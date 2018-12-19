#NoEnv  ; Recommended for performance and compatibility with future AutoHotkey releases.
; #Warn  ; Enable warnings to assist with detecting common errors.
SendMode Input  ; Recommended for new scripts due to its superior speed and reliability.
SetWorkingDir %A_ScriptDir%  ; Ensures a consistent starting directory.
#SingleInstance, force


~LButton::
CoordMode, Mouse, Relative
MouseGetPos, xpos, ypos
PixelGetColor, color, xpos, ypos
CoordMode, Mouse, Screen
MouseGetPos, xspos, yspos
FileAppend, `n%xpos% %ypos% REL`n%xspos% %yspos% ABS`n%color%`n, %A_ScriptDir%\mouseOutput.txt
Return

^Space::
Run notepad.exe %A_ScriptDir%\mouseOutput.txt
ExitApp, 1