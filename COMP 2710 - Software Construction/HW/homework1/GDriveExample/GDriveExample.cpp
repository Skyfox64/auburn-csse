#include <iostream>
#include <string>
#include <algorithm>

using namespace std;

// Function:     Main
// Description:  Runs the program in the command window.

int main()
{

	string userName;                                           // user name that will be enter by user
	string message;                                            // message that the user enters
	string user = "yes";                                       // yes or no variable that continues or ends the program
	string message_buffer = "The current messages are: \n\n";  // string that the user names and messages are stored in for output later
	size_t first_char;

	cout << "========================================================\n";
	cout << "|           Welcome to the Message System!              |\n";
	cout << "========================================================\n\n\n";
	
	// if user inputs yes for "Any more users?" then the while loop will continue until no is entered.
	while (user == "yes")
	{
		cout << "Enter user name> ";
		cin >> userName;
		message_buffer += "<" + userName + ">";
		cout << "Enter the message> ";

		// while loop will continue until user enetrs $ and enter key on a single line.
		while (message != "$")
		{
			getline(cin, message);

			// If message = $ then the user is through inputting and the if ststement will not execut
			if (message != "$")
			{
				// If the message string is empty then it will not add anything to the message_buffer.
				if (message != "")
				{
					message_buffer += message + "\n";
				}
			}
		}

		message = "";
		cout << "\nAny more users? > ";
		getline(cin, user);
		cout << "\n";

		// transforms the users answer to the question "Any more users?" to lower case.
		std::transform(user.begin(), user.end(), user.begin(), ::tolower);
	}

	cout << "The current messages are: \n\n";

	// This while loop prints out the user names and their messages. As the code executes we remove the part of message_buffer
	// that we no longer need until we reach the end of the string.
	while (message_buffer.size() > 0)
	{
		first_char = message_buffer.find("<");
		message_buffer = message_buffer.substr(first_char + 1);

		userName = message_buffer.substr(0, message_buffer.find(">")) + " ~ ";
		message_buffer = message_buffer.substr(message_buffer.find(">") + 1);

		message = message_buffer.substr(0, message_buffer.find("<"));
		message_buffer = message_buffer.substr(message.size() - 1);

		message_buffer = message_buffer.substr(message_buffer.find("\n") + 1);

		cout << userName << message << "\n";
	}
	cout << "";
}