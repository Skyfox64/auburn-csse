// Program 0:              Lab 1
// Name:                   Robinson Davis
// Class:                  COMP 2710 Section 002
// E-Mail:                 rad0017@auburn.edu
//
// Description:           This program will support a full message board
//                        for users to create and join groups, post messages
//                        in those groups, direct message other users, and 
//                        broadcast a message to all users. It will also
//                        provide basic output to display the user's wall
//                        and home page.

#include <iostream>
#include <string>
#include <map>
#include <vector>
#include <algorithm>
#include <limits>
#include <iterator>

using namespace std;

/******Class Declarations******/

// Class: User
// Description: Class to maintain data about users and
//              and groups, as well as functions to 
class User {
   public:
   map<string, vector<string> > usersWithGroups;
   string currentUser;
   
   void newUser();
   void newGroup();
   void switchUser();
   void joinGroup();
   bool existingUser(string);
   bool existingGroup(string);
   };

// Class: MessageBuffer
// Description: Class to maintain message buffer string and
//              functions to copy add to the message buffer.
class MessageBuffer: public User {
public:
   string message_buffer;

   string copyBuffer();
   void add(string, string, string);
   void broadcastMessage();
   void multicastMessage();
   void unicastMessage();
   void displayWall();
   void displayHome();
};

// Class: System
// Description: 
class System {
 public:
   string currentUser;
   
   int getChoice();
   void displayMenu();
   void run();
};

/******Main Function Declaration******/

// Function: Main
// Description: Used to instantiate a system object 
//              to run the program.

int main() {
   System runProgram;
   runProgram.run();
}

/******User Function Declarations******/

// Function: newUser
// Description: 
void User::newUser() {
   string username;
   bool done = false;
   while (!done) {
      cout << "\nPlease enter a username: ";
      cin >> username;
      if (existingUser(username)) {
         cout << "\nError, username already exists." << endl;
      }
      else {
         done = true;
      }
   }
   usersWithGroups["All"].push_back(username);
   cout << "\nUser successfuly created.\n" << endl;;
   currentUser = username;
   cout << "===========================================================\n";
   cout << "|    Welcome to the Auburn Messaging System, " + username + "!     |" << endl;
   cout << "===========================================================\n" << endl;
   return;
}

// Function: newGroup
// Description:
void User::newGroup() {
   string group;
   bool done = false;
   while (!done) {
      cout << "\nPlease enter group name: ";
      cin >> group;
      if (existingGroup(group)) {
         cout << "\nError, group already exists." << endl;
      }
      else {
         done = true;
      }
   }
   usersWithGroups[group];
   cout << "\nGroup has been sucessfully created.\n";
}

// Function: switchUser
// Description: 
void User::switchUser() {
   string usernameIn;
   bool validUser = false;
   while (!validUser) {
      cout << "\nEnter user's name: ";
      cin >> usernameIn;
      if (existingUser(usernameIn)) {
         currentUser = usernameIn;
         cout << "\n===========================================================" << endl;
         cout << "|  Welcome back to the Auburn Messaging System, " + usernameIn + "!   |" << endl;
         cout << "===========================================================" << endl;
         validUser = true;
      }
   }
}

// Function: joinGroup
// Description:
void User::joinGroup() {
   string group;
   bool done = false;
   while (done == false) {
      cout << "\nPlease enter a group: ";
      cin >> group;
      
      if (usersWithGroups.count(group)== 0) {
         cout << "\nError, group does not exist." << endl;
         continue;
      }
      
      else if (find(usersWithGroups[group].begin(), usersWithGroups[group].end(), currentUser) != usersWithGroups[group].end()) {
         cout << "\nError, user is already a member of this group" << endl;
         return;
      }
      else {
         done = true;
      }
   }
   usersWithGroups[group].push_back(currentUser);
   cout << "\nUser successfully added." << endl;
}

// Function: existingUser
// Description: 
bool User::existingUser(string username) {
   bool userExists = false;
   if (find(usersWithGroups["All"].begin(), usersWithGroups["All"].end(), username) != usersWithGroups["All"].end()) {
      return true;
   }
   return false;
}

// Function: existingGroup
// Description: 
bool User::existingGroup(string group) {
   if (usersWithGroups.count(group) != 0) {
      return true;
   }
   return false;
}

/******MessageBuffer Function Declarations******/

// Function: copyBuffer
// Description: 
string MessageBuffer::copyBuffer() {
   return message_buffer;
}

// Function: add
// Description: 
void MessageBuffer::add(string username, string group, string message) {
   string prepend;
   prepend = "|<" + username + "::" + group + ">|" + message;
   message_buffer = prepend + message_buffer;
}

// Function: broadcastMessage
// Description:
void MessageBuffer::broadcastMessage() {
   string messageIn;
   string message;
   cout << "\nEnter message: ";
   while (getline(cin, messageIn)) {
      // If messageIn == $$, stop receiving input.
      if (messageIn == "$$")  {
         break;
      }
      message += messageIn + "\n";
   }
   add(currentUser, "All", message);
}

// Function: multicastMessage
// Description:
void MessageBuffer::multicastMessage() {
   string group;
   string messageIn;
   string message;
   bool validGroup = false;
   while (!validGroup) {
      cout << "\nEnter the group name: ";
      cin >> group;
      if (existingGroup(group)) {
         validGroup = true;
      }
      else {
         cout << "\nSorry, that group does not exist.";
      }
   }
   cout << "\nEnter message: ";
   while (getline(cin, messageIn)) {
      
      // If messageIn == $$, stop receiving input.
      if (messageIn == "$$")  {
         break;
      }
      message += messageIn + "\n";
   }
   add(currentUser, group, message);
   
}

// Function: unicastMessage
// Description:
void MessageBuffer::unicastMessage() {
   string recipientUser;
   string messageIn;
   string message;
   bool validUser = false;
   while (!validUser) {
      cout << "\nEnter the recipient user name: ";
      cin >> recipientUser;
      if (existingUser(recipientUser)) {
         validUser = true;
      }
      else {
         cout << "\nSorry, that user does not exist.";
      }
   }
   cout << "\nEnter message: ";
   while (getline(cin, messageIn)) {
      
      // If messageIn == $$, stop receiving input.
      if (messageIn == "$$")  {
         break;
      }
      message += messageIn + "\n";
   }
   add(currentUser, recipientUser, message);
   cout << "\nMessage has been sent." << endl;
}

void MessageBuffer::displayWall() {
   string message_buffer_temp = copyBuffer();
   size_t beginning;
   string username;
   string group;
   string message;
   string moreMessages;
   int i = 0;
   while (message_buffer_temp.size() > 0) {
   
   // Find the benning delimiter, and store the index.
      beginning = message_buffer_temp.find("|<");
      
   // Eliminate the beginning delimiter and retrieve the user name 
   // between new beginning index and the middle delimiter.
      message_buffer_temp = message_buffer_temp.substr(beginning + 2);
      username = message_buffer_temp.substr(0, message_buffer_temp.find("::"));
      
   // Eliminate the middle delimiter and retrieve the group between 
   // the new beginning index and the final delimiter.
      message_buffer_temp = message_buffer_temp.substr(message_buffer_temp.find("::") + 2);
      group = "(" + message_buffer_temp.substr(0, message_buffer_temp.find(">|")) + ")>>";
   
   // Eliminate the final delimiter and retrieve all data after the 
   // new beginning index. This will be the message.
      message_buffer_temp = message_buffer_temp.substr(message_buffer_temp.find(">|") + 2);	
      message = message_buffer_temp.substr(0, message_buffer_temp.find("|<"));
      
   // Move to beginning of next buffered message for next user.
   // (If one exists.)
   // Also avoid passing an empty string to message_buffer, which
   // causes a runtime error.
      message_buffer_temp = message_buffer_temp.substr(message.size() - 2);
      message_buffer_temp = message_buffer_temp.substr(message_buffer_temp.find("\n") + 1);
      
   
   // Print information in formatted form.
      if (username == currentUser) {
         cout << username << group << message << "\n";
      }
      
      i++;
      if (i == 2 && message_buffer_temp.size() != 0) {
         cout << "More messages? (yes/no): ";
         cin >> moreMessages;
         cout << "\n";
         if (moreMessages == "no") {
            break;
         }
      }
      
   } 
}

void MessageBuffer::displayHome() {
   string message_buffer_temp = copyBuffer();
   size_t beginning;
   string username;
   string group;
   string message;
   string moreMessages;
   string output;
   int i = 0;                                                     // keeps track of number of messages printed
   int p = 0;                                                     // prevents message from printing more than once
   while (message_buffer_temp.size() > 0) {
   
   // Find the benning delimiter, and store the index.
      beginning = message_buffer_temp.find("|<");
      
   // Eliminate the beginning delimiter and retrieve the user name 
   // between new beginning index and the middle delimiter.
      message_buffer_temp = message_buffer_temp.substr(beginning + 2);
      username = message_buffer_temp.substr(0, message_buffer_temp.find("::"));
      output += username;
      
   // Eliminate the middle delimiter and retrieve the group between 
   // the new beginning index and the final delimiter.
      message_buffer_temp = message_buffer_temp.substr(message_buffer_temp.find("::") + 2);
      group = message_buffer_temp.substr(0, message_buffer_temp.find(">|"));
      output += "(" + group + ")>>";
   
   // Eliminate the final delimiter and retrieve all data after the 
   // new beginning index. This will be the message.
      message_buffer_temp = message_buffer_temp.substr(message_buffer_temp.find(">|") + 2);	
      message = message_buffer_temp.substr(0, message_buffer_temp.find("|<"));
      output += message;
      
   // Move to beginning of next buffered message for next user.
   // (If one exists.)
   // Also avoid passing an empty string to message_buffer, which
   // causes a runtime error.
      message_buffer_temp = message_buffer_temp.substr(message.size() - 2);
      message_buffer_temp = message_buffer_temp.substr(message_buffer_temp.find("\n") + 1);
      
   
   // Print information in formatted form.
      if (group == currentUser) {
         cout << output << endl;
         p++;
      }
      if (group == "All" && p < 1) {
         cout << output << endl;
         p++;
      }
      if (find(usersWithGroups[group].begin(), usersWithGroups[group].end(), currentUser) != usersWithGroups[group].end()
          && p < 1) {
         cout << output << endl;
         p++;
      }
      
      i++;
      if (i == 2 && message_buffer_temp.size() != 0) {
         cout << "More messages? (yes/no): ";
         cin >> moreMessages;
         cout << "\n";
         if (moreMessages == "no") {
            break;
         }
      }
      
   }
}

/******System Function Declarations******/

// Function: getChoice
// Description: 
int System::getChoice() {
   int choice;
   bool validChoice = false;
   vector<int> validChoicesVector;
   for (int i = 1; i < 11; i++){
      validChoicesVector.push_back(i);
   }
   
   while (!validChoice) {
      cout << "\nPlease choose an option: ";
      cin >> choice;
      if (find(validChoicesVector.begin(), validChoicesVector.end(), choice) != validChoicesVector.end()) {
         return choice;
      }
      else {
         cout << "\nError, this choice is invalid." << endl;
         cin.clear();
         // discard 'bad' character(s)
         cin.ignore(numeric_limits<streamsize>::max(), '\n');
      }
   }
   
}

// Function: displayMenu
   // Description: 
void System::displayMenu() {
   cout << "\n";
   cout << "       1) Create a new user" << endl;
   cout << "       2) Broadcast a message" << endl;
   cout << "       3) Multicast a message" << endl;
   cout << "       4) Unicast a message" << endl;
   cout << "       5) Display Wall Page" << endl;
   cout << "       6) Display Home Page" << endl;
   cout << "       7) Create a new group" << endl;
   cout << "       8) Join a group" << endl;
   cout << "       9) Switch to a different user" << endl;
   cout << "       10) Quit Auburn Messaging System" << endl;
}

// Function: run
// Description: 
void System::run() {
   cout << "===========================================================\n";
   cout << "|      Welcome to the Auburn Messaging System!            |\n";
   cout << "===========================================================\n\n";
   MessageBuffer userObject;
   userObject.usersWithGroups["All"];
   int choice = 0;
   while (choice != 10) {
      
      displayMenu();
      choice = getChoice();  
      switch (choice) {
         case 1:
            userObject.newUser();
            break;
         case 2:
            userObject.broadcastMessage();
            break;
         case 3:
            userObject.multicastMessage();
            break;
         case 4:
            userObject.unicastMessage();
            break;
         case 5:
            userObject.displayWall();
            break;
         case 6:
            userObject.displayHome();
            break;
         case 7:
            userObject.newGroup();
            break;
         case 8:
            userObject.joinGroup();
            break;
         case 9:
            userObject.switchUser();
            break;
         case 10:
            return;
      }
   }
}