CREATE TABLE Accounts (
	AccountID int AUTO_INCREMENT,
	CustomerID int NOT NULL,
	Status int NOT NULL,
	Permission int NOT NULL,
	CreationDate datetime NOT NULL,
	Password varchar(15),
	PRIMARY KEY (AccountID),
	FOREIGN KEY (CustomerID) REFERENCES Customers(CustomerID)
);
CREATE TABLE AuthorBios (
	AuthorBioID int AUTO_INCREMENT,
	BioText varchar(150) NOT NULL,
	PRIMARY KEY (AuthorBioID)
);
CREATE TABLE AuthorReviews ( 
	AuthorReviewID int AUTO_INCREMENT,
	AuthorID int NOT NULL,
	AccountID int NOT NULL,
	Rating int NOT NULL,
	Text varchar(100) NOT NULL,
	PRIMARY KEY (AuthorReviewID),
	FOREIGN KEY (AuthorID) REFERENCES Authors(AuthorID),
	FOREIGN KEY (AccountID) REFERENCES Accounts(AccountID)
);
CREATE TABLE Authors (
	AuthorID int AUTO_INCREMENT,
	FirstName varchar(25) NOT NULL,
	LastName varchar(25) NOT NULL,
	AuthorBioID int NOT NULL,
	PRIMARY KEY (AuthorID),
	FOREIGN KEY (AuthorBioID) REFERENCES AuthorBios(AuthorBioID)
	
);
CREATE TABLE BookDescriptions (
	BookDescriptionID int AUTO_INCREMENT,
	Description varchar(150) NOT NULL,
	PRIMARY KEY (BookDescriptionID)
);
CREATE TABLE BookReviews (
	BookReviewID int AUTO_INCREMENT,
	BookID int NOT NULL,
	AccountID int NOT NULL,
	Rating int NOT NULL,
	Text varchar(100) NOT NULL,
	PRIMARY KEY (BookReviewID),
	FOREIGN KEY (BookID) REFERENCES Books(BookID),
	FOREIGN KEY (AccountID) REFERENCES Accounts(AccountID)
);
CREATE TABLE BookTypes(
	BookTypeID int AUTO_INCREMENT,
	BookType varchar(25),
	PRIMARY KEY (BookTypeID)
);
CREATE TABLE Books (
	BookID int AUTO_INCREMENT,
	Title varchar(50) NOT NULL,
	ISBN int NOT NULL,
	NumPages int NOT NULL,
	Quantity int NOT NULL,
	AuthorID int NOT NULL,
	BookDescriptionID int NOT NULl,
	GenreID int NOT NULL,
	BookTypeID int NOT NULL,
	PRIMARY KEY (BookID),
	FOREIGN KEY (AuthorID) REFERENCES Authors(AuthorID),
	FOREIGN KEY (BookDescriptionID) REFERENCES BookDescriptions(BookDescriptionID),
	FOREIGN KEY (BookID) REFERENCES Books(BookID),
	FOREIGN KEY (GenreID) REFERENCES Genres(GenreID),
	FOREIGN KEY (BookTypeID) REFERENCES BookTypes(BookTypeID)
);
CREATE TABLE Customers (
	CustomerID int AUTO_INCREMENT,
	FirstName varchar(25) NOT NULL,
	LastName varchar(25) NOT NULL,
	PRIMARY KEY (CustomerID)
);
CREATE TABLE Genres (
	GenreID int AUTO_INCREMENT,
	Genre varchar(25) NOT NULl,
	PRIMARY KEY (GenreID)
);
CREATE TABLE Reports(
	ReportID int AUTO_INCREMENT,
	AccountID int NOT NULL,
	BookID int NOT NULL,
	StartDate datetime NOT NULL,
	DueDate datetime NOT NULL,
	PickedUp tinyint(1) NOT NULL,
	Late tinyint(1) NOT NULL,
	Lost tinyint(1) NOT NULl,
	Active tinyint(1) NOT NULL,
	PRIMARY KEY (ReportID),
	FOREIGN KEY (BookID) REFERENCES Books(BookID),
	FOREIGN KEY (AccountID) REFERENCES Accounts(AccountID)
);
CREATE TABLE WaitReports (
	BookID int NOT NULL,
	AccountID int NOT NULL,
	StartDate datetime NOT NULL,
	EndDate datetime,
	Active tinyint(1) NOT NULL,
	FOREIGN KEY (BookID) REFERENCES Books.BookID,
	FOREIGN KEY (AccountID) REFERENCES Accounts.AccountID
);
INSERT INTO Customers
VALUES(0, 'Josh', 'Gaston');
INSERT INTO Accounts
VALUES(0, 1, 0, 0, '2015-11-27 01:01:01', 'asdf');
INSERT INTO BookTypes
VALUES(0, "Reference");
INSERT INTO BookTypes
VALUES(0, "Hardback");
INSERT INTO BookTypes
VALUES(0, "Paperback");
INSERT INTO Genres
VALUES(0, "Action");
INSERT INTO Genres
VALUES(0, "Romance");
INSERT INTO Genres
VALUES(0, "Fantasy");
INSERT INTO Genres
VALUES(0, "Nonfiction");





DROP TABLE Accounts;
DROP TABLE AuthorBios;
DROP TABLE AuthorReviews;
DROP TABLE Authors;
DROP TABLE BookDescriptions;
DROP TABLE BookReviews;
DROP TABLE BookTypes;
DROP TABLE Books;
DROP TABLE Customers;
DROP TABLE Genres;
DROP TABLE Reports;
DROP TABLE WaitReports;