TITLE Name/Age Exercise	(Lab 1)				(main.asm)
INCLUDE Irvine32.inc

.data
;myMessage BYTE "MASM program example", 0dh, 0ah, 0

nameInput BYTE 128 DUP(0)
askName BYTE "Please enter your name: ", 0

yearInput BYTE 128 DUP(0)
askYear BYTE "What year were you born? ", 0

returnPart1 BYTE "Hello, ", 0
returnPart2 BYTE ". At the end of this year, you'll be ", 0
returnPart3 BYTE " years old.", 0dh, 0ah, 0


.code
main PROC
	call Clrscr

	;mov	 edx,OFFSET myMessage
	;call WriteString

	;Display "Please enter your name: "
	mov edx, offset askName
	call WriteString

	;Read the user's name from the input
	mov edx, offset nameInput
	mov ecx, sizeof nameInput
	call ReadString

	;Displays "What year were you born? "
	mov edx, offset askYear
	call WriteString

	;Reads a nonnegative integer (a year) from the input
	mov edx, offset yearInput
	mov eax, sizeof yearInput
	call ReadDec

	;Display "Hello, name. At the end of this year, you'll be age years old."
	; Hello
	mov edx, offset returnPart1
	call WriteString

	; name
	mov edx, offset nameInput
	call WriteString

	; at the.... you'll be
	mov edx, offset returnPart2
	call WriteString

	; age
	mov edx, 2014
	sub edx, eax
	mov eax, edx
	call WriteDec

	; finish the string
	mov edx, offset returnPart3
	call WriteString


	exit
main ENDP

END main