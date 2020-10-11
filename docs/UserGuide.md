# User Guide

## Introduction

eCardnomics is a **desktop flashcard application to quickly create, manage, and access new flashcards via a Command
 Line Interface (CLI)**. eCardnomics is targeted at economics students in Junior College in Singapore, and aims to
 enhance students’ study experience as an efficient and handy aid for active recall. Through the ability to create
 multiple decks of flashcards and tag them independently, students can segment the subject syllabus into topics when
 managing flashcards, yet consolidate flashcards by topic when accessing them to study.

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

Deletes an existing deck of flashcards. The `delete` command expects one argument specifying the name of the deck to
 be deleted. User is then further prompted for an input of only either `y` or `n`.
 
#### Format

```java
[Normal]
  > delete <index of deck>
// Do you want to delete `name of deck`? [y/n] <y/n>
// `name of deck` has been deleted.
```

> Note: `name of deck` is a placeholder for the actual name of the deck corresonding to the index entered. The second
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

### Create a new deck: `create`
Creates a new deck of flashcards. The `create` command expects one argument specifying the name of the deck to be
 created. Additional arguments after /tag specify tags to use for the deck.

#### Format

`create <name of deck>`
* The `DEADLINE` can be in a natural language format.
* The `TODO_NAME` cannot contain punctuation.  

#### Examples

`todo n/Write the rest of the User Guide d/next week`

`todo n/Refactor the User Guide to remove passive voice d/13/04/2020`

## Features - Anywhere

## FAQ

**Q**: How do I transfer my data to another computer? 

**A**: {your answer here}

## Command Summary

{Give a 'cheat sheet' of commands here}

* Add todo `todo n/TODO_NAME d/DEADLINE`
