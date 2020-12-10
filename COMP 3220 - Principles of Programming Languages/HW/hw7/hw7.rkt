#lang racket

#|
********************************************************
 * PROGRAM NAME - hw7 (Homework 7)
 * PROGRAMMER - John Carroll
 * SYSTEM - Coded in DrRacket
 * DATE - Started 11/18/2014       Completed 11/20/2014
 * DESCRIPTION -  This program has multiple function 
 *                definitions. (5)
 ********************************************************
|#

#|
Question 1 - Write a DrRacket (formerly DrScheme) function that takes an expression as its
         argument and returns a non-nested list of all atoms found in the expression. Example,
         (squash ‘(a (a (a (a b))) (((a b) b) b) b)) returns (a a a a b a b b b b)).
|#
(define (parse lst)
  (cond ((null? lst) '())
        ((not (list? lst)) (list lst))
        ((append (parse (car lst))
                 (parse (cdr lst))))))
;Execution
(display "Question 1 : \n")
(parse '(a (a (a (a b))) (((a b) b) b) b))
(parse '(1 (2 (3)) (4 5))) 
(parse '(Hello (how(are(you)) (doing) ( Dave?))))

#|
Question 2 - Write a DrRacket function that determines whether an integer is divisible by 3
         (e.g., (divisible-by-three 6) returns #t).
|#
(define (divisible-by-3? x)
  (and (number? x) (divisible? x 3)))
(define (divisible? big small)
  (= (remainder big small) 0))

;Execution
(display "Question 2 : \n")
(divisible-by-3? 0)
(divisible-by-3? 2)
(divisible-by-3? 5)
(divisible-by-3? 9)
(divisible-by-3? 3)
(divisible-by-3? 36)

#|
Question 3 - Write a DrRacket function that that can sort a list in ascending or descending
         order (by making the comparison operator a parameter). The sorting algorithm should be
         INSERTION SORT.
|#
(define (insertionsort element comparator lst)
  (cond
    [(or (empty? lst) (comparator element (first lst))) (cons element lst)]
    [else (cons (first lst) (insertionsort element comparator (rest lst)))]))
;Demo for insertionsort
(define (insertionsort-demo comparator lst)
  (cond
    [(empty? lst) empty]
    [else (insertionsort (first lst) comparator (insertionsort-demo comparator (rest lst)))]))

;Execution
(display "Question 3 : \n")
(insertionsort-demo > '( 9 8 7 6 5 4 3 2 1 1 2 4 5 6 7 8 5 4 2 5 6))
(insertionsort-demo < '( 9 8 7 6 5 4 3 2 1 1 2 4 5 6 7 8 5 4 2 5 6))
(insertionsort-demo = '( 9 8 7 6 5 4 3 2 1 1 2 4 5 6 7 8 5 4 2 5 6))
#|
Question 4 - Write a DrRacket function, palindrome, that tests its argument to see if it is a
         list that has the same sequence of symbols when read from right to left as when it is read
         from left to right.
|#
(define (palindrome str)
  (let* ([lst (string->list (string-downcase str))]
         [slst (remove* '(#\space) lst)])
    (string=? (list->string (reverse slst)) (list->string slst))))

;Execution
(display "Question 4 : \n")
(palindrome "RACECAR")
(palindrome "MONKEY")
(palindrome "MOM")
(palindrome "DAD")
(palindrome "DUDE")

#|
Question 5 - Write the Quicksort algorithm in DrRacket.
|#
;Quicksort function
(define quicksort (lambda (list)
                    (cond ((null? list) list)
                          (else
                          (let ((lx (partition list)))
                            (append (quicksort (car lx)) (cons (cadr lx) (quicksort (caddr lx)))))))))
;Pivot function, used for Quicksort
(define pivot (lambda (all chk list list2)
                  (cond ((null? all) (cons list (cons chk (cons list2 '()))))
                        (else
                        (let ((x (car all)))
                          (if (<= x chk) 
                              (pivot (cdr all) chk (cons x list) list2)
                              (pivot (cdr all) chk list (cons x list2))))))))
;Partition function, used for Quicksort
(define partition (lambda (list)
                      (pivot (cdr list) (car list) '() '())))

;Execution
(display "Question 5 : \n")
(quicksort '(948 785 632 45 147 89 7856 98 320))
(quicksort '(88888888 4444 666666 222222 55555 7777777 333 22 1))
(quicksort '(8 4 6 1 9 5 7 3 2))
