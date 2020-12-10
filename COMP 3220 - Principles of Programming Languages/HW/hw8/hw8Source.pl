/*
********************************************************
 * PROGRAM NAME - hw8 (Homework 8)
 * PROGRAMMER - John Carroll
 * IDE - SWI-Prolog
 * DATE - Started 12/1/2014       Completed 12/1/2014
 * DESCRIPTION -  This program has multiple function
 *                definitions. (5)
 * RUN INSTRUCTIONS - 1. Compile inside of SWI-Prolog
 *		      2. call functions from terminal,
 *			 follow example
 ********************************************************
*/

/*Question 1: Using the structures parent(X,Y), male(X), and female(X),
	write a Prolog structure that defines sister(X,Y).

Call example: sister(X, charlotte).
*/
parent(chris, charlotte).
parent(chris, sharona).
female(charlotte).
female(sharona).
male(wilbur).
male(hamilton).
sister(X,Y):-
	parent(Z,X),
	parent(Z,Y),
	female(X).

/*Question 2: Write a Prolog program that finds the maximum of a list of
numbers.

Call example: maximum([1, 5, 10, 13, 4, 99, 5000], X).
*/
maximum([M],M).
maximum([M|List],Max):-
	Max=M,maximum(List,Max1),
	M>=Max1.
maximum([M|List],Max):-
	Max=Max1,
	maximum(List,Max1),
	M< Max1.

/*Question 3: Write a Prolog program that succeeds if the intersection of two
given list parameters is empty

Call example: intersection([1,5,10,15],[1,4,9,15,16],X).
*/
intersection([X|Y],I,[X|Z]) :-
	member(X,I),
	intersection(Y,I,Z).
intersection([X|Y],I,Z) :-
	\+ member(X,I),
	intersection(Y,I,Z).
intersection([],I,[]).

/*Question 4: Write a Prolog program that returns a list containing the union of
the elements of two given lists.

Call example: union([1,2,3],[0,2,4],X).
*/
union([ ], X, X).
union([X|R], Y, Z):-
	member(X, Y),
	!,
	union(R, Y, Z).
union([X|R], Y, [X|Z]):-
	union(R, Y, Z).

/*Question 5: Write a Prolog program that implements Quicksort.

Call example: quicksort([8,6,7,5,3,0,9],X).
*/
quicksort([], []).
quicksort([X|Tail], Sorted) :-
    split(X, Tail, Small, Big),
    quicksort(Small, SortedSmall),
    quicksort(Big, SortedBig),
    append(SortedSmall, [X|SortedBig], Sorted).
split(X, [], [], []).
split(X, [Y|Tail], [Y|Small], Big) :-
    X > Y, !,
    split(X, Tail, Small, Big).
split(X, [Y|Tail], Small, [Y|Big]) :-
    split(X, Tail, Small, Big).


