# Practice with Loops and Arrays

## Average

Write a program that initializes a 1-D array of doubles and then finds the average of its elements.

```
double[] d = new double[8];

// Fill in the elements of d with values

// Use a loop to sum up the elements of d

// Calculate and print the average

```

## Maximum
Add another loop to your program to find the maximum element of the array. Use an `if` statement inside the loop to keep track of the largest element seen so far.


## FizzBuzz

<img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRotf_0BVD65WuId_eRFnmAFAXFFB3cGVGs-g&usqp=CAU" width="35%" />

One of the all-time classic programming interview questions originally created by Imran Gohry.

Print the numbers from 1 to 100, except

- Print `Fizz` for numbers divisible by 3
- Print `Buzz` for numbers divisible by 5
- Print `FizzBuzz` for numbers divisible by both 3 and 5

Here is an example of the output:

```
1
2
Fizz
4
Buzz
Fizz
7
8
Fizz
Buzz
11
Fizz
13
14
FizzBuzz
```

Use a loop with an if-else if-else block inside it.

```
for (int i = 1; i < 101; i++) {
    if (SOMETHING) {
        System.out.println("FizzBuzz");
    } else if (SOMETHING ELSE) {
        System.out.println("Fizz");
    }
    
    // Finish
}
```

Tip: Remember that you can use the modulus operator, `%`, to test for divisibility. For example, to test if `i` is divisible by 3 and 5 use:

```
if (i % 3 == 0 && i % 5 == 0) {

}
```

## Descending a Staircase

Write a program that uses a loop to print a descending staircase of blocks like the following:

```
#
##
###
####
#####
```

Use a variable to control the height of the staircase.

Tip: Use an outer loop that iterates over each level of the stairs. Then use an inner loop to print the correct number of blocks on each line. Use `System.out.print("#")` to
print a block without going to the next line.

```
for (int level = 0; level < height; level++) {

    // Use an inner loop to print level + 1 blocks on this line
    
    
    // Go to the next line
}
```


## Look on My Works, Ye Mighty, and Despair!

![](https://upload.wikimedia.org/wikipedia/en/1/1c/Iron_Maiden_-_Powerslave.jpg)

https://www.poetryfoundation.org/poems/46565/ozymandias

Write a program that can print pyramids of stars like the following:

```
    *
   ***
  *****
 *******
*********
```

Use three loops:

- An outer one for the levels
- An inner one that prints the spaces on each line
- A second inner one that prints the stars on each line

Tip: the first level has `height - 1` spaces and 1 star. The second has `height - 2` spaces and 3 stars. I recommend using variables to keep track of the number of spaces and
stars that you need to print on each line and then updating their values before you move to the next line.

```
int height = 10;

int stars = 1;
int spaces = height - 1;

for (int level = 0; level < height; level++) {
    // Use a loop to print the spaces on the current line
    
    
    // Use a second loop to print the stars on the current line
    
    
    // Move to the next line
    System.out.println();
    
    // Update the numbers of spaces and stars for the next line
    stars += 2;
    spaces -= 1;
}
```
