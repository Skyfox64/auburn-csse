#include <sys/socket.h>
#include <netinet/in.h>
#include <arpa/inet.h>
#include <string.h>
#include <stdio.h>
#include <iostream>
#include <fstream>
#include <boost/lexical_cast.hpp>
#include "packet.h"


#define USAGE "Usage:\r\nc [tux machine number] [probability of packet corruption in int form] [probability of packet loss in int form]\r\n"
#define BUFSIZE 121
#define FILENAME "Testfile"
#define TEST_FILENAME "Testfile2"

using namespace std;
bool gremlin(Packet * pack, int corruptProb, int lossProb, int seqNum);

int main(int argc, char** argv){
	
	int sock = 0;
	unsigned char buffer[BUFSIZE];
	bool seqNum;
	
	//Checks that the proper number of arguments were input
	if(argc != 4){
		cout << USAGE << endl;
		return 1;
	}

	//Creation of variables for the probability of corruption/dropping
	char * probCorruptStr = argv[2];
	int probCorrupt = boost::lexical_cast<int>(probCorruptStr);
	char * probLossStr = argv[3];
	int probLoss = boost::lexical_cast<int>(probLossStr);

	//setting the IP and socket address values
	string targetIP = string("131.204.14.") + argv[1];
	short int port = 10038; /* Can be any port within 10038-10041, inclusive. */
	
	char * file;
	int fileLength;
	ifstream inputStream (FILENAME, ifstream::binary);
	
	if(inputStream) {
		inputStream.seekg(0, inputStream.end);
		fileLength = inputStream.tellg();
		inputStream.seekg(0, inputStream.beg);

		file = new char[fileLength];

		cout << "Reading " << fileLength << " characters..." << endl;
		inputStream.read(file, fileLength);

		if(!inputStream) cout << "File reading failed." << endl;
		inputStream.close();
	}
	
	//Not sure if I could put the following section into its own method. Handles socket binding
	struct sockaddr_in a;
	struct sockaddr_in sa;
	socklen_t salen = sizeof(sa);
	struct hostent *h;//could possibly be removed. Does not appear to be being used?

	if ((sock = socket(AF_INET, SOCK_DGRAM, IPPROTO_UDP)) < 0) {
		cout << "Socket creation failed. (Socket socket)" << endl;
		return 0;
	}

	memset((char *)&a, 0, sizeof(a));
	a.sin_family = AF_INET;
	a.sin_addr.s_addr = htonl(INADDR_ANY); //why does this always give us 0? 
	a.sin_port = htons(0);

	if (bind(sock, (struct sockaddr *)&a, sizeof(a)) < 0){
		cout << "Socket binding failed. (Socket socket, address a)" << endl;
		return 0;
	}

	memset((char *)&sa, 0, sizeof(sa));
	sa.sin_family = AF_INET;
	sa.sin_port = htons(port);
	inet_pton(AF_INET, targetIP.c_str(), &(sa.sin_addr));
	
	//End socket binding section
	
	cout << endl;

	cout << "Server address (inet mode): " << inet_ntoa(sa.sin_addr) << endl;
	cout << "Port: " << ntohs(sa.sin_port) << endl;

	cout << endl << endl;

	string fileStr = string(file);

	cout << "File: " << endl << fileStr << endl << endl;
	
	seqNum = true;
	bool dropPacket = false;
	
	
	for(int x = 0; x <= fileLength / BUFSIZE; x++){
		cout << "\n===SENDING PACKET===" << endl;
		string messageStr = fileStr.substr(x * BUFSIZE, BUFSIZE); //Creates the string we'll be sending
		if(x * BUFSIZE + BUFSIZE > fileLength){//Checks to see if we're at the end of the text
			messageStr[fileLength - (x * BUFSIZE)] = '\0';
		}
		Packet pckt(seqNum, messageStr.c_str());//Initialization of the packet
		
		dropPacket = gremlin(&pckt, probCorrupt, probLoss, seqNum);
		
		if(dropPacket == false){//Checks if the packet will be dropped
			if(sendto(sock, pckt.str(), BUFSIZE + 7, 0, (struct sockaddr *)&sa, sizeof(sa)) < 0) {//Tries to send the packet
				cout << "Packet sending failed. (socket socket, server address sa, message m)" << endl;
				return 0;
			}
		}
		cout << "WAITING FOR RESPONSE" << endl;
		if(recvfrom(sock, buffer, BUFSIZE + 7, 0, (struct sockaddr *)&sa, &salen)<0){
			cout << "Timeout: Packet was dropped!" << endl;
			x--;
		} else if (buffer[6] == '0'){
			cout << "Packet is good!" << endl;
		} else {
			cout << "There was a problem with the packet!" << endl;
//			x--;
		}
		
	}
	
	
	
	
	
	
}


bool gremlin(Packet * pack, int corruptProb, int lossProb, int seqNum){
	bool dropPacket = false;
	int r = rand() % 100;

	if(r <= (lossProb)){
		dropPacket = true;
		cout << "Packet dropped!" << endl;
	}  
	else if(r <= (corruptProb)){
		cout << "Packet corrupted!" << endl;
		pack->loadDataBuffer((char*)"abcdefghijklmnopqrstuv");
	}
	else seqNum = (seqNum) ? false : true; 
	cout << "Seq. num: " << pack->getSequenceNum() << endl;
	cout << "Checksum: " << pack->getCheckSum() << endl;
	cout << "Message: "  << pack->getDataBuffer() << endl;

	return dropPacket;
}




