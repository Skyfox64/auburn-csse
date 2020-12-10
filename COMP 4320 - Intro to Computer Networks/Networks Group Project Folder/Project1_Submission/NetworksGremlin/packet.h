#ifndef PACKET_H
#define PACKET_H
#include <stdio.h>
#include <string.h>
#include <iostream>

#define SEQUENCE_SIZE 	1
#define CHECKSUM_SIZE	6
#define BODY_SIZE		249
#define PACKET_SIZE 	256

class Packet{

	//Private variables
	private:
		int sequenceNum;
	    int checkSum;
    	int ackNack;
    	char dataBuff[BODY_SIZE];
    	char packet[PACKET_SIZE];
    	std::string tempStr;
    	std::string packetString;

	//Public functions and variables
	public:
		//Constructor
	    Packet(int sn, const char db[BODY_SIZE]);
	    Packet();
	    
	    //Setters
	    void setSequenceNum(int sequenceNumIn);
	    void setCheckSum(int checkSumIn);
	    void setAckNack(int ackNackIn);

	    //Getters
	    int getSequenceNum();
	    int getCheckSum();
	    int getAckNack();

	    //Functions
	    int generateCheckSum();
	    void loadDataBuffer(char* data);
	    char* getDataBuffer();
	    char* str();
	};
#endif