# Othello (Reversi)

Othello (Reversi) is a two players (X & O) board game. Players take alternate turns.

'X' goes first and *must* place an 'X' on the board, in such a position that there exists at least one straight (horizontal, vertical, or diagonal) occupied line of 'O's between the new 'X' and another 'X' on the board.

After placing the piece, all 'O's lying on all straight lines between the new 'X' and any existing 'X' are captured (i.e. they turn into 'X's )

Now 'O' plays. 'O' operates under the same rules, with the roles reversed: 'O' places an 'O' on the board in such a position where *at least one* 'X' is captured

Moves are specified as coordinates. Column+row or row+column (e.g. 3d or d3)

If a player cannot make a valid move (_capturing at least one of the opposing player's pieces along a straight line_), play passes back to the other player.

The game ends when either
 1. neither player can make a valid move
 2. the board is full

The player with the most pieces on the board at the end of the game wins.

For more detail: https://en.wikipedia.org/wiki/Reversi

### Pre-requisites
- Java 8 (JDK 1.8.0_161 or equivalent)
- Maven

### Build And Run Instructions
Compile and package up the game:
```
$ mvn clean package
$ java -jar F:\workspace\Othello\target\Othello-1.0-SNAPSHOT-jar-with-dependencies.jar com.prashu.othello.Game 
```

### Game Starting Position
```
Let's Play Othello (Reversi)

        a       b       c       d       e       f       g       h
1       -       -       -       -       -       -       -       -       1
2       -       -       -       -       -       -       -       -       2
3       -       -       -       -       -       -       -       -       3
4       -       -       -       O       X       -       -       -       4
5       -       -       -       X       O       -       -       -       5
6       -       -       -       -       -       -       -       -       6
7       -       -       -       -       -       -       -       -       7
8       -       -       -       -       -       -       -       -       8
        a       b       c       d       e       f       g       h

PlayerX : 2,    PlayerO : 2,    Empty Spots : 60

Possible spots for PlayerX: 4
```

##### Player X Places Move 4C
```
PlayerX:
4C

        a       b       c       d       e       f       g       h
1       -       -       -       -       -       -       -       -       1
2       -       -       -       -       -       -       -       -       2
3       -       -       -       -       -       -       -       -       3
4       -       -       X       X       X       -       -       -       4
5       -       -       -       X       O       -       -       -       5
6       -       -       -       -       -       -       -       -       6
7       -       -       -       -       -       -       -       -       7
8       -       -       -       -       -       -       -       -       8
        a       b       c       d       e       f       g       h

PlayerX : 4,    PlayerO : 1,    Empty Spots : 59

Possible spots for PlayerO: 3
```

##### Player  Places Move 3C
```
PlayerO:
3C

        a       b       c       d       e       f       g       h
1       -       -       -       -       -       -       -       -       1
2       -       -       -       -       -       -       -       -       2
3       -       -       O       -       -       -       -       -       3
4       -       -       X       O       X       -       -       -       4
5       -       -       -       X       O       -       -       -       5
6       -       -       -       -       -       -       -       -       6
7       -       -       -       -       -       -       -       -       7
8       -       -       -       -       -       -       -       -       8
        a       b       c       d       e       f       g       h

PlayerX : 3,    PlayerO : 3,    Empty Spots : 58

Possible spots for PlayerX: 4

PlayerX:
```

##### Game continues...

### Special Scenarios
See com.prashu.othello.GameTest for few interesting cases when neither player can make a move

For example: For the sequence of moves mentioned below, the game gets stuck where neither of the player can make a move and both the players have same score (30) so game ties
```
E6F4C3C4D3D6C5C6D7B5B6F7A6A5B4A7F3C8E8C7F6E7G8G6F8F5G4E3D2H3G5G3H4H5H7D8B8A4B3D1C1B1C2E1E2A3B7F2F1G1B2A2G2H6H2G7
```

##### Output
```
Possible spots for PlayerO: 1

PlayerO:

	a	b	c	d	e	f	g	h
1	-	O	O	O	O	O	O	-	1
2	O	O	O	O	O	O	X	X	2
3	O	X	O	X	O	X	X	X	3
4	O	X	X	O	X	O	X	X	4
5	O	X	O	X	O	X	O	X	5
6	O	X	X	X	X	O	O	X	6
7	O	X	X	O	O	O	O	X	7
8	-	X	X	X	X	X	X	-	8
 	a	b	c	d	e	f	g	h

PlayerX : 30,	PlayerO : 30,	Empty Spots : 4

Possible spots for PlayerX: 0
No possible moves for PlayerX

Possible spots for PlayerO: 0
No possible moves for PlayerO
No possible moves for either of the Player. Game is finished.
```