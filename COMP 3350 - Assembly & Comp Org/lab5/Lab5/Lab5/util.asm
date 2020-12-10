.model flat, c
.code
; Computes the minimum of two signed, 32-bit integers
; Receives: [ebp+8] Int 1 (a)
;			[ebp+12] Int 2 (b)
; Returns: EAX Minimum of a and b
minimum PROC
	enter 0, 0

	;Compute the theorem
	;Thm: min = b xor ((a xor b) & ((a-b)>>s 31))

	;ecx = a xor b
		mov eax, [ebp+8]
		mov ebx, [ebp+12] 
		xor eax, ebx	
		mov ecx, eax	; move into ecx

	;edx = (a-b)>>s 31)
		mov eax, [ebp+8]
		sub eax, ebx	; (a-b)
		jno skip
		neg eax
skip:		
		sar eax, 31		; arithemetic shift right 31 times
		mov edx, eax	; move into edx		

	;ecx = ((a xor b) & ((a-b)>>s 31))
		and ecx, edx	

	;eax = b xor ecx
		mov eax, [ebp+12] 
		xor eax, ecx	

		leave
		ret		
minimum ENDP
END