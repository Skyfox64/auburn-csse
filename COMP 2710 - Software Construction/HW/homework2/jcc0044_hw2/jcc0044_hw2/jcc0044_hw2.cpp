/*
Program:	Homework 2
Name:		John Carroll
UserID:		jcc0044
StudentID#:	902521946
Class:		COMP 2710
Date:		November 14th, 2014
E-Mail:     jcc0044@tigermail.auburn.edu

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
	   5. Create vehicles and p[lace owner info into the system.
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
#include <map>
#include <time.h> 

using namespace std;

class Person {
public:
	Person();
	Person(string the_name);
	Person(string the_name, string the_address);
	Person(const Person& the_object);

	string get_name() const;
	void set_name(string the_name);

	string get_address() const;
	void set_address(string the_address);

	Person& operator = (const Person& rt_side);
	bool operator == (const Person& rt_side);        

	virtual void printInfo() const;                       
	
private:
	string ownerName;
	string ownerAddress;
};

//Class: Vehicle, base class
//Description: All vehicle-like objects derive from this class
class Vehicle {
public:	
	Vehicle();
	Vehicle(const Vehicle& objectIn);
	Vehicle(string manNameIn, int numCyIn, Person ownerIn);

	string getManufacturerName();
	void setManufacturerName(string nameIn);

	int getCylinderNum();
	void setCylinderNum(int numIn);

	Person* getOwner();
	void setOwner(Person &ownerIn);

	Vehicle& operator = (const Vehicle& rt_Side);				
	virtual void printInfo();									

private:
	string manufacturerName;
	int numCylinders;
	Person* owner;
};

//Class: Car, derived from Vehicle
//Description: This class is for car objects
class Car : public Vehicle{
public:
	Car();
	Car(int doorsIn, int engineSizeIn);

	int getDoorNum();
	void setDoorNum(int numIn);

	int getEngineSize();
	void setEngineSize(int sizeIn);

	Car& operator = (const Car& rt_side);
	virtual void printInfo();

private:
	int doorNum;
	int engineSize;
};

//Class: SportsCar, derived from Car
//Description: This class is for sports car objects
class SportsCar : public Car{
public:
	SportsCar();
	SportsCar(bool sunroofIn, bool convertibleIn);
	
	bool getSunroof();
	void setSunroof(bool valueIn);

	bool getConvertible();
	void setConvertible(bool valueIn);
	
	SportsCar& operator = (const SportsCar& rt_side);
	virtual void printInfo();

private:
	bool sunroof;
	bool convertible;
};

//Class: Truck, derived from Vehicle
//Description: This class is for truck objects
class Truck : public Vehicle {
public:
	Truck();													
	Truck(double the_loadCap, int the_towCap);

	double getLoadCap();
	void setLoadCap(double numIn);

	int getTowCap();
	void setTowCap(int numIn);

	Truck& operator = (const Truck& rt_side);
	virtual void printInfo();									

private:
	double loadCapacity;
	int towingCapacity;
};

//Class: System
//Description: This class is responsible for managing the main operations
//             of the program.
class System {
public:
	void runProgram();			   	
	
	void printCase1();
	void printCase2();	
	void printCase3();
	void printCase4();						
					

	void createTruck();
	void createCar();
	void createSportsCar();

	bool existingOwner(string);
	bool ownsTrucks(string);
	bool ownsCars(string);
	bool ownsSportsCars(string);
			
	void sleep(float s)	{
		//Delays the closing of the window to allow the user to read the goodbye message. 
		time_t start_time, current_time;
		time(&start_time);
		do {
			time(&current_time);
		} while ((current_time - start_time) < s);
	}

private:
	vector<Person> validOwners;
	map<string, vector<Car> > cars;
	map<string, vector<SportsCar> > sportsCars;
	map<string, vector<Truck> > trucks;
};

//Class: Menu
//Description: This class gives the user a menu to select which functions to run
class Menu : public System {
public:
	bool displayMenu();
	void displaySubMenu();
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
	Menu menuObj;
	string input, fileName;

	//Welcome the user
	cout << "\n        ===========================================================" << endl;
	cout << "        |           Welcome to the Homework 2 Program!            |" << endl;
	cout << "        ===========================================================\n" << endl;

	//Run the Programe
	while (true) {

		bool quitProgram = menuObj.displayMenu();

		if (quitProgram){
			//End of program, print msg and wait 5 seconds to allow user to read the message.
			cout << "\n        ========================================================" << endl;
			cout << "        |          Thank you for running the program!          |" << endl;
			cout << "        ========================================================\n" << endl;
			sleep(5);
			break;
		}
	}
}

bool Menu::displayMenu(){
	bool quitProgramReturn = false;;
	string theExtra;

	//Display the user with the menu
	cout << "\n";
	cout << "(1) Print all owners and their vehicles.\n";
	cout << "(2) Print a particular owner along with their vehicles and info.\n";
	cout << "(3) Print all the vehicles(and all related information) and their owners.\n";
	cout << "(4) Print all the vehicles(and their owners) of a specific type\n";
	cout << "(5) Create a vehicle.\n";
	cout << "(9) Quit.\n";
	cout << "\nEnter the number of the function you wish to use.\n";
	cout << "Selection: ";
	int input;
	//getline(cin, input);
	cin >> input;
	getline(cin, theExtra);
	cout << endl;
	switch (input) {
	case 1:          
		//  1. Print all the owners(and all related information) and their vehicles(and all
		//	   related information)
		printCase1();
		break;
	case 2:       
		//	2. Print a particular owner(by name), all the owner’s related information and their
		//	   vehicles(and all their related information)
		printCase2();
		break;
	case 3:            
		//	3. Print all the vehicles(and all related information) and their owners.
		printCase3();
		break;
	case 4:
		//	4. Print all the vehicles(and their owners) of a specific type, e.g.sportscar.
		printCase4();
		break;
	case 5:
		//  5. Create a vehicle.
		// prompt for choice
		displaySubMenu();
		break;
	case 9:
		// 9. Quit the program
		quitProgramReturn = true;
		break;
	default:        
		cout << "\n       Your input was invalid. Try again.\n";
		break;
	}

	return quitProgramReturn;
}

void Menu::displaySubMenu(){

	string choiceTemp, theExtra;
	//char choice;
	//char input;
	cout << endl << "Enter:\n     1 for Car\n     2 for Sports Car\n     2 for Truck";
	cout << endl << "Selection: ";
	int input;
	cin >> input;
	cout << endl;
	getline(cin, theExtra);
	switch (input) {
	case 1:
		createCar();
		break;
	case 2:
		createSportsCar();
		break;
	case 3:
		createTruck();
		break;
	default:
		cout << "\n       Your input was invalid. Try again.\n";
		break;
	}
}


/*
* Default constructor for Person class
*/
Person::Person() {
	ownerName = "";
	ownerAddress = "";
}

/*
* Constructor for person with name, and no address.
*/
Person::Person(string the_name) {
	ownerName = the_name;
	ownerAddress = "";
}

/*
* Constructor for person with name and address.
*/
Person::Person(string the_name, string the_address) {
	ownerName = the_name;
	ownerAddress = the_address;
}

/*
* Copy constructor for Person class.
*/
Person::Person(const Person& theObject) {
	ownerName = theObject.ownerName;
	ownerAddress = theObject.ownerAddress;
}

/*
* Function: get_name()
*/
string Person::get_name() const {
	return ownerName;
}

/*
* Function: set_name(string)
*/
void Person::set_name(string the_name) {
	ownerName = the_name;
}

/*
* Function: get_address()
*/
string Person::get_address() const {
	return ownerAddress;
}

/*
* Function: set_address()
*/
void Person::set_address(string the_address) {
	ownerAddress = the_address;
}


/*
* Function: printInfo()
*/
void Person::printInfo() const {
	cout << endl << "     Owner: " << ownerName << endl;
	cout << "     Owner's address: " << ownerAddress << endl;
}

/*
* Default constructor for Vehicle class
*/
Vehicle::Vehicle() {
	manufacturerName = "";
	numCylinders = 0;
	owner = new Person();
}

/*
* Constructor for Vehicle with manufacturer name, number of cylinders, and an owner object
*/
Vehicle::Vehicle(string manufacturerIn, int numCylindersIn, Person ownerObjectIn) {
	manufacturerName = manufacturerIn;
	numCylinders = numCylindersIn;
	owner = &ownerObjectIn;
}

/*
* Copy constructor for Vehicle class.
*/
Vehicle::Vehicle(const Vehicle& theObject) {
	manufacturerName = theObject.manufacturerName;
	numCylinders = theObject.numCylinders;
	owner = theObject.owner;
}

/*
* Function: get_manufacName()
* Class: Vehicle
* Description: Returns manufacName
*/
string Vehicle::getManufacturerName(){
	return manufacturerName;
}

/*
* Function: set_manufacName(string)
* Class: Vehicle
* Description: Sets manufacName to the param
*/
void Vehicle::setManufacturerName(string manufacturerNameIn) {
	manufacturerName = manufacturerNameIn;
}

/*
* Function: get_numCyl()
* Class: Vehicle
* Description: returns numCyl
*/
int Vehicle::getCylinderNum() {
	return numCylinders;
}

/*
* Function: setCylinderNum(int)
* Class: Vehicle
* Description: Sets numCyl to the param
*/
void Vehicle::setCylinderNum(int numCylindersIn) {
	numCylinders = numCylindersIn;
}

/*
* Function: get_owner()
* Class: Vehicle
* Description: Returns the owner pointer
*/
Person* Vehicle::getOwner() {
	return owner;
}

/*
* Function: set_owner(Person&)
* Class: Vehicle
* Description: Sets the owner pointer to the param
*/
void Vehicle::setOwner(Person &ownerIn) {
	owner = &ownerIn;
}



/*
* Function: printInfo
* Class: Vehicle
* Description: Displays info about a Truck object.
*/
void Vehicle::printInfo() {
	owner->printInfo();
	cout << "     Manufacturer: " << manufacturerName << endl;
	cout << "     Number of Cylinders: " << numCylinders << endl;
}

/*
* Default constructor for Truck class.
*/
Truck::Truck() {
	loadCapacity = 0;
	towingCapacity = 0;
}

/*
* Constructor for truck object with loadCap and towCap
*/
Truck::Truck(double loadCapacityIn, int towingCapacityIn) {
	loadCapacity = loadCapacityIn;
	towingCapacity = towingCapacityIn;
}

/*
* Function: get_loadCap()
* Class: Truck
* Description: Returns loadCap
*/
double Truck::getLoadCap() {
	return loadCapacity;
}

/*
* Function: get_towCap()
* Class: Truck
* Description: Returns towCap
*/
int Truck::getTowCap() {
	return towingCapacity;
}

/*
* Function: set_loadCap(double)
* Class: Truck
* Description: Sets loadCap to the param
*/
void Truck::setLoadCap(double the_loadCap) {
	loadCapacity = the_loadCap;
}

/*
* Function: set_towCap(int)
* Class: Truck
* Description: Sets towCap to the param
*/
void Truck::setTowCap(int the_towCap) {
	towingCapacity = the_towCap;
}

/*
* Function: printInfo
* Class: Truck
* Description: Displays info about a Truck object.
*/
void Truck::printInfo() {
	Vehicle::printInfo();
	cout << "     Loading capacity: " << loadCapacity << endl;
	cout << "      Towing capacity: " << towingCapacity << endl;
}

/*
* Default constructor for Car class.
*/
Car::Car() {
	doorNum = 0;
	engineSize = 0;
}

/*
* Constructor for Car object with doors and engineSize
*/
Car::Car(int the_doors, int the_engineSize) {
	doorNum = the_doors;
	engineSize = the_engineSize;
}

/*
* Function: get_doors()
* Class: Car
* Description: Returns doors
*/
int Car::getDoorNum() {
	return doorNum;
}

/*
* Function: set_doors(int)
* Class: Car
* Description: Sets doors to param
*/
void Car::setDoorNum(int the_doors) {
	doorNum = the_doors;
}

/*
* Function: get_engineSize()
* Class: Car
* Description: Returns engineSize
*/
int Car::getEngineSize() {
	return engineSize;
}

/*
* Function: set_engineSize(int)
* Class: Car
* Description: Sets engineSize to param
*/
void Car::setEngineSize(int the_engineSize) {
	engineSize = the_engineSize;
}

/*
* Function: printInfo()
* Class: Car
* Description: Prints info abiyt Car objects
*/
void Car::printInfo() {
	Vehicle::printInfo();
	cout << "     Number of doors: " << doorNum << endl;
	cout << "     Engine size: " << engineSize << endl;
}


/*
* Default constructor for SportsCar class.
*/
SportsCar::SportsCar() {
	sunroof = false;
	convertible = false;
}

/*
* Constructor for SportsCar with sunroof and convertible
*/
SportsCar::SportsCar(bool the_sunroof, bool the_convertible) {
	sunroof = the_sunroof;
	convertible = the_convertible;
}

/*
* Function: get_sunroof()
* Class: SportsCar
* Description: Returns sunroof
*/
bool SportsCar::getSunroof() {
	return sunroof;
}

/*
* Function: set_sunroof(bool)
* Class: SportsCar
* Description: Sets sunroof to param
*/
void SportsCar::setSunroof(bool setIn) {
	sunroof = setIn;
}

/*
* Function: get_convertible()/
* Class: SportsCar
* Description: Returns convertible
*/
bool SportsCar::getConvertible(){
	return convertible;
}

/*
* Function: set_convertible(bool)
* Class: SportsCar
* Description: Sets convertible to param
*/
void SportsCar::setConvertible(bool setIn) {
	convertible = setIn;
}

/*
* Function: printInfo()
* Class: SportsCar
* Description: Prints info about SportsCar objects
*/
void SportsCar::printInfo() {
	Vehicle::printInfo();
	if (sunroof) {
		cout << "     Sunroof: Yes" << endl;
	}
	else {
		cout << "     Sunroof: No" << endl;
	}
	if (convertible) {
		cout << "     Convertible: Yes" << endl;
	}
	else {
		cout << "     Convertible: No" << endl;
	}
}



/*
* Function: createCar()
*/
void System::createCar() {
	Person *ownerObject;
	Car carObject;
	string ownerIn = "";
	string ownerAddressIn, manufacturerIn;
	int numCyl, doors, engineSize;

	cout << endl << "Please enter the following information:\n";
	cout << endl << "     Enter owner's name: ";
	getline(cin, ownerIn);

	cout << "     Enter owner's address: ";
	getline(cin, ownerAddressIn);
	ownerObject = new Person(ownerIn, ownerAddressIn);
	if (!existingOwner(ownerIn)) {
		validOwners.push_back(ownerIn);
	}
	carObject.setOwner(*(ownerObject));

	cout << "     Enter the vehicle's manufacturer: ";
	getline(cin, manufacturerIn);
	carObject.setManufacturerName(manufacturerIn);

	cout << "     Enter the number of engine cylinders: ";
	cin >> numCyl;
	carObject.setCylinderNum(numCyl);

	cout << "     Enter the number of doors: ";
	cin >> doors;
	carObject.setDoorNum(doors);

	cout << "     Enter the engine size in liters: ";
	cin >> engineSize;
	carObject.setEngineSize(engineSize);
	cars[ownerIn].push_back(carObject);
}

/*
* Function: createSportsCar()
*/
void System::createSportsCar() {
	Person *ownerObject;
	SportsCar sportsCarObject;

	string ownerIn, ownerAddressIn, manufacturerIn, choice;
	int numCyl;
	bool sunroof;
	bool convertible;
	bool validChoiceEntered = false;
	char choiceChar;

	cout << endl << "Please enter the following information:\n";
	cout << "     Enter owners name: ";
	getline(cin, ownerIn);

	cout << "     Enter owners address: ";
	getline(cin, ownerAddressIn);
	ownerObject = new Person(ownerIn, ownerAddressIn);
	if (!existingOwner(ownerIn)) {
		validOwners.push_back(ownerIn);	}
	sportsCarObject.setOwner(*(ownerObject));

	cout << "     Enter the vehicle's manufacturer: ";
	getline(cin, manufacturerIn);
	sportsCarObject.setManufacturerName(manufacturerIn);

	cout << "     Enter the number of engine cylinders: ";
	cin >> numCyl;
	sportsCarObject.setCylinderNum(numCyl);
	while (!validChoiceEntered) {
		cout << "     Have a sunroof? (Y/N): ";
		cin >> choice;
		choiceChar = toupper(choice.at(0));
		if (choiceChar == 'Y') {
			sunroof = true;
			validChoiceEntered = true;
		}
		else if (choiceChar == 'N') {
			sunroof = false;
			validChoiceEntered = true;
		}
		else {
			cout << "     Invalid input, try again." << endl;;
		}
	}
	sportsCarObject.setSunroof(sunroof);
	validChoiceEntered = false;

	while (!validChoiceEntered) {
		cout << "     Convertible? (Y/N): ";
		cin >> choice;
		choiceChar = toupper(choice.at(0));
		if (choiceChar == 'Y') {
			convertible = true;
			validChoiceEntered = true;
		}
		else if (choiceChar == 'N') {
			convertible = false;
			validChoiceEntered = true;
		}
		else {
			cout << "     Retry." << endl;
		}
	}
	sportsCarObject.setConvertible(convertible);
	sportsCars[ownerIn].push_back(sportsCarObject);
}

/*
* Function: createTruck()
*/
void System::createTruck() {
	Person *ownerObject;
	Truck truckObject;

	string ownerIn, ownerAddressIn, manufacturerIn;

	int numCyl, loadCap, towCap;
	int position = 0;

	cout << endl << "Please enter the following information:\n";
	cout << "     Enter owners name: ";
	getline(cin, ownerIn);

	cout << "     Enter owners address: ";
	getline(cin, ownerAddressIn);
	ownerObject = new Person(ownerIn, ownerAddressIn);
	if (!existingOwner(ownerIn)) {
		validOwners.push_back(ownerIn);
	}
	truckObject.setOwner(*(ownerObject));

	cout << "     Enter the vehicle's manufacturer: ";
	getline(cin, manufacturerIn);
	truckObject.setManufacturerName(manufacturerIn);

	cout << "     Enter the number of engine cylinders: ";
	cin >> numCyl;
	truckObject.setCylinderNum(numCyl);

	cout << "     Enter the loading capacity in pounds: ";
	cin >> loadCap;
	truckObject.setLoadCap(loadCap);

	cout << "     Enter the towing capacity in pounds: ";
	cin >> towCap;
	truckObject.setTowCap(towCap);
	trucks[ownerIn].push_back(truckObject);
}

/*
* Function: existingOwner
*/
bool System::existingOwner(string ownerIn) {
	for (size_t i = 0; i < validOwners.size(); i++) {
		if (validOwners[i].get_name() == ownerIn) {
			return true;
		}
	}
	return false;
}

/*
* Function: ownsTrucks
*/
bool System::ownsTrucks(string ownerIn)  {
	if (trucks[ownerIn].size() != 0) {
		return true;
	}
	else {
		return false;
	}
}

/*
* Function: ownsCars
*/
bool System::ownsCars(string ownerIn)  {
	if (cars[ownerIn].size() != 0) {
		return true;
	}
	else {
		return false;
	}
}

/*
* Function: ownsSportsCars
*/
bool System::ownsSportsCars(string ownerIn) {
	if (sportsCars[ownerIn].size() != 0) {
		return true;
	}
	else {
		return false;
	}
}
//Function: printCase1
// 1. Print all the owners(and all related information) and their vehicles(and all
//    related information)
void System::printCase1() {

	if (!cars.empty() && !sportsCars.empty() && !trucks.empty()){
		cout << endl;
		if (!cars.empty()) {
			cout << "All cars: " << endl;
			for (map<string, vector<Car> >::iterator it = cars.begin(); it != cars.end(); ++it) {
				for (size_t i = 0; i < cars[it->first].size(); i++) {
					cars[it->first].at(i).printInfo();
				}
			}
			cout << endl;
		}
		if (!sportsCars.empty()) {
			cout << "All sports cars: " << endl;
			for (map<string, vector<SportsCar> >::iterator it = sportsCars.begin(); it != sportsCars.end(); ++it) {
				for (size_t i = 0; i < sportsCars[it->first].size(); i++) {
					sportsCars[it->first].at(i).printInfo();
				}
			}
			cout << endl;
		}
		if (!trucks.empty()) {
			cout << "All trucks: " << endl;
			for (map<string, vector<Truck> >::iterator it = trucks.begin(); it != trucks.end(); ++it) {
				for (size_t i = 0; i < trucks[it->first].size(); i++) {
					trucks[it->first].at(i).printInfo();
				}
			}
			cout << endl;
		}
		cout << endl;
	}
	else{
		cout << " \nNo owners in database!" << endl << endl;
	}
	cout << endl;
}

//Function: printCase2
// 2. Print a particular owner (by name), all the owner’s related information and their
//    vehicles(and all their related information)
void System::printCase2() {
	string ownerIn;

	// get ownerIn
	cout << endl;
	cout << "Please enter a owner's name: ";
	getline(cin, ownerIn);

	// if this owner doesn't exist, (s)he owns no vehicles
	if (!existingOwner(ownerIn)) {
		cout << "     " << ownerIn << " owns no vehicles!" << endl << endl;
		return;
	}

	// if no trucks, display
	if (!ownsTrucks(ownerIn)) {
		cout << ownerIn << " does not own any trucks." << endl << endl;
	}
	// else print info for them
	else {
		cout << "Trucks owned by " << ownerIn << ":" << endl;
		for (size_t i = 0; i < trucks[ownerIn].size(); i++) {
			trucks[ownerIn].at(i).printInfo();
		}
		cout << endl;
	}
	// if no cars, display
	if (!ownsCars(ownerIn)) {
		cout << ownerIn << " does not own any cars." << endl << endl;
	}
	// else print info for them
	else {
		cout << "Cars owned by " << ownerIn << ":" << endl;
		for (size_t i = 0; i < cars[ownerIn].size(); i++) {
			cars[ownerIn].at(i).printInfo();
		}
		cout << endl;
	}
	// if no sports cars, display
	if (!ownsSportsCars(ownerIn)) {
		cout << ownerIn << " does not own any sports cars." << endl;
	}
	// else print info for them
	else {
		cout << "Sports Cars owned by " << ownerIn << ":" << endl;
		for (size_t i = 0; i < sportsCars[ownerIn].size(); i++) {
			sportsCars[ownerIn].at(i).printInfo();
		}
		cout << endl;
	}
	cout << endl;
}

//Function: printCase3
// 3. Print all the vehicles (and all related information) and their owners
void System::printCase3() {
	if (!cars.empty() && !sportsCars.empty() && !trucks.empty()){
		cout << endl;
		if (!cars.empty()) {
			cout << "All cars: " << endl;
			for (map<string, vector<Car> >::iterator it = cars.begin(); it != cars.end(); ++it) {
				for (size_t i = 0; i < cars[it->first].size(); i++) {
					cars[it->first].at(i).printInfo();
				}
			}
			cout << endl;
		}
		if (!sportsCars.empty()) {
			cout << "All sports cars: " << endl;
			for (map<string, vector<SportsCar> >::iterator it = sportsCars.begin(); it != sportsCars.end(); ++it) {
				for (size_t i = 0; i < sportsCars[it->first].size(); i++) {
					sportsCars[it->first].at(i).printInfo();
				}
			}
			cout << endl;
		}
		if (!trucks.empty()) {
			cout << "All trucks: " << endl;
			for (map<string, vector<Truck> >::iterator it = trucks.begin(); it != trucks.end(); ++it) {
				for (size_t i = 0; i < trucks[it->first].size(); i++) {
					trucks[it->first].at(i).printInfo();
				}
			}
			cout << endl;
		}
		cout << endl;
	}
	else{
		cout << " \nNo vehicles in database!" << endl << endl;
	}
	cout << endl;
}

//Function: printCase4
// 4. Print all the vehicles (and their owners) of a specific type, e.g. sportscar.
void System::printCase4() {

	// initalize typeTemp and type (choices for type of car)
	//string choiceTemp;
	//char choice;
	char input;

	// prompt for choice
	cout << endl << "Enter:\n     C for Car\n     S for Sports Car\n     T for Truck";
	cout << endl << "Selection: ";
	//getline(cin, choiceTemp);
	//choice = toupper(choiceTemp.at(0));

	cin >> input;

	// switch cases for choice
	switch (input) {
	case 'T':
		if (trucks.empty()) {
			cout << "     There are no trucks in the database!" << endl;
		}
		else {
			cout << "All trucks in database: " << endl;
			for (map<string, vector<Truck> >::iterator it = trucks.begin(); it != trucks.end(); ++it) {
				for (size_t i = 0; i < trucks[it->first].size(); i++) {
					trucks[it->first].at(i).printInfo();
				}
			}
			cout << endl;
		}
		break;
	case 'C':
		if (cars.empty()) {
			cout << "     There are no cars in the database!" << endl;
		}
		else {
			cout << "All cars in database: " << endl;
			for (map<string, vector<Car> >::iterator it = cars.begin(); it != cars.end(); ++it) {
				for (size_t i = 0; i < cars[it->first].size(); i++) {
					cars[it->first].at(i).printInfo();
				}
			}
			cout << endl;
		}
		break;
	case 'S':
		if (sportsCars.empty()) {
			cout << "     There are no sports cars in the database!" << endl;
		}
		else {
			cout << "All sports cars in database: " << endl;
			for (map<string, vector<SportsCar> >::iterator it = sportsCars.begin(); it != sportsCars.end(); ++it) {
				for (size_t i = 0; i < sportsCars[it->first].size(); i++) {
					sportsCars[it->first].at(i).printInfo();
				}
			}
			cout << endl;
		}
		break;
	default:
		cout << "\n       Your input was invalid. Try again.\n";
		break;
	}
	cout << endl;
}



//OPERATOR OVERLOADS
bool Person::operator == (const Person& rt_side) {
	if (ownerName == rt_side.ownerName && ownerAddress == rt_side.ownerAddress) {
		return true;
	}
	else {
		return false;
	}
}
Person& Person::operator = (const Person& rt_side) {
	if (this == &rt_side)		return *this;
	else {
		ownerName = rt_side.ownerName;
		ownerAddress = rt_side.ownerAddress;
		return *this;
	}
}
Vehicle& Vehicle::operator = (const Vehicle& rt_side) {
	if (this == &rt_side)		return *this;
	else {
		manufacturerName = rt_side.manufacturerName;
		numCylinders = rt_side.numCylinders;
		owner = rt_side.owner;
		return *this;
	}
}
Car& Car::operator = (const Car& rt_side) {
	if (this == &rt_side)		return *this;
	else {
		doorNum = rt_side.doorNum;
		engineSize = rt_side.engineSize;
		return *this;
	}
}
Truck& Truck::operator = (const Truck& rt_side) {
	if (this == &rt_side)		return *this;
	else {
		loadCapacity = rt_side.loadCapacity;
		towingCapacity = rt_side.towingCapacity;
		return *this;
	}
}

SportsCar& SportsCar::operator = (const SportsCar& rt_side) {
	if (this == &rt_side)		return *this;
	else {
		sunroof = rt_side.sunroof;
		convertible = rt_side.convertible;
		return *this;
	}
}
