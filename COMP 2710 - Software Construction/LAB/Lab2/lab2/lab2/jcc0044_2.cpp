/*
Program:	Lab 2
Name:		John Carroll
UserID:		jcc0044
StudentID#:	902521946
Class:		COMP 2710
Date:		October 22nd, 2014
E-Mail:     jcc0044@tigermail.auburn.edu

Description: This is a message sharing application called Auburn Messaging System. 
	It has a text-based user interface that allows multiple users to share messages 
	through one of the three methods: (1) broadcast a message to all users, (2) multicast a 
	message to a group, or (3) unicast a message to a particular user. A user may display 
	their homepage, all multicast messages to each group where the user is a member of, all broadcast
	messages, and all unicast messages to the user. This program allows a user to display in
	their messageObject page all messages posted by the user.
Compile Instructions:
1)	Change current directory to correct directory which contains the .cpp using command: “cd”
2)	To compile:
	a.	type "g++ hw1.cpp -o hw1" in a terminal window to create hw1 executable file;
		re-executing this will update the hw1 file
		______________________________________________________________________

		*NOTE* Assuming you are invoking g++ from the command line (terminal):
		"$ g++ -std=c++11 your_file.cpp -o your_program"
							or
		"$ g++ -std=c++0x your_file.cpp -o your_program"
		______________________________________________________________________

	b.	type "g++ hw1.cpp" to create and update the a.out with the latest code
	c.	type "./a.out" or “./hw1” to run the program
*/

#include <iostream>
#include <fstream>
#include <sstream>
#include <string>
#include <vector>
#include <cstring>
#include <cstdlib>
#include <vector>
#include <algorithm>
#include <limits>
#include <iterator>
#include <time.h> 

using namespace std;

//Class: Menu
//Description: This class handles the ouptut of any user menuClasss.
class Menu
{
public:
   string current_User;
   void runProgram();
   void sleep(float);
   void welcome(bool);
   void enterOption();
   void systemMenuSwitch(char);
   void quit();
};

//Class: Group
//Description: This class handles the ouptut of any user Group objects.
class Group
{
public:
   void joinGroup(string);
   void createGroup();
};

//Class: Message
//Description: This class handles the ouptut of any user Message objects.
class Message
{
public:
   void broadcastMessage(string);
   void multicastMessage(string);
   void unicastMessage(string);
   void displayWall(string);
   void displayHome(string);
   void createTimeStamp();
   int timeStamp();
   int getTime();
};


//Function: main
//Description: This the driver function for the program. Is calls the run function.
int main()
{
   Menu system;
   system.runProgram();
}

//Function: run
//Description: This is the function that prints out the menu for the user and then calls the appropriate functions.
void Menu::runProgram()
{
   Menu menuObject; //Save current_User and call functions from menu class
   Message msgObj;
		
   string welcome, users, option2, filename, entry, everythingElse;
   bool found = false;
   bool setUser = false;
   char firstLetter;

   ofstream outfile;
   ifstream infile;
   
   cout << "===========================================================\n";
   cout << "|             Distributed Message System!                  |\n";
   cout << "===========================================================\n\n";
   do{
	   cout << "        Please enter user name: ";
	   getline(cin, entry);
	   if (entry.size() > 0)
	   {
			firstLetter = entry.at(0);
			if (firstLetter != ' ')
			{
				menuObject.current_User = entry;
				setUser = true;
			}
			else
			{
				cout << "\nInvalid user name\n" << endl;
			}			
	   }
	   else
	   {
		   cout << "\nInvalid user name\n" << endl;
	   }

   } while (!setUser);

	// checks to see if users.txt exists.
   ifstream my_file("Users.txt");
   if (my_file.good())
   {   
   //Opens "Users.txt" if it is already created.
	  filename = "Users.txt";
	  infile.open(filename.c_str());   
   // Checks to see if user is already in the file.
	  while (infile >> users)
	  {
		 if (users == menuObject.current_User)
		 {
			found = true;
		 }
	  }   
   //if user is not already in file
	  if (found == false)
	  {
	  //opens file for appending and adds user to file.
		 outfile.open("Users.txt", ios::app);
		 outfile << menuObject.current_User + "\n";
		 outfile.flush();
		 outfile.close();	  
	   //Create <username>.txt, <username>'s_from.txt, and <username>'s_groups.txt
		 filename = menuObject.current_User + ".txt";
		 outfile.open(filename.c_str());
		 outfile.flush();
		 outfile.close();	  
		 filename = menuObject.current_User + "'s_from.txt";
		 outfile.open(filename.c_str());
		 outfile.flush();
		 outfile.close();	  
		 filename = menuObject.current_User + "'s_groups.txt";
		 outfile.open(filename.c_str());
		 outfile.flush();
		 outfile.close();	  
		 menuObject.welcome(true);
	  }
	  else if (found == true)
	  {
		 menuObject.welcome(false);
	  }
   }
   //Makes a users.txt
   else
   {
   //Create users.txt for first time
	  filename = "Users.txt";
	  outfile.open(filename.c_str());
	  outfile << menuObject.current_User + "\n";
	  outfile.flush();
	  outfile.close();
   //Create <username>.txt, <username>'s_from.txt, and <username>'s_groups.txt
	  filename = menuObject.current_User + ".txt";
	  outfile.open(filename.c_str());
	  outfile.flush();
	  outfile.close();   
	  filename = menuObject.current_User + "'s_from.txt";
	  outfile.open(filename.c_str());
	  outfile.flush();
	  outfile.close();   
	  filename = menuObject.current_User + "'s_groups.txt";
	  outfile.open(filename.c_str());
	  outfile.flush();
	  outfile.close();	  
	  menuObject.welcome(true); //Firstlogin = true
   }
   msgObj.createTimeStamp();
   menuObject.enterOption();
}

void Menu::quit()
{
   cout << "\n        ========================================================\n";
   cout << "        | Thank you for using the Distributed Messaging System |\n";
   cout << "        ========================================================\n" <<endl;
   sleep(5);
}

void Menu::sleep(float s)
{
	//Delays the closing of the window to allow the user to read the goodbye message. 
   time_t start_time, current_time;
   time(&start_time);
   do
   {
	  time(&current_time);
   } while ((current_time - start_time) < s);

}

void Menu::welcome(bool firstLogin)
{
   if (firstLogin == true)
   {
	  cout << "\n===========================================================" << endl;
	  cout << "|   Welcome to the Distributed Messaging System, " + current_User << endl;
	  cout << "===========================================================\n" << endl;
   }
   
   // welcome back if previous user
   else if (firstLogin == false) {
	  cout << "\n===========================================================" << endl;
	  cout << "|  Welcome back to the Distributed Messaging System, " + current_User << endl;
	  cout << "===========================================================\n" << endl;
   }
}

void Menu::enterOption()
{
   char option;
   string everythingElse;
   do
   {
	  cout << "Broadcast (b), Multicast (m), Unicast (u), Wall (w), Home (h), Create group (g), Join Group (j), Quit (q)" << endl;
	  cout << "Enter option: ";
	  cin >> option;
	  getline(cin, everythingElse);
	  if (everythingElse.length())
	  {
		 option = 'a';
	  }
	  systemMenuSwitch(option);
   } while (option != 'q');
}
void Menu::systemMenuSwitch(char choiceIn)
{
   Message messageObject;
   Group groupObject;
   
   switch (choiceIn)
   {
	  case 'b':
		 messageObject.broadcastMessage(current_User);
		 break;
	  case 'm':
		 messageObject.multicastMessage(current_User);
		 break;
	  case 'u':
		 messageObject.unicastMessage(current_User);
		 break;
	  case 'w':
		 messageObject.displayWall(current_User);
		 break;
	  case 'h':
		 messageObject.displayHome(current_User);
		 break;
	  case 'g':
		 groupObject.createGroup();
		 break;
	  case 'j':
		 groupObject.joinGroup(current_User);
		 break;
	  case 'q':
		 quit();
		 break;
	  default:
		 cerr << "\nInvalid menu option.\n" << endl;
		 break;
   }
}
void Group::createGroup()
{
   string groupIn, groupFileName;
   ofstream outfile;
   ifstream infile;
   bool reprompt = true;
   do
   {
	  cout << "Please enter the group name: ";
	  cin >> groupIn;   
	  groupFileName = groupIn + ".txt";
	  ifstream my_file(groupFileName.c_str());
   //Check if the group entered in is NOT already a group
	  if (my_file.good())
	  {
	  //Group already exists
		 cout << endl;
		 cout << "\nGroup aleady exists.\n" << endl;	  
	  }
	  else
	  {
		 reprompt = false; //reprompt to enter	  
	  //add entered in group to all groups
		 outfile.open(groupFileName.c_str());
		 outfile.flush();
		 outfile.close();	  
		 cout << "\n===========================================================" << endl;
		 cout << "|              New group " + groupIn + " created!          " << endl;
		 cout << "===========================================================\n" << endl;	  
		 break;
	  }
   } while (reprompt == true);
}


void Group::joinGroup(string currentUser)
{
   string groupIn, groupFileName, msgs;
   string userGroupFile = currentUser + "'s_groups.txt";
   ofstream outfile;
   ifstream infile, readFile;
   bool inGroup = false;
   cout << "Please enter the group name: ";
   cin >> groupIn;
   groupFileName = groupIn + ".txt";
   ifstream my_file(groupFileName.c_str());
	//Check if the group exists
   if (my_file.good())
   {
	  ifstream my_file2(userGroupFile.c_str());
   //Check if the <currentUser>'s groups.txt exists
	  if (my_file2.good())
	  {	  
	  //Then check if the group is one the user is in.
		 infile.open(userGroupFile.c_str());
		 while (infile >> msgs)
		 {
			if (msgs.find(groupIn) != string::npos)
			{
			   cout << "\nYou are already in this group.\n" << endl;
			   inGroup = true;
			}
		 }	  
		 if (!inGroup)
		 {
			outfile.open(userGroupFile.c_str(), ios::app);
			outfile << groupIn + "\n";
			outfile.flush();
			outfile.close();		 
			cout << endl << "\n===========================================================" << endl;
			cout << "|          " + currentUser + " has joined group " + groupIn + "        ";
			cout << endl << "===========================================================\n" << endl;
		 }
	  }
	  cout << endl;   
   }
   else
   {   
	  cout << endl;
	  cout << "\nGroup does not exist.\n" << endl << endl;   
   }
}
//Function: displayWall
//Description: This function dislays the messageObject page of the current user. 
//             First it displays the last three message and then more
//             if the user selects to display more messages.
void Message::displayWall(string currentUser)
{
   string output, target, timeString, receiver, message, moreMessages, fileMessages;

   bool alreadyChecked = false;
   bool alreadyDisplayed = false;
   bool success = false;

   int currentTime;
   int messageCounter = 0;
   int max_Time = getTime();
   int timeCheck = max_Time;
	// Print header
   cout << "\n===========================================================" << endl;
   cout << "|              " + currentUser + "'s Wall Page            " << endl;
   cout << "===========================================================\n" << endl;

   while (timeCheck > -1)
   {
	  alreadyDisplayed = false;
   
	  string userFrom = currentUser + "'s_from.txt";
	  ifstream my_file(userFrom.c_str());
	  if (my_file.good())
	  {
		//Save contents of file fileMessages
		 stringstream messagesTemp;
		 messagesTemp << my_file.rdbuf();
		 string fileMessagesTemp(messagesTemp.str());
		 fileMessages += fileMessagesTemp;
	  }
   
	  while (fileMessages.size() > 0) {
		 alreadyDisplayed = false;
		 string output = "";
	  
		// get time 
		 fileMessages = fileMessages.substr(fileMessages.find("[(") + 2);
		 timeString = fileMessages.substr(0, fileMessages.find(")]"));
		 stringstream convert(timeString);
		 convert >> currentTime;
	  
		// get receiver
		 fileMessages = fileMessages.substr(fileMessages.find("|<") + 2);
		 receiver = fileMessages.substr(0, fileMessages.find(">|"));
	  
		// create output
		 output += currentUser;
		 output += "(" + receiver + ")>>\n";
	  
		// get message, create output
		 fileMessages = fileMessages.substr(fileMessages.find(">|") + 2);
		 message = fileMessages.substr(0, fileMessages.find("[("));
		 output += message;
	  
		// shrink fileMessages
		 fileMessages = fileMessages.substr(message.size());
	  
		// If current message is to the current user, print.
		 if (currentTime == timeCheck && !alreadyDisplayed) {
		 // Prompt for more messages after two.
			messageCounter++;
			if (messageCounter == 3 && fileMessages.size() > 0 && !alreadyChecked) {
			   alreadyChecked = true;
			   cout << "More messages? (yes/no): ";
			   cin >> moreMessages;
			   cout << "\n";
			   if (moreMessages == "no") {
				  break;
			   }
			}
			cout << output << endl;
			alreadyDisplayed = true; 
			timeCheck--;
			success = true;
		 }							
	  }
	// if there is no more messages to check, break.
	  if (timeCheck < 0) {
		 break;
	  }
	  if (success) {
		 success = false;
	  }
	  else {
		 timeCheck--; //Added but not sure==============================================<
	  }		
   }
   cout << "\n===========================================================" << endl;
   cout << "|           End of " + currentUser + "'s Wall Page      " << endl;
   cout << "===========================================================\n" << endl;
}

//Function: displayHome
//Description: This function displays the home page of the user.
//             The last three messages of the user and his group 
//             will be displayed. If the user selects for more 
//             message to be displayed then the program will display 
//             the rest of the messages.
void Message::displayHome(string currentUser)
{
	// variables
   string output, target, timeString, receiver, message, moreMessages;
   string currentFileName, fileMessages, username, groupIn, groupFileName;

   bool alreadyChecked = false;
   bool alreadyDisplayed = false;
   bool success = false;

   int currentTime;
   int filesRead = 0;
   int messageCounter = 0;
   int max_Time = getTime();
   int timeCheck = max_Time;

	// Print header
   cout << "\n===========================================================" << endl;
   cout << "|                  " + currentUser + "'s Home Page            " << endl;
   cout << "===========================================================\n" << endl;
   while (timeCheck > -1)
   {
	  alreadyDisplayed = false;	
   
	//Acquire messages from various files   
	//Begin with unicasted messages
	//Save contents of <currentuser>.txt into fileMessages
	  string userFile = currentUser + ".txt";
	  ifstream my_file(userFile.c_str());
	  if (my_file.good())
	  {
		 string fileMsgsPt1temp, fileMsgsPt1temptemp;
		 stringstream messagesTemp;
		 messagesTemp << my_file.rdbuf();
		 string fileMessagesTemp(messagesTemp.str());
		 fileMessages += fileMessagesTemp;

/*		 fileMsgsPt1temp += fileMessagesTemp;	  
		 string fileMessagesTemp2 = fileMsgsPt1temp;
		 while (fileMessagesTemp2.size() > 0) {
			fileMessagesTemp2 = fileMessagesTemp2.substr(fileMessagesTemp2.find("[("));
			string frontPart = fileMessagesTemp2.substr(0, fileMessagesTemp2.find(">|"));
			fileMessagesTemp2 = fileMessagesTemp2.substr(fileMessagesTemp2.find(">|"));
			message = fileMessagesTemp2.substr(0, fileMessagesTemp2.find("[("));
			if (fileMessagesTemp2.find("[(") != std::string::npos)
			{
			   fileMessagesTemp2 = fileMessagesTemp2.substr(fileMessagesTemp2.find("[("));
			   fileMsgsPt1temptemp += frontPart + "::" + currentUser + message;
			}
			else if (!fileMessagesTemp2.find("[(") != std::string::npos)
			{
			   fileMsgsPt1temptemp += frontPart + "::" + currentUser + message;
			   fileMessagesTemp2 = fileMessagesTemp2.substr(message.size());
			   fileMsgsPt1 = fileMsgsPt1temptemp;
			}
		 }		*/	
	  }
   
	//Broadcasted messages
	//Save contents of All.txt into fileMessages
	  string allGroupFile = "All.txt";
	  ifstream my_file2(allGroupFile.c_str());
	  if (my_file2.good())
	  {
		 string fileMsgsPt2temp, fileMsgsPt2temptemp;
		 stringstream messagesTemp;
		 messagesTemp << my_file2.rdbuf();
		 string fileMessagesTemp(messagesTemp.str());
		 fileMessages += fileMessagesTemp;
	  }
   
	//Multicasted messages
	//Save contents of user's <group>.txt(s) into fileMessages
	  string userGroupsFile = currentUser + "'s_groups.txt";
	  ifstream my_file3(userGroupsFile.c_str());
	  if (my_file3.good())
	  {
		//Then check if the group is one the user is in.
		 string fileMsgsPt3temp, fileMsgsPt3temptemp;
		 ifstream infile;
		 infile.open(userGroupsFile.c_str());
		 while (infile >> groupIn)
		 {
			string groupFileName = groupIn + ".txt";				
			ifstream my_file4(groupFileName.c_str());
			if (my_file4.good())
			{
			   stringstream messagesTemp;
			   messagesTemp << my_file4.rdbuf();
			   string fileMessagesTemp(messagesTemp.str());
			   fileMessages += fileMessagesTemp;
			}				
		 }
	  }
	
	  while (fileMessages.size() > 0) {
		 alreadyDisplayed = false;
	  
		// get time
		 fileMessages = fileMessages.substr(fileMessages.find("[(") + 2);
		 timeString = fileMessages.substr(0, fileMessages.find(")]"));
		 stringstream convert(timeString);
		 convert >> currentTime;
	  
		// get username
		 fileMessages = fileMessages.substr(fileMessages.find("|<") + 2);
		 username = fileMessages.substr(0, fileMessages.find("::"));
	  
		//get current file name
		 fileMessages = fileMessages.substr(fileMessages.find("::") + 2);
		 currentFileName = fileMessages.substr(0, fileMessages.find(">|"));
	  
		// create output
		 string outputBeginning = username;
		 string outputReceiver = "(" + currentFileName + ")";
		 string outputEnd =	">>\n";
		 string output = "";
	  
		// get message, create output
		 fileMessages = fileMessages.substr(fileMessages.find(">|") + 2);
		 message = fileMessages.substr(0, fileMessages.find("[("));
		 output += message;
	  
		// shrink fileMessages
		 fileMessages = fileMessages.substr(message.size());
	  
		// If current message is to the current user, print.
		 if (currentFileName == currentUser && currentTime == timeCheck && !alreadyDisplayed) {
			messageCounter++;
			// Prompt for more messages after two.
			if (messageCounter == 3 && fileMessages.size() > 0 && !alreadyChecked) {
			   alreadyChecked = true;
			   cout << "More messages? (yes/no): ";
			   cin >> moreMessages;
			   cout << "\n";
			   if (moreMessages == "no") {
				  break;
			   }
			}
			alreadyDisplayed = true;
			cout << outputBeginning << outputEnd << output << endl;
			timeCheck--;
			success = true;
		 }
		//If message is to a group/All, print like this
		 if (currentFileName != currentUser && currentTime == timeCheck) {
			messageCounter++;
			// Prompt for more messages after two.
			if (messageCounter == 3 && fileMessages.size() > 0 && !alreadyChecked) {
			   alreadyChecked = true;
			   cout << "More messages? (yes/no): ";
			   cin >> moreMessages;
			   cout << "\n";
			   if (moreMessages == "no") {
				  break;
			   }
			}
			alreadyDisplayed = true;
			cout << outputBeginning << outputReceiver << outputEnd << output << endl;
			timeCheck--;
			success = true;
		 }
	  }
	// if there is no more messages to check, break.
	  if (timeCheck < 0) {
		 break;
	  }
	  if (success) {
		 success = false;
	  }
	  else {
		 timeCheck--; //Added but not sure==============================================<
	  }
   }
   cout << "\n===========================================================" << endl;
   cout << "|           End of " + currentUser + "'s Home Page      " << endl;
   cout << "===========================================================\n" << endl;
}

////Function: broadcastMessage
////Description: This function adds the user and  his message to the message_buffer.
void Message::broadcastMessage(string currentUser)
{
   string message_buffer, message, newMessage, filename, msgs, msgs_temp, fromBuffer, fromTemp, froms;
   ofstream outfile;
   ifstream infile, infile2, readFile;
   string userFromFile = currentUser + "'s_from.txt";
   Message msgObj;

   cout << "Enter message: ";
   newMessage = "";
	//Checks to make sure message does not end the end of the message symbol $$
   while (message != "$$")
   {
	  getline(cin, message);
   // If message = $$ then the user is through inputting and the if ststement will not execut
	  if (message != "$$")
	  {
	  // If the message string is empty then it will not add anything to the message_buffer.
		 if (message != "")
		 {
			newMessage += message + "\n";
		 }
	  }
   }
   cout << endl << "\n===========================================================" << endl;
   cout << "|          " + currentUser + " has broadcasted a new message      ";
   cout << endl << "===========================================================\n" << endl;
   
   stringstream ssTime;
   ssTime << msgObj.timeStamp();
   string time = ssTime.str();
 
	//Adds the user and message to the message_buffer to the message_buffer string in reverse chronological order.
   message_buffer = "[(" + time + ")]|<" + currentUser + "::All>|" + newMessage;
   fromBuffer = "[(" + time + ")]|<All>|" + newMessage;
   message = "";
   newMessage = "";

	  //Save the messsage into all.txt
   ifstream my_file("All.txt");
   if (my_file.good())
   { 
	  message_buffer += msgs_temp;   
	  filename = "All.txt";
	  outfile.open(filename.c_str(), ios::app);   
	  outfile << message_buffer;
	  outfile.flush();
	  outfile.close();
   }   
   else
   {
	  message_buffer += msgs_temp;
   
	  filename = "All.txt";
	  outfile.open(filename.c_str(), ios::app);   
	  outfile << message_buffer;
	  outfile.flush();
	  outfile.close();
   }
//Also save the message into username's from messages.txt
   ifstream my_file2(userFromFile.c_str());
   if (my_file2.good())
   {
	  outfile.open(userFromFile.c_str(), ios::app);
	  outfile << fromBuffer;
	  outfile.flush();
	  outfile.close();
   }   
   else
   {
	  outfile.open(userFromFile.c_str(), ios::app);
	  outfile << fromBuffer;
	  outfile.flush();
	  outfile.close();
   }
}

void Message::multicastMessage(string currentUser)
{
   string message_buffer, message, newMessage, filename, msgs, msgs_temp, fromBuffer, message_temp, groupIn, groupFileName;
   ofstream outfile;
   ifstream infile, infile2, readFile;
   string userFromFile = currentUser + "'s_from.txt";
   std::string time;
   Message msgObj;

   cout << "Enter the group name: ";
   cin >> groupIn;

   groupFileName = groupIn + ".txt";
   ifstream my_file(groupFileName.c_str());

	//If the group.txt exists
   if (my_file.good())
   {
	  cout << "Enter message: ";
	  newMessage = "";
   //Checks to make sure message does not end the end of the message symbol $$
	  while (message != "$$")
	  {
		 getline(cin, message);
	  // If message = $$ then the user is through inputting and the if ststement will not execut
		 if (message != "$$")
		 {
		 // If the message string is empty then it will not add anything to the message_buffer.
			if (message != "")
			{
			   newMessage += message + "\n";
			}
		 }
	  }
	  cout << endl << "\n===========================================================" << endl;
	  cout << "|    " + currentUser + " has multicasted a message to group " + groupIn + "    |";
	  cout << endl << "===========================================================\n" << endl;
   
	  stringstream ssTime;
	  ssTime << msgObj.timeStamp();
	  string time = ssTime.str();
			//Adds the user and message to the message_buffer to the message_buffer string in reverse chronological order.
	  message_buffer = "[(" + time + ")]|<" + currentUser + "::" + groupIn + ">|" + newMessage;
	  //message_buffer = "[(" + time + ")]|<" + currentUser + ">|" + newMessage;
	  fromBuffer = "[(" + time + ")]|<" + groupIn + ">|" + newMessage;
	  message = "";
	  newMessage = "";   
	  my_file.close();	  
	  outfile.open(groupFileName.c_str(), ios::app);   
	  outfile << message_buffer;
	  outfile.flush();
	  outfile.close();
   
   //add to currentUser's from.txt
	  ifstream my_file2(userFromFile.c_str());
	  if (my_file2.good())
	  {
		 my_file2.close();
		 filename = userFromFile;
	   
		 outfile.open(filename.c_str(), ios::app);	  
		 outfile << fromBuffer;
		 outfile.flush();
		 outfile.close();
	  }
	  else
	  {
		 filename = userFromFile;
	  
		 outfile.open(filename.c_str(), ios::app);	  
		 outfile << message_buffer;
		 outfile.flush();
		 outfile.close();
	  }   
   }
   //If it does not exist
   else
   {
	  cout << endl;
	  cout<< "\nGroup does not exist.\n";
   }
}

void Message::unicastMessage(string currentUser)
{
   string message_buffer, message, newMessage, filename, msgs, msgs_temp, fromBuffer, message_temp, target, targetFileName;
   ofstream outfile;
   ifstream infile, infile2, readFile;
   string userFromFile = currentUser + "'s_from.txt";
   std::string time;
   Message msgObj;

   cout << "Enter the recipient user name: ";
   cin >> target;
   targetFileName = target + ".txt";
   ifstream my_file(targetFileName.c_str());
	//If the username.txt exists
   if (my_file.good())
   {
	  cout << "Enter message: ";
	  newMessage = "";
   //Checks to make sure message does not end the end of the message symbol $$
	  while (message != "$$")
	  {
		 getline(cin, message);
	  // If message = $$ then the user is through inputting and the if ststement will not execut
		 if (message != "$$")
		 {
		 // If the message string is empty then it will not add anything to the message_buffer.
			if (message != "")
			{
			   newMessage += message + "\n";
			}
		 }
	  }
	  cout << endl << "\n===========================================================" << endl;
	  cout << "|    " + currentUser + " has unicasted a message to " + target + "    |";
	  cout << endl << "===========================================================\n" << endl;
   
	  stringstream ssTime;
	  ssTime << msgObj.timeStamp();
	  string time = ssTime.str();
	 
   //Adds the user and message to the message_buffer to the message_buffer string in reverse chronological order.
	  message_buffer = "[(" + time + ")]|<" + currentUser + "::" + target + ">|" + newMessage;
	  //message_buffer = "[(" + time + ")]|<" + currentUser + ">|" + newMessage;
	  fromBuffer = "[(" + time + ")]|<" + target + ">|" + newMessage;
	  message = "";
	  newMessage = "";
   
   //Save msg in recipient <username>.txt
   
	  outfile.open(targetFileName.c_str(), ios::app);   
	  outfile << message_buffer;
	  outfile.flush();
	  outfile.close();
   
   //add to currentUser's from.txt
	  ifstream my_file2(userFromFile.c_str());
	  if (my_file2.good())
	  {
		 my_file2.close();
		 filename = userFromFile;
	  
		 outfile.open(filename.c_str(), ios::app);	  
		 outfile << fromBuffer;
		 outfile.flush();
		 outfile.close();
	  }
	  else
	  {
		 filename = userFromFile;
	   
		 outfile.open(filename.c_str(), ios::app);	  
		 outfile << message_buffer;
		 outfile.flush();
		 outfile.close();
	  }   
   }
   //If it does not exist
   else
   {
	  cout << endl;
	  cout<< "\nUser does not exist.\n";
   }
}
void Message::createTimeStamp()
{
   string filename;
   ifstream infile;
   ofstream outfile;
   int time;
	//Checks to see if a time file has been created and 
	//opens it for reading if it has already been created.
   ifstream my_file("Time.txt");
   if (my_file.good())
   {
	//do Nothing
   }
   else
   {
	//Sets the initial time stamp to -1	
	  time = -1;
	//Creates a time file for writing.
	  filename = "Time.txt";
	  outfile.open(filename.c_str());
	//Writes the time to the time file.
	  outfile << time;
	  outfile.flush();
	  outfile.close();
   }
	//return time;
}
int Message::timeStamp()
{
   string filename;
   ifstream infile;
   ofstream outfile;
   int time;
	//Checks to see if a time file has been created and 
	//opens it for reading if it has already been created.
   ifstream my_file("Time.txt");
   if (my_file.good())
   {
	  my_file.close();
	  filename = "Time.txt";
	  infile.open(filename.c_str());   
   //Reads the number in the file and stores it in a int.
	  infile >> time;   
	  time++;
	  infile.close();   
   //Opens the time file for writing.
	  filename = "Time.txt";
	  outfile.open(filename.c_str());   
   //Writes the new time to the file.
	  outfile << time;
	  outfile.flush();
	  outfile.close();
   }
   
   //If the time file does not already exist creates one.
   else
   {	//Sets the initial time stamp to 0	
	  time = -1;   
   //Creates a time file for writing.
	  filename = "Time.txt";
	  outfile.open(filename.c_str());   
   //Writes the time to the time file.
	  outfile << time;
	  outfile.flush();
	  outfile.close();
   }
   return time;
}
int Message::getTime()
{
   string filename;
   ifstream infile;
   ofstream outfile;
   int time;
	//Checks to see if a time file has been created and 
	//opens it for reading if it has already been created.6
   ifstream my_file("Time.txt");
   if (my_file.good())
   {
	  my_file.close();
	  filename = "Time.txt";
	  infile.open(filename.c_str());
   
   //Reads the number in the file and stores it in a int.
	  infile >> time;   
   }
   else
   {
	  time = -1;
	  cout << "\nError: Oops! No Time.txt!\n";
   }
   return time;
}