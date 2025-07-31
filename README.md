# Robot Controller Emulator (RT-104)

## Overview

This project is a Java-based emulator of a virtual processor (RT-104) controlling a turtle-like robot navigating through a maze. 
The program reads two files specified by the user: 
- Maze Layout File: Contains the maze structure with walls and open paths.
- Program File: Contains assembly-like instructions for the robot.

It then interprets and executes the instructions to simulate the robot's movements and interactions with its environment.

## Features

- Reads maze and program files from user input
- Initializes the robot’s position and orientation
- Interprets a set of assembly-like instructions
- Tracks movement, collisions, and instructions executed
- Outputs formatted execution trace

### Supported Instructions

| Instruction      | Description |
|------------------|-------------|
| `ava imm`        | Move forward up to `imm` steps (stops if a wall is encountered) |
| `tad`            | Turn right (clockwise) |
| `tag`            | Turn left (counterclockwise) |
| `met imm`        | Bitwise AND with current memory cell |
| `mou imm`        | Bitwise OR with current memory cell |
| `s label`        | Unconditional jump to `label` |
| `sma label`      | Jump to `label` if wall ahead |
| `sez imm label`  | Jump to `label` if `(imm & mem) == 0` |
| `sou imm label`  | Jump to `label` if `(imm | mem) == 15` |
| `sdi dir label`  | Jump to `label` if direction is `dir` (`n`, `s`, `e`, `w`) |
| `fin`            | Ends program execution |

## Usage

1. Run the application.
2. Enter:
    - The **maze filename** (e.g., `lab1.txt`)
    - The **program filename** (e.g., `prog1.txt`)
    - The starting **column** and **row** of the robot
3. The program loads the maze and instructions, initializes the robot, and starts interpreting.
4. After each instruction:
    - Displays the current instruction index (CO), position, and direction
5. When finished:
    - Displays the number of executed instructions
    - Displays the number of moves and collisions

## Example

```text
Enter the maze file name:
lab1.txt
Enter the RT-104 program file name:
prog1.txt
Enter turtle's starting column:
1
Enter turtle's starting row:
0
0 : ( 1, 0 ) East
1 : ( 3, 0 ) East
2 : ( 3, 0 ) South
...
12 : ( 1, 2 ) West
Number of instructions executed: 12
Number of movements: 11
Number of collisions: 1
```