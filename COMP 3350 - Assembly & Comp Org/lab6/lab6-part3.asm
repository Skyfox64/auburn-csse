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

.data
szClassName BYTE "sampleWindow", 0
szTitle     BYTE "COMP 3350 Windows Application", 0
szError     BYTE "Error", 0

WNDCLASS_START = $
cbSize        DWORD WNDCLASS_END - WNDCLASS_START
style         DWORD 0
lpfnWndProc   DWORD OFFSET DefWindowProcA
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

	; Create a 500x100-pixel window
	push 0
	push hInstance
	push 0
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

	; FIXME: ADD MESSAGE LOOP HERE

	; Exit cleanly
	push 0
	call ExitProcess

error:
	; Display a generic error message and exit uncleanly
	push MB_ICONERROR
	push OFFSET szError
	push OFFSET szError
	push 0
	call MessageBoxA
	push 1
	call ExitProcess
main ENDP
END