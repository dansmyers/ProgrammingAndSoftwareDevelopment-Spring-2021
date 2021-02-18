# Recursion Practice

## Everyone Needs a Hobby

<img src="https://upload.wikimedia.org/wikipedia/commons/4/41/White_Temple_ziggurat_in_Uruk.jpg" width="35%" />

*The Anu ziggurat was built by the ancient Sumerians at the city of Uruk in approximately 4000 BCE.*

One of my favorite activities is building stone ziggurats in my backyard. To build an *n*-level ziggurat, I first lay down an *n* x *n* square of stones for the first level, then
an (*n* - 1) x (*n* - 1) square of stones for the second level, and so forth, until I finally place a single stone on the top.

Write a **recursive function** called `stones` that takes a positive integer *n* as input and calculates the total number of stones in an *n*-level ziggurat.
For example, a four-level structure has

4<sup>2<sup> + 3<sup>2<sup> + 2<sup>2<sup> + 1 = 30

total stones.

Tip:

The recursive relationship is

```
stones(n) = n * n + stones(n - 1)
```

Think about the base case: What value of *n* allows you to return immediately without doing any recursive work?


## Mutant Bunnies

A group of *n* bunnies are standing in a line. The bunnies at odd-numbered positions have the standard two ears, but the bunnies standing at even-numbered positions are **mutated**
and have ***three*** ears.

Write a **recursive function** called `ears` to calculate the total number of ears in a line of *n* bunnies.

The base case is one bunny having the requisite two ears. The recursive case has the general form:

```
ears(n) = ears for the Nth bunny + ears(n - 1)
```

That is, the total number of ears for the line of *n* bunnies is the number of ears on bunny *n* plus the total ears of the remaining *n - 1* bunnies. The number of ears for
bunny *n* is either two or three, depending on whether *n* is even or odd.


## Towers of Hanoi

<img src="https://upload.wikimedia.org/wikipedia/commons/0/07/Tower_of_Hanoi.jpeg" width="35%" />

You have probably seen the classic Towers of Hanoi game, played with disks and three pegs. The object is to move all of the disks from the starting peg to a different peg.
You can move only one disk at a time and you can never place a larger disk on top of a smaller disk.

Use this online version to play a few games of the Towers of Hanoi: https://www.mathsisfun.com/games/towerofhanoi.html.

- How many moves does it take to solve the puzzle of two disks?

- How many moves for three disks?

- How about four disks?

The app will actually tell you the minimum number of moves in each case. As you solve the puzzle, keep track of the sequence of moves that generates the minimal value.




