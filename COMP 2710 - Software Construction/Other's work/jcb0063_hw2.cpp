/*
Program:	Homework 2
Name:		James Bass
UserID:		jcb0063
StudentID#:	902519165
Class:		COMP 2710
Date:		November 14th, 2014
E-Mail:     jcb0063@tigermail.auburn.edu

Description: The program that will register and record the ownership of vehicles. The vehicles can
be of type truck, car, or sportscar. It will allow the owner and vehicle information to be entered and
stored. The program will then allow the owner and vehicle information to be retrieved
later. 
The program allows the user to: 
	   1. Print all the owners (and all related information) and their vehicles (and all
		  related information)
	   2. Print a particular owner (by name), all the owner’s related information and their
		  vehicles (and all their related information)
	   3. Print all the vehicles (and all related information) and their owners
	   4. Print all the vehicles (and their owners) of a specific type, e.g. sportscar.

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
#include <unordered_map>

using namespace std;

class Person {
public:
	//constructors
	Person();
	Person(string the_name);
	Person(string the_name, string the_address);
	Person(const Person& the_object);
	//information functions
	string get_name() const;
	void set_name(string the_name);
	string get_address() const;
	void set_address(string the_address);

	Person& operator = (const Person& rt_side);

private:
	//information variables
	string name;
	string address;
};

//Class: Vehicle, base class
//Description: All vehicle-like objects derive from this class
class Vehicle {
public:
	Vehicle();
	Vehicle(string manNameIN, int numCyIN);
	Vehicle(string manNameIN, int numCyIN, Person* ownerIN);

	string getManName();
	void setManName(string nameIN);

	int getCyNum();
	void setCyNum(int numIN);

	Person getOwner();
	void setOwner(Person* ownerIN);
private:
	string manufactureName;
	int numCylinders;
	Person owner;
};

//Class: Car, derived from Vehicle
//Description: This class is for car objects
class Car : public Vehicle{
public:
	Car();
	Car(const string& manNameIN, const int& numCyIN, int doorNumIN, int engineSizeIN) : Vehicle(manNameIN, numCyIN){}
	Car(const string& manNameIN, const int& numCyIN,  Person*& ownerIN, int doorNumIN, int engineSizeIN) : Vehicle(manNameIN, numCyIN, ownerIN){}

	int getDoorNum();
	void setDoorNum(int numIN);

	int getEngineSize();
	void setEngineSize(int sizeIN);

private:
	int doorNum;
	int engineSize;
};

//Class: SportsCar, derived from Car
//Description: This class is for sports car objects
class SportsCar : public Car{
public:
	SportsCar();
	SportsCar(const string& manNameIN, const int& numCyIN,
		int doorNumIN, int engineSizeIN, bool sunroofIN, bool topPopIN) : Car(manNameIN,  numCyIN,  doorNumIN,  engineSizeIN){}
	SportsCar(const string& manNameIN, const int& numCyIN,  Person*& ownerIN,
		int doorNumIN, int engineSizeIN, bool sunroofIN, bool topPopIN) : Car(manNameIN, numCyIN, ownerIN, doorNumIN, engineSizeIN){}


	bool getSunroof();
	void setSunroof(bool valueIN);

	bool getTopPop();
	void setTopPop(bool valueIN);

private:
	bool sunroofPresent;
	bool topPop;
};

//Class: Truck, derived from Vehicle
//Description: This class is for truck objects
class Truck : public Vehicle {
public:
	Truck();
	Truck(const string& manNameIN, const int& numCyIN,
		double loadCap, int towCap) : Vehicle(manNameIN, numCyIN){}
	Truck(const string& manNameIN, const int& numCyIN,  Person*& ownerIN,
		double loadCap, int towCap) : Vehicle(manNameIN, numCyIN, ownerIN){}


	double getLoadCap();
	void setLoadCap(double numIN);

	int getTowCap();
	void setTowCap(int numIN);

private:
	double loadCapacity;
	int towingCapacity;
};

//Class: System
//Description: This class is responsible for managing the main operations
//             of the program.
class System {
public:
	//functions
	void createPerson();
	void createVehicle();
	void runProgram();
	void sleep(float s);
	//variables
	unordered_map<string, Person*> owners;
	unordered_map<int, Vehicle> vehicles;
	unordered_map<int, SportsCar> sportsCars;
	unordered_map<int, Car> cars;
	unordered_map<int, Truck> trucks;
	int vehiclesMade = 0;
	int sportsCarsMade = 0;
	int carsMade = 0;
	int trucksMade = 0;
};

//Class: Menu
//Description: This class gives the user a menu to select which functions to run
class Menu {
public:
	bool createMenu();
	bool printMenu();
};


//Function: main
//Description: This the driver function for the program. Is calls the run function.
int main() {
	System system;
	system.runProgram();
}

//Function: runProgram
//Description: This is the actual function which runs the lab3 maze solver
void System::runProgram(){
	//Initializations
	Menu menuObj;
	string input, fileName;

	//Welcome the user
	cout << "\n        ===========================================================" << endl;
	cout << "        |           Welcome to the Homework 2 Program!            |" << endl;
	cout << "        ===========================================================\n" << endl;

	//Run the Program
	while (true) {

		bool quitProgram = menuObj.createMenu(); 

		if (quitProgram){
			//End of program, print msg and wait 3 seconds to allow user to read the message.
			cout << "\n        ========================================================" << endl;
			cout << "        |          Thank you for running the program!          |" << endl;
			cout << "        ========================================================\n" << endl;
			sleep(3);
			break;
		}
	}
}
bool Menu::createMenu(){

	bool quit = false;;

	//display the menu to create objects
	cout << "(1) Create new owner.\n";
	cout << "(2) Create new vehicle.\n";
	cout << "(3) Go to the print menu.\n";
	cout << "\nEnter the number of the function you wish to use.\n";
	cout << "Selection: ";
	int input;
	cin >> input;
	switch (input) {
	case 1:
		//  1. Create new owner
		break;
	case 2:
		//	2. Create new vehicle
		break;
	case 3:
		// Display print menu
		cout << endl;
		quit = printMenu();
		break;
		
	default:
		cout << "\n       Your input was invalid. Try again.\n";
		break;
	}

	return quit;
}

bool Menu::printMenu(){
	bool quit = false;;


	//Display the menu to print objects
	cout << "(1) Print all owners and their vehicles.\n";
	cout << "(2) Print a particular owner's name, info, and vehicle(s) info.\n";
	cout << "(3) Print all the vehicles info and their owners.\n";
	cout << "(4) Print all vehicles info and owners by type.\n";
	cout << "(5) Go to the create menu.\n";
	cout << "(6) Quit.\n";
	cout << "\nEnter the number of the function you wish to use.\n";
	cout << "Selection: ";
	int input;
	cin >> input;
	switch (input) {
	case 1:          
		//  1. Print all the owners(and all related information) and their vehicles(and all
		//	   related information)

		break;
	case 2:       
		//	2. Print a particular owner(by name), all the owner’s related information and their
		//	   vehicles(and all their related information)
		break;
	case 3:            
		//	3. Print all the vehicles(and all related information) and their owners.

		break;
	case 4:
		//	4. Print all the vehicles(and their owners) of a specific type, e.g.sportscar.

		break;
	case 5:
		cout << endl;
		 quit = createMenu();
	case 6:
		//Quit the program
		quit = true;
		break;
	default:        
		cout << "\n       Your input was invalid. Try again.\n";
		break;
	}

	return quit;
}

void System::createPerson(){
	string name, address;
	cout << "Enter the person's name.\n";
	cout << "name: ";
	getline(cin, name);
	cout << "Enter the person's address.\n";
	cout << "address: ";
	getline(cin, address);
	Person* newPerson = new Person(name, address);
	owners.emplace(name, newPerson);

}

void System::createVehicle(){
	string make, owner, check;
	int cyl, choice, tow, doors, engine;
	Person* ownerObj;
	double load;
	bool sunroof, convert;
	cout << "What type of vehicle would you like to create?\n ";
	cout << "(1) Truck\n";
	cout << "(2) Car\n";
	cout << "(3) SportsCar\n";
	cout << "type: ";
	cin >> choice;
	if (choice > 0 && choice < 4)
	{
		//Take input to build vehicle.
		cout << "Enter the manufacturer's name.\n";
		cout << "Manufacturer's name: ";
		getline(cin, make);
		cout << "Enter the number of cylinders.\n";
		cout << "Number of cylinders: ";
		cin >> cyl;
		cout << "Enter the owner's name.\n";
		cout << "owner's name: ";
		getline(cin, owner);
		ownerObj = owners.at(owner);
		Vehicle* newVehicle = new Vehicle(make, cyl, ownerObj);
		vehicles.emplace(vehiclesMade, newVehicle);
		vehiclesMade++;
		if (choice == 1)
		{
			cout << "Enter the load Capacity.\n";
			cout << "Load capacity: ";
			cin >> load;
			cout << "\nEnter the towing capacity.\n";
			cout << "Towing Capacity: ";
			cin >> tow;
			Truck* newTruck = new Truck(make, cyl, ownerObj, load, tow);
			trucks.emplace(trucksMade, newTruck);
			trucksMade++;
		}
		else
		{
			cout << "\nEnter the number of doors.\n";
			cout << "Number of doors: ";
			cin >> doors;
			cout << "\nEnter the size of the engine.\n";
			cout << "Engine size: ";
			cin >> engine;
			Car* newCar = new Car(make, cyl, ownerObj, doors, engine);
			cars.emplace(carsMade, newCar);
			if (choice == 3)
			{
				cout << "Does this sportscar have a sunroof?\n";
				cout << "sunroof?: ";
				getline(cin, check);
				if (check == "yes")
				{
					sunroof = true;
				}
				cout << "Can you pop the top on this sportscar?\n";
				cout << "pop top?: ";
				getline(cin, check);
				if (check == "yes")
				{
					convert = true;
				}
				SportsCar* newSportsCar = new SportsCar(make, cyl, ownerObj, doors, engine, sunroof, convert);
				sportsCars.emplace(sportsCarsMade, newSportsCar);
			}

		}
	}
	else
	{
		createVehicle();
	}
}
void System::sleep(float s){
	//Delays the closing of the window to allow the user to read the goodbye message. 
	time_t start_time, current_time;
	time(&start_time);
	do {
		time(&current_time);
	} while ((current_time - start_time) < s);
}