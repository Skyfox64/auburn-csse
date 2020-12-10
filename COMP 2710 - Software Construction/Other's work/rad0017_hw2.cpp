/*****
 * PROGRAM:     Homework2
 * AUTHOR:      Robinson Davis, rad0017@tigermail.auburn.edu
 * CLASS:       COMP 2710 Section 002
 * DATE:        November 14, 2014
 * Description: Maintains a database of vehicle owners.       
 *****/
#include <string>
#include <iostream>
#include <map>
#include <vector>
#include <iterator>
#include <algorithm>
using namespace std;

/*
* Person class
* Holds information of owners.
* Inherited class(es): None
* Derived class(es): Vehicle
*/
class Person {
public:
   Person();                                                // default constructor
   Person(string the_name);                                 // constructor for just name
   Person(string the_name, string the_address);             // constructor for multiple params
   Person(const Person& the_object);                        // copy constructor
   int set_name(string the_name);                           // sets name
   string get_name() const;                                 // gets name
   int set_address(string the_address);                     // sets address
   string get_address() const;                              // gets address
   virtual void printInfo() const;                          // prints info for Person object
   Person& operator = (const Person& rt_side);              // override for '='
   bool operator == (const Person& rt_side);                // override for '=='
private:
   string name;                                             // owners name
   string address;                                          // owners address
};

/*
* Vehicle class
* Holds information of all vehicles, including their owners.
* Inherited class(es): Person
* Derived class(es): Truck, Car, SportsCar
*/
class Vehicle {
public:
   Vehicle();                                                      // default constructor
   Vehicle(string the_manufacName, int the_numCyl,
   	Person ownerObject);                                        // constructor for params 
   Vehicle(const Vehicle& the_object);                             // copy constructor 
   string get_manufacName();										// returns manufacName
   int get_numCyl();												// returns numCyl
   int set_manufacName(string the_manufacName);					// sets manufacName
   int set_numCyl(int the_numCyl);									// sets numCyl
   int set_owner(Person &the_owner);								// sets owner
   Person* get_owner();											// returns the owner
   virtual void printInfo();									    // prints vehicle information
   Vehicle& operator = (const Vehicle& rt_Side);					// overload for "="
private:
   string manufacName;												// manufacturer's name
   int numCyl;														// engine cylinders
   Person *owner;													// pointer to person object
};

/*
* Truck class
* Holds information of trucks.
* Inherited class(es): Vehicle<-Person
* Derived class(es): None
*/
class Truck : public Vehicle {
public:
   Truck();														 // default constructor
   Truck(double the_loadCap, int the_towCap);						 // constructor for params
   double get_loadCap();											 // returns loadCap
   int get_towCap();												 // returns towCap
   int set_loadCap(double the_loadCap);							 // sets loadCap
   int set_towCap(int the_towCap);									 // sets towCap
   virtual void printInfo();										 // prints Truck information
   Truck& operator = (const Truck& rt_side);
private:
   double loadCap;													 // loading capacity in pounds
   int towCap;														 // towing capacity in pounds

};

/*
* Truck class
* Holds information of cars.
* Inherited class(es): Vehicle<-Person
* Derived class(es): SportsCar
*/
class Car : public Vehicle {
public:
   Car();
   Car(int the_doors, int the_engineSize);
   int get_doors();
   int get_engineSize();
   int set_doors(int the_doors);
   int set_engineSize(int the_engineSize);
   virtual void printInfo();
   Car& operator = (const Car& rt_side);
private:
   int doors;											// number of doors
   int engineSize;										// engine size in liters
};

/*
* Truck class
* Holds information of sports cars.
* Inherited class(es): Car<-Vehicle<-Person
* Derived class(es): None
*/
class SportsCar : public Car {
public:
   SportsCar();
   SportsCar(bool the_sunroof, bool popTop);
   bool get_sunroof();
   bool get_popTop();
   int set_sunroof(bool the_sunroof);
   int set_popTop(bool the_popTop);
   virtual void printInfo();
   SportsCar& operator = (const SportsCar& rt_side);
private:
   bool sunroof;										// whether or not car has sunroof
   bool popTop;										// whether or not top can be popped
};

/*
* Menu class
* Displays the menu, and also gets the user's choice.
*/
class Menu {
public:
   void displayMenu();
   int getChoice();
};

/*
* System class
* Has functions to run the program, and maintain its data.
*/
class System : public Menu{
public:
   void createTruck();					// creates a new truck
   void createCar();						    // creates a new car
   void createSportsCar();				        // creates a new sports car
   bool existingOwner(string);		            // checks if param user is existing user
   bool ownsTrucks(string);			            // checks if param user owns trucks, prints info
   bool ownsCars(string);			        	// checks if param user owns cars, prints info
   bool ownsSportsCars(string);		            // checks if param user owns sports cars, prints info
   void printByOwner();						// prints info about an owner
   void printByVehicle();						// prints info about a car type
   void printDatabase();						// prints entire database
private:
   map<string, vector<Truck> > trucks;
   map<string, vector<Car> > cars;
   map<string, vector<SportsCar> > sportsCars;
   vector<Person> validOwners;
};

/*****Begin Person Function Definitions*****/

/*
* Default constructor for Person class
*/
Person::Person() {
   name = "";
   address = "";
}

/*
* Constructor for person with name, and no address.
*/
Person::Person(string the_name) {
   name = the_name;
   address = "";
}

/*
* Constructor for person with name and address.
*/
Person::Person(string the_name, string the_address) {
   name = the_name;
   address = the_address;
}

/*
* Copy constructor for Person class.
*/
Person::Person(const Person& theObject) {
   name = theObject.name;
   address = theObject.address;
}

/*
* Function: get_name()
* Class: Person
* Description: Returns the name variable.
*/
string Person::get_name() const {
   return name;
}

/*
* Function: get_address()
* Class: Person
* Description: Returns the address variable.
*/
string Person::get_address() const {
   return address;
}

/*
* Function: set_name(string)
* Class: Person
* Description: Sets the name variable to the param name.
*/
int Person::set_name(string the_name) {
   name = the_name;
   return 0;
}

/*
* Function: set_address()
* Class: Person
* Description: Sets the address variable to the param address.
*/
int Person::set_address(string the_address) {
   address = the_address;
   return 0;
}

/*
* Function: printInfo()
* Class: Person
* Description: Displays info about a Person object.
*/
void Person::printInfo() const {
   cout << endl << "\tOwner name: " << name << endl;
   cout << "\tOwner address: " << address << endl;
}

/*
* "=" operator overload for Person objects
* Class: Person
*/
Person& Person::operator = (const Person& rt_side) {
   if (this == &rt_side) {
      return *this;
   }
   else {
      name = rt_side.name;
      address = rt_side.address;
      return *this;
   }
}

/*
* "==" operator overload for Person objects
* Class: Person
*/
bool Person::operator == (const Person& rt_side) {
   if (name == rt_side.name && address == rt_side.address) {
      return true;
   }
   else {
      return false;
   }
}

/*****End Person Function Definitions*****/


/*****Begin Vehicle Function Definitions*****/
/*
* Default constructor for Vehicle class
*/
Vehicle::Vehicle() {
   manufacName = "";
   numCyl = 0;
   owner = new Person();
}

/*
* Constructor for Vehicle with manufacturer Name, number of cylinders, and an owner object
*/
Vehicle::Vehicle(string the_manufacName, int the_numCyl, Person ownerObject) {
   manufacName = the_manufacName;
   numCyl = the_numCyl;
   owner = &ownerObject;
}

/*
 * Copy constructor for Vehicle class.
 */
Vehicle::Vehicle(const Vehicle& theObject) {
   manufacName = theObject.manufacName;
   numCyl = theObject.numCyl;
   owner = theObject.owner;
}

/*
* Function: get_manufacName()
* Class: Vehicle
* Description: Returns manufacName
*/
string Vehicle::get_manufacName(){
   return manufacName;
}

/*
* Function: get_numCyl()
* Class: Vehicle
* Description: returns numCyl
*/
int Vehicle::get_numCyl() {
   return numCyl;
}

/*
* Function: set_manufacName(string)
* Class: Vehicle
* Description: Sets manufacName to the param
*/
int Vehicle::set_manufacName(string the_manufacName) {
   manufacName = the_manufacName;
   return 0;
}

/*
* Function: set_numCyl(int)
* Class: Vehicle
* Description: Sets numCyl to the param
*/
int Vehicle::set_numCyl(int the_numCyl) {
   numCyl = the_numCyl;
   return 0;
}

/*
* Function: set_owner(Person&)
* Class: Vehicle
* Description: Sets the owner pointer to the param
*/
int Vehicle::set_owner(Person &the_owner) {
   owner = &the_owner;
   return 0;
}

/*
* Function: get_owner()
* Class: Vehicle
* Description: Returns the owner pointer
*/
Person* Vehicle::get_owner() {
   return owner;
}

/*
* Function: printInfo
* Class: Vehicle
* Description: Displays info about a Truck object.
*/
void Vehicle::printInfo() {
   owner->printInfo();
   cout << "\tVehicle manufacturer: " << manufacName << endl;
   cout << "\tNumber of cylinders: " << numCyl << endl;
}

/*
* "=" operator overload for Vehicle objects
* Class: Vehicle
*/
Vehicle& Vehicle::operator = (const Vehicle& rt_Side) {
   if (this == &rt_Side) {
      return *this;
   }
   else {
      manufacName = rt_Side.manufacName;
      numCyl = rt_Side.numCyl;
      owner = rt_Side.owner;
      return *this;
   }
}
/*****End Vehicle Function Definitions*****/


/*****Begin Truck Function Definitions*****/
/*
* Default constructor for Truck class.
*/
Truck::Truck() {
   loadCap = 0;
   towCap = 0;
}

/*
* Constructor for truck object with loadCap and towCap
*/
Truck::Truck(double the_loadCap, int the_towCap) {
   loadCap = the_loadCap;
   towCap = the_towCap;
}

/*
* Function: get_loadCap()
* Class: Truck
* Description: Returns loadCap
*/
double Truck::get_loadCap() {
   return loadCap;
}

/*
* Function: get_towCap()
* Class: Truck
* Description: Returns towCap
*/
int Truck::get_towCap() {
   return towCap;
}

/*
* Function: set_loadCap(double)
* Class: Truck
* Description: Sets loadCap to the param
*/
int Truck::set_loadCap(double the_loadCap) {
   loadCap = the_loadCap;
   return 0;
}

/*
* Function: set_towCap(int)
* Class: Truck
* Description: Sets towCap to the param
*/
int Truck::set_towCap(int the_towCap) {
   towCap = the_towCap;
   return 0;
}

/*
* Function: printInfo
* Class: Truck
* Description: Displays info about a Truck object.
*/
void Truck::printInfo() {
   Vehicle::printInfo();
   cout << "\tLoading capacity (lbs): " << loadCap << endl;
   cout << "\tTowing capacity (lbs): " << towCap << endl;
}
/*
* "=" operator overload for Truck objects
* Class: Truck
*/
Truck& Truck::operator = (const Truck& rt_Side) {
   if (this == &rt_Side) {
      return *this;
   }
   else {
      loadCap = rt_Side.loadCap;
      towCap = rt_Side.towCap;
      return *this;
   }
}

/*****End Truck Function Definitions*****/


/*****Begin Car Function Definitions*****/
/*
* Deafault constructor for Car class.
*/
Car::Car() {
   doors = 0;
   engineSize = 0;
}

/*
* Constructor for Car object with doors and engineSize
*/
Car::Car(int the_doors, int the_engineSize) {
   doors = the_doors;
   engineSize = the_engineSize;
}

/*
* Function: get_doors()
* Class: Car
* Description: Returns doors
*/
int Car::get_doors() {
   return doors;
}

/*
* Function: get_engineSize()
* Class: Car
* Description: Returns engineSize
*/
int Car::get_engineSize() {
   return engineSize;
}

/*
* Function: set_doors(int)
* Class: Car
* Description: Sets doors to param
*/
int Car::set_doors(int the_doors) {
   doors = the_doors;
   return 0;
}

/*
* Function: set_engineSize(int)
* Class: Car
* Description: Sets engineSize to param
*/
int Car::set_engineSize(int the_engineSize) {
   engineSize = the_engineSize;
   return 0;
}

/*
* Function: printInfo()
* Class: Car
* Description: Prints info abiyt Car objects
*/
void Car::printInfo() {
   Vehicle::printInfo();
   cout << "\tNumber of doors: " << doors << endl;
   cout << "\tEngine size: " << engineSize << endl;
}

/*
* "=" operator overload for Car objects
* Class: Car
*/
Car& Car::operator = (const Car& rt_side) {
   if (this == &rt_side) {
      return *this;
   }
   else {
      doors = rt_side.doors;
      engineSize = rt_side.engineSize;
      return *this;
   }
}

/*****End Car Function Definitions*****/


/*****Begin Sports Car Function Definitions*****/
/*
* Default constructor for SportsCar class.
*/
SportsCar::SportsCar() {
   sunroof = false;
   popTop = false;
}

/*
* Constructor for SportsCar with sunroof and popTop
*/
SportsCar::SportsCar(bool the_sunroof, bool the_popTop) {
   sunroof = the_sunroof;
   popTop = the_popTop;
}

/*
* Function: get_sunroof()
* Class: SportsCar
* Description: Returns sunroof
*/
bool SportsCar::get_sunroof() {
   return sunroof;
}

/*
* Function: get_popTop()/
* Class: SportsCar
* Description: Returns popTop
*/
bool SportsCar::get_popTop(){
   return popTop;
}

/*
* Function: set_sunroof(bool)
* Class: SportsCar
* Description: Sets sunroof to param
*/
int SportsCar::set_sunroof(bool the_sunroof) {
   sunroof = the_sunroof;
   return 0;
}

/*
* Function: set_popTop(bool)
* Class: SportsCar
* Description: Sets popTop to param
*/
int SportsCar::set_popTop(bool the_popTop) {
   popTop = the_popTop;
   return 0;
}

/*
* Function: printInfo()
* Class: SportsCar
* Description: Prints info about SportsCar objects
*/
void SportsCar::printInfo() {
   Vehicle::printInfo();
   if (sunroof) {
      cout << "\tSunroof present: Yes" << endl;
   }
   else {
      cout << "\tSunroof present: No" << endl;
   }

   if (popTop) {
      cout << "\tPoppable top: Yes" << endl;
   }
   else {
      cout << "\tPoppable top: No" << endl;
   }
}

/*
* "=" operator overload for SportsCar objects
* Class: SportsCar
*/
SportsCar& SportsCar::operator = (const SportsCar& rt_side) {
   if (this == &rt_side) {
      return *this;
   }
   else {
      sunroof = rt_side.sunroof;
      popTop = rt_side.popTop;
      return *this;
   }
}

/*****End Sports Car Function Definitions*****/


/*****Begin Menu Function Definitions*****/

/*
* Function: displayMenu()
* Class: Menu
* Description: Displays the menu to the user.
*/
void Menu::displayMenu() {
   cout << "[1] Add New Truck     [2] Add New Car     [3] Add Sports Car" << endl;
   cout << "[4] Print By Owner    [5] Print By Car    [6] Print All" << endl;
   cout << "                      [10] Quit" << endl;
}

/*
* Function: getChoice()
* Class: Menu
* Description: Retrieves the users selection based on the menu.
*/
int Menu::getChoice() {
   int choice;
   char temp;
   cout << endl << "Please enter a valid choice: ";
   cin >> choice;
   cin.get(temp);
   return choice;
}

/*****End Menu Function Definitions*****/


/*****Begin System Function Definitions*****/
/*
* Function: createTruck()
* Class: System
* Description: Creates a new truck object and stores it.
*/
void System::createTruck() {
	/*****Begin Variables*****/
   Person *ownerObject;
   Truck truckObject;

   string the_owner;
   string owner_address;
   string manufacName;

   int numCyl;
   int loadCap;
   int towCap;

   int position = 0;
	/*****End Variables*****/

	// get the_owner
   cout << endl << "\tPlease enter owners name: ";
   getline(cin, the_owner);

	// get owner_address
   cout << "\tPlease enter owners address: ";
   getline(cin, owner_address);

	// Create new owner object
   ownerObject = new Person(the_owner, owner_address);
	// if its not a new owner, add to validOwners
   if (!existingOwner(the_owner)) {
      validOwners.push_back(the_owner);
   }
	// set owner of truck object
   truckObject.set_owner(*(ownerObject));

	// get manufacName and set it
   cout << "\tPlease enter the vehicle's manufacturer: ";
   getline(cin, manufacName);
   truckObject.set_manufacName(manufacName);

	// get numCyl and set it
   cout << "\tPlease enter the number of engine cylinders: ";
   cin >> numCyl;
   truckObject.set_numCyl(numCyl);

	// get loadCap and set it
   cout << "\tPlease enter the loading capacity in pounds: ";
   cin >> loadCap;
   truckObject.set_loadCap(loadCap);

	// get towCap and set it
   cout << "\tPlease enter the towing capacity in pounds: ";
   cin >> towCap;
   truckObject.set_towCap(towCap);

	// add to trucks map with owner as key
   trucks[the_owner].push_back(truckObject);

	// display success
   cout << "New truck has been successfully added to the database." << endl << endl;

}

/*
* Function: createCar()
* Class: System
* Description: Creates a new car object and stores it.
*/
void System::createCar() {
	/*****Begin Variables*****/
   Person *ownerObject;
   Car carObject;

   string the_owner;
   string owner_address;
   string manufacName;

   int numCyl;
   int doors;
   int engineSize;
	/*****End Variables*****/

	// get the_owner
   cout << endl << "\tPlease enter owners name: ";
   getline(cin, the_owner);

	// get owner_address
   cout << "\tPlease enter owners address: ";
   getline(cin, owner_address);

	// Create new owner object
   ownerObject = new Person(the_owner, owner_address);
	// if its not a new owner, add to validOwners
   if (!existingOwner(the_owner)) {
      validOwners.push_back(the_owner);
   }
	// set owner of truck object
   carObject.set_owner(*(ownerObject));

	// get manufacName and set it
   cout << "\tPlease enter the vehicle's manufacturer: ";
   getline(cin, manufacName);
   carObject.set_manufacName(manufacName);

	// get numCyl and set it
   cout << "\tPlease enter the number of engine cylinders: ";
   cin >> numCyl;
   carObject.set_numCyl(numCyl);

	// get doors and set it
   cout << "\tPlease enter the number of doors: ";
   cin >> doors;
   carObject.set_doors(doors);

	// get engineSize and set it
   cout << "\tPlease enter the engine size in liters: ";
   cin >> engineSize;
   carObject.set_engineSize(engineSize);

	// add to cars map with owner as key
   cars[the_owner].push_back(carObject);

	// display success
   cout << "New car has been successfully added to the database." << endl << endl;

}

/*
* Function: createSportsCar()
* Class: System
* Description: Creates a new SportsCar object and stores it.
*/
void System::createSportsCar() {
	/*****Begin Variables*****/
   Person *ownerObject;
   SportsCar sportsCarObject;

   string the_owner;
   string owner_address;
   string manufacName;

   int numCyl;

   bool sunroof;
   bool popTop;

   bool validChoiceEntered = false;
   string choice;
   char choiceChar;
	/*****End Variables*****/

	// get the_owner
   cout << endl << "\tPlease enter owners name: ";
   getline(cin, the_owner);

	// get owner_address
   cout << "\tPlease enter owners address: ";
   getline(cin, owner_address);

	// Create new owner object
   ownerObject = new Person(the_owner, owner_address);
	// if its not a new owner, add to validOwners
   if (!existingOwner(the_owner)) {
      validOwners.push_back(the_owner);
   }
	// set owner of truck object
   sportsCarObject.set_owner(*(ownerObject));

	// get manufacName and set it
   cout << "\tPlease enter the vehicle's manufacturer: ";
   getline(cin, manufacName);
   sportsCarObject.set_manufacName(manufacName);

	// get numCyl and set it
   cout << "\tPlease enter the number of engine cylinders: ";
   cin >> numCyl;
   sportsCarObject.set_numCyl(numCyl);

	// make sure user enters a valid choice,
   while (!validChoiceEntered) {
   	// get choice
      cout << "\tDoes this sports car have a sunroof? (Y/N): ";
      cin >> choice;
      choiceChar = toupper(choice.at(0));
   	// get yes
      if (choiceChar == 'Y') {
         sunroof = true;
         validChoiceEntered = true;
      }
      // get no
      else if (choiceChar == 'N') {
         sunroof = false;
         validChoiceEntered = true;
      }
      // get wrong choice
      else {
         cout << "\tPlease enter a valid choice." << endl;;
      }
   }

	// set sunroof, reset validChoiceEntered
   sportsCarObject.set_sunroof(sunroof);
   validChoiceEntered = false;

	// make sure user enters a valid choice
   while (!validChoiceEntered) {
   	// get choice
      cout << "\tDoes this sports car have a pop top? (Y/N): ";
      cin >> choice;
      choiceChar = toupper(choice.at(0));
   	// get yes
      if (choiceChar == 'Y') {
         popTop = true;
         validChoiceEntered = true;
      }
      // get no
      else if (choiceChar == 'N') {
         popTop = false;
         validChoiceEntered = true;
      }
      // get wrong choice
      else {
         cout << "\tPlease enter a valid choice." << endl;
      }
   }

	// set popTop
   sportsCarObject.set_popTop(popTop);

	// add to sportsCars map with owner as key
   sportsCars[the_owner].push_back(sportsCarObject);

	// display success
   cout << "New car has been successfully added to the database." << endl << endl;

}

/*
* Function: existingOwner(string)
* Class: System
* Description: Checks if owner exists.
*/
bool System::existingOwner(string the_owner) {
   for (size_t i = 0; i < validOwners.size(); i++) {
      if (validOwners[i].get_name() == the_owner) {
         return true;
      }
   }
   return false;
}

/*
* Function: ownsTrucks(string)
* Class: System
* Description: Returns whether or not the param owner owns trucks.
*/
bool System::ownsTrucks(string the_owner)  {
   if (trucks[the_owner].size() != 0) {
      return true;
   }
   else {
      return false;
   }
}

/*
* Function: ownsCars(string)
* Class: System
* Description: Returns whether or not the param owner owns cars.
*/
bool System::ownsCars(string the_owner)  {
   if (cars[the_owner].size() != 0) {
      return true;
   }
   else {
      return false;
   }
}

/*
* Function: ownsSportsCars(string)
* Class: System
* Description: Returns whether or not the param owner owns sports cars.
*/
bool System::ownsSportsCars(string the_owner) {
   if (sportsCars[the_owner].size() != 0) {
      return true;
   }
   else {
      return false;
   }
}

/*
* Function: printByOwner()
* Class: System
* Description: Prints info for a specific owner
*/
void System::printByOwner() {
	// initalize the_owner
   string the_owner;

	// get the_owner
   cout << "Please enter a owner's name: ";
   getline(cin, the_owner);

	// if this owner doesn't exist, (s)he owns no vehicles
   if (!existingOwner(the_owner)) {
      cout << "\t" << the_owner << " owns no vehicles!" << endl << endl;
      return;
   }

	// if no trucks, display
   if (!ownsTrucks(the_owner)) {
      cout << the_owner << " does not own any trucks." << endl << endl;
   }
   // else print info for them
   else {
      cout << "Trucks owned by " << the_owner << ":" << endl;
      for (size_t i = 0; i < trucks[the_owner].size(); i++) {
         trucks[the_owner].at(i).printInfo();
      }
      cout << endl;
   }
	// if no cars, display
   if (!ownsCars(the_owner)) {
      cout << the_owner << " does not own any cars." << endl << endl;
   }
   // else print info for them
   else {
      cout << "Cars owned by " << the_owner << ":" << endl;
      for (size_t i = 0; i < cars[the_owner].size(); i++) {
         cars[the_owner].at(i).printInfo();
      }
      cout << endl;
   }
	// if no sports cars, display
   if (!ownsSportsCars(the_owner)) {
      cout << the_owner << " does not own any sports cars." << endl;
   }
   // else print info for them
   else {
      cout << "Sports Cars owned by " << the_owner << ":" << endl;
      for (size_t i = 0; i < sportsCars[the_owner].size(); i++) {
         sportsCars[the_owner].at(i).printInfo();
      }
      cout << endl;
   }

   cout << endl;
}

/*
* Function: printByVehicle()
* Class: System
* Description: Prints info for specific vehicle type
*/
void System::printByVehicle() {

	// initalize typeTemp and type (choices for type of car)
   string choiceTemp;
   char choice;

	// prompt for choice
   cout << endl << "Please enter ""T"" for truck, ""C"" for car, or ""S"" for sports car: ";
   getline(cin, choiceTemp);
   choice = toupper(choiceTemp.at(0));

	// switch cases for choice
   switch (choice) {
   	// case for trucks
      case 'T':
      // if no trucks, display
         if (trucks.empty()) {
            cout << "\tThere are no trucks in the database!" << endl;
         }
         // else print info for them
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
   	// case for cars
      case 'C':
      // if no cars, display
         if (cars.empty()) {
            cout << "\tThere are no cars in the database!" << endl;
         }
         // else print info for them
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
   	// case for sports cars
      case 'S':
      // if no sports cars, display
         if (sportsCars.empty()) {
            cout << "\tThere are no sports cars in the database!" << endl;
         }
         // else print info for them
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
   	// default for invalid choice
      default:
         cout << endl << "Please enter a valid choice." << endl;
   }
   cout << endl;
}

void System::printDatabase() {
	// if trucks is empty, display
   if (trucks.empty()) {
      cout << "\tThere are no trucks in the database!" << endl;
   }
   // else print info for them
   else {
      cout << "All trucks in database: " << endl;
      for (map<string, vector<Truck> >::iterator it = trucks.begin(); it != trucks.end(); ++it) {
         for (size_t i = 0; i < trucks[it->first].size(); i++) {
            trucks[it->first].at(i).printInfo();
         }
      }
      cout << endl;
   }

	// if no cars, display
   if (cars.empty()) {
      cout << "\tThere are no cars in the database!" << endl;
   }
   // else print info for them
   else {
      cout << "All cars in database: " << endl;
      for (map<string, vector<Car> >::iterator it = cars.begin(); it != cars.end(); ++it) {
         for (size_t i = 0; i < cars[it->first].size(); i++) {
            cars[it->first].at(i).printInfo();
         }
      }
      cout << endl;
   }

	// if no sports cars, display
   if (sportsCars.empty()) {
      cout << "\tThere are no sports cars in the database!" << endl;
   }
   // else print info for them
   else {
      cout << "All sports cars in database: " << endl;
      for (map<string, vector<SportsCar> >::iterator it = sportsCars.begin(); it != sportsCars.end(); ++it) {
         for (size_t i = 0; i < sportsCars[it->first].size(); i++) {
            sportsCars[it->first].at(i).printInfo();
         }
      }
      cout << endl;
   }
   cout << endl;
}

/*****End System Function Definitions*****/

int main() {
   cout << "\t***********************************************" << endl;
   cout << "\t|         Vehicle Database Management         |" << endl;
   cout << "\t***********************************************" << endl << endl;

	// initalize choice and run
   int choice = 0;
   System run;

	// loop through choice
   while (choice != 10) {
   	// display menu and get choice
      run.displayMenu();
      choice = run.getChoice();
   	// switch case for choice
      switch (choice) {
         case 1:
            run.createTruck();
            break;
         case 2:
            run.createCar();
            break;
         case 3:
            run.createSportsCar();
            break;
         case 4:
            run.printByOwner();
            break;
         case 5:
            run.printByVehicle();
            break;
         case 6:
            run.printDatabase();
            break;
         case 10:
         // print goodbye
            cout << endl << "\t***********************************************" << endl;
            cout << "\t| Thanks for Using Vehicle Database Management |" << endl;
            cout << "\t***********************************************" << endl;
            return 0;
      	// default case for invalid choice
         default:
            cout << endl << "Please enter a valid choice." << endl;
      }
   }

}