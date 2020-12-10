TITLE Name/Age Exercise	(Lab 1)				(main.asm)
INCLUDE Irvine32.inc

.data

;nums WORD 10 20 30 40  ; Array of four words

;BYTE ?

;BYTE 256

;WORD 'x'

;WORD "Hello",0

;twofiftyfive WORD FFh            ;, 0Dh, 0Ah, 0; Hexadecimal FF

;ebp BYTE "ebp",0 ; Null-terminated string ebp

;empty DWORD 4*1024 DUP(?)


.code
main PROC
	call Clrscr
	;mov edx, offset twofiftyfive
	;call WriteString

	;==========================================================================================
	
	COMMENT ! This is problem 14 in october 12th reading questions
	;Implement the following C++ expression in assembly language, using 32-bit unsigned operands:
	;val1 = (val2 * val3) / (val4 - 3)

	;(val2 * val3) 
	mov eax,val2 ; left side
	mov ebx,val3
	mul ebx ; EDX:EAX = product

	;(val4 - 3)
	mov ebx, val4 ; right side
	sub ebx,3

	; divide EDX:EAX by EBX
	div ebx ; final division
	mov val1, eax
	!

	;==========================================================================================


	;Implement the following C++ expression in assembly language, using 32-bit signed operands:
	; val1 = (val2 / val3) * (val1 + val2)

	; (val2 /val3)
	mov eax, val2		;left side
	mov ebx, val3
	cdq					; sign-extend dividend
	idiv				; EDX = remainder

	;(val1 + val2)
	mov ebx, val1
	add ebx, val2

	; multiply the quotient by EBX 
	imul ebx,
	mov val1, eax


	exit

main ENDP
END main

