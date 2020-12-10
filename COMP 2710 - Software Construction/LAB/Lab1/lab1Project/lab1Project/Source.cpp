/*
Program:	Lab 1
Name:		John Carroll
UserID:		jcc0044
StudentID#:	902521946
Class:		COMP 2710
Date:		September 26, 2014
E-Mail:     jcc0044@tigermail.auburn.edu

Description: This is a simple message sharing application, called Auburn Messaging System. 
	It has a simple text-based user interface that allows multiple users to share messages 
	through one of the three methods: (1) broadcast a message to all users, (2) multicast a 
	message to a group, or (3) unicast a message to a particular user. A user may display 
	their homepage, all multicast messages to each group where the user is a member of, all broadcast
	messages, and all unicast messages to the user. This program allows a user to display in
	their messageClass page all messages posted by the user.

Compile Instructions:
1)	Change current directory to correct directory which contains the .cpp using command: “cd”
2)	To compile:
	a.	type "g++ hw1.cpp -o hw1" in a terminal window to create hw1 executable file;
		re-executing this will update the hw1 file
	b.	type "g++ hw1.cpp" to create and update the a.out with the latest code
	c.	type "./a.out" or “./hw1” to run the program
*/


#include <iostream>
#include <string>
#include <vector>
#include <cstring>
#include <fstream>
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
   void run();
   void mainerrorClass();
   void grouperrorClass1();
   void grouperrorClass2();
   void grouperrorClass3();
   void usererrorClass();
   void usererrorClass2();
   void usererrorClass3();
   void usererrorClass4();
   void sleep(float);
};

//Class: User
//Description: This class handles the running the menu, creating a new user, and switching user.

class User
{
public:
   string current_User;
   string users;

   bool isUser(string);
   void createUser();
   void switchUser();
   void checkSwitch();
   bool userAvailable(string);
};

class Group
{
public:
   string new_Group;
   string groups;
   string groupList;
   string members;
   string doubleBuffer;

   bool isGroup(string);
   bool isInGroup(string, string);
   void joinGroup(User, Group);
   void createGroup(Group);
};

class Message
{
public:
   string message_buffer;
   string groupList;

   void broadcastMessage(string);
   void multicastMessage(User, Group);
   void unicastMessage(User);
   void displayWall(User, Group);
   void displayHome(User, Group);
   void joinGroup(string, string);
};


//Function: main
//Description: This the driver function for the program. Is calls the run function.

//void main()
int main()
{
   Menu run_program;
   run_program.run();
}

//Function: mainerrorClass
//Description: This function prints out an menuClass statement if the user inputs a wrong option.

void Menu::mainerrorClass()
{
   cerr << "Your input was invalid!" << endl << endl;
}

//Function: grouperrorClass1
//Description: This function prints out an menuClass statement if the user tries to add themself as a group.

void Menu::grouperrorClass1()
{
   cerr << "You can not add yourself as a group." << endl << endl;
}

//Function: grouperrorClass2
//Description: This function prints an menuClass statement if users are already group.

void Menu::grouperrorClass2()
{
   cerr << "Group does not exist." << endl << endl;
}

//Function: grouperrorClass3
//Description: This function prints an menuClass message if a user tries to add a group that is not a user.

void Menu::grouperrorClass3()
{
   cerr << "Group already exists." << endl << endl;
}

//Function: grouperrorClass3
//Description: This function prints an menuClass message if a user tries to switch to a user that is not already created.

void Menu::usererrorClass()
{
   cerr << "You can not switch to a user that is not created." << endl << endl;
}

//Function: grouperrorClass3
//Description: This function prints an menuClass message if a user tries to switch to themself.

void Menu::usererrorClass2()
{
   cerr << "You are already the current user." << endl << endl;
}

//Function: grouperrorClass3
//Description: This function prints an menuClass message if a user tries to switch to themself.

void Menu::usererrorClass3()
{
   cerr << "This user already exists." << endl << endl;
}
   
void Menu::usererrorClass4()
{
   cerr << "This user does not exist." << endl << endl;
}

//Function: run
//Description: This is the function that prints out the menu for the user and then calls other functions based on user inputs.

void Menu::run()
{
	//Constants for the switch statement.
   const int CASE1 = 1, CASE2 = 2, CASE3 = 3, CASE4 = 4, CASE5 = 5, CASE6 = 6, CASE7 = 7, CASE8 = 8, CASE9 = 9, CASE10 = 10;

	//Message object to make a call to Message functions.
   Message messageClass;
   User userClass;
   Group groupClass;
   Menu menuClass;

	//Selection is the string being inputed by the user.

   string selection;
   
   vector<int> validChoicesVector;
   for (int i = 1; i < 11; i++){
      validChoicesVector.push_back(i);
   }

   cout << "        ===========================================================\n";
   cout << "        |             The Auburn Messaging System!                |\n";
   cout << "        ===========================================================\n\n\n";

	// This loop presents the user with the system menu.
	// The program terminates and exits the while upon the user selecting the quit option.
	// choice is used for the switch statement.
   int choice = 0;
   while ((choice != 10))
   {
      cout << "    1) Create a new user" << endl;
      cout << "    2) Broadcast a message" << endl;
      cout << "    3) Multicast a message" << endl;
      cout << "    4) Unicast a message" << endl;
      cout << "    5) Display a Wall Page" << endl;
      cout << "    6) Display a Home Page" << endl;
      cout << "    7) Create a new group" << endl;
      cout << "    8) Join a group" << endl;
      cout << "    9) Switch to a different user" << endl;
      cout << "    10) Quit Auburn Messaging System" << endl;
   
      int choice;
      bool validChoice = false;
   
      while (!validChoice) {
         cout << "\n" << "Please choose an option: ";
         cin >> choice;
         cout << endl;
         if (find(validChoicesVector.begin(), validChoicesVector.end(), choice) != validChoicesVector.end()) {
            selection = choice;
            validChoice = true;
         }
         else {
            menuClass.mainerrorClass();
            cin.clear();
         // discard 'bad' character(s)
            cin.ignore(numeric_limits<streamsize>::max(), '\n');
         }
      }
   
   //If the users string is empty and the user attempts to do something besides 
   //create a user or exit the program it will result in an error message.
      if (userClass.users.size() == 0 && choice != 1 && choice != 10)
      {
      //This calls the mainmenuClass function.
         menuClass.mainerrorClass();
      }
      else
      {
      //This is the switch statement that handles each option in the menu.
         switch (choice)
         {
            case CASE1:
               cout << "Please enter user name: ";
               cin >> userClass.current_User;
            
            //This calls the createUser function
               userClass.createUser();
               break;
         
            case CASE2:
            // Broadcast message
            
            //This calls the broadcastMessage function with a parameter of the current_User.
               messageClass.broadcastMessage(userClass.current_User);
               break;
         
            case CASE3:
            // Multicast message
            
               messageClass.multicastMessage(userClass, groupClass);
               break;
         
            case CASE4:
            // Unicast message
            
               messageClass.unicastMessage(userClass);
               break;
         
            case CASE5:
            // Display Wall page
            
            //This calls the displayWall function with a parameter of the current_User.
               messageClass.displayWall(userClass, groupClass);
               break;
         
            case CASE6:
            // Display Home page
            
            //This calls the displayHome function with a parameter of the current_User.
               messageClass.displayHome(userClass, groupClass);
               break;
         
            case CASE7:
            // Create a new group
            
               groupClass.createGroup(groupClass);
               break;
         
            case CASE8:
            // Join a group
            
               groupClass.joinGroup(userClass, groupClass);
               break;
         
            case CASE9:
            // Switch to a different user
            
            //This calls the checkSwitch function.
               userClass.checkSwitch();
               break;
         
            case CASE10:
            // Quit the system
            
               cout << "        ===========================================================\n";
               cout << "        |      Thank you for using Auburn Messaging System        |\n";
               cout << "        ===========================================================\n\n\n";
            
            // Allows time for the user to see the Thank you message.
               sleep(5);
               return;
         
            default:
            
            //This calls the mainmenuClass function.
               menuClass.mainerrorClass();
               break;
         }
      
         choice = 0;
      }
   }
   
   //This continues the loop until a 7 is entered.
   //while (choice != 10);
}

//Function: createUser
//Description: This function checks to see if a user is trying to create a user that is already in the system.

void User::createUser()
{
	//This is a constant length between the two | characters
   const int WELCOME_LENGTH = 58;

	//Menu object to make a call to Menu functions.
   Menu menuClass;

	//name_length and length are used for calculations for the welcome message. 
	//user_buffer is a temp copy of the users string for checking. 
	//currentUser is just a copy of the current_User variable in the User class. 
   int name_length, length, i = 0;
   string welcome;
   string user_buffer = users;
   string tempUser;
   string currentUser = current_User;
   string frontSpaces, rearSpaces;
   size_t first_char;

	//while loop that checks the size of the user_buffer.
   while (user_buffer.size() > 0)
   {
      first_char = user_buffer.find("<");
      user_buffer = user_buffer.substr(first_char + 1);
      tempUser = user_buffer.substr(0, user_buffer.find(">"));
   
   //checks to see if the user being added is already a user.
      if (currentUser != tempUser)
      {
         user_buffer = user_buffer.substr(user_buffer.find(">") + 1);
      }
      
      else
      {
         user_buffer = "";
         i = 1;
      }
   }

	//if the user is not already created the user is added to the list and a welcome message prints.
   if (i != 1)
   {
      users += "<" + currentUser + ">";
      cout << endl;
   
      welcome = "Welcome to Auburn Messaging System, " + currentUser + "!";
      name_length = welcome.size();
      length = (WELCOME_LENGTH - name_length) / 2;
      welcome = frontSpaces + welcome + rearSpaces;
      while (length > 0)
      {
         welcome = " " + welcome + " ";
         length--;
      }
   
      cout << "         ===========================================================\n";
      cout << "         |" << welcome << "|" << endl;
      cout << "         ===========================================================\n\n";
   }
   
   else
   {
      cout << endl;
   //menuClass.mainerrorClass();
      menuClass.usererrorClass3();
   }
}

//Function: checkSwitch
//Description: This function checks to see if the user being switched to is actually a user.

void User::checkSwitch()
{
	//This is a constant lencth between the two | characters
   const int WELCOME_LENGTH = 58;

	//Menu object to make a call to Menu functions.
   Menu menuClass;

	//name_length and length are used for calculations for the welcome message. 
	//user_buffer is a temp copy of the users string for checking. 
   int name_length, length, i = 0;
   string welcome, user_buffer = users, tempUser, new_user;
   size_t first_char;

   cout << "Enter user's name: ";
   cin >> new_user;
   cout << endl;

	//Checks to make sure the user being switched to is not already the current user.
   if (new_user == current_User)
   {
      menuClass.usererrorClass2();
   }
   else
   {
   
   //Continues the loop until the user_buffer is empty.
      while (user_buffer.size() > 0)
      {
         first_char = user_buffer.find("<");
         user_buffer = user_buffer.substr(first_char + 1);
         tempUser = user_buffer.substr(0, user_buffer.find(">"));
         user_buffer = user_buffer.substr(user_buffer.find(">") + 1);
      
      //If the user being switched to is found in the user_buffer then the current user switched.
         if (new_user == tempUser)
         {
            user_buffer = "";
            current_User = new_user;
         }
      }
   
   //If the user is found then the current user is switched and a welcome back message is printed.
      if (current_User == new_user)
      {
         cout << endl;
      
         welcome = "Welcome back to Auburn Messaging System, " + current_User + "!";
         name_length = welcome.size();
         length = (WELCOME_LENGTH - name_length) / 2;
      
         while (length > 0)
         {
            welcome = " " + welcome + " ";
            length--;
         }
      
         cout << "         ==========================================================\n";
         cout << "         |" << welcome << "|" << endl;
         cout << "         ==========================================================\n\n";
      }
      else
      {
         cout << endl;
         menuClass.usererrorClass();
      }
   }
}

//Function: userAvailable
//Description: This function checks to see if the group being added is the user him/herself or if the group is an actual user.

bool User::userAvailable(string name)
{
	//Menu object to make a call to Menu functions.
   Menu menuClass;

	//group is set to the parameter being passed of the current user.
	//user_buffer is a temp variable of the string users.
   string group = name, user_buffer = users, tempUser;
   size_t first_char, last_char;
   bool check = false, available = false;
   int i = 0;

	//continues loop until user_buffer is empty.
   while (user_buffer.size() > 0)
   {
      first_char = user_buffer.find("<");
      last_char = user_buffer.find(">");
      user_buffer = user_buffer.substr(first_char + 1);
      tempUser = user_buffer.substr(0, last_char - 1);
      user_buffer = user_buffer.substr(last_char);
   
   //Checks to see if users are already group.
      if (group == current_User)
      {
         menuClass.grouperrorClass1();
         check = false;
         available = true;
         break;
      }
   
   //Checks to see if group is a user 
      if (group == tempUser)
      {
         user_buffer = "";
         check = true;
         available = true;
      }
      
      else
      {
         available = false;
      }
   }

	//If group is not a valid user a menuClass message is printed.
   if (!available)
   {
      menuClass.grouperrorClass3();
   }

	//Returns a boolean variable representing if the group being added is available or not.
   return check;
}

bool User::isUser(string userIn)
{
   int i = 0;
	//Group groupClass;
   Menu menuClass;
	//string groupIn;
   string user_buffer = users;
   string tempUser;
   size_t first_char;
   bool result = false;

   if (user_buffer.size() == 0)
   {
      result = false;
   }
   while (user_buffer.size() > 0)
   {
      first_char = user_buffer.find("<");
      user_buffer = user_buffer.substr(first_char + 1);
      tempUser = user_buffer.substr(0, user_buffer.find(">"));
   
   //checks to see if the user being added is already a user.
      if (userIn != tempUser)
      {
      //This makes a new substring and moves on its search
         user_buffer = user_buffer.substr(user_buffer.find(">") + 1);
      }
      
      else
      {
         result = true;
         user_buffer = "";
         break;
      }
   }

   return result;

}

//Function: displayWall
//Description: This function dislays the messageClass page of the current user. 
//             First it displays the last three message and then more
//             if the user selects to display more messages.

void Message::displayWall(User userObject, Group groupObject)
{
	//This is a constant lencth between the two | characters
   const int WELCOME_LENGTH = 58;

	//current_user set to the current user being passed as a parameter.
	//message_buffer_temp is set to a temp variable of the message_buffer.
   int name_length, length, i = 0;
   string welcome, message_buffer_temp = message_buffer, user_temp, group_temp;
   string message_temp, message_buffer_temp2, more_messages, current_user = userObject.current_User;
   size_t first_char;

   first_char = message_buffer_temp.find("<");
   user_temp = message_buffer_temp.substr(first_char + 1, message_buffer_temp.find(">") - 1);

   welcome = current_user + "'s Wall Page";
   name_length = welcome.size();
   length = (WELCOME_LENGTH - name_length) / 2;

   while (length > 0)
   {
      welcome = " " + welcome + " ";
      length--;
   }

   cout << "         ==========================================================\n";
   cout << "         |" << welcome << "|" << endl;
   cout << "         ==========================================================\n\n";

	//Conitnues until message_buffer_temp is empty.
   while (message_buffer_temp.size() > 0)
   {
   //Conitnues until three messages has been printed or there are no more messages for the user.
      while (i < 2)
      {
         first_char = message_buffer_temp.find("|<");													// Move message_buffer to first entry
         message_buffer_temp = message_buffer_temp.substr(first_char + 2);								// Move message_buffer
         user_temp = message_buffer_temp.substr(0, message_buffer_temp.find("::"));					// Get userName
      
         message_buffer_temp = message_buffer_temp.substr(message_buffer_temp.find("::") + 2);						// Move message_buffer
         group_temp = "(" + message_buffer_temp.substr(0, message_buffer_temp.find(">|")) + ")>>\n";				// Get groupName
         message_buffer_temp = message_buffer_temp.substr(message_buffer_temp.find(">|") + 2);
      
         message_temp = message_buffer_temp.substr(0, message_buffer_temp.find("|<"));
         message_buffer_temp = message_buffer_temp.substr(message_temp.size() - 2);
         message_buffer_temp = message_buffer_temp.substr(message_buffer_temp.find("\n") + 1);
         message_buffer_temp2 = message_buffer_temp;
      
      
      //Checks the users is the message_buffer to see if they are the current user.
      //If it is the current user then the user and message are printed and i is incremented.
         if (user_temp == current_user)
         {
         
         
         //Prints the user and their message is reverse chronological order.
            cout << user_temp << group_temp << message_temp << "\n";
         
            i++;
            if (i == 2)
            {
               message_buffer_temp = "";
            }
         }
         //If it is not the current user then that user and message is removed from the message buffer.
         else
         {
         //message_temp = message_buffer_temp.substr(0, message_buffer_temp.find("|<"));
         //message_buffer_temp = message_buffer_temp.substr(message_temp.size() - 2);
         //message_buffer_temp = message_buffer_temp.substr(message_buffer_temp.find("\n") + 1);
         //message_buffer_temp2 = message_buffer_temp;
         }
      
      //If the message_buffer is empty it sets i = 3 to break out of the while loop.
         if (message_buffer_temp.size() == 0)
         {
            i = 2;
         }
      
      }
   }
  
	//If there are more messages to print for the user then the user is asked ifthey want to print more messages.
   if (message_buffer_temp2.size() != 0)
   {
   reprompt:
      cout << "                  More messages? (yes/no): ";
      cin >> more_messages;
      cout << endl;
   
   //If the user selects to display more messages then all messages for the user are displayed.
      if (more_messages == "yes")
      {
      //Continues loop until message_buffer_temp2 is empty
         while (message_buffer_temp2.size() > 0)
         {
            first_char = message_buffer_temp2.find("|<");													// Move message_buffer to first entry
            message_buffer_temp2 = message_buffer_temp2.substr(first_char + 2);								// Move message_buffer
            user_temp = message_buffer_temp2.substr(0, message_buffer_temp2.find("::"));					// Get userName
         
            message_buffer_temp2 = message_buffer_temp2.substr(message_buffer_temp2.find("::") + 2);						// Move message_buffer
            group_temp = "(" + message_buffer_temp2.substr(0, message_buffer_temp2.find(">|")) + ")>>\n";				// Get groupName
            message_buffer_temp2 = message_buffer_temp2.substr(message_buffer_temp2.find(">|") + 2);
         
            message_temp = message_buffer_temp2.substr(0, message_buffer_temp2.find("|<"));
            message_buffer_temp2 = message_buffer_temp2.substr(message_temp.size() - 2);
            message_buffer_temp2 = message_buffer_temp2.substr(message_buffer_temp2.find("\n") + 1);
         
         //first_char = message_buffer_temp2.find("<");
         //message_buffer_temp2 = message_buffer_temp2.substr(first_char + 1);
         //user_temp = message_buffer_temp2.substr(0, message_buffer_temp2.find("::"));
         
         //Checks the users is the message_buffer to see if they are the current user.
         //If it is the current user then the user and message are printed and i is incremented.
            if (user_temp == current_user)
            {
            //message_buffer_temp2 = message_buffer_temp2.substr(message_buffer_temp2.find(">|") + 2);
            //message_temp = message_buffer_temp2.substr(0, message_buffer_temp2.find("|<"));
            //message_buffer_temp2 = message_buffer_temp2.substr(message_temp.find("\n"));
            
            
            //Checks to see if the string equals the new line character. If it does then the message_buffer_temp2
            //is cleared.
               if (message_buffer_temp2 == "\n")
               {
                  message_buffer_temp2 = "";
               }
            
            //Prints the rest of the messages for the user.
               cout << user_temp << group_temp << message_temp << "\n";
            
            //cout << user_temp << ">> " << message_temp << "\n";
            }
         }
      }
      else if (more_messages == "no")
      {
         goto out;
      }
      else{
         goto reprompt;
      }
   out:
      cout << "";
   }

}

//Function: displayHome
//Description: This function displays the home page of the user.
//             The last three messages of the user and his group 
//             will be displayed. If the user selects for more 
//             message to be displayed then the program will display 
//             the rest of the messages.

void Message::displayHome(User userObject, Group groupObject)
{

	//TO DO:
	// check how many messages print
	// prompt more messages if more than two.
	// print more messages


	//This is a constant lencth between the two | characters
   const int WELCOME_LENGTH = 58;

	//current_user set to the current user being passed as a parameter.
	//message_buffer_temp is set to a temp variable of the message_buffer.
   int name_length, length, i = 0;
   string current_user = userObject.current_User;
   string message_buffer_temp = message_buffer;
   string groupListTemp = groupList;
   string user1, welcome;
   string user_temp;
   string group_temp;
   string message_temp;
   string message_buffer_temp2;
   string more_messages;
   string home_buffer;
   string user2;
   size_t first_char;
   bool willPrint = false;
   bool printWithoutGroup = false;

   welcome = current_user + "'s Home Page";
   name_length = welcome.size();
   length = (WELCOME_LENGTH - name_length) / 2;

   while (length > 0)
   {
      welcome = " " + welcome + " ";
      length--;
   }

   cout << "         ==========================================================\n";
   cout << "         |" << welcome << "|" << endl;
   cout << "         ==========================================================\n\n";

	//Continues until message_buffer_temp is empty
   while (message_buffer_temp.size() > 0)
   {
   
   //Continues until three messages are found or until there are no messages.
      while (i < 2)
      {
         willPrint = false;
      
         first_char = message_buffer_temp.find("|<");
         message_buffer_temp = message_buffer_temp.substr(first_char + 2);
         user_temp = message_buffer_temp.substr(0, message_buffer_temp.find(">|"));
         group_temp = user_temp.substr(user_temp.find("::") + 2, std::string::npos);	//Get the group/receiver
      
         user_temp = user_temp.substr(0, user_temp.find("::"));							//Get the user/sender
         message_buffer_temp = message_buffer_temp.substr(message_buffer_temp.find(">|") + 2);
      
      //message_temp = message_buffer_temp.substr(0, message_buffer_temp.find("|<"));
      //message_buffer_temp = message_buffer_temp.substr(message_buffer_temp.find("\n"));
      //message_buffer_temp2 = message_buffer_temp; //pass on the rest of the messages for reprompt
      
      //wallway
      //first_char = message_buffer_temp.find("|<");													// Move message_buffer to first entry
      //message_buffer_temp = message_buffer_temp.substr(first_char + 2);								// Move message_buffer
      //user_temp = message_buffer_temp.substr(0, message_buffer_temp.find("::"));					// Get userName
      
      //message_buffer_temp = message_buffer_temp.substr(message_buffer_temp.find("::") + 2);						// Move message_buffer
      //group_temp = "(" + message_buffer_temp.substr(0, message_buffer_temp.find(">|")) + ")>>\n";				// Get groupName
      //message_buffer_temp = message_buffer_temp.substr(message_buffer_temp.find(">|") + 2);
      
         message_temp = message_buffer_temp.substr(0, message_buffer_temp.find("|<"));
         message_buffer_temp = message_buffer_temp.substr(message_temp.size() - 2);
         message_buffer_temp = message_buffer_temp.substr(message_buffer_temp.find("\n") + 1);
         message_buffer_temp2 = message_buffer_temp;
      
      
         if (group_temp == "All")
         {
            cout << user_temp << "(" + group_temp + ")>>\n" + message_temp + "\n";
            i++;
         }
         else if (group_temp == userObject.current_User)
         {
            cout << user_temp + ">>\n" + message_temp + "\n";
            i++;
         }
         else if (groupObject.isInGroup(userObject.current_User, group_temp))
         {
            cout << user_temp << "(" + group_temp + ")>>\n" + message_temp + "\n";
            i++;
         }
         else
         {
         
         }
         if (i == 2)
         {
            message_buffer_temp = "";
         }
      
         if (message_buffer_temp.size() == 0)
         {
            i = 2;
         }
      }
   }

	//If there are more messages to print for the user then the user is asked if they want to print more messages.
   if (message_buffer_temp2.size() != 0)
   {
   reprompt:
      cout << "                  More messages? (yes/no): ";
      cin >> more_messages;
      cout << endl;
   
   //If the user selects to display more messages then all messages for the user are displayed.
      if (more_messages == "yes")
      {
      //Continues until message_buffer_temp2 is empty
         while (message_buffer_temp2.size() > 0)
         {
            willPrint = false;
         
         //first_char = message_buffer_temp.find("|<");
         //message_buffer_temp = message_buffer_temp.substr(first_char + 2);
         //user_temp = message_buffer_temp.substr(0, message_buffer_temp.find(">|"));
         //group_temp = user_temp.substr(user_temp.find("::") + 2, std::string::npos);	//Get the group/receiver
         
         //user_temp = user_temp.substr(0, user_temp.find("::"));							//Get the user/sender
         //message_buffer_temp = message_buffer_temp.substr(message_buffer_temp.find(">|") + 2);
         
         ////message_temp = message_buffer_temp.substr(0, message_buffer_temp.find("|<"));
         ////message_buffer_temp = message_buffer_temp.substr(message_buffer_temp.find("\n"));
         ////message_buffer_temp2 = message_buffer_temp; //pass on the rest of the messages for reprompt
         
         ////wallway
         ////first_char = message_buffer_temp.find("|<");													// Move message_buffer to first entry
         ////message_buffer_temp = message_buffer_temp.substr(first_char + 2);								// Move message_buffer
         ////user_temp = message_buffer_temp.substr(0, message_buffer_temp.find("::"));					// Get userName
         
         ////message_buffer_temp = message_buffer_temp.substr(message_buffer_temp.find("::") + 2);						// Move message_buffer
         ////group_temp = "(" + message_buffer_temp.substr(0, message_buffer_temp.find(">|")) + ")>>\n";				// Get groupName
         ////message_buffer_temp = message_buffer_temp.substr(message_buffer_temp.find(">|") + 2);
         
         //message_temp = message_buffer_temp.substr(0, message_buffer_temp.find("|<"));
         //message_buffer_temp = message_buffer_temp.substr(message_temp.size() - 2);
         //message_buffer_temp = message_buffer_temp.substr(message_buffer_temp.find("\n") + 1);
         //message_buffer_temp2 = message_buffer_temp;
         
         //===========================================
         
            first_char = message_buffer_temp2.find("|<");
            message_buffer_temp2 = message_buffer_temp2.substr(first_char + 2);
            user_temp = message_buffer_temp2.substr(0, message_buffer_temp2.find(">|"));
            group_temp = user_temp.substr(user_temp.find("::") + 2, std::string::npos);		//get the group/receiver
         
            user_temp = user_temp.substr(0, user_temp.find("::"));							//get the user/sender
            message_buffer_temp2 = message_buffer_temp2.substr(message_buffer_temp2.find(">|") + 2);
         
         ////message_temp = message_buffer_temp2.substr(0, message_buffer_temp2.find("\n"));
         ////message_buffer_temp2 = message_buffer_temp2.substr(message_buffer_temp2.find("\n"));
         
         
         ////wallway2 again
         //first_char = message_buffer_temp2.find("|<");													// Move message_buffer to first entry
         //message_buffer_temp2 = message_buffer_temp2.substr(first_char + 2);								// Move message_buffer
         //user_temp = message_buffer_temp2.substr(0, message_buffer_temp2.find("::"));					// Get userName
         
         //message_buffer_temp2 = message_buffer_temp2.substr(message_buffer_temp2.find("::") + 2);						// Move message_buffer
         //group_temp = "(" + message_buffer_temp2.substr(0, message_buffer_temp2.find(">|")) + ")>>\n";				// Get groupName
         //message_buffer_temp2 = message_buffer_temp2.substr(message_buffer_temp2.find(">|") + 2);
         
            message_temp = message_buffer_temp2.substr(0, message_buffer_temp2.find("|<"));
            message_buffer_temp2 = message_buffer_temp2.substr(message_temp.size() - 2);
            message_buffer_temp2 = message_buffer_temp2.substr(message_buffer_temp2.find("\n") + 1);
         
            if (group_temp == "All")
            {
               cout << user_temp << "(" + group_temp + ")>>\n" + message_temp + "\n";
               i++;
            }
            else if (group_temp == userObject.current_User)
            {
               cout << user_temp + ">>\n" + message_temp + "\n";
               i++;
            }
            else if (groupObject.isInGroup(userObject.current_User, group_temp))
            {
               cout << user_temp << "(" + group_temp + ")>>\n" + message_temp + "\n";
               i++;
            }
            else
            {
            
            }
         
            if (message_buffer_temp2 == "\n")
            {
               message_buffer_temp2 = "";
            }
         }
      }
      else if (more_messages == "no")
      {
         goto out;
      }
      else{
         goto reprompt;
      }
   out:
      cout << "";
   }
}

//Function: broadcastMessage
//Description: This function adds the user and  his message to the message_buffer.

void Message::broadcastMessage(string name)
{
   string message, message_temp, user_temp = name;

   cout << "Enter message: ";

	//Checks to make sure message does not end the end of the message symbol $
   while (message != "$$")
   {
      getline(cin, message);
   // If message = $ then the user is through inputting and the if ststement will not execut
      if (message != "$$")
      {
      // If the message string is empty then it will not add anything to the message_buffer.
         if (message != "")
         {
            message_temp += message + "\n";
         }
      }
   }

	//Adds the user and message to the message_buffer to the message_buffer string in reverse chronological order.
   message_buffer = "|<" + user_temp + "::All>|" + message_temp + message_buffer;
   message = "";
   message_temp = "";
   cout << endl;
}

void Message::multicastMessage(User userObject, Group groupObject)
{
	   //Group groupClass;
   groupObject.groups;
   Menu menuClass;
   string message, message_temp;
   string user_temp = userObject.current_User;
   string groupIn;
	
	   //string group_buffer = groups;
   string tempGroup;
		 //string newGroup = groupClass.new_Group;
   size_t first_char;
   int i = 0;

   cout << "Enter the group name: ";
   cin >> groupIn;

   if (groupObject.isGroup(groupIn) == true)
   {
      cout << "\nEnter message: ";
   
   //Checks to make sure message does not end the end of the message symbol $$
      while (message != "$$")
      {
         getline(cin, message);
      // If message = $$ then the user is through inputting and the if statement will not execute
         if (message != "$$")
         {
         // If the message string is empty then it will not add anything to the message_buffer.
            if (message != "")
            {
               message_temp += message + "\n";
            }
         }
      }
   
   //Adds the user and message to the message_buffer to the message_buffer string in reverse chronological order.
      message_buffer = "|<" + user_temp + "::" + groupIn + ">|" + message_temp + message_buffer;
      message = "";
      message_temp = "";
      cout << endl;
   }
   else
   {
      cout << endl;
      menuClass.grouperrorClass2();
   }
}

void Message::unicastMessage(User userObject)
{
   //Group groupClass;
	   //groupObject.groups;
   Menu menuClass;
   string message, message_temp;
   string dasUsers = userObject.users;
   string user_temp = userObject.current_User;
   string userIn;
	
	   //string group_buffer = groups;
   string tempUser;
		 //string newGroup = groupClass.new_Group;
   size_t first_char;
   int i = 0;

   cout << "Enter the user name: ";
   cin >> userIn;

   if (userObject.isUser(userIn) == true)
   {
      cout << "\nEnter message: ";
   
   //Checks to make sure message does not end the end of the message symbol $$
      while (message != "$$")
      {
         getline(cin, message);
      // If message = $$ then the user is through inputting and the if statement will not execute
         if (message != "$$")
         {
         // If the message string is empty then it will not add anything to the message_buffer.
            if (message != "")
            {
               message_temp += message + "\n";
            }
         }
      }
   
   //Adds the user and message to the message_buffer to the message_buffer string in reverse chronological order.
      message_buffer = "|<" + user_temp + "::" + userIn + ">|" + message_temp + message_buffer;
      message = "";
      message_temp = "";
      cout << endl;
   }
   else
   {
      cout << endl;
      menuClass.usererrorClass4();
   }
}


bool Group::isGroup(string groupIn)
{
   int i = 0;
	//Group groupClass;
   Menu menuClass;
	//string groupIn;
   string group_buffer = groups;
   string tempGroup;
   size_t first_char;
   bool result = false;

   if (group_buffer.size() == 0)
   {
      result = false;
   }
   while (group_buffer.size() > 0)
   {
      first_char = group_buffer.find("<");
      group_buffer = group_buffer.substr(first_char + 1);
      tempGroup = group_buffer.substr(0, group_buffer.find(">"));
   
   //checks to see if the user being added is already a user.
      if (groupIn != tempGroup)
      {
      //This makes a new substring and moves on its search
         group_buffer = group_buffer.substr(group_buffer.find(">") + 1);
      }
      
      else
      {
         result = true;
         group_buffer = "";
         break;
      }
   }
   return result;
}

bool Group::isInGroup(string userIn, string groupIn)
{
   string target = "(" + groupIn + ")<" + userIn + ">";
   bool result = false;

   if ((isGroup(groupIn)) && (doubleBuffer.find(target) != std::string::npos))
   {
      result = true;
   }
   return result;
	
}

void Group::createGroup(Group groupObject)
{
   Menu menuClass;
   groupObject.new_Group;
   groupObject.groups;
		 
   int i = 0; //Set to found initially
   string group_buffer = groups;
   string tempGroup;
   size_t first_char;
   bool reprompt = true;
   
   do
   {
      cout << "Enter group name: ";
      cin >> groupObject.new_Group;
    //string newGroup = new_Group;
    //Check if the group entered in is NOT already a group
      if (groupObject.isGroup(groupObject.new_Group) == false)
      {
         reprompt = false; //reprompt to enter
      
      //add entered in group to all groups
         groups += "<" + groupObject.new_Group + ">";
         cout << endl;
         break;
      }
      else
      {
      //Group already exists
         cout << endl;
      //reprompt = true;
      //menuClass.grouperrorClass3();
         cout << "Group aleady exists." << endl << endl;
      //groupObject.createGroup(groupObject);
      }
   }      
   while(reprompt == true);
}


void Group::joinGroup(User userObject, Group groupObject)
{
		/*Join a group: When selected, the program will first prompt for the name of the group. 
		It then checks if the group’s name is already an existing group. If not, it will display an error 
		message and prompts for another group name. Next, the program will add the current 
		user name to the group. */
		
   Menu menuClass;
   userObject.users;
   groupObject.doubleBuffer;
   groupObject.new_Group;
   groupObject.groups;
 
   int i = 0; //Set to found initially
   string group_buffer = groups;
   string tempGroup;
   size_t first_char;
   bool reprompt = true;
   
   do
   {
   //the program will first prompt for the name of the group. 
      cout << "Enter group name: ";
      cin >> groupObject.new_Group;
   
    ///It then checks if the group’s name is already an existing group.
      if (groupObject.isGroup(groupObject.new_Group) == true)
      {
         reprompt = false; //reprompt
      //Next, the program will add the current user name to the group.
         doubleBuffer += "|(" + groupObject.new_Group + ")<" + userObject.current_User + ">|";
      
      //groups += "<" + newGroup + ">"; 
         cout << endl;  
      }
      else 
      {
      //If not, it will display an error message and prompts for another group name.
         reprompt = true; //Will reprompt for group
         cout << endl;
         cout << "Group does not exist." << endl << endl; //"error message"
      //groupObject.createGroup(groupObject);
         if (groupObject.groups.size() == 0)
         {
            break;
         }
      }
   }          
   while(reprompt == true);
} 

void Menu::sleep(float s)
{
	//Delays the closing of the window to allow the user to read the goodbye message. 
   time_t start_time, current_time; 
   time(&start_time); 
   do 
   { 
      time(&current_time);
   } 
   while ((current_time - start_time) < s);

}

