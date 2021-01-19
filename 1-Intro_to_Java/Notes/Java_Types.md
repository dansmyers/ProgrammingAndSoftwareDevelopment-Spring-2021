# Variable Types in Java

## Primitive Types

As we discussed in class, Java supports eight basic data types that are called the **primitive types**. Each type correspond to a certain kind of data
which has an underlying representation in the computer's memory.



| Type    | Description           | Range                                | Typical Use               |
| ------- | --------------------- | ------------------------------------- | ------------------|
| `int`   | 32-bit signed integer | -2<sup>31</sup> to 2<sup>31</sup> - 1 | Primary type for integer data |
| `short` | 16-bit signed integer | -32768 to 32767                       | Rarely used unless you need to minimize memory usage |
| `long` | 64-bit signed integer | -2<sup>64</sup> to 2<sup>64</sup> - 1 | Integer data that doesn't fit into the range of an `int` |
| `byte` | A single 8-bit byte   | -128 to 127                           | Working with byte-level data in files or networks |
| `double` | 64-bit floating point number | About 14 digits of precision after the decimal point | Primary type for decimal values |
| `float` | 32-bit floating point number |  About 7 digits of precision after the decimal point | Rarely used unless you need to minimize memory usage |
| `char` | A single character |     | Working with individual characters that are part of a `String` |
| `boolean` | Logical true or false | `true` or `false` | Tests results, controlling `while` loops, flags |


Here are some example variable declarations using the common types:

```
int fingers = 10;

double weightInKilos = 100.5;

// Use single quotes to declare a char value
char pound = '#';

// true and false are Java keywords
boolean active = true;
```

Everything that isn't one of the eight primitive types is an **object** in Java. Object types always start with a capital letter. Notably, `String` is an object type:

```
String message = "Strings are objects, not a primitive type!"
```

Notice that Java `String` values are always enclosed in **double quotes** and a single `char` value is enclosed in **single quotes**. Python did not have the concept of a 
dedicated type for single characters, and all string values (the `str` type) could be enclosed in **either double or single quotes**.

## Arithmetic Operators

Most of the arithmetic operators work the same as their Python counterparts:

- `+`
- `-`
- `*`
- `%` for the modulus operator

The one exception is division. If you divide two `int` values, Java performs **integer division**. This is equivalent to performing exact division and **rounding down**:

```
int x = 5 / 3;  // result is 1

int y = 10 / 4;  // result is 2

int z = 3 / 4;  // result is 0
```

Again, this is different than Python 3, which always performs exact division unless you use the special `//` operator to force integer division.
