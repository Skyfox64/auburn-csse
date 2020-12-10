TITLE COMP 3350 Homework 4 (Fa14) - John Carroll

INCLUDE Irvine32.inc

.code
;==============================================================================
; ucase - Receives the offset of a null-terminated string.  Changes all
;         lowercase characters in the string to uppercase, leaving all other
;         characters (numbers, punctuation, etc.) as-is.
;
; Receives: ESI  Offset of string
; Returns:  None (string is modified in-place)
;==============================================================================
ucase PROC
	; Push ESI and EAX to the stack
		push esi							
		push eax
lowerthecase:								; Top of the loop
	; Look at the first chracter byte by moving into EAX, what is at the pointer, ESI
		movzx eax, BYTE PTR [esi]			
	; Jump to done if eax is 0, null
		cmp eax, 0	
		je done	

	; Change all lowercase characters in the string to uppercase, leaving all other
	; characters (numbers, punctuation, etc.) as-is.	
	; Check if the byte has an ASCII value less than 'a', if so
	; ignore this character byte and move on to the next.
		cmp eax, 61h						
		jb ignore			

	; Check if the byte has an ASCII value greater than 'z', if so
	; ignore this character byte and move on to the next.
		cmp eax, 7ah						
		ja ignore								

	; Subtract 20h from the ASCII value of the lower case letter
	; replace the lower case letter with same uppercase letter
		sub eax, 20h						
		mov [esi], al						

ignore:										; Ignore if it is anything but lowercase
		inc esi								; Increment ESI pointer to get next character byte
		jmp lowerthecase					; repeat

done:										; Procedure is done
	; Return EAX and ESI to the caller
		pop eax								
		pop esi								
		ret									; Return to the caller

ucase ENDP


;==============================================================================
; strrchr - Receives two arguments, (1) the offset of a null-terminated string
;           and (2) an ASCII code, and returns (in EAX) the zero-based index of
;           the last character in the string with the given ASCII code, or -1
;           if the string does not contain the given character.  The final
;           null character is considered to be part of the string, so a search
;           for the ASCII code 0 will return the index of the terminating NULL.
;
; Receives: ESI  Offset of string
;           AL   ASCII code to search for (must be 0-127, inclusive)
; Returns:  EAX  Zero-based index, or -1 if not found
;==============================================================================
strrchr PROC
	; Push EBX, ECX, EDX, ESI onto the stack
		push ebx							
		push ecx							
		push edx							
		push esi							

	; Initialize EBX as the index counter
		mov ebx, 0							
	; EDX will be -1, or FALSE unless the given character is found
		mov edx, -1						

compareChar:									; Top of the loop
	; Look at the first chracter byte by moving into EAX, what is at the pointer, ESI
		movzx ecx, BYTE PTR[esi]		

	; Check if the current character byte matches the target, if so
	; jump to "found"
		cmp cl, al							
		je found							

continueCondition:							; Decide if it should continue searching
	; If the current byte is 0, then the string is done being checked and the procedure is done
		cmp cl, 0						
		je done							
	; Else, keep checking. Increment ESI to move to the next byte in the string.
	; Increment the index counter as well.
		inc esi							
		inc ebx							
		jmp compareChar							; Repeat search from the top

found:										; The target has been found
		mov edx, ebx						; Update EDX with the current zero-based index
		jmp continueCondition				; Continue to the continue condition label

done:										; Procedure is done
	; Return in EAX the most up to date EDX
		mov eax, edx						
	; Pop ESI, EDX, ECX, EBX off of the stack and back to caller
		pop esi								
		pop edx								
		pop ecx							
		pop ebx								
		ret									; Return to the caller
		
strrchr ENDP

;==============================================================================
; pow - Returns a to the nth power, as described in the assignment sheet.
;
; Receives: EAX  a  Signed 32-bit integer
;           EBX  n  Signed 32-bit integer (must be >= 1)
; Returns:  EAX  Result, assuming n >= 1 and it is in range
;==============================================================================
pow PROC
	; Push EBX, ECX, EDX, ESI onto the stack
		push ebx							
		push ecx							
		push edx							
		push esi					
				
	; Set ECX to 2 to test if even
		mov ecx, 2							
		mov esi, eax						; ESI holds the base value
	
	; If exponent is 1, if so then jump to done
		cmp ebx, 1							
		je done							

	; Else move the exponent into EAX to be divided
		mov eax, ebx					
		cdq								; Convert/extend DWORD in EAX to QWORD in EDX:EAX
		div ecx							; Check if even by dividing EAX by ECX(2) 
		
	; If remainder(EDX) is 1, then handle as odd exponent
		cmp edx, 1						
		je oddHandle		
						
	; Recursive Calling
	; Even exponent handling
		; Prior to recursive call, place new exponent into EBX, reset the orignal "a" into eax
			mov ebx, eax					
			mov eax, esi					
			call pow						

			IMUL eax					; Multiply EAX by itself
			jmp done					; The procedure is done

	; Odd exponent handling
oddHandle:				
		; Prior to recursive call, place new exponent into EBX, reset the orignal "a" into eax				
			mov ebx, eax					
			mov eax, esi				
			call pow					
				
			IMUL eax					; Multiply EAX by itself
			
			IMUL esi					; Multiply EAX by "a"
			jmp done					; The procedure is done

done:									; The procedure is done 
	; Pop ESI, EDX, ECX, EBX off of the stack and back to caller
		pop esi								
		pop edx								
		pop ecx							
		pop ebx
		ret								; Return to the caller
		
pow ENDP


.data
mmmkay BYTE "It's easy, MMMkay!", 0

test1 BYTE "abcde", 0
test2 BYTE "It's easy, MMMkay!", 0
test3 BYTE ":-)", 0
test4 BYTE 0
test5 BYTE 0

expected1 BYTE "ABCDE", 0
expected2 BYTE "IT'S EASY, MMMKAY!", 0
expected3 BYTE ":-)", 0
expected4 BYTE 0

test_number DWORD 0

CR = 13
LF = 10
msgUFail BYTE "Failed ucase test #", 0
msgSFail BYTE "Failed strrchr test #", 0
msgPFail BYTE "Failed pow test #", 0
msgPassed BYTE "All tests passed!", CR, LF, 0

.code
main PROC

	; ===== UCASE TESTS =====

	; Keep ucase number in test_number
	mov test_number, 0

	; Test 1: ucase("abcde") == "ABCDE"
	inc test_number
	mov esi, OFFSET test1
	call ucase
	INVOKE Str_compare, ADDR test1, ADDR expected1
	jnz ufailed

	; Test 2: ucase("It's easy, MMMkay!") == "IT'S EASY, MMMKAY!"
	inc test_number
	mov esi, OFFSET test2
	call ucase
	INVOKE Str_compare, ADDR test2, ADDR expected2
	jnz ufailed

	; Test 3: ucase(":-)") == ":-)"
	inc test_number
	mov esi, OFFSET test3
	call ucase
	INVOKE Str_compare, ADDR test3, ADDR expected3
	jnz ufailed

	; Test 4: ucase("") == ""
	inc test_number
	mov esi, OFFSET test4
	call ucase
	INVOKE Str_compare, ADDR test4, ADDR expected4
	jnz ufailed

	; Test 5: Check that ucase does not change registers except EAX
	inc test_number
	mov ebx, 1234
	mov ecx, 2345
	mov edx, 5432
	mov edi, 4567
	push 5678
	mov esi, OFFSET test5
	call ucase
	pop eax
	cmp eax, 5678
	jne ufailed
	cmp edi, 4567
	jne ufailed
	cmp esi, OFFSET test5
	jne ufailed
	cmp ecx, 2345
	jne ufailed
	cmp ebx, 1234
	jne ufailed
	cmp edx, 5432
	jne ufailed

	; ===== STRRCHR TESTS =====

	; Keep strrchr test number in test_number
	mov test_number, 0

	; Test 1: strrchr("It's easy, MMMKay!", 'I') == 0
	inc test_number
	mov al, 'I'
	mov esi, OFFSET mmmkay
	call strrchr
	cmp eax, 0
	jne sfailed

	; Test 2: strrchr("It's easy, MMMKay!", '''') == 2
	inc test_number
	mov al, ''''
	mov esi, OFFSET mmmkay
	call strrchr
	cmp eax, 2
	jne sfailed

	; Test 3: strrchr("It's easy, MMMKay!", 'M') == 13
	inc test_number
	mov al, 'M'
	mov esi, OFFSET mmmkay
	call strrchr
	cmp eax, 13
	jne sfailed

	; Test 4: strrchr("It's easy, MMMKay!", '!') == 17
	inc test_number
	mov al, '!'
	mov esi, OFFSET mmmkay
	call strrchr
	cmp eax, 17
	jne sfailed

	; Test 5: strrchr("It's easy, MMMKay!", 0) == 18
	inc test_number
	mov al, 0
	mov esi, OFFSET mmmkay
	call strrchr
	cmp eax, 18
	jne sfailed

	; Test 6: strrchr("It's easy, MMMKay!", 'x') == -1
	inc test_number
	mov al, 'x'
	mov esi, OFFSET mmmkay
	call strrchr
	cmp eax, -1
	jne sfailed

	; Test 7: Check that strrchr does not change registers except EAX
	inc test_number
	mov ebx, 1234
	mov ecx, 2345
	mov edx, 5432
	mov edi, 4567
	push 5678
	mov al, 'x'
	mov esi, OFFSET mmmkay
	call strrchr
	pop eax
	cmp eax, 5678
	jne sfailed
	cmp edi, 4567
	jne sfailed
	cmp esi, OFFSET mmmkay
	jne sfailed
	cmp ecx, 2345
	jne sfailed
	cmp ebx, 1234
	jne sfailed
	cmp edx, 5432
	jne sfailed

	; ===== POW TESTS =====

	; Keep pow number in test_number
	mov test_number, 0

	; Test 1: pow(1, 1) == 1
	inc test_number
	mov eax, 1
	mov ebx, 1
	call pow
	cmp eax, 1
	jne pfailed

	; Test 2: pow(5, 1) == 5
	inc test_number
	mov eax, 5
	mov ebx, 1
	call pow
	cmp eax, 5
	jne pfailed

	; Test 3: pow(-3, 1) == -3
	inc test_number
	mov eax, -3
	mov ebx, 1
	call pow
	cmp eax, -3
	jne pfailed
	
	; Test 4: pow(0, 2) == 0
	inc test_number
	mov eax, 0
	mov ebx, 2
	call pow
	cmp eax, 0
	jne pfailed
	
	; Test 5: pow(5, 2) == 25
	inc test_number
	mov eax, 5
	mov ebx, 2
	call pow
	cmp eax, 25
	jne pfailed
		
	; Test 6: pow(-6, 2) == 36
	inc test_number
	mov eax, -6
	mov ebx, 2
	call pow
	cmp eax, 36
	jne pfailed
		
	; Test 7: pow(2, 3) == 8
	inc test_number
	mov eax, 2
	mov ebx, 3
	call pow
	cmp eax, 8
	jne pfailed
		
	; Test 8: pow(-2, 3) == -8
	inc test_number
	mov eax, -2
	mov ebx, 3
	call pow
	cmp eax, -8
	jne pfailed

	; Test 9: pow(5, 4) == 625
	inc test_number
	mov eax, 5
	mov ebx, 4
	call pow
	cmp eax, 625
	jne pfailed

	; Test 10: pow(-5, 4) == 625
	inc test_number
	mov eax, -5
	mov ebx, 4
	call pow
	cmp eax, 625
	jne pfailed

	; Test 11: pow(6, 5) == 7776
	inc test_number
	mov eax, 6
	mov ebx, 5
	call pow
	cmp eax, 7776
	jne pfailed

	; Test 12: pow(-7, 5) == -16807
	inc test_number
	mov eax, -7
	mov ebx, 5
	call pow
	cmp eax, -16807
	jne pfailed

	; Test 13: pow(-1, 12345) == -1
	inc test_number
	mov eax, -1
	mov ebx, 12345
	call pow
	cmp eax, -1
	jne pfailed

	; Test 14: Check that pow does not change registers except EAX
	inc test_number
	mov eax, 0
	mov ebx, 1234
	mov ecx, 2345
	mov edx, 5432
	mov esi, 4321
	mov edi, 4567
	push 5678
	call pow
	pop eax
	cmp eax, 5678
	jne pfailed
	cmp edi, 4567
	jne pfailed
	cmp esi, 4321
	jne pfailed
	cmp ecx, 2345
	jne pfailed
	cmp ebx, 1234
	jne pfailed
	cmp edx, 5432
	jne pfailed

	; If we reach this point, all tests passed
	mov edx, OFFSET msgPassed
	call WriteString
	jmp done

ufailed:
	; ucase test (number in EDX) failed
	mov edx, OFFSET msgUFail
	call WriteString
	mov eax, test_number
	call WriteDec
	jmp done
sfailed:
	; strrchr test (number in EDX) failed
	mov edx, OFFSET msgSFail
	call WriteString
	mov eax, test_number
	call WriteDec
pfailed:
	; pow test (number in EDX) failed
	mov edx, OFFSET msgPFail
	call WriteString
	mov eax, test_number
	call WriteDec
done:
	exit
main ENDP

END main