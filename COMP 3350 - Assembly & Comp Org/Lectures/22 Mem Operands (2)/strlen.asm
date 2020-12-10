INCLUDE Irvine32.inc

.data
hi    BYTE "Hello", 0
bye   BYTE "See you", 0
crlf_ BYTE 0Dh, 0Ah, 0
empty BYTE 0

.code
strlen PROC
; Returns the length of a null-terminated string
; Receives: EDX -- Pointer to string
; Returns: EAX -- Length of string

      push edx

      mov eax, 0              ; Store length in EAX, initially 0
next: cmp BYTE PTR [edx], 0   ; while the byte pointed to by EDX is not 0 {
      je done
      inc edx                 ;     point EDX at the next byte
      inc eax                 ;     length++
      jmp next                ; }

done: pop edx
      ret
strlen ENDP

main PROC
    mov edx, OFFSET hi
    call strlen
    call WriteDec

    mov edx, OFFSET bye
    call strlen
    call WriteDec

    mov edx, OFFSET crlf_
    call strlen
    call WriteDec

    mov edx, OFFSET empty
    call strlen
    call WriteDec

    exit
main ENDP

END main
