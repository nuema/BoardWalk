# BOARD WALK

This is a very silly TDD exercise for JAVA.

It is about a NxN board labelled consecutively. 
That can be walked through by actions.

## Logic

It works using an Enum of **Actions**, a **Position** just to modelate de matrix pair,
 a Board(Board) of configurable size and 
  a BoardWalk wich handles the actions keeping the list of "_moves_".
  
A "_game_" is an ordered list of actions to run. 
These actions creates "_moves_" that are recorded in the moves list as Positions.

The result of the walk is to show the positions label (or value).

## Supported actions
- FW ->  Moves a step to the next column 
- DOWN ↓ Moves a step to the next row 
- BACK <- Moves a step to the column before
- UP ↑ Moves a step to the row before

### 3x3 board positions

(0,0) (0,1) (0,2)

(1,0) (1,1) (1,2)

(2,0) (2,1) (2,2)


### Board labels

1 2 3

4 5 6

7 8 9

#### Example 1
Given Board 3x3

Actions:  FW FW FW

Moves result: [1, 2, 3]

#### Example 2
Given Board 3x3

Actions:  DOWN FW BACK UP
Moves result: [1, 4, 5, 4, 1]











