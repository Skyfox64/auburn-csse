;
; John Carroll
;
; Answers to Lab Questions:
; 1. It is a lowercase i, for information, in a blue circle
; 2. MB_ICONASTERISK
;    MB_ICONINFORMATION
; 3. DispatchMessage: Dispatches a message to a window procedure. 
;    It is typically used to dispatch a message retrieved by the GetMessage function.
; 4. stdcall: This is because there are 16 bytes in the argument list.
; 5. WM_DESTROY: It's sent when a window is being destroyed. 
;    It is sent to the window procedure of the window being destroyed after the window 
;    is removed from the screen.
; 6. szFile and szExit: The & specifies the letter immediately following it to be underlined.
; 7. WM_COMMAND: Sent when the user selects a command item from a menu, when a control 
;    sends a notification message to its parent window, or when an accelerator keystroke 
;    is translated.

.586
.model flat, stdcall
option casemap:none

; Win32 API constants
; ===================

MB_ICONERROR = 10h
MB_ICONINFORMATION = 40h
CW_USEDEFAULT = 80000000h
SW_SHOWNORMAL = 1
WS_OVERLAPPEDWINDOW = 0CF0000h
WM_DESTROY = 2h
MF_POPUP = 10h
MF_STRING = 0h
WM_COMMAND = 111h

; Win32 API functions
; ===================

ExitProcess PROTO, dwExitCode:DWORD

GetModuleHandleA PROTO,
	lpModuleName:DWORD

RegisterClassExA PROTO,
	lpwcx:DWORD

DefWindowProcA PROTO,
	hWnd:DWORD,
	msg:DWORD,
	wParam:DWORD,
	lParam:DWORD

CreateWindowExA PROTO,
	dwExStyle:DWORD,
	lpClassName:DWORD,
	lpWindowName:DWORD,
	dwStyle:DWORD,
	x:DWORD,
	y:DWORD,
	nWidth:DWORD,
	nHeight:DWORD,
	hWndParent:DWORD,
	hMenu:DWORD,
	hInstance:DWORD,
	lpParam:DWORD

ShowWindow PROTO,
	hWnd:DWORD,
	nCmdShow:DWORD

MessageBoxA PROTO,
	dWnd:DWORD,
	lpText:PTR BYTE,
	lpCaption:PTR BYTE,
	uType:DWORD

GetMessageA PROTO,
	lpMsg:DWORD,
	hWnd:DWORD,
	wMsgFilterMin:DWORD,
	wMsgFilterMax:DWORD

TranslateMessage PROTO,
	lpMsg:DWORD

DispatchMessageA PROTO,
	lpMsg:DWORD

PostQuitMessage PROTO,
	nExitCode:DWORD

CreateMenu PROTO

AppendMenuA PROTO,
	hMenu:DWORD,
	uFlags:DWORD,
	uIDNewItem:DWORD,
	lpNewItem:DWORD

.data
szClassName BYTE "sampleWindow", 0
szTitle     BYTE "COMP 3350 Windows Application", 0
szError     BYTE "Error", 0
szFile BYTE "&File", 0
szExit BYTE "E&xit", 0
hMenu DWORD ?
hMenuFile DWORD ?
msg BYTE 28 DUP(?)
mbGoodbye   BYTE "Goodbye", 0

WNDCLASS_START = $
cbSize        DWORD WNDCLASS_END - WNDCLASS_START
style         DWORD 0
lpfnWndProc   DWORD OFFSET MainWindowProc@16
cbClsExtra    DWORD 0
cbWndExtra    DWORD 0
hInstance     DWORD 0
hIcon         DWORD 0
hCursor       DWORD 0
hbrBackground DWORD 6
lpszMenuName  DWORD 0
lpszClassName DWORD OFFSET szClassName
hIconSm       DWORD 0
WNDCLASS_END = $

.code
main PROC
	; Get the instance handle
	push 0
	call GetModuleHandleA
	mov hInstance, eax

	; Register a window class
	push WNDCLASS_START
	call RegisterClassExA
	cmp eax, 0
	je error

	; Create the menu bar
	call CreateMenu
	cmp eax, 0
	je error
	mov hMenu, eax

	; Create the File menu
	call CreateMenu
	cmp eax, 0
	je error
	mov hMenuFile, eax

	; Add an Exit item to the File menu
	push OFFSET szExit
	push 0
	push MF_STRING
	push hMenuFile
	call AppendMenuA
	cmp eax, 0
	je error

	; Add the File menu to the menu bar
	push OFFSET szFile
	push hMenuFile
	push MF_POPUP
	push hMenu
	call AppendMenuA
	cmp eax, 0
	je error

	; Create a 500x100-pixel window
	push 0
	push hInstance
	push hMenu
	push 0
	push 100
	push 500
	push CW_USEDEFAULT
	push CW_USEDEFAULT
	push WS_OVERLAPPEDWINDOW
	push OFFSET szTitle
	push OFFSET szClassName
	push 0
	call CreateWindowExA
	cmp eax, 0
	je error

	; Show the window
	push SW_SHOWNORMAL
	push eax
	call ShowWindow

	; MESSAGE LOOP HERE
loopCondition:
	push 0
	push 0
	push 0
	push OFFSET msg

	call GetMessageA
	cmp eax, 0
	je done

	push OFFSET msg
	call TranslateMessage

	push OFFSET msg
	call DispatchMessageA

	jmp loopCondition
	
	; Exit cleanly
done:
	push 0
	call ExitProcess
	
	; Display a generic error message and exit uncleanly
error:
	push MB_ICONERROR
	push OFFSET szError
	push OFFSET szError
	push 0
	call MessageBoxA

	push 1
	call ExitProcess
main ENDP

MainWindowProc@16 PROC
	hWnd EQU DWORD PTR [ebp+8]
	uMsg EQU DWORD PTR [ebp+12]
	wParam EQU DWORD PTR [ebp+16]
	lParam EQU DWORD PTR [ebp+20]

	enter 0, 0

	push lParam
	push wParam
	push uMsg
	push hWnd

	;Replace DefWindowProcA
	cmp uMsg, WM_COMMAND
	je goodbyeMsg

	cmp uMsg, WM_DESTROY
	je postquitMsg

	call DefWindowProcA
	jmp done

goodbyeMsg:
	push 0
	push OFFSET mbGoodbye
	push OFFSET mbGoodbye
	push 0
	call MessageBoxA

postquitMsg:
	push 0
	call PostQuitMessage
	mov eax, 0

done:
	leave
	ret 16
MainWindowProc@16 ENDP
END