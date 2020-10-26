# User Guide

## Introduction

eCardnomics is a **desktop flashcard application to quickly create, manage, and access new flashcards via a Command
 Line Interface (CLI)**. eCardnomics is targeted at economics students in Junior College in Singapore, and aims to
 enhance students’ study experience as an efficient and handy aid for active recall. Through the ability to create
 multiple decks of flashcards and tag them independently, students can segment the subject syllabus into topics when
 managing flashcards, yet consolidate flashcards by topic when accessing them to study.

## Contents

<details><summary>Preliminaries</summary><p>

* [Preliminaries](#preliminaries)
  + [Installation](#installation)
  + [Running the program](#running-the-program)
  + [Guide format](#guide-format)

</p></details>
<details><summary>Features - Normal Mode</summary><p>

* [Features - Normal Mode](#features---normal-mode)
  + [Create a new deck: `create`](#create-a-new-deck---create-)
    - [Format](#format)
    - [Examples](#examples)
  + [Display all decks: `decks`](#display-all-decks---decks-)
    - [Format](#format-1)
    - [Examples](#examples-1)
  + [Delete an existing deck: `delete`](#delete-an-existing-deck---delete-)
    - [Format](#format-2)
    - [Examples](#examples-2)
  + [Deck Mode: `edit`](#deck-mode---edit-)
    - [Format](#format-3)
    - [Examples](#examples-3)
  + [Game Mode: `start`](#game-mode---start-)
    - [Format](#format-4)
    - [Examples](#examples-4)
  + [Viewing help in Normal Mode: `help`](#viewing-help-in-normal-mode---help-)
    - [Examples](#examples-5)

</p></details>
<details><summary>Features - Deck Mode</summary><p>

* [Features - Deck Mode](#features---deck-mode)
  + [Add a flashcard: `add`](#add-a-flashcard---add-)
    - [Format](#format-5)
    - [Examples](#examples-6)
  + [List all the flashcards in the deck: `list`](#list-all-the-flashcards-in-the-deck---list-)
    - [Format](#format-6)
    - [Examples](#examples-7)
  + [Delete an existing Flash Card: `delete`](#delete-an-existing-flash-card---delete-)
    - [Format](#format-7)
    - [Examples](#examples-8)
  + [Game Mode: `start`](#game-mode---start--1)
    - [Format](#format-8)
    - [Examples](#examples-9)
  + [Exits Deck Mode: `done`](#exits-deck-mode---done-)
    - [Examples](#examples-10)
  + [Viewing help in Deck Mode: `help`](#viewing-help-in-deck-mode---help-)
    - [Examples](#examples-11)

</p></details>
<details><summary>Features - Game Mode</summary><p>

* [Features - Game Mode](#features---game-mode)
  + [Gameplay](#gameplay)
    - [Examples](#examples-12)
  + [Exits Game Mode: `done`](#exits-game-mode---done-)
    - [Examples](#examples-13)
  + [Viewing help in Game Mode: `help`](#viewing-help-in-game-mode---help-)
    - [Examples](#examples-14)

</p></details>
<details><summary>Features - Anywhere</summary><p>

* [Features - Anywhere](#features---anywhere)
  + [Exits the program: `exit`](#exits-the-program---exit-)
    - [Examples](#examples-15)
  + [Shows release version: `--version`](#shows-release-version-----version-)
    - [Examples](#examples-16)

</p></details>

* [FAQ](#faq)
  + [Game Mode](#game-mode)
* [Command Summary](#command-summary)
  + [Normal Mode](#normal-mode)
  + [Deck Mode](#deck-mode)
  + [Game Mode](#game-mode-1)
  + [Anywhere](#anywhere)

## Preliminaries

### Installation

1. Ensure that you have Java 11 or above installed.
2. Download the latest _jar_ release of `eCardnomics` from [here](https://github.com/AY2021S1-CS2113-T14
-2/tp/releases).

> Java 11 and above is highly recommended, although eCardnomics might run on a lower version.

### Running the program

Open your command line or terminal and navigate to the folder (e.g., `~/downloads`) where you downloaded the jar file
. Then simply run the command `java -jar tp.jar`:

```batch
$ cd ~/downloads
$ ls 
tp.jar
$ java -jar tp.jar
```

> Note: You can also run eCardnomics by double clicking the `tp.jar` file directly.

### Guide format

Words in `<>` are parameters or additional input to be supplied by the user. 

> Example: `edit <index>`
> 
> Here, `index` is a parameter supplied by the user, in this case to specify a deck index to enter edit mode for.

Commented-out lines `//` represent system output by the program.

> Example:
> ```java 
> add
> // Enter question: <question description>
> // Enter answer: <question answer or explanation>
> ```
> Notice how `<question description>` is still commented out but still represents user input. In other words
>, `<>` can be thought of as being delimiters in output representation across this guide.

Words in square brackets `[]` represent optional input parameters.

> Example: list [/ans]

## Features - Normal Mode

> `[Normal]` is displayed at every command prompt, to indicate that the program is in Normal Mode.

### Create a new deck: `create`

Creates a new deck of flashcards. The `create` command expects one argument specifying the name of the deck to be
 created.

#### Format

```java
create <name of deck>
```

#### Examples

```java
[Normal]
  > create market-failure
// New deck created: market-failure
```

### Display all decks: `decks`

Displays an enumerated list of all the decks available to the user. The `decks` command does not expect any arguments.

#### Format

```java
decks
```

#### Examples

```java
[Normal]
  > decks
// The following decks are available:
// Decks:
// 1. market-failure
// 2. perfect competition
// 3. externalities
```

### Delete an existing deck: `delete`

Deletes an existing deck of flashcards. The `delete` command expects one argument specifying the index of the deck to
 be deleted. User is then further prompted for an input of only either `y` or `n`.
 
#### Format

```java
[Normal]
  > delete <index of deck>
// Do you want to delete `name of deck`? [y/n] <y/n>
// `name of deck` has been deleted.
```

> Note: `name of deck` is a placeholder for the actual name of the deck corresponding to the index entered. The second
> line will only be displayed if the user entered y at the prompt for <y/n>.

#### Examples

```java
[Normal]
  > delete 1
// Do you want to delete market-failure? [y/n] n
[Normal]
  > 
```

```java
[Normal]
  > delete 2
// Do you want to delete perfect competition? [y/n] y
// perfect competition has been deleted.
[Normal]
  >
```

```java
[Normal]
  > delete 1
// Do you want to delete market-failure? [y/n] not_y_or_n
// Response should be 'y' or 'n'!
// Do you want to delete market-failure? [y/n] y
// market-failure has been deleted.
[Normal]
  >
```

### Deck Mode: `edit`

Enters the Deck Mode to edit an existing deck. The `edit` command expects one argument specifying the deck index for
 which to enter Deck Mode.
 
#### Format

```java
[Normal]
  > edit <index of deck>
```

#### Examples

```java
[Normal]
  > edit 1
// ------------------------------------------------------------
// You are now in Deck Mode, editing: [1] market-failure
// ------------------------------------------------------------
[Deck - market-failure]
  >
```

> Notice how the prompt mode identifier `[Normal]` changed to `[Deck - market-failure]`.

### Game Mode: `start`

Starts Game Mode for an existing deck. The `start` command expects one argument specifying the deck index for which to
 enter Deck Mode.
 
> The `start` command can also be entered from within Deck Mode, although the index of the deck is still expected.
 
#### Format

```java
[Normal]
  > start <index of deck>
```

#### Examples

```java
[Normal]
  > start 1
// ------------------------------------------------------------
// Welcome to Game Mode!
//
// In this mode, you test your knowledge against...
// ... 
//                                      ...Have fun!
//
// Game Mode is started for: [1] market-failure
// ------------------------------------------------------------
// Q: What is market failure?
//   Enter your attempt below (or `done`, `exit`, `help`):
  >
```

### Viewing help in Normal Mode: `help`

Displays the list of all commands in Normal Mode. 

#### Examples

```java
[Normal]
  > help
// ------------------------------------------------------------
// eCardnomics.
// Normal Mode.
// 
// Usage:
//  create         Creates a new deck of flash cards.
//  decks          Lists all available decks.
//  edit <ix>      Enter Deck Mode for editing the deck at list index <ix>.
//  delete <ix>    Deletes the deck at list index <ix> from list of decks.
//  exit           Exits the program.
//  help           Show this output.
//
// Options:
//  --version      Show version.
// ------------------------------------------------------------
```

## Features - Deck Mode

### Add a flashcard: `add`
Adds a flashcard to the end of the current deck. The `add` command expects no initial arguments. Instructions and 
format of card entry is displayed. Then, the user is prompted to specify the details of the flashcard to be added.

#### Format
```java
add
// Enter question: <question description>
// Enter answer: <question answer or explanation>
```
 

#### Examples

```java
// [Deck - market failure]
     > add 
// Enter question: <question description>
// ------------------------------------------------------------
// You are now adding a FlashCard to: market failure
// ------------------------------------------------------------
// Enter question:
     > define market failure
// Enter answer:
     > Market failure is the economic situation defined by an inefficient distribution of goods 
and services in the free market
// FlashCard successfully added! 
// ------------------------------------------------------------ 
```

### List all the flashcards in the deck: `list`
Lists all the existing flash cards within the current deck. You can add the option `\ans` after the `list` command 
to show all the questions, and their respective answers.

#### Format
```java
[Deck - `name of deck`]
  > list
// ------------------------------------------------------------
// You are now viewing deck: `name of deck`
// ------------------------------------------------------------
// 1. Question: <question 1>
// 
// 2. Question: <question 2>
//
// 3. Question: <question 3>
// ------------------------------------------------------------
```

```java
[Deck - `name of deck`]
  > list /ans
// ------------------------------------------------------------
// You are now viewing deck: `name of deck`
// ------------------------------------------------------------
// 1. Question: <question 1>
//    Answer:   <answer 1>
//
// 2. Question: <question 2>
//    Answer:   <answer 2>
//
// 3. Question: <question 3>
//    Answer:   <answer 3>
// ------------------------------------------------------------
```

#### Examples

```java
[Deck - market-failure]
  > list
// ------------------------------------------------------------
// You are now viewing deck: market-failure
// ------------------------------------------------------------
// 1. Question: define market failure
//
// 2. Question: What is a public good?
//
// 3. Question: What is a merit good?
// ------------------------------------------------------------
```

```java
[Deck - market-failure]
  > list /ans
// ------------------------------------------------------------
// You are now viewing deck: market-failure
// ------------------------------------------------------------
// 1. Question: define market failure
//    Answer:   Market failure is the economic situation defined 
//    by an inefficient distribution of goods and services
//    in the free market
// 
// 2. Question: What is a public good?
//    Answer:   A good which are non-rival and non-excludable
// 
// 3. Question: What is a merit good?
//    Answer:   A good that people underestimates the benefits of
// ------------------------------------------------------------
```

### Delete an existing Flash Card: `delete`

Deletes an existing flashcard from deck. The `delete` command expects one argument specifying the index of the flash card to
 be deleted. User is then further prompted for an input of only either `y` or `n`.
 
#### Format

```java
[Deck - `name of deck`]
  > delete 1
// Do you want to delete the following flash card? [y/n]
//   '<question 1>'
  > n
// ------------------------------------------------------------
```

```java
[Deck - `name of deck`]
  > delete 2
// Do you want to delete the following flash card? [y/n]?
//   '<question 2>'? 
  > y
// ------------------------------------------------------------
// The following flash card has been deleted:
//   '<question 2>'
// ------------------------------------------------------------
```

> Note: `name of deck` is a placeholder for the name of the current deck. The second
> line will only be displayed if the user entered y at the prompt for <y/n>.

#### Examples
```java
[Deck - market-failure]
  > delete 1
// Do you want to delete the following flash card? [y/n]
//   `define market failure?`
  > n
// ------------------------------------------------------------
```

```java
[Deck - market-failure]
  > delete 2
// Do you want to delete the following flash card? [y/n]?
//   'What is a public good?'? 
  > y
// ------------------------------------------------------------
// The following flash card has been deleted:
//   'What is a public good?'
// ------------------------------------------------------------
```

### Game Mode: `start`

Starts Game Mode for an existing deck. The `start` command expects one argument specifying the deck index for which to
 enter Deck Mode.
 
> The `start` command can also be entered from within Normal Mode.
 
#### Format

```java
[Deck - market-failure]
  > start <index of deck>
```

#### Examples

```java
// You are now in Deck Mode, editing: [1] market-failure
// ------------------------------------------------------------
[Deck - market-failure]
  > ...
// ...
// ------------------------------------------------------------
[Deck - market-failure]
  > start 1
// ------------------------------------------------------------
// Welcome to Game Mode!
//
// In this mode, you test your knowledge against...
// ... 
//                                      ...Have fun!
//
// Game Mode is started for: [1] market-failure
// ------------------------------------------------------------
// Q: What is market failure?
//   Enter your attempt below (or `done`, `exit`, `help`):
  >
```

> Notice how the `start 1` command is entered with the deck index. This is required! 

### Exits Deck Mode: `done`

Returns to Normal Mode.

#### Examples

```java
[Deck - market-failure]
  > done
// ------------------------------------------------------------
// You are back in Normal Mode
// ------------------------------------------------------------
[Normal]
  >
```

### Viewing help in Deck Mode: `help`

Displays the list of all commands in Deck Mode.

#### Examples

```java
[Deck - market-failure]
  > help
// ------------------------------------------------------------
// eCardnomics.
// Deck Mode.
// 
// Usage:
//  add            Adds a new flash card to the current deck.
//  list [/ans]    Lists all flash cards in the current deck, optionally with answers.
//  delete <ix>    Deletes the flash card at list index <ix> from the current deck.
//  done           Exits from Deck Mode and returns to Normal Mode.
//  exit           Exits the program.
//  help           Show this output.
//
// Options:
//  --version      Show version.
// ------------------------------------------------------------
```

## Features - Game Mode

### Gameplay

Questions are displayed in a randomised order. At each question, the user will:

1. Try to attempt an answer at the question, by typing at the prompt; then
2. Press `<enter>` (optionally with an empty attempt).

Then, the correct answer is displayed, and our 'advanced' algorithm scores the user's attempt against the correct
 answer. Finally, the user is given the option to re-attempt the question later. See below for example gamplay.
 
#### Examples

* Start Game Mode (from within Deck Mode)

```java
[Deck - Micro-Economics]
  > list
// ------------------------------------------------------------
// You are now viewing deck: Micro-Economics
// 1. Question: What is the Law of demand?
// 
// 2. Question: What is the Law of supply?
//
// 3. Question: What is price elasticity of demand?
//
// 4. Question: What is price elasticity of supply?
// ------------------------------------------------------------
[Deck - Micro-Economics]
  > start 1
```

* Play!

```java
// ...
// Game Mode is started for: [1] Micro-Economics
// ------------------------------------------------------------
// Q: What is the Law of supply?
//   Enter your attempt below (or `done`, `exit`, `help`):
   > Price of good increases, quantity supplied increases.
// A: When the price of a good increases, the quantity supplied increases, ceteris paribus.
// The % match between your answer and the actual answer is: 53.85
// ------------------------------------------------------------
// Do you want to re-attempt this question later? [y/n]
  > y
// ------------------------------------------------------------
// Q: What is price elasticity of demand?
//   Enter your attempt below (or `done`, `exit`, `help`):
  > I don't know.
// A: Percentage change in quantity demanded caused by a 1 percent change in price.
// The % match between your answer and the actual answer is: 0.00
// ------------------------------------------------------------
// Do you want to re-attempt this question later? [y/n]
  > y
// ------------------------------------------------------------
// Q: What is the Law of demand?
//   Enter your attempt below (or `done`, `exit`, `help`):
  > Quantity of good demanded fall when price of good rises.
// A: When the price of a good rises, the quantity of the good demanded will fall, ceteris paribus.
// The % match between your answer and the actual answer is: 58.82
// ------------------------------------------------------------
// Do you want to re-attempt this question later? [y/n]
  > n
// ------------------------------------------------------------
// Q: What is price elasticity of supply?
//   Enter your attempt below (or `done`, `exit`, `help`):
  > Percentage change in quantity supplied for a 1 percent price change
// A: Percentage change in quantity supplied caused by a 1 percent change in price.
// The % match between your answer and the actual answer is: 84.62
// ------------------------------------------------------------
// Do you want to re-attempt this question later? [y/n]
  > n
// ------------------------------------------------------------
// Q: What is price elasticity of demand?
//   Enter your attempt below (or `done`, `exit`, `help`):
  > Percentage change in quantity demanded for a 1 percent price change.
// A: Percentage change in quantity demanded caused by a 1 percent change in price.
// The % match between your answer and the actual answer is: 84.62
// ------------------------------------------------------------
// Do you want to re-attempt this question later? [y/n]
  > n
// ------------------------------------------------------------
// Q: What is the Law of supply?
//   Enter your attempt below (or `done`, `exit`, `help`):
  > Price of a good increases, the quantity supplied increases, ceteris paribus.
// A: When the price of a good increases, the quantity supplied increases, ceteris paribus.
// The % match between your answer and the actual answer is: 92.31
// ------------------------------------------------------------
// Do you want to re-attempt this question later? [y/n]
  > n
// ------------------------------------------------------------
// You have completed all the flash cards in this deck!
// Returning to Normal Mode...
// ------------------------------------------------------------
// You are back in Normal Mode
// ------------------------------------------------------------
[Normal]
  >
```

### Exits Game Mode: `done`

Returns to Normal Mode.

#### Examples

```java
// ...
// ------------------------------------------------------------
// Q: What is market-failure?
//   Enter your attempt below (or `done`, `exit`, `help`):
  > done
// ------------------------------------------------------------
// You are back in Normal Mode
// ------------------------------------------------------------
[Normal]
  > 
```

### Viewing help in Game Mode: `help`

Displays the list of all commands in Game Mode.

#### Examples

```java
// ...
// ------------------------------------------------------------
// Q: What is market-failure?
//   Enter your attempt below (or `done`, `exit`, `help`):
  > help
// ------------------------------------------------------------
// eCardnomics.
// Game Mode.
//
// Usage:
//   done           Exits from Game Mode and returns to Normal Mode.
//   exit           Exits the program.
//   help           Show this output.
// 
// Options:
//   --version      Show version.
//
// Gameplay:
// Questions will be displayed in a randomised order. At each question, you can
//     1. Try to attempt an answer at the question, by typing at the prompt
//     2. Press <enter> (with an empty attempt if you want to do it in your head)
// 
// Then, our 'advanced' algorithms will check your answer and score your answer 
// (if any), and display the correct answer for you to check your answer against.
// Finally, we will ask if you think you got it right. If you did not, the
// question will be inserted back into the question pool, and you will get a 
// chance to attempt it again!
// ------------------------------------------------------------
// Q: What is market-failure?
//   Enter your attempt below (or `done`, `exit`, `help`):
  > 
```

## Features - Anywhere

### Exits the program: `exit`

Can be entered from any mode, anywhere in the program.

> Except during Y/N prompts.

#### Examples

```java
[Normal]
  > exit
// ------------------------------------------------------------
// Bye! Hope to see you again soon!
// ------------------------------------------------------------
```

```java
[Deck - market-failure]
  > exit
// ------------------------------------------------------------
// Bye! Hope to see you again soon!
// ------------------------------------------------------------
```

```java
...
// ------------------------------------------------------------
// Q: What is market-failure?
//   Enter your attempt below (or `done`, `exit`, `help`):
  > exit
// ------------------------------------------------------------
// Bye! Hope to see you again soon!
// ------------------------------------------------------------
```

### Shows release version: `--version`

Shows release version from anywhere in the program.

> Except during Y/N prompts.

#### Examples

```java
// ...
// ------------------------------------------------------------
// Q: What is market-failure?
//   Enter your attempt below (or `done`, `exit`, `help`):
  > --version
// ------------------------------------------------------------
// Version: 2.0
// ------------------------------------------------------------
// Q: What is market-failure?
//   Enter your attempt below (or `done`, `exit`, `help`):
  > 
```

## FAQ

### Game Mode

**Q**: What if my flash card answer contains a single word "done" or "exit"?

```java
// Q: What is the command to exit Game Mode or Deck Mode?
//   Enter your attempt below (or `done`, `exit`, or `help`):
  > done
// ------------------------------------------------------------
// You are back in Normal Mode
// ------------------------------------------------------------
[Normal]
  >
```

**A**: Escape the command using punctuations, e.g. `\exit` or `"exit"`.

```java
// Q: What is the command to exit Game Mode or Deck Mode?
//   Enter your attempt below (or `done`, `exit`, or `help`):
  > "done"
// A: done
// The % match between your answer and the actual answer is: 100.00
// ------------------------------------------------------------
// ...
```

## Command Summary

### Normal Mode

|Action|Format|Example|
|------|------|-------|
|Create deck|`create <nm>`|`create market-failure`|
|Display decks|`decks`||
|Delete deck|`delete <ix>`|`delete 1`|
|Enter Deck Mode|`edit <ix>`|`edit 1`|
|Enter Game Mode|`start <ix>`|`start 1`|
|Help|`help`||

### Deck Mode

|Action|Format|Example|
|------|------|-------|
|Add flash card|`add`||
|List flash cards|`list [/ans]`||
|Delete flash card|`delete <ix>`|`delete 1`|
|Enter Game Mode|`start <ix>`|`start 1`|
|Exit Deck Mode|`done`||
|Help|`help`||

### Game Mode

|Action|Format|Example|
|------|------|-------|
|Done|`done`||
|Help|`help`||

### Anywhere

|Action|Format|Example|
|------|------|-------|
|Exit program|`exit`||
|Show version|`--version`||
