#NoEnv  ; Recommended for performance and compatibility with future AutoHotkey releases.
; #Warn  ; Enable warnings to assist with detecting common errors.
SendMode Input  ; Recommended for new scripts due to its superior speed and reliability.
SetWorkingDir %A_ScriptDir%  ; Ensures a consistent starting directory.
#SingleInstance, force

; Author: Cameron Hetzler
; README
; Some of this, like the program file name for the XPanel
; process and the name of the input files are hard coded.
; Don't hit me
; Input: processors.csv
; seperate each value by a single ',' no spaces
; include full url with .classtech.ncsu.edu
; Seperate program name must be ScreenDown

WinWaitActive, XPanel - ScreenDown
CoordMode, Mouse, Relative
if (WaitPixelColor(0xBC7100,980,780,60000) == 2) {
    MsgBox, Program timed out`nExiting
    Return
}
Loop, Read, %A_ScriptDir%\processors.csv
{
    LineNumber = %A_Index%
    Loop, parse, A_LoopReadLine, csv
    {
        ;MsgBox, , , %A_LoopField%, 1
        ;alt
        Send {Alt}
        sleep, 250
        ;right
        Send {Right}
        sleep, 250
        ;enter
        Send {Enter}
        sleep, 250
        ;enter
        Send {Enter}
        sleep, 250
        ;tab
        Send {Tab}
        sleep, 250
        ;type
        Send %A_LoopField%
        sleep, 200
        
        ;confirm the connection settings
        Click, 95, 304
        ;conditional wait
        WinWaitActive, XPanel - ScreenDown
        if (WaitPixelColor(0x56D800, 325, 178, 5000) == 2) {
            MsgBox Connection Timeout: %A_LoopField%`nExiting
            Return
        }
        ;succeful connection attempt, continue
        
        ; I'm double clicking because it can't hurt and to
        ; decrease the chance of it not registering until
        ; I find a better method of making sure that it does
        ; register

        ;left 95 304
        Click, 327, 467
        sleep, 400
        ;left 95 304
        Click, 327, 467
        sleep, 1000
        

        ;right 706 454
        Click, 700, 460
        sleep, 400
        ;right 706 454
        Click, 700, 460
        sleep, 800
    }
}
return

; An emergency close method
^space::
ExitApp, 1

; Author: https://github.com/MasterFocus
; This method will execute a loop that looks for when the requested color at a given
; location appears. If it timesout before then it will return an error code.
WaitPixelColor(p_DesiredColor,p_PosX,p_PosY,p_TimeOut=0,p_GetMode="",p_ReturnColor=0) {
    l_Start := A_TickCount
    Loop {
        PixelGetColor, l_OutputColor, %p_PosX%, %p_PosY%, %p_GetMode%
        If ( ErrorLevel )
            Return ( p_ReturnColor ? l_OutputColor : 1 )
        If ( l_OutputColor = p_DesiredColor )
            Return ( p_ReturnColor ? l_OutputColor : 0 )
        If ( p_TimeOut ) && ( A_TickCount - l_Start >= p_TimeOut )
            Return ( p_ReturnColor ? l_OutputColor : 2 )
    }
}