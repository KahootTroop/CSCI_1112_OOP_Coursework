# TicTacToe

## Synopsis
This is a 2 player game of Tic-Tac-Toe. 2 Players enter their names and then compete to win the game.

## Motivation
This project was made with JavaFX to demonstrate some of the new things I learned in Object Oriented Programming 2

## How to Run
To play this game you just need one computer for the players to share. 
Each player will enter their name and then take turns placing tiles on the game board to try and get 3 in a row.
[Gameplay Example](GamePlay.png)

## Code Example
This piece of code checks every cell in the grid to see if a tile has been placed. 
If every cell has a tile assigned to it this method returns true and the game is a draw.
```
public boolean isDraw() {
	for(int i = 0; i < 3; i++) {
		for(int j = 0; j < 3; j++) {
			if(cell[i][j].getSymbol() == 'n') {
				return false;
			}
		}
	}
	return true;
}
```
