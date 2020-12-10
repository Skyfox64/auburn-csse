/*
Program:	Lab 3
Name:		John Carroll
UserID:		jcc0044
StudentID#:	902521946
Class:		COMP 2710
Date:		November 10th, 2014
E-Mail:     jcc0044@tigermail.auburn.edu

Description: This program prompts the user for a graph configuration file(.txt). From it
			 the program will construct the graph, then traverse it, finding the shortest
			 path possible. It will return data regarding the traversal.
Compile Instructions:
1)	Change current directory to correct directory which contains the .cpp using command: “cd”
2)	To compile:
	a.	type "g++ hw1.cpp -o hw1" in a terminal window to create hw1 executable file;
		re-executing this will update the hw1 file
		______________________________________________________________________

		*NOTE* Assuming you are invoking g++ from the linux terminal, use:
		"$ g++ -std=c++11 your_file.cpp -o your_program"
							or
		"$ g++ -std=c++0x your_file.cpp -o your_program"
		______________________________________________________________________

	b.	type "g++ hw1.cpp" to create and update the a.out with the latest code
	c.	type "./a.out" or “./hw1” to run the program
*/

#include <string>
#include <iostream>
#include <fstream>
#include <sstream>
#include <vector>
#include <cstring>
#include <cstdlib>
#include <vector>
#include <algorithm>
#include <limits>
#include <iterator>
#include <time.h> 

using namespace std;

//Class: System
//Description: This class runs the program
class System {
public: 
	void runProgram();
	void sleep(float s)	{
		//Delays the closing of the window to allow the user to read the goodbye message. 
		time_t start_time, current_time;
		time(&start_time);
		do { 
			time(&current_time);
		} while ((current_time - start_time) < s);
	}
};
//Class: Node
//Description: The functions and attributes specific to a Node
class Node {
public:
	Node(string newname);							//Constuctors
	Node();

	void setNodeName(string newname);				//set Node Name
	string getNodeName();							//get Node Name

	void attachNewNode(Node *newNode, int index);	//Attach Node ptr
	Node *getAttachedNode(int index);				//get attached node ptr
		
	int setNumberUsed(int newNumberUsed);			//set Number of nodes used
	int getNumberUsed();							//get Number of nodes used
		
	void setPrevious(Node *previousNode);			//set previous node
	Node *getPrevious();							//get previous node
		
	int setMarked();								//set node as marked
	int getMarked();								//get if node is marked

private:
	string name;									//Node Name
	Node *attachedNodes[4];							//Up to 4, either attached or null
	Node *previous;									//Mem Address of Previous node
	int numberUsed;									//Number of attachments
	int marked;										//Is set if node is marked
};
//Class: BFSMazeSolver
//Description: The breadth-first search maze solver which finds the
//				shortest path to solve the maze.
class BFSMazeSolver {
public:
	void constructMaze();			//build graph into data structure
	void traverseMaze();			//use BFS to traverse the maze

	int numOfNodes;					//Number of nodes
	string startingPoint;			//Starting node
	string destinationPoint;		//Objective node

	typedef Node* NodePTR;
	NodePTR nodeArray;				//All Nodes
	string currentGraphConfigFile;	//The Current Graph configuration file
};

//Function: main
//Description: This the driver function for the program. Is calls the run function.
int main() {
	System system;
	system.runProgram(); //Run the BFS maze solving program
}

//Function: runProgram
//Description: This is the actual function which runs the lab3 maze solver
void System::runProgram(){
	//Initializations
	BFSMazeSolver mazeSolver; // Maze Solver object
	string fileNameInput, fileName;

	//Welcome the user
		cout << "\n        ===========================================================" << endl;
		cout << "        |         Welcome to the Shortest Path Maze Solver!       |" << endl;
		cout << "        ===========================================================\n" << endl;

	//Run the Programe
	while (true) {
		//Prompt user for file name
		cout << "\nEnter the name of the Maze configuration file: ";
		getline(cin, fileNameInput);
		mazeSolver.currentGraphConfigFile = fileNameInput + ".txt";

		ifstream my_file(mazeSolver.currentGraphConfigFile);
		if (fileNameInput == "Quit"){
			//End of program, print msg and wait 5 seconds to allow user to read the message.
			cout << "\n        ========================================================" << endl;
			cout << "        |   Thank you for using the Shortest Path Maze Solver! |" << endl;
			cout << "        ========================================================\n" << endl;
			sleep(5);
			break;
		}
		//If the filename.txt exists
		else if (my_file.good()) {
			//get nodes, build array/graph
			mazeSolver.constructMaze();
			//perform BFS - traverse the maze
			mazeSolver.traverseMaze();			

			delete[] mazeSolver.nodeArray; //Destroy the dynamic array
			mazeSolver.nodeArray = NULL;   //Point it to NULL
		}
		else {
			//Invalid entry/file not found
			cout << "\n       Your input was invalid. Try again.\n";
			continue;
		}
	}
}
//Constructor: Node()
//Description: Sets the initial variables to null.
Node::Node(){
	name = "";
	marked = 0;	
	numberUsed = 0;
	Node *previous = NULL;

	attachedNodes[0] = NULL;
	attachedNodes[1] = NULL;
	attachedNodes[2] = NULL;
	attachedNodes[3] = NULL;
}

//Constructor: Node()
//Description: Sets the initial variables to null and sets the name of the current node.
Node::Node(string newNameIn){
	name = newNameIn;
	marked = 0;
	numberUsed = 0;
	Node *previous = NULL;

	attachedNodes[0] = NULL;
	attachedNodes[1] = NULL;
	attachedNodes[2] = NULL;
	attachedNodes[3] = NULL;
}
//Function: setNodeName
//Description: sets the name of the node to 
//             the variable that is being passed 
//             to the function.
void Node::setNodeName(string newNameIn){
	name = newNameIn;
}

//Function: getName
//Description: returns the name of the node.
string Node::getNodeName(){
	return name;
}

//Function: attachNewNode
//Description: attaches a node to the current 
//             node in the correct direction
//				Takes in pointer to a node and and index
void Node::attachNewNode(Node *newNode, int indexIn){
	attachedNodes[indexIn] = newNode;
}

//Function: getAttachedNode
//Description: returns the node that is attached to the 
//             current node in the direction that is being 
//             passed to the function.
Node* Node::getAttachedNode(int indexIn){
	return attachedNodes[indexIn];
}

//Function: setNumberUsed
//Description: sets the number of possible attached nodes
//				to be the parameter. Max = 4
int Node::setNumberUsed(int numberUsedIn) {
	numberUsed = numberUsedIn;
	return 0;
}

//Function: getNumberUsed
//Description: returns the number of possible attached nodes
int Node::getNumberUsed() {
	return numberUsed;
}

//Function: setPrevious
//Description: sets the previous to point to the parameter
void Node::setPrevious(Node *newPrevious) {
	previous = newPrevious;
}

//Function: getPrevious
//Description: gets the previous node
Node* Node::getPrevious() {
	return previous;
}

//Function: setMarked
//Description: Sets the node as marked
int Node::setMarked() {
	marked = 1;
	return 0;
}

//Function: getMarked
//Description: gets the node's marked status
int Node::getMarked() {
	return marked;
}

//Function: constructMaze
//Description: Reads in the configuration file's data
//				Creates the graph from it.
void BFSMazeSolver::constructMaze(){
	string numNodesUserIn, line, nameIn, attachedNodeNameIn;
	ifstream infile;

	infile.open(currentGraphConfigFile);
	//grab the top 3 lines, the number of nodes, the start and end nodes
	infile >> numOfNodes;								//Get numOfNodes
	infile >> startingPoint;							//Get starting node
	infile >> destinationPoint;							//Get destination node
	//Debugging output, not actual
	//cout << "      #Nodes: " << numOfNodes << endl;
	//cout << "       Start: " << startingPoint << endl;
	//cout << " Destination: " << destinationPoint << endl << endl;

	// initalize dynamic array of nodes
	nodeArray = new Node[numOfNodes];

	//Read in nodes up to the number of nodes given
	for (int i = 0; i < numOfNodes; i++){
		//get THE node
		infile >> nameIn;		
		Node* newNode = new Node(nameIn);	//Make Node		
		//out << "Node: " << nameIn << "   Attached:";

		//get nodes attached to THE node
		getline(infile, line); 
		istringstream iss(line);
		int j = 0;
		while(iss >> attachedNodeNameIn){
			//Create Node POINTER
			Node *attachedNode = new Node(attachedNodeNameIn);
			if (attachedNode == NULL) {
				cout << "Error: Insufficient memory.\n";
			    exit(1);
			}
			newNode->attachNewNode(attachedNode, j);
			//cout << ' ' << attachedNodeNameIn << ' ';
			newNode->setNumberUsed(j++); //Num used, excluding NULL
		}		

		// get rest of nodes, these will be attached to first node

		//PLACE INTO nodeArray
		nodeArray[i] = *newNode;

		//cout << endl; //Debug output: endl, drop a line
	}

	//for (int i = 0; i < numOfNodes; i++){
	//	Node testNode = nodeArray[i];
	//	cout << testNode.getNodeName() << endl;
	//}

	//cout << "\n\n\n\n" << endl;
}

//Function: traverseMaze
//Description: Traverses the graph.
//				Finds the shortest path, logs where it has searched
//				using Breadth-First Search, outputs data.
void BFSMazeSolver::traverseMaze(){
	vector<string> shortestPath;
	Node *startNode, *endNode;
	Node *currentNode, *currentAttachedNode;

	string startNodeName;
	string endNodeName;

	for (int i = 0; i < numOfNodes; i++) {
		if (nodeArray[i].getNodeName() == startingPoint) {
			startNode = &nodeArray[i];
			startNodeName = startNode->getNodeName();
		}
		if (nodeArray[i].getNodeName() == destinationPoint) {
			endNode = &nodeArray[i];
			endNodeName = endNode->getNodeName();
		}
	}

	cout << "The Start Node is: " << startingPoint << endl;
	cout << "The destination Node is: " << destinationPoint << endl;
	cout << "Finding the shortest path from the Start to Destination node ..." << endl;
	cout << "Node visited: ";

	//4 create a queue Q
	vector<Node*> queue;

	//5 enqueue start node onto Q
	queue.push_back(startNode); //enQ

	//6 mark start node
	queue[0]->setMarked();

	// for each node n
	for (int i = 0; i < numOfNodes; i++) {

		//7 while Q is not empty :
		while (queue.size() > 0) {
			//8	dequeue an item from Q into n
			currentNode = (queue[0]);
			queue.erase(queue.begin());	//deQ
			cout << currentNode->getNodeName() << " "; //Print visited Node

			if (currentNode->getNodeName() == endNodeName) {
				cout << endl << "Congratulations: Found the shortest path successfully." << endl;
				cout << "The path is: ";
				while (currentNode != NULL) {
					shortestPath.insert(shortestPath.begin(), currentNode->getNodeName());
					currentNode = currentNode->getPrevious();
				}
				for (vector<string>::iterator itr = shortestPath.begin(); itr != shortestPath.end(); itr++) {
					cout << *itr << " ";
				}

				cout << endl;
				return;
			}

			// 9 for each connection of n
			for (int i = 0; i < currentNode->getNumberUsed() + 1; i++) {

				// let m be the connection
				currentAttachedNode = currentNode->getAttachedNode(i);
				for (int i = 0; i < numOfNodes; i++) {
					if (nodeArray[i].getNodeName() == currentAttachedNode->getNodeName()) {
						currentAttachedNode = &nodeArray[i];
						break;
					}
				}
				//11 if m is not marked :
				if (currentAttachedNode->getMarked() == 0) {
					// 12 mark m
					currentAttachedNode->setMarked();
					// 13 set m.previous equal to n
					currentAttachedNode->setPrevious(currentNode);
					// 14 enqueue m onto q
					queue.push_back(currentAttachedNode);
				}
			}
		}
	}

	cout << endl << "Unsuccessful: No path can be found." << endl;

}
	