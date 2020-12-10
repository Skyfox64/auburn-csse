/*
Program:	Lab 4
Name:		John Carroll
UserID:		jcc0044
StudentID#:	902521946
Class:		COMP 2710
Date:		December 3rd, 2014
E-Mail:     jcc0044@tigermail.auburn.edu

Description: Aubie Bank is a simple banking system

Compile Instructions:
1)	Change current directory to correct directory which contains the .cpp using command: “cd”
2)	To compile:
	a.	type "g++ program.cpp -o program" in a terminal window to create hw1 executable file;
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

#include <iostream>
#include <iomanip>
#include <string>
#include <list>
#include <vector>
#include <iterator>
#include <stdlib.h>
#include <cstdlib>

using namespace std;

//Class: Transaction
//Description: This class is the base class for all base classes
class Transaction{
protected:
	string type;
	string name;
	string accountType;
	int number;
public:
	string getType();
	virtual double getInfo() = 0;
};
//Function: getType
//Description: get the type of transaction
string Transaction::getType(){
	return type;
}

//Class: Deposit
//Description: This class is for deposits
class Deposit : public Transaction{
private:
	double amount;
public:
	Deposit(string, string, double, int);
	virtual double getInfo();
};
//Constructor: Deposit()
//Description: Creates a deposit object
Deposit::Deposit(string nameIn, string accountIn, double amountIn, int numIn){
	type = "Deposit";
	name = nameIn;
	accountType = accountIn;
	amount = amountIn;
	number = numIn;
}
//Function: Get Info
//Description: Gets the info for this transaction
double Deposit::getInfo(){
	cout << "Transaction #" << number << endl;
	cout << type << endl;
	cout << "Name: " << name << endl;
	cout << "Account Type: " << accountType << endl;
	cout << "Amount: " << amount << endl;
	return amount;
}

//Class: Withdrawal
//Description: This class is for withdrawal
class Withdrawal : public Transaction{
private:
	double amount;
public:
	Withdrawal(string, string, double, int);
	virtual double getInfo();
};
//Constructor: Withdrawal()
//Description: Creates a withdrawal object
Withdrawal::Withdrawal(string nameIn, string accountIn, double amountIn, int numIn){
	type = "Withdrawal";
	name = nameIn;
	accountType = accountIn;
	amount = amountIn;
	number = numIn;
}
//Function: Get Info
//Description: Gets the info for this transaction
double Withdrawal::getInfo(){
	cout << "Transaction #" << number << endl;
	cout << type << endl;
	cout << "Name: " << name << endl;
	cout << "Account Type: " << accountType << endl;
	cout << "Amount: " << amount << endl;
	return amount;
}


//Class: CreateAccount
//Description: This class is for new accounts
class CreateAccount : public Transaction{
public:
	CreateAccount(string, string, int);
	virtual double getInfo();
};
//Constructor: CreateAccount
//Description: Creates a new account object
CreateAccount::CreateAccount(string nameIn, string accountIn, int numIn){
	type = "Account Created";
	name = nameIn;
	accountType = accountIn;
	number = numIn;
}
//Function: Get Info
//Description: Gets the info for this transaction
double CreateAccount::getInfo(){
	cout << "Transaction #" << number << endl;
	cout << type << endl;
	cout << "Name: " << name << endl;
	cout << "Account Type: " << accountType << endl;
	return -1;
}

//Class: CreateAccountCD
//Description: Creates a new accountCD object
class CreateAccountCD : public Transaction{
private:
	double rate;
public:
	CreateAccountCD(string, string, double, int);
	virtual double getInfo();
};
//Constructor: CreateAccountCD
//Description: Creates a new account object
CreateAccountCD::CreateAccountCD(string nameIn, string accountIn, double rateIn, int numIn){
	type = "Account Created";
	name = nameIn;
	accountType = accountIn;
	rate = rateIn;
	number = numIn;
}
//Function: Get Info
//Description: Gets the info for this transaction
double CreateAccountCD::getInfo(){
	cout << "Transaction #" << number << endl;
	cout << type << endl;
	cout << "Name: " << name << endl;
	cout << "Account Type: " << accountType << endl;
	cout << "Rate: " << rate << endl;
	return -1;
}

//Class: BankAccount
//Description: baseclass for account types
class BankAccount{
protected:
	string ownerName;
	string accountType;
	double balance;
	vector<Transaction*> transactions;
public:
	void deposit(double, int);
	string getName();
	string getAccountType();
	double getBalance();
	virtual void printTransactions() = 0;
	virtual double computeBankBalance(int) = 0;
	virtual int withdraw(double, int) = 0;
};
//Function: deposit
//Description: makes a deposit into the bankAccount obj
void BankAccount::deposit(double amountIn, int transNum){
	balance += amountIn;
	transactions.push_back(new Deposit(this->ownerName, 
		this->accountType, amountIn, transNum));
}
//Function: GetName
//Description: gets the owner's name
string BankAccount::getName(){
	return ownerName;
}
//Function: get account type
//Description: get the type of account
string BankAccount::getAccountType(){
	return accountType;
}
//Function: get balance
//Description: get the balance of the account
double BankAccount::getBalance(){
	return balance;
}
//Class: SavingAccount
//Description: is also a bank account
class SavingAccount : public BankAccount{
public:
	SavingAccount(string, int);
	virtual void printTransactions();
	virtual double computeBankBalance(int);
	virtual int withdraw(double, int);
};
//Constructor: SavingAccount
//Description: creates a savingAcc obj
SavingAccount::SavingAccount(string nameIn, int transNum){
	ownerName = nameIn;
	accountType = "Savings Account";
	balance = 0;
	transactions.push_back(new CreateAccount(this->ownerName, this->accountType, transNum));
}
//Function: printTransactions
//Description: print all transactions
void SavingAccount::printTransactions(){
	for (unsigned int i = 0; i < transactions.size(); i++)	{
		transactions[i]->getInfo();
		cout << endl;
	}
}
//Function: computeBankBalance
//Description: compute the bank balance
double SavingAccount::computeBankBalance(int all){
	double sum = 0;
	for (unsigned int i = 0; i < transactions.size(); i++)	{
		if (transactions[i]->getType() == "Deposit")
		{
			sum += transactions[i]->getInfo();
		}
		else if (transactions[i]->getType() == "Withdrawal")
		{
			sum -= transactions[i]->getInfo();
		}
		else if (all == 1) {
			transactions[i]->getInfo();
		}
		cout << endl;
	}
	return sum;
}
//Function: withdraw
//Description: withdraw from savings account
int SavingAccount::withdraw(double amountIn, int transNum){
	if (amountIn < 0) return 0;
	balance -= amountIn;
	transactions.push_back(new Withdrawal(this->ownerName, this->accountType, amountIn, transNum));
	return 1;
}

//Class: Checking Account
//Description: also a bank account
class CheckingAccount : public BankAccount{
public:
	CheckingAccount(string, int);
	virtual void printTransactions();
	virtual double computeBankBalance(int);
	virtual int withdraw(double, int);
};
//Constructor: CheckingAccount
//Description: constructs a checking account
CheckingAccount::CheckingAccount(string nameIn, int transNum){
	ownerName = nameIn;
	accountType = "Checkings Account";
	balance = 0;
	transactions.push_back(new CreateAccount(this->ownerName, this->accountType, transNum));
}
//Function: printTransactions
//Description: print all of the checking acc transactions
void CheckingAccount::printTransactions(){
	for (unsigned int i = 0; i < transactions.size(); i++)	{
		transactions[i]->getInfo();
		cout << endl;
	}
}
//Function: computeBankBalance
//Description: compute checking acc balance
double CheckingAccount::computeBankBalance(int all){
	double sum = 0;
	for (unsigned int i = 0; i < transactions.size(); i++)	{
		if (transactions[i]->getType() == "Deposit")
		{
			sum += transactions[i]->getInfo();
		}
		else if (transactions[i]->getType() == "Withdrawal")
		{
			sum -= transactions[i]->getInfo();
			if (sum < 500) {
				sum -= 2.50;
				cout << "Withdrawal Fee: $ 2.50" << endl;
			}
		}
		else if (all == 1) {
			transactions[i]->getInfo();
		}
		cout << endl;
	}
	if (sum != balance) cout << "balance doesn't equal sum: " << balance << " ";
	return sum;
}
//Function: withdraw
//Description: from checking acc
int CheckingAccount::withdraw(double amountIn, int transNum){
	if (amountIn < 0) return 0;
	balance -= amountIn;
	if (balance < 500) {
		balance -= 2.50;
		cout << "Fee: $ 2.50" << endl;
	}
	transactions.push_back(new Withdrawal(this->ownerName, this->accountType, amountIn, transNum));
	return 1;
}

//Class: MoneyMarketAccount
//Description: also a bank account
class MoneyMarketAccount : public BankAccount{
public:
	MoneyMarketAccount(string, int);
	virtual void printTransactions();
	virtual double computeBankBalance(int);
	virtual int withdraw(double, int);
private:
	int numWithdrawals;
};
//Constructor: MoneyMarketAccount
//Description: creates a moneymarketaccount
MoneyMarketAccount::MoneyMarketAccount(string nameIn, int transNum){
	ownerName = nameIn;
	accountType = "Money Market Account";
	balance = 0;
	numWithdrawals = 0;
	transactions.push_back(new CreateAccount(this->ownerName, this->accountType, transNum));
}
//Function: printTransactions
//Description: print all money market transactions
void MoneyMarketAccount::printTransactions(){
	for (unsigned int i = 0; i < transactions.size(); i++){
		transactions[i]->getInfo();
		cout << endl;
	}
}
//Function: computeBankBalance
//Description: compute money market balance
double MoneyMarketAccount::computeBankBalance(int all){
	double sum = 0;
	int withdraws = 0;
	for (unsigned int i = 0; i < transactions.size(); i++)
	{
		if (transactions[i]->getType() == "Deposit")
		{
			sum += transactions[i]->getInfo();
		}
		else if (transactions[i]->getType() == "Withdrawal")
		{
			sum -= transactions[i]->getInfo();
			if (withdraws > 1) {
				sum -= 1.50;
				cout << "Fee: $ 1.50" << endl;
			}

			withdraws++;

		}
		else if (all == 1) {
			transactions[i]->getInfo();
		}
		cout << endl;
	}
	return sum;
}
//Function: withdraw
//Description: withdraw from moneymarketaccount
int MoneyMarketAccount::withdraw(double amountIn, int transNum){
	if (amountIn < 0) return 0;
	balance -= amountIn;
	if (numWithdrawals > 1) {
		balance -= 1.50;
		cout << "Fee: $ 1.50" << endl;
	}
	numWithdrawals++;
	transactions.push_back(new Withdrawal(this->ownerName, this->accountType, amountIn, transNum));
	return 1;
}

//Class:  CDAccount
//Description: also a bankAccount
class CDAccount : public BankAccount{
public:
	CDAccount(string, double, int);
	virtual void printTransactions();
	virtual double computeBankBalance(int);
	virtual int withdraw(double, int);
private:
	double rate;
};
//Constructor: CDAccount
//Description: creates a CDAccount object
CDAccount::CDAccount(string nameIn, double rateIn, int transNum){
	ownerName = nameIn;
	accountType = "CD Account";
	balance = 0;
	rate = rateIn;
	transactions.push_back(new CreateAccountCD(this->ownerName, this->accountType, rateIn, transNum));
}
//Function: printTransactions
//Description: print CDAcount transactions
void CDAccount::printTransactions(){
	for (unsigned int i = 0; i < transactions.size(); i++)	{
		transactions[i]->getInfo();
		cout << endl;
	}
}
//Function: computeBankBalance
//Description: compute CDAccount balance
double CDAccount::computeBankBalance(int all){
	double sum = 0;
	double fee;
	for (unsigned int i = 0; i < transactions.size(); i++)
	{
		if (transactions[i]->getType() == "Deposit")
		{
			sum += transactions[i]->getInfo();
		}
		else if (transactions[i]->getType() == "Withdrawal")
		{
			fee = sum*(rate / 100)*.25;
			sum -= transactions[i]->getInfo();
			sum -= fee;
			cout << "Withdrawal Penalty: $ " << setprecision(2) << fixed << fee << endl;
		}
		else if (all == 1) {
			transactions[i]->getInfo();
		}
		cout << endl;
	}
	return sum;
}
//Function: withdraw
//Description: withdraw from CDAccount
int CDAccount::withdraw(double amountIn, int transNum){
	double fee;
	if (amountIn < 0) return 0;
	fee = balance*(rate / 100)*.25;
	balance -= fee;
	balance -= amountIn;
	cout << "Fee: $ " << fee << endl;
	transactions.push_back(new Withdrawal(this->ownerName, this->accountType, amountIn, transNum));
	return 1;
}

//Class: AubieBank
//Description: Aubie Bank class for the program as a whole
class AubieBank{
private:
	int numTransactions;
	vector<BankAccount*> activeAccounts;
	double systemBalance;
public:
	void runProgram();
	BankAccount *findAccount(string, string);
	string getAccountType();
	int createNewAccount();
	int deposit();
	int withdraw();
	int transfer();
	int inquiry();
	void printAll();
	void computeBalance();
};
//Function: computeBalance
//Description: compute the balance of the bank
void AubieBank::computeBalance(){
	double BankBalance = 0;
	for (unsigned int i = 0; i < activeAccounts.size(); i++) {
		BankBalance += activeAccounts[i]->computeBankBalance(0);
	}
	cout << "System Balance:  $ " << setprecision(2) << fixed << BankBalance << endl;
}
//Function: printAll
//Description: prints all of the balances for the accounts
void AubieBank::printAll(){
	for (unsigned int i = 0; i < activeAccounts.size(); i++) {
		activeAccounts[i]->computeBankBalance(1);
	}
}
//Function: inquiry
//Description:  Inquiry on the balance of an account of any type
int AubieBank::inquiry(){
	string name;
	string accountType;
	BankAccount *accountPtr;
	cout << "Enter name: ";
	cin >> name;
	accountType = getAccountType();
	accountPtr = findAccount(name, accountType);
	if (accountPtr == NULL) return 0;
	cout << "Balance:  $ " << setprecision(2) << fixed << accountPtr->getBalance() << endl;
	return 1;
}
//Function: transfer
//Description: transfer funds from one account to another
int AubieBank::transfer(){
	string name1, name2;
	string accountType1, accountType2;
	double amount;
	BankAccount *accountPtr1, *accountPtr2;

	cout << "Enter name of first account: ";
	cin >> name1;
	accountType1 = getAccountType();
	accountPtr1 = findAccount(name1, accountType1);
	if (accountPtr1 == NULL) return 0;

	cout << "Enter name of second account: ";
	cin >> name2;
	accountType2 = getAccountType();
	accountPtr2 = findAccount(name2, accountType2);
	if (accountPtr2 == NULL) return 0;

	cout << "Enter transfer amount: $ ";
	cin >> amount;
	accountPtr1->withdraw(amount, numTransactions);
	numTransactions++;
	accountPtr2->deposit(amount, numTransactions);
	numTransactions++;

	cout << "Balance of first account: $ " << setprecision(2) << fixed << accountPtr1->getBalance() << endl;
	cout << "Balance of second account: $ " << setprecision(2) << fixed << accountPtr2->getBalance() << endl;
	return 1;
}
//Function: withdraw
//Description: withdraws funds from an account
int AubieBank::withdraw(){
	string name;
	string accountType;

	double amount;
	BankAccount *accountPtr;

	cout << "Enter name: ";
	cin >> name;
	accountType = getAccountType();
	accountPtr = findAccount(name, accountType);
	if (accountPtr == NULL) return 0;

	cout << "Enter withdrawal amount: $ ";
	cin >> amount;
	if (accountPtr->getBalance() < amount) return 2;
	accountPtr->withdraw(amount, numTransactions);
	numTransactions++;

	cout << "Balance: $ " << setprecision(2) << fixed << accountPtr->getBalance() << endl;
	systemBalance -= amount;
	return 1;
}
//Function: deposit
//Description: make a deposit into an account
int AubieBank::deposit(){
	string name;
	string accountType;
	double amount;
	BankAccount *accountPtr;

	cout << "Enter name: ";
	cin >> name;

	accountType = getAccountType();
	accountPtr = findAccount(name, accountType);
	if (accountPtr == NULL) return 0;
	cout << "Enter deposit amount: $ ";
	cin >> amount;

	accountPtr->deposit(amount, numTransactions);
	numTransactions++;
	cout << "Balance: $ " << setprecision(2) << fixed << accountPtr->getBalance() << endl;
	systemBalance += amount;
	return 1;
}
//Function: getAccountType
//Description: get the account type
string AubieBank::getAccountType(){
	int accountType;
	do
	{
		cout << "Enter account type ((1) Checking, (2) Savings, (3) Money Market, (4) CD): ";
		cin >> accountType;
		//cout << endl;
	} while (accountType > 4 && accountType < 1);
	switch (accountType){
	case 1:
		return "Checkings Account";
		break;
	case 2:
		return "Savings Account";
		break;
	case 3:
		return "Money Market Account";
		break;
	case 4:
		return "CD Account";
		break;
	}
	return "";
}
//Function: createNewAccount
//Description: create a new account
int AubieBank::createNewAccount(){
	string name;
	int accountType;
	double rate;

	cout << "Enter name: ";
	cin >> name;
	do
	{
		cout << "Enter account type ((1) Checking, (2) Savings, (3) Money Market, (4) CD): ";
		cin >> accountType;
		//cout << endl;
	} while (accountType > 4 && accountType < 1);
	switch (accountType)
	{
	case 1:
		if (findAccount(name, "Checkings Account") == NULL)
		{
			activeAccounts.push_back(new CheckingAccount(name, numTransactions));
			numTransactions++;
			return 1;
		}
		break;
	case 2:
		if (findAccount(name, "Savings Account") == NULL)
		{
			activeAccounts.push_back(new SavingAccount(name, numTransactions));
			numTransactions++;
			return 1;
		}
		break;
	case 3:
		if (findAccount(name, "Money Market Account") == NULL)
		{
			activeAccounts.push_back(new MoneyMarketAccount(name, numTransactions));
			numTransactions++;
			return 1;
		}
		break;
	case 4:
		do {
			cout << "Enter interest rate (in percentage): ";
			cin >> rate;
		} while (rate < 0);
		if (findAccount(name, "CD Account") == NULL)
		{
			activeAccounts.push_back(new CDAccount(name, rate, numTransactions));
			numTransactions++;
			return 1;
		}
		break;
	}
	return 0;
}
//Function: runProgram
//Description: this is the AubieBank's run process/cycle
void AubieBank::runProgram(){
	int input;
	int error;
	numTransactions = 1;
	systemBalance = 0;
	do
	{
		//Welcome the user
		cout << "\n        ===========================================================" << endl;
		cout << "        |                  Welcome to Aubie Bank!                 |" << endl;
		cout << "        ===========================================================\n" << endl;

		cout << endl << "Select an option: (1) Create account, (2) Deposit fund, (3) Withdraw fund, (4)" << endl;
		cout << "Transfer fund, (5) Inquiry, (6) Print All Transactions, (7) Print Bank Balance," << endl;
		cout << "(8) Quit: ";
		do
		{
			cin >> input;
			cout << endl;
		} while (input < 1 && input > 8);
		switch (input)
		{
		case 1:
			if (createNewAccount() != 1) cout << "Account already exists" << endl;
			break;
		case 2:
			if (deposit() != 1) cout << "Account not found" << endl;
			break;
		case 3:
			error = withdraw();
			if (error == 2) cout << "Amount exceeds balance" << endl;
			if (error == 0) cout << "Account already exists" << endl;
			break;
		case 4:
			if (transfer() != 1) cout << "Account not found" << endl;
			break;
		case 5:
			if (inquiry() != 1) cout << "Account not found" << endl;
			break;
		case 6:
			printAll();
			break;
		case 7:
			computeBalance();
			break;
		case 8:
			break;
		default:
			break;
		}
	} while (input != 8);
}

//Function: findAccount
//Description: find account given a name and type
BankAccount *AubieBank::findAccount(string ownerIn, string accountTypeIn){
	for (unsigned int i = 0; i < activeAccounts.size(); i++)	{
		if (activeAccounts[i]->getName() == ownerIn && activeAccounts[i]->getAccountType() == accountTypeIn)		{
			return activeAccounts[i];
		}
	}
	return NULL;
}

//Function: the main function
//Description: runs the program
int main(){
	AubieBank aubieBank;
	aubieBank.runProgram();

}