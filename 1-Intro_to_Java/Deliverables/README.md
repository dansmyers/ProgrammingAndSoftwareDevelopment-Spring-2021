# Sprint 1 &ndash; Deliverable Programs

## Description
Write Java programs for each of the following. Create a separate `.java` file for each question and put your code in the `main` method of the class. Put all of your Java files into one ZIP archive and submit the ZIP file through the assignment on Canvas.


## Unit of Measure

My son Scott has created a new unit of length called the **Scottometer**. The purpose of the Scottometer is, in his words, "to measure the size of the solar system". Confusingly, 1 Scottometer is defined to be 1 million miles.

Write a Java program that reads a number of miles from the console (using a `Scanner`) and prints the equivalent number of Scottometers. Here is a skeleton to help you get started.

```
/**
 * Scottometer Converter
 */
 
import java.util.Scanner;
 
public class Scottometers {

    public static void main(String[] args) {
    
        // Create a Scanner that reads from the standard input
        Scanner input = new Scanner(System.in);
        
        // Add your code here
    
    }

}
```

Tips:

- Put your code in a file named `Scottometers.java`. Remember that capitalization is important for class and file names.

- Use `double` variables to store the numbers of miles and Scottometers.

- Use the `Scanner`'s `nextDouble` method to read a `double` value from the console.

- Look at the `InchesToCentimeters.java` example.


## Fake Internet Meme Money

<img src="https://static-numista.com/forum/images/56febeae99f8b.jpg" width="50%" />

Dogecoin, the favored cryptocurrency of shiba inus everywhere, currently trades for about $.003 per DOGE.

Write a program that can take a value in dollars as input and output the equivalent number of dogecoins. Print your answers to two decimal places.

Tips:

- Use a `Scanner` and the `nextDouble` method to read from the console.

- To print to two decimal places, use `System.out.printf("%.2f", dogecoins)`, where `dogecoins` is the variable that holds the number of dogecoins you want to print.

- Use a `final double` to store the conversion factor:

```
final double USD_PER_DOGE = .003;
```


## Binet's Formula

You've heard of the famous Fibonacci sequence, where each term is calculated by adding the two previous terms:

```
0, 1, 1, 2, 3, 5, 8, 13, 21, 34, ...
```

Suppose you would like to calculate the *n*<sup>th</sup> Fibonacci number. How could you do that?

One way is to start at the base case and grind your way up through the sequence until you've calculated *n* total terms.

It turns out, though, that there is a **single formula** that will calculate the terms of the Fibonacci sequence. This is weird and suprising, because it seems unlikely that such a highly structured sequence, where each term depends on all the previous terms, could be represented in closed form. The result is know as **Binet's formula**, and it says that the Nth Fibonacci number *f*<sub>*n*</sub> is

<img src="https://latex.artofproblemsolving.com/8/6/d/86d486c560727727342090b432e23ba85ac098b1.png" width="30%"/>

Gnarly.

The number `(1 + sqrt(5)) / 2` is the famous **golden ratio**, the most aesthetically pleasing of all proportions. It's sometimes denoted by the Greek letter φ (phi) after the ancient architect and sculptor Phidias, who used it in planning the design of the Parthenon.

<img src="https://upload.wikimedia.org/wikipedia/commons/d/da/The_Parthenon_in_Athens.jpg" width="50%" />

Write a Java program called `Binet.java` that prompts the user for a value of *n* and then uses Binet's formula to calcuate the *n*<sup>th</sup> Fibonacci number.

Tips:

- Again, use a `Scanner` to read from `System.in`. Use the `nextInt` method to read an `int` value from the console.

- Use `Math.sqrt()` to calculate square roots. For example,

```
double phi = (1 + Math.sqrt(5)) / 2;
```


## Magic 8-Ball

<img src="https://upload.wikimedia.org/wikipedia/commons/9/90/Magic8ball.jpg" width="30%" />

Finish the Magic 8-Ball program given in the `Magic8Ball.java` example. The program should prompt the user for a question, then return one of following ten possible answers
selected at random.

- It is certain.
- It is decidedly so.
- Signs point to yes.
- Reply hazy, try again.
- Ask again later.
- Better not tell you now.
- Concentrate and ask again.
- Don't count on it.
- My reply is no.
- My sources say no.

## RPS

Follow the instructions in `RockPaperScissors.md` to implement a Rock-Paper-Scissors game. Put your program in a file named `RockPaperScissors.java`.
