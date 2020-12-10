#include <string>
#include <iostream>
#include <fstream>
#include <vector>
#include <sstream>
using namespace std;

/*
* Node class
* Used to maintain nodes.
*/
class Node {
public:
   Node();
   Node(string);
   Node(const Node& the_node);
   void setNodeName(string);
   string getNodeName();
   void attachNewNode(Node *newNode, int);
   Node *getAttachedNode(int);
   int getNumberUsed();
   int setNumberUsed(int);
   void setPrevious(Node &previousNode);
   Node *getPrevious();
   int setMarked();
   int getMarked();
private:
   string name;
   Node *attachedNodes[4];
   int numberUsed;
   Node *previous;
   int marked;
};

/*
* Solver class
* Provides functionality to maintain the graph of nodes,
* and functions to perfrom breadth first search on it.
*/
class Solver : public Node {
public:
   int setnumOfNodes(int);
   int getnumOfNodes();

   int setFile(string);
   string getFile();

   int setStartNode(string);
   string getStartNode();

   int setEndNode(string);
   string getEndNode();

   void getFileName();
   Node* getFileInfo();
   void travesrse(Node[]);
private:
   int numOfNodes;
   string file;
   string startNode;
   string endNode;
};

/*
* Error class
* Maintains functions to display errors.
*/
class Error {
public:
   void noFileExists();
};

/*****Begin Node Definitions*****/

/*
* Default constructor for Node class.
*/
Node::Node() {
   name = "";
   numberUsed = 0;
   Node *previous = NULL;
   marked = 0;
   for (int i = 0; i < 4; i++) {
      attachedNodes[i] = NULL;
   }
}

/*
* Constructor for naming a node.
*/
Node::Node(string newname) {
   name = newname;
   numberUsed = 0;
   Node *previous = NULL;
   marked = 0;
   for (int i = 0; i < 4; i++) {
      attachedNodes[i] = NULL;
   }
}

/*
* Copy constructor for Node.
*/
Node::Node(const Node& the_node) {
   name = the_node.name;
   attachedNodes[4] = the_node.attachedNodes[4];
   numberUsed = the_node.numberUsed;
   previous = the_node.previous;
   marked = the_node.marked;
}

/*
* Function: setNodeName(string)
* Class: Node
* Description: Sets the node name for any given node.
*/
void Node::setNodeName(string newname) {
   name = newname;
}

/*
* Function: attatchNewNode(Node *newNode, int)
* Class: Node
* Description: Attaches a new node at the given index.
*/
void Node::attachNewNode(Node *newNode, int index) {
   attachedNodes[index] = newNode;
}

/*
* Function: *getAttachedNode(int)
* Class: Node
* Description: Returns the attached node at the given index.
*/
Node* Node::getAttachedNode(int index) {
   return attachedNodes[index];
}


/*
* Function: getNumberUsed()
* Class: Node
* Description: Returns the number of sides used by a node.
*/
int Node::getNumberUsed() {
   return numberUsed;
}

/*
* Function: setNumberUsed(int)
* Class: Node
* Description: Sets the number of sides used by a node.
*/
int Node::setNumberUsed(int newNumberUsed) {
   numberUsed = newNumberUsed;
   return 0;
}

/*
* Function: setPrevious(Node *previousNode);
* Class: Node
* Description: Sets the previous node of another node.
*/
void Node::setPrevious(Node &newPrevious) {
   previous = &newPrevious;
}

/*
* Function: setMarked()
* Class: Node
* Description: Sets a given node as marked or unmarked.
*/
int Node::setMarked() {
   marked++;
   return 0;
}

/*
* Function getMarked()
* Class: Node
* Description: Returns the marked value.
*/
int Node::getMarked() {
   return marked;
}

/*
* Function: *getPrevious()
* Class: Node
* Description: Gets the previous node of any node.
*/
Node* Node::getPrevious() {
   return previous;
}

/*
* Function: getNodeName()
* Class: Node
* Returns the name of a given node.
*/
string Node::getNodeName() {
   return name;
}

/*****End Node Definitions*****/

/*****Begin Solver Definitions*****/

/**
* Function: setFile(string)
* Class: Solver
* Description: Sets the file name.
*/

int Solver::setFile(string fileIn) {
   file = fileIn;
   return 0;
}

/**
* Function: getFile()
* Class: Solver
* Description: Gets the file name.
*/
string Solver::getFile() {
   return file;
}

/*
* Function: setNumOfNodes(int)
* Class: Solver
* Description: Sets the total number of nodes.
*/
int Solver::setnumOfNodes(int newNumOfNodes) {
   numOfNodes = newNumOfNodes;
   return 0;
}

/*
* Function: getNumOfNodes(int)
* Class: Solver
* Description: Returns the total number of nodes.
*/
int Solver::getnumOfNodes() {
   return numOfNodes;
}

/*
* Function: setStartNode(string)
* Class: Solver
* Description: Sets the starting node.
*/
int Solver::setStartNode(string newStartNode) {
   startNode = newStartNode;
   return 0;
}

/*
* Function: getStartNode()
* Class: Solver
* Description: Gets the starting node.
*/
string Solver::getStartNode() {
   return startNode;
}

/*
* Function: setEndNode(string)
* Class: Solver
* Description: Sets the ending node.
*/
int Solver::setEndNode(string newEndNode) {
   endNode = newEndNode;
   return 0;
}

/*
* Function: getEndNode()
* Class: Solver
* Description: Gets the ending node.
*/
string Solver::getEndNode() {
   return endNode;
}

/*
* Function: getFile()
* Class: Solver
* Description: Gets the file name from the user.
*/
void Solver::getFileName() {
   string fileIn;
   bool validFile = false;

	// check if file exists
   while (!validFile) {
      cout << endl << endl << "Enter the name of the Maze configuration file: ";
      getline(cin, fileIn);
      if (fileIn == "Quit") {
         break;
      }
      ifstream ifile(fileIn.c_str());
      if (!ifile) {
         cout << "\t--That file does not exist." << endl;
      }
      else {
         validFile = true;
      }
   }

	// set file
   setFile(fileIn);
}

/*
* Function: getFileInfo()
* Class: Solver
* Description: Reads information about a node graph from a given
*              configuration file.
*/
Node* Solver::getFileInfo() {
	/*****Variables*****/
   string numNodesUserIn;
   string line;
   string nameIn;
   string attachedNodeNameIn;
   string next;
   string t;
   int nodesAdded = 0;
   Node* firstNode;
   ifstream inStream;

   inStream.open(getFile().c_str());
	//grab the top 3 lines, the number of nodes, the start and end nodes
   inStream >> numOfNodes;								//Get numOfNodes
   inStream >> startNode;							//Get starting node
   inStream >> endNode;							//Get destination node
	//Debugging output, not actual
   //cout << "      #Nodes: " << numOfNodes << endl;
   //cout << "       Start: " << startNode << endl;
   //cout << " Destination: " << endNode << endl << endl;

	// initalize dynamic array of nodes
   Node* nodeArray = NULL;
   nodeArray = new Node[numOfNodes];

	//Read in nodes up to the number of nodes given
   for (int i = 0; i < numOfNodes; i++){
     // get firstNode
      inStream >> nameIn;
      firstNode = new Node(nameIn);
   
     // get rest of nodes, these will be attached to first node
      getline(inStream, line);
      istringstream inStringStream(line);
      int index = 0;
      while (inStringStream >> attachedNodeNameIn) {
         Node *attachedNode = new Node(attachedNodeNameIn);
         firstNode->attachNewNode(attachedNode, index);
         firstNode->setNumberUsed(index++);
      }
   
    //// loop through nodeArray
    // for (int j = 0; j < nodesAdded; j++) {
    // // loop through each nodes attachedNodes
    //    for (int k = 0; k < 4; k++) {
    //     // point to that value
    //       Node* testNode = nodeArray[j].getAttachedNode(k);
    //    // if null, do nothing does not need to be set
    //       if (testNode == NULL) {
    //       
    //       }
    //       // if that node is the same as this node, set it at that index
    //       else {
    //          if (testNode->getNodeName() == firstNode->getNodeName()) {
    //             nodeArray[j].attachNewNode(firstNode, k);
    //          }
    //       }
    //    }
    // }
   
   
    //PLACE INTO nodeArray
      nodeArray[nodesAdded++] = *firstNode;
   }
   return nodeArray;
}


/*
* Function: Traverse
* Class: Solver
* Description:
*/

void Solver::travesrse(Node* nodeArrayIn) {
   vector<string> visited;
   vector<Node*> sides;
   vector<string> returnedTemp;
   vector<string> returned;
   Node *startNode;
   Node *endNode;
   Node *currentNode;
   Node *currentAttachedNode;

   string startNodeName;
   string endNodeName;

   for (int i = 0; i < getnumOfNodes(); i++) {
      if (nodeArrayIn[i].getNodeName() == getStartNode()) {
         startNode = &nodeArrayIn[i];
         startNodeName = startNode->getNodeName();
      }
      if (nodeArrayIn[i].getNodeName() == getEndNode()) {
         endNode = &nodeArrayIn[i];
         endNodeName = endNode->getNodeName();
      }
   }

   cout << "The Start Node is: " << getStartNode() << endl;
   cout << "The destination Node is: " << getEndNode() << endl;
   cout << "Finding the shortest path from the Start to Destination node ..." << endl;
   cout << "Node visited: ";

	// create a queue q
   vector<Node*> queue;

	// enqueue start node onto q
   queue.push_back(startNode);
	// mark start node

   queue[0]->setMarked();
   visited.push_back(getStartNode());

	// for each node n
   for (int i = 0; i < getnumOfNodes(); i++) {
   
   // while q is not empty
      while (queue.size() > 0) {
      
      // dequeue from q into n
         currentNode = queue[0];
         queue.erase(queue.begin());
         cout << currentNode->getNodeName() << " ";
      
         if (currentNode->getNodeName() == endNodeName) {
            cout << endl << "Congratulations: Found the shortest path successfully." << endl;
            cout << "The path is: ";
            while (currentNode != NULL) {
               returned.insert(returned.begin(), currentNode->getNodeName());
               currentNode = currentNode->getPrevious();
            }
         
            for (vector<string>::iterator itr = returned.begin(); itr != returned.end(); itr++) {
               cout << *itr << " ";
            }
         
            return;
         }
      
      // for each connection of n
         for (int i = 0; i < currentNode->getNumberUsed() + 1; i++) {
         
         // let m be the connection
            currentAttachedNode = currentNode->getAttachedNode(i);
            for (int i = 0; i < numOfNodes; i++) {
               if (nodeArrayIn[i].getNodeName() == currentAttachedNode->getNodeName()) {
                  currentAttachedNode = &nodeArrayIn[i];
                  break;
               }
            }
         
         // if m is not marked
            if (currentAttachedNode->getMarked() == 0) {
            // mark m
               currentAttachedNode->setMarked();
            // set m.previous equal to n
               currentAttachedNode->setPrevious(*(currentNode));
            // enqueue m onto q
               queue.push_back(currentAttachedNode);
            //cout << currentAttachedNode->getNodeName() << " ";
            //visited.push_back(currentAttachedNode->getNodeName());
            }
         
         }
      }
   }

   cout << endl << "Unsuccessful: No path can be found.";
}

/*****End Solver Definitions*****/

/*****Begin Main Definition*****/
int main() {
	// display header
   cout << "\t===========================================================" << endl;
   cout << "\t|        Welcome to the Shortest Path Maze Solver!        |" << endl;
   cout << "\t===========================================================" << endl;

	// create solver object
   Solver run;
   Node* nodeArray = NULL;

   while (1) {
      run.getFileName();
      if (run.getFile() == "Quit") {
         cout << endl << "\t===========================================================" << endl;
         cout << "\t|   Thank you for using the Shortest Path Maze Solver!    |" << endl;
         cout << "\t===========================================================";
         return 0;
      }
      nodeArray = run.getFileInfo();
      run.travesrse(nodeArray);
      delete[] nodeArray;
   }

}
/*****End Main Definition*****/