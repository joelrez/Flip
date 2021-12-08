# Flip
Flip is a game that I quickly wrote up in Java. I came up with the rules of the game, and it turns out this puzzle idea has already been done in "Between Time: Escape Room." In the future, I might want to make this game into a mobile app.

# How to Play
On the board there will be X's and O's, and by clicking on them, they switch to the other. For instance, if you click an X it will "flip" to an O, and vice versa. In addition, that X or O's adjacent cells will also flip. The objective of the game is to get all O's on the board like below.

![image](https://user-images.githubusercontent.com/32008471/145199228-b11f86dc-23c2-44d3-92d3-52e93480c221.png)

The interface has been made so that the user can create their own puzzles by randomly clicking in the grid or allow the algorithm to randomly generate a puzzle. Currently, they are really easy because the algorithm only flips about 10 cells.

# Development Ideas
* I would like to have a history of all moves the user has made after randomization. So that if someone is unhappy with the moves they made up to that point, they could return to the original state of the puzzle or undo moves.
* I want to allow the user to select how many cells they'd like randomly flipped. Maybe by increasing the difficulty or manually selecting the exact number. I am unsure at the moment.
