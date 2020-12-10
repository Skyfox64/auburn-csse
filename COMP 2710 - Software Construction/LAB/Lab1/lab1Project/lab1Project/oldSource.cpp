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
	their wall page all messages posted by the user.

Compile Instructions:
1)	Change current directory to correct directory which contains the .cpp using command: �cd�
2)	To compile:
	a.	type "g++ hw1.cpp -o hw1" in a terminal window to create hw1 executable file;
		re-executing this will update the hw1 file
	b.	type "g++ hw1.cpp" to create and update the a.out with the latest code
	c.	type "./a.out" or �./hw1� to run the program
*/


#include <iostream>
#include <string>
#include <vector>
#include <cstring>
#include <fstream>

using namespace std;

//Class: Menu
//Description: This class handles the ouptut of any user errors.

class Menu
{
public:
   void mainerror();
   void frienderror1();
   void frienderror2();
   void frienderror3();
   void usererror();
   void usererror2();
};

//Class: User
//Description: This class handles the running the menu, creating a new user, and switching user.

class User
{
public:
   string current_User;
   string users;
   string groups;

   void run();
   void checkUser();
   void switchUser();
   void checkSwitch();
   bool userAvailable(string);
};

//Class: Message
//Function: This class handles everything related to user messages and friends.

class Message
{
public:
   string message_buffer;
   string friendList;

   void newMessage(string);
   void displayWall(string);
   void displayHome(string);
   void addFriend(string, string);
};

//Function: main
//Description: This the driver function for the program. Is calls the run function.

//void main()
int main()
{
   User run_program;
   run_program.run();
}

//Function: mainerror
//Description: This function prints out an error statement if the user inputs a wrong option.

void Menu::mainerror()
{
   cerr << "         Your input was invalid!" << endl << endl;
}

//Function: frienderror1
//Description: This function prints out an error statement if the user tries to add themself as a friend.

void Menu::frienderror1()
{
   cerr << "         You can not add yourself as a friend." << endl << endl;
}

//Function: frienderror2
//Description: This function prints an error statement if users are already friends.

void Menu::frienderror2()
{
   cerr << "         Users are already friends." << endl << endl;
}

//Function: frienderror3
//Description: This function prints an error message if a user tries to add a friend that is not a user.

void Menu::frienderror3()
{
   cerr << "         Friend is not a valid user." << endl << endl;
}

//Function: frienderror3
//Description: This function prints an error message if a user tries to switch to a user that is not already created.

void Menu::usererror()
{
   cerr << "         You can not switch to a user that is not created." << endl << endl;
}

//Function: frienderror3
//Description: This function prints an error message if a user tries to switch to themself.

void Menu::usererror2()
{
   cerr << "         You are already the current user." << endl << endl;
}

//Function: run
//Description: This is the function that prints out the menu for the user and then calls other functions based on user inputs.

void User::run()
{
	//Constants for the switch statement.
   const int CASE1 = 1, CASE2 = 2, CASE3 = 3, CASE4 = 4, CASE5 = 5, CASE6 = 6, CASE7 = 7, CASE8 = 8, CASE9 = 9, CASE10 = 10;

	//Message object to make a call to Message functions.
   Message wall;

	//Menu object to make a call to Menu functions.
   Menu error;

	//selection is the string being inputed by the user.
	//friends is the friend being added to the friend list. 
	//choice is used for the switch statement.
   int selection;
   string friends, line;
   int choice;

   cout << "        ===========================================================\n";
   cout << "        |             The Auburn Messaging System!                |\n";
   cout << "        ===========================================================\n\n\n";

	// This do-while loop presents the user with the system menu.
	// The program terminates and exits the while upon the user selecting the quit option.

   do
   {
      cout << "1) Create a new user" << endl;
      cout << "2) Broadcast a message" << endl;
      cout << "3) Multicast a message" << endl;
      cout << "4) Unicast a message" << endl;
      cout << "5) Display a Wall Page" << endl;
      cout << "6) Display a Home Page" << endl;
      cout << "7) Create a new group" << endl;
      cout << "8) Join a group" << endl;
      cout << "9) Switch to a different user" << endl;
      cout << "10) Quit Auburn Messaging System" << endl;
      cout << "\n" << "         Please choose an option: ";
      cin >> selection;
   
   	//This statement reads the rest of the line when the user is prompted to make a selection.
   	//This keeps the program from running the loop if the users inputs a sentence.
      getline(cin, line);
   
      cout << endl;
   
   
   	//If the size of selection is greater than one then the user input an invalid selection
      if (selection < 1)
      {
         choice = 11;
      }
      
      else
      {
      
      	//This statement converts s string to a int value.
         //choice = atoi(selection.c_str());
         choice = selection;
      }
   
   	//If the users string is empty and the user attempts to do something besides 
   	//create a user or exit the program it will result in an error message.
      if (users.size() == 0 && choice != 1 && choice != 10)
      {
      	//This calls the mainerror function.
         error.mainerror();
      }
      else
      {
      	//This is the switch statement that handles each option in the menu.
         switch (choice)
         {
            case CASE1:
               cout << "         Please enter user name: ";
               cin >> current_User;
            
            //This calls the checkUser function
               checkUser();
               break;
            case CASE2:
            // Broadcast message
            
            //This calls the newMessage function with a parameter of the current_User.
               wall.newMessage(current_User);
               break;
         
            case CASE3:
            // Multicast message
            
               break;
            case CASE4:
            // Unicast message
            
               break;
            case CASE5:
            // Display Wall page
            
            //This calls the displayWall function with a parameter of the current_User.
               wall.displayWall(current_User);
               break;
            case CASE6:
            // Display Home page
            
            //This calls the displayHome function with a parameter of the current_User.
               wall.displayHome(current_User);
               break;
            case CASE7:
            // Create a new group
            
               cout << "         Enter friend's name: ";
               cin >> friends;
               cout << endl;
            
            //This checks to see if the friend is available to add by calling the userAvailable function.
               if (userAvailable(friends))
               {
               
               //This calls the addFriend function with the current_User as a parameter.
                  wall.addFriend(friends, current_User);
               }
               break;
            case CASE8:
            // Join a group
            
               break;
            case CASE9:
            // Switch to a different user
            
            //This calls the checkSwitch function.
               checkSwitch();
               break;
         
            case CASE10:
               break;
            default:
            
            //This calls the mainerror function.
               error.mainerror();
               break;
         }
      }
   }
   
   //This continues the loop until a 7 is entered.
   while (choice != 10);
}

//Function: checkUser
//Description: This function checks to see if a user is trying to create a user that is already in the system.

void User::checkUser()
{
	//This is a constant length between the two | characters
   const int WELCOME_LENGTH = 58;

	//Menu object to make a call to Menu functions.
   Menu error;

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
   					//|      Welcome to Auburn Messaging System, Abraham!        |
   	                //|        Welcome to Auburn Messaging System, Mary!         |
   	                //|        Welcome to Auburn Messaging System, George!       |
      cout << "         |" << welcome << "|" << endl;
      cout << "         ===========================================================\n\n";
   }
   
   else
   {
      cout << endl;
      error.mainerror();
   }
}

//Function: checkSwitch
//Description: This function checks to see if the user being switched to is actually a user.

void User::checkSwitch()
{
	//This is a constant lencth between the two | characters
   const int WELCOME_LENGTH = 55;

	//Menu object to make a call to Menu functions.
   Menu error;

	//name_length and length are used for calculations for the welcome message. 
	//user_buffer is a temp copy of the users string for checking. 
   int name_length, length, i = 0;
   string welcome, user_buffer = users, tempUser, new_user;
   size_t first_char;

   cout << "Enter user's name: ";
   cin >> new_user;

	//Checks to make sure the user being switched to is not already the current user.
   if (new_user == current_User)
   {
      error.usererror2();
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
      
         cout << "         ========================================================\n";
         cout << "         |" << welcome << "|" << endl;
         cout << "         ========================================================\n\n";
      }
      else
      {
         cout << endl;
         error.usererror();
      }
   }
}

//Function: userAvailable
//Description: This function checks to see if the friend being added is the user him/herself or if the friend is an actual user.

bool User::userAvailable(string name)
{
	//Menu object to make a call to Menu functions.
   Menu error;

	//friend is set to the parameter being passed of the current user.
	//user_buffer is a temp variable of the string users.
   string friends = name, user_buffer = users, tempUser;
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
   
   	//Checks to see if users are already friends.
      if (friends == current_User)
      {
         error.frienderror1();
         check = false;
         available = true;
         break;
      }
   
   	//Checks to see if friend is a user 
      if (friends == tempUser)
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

	//If friend is not a valid user a error message is printed.
   if (!available)
   {
      error.frienderror3();
   }

	//Returns a boolean variable representing if the friend being added is available or not.
   return check;
}

//Function: displayWall
//Description: This function dislays the wall page of the current user. 
//             First it displays the last three message and then more
//             if the user selects to display more messages.

void Message::displayWall(string name)
{

	//This is a constant lencth between the two | characters
   const int WELCOME_LENGTH = 55;

	//current_user set to the current user being passed as a parameter.
	//message_buffer_temp is set to a temp variable of the message_buffer.
   int name_length, length, i = 0, j = 0;
   string welcome, message_buffer_temp = message_buffer, user_temp;
   string message_temp, message_buffer_temp2, more_messages, current_user = name;
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

   cout << "         ========================================================\n";
   cout << "         |" << welcome << "|" << endl;
   cout << "         ========================================================\n\n";

	//Conitnues until message_buffer_temp is empty.
   while (message_buffer_temp.size() > 0)
   {
   	//Conitnues until three messages has been printed or there are no more messages for the user.
      while (i < 3)
      {
         first_char = message_buffer_temp.find("<");
         message_buffer_temp = message_buffer_temp.substr(first_char + 1);
         user_temp = message_buffer_temp.substr(0, message_buffer_temp.find(">"));
         message_buffer_temp = message_buffer_temp.substr(message_buffer_temp.find(">") + 1);
      
      	//Checks the users is the message_buffer to see if they are the current user.
      	//If it is the current user then the user and message are printed and i is incremented.
         if (user_temp == current_user)
         {
            message_temp = message_buffer_temp.substr(0, message_buffer_temp.find("<"));
            message_buffer_temp = message_buffer_temp.substr(message_temp.size() - 1);
            message_buffer_temp = message_buffer_temp.substr(message_buffer_temp.find("\n") + 1);
            message_buffer_temp2 = message_buffer_temp;
         
         	//Prints the user and their message is reverse chronological order.
            cout << user_temp << "~ " << message_temp << "\n";
         
            i++;
            j++;
            if (i == 3)
            {
               message_buffer_temp = "";
            }
         }
         
         //If it is not the current user then that user and message is removed from the message buffer.
         else
         {
            message_temp = message_buffer_temp.substr(0, message_buffer_temp.find("<"));
            message_buffer_temp = message_buffer_temp.substr(message_temp.size() - 1);
            message_buffer_temp = message_buffer_temp.substr(message_buffer_temp.find("\n") + 1);
            message_buffer_temp2 = message_buffer_temp;
         }
      
      	//If the message_buffer is empty it sets i = 3 to break out of the while loop.
         if (message_buffer_temp.size() == 0)
         {
            i = 3;
         }
      }
   }

	//If there are more messages to print for the user then the user is asked ifthey want to print more messages.
   if (j = 3)
   {
      cout << "                  More messages? (yes/no): ";
      cin >> more_messages;
      cout << endl;
   
   	//If the user selects to display more messages then all messages for the user are displayed.
      if (more_messages == "yes")
      {
      	//Continues loop until message_buffer_temp2 is empty
         while (message_buffer_temp2.size() > 0)
         {
            first_char = message_buffer_temp2.find("<");
            message_buffer_temp2 = message_buffer_temp2.substr(first_char + 1);
            user_temp = message_buffer_temp2.substr(0, message_buffer_temp2.find(">"));
         
         	//Checks the users is the message_buffer to see if they are the current user.
         	//If it is the current user then the user and message are printed and i is incremented.
            if (user_temp == current_user)
            {
               message_buffer_temp2 = message_buffer_temp2.substr(message_buffer_temp2.find(">") + 1);
               message_temp = message_buffer_temp2.substr(0, message_buffer_temp2.find("<"));
               message_buffer_temp2 = message_buffer_temp2.substr(message_temp.size() - 1);
            
            	//Checks to see if the string equals the new line character. If it does then the message_buffer_temp2
            	//is cleared.
               if (message_buffer_temp2 == "\n")
               {
                  message_buffer_temp2 = "";
               }
            
            	//Prints the rest of the messages for the user.
               cout << user_temp << "~ " << message_temp << "\n";
            }
         }
      }
   }

}

//Function: addFriend
//Description: If the userAvailable function returns true then this 
//             method will add the friend to the user's friends list.

void Message::addFriend(string name, string userCurrent)
{
	//Menu object to make a call to Menu functions.
   Menu error;

	//friends set to friend being added. friendList_temp is a copy of the friendList string
	//current_user is set to the current user.
   string friends = name, user, new_friend, friendList_temp = friendList, current_user = userCurrent, user_temp;
   size_t first_char, last_char;
   int i = 0;

	//Continues loop until friendList_temp is empty.
   while (friendList_temp.size() > 0)
   {
      first_char = friendList_temp.find("<");
      last_char = friendList_temp.find(">");
      user_temp = friendList_temp.substr(first_char + 1, last_char - 1);
      friendList_temp = friendList_temp.substr(last_char + 1);
   
      first_char = friendList_temp.find("<");
      last_char = friendList_temp.find(">");
      new_friend = friendList_temp.substr(first_char + 1, last_char - 1);
      friendList_temp = friendList_temp.substr(last_char + 1);
   
   	//Checks to make sure the user is equalt to the current user.
      if (user_temp == current_user)
      {
      
      	//Checks to see if the friend being added is already a friend of the user.
         if (new_friend == friends)
         {
            error.frienderror2();
            friendList_temp = "";
            break;
         }
      }
      
      else
      {
         new_friend = "";
      }
   }

	//If the new friend is not already a friend of the user then the user and the friend are added to a string.
   if (new_friend != friends)
   {
      friendList = "<" + current_user + ">" + "<" + friends + ">" + friendList;
   }
}

//Function: displayHome
//Description: This function displays the home page of the user.
//             The last three messages of the user and his friends 
//             will be displayed. If the user selects for more 
//             message to be displayed then the program will display 
//             the rest of the messages.

void Message::displayHome(string name)
{

	//This is a constant lencth between the two | characters
   const int WELCOME_LENGTH = 55;

	//current_user set to the current user being passed as a parameter.
	//message_buffer_temp is set to a temp variable of the message_buffer.
   int name_length, length, i = 0, j = 0;
   string current_user = name;
   string messageBuffer = message_buffer;
   string friendListTemp = friendList;
   string user1, welcome;
   string user_temp;
   string message_temp;
   string message_buffer_temp2;
   string more_messages;
   string home_buffer;
   string user2;
   size_t first_char;

   welcome = current_user + "'s Home Page";
   name_length = welcome.size();
   length = (WELCOME_LENGTH - name_length) / 2;

   while (length > 0)
   {
      welcome = " " + welcome + " ";
      length--;
   }

   cout << "         ========================================================\n";
   cout << "         |" << welcome << "|" << endl;
   cout << "         ========================================================\n\n";

	//Continues until messageBuffer is empty
   while (messageBuffer.size() > 0)
   {
   
   	//Continues until three messages are found or until there are no messages.
      while (i < 3)
      {
         first_char = messageBuffer.find("<");
         messageBuffer = messageBuffer.substr(first_char + 1);
         user_temp = messageBuffer.substr(0, messageBuffer.find(">"));
         messageBuffer = messageBuffer.substr(messageBuffer.find(">") + 1);
      
      	//Checks the users is the message_buffer to see if they are the current user.
      	//If it is the current user then the user and message are printed and i is incremented.
         if (user_temp == current_user)
         {
            message_temp = messageBuffer.substr(0, messageBuffer.find("<"));
            messageBuffer = messageBuffer.substr(message_temp.size() - 1);
            messageBuffer = messageBuffer.substr(messageBuffer.find("\n") + 1);
            message_buffer_temp2 = messageBuffer;
         
            home_buffer += user_temp + "~ " + message_temp + "\n";
         
            i++;
            j++;
         
         	//Once three messages are found messageBuffer is emptied to end the while loops.
            if (i == 3)
            {
               messageBuffer = "";
            }
         }
         
         //If it is not the current user then that user and message is removed from the message buffer.
         else
         {
         
         	//Continues loop until friendList_temp is empty.
            while (friendListTemp.size() > 0)
            {
               first_char = friendListTemp.find("<");
               friendListTemp = friendListTemp.substr(first_char + 1);
               user1 = friendListTemp.substr(0, friendListTemp.find(">"));
               friendListTemp = friendListTemp.substr(friendListTemp.find(">") + 1);
            
            	//Checks to see if the user in the friend list is the current user.
               if (user1 == current_user)
               {
                  first_char = friendListTemp.find("<");
                  friendListTemp = friendListTemp.substr(first_char + 1);
                  user2 = friendListTemp.substr(0, friendListTemp.find(">"));
                  friendListTemp = friendListTemp.substr(friendListTemp.find(">") + 1);
               
               	//Checks to see if the friend in the friend list equals the friend in the message buffer.
                  if (user_temp == user2)
                  {
                     first_char = messageBuffer.find("<");
                     message_temp = messageBuffer.substr(0, first_char - 1);
                     message_buffer_temp2 = messageBuffer.substr(message_temp.size());
                  
                     home_buffer += user_temp + "~ " + message_temp + "\n";
                  
                     i++;
                     j++;
                  
                  	//If three messages are found then messageBuffer is emptied to end the while loops.
                     if (i == 3)
                     {
                        messageBuffer = "";
                     }
                  }
               }
            
            	//If messageBuffer is emptied then i set to 3 to end the while loop.
               if (messageBuffer.size() == 0)
               {
                  i = 3;
               }
            }
         
         	//resets the friendListTemp to the friendList after the while loop.
            friendListTemp = friendList;
         }
      }
   }

	//Prints out the user and the user's friends messages.
   cout << home_buffer;

	//If there are more messages to print for the user then the user is asked ifthey want to print more messages.
   if (j = 3)
   {
      cout << "                  More message? (yes/no): ";
      cin >> more_messages;
      cout << endl;
   
   	//If the user selects to display more messages then all messages for the user are displayed.
      if (more_messages == "yes")
      {
         messageBuffer = message_buffer_temp2;
         home_buffer = "";
      
      	//Continues until messageBuffer is empty
         while (messageBuffer.size() > 0)
         {
            first_char = messageBuffer.find("<");
            messageBuffer = messageBuffer.substr(first_char + 1);
            user_temp = messageBuffer.substr(0, messageBuffer.find(">"));
            messageBuffer = messageBuffer.substr(messageBuffer.find(">") + 1);
         
         	//Checks the users is the message_buffer to see if they are the current user.
         	//If it is the current user then the user and message are printed and i is incremented.
            if (user_temp == current_user)
            {
               message_temp = messageBuffer.substr(0, messageBuffer.find("<"));
               messageBuffer = messageBuffer.substr(message_temp.size() - 1);
               messageBuffer = messageBuffer.substr(messageBuffer.find("\n") + 1);
               message_buffer_temp2 = messageBuffer;
               home_buffer += user_temp + "~ " + message_temp + "\n";
            }
            
            //If it is not the current user then that user and message is removed from the message buffer.
            else
            {
            
            	//Continues loop until friendList_temp is empty.
               while (friendListTemp.size() > 0)
               {
                  first_char = friendListTemp.find("<");
                  friendListTemp = friendListTemp.substr(first_char + 1);
                  user1 = friendListTemp.substr(0, friendListTemp.find(">"));
                  friendListTemp = friendListTemp.substr(friendListTemp.find(">") + 1);
               
               	//Checks to see if the user in the friend list is the current user.
                  if (user1 == current_user)
                  {
                     first_char = friendListTemp.find("<");
                     friendListTemp = friendListTemp.substr(first_char + 1);
                     user2 = friendListTemp.substr(0, friendListTemp.find(">"));
                     friendListTemp = friendListTemp.substr(friendListTemp.find(">") + 1);
                  
                  	//Checks to see if the friend in the friend list equals the friend in the message buffer.
                     if (user_temp == user2)
                     {
                        first_char = messageBuffer.find("<");
                        message_temp = messageBuffer.substr(0, first_char - 1);
                        messageBuffer = messageBuffer.substr(messageBuffer.find("\n") + 1);
                     
                     	//If messageBuffer is emptied then i set to 3 to end the while loop.
                        if (messageBuffer.size() == 0)
                        {
                           friendListTemp = "";
                        }
                     
                        home_buffer += user_temp + "~ " + message_temp + "\n";
                     }
                  }
               }
            }
         
         	//resets the friendListTemp to the friendList after the while loop.
            friendListTemp = friendList;
         }
      
      	//Prints out the user and the user's friends messages.
         cout << home_buffer;
      }
   }
}

//Function: newMessage
//Description: This function adds the user and  his message to the message_buffer.

void Message::newMessage(string name)
{
   string message, message_temp, user_temp = name;

   cout << "         Enter message: ";

	//Checks to make sure message does not end the end of the message symbol $
   while (message != "$")
   {
      getline(cin, message);
   	// If message = $ then the user is through inputting and the if ststement will not execut
      if (message != "$")
      {
      	// If the message string is empty then it will not add anything to the message_buffer.
         if (message != "")
         {
            message_temp += message + "\n";
         }
      }
   }

	//Adds the user and message to the message_buffer to the message_buffer string in reverse chronological order.
   message_buffer = "<" + user_temp + ">" + message_temp + message_buffer;
   message = "";
   message_temp = "";
   cout << endl;
}
