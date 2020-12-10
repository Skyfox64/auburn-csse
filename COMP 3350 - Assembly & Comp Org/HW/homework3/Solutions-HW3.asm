TITLE COMP 3350 Homework 3 (Fa14) - Sample Solution
INCLUDE Irvine32.inc

COUNT = 10      ; Number of values to input

.data
prompt   BYTE   "Enter a value: ", 0
error    BYTE   "Out of range", 0Dh, 0Ah, 0
space    BYTE   " ", 0
values   SWORD  COUNT DUP(?)

.code
main PROC

    ; Read values into array
    mov ecx, 0
read:
    mov edx, OFFSET prompt              ; Input signed integer
    call WriteString
    call ReadInt

    cmp eax, -32768                     ; Reject out-of-range values
    jl outOfRange
    cmp eax, 32767
    jg outOfRange

    mov [values + ecx*SIZEOF WORD], ax  ; Store in values array
    inc ecx

    cmp ecx, COUNT                      ; Stop after reading COUNT values
    je displayReverse
    jmp read

    ; Display the array in reverse order
displayReverse:
    dec ecx                                 ; ECX counts down COUNT-1, ..., 0
    movsx eax, [values + ecx*SIZEOF WORD]   ; Display value
    call WriteInt
    mov edx, OFFSET space                   ; Display space
    call WriteString
    jecxz displayPrefixSum                  ; Done displaying when ECX = 0
    jmp displayReverse

    ; Display the prefix sum of the array
displayPrefixSum:
    call Crlf
    mov eax, 0          ; Use EAX to store prefix sum
    mov ecx, 0          ; Use ECX as a loop counter

next:                                           ; ECX counts up 0, ..., COUNT-1
    movsx ebx, [values + ecx*SIZEOF WORD]       ; EBX = current value
    add eax, ebx                                ; EAX = current prefix sum
    call WriteInt                               ; Display current prefix sum
    mov edx, OFFSET space                       ;     followed by space
    call WriteString
    inc ecx
    cmp ecx, COUNT                              ; Exit when ECX reaches COUNT
    je done
    jmp next

outOfRange:                     ; Error handling (for out-of-range inputs)
    mov edx, OFFSET error
    call WriteString

done:
    call Crlf
    exit
main ENDP

END main
