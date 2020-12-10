// Program 1:    Lab 3
// Name:         Brandon Hurler
// Class:        COMP 2710
// Date:         November 10, 2014
// E-Mail:       bch0011@auburn.edu
//
// Description:  .

#include <fstream>
#include <iostream>
#include <string>
#include <cstring>
#include <sstream>
#include <cstdlib>
#include <stdio.h>
#include <time.h>


using namespace std;

//Class: Menu
//Description: This class handles the running of the program and any errors.

class Menu
{
	public:
		void run();
		void sleep();
		void invalidFileError();
};

//Class: Node
//Description: This class handles each node's pointers, setters, and getters.

class Node {
	public:
		Node(string newname);
		Node();

		void setNodeName(string newname);
		string getNodeName();

		void attachNewNode(Node *newNode, int index);
		Node *getAttachedNode(int index);

		int getNumberUsed();
		int setNumberUsed(int newNumberUsed);

		void setPrevious(Node *previousNode);
		Node *getPrevious();

		int setMarked();

	//private:
		string name;

		Node *attachedNodes[4];
		Node *previous;

		int numberUsed;
		int marked;
};

//Class: MazeSolver
//Description: This class handles username checks, creating a new user, and switching users.

class MazeSolver {
	public:
		void buildMaze();
		void findShortestPath();

		int numberOfNodes;
		string start;
		string finish;

		Node* nodeArray[];
	
};

//Class: File
//Description: This class handles all file associations, checking, creation, and append.

class File
{
	public:
		bool fileExists(string);
		void readFile(string, MazeSolver, Node);
};

//Function: main
//Description: This is the driver function for the program.

int main()
{
	Menu program;
	program.run();

	return 0;
}

//Function: invalidFileError
//Description: This function prints out an error statement if the user inputs anything other than the numbers 1 - 10.

void Menu::invalidFileError()
{
	cerr << "	That file does not exist. Please try another." << endl << endl;
}

//Function: run
//Description: This is the function that prints out the menu for the user and then calls other functions based on user inputs.

void Menu::run()
{

	//Menu object to make a call to Menu functions.
	Menu error;

	//File object to make a call to File functions.
	File file;

	//MazeSolver object instantiation.
	MazeSolver maze;

	//Node object instantiation.
	Node node;

	//Original user input.
	string input;

	//line is what is being read in for the input.
	string line;

	//fileName is the string being input by the user, after verified as a file.
	string fileName;

	//Whether the program should quit as indicated by the user.
	bool quit = false;

	cout << "	===================================================================\n";
	cout << "	|            Welcome to the Shortest Path Maze Solver!            |\n";
	cout << "	===================================================================\n\n";

	//The do-while loop to continue the running of the program unless the users selects to quit the Shortest Path Maze Solver.
	do
	{
		cout << "	Enter the name of the Maze configuration file: ";
		getline(cin, input);
		cout << endl;

		quit = input.compare("quit") == 0 || input.compare("Quit") == 0 || input.compare("q") == 0 || input.compare("Q") == 0;

		//Invalid if null.
		if (input.size() == 0)
		{
			continue;
		}

		//Quits the program.
		if (quit == true)
		{
			break;
		}

		//Once it passes the quit and null checks, set fileName to input to begin search.
		fileName = input;

		//Makes a boolean conditional fileExists based on the results of the fileExists() function on fileName.
		bool fileExists = file.fileExists(fileName);

		if (fileExists)
		{
			file.readFile(fileName, maze, node);
		}

		else
		{
			//The file name entered could not be found; prints error message.
			error.invalidFileError();
		}

	} while (quit == false);

	cout << "	==================================================================\n";
	cout << "	|        Thank you for using the Shortest Path Maze Solver!      |\n";
	cout << "	==================================================================\n\n\n";

	//Delays the closing of the window to allow the user to read the goodbye message.
	sleep();
}

bool File::fileExists(string file)
{
	if (!(file.find(".txt") != std::string::npos)) {
		file = file + ".txt";
	}

	ifstream f(file.c_str());
	if (f.good())
	{
		f.close();
		return true;
	}

	else
	{
		f.close();
		return false;
	}
}

void File::readFile(string file, MazeSolver maze, Node node)
{
	string name;
	string connectedNode;
	string delimiter = " ";

	//Checks if the file name entered by the user ends with .txt, if not, adds the extension.
	if (!(file.find(".txt") != std::string::npos)) {
		file = file + ".txt";
	}

	string line = "";
	ifstream fileIn(file);
	int i = 0;

	while (i < 3)
	{
		fileIn >> line;

		if (i == 0)
		{
			maze.numberOfNodes = atoi(line.c_str());
			cout << "	" << maze.numberOfNodes << endl; //For Testing
		}

		if (i == 1)
		{
			maze.start = line;
			cout << "	" << maze.start << endl; //For Testing
		}

		if (i == 2)
		{
			maze.finish = line;
			cout << "	" << maze.finish << endl; //For Testing
		}

		i++;
	}

	//Sets the size for the nodeArray.
	*maze.nodeArray = new Node[maze.numberOfNodes];

	//Creates the nodes based on the size read in from line 1.
	for (int i = 0; i < maze.numberOfNodes; i++)
	{
		maze.nodeArray[i] = new Node();
	}

	//Traverses the nodes in the file, assigning the correct names and indexes.
	for (int i = 0; i < maze.numberOfNodes; i++)
	{
		getline(fileIn, line);

		//Handles blank strings accidentally read from the text files.
		if (line == "")
		{
			i--;
			continue;
		}

		//Set the name of the node.
		name = line.substr(0, line.find(delimiter));
		//Assign the rest of the line to the variable, line.
		line = line.substr(line.find(delimiter) + 1);
		//Assign the node in the array at index i to the name.
		maze.nodeArray[i] -> setNodeName(name);

		//For each "door", assign a node.
		int j = 0;
		while (line != "" && line != " " && j < 4)
		{
			//If it is the last node in the array, set it and break.
			if (line.find(delimiter) == -1)
			{
				connectedNode = line.substr(0, line.find(delimiter));
				line = line.substr(line.find(delimiter) + 1);
				maze.nodeArray[i] -> attachNewNode(maze.nodeArray[maze.numberOfNodes], j);
				break;
			}

			//************CHANGE ATTACHNEWNODE TO PRINT FOR TESTING***************.

			//Set the node in the array, modify the substring, and increment j.
			connectedNode = line.substr(0, line.find(delimiter));
			line = line.substr(line.find(delimiter) + 1);
			maze.nodeArray[i] -> attachNewNode(maze.nodeArray[maze.numberOfNodes], j);
			j++;
		}
	}
}


//Constructor: Node()
//Description: Sets the initial 4 variables to null (one for each "door").

Node::Node()
{
	for (int i = 0; i < 4; i++)
	{
		attachedNodes[i] = NULL;
	}
}

//Constructor: Node()
//Description: Sets the initial 4 variables to null (one for each "door")
//  		   and sets the name of the current node.

Node::Node(string newname)
{
	name = newname;

	for (int i = 0; i < 4; i++)
	{
		attachedNodes[i] = NULL;
	}
}

//Function: setNodeName
//Description: Assigns the name of the node that is being passed 
//             to the function (newname) to the variable (name).

void Node::setNodeName(string newname)
{
	name = newname;
}

//Function: getName
//Description: Returns the name of the node.

string Node::getNodeName()
{
	return name;
}

//Function: attachNewNode
//Description: Attaches a node to the current 
//             node in the specified index.

void Node::attachNewNode(Node *newNode, int index)
{
	attachedNodes[index] = newNode;
}

//Function: getAttachedNode
//Description: Returns the node that is attached to the 
//             current node by the index that is being 
//             passed to the function.

Node* Node::getAttachedNode(int index)
{
	return attachedNodes[index];
}

//Function: sleep
//Description: Suspends all operations for a duration of 
//			   three seconds.

void Menu::sleep()
{
	//Delays the closing of the window to allow the user to read the goodbye message.
	time_t start_time;
	time_t current_time;

	time(&start_time);
	do
	{
		time(&current_time);
	} while ((current_time - start_time) < 3);
}