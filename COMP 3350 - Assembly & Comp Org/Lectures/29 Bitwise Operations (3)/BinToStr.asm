INCLUDE Irvine32.inc

.data
buffer BYTE 33 DUP(?)

.code
main PROC
         ; Store a 32-character string in buffer
         ; with the binary representation of 42
         push OFFSET buffer
         push 42
         call BinToStr

                   ; Display the string
         mov edx, OFFSET buffer
         call WriteString
    exit
main ENDP

; (STDCALL) Stores a null-terminated string with the binary representation of a
;           32-bit unsigned integer value.
; Receives: [ebp+8]  DWORD value to convert
;           [ebp+12] Pointer to buffer (>= 33 bytes)
; Returns:  (none)
BinToStr PROC
         enter 0, 0
         push eax
         push ecx
         push edi

         mov eax, [ebp+8]          ; EAX = Value to convert
         mov edi, [ebp+12]         ; EDI = Pointer to buffer
         mov ecx, 32               ; ECX counts down 32, 31, ..., 1

nextBit: shl eax, 1
         jc one
isZero:  mov BYTE PTR [edi], '0'
         jmp incdec
isOne:   mov BYTE PTR [edi], '1'

incdec:  inc edi
         dec ecx
         jecxz done
         jmp nextBit

done:    mov BYTE PTR [edi], 0

         pop edi
         pop ecx
         pop eax
         leave
         ret 8
BinToStr ENDP

END main
