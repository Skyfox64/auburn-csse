INCLUDE Irvine32.inc

.code
main PROC
	push 99999999h
	push 99999999h
	push 99999999h
	push 99999999h

	; Add the numbers 0 + 1 + 2 + 3 = 6
	push 3
	call AddDownToZero
	call WriteDec
	exit
main ENDP

AddDownToZero PROC
	enter 0,0

	; Load the argument into EAX and check if it's zero
	mov eax, DWORD PTR [ebp+8]
	cmp eax, 0
	jne recurse

	; Argument is 0; no more recursion
	jmp done

recurse:
	; Invoke AddDownToZero on the next smallest natural number
	dec eax
	push eax
	call AddDownToZero

	; Add the argument value to the result of the recursive call
	add eax, DWORD PTR [ebp+8]

done:
	leave
	ret 4
AddDownToZero ENDP

END main