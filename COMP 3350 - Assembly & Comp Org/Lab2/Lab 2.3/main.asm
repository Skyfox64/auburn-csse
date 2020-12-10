TITLE Name/Age Exercise	(Lab 1)				(main.asm)
INCLUDE Irvine32.inc

.data


.code
main PROC
	call Clrscr

	; 1. Read a nonnegative integer from the keyboard.
Read: 
      call ReadDec
	  mov ecx, eax
	  ;call WriteDec

	; 2. The user is not allowed to enter zero.
	;    If n is 0, go back to step 1(Read).
	  jecxz read

	; 3. Display the first n positive integers, 
	;    where n is the input from the user.
	  mov eax, 1

Display: 
	  call WriteDec
	  sub ecx, 1
	  add eax, 1
	  jecxz Done
	  jmp Display

Done: 
      nop

	exit
main ENDP

END main