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
> ``` 
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

```
create <name of deck>
```

#### Examples

```
[Normal]
  > create market-failure
// New deck created: market-failure
```

### Display all decks: `decks`

Displays an enumerated list of all the decks available to the user. The `decks` command does not expect any arguments.

#### Format

```
decks
```

#### Examples

```
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

```
[Normal]
  > delete <index of deck>
// Do you want to delete `name of deck`? [y/n] <y/n>
// `name of deck` has been deleted.
```

> Note: `name of deck` is a placeholder for the actual name of the deck corresonding to the index entered. The second
> line will only be displayed if the user entered y at the prompt for <y/n>.

#### Examples

Deciding not to delete:
```
[Normal]
  > delete 1
// Do you want to delete market-failure? [y/n] n
[Normal]
  > 
```

Confirming a delete:
```
[Normal]
  > delete 2
// Do you want to delete perfect competition? [y/n] y
// perfect competition has been deleted.
[Normal]
  >
```

Entering an invalid response:
```
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

```
[Normal]
  > edit <index of deck>
```

#### Examples

```
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

```
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

### Add a flashcard: `create`

Adds a flashcard to the end of the current deck.
The `add` command expects no initial arguments.
Instructions and format of card entry is displayed.
Then, the user is prompted to specify the details of the flashcard to be added.

#### Format

```
[Deck - `name`]
  > add
// ------------------------------------------------------------
// You are now adding a FlashCard to: name
// ------------------------------------------------------------
// Enter question:
   > <question description>
// Enter answer:
   > <question answer or explanation>
// FlashCard successfully added!
// ------------------------------------------------------------
```
> Note: `name` is a placeholder for the actual name of the deck that is being edited.

#### Examples

```
[Deck - market failure]
  > add
// ------------------------------------------------------------
// You are now adding a FlashCard to: market failure
// ------------------------------------------------------------
// Enter question:
   > define market failure
// Enter answer:
   > Economic situation defined by inefficient distribution of goods and services in the free market
// FlashCard successfully added!
// ------------------------------------------------------------
[Deck - market failure]
```

### List all flashcards: `list`

Displays an enumerated list of the flashcards in the current deck.
By default, the `list` command displays only the question for each flashcard.
Optionally, the user can append the argument `/ans` that will prompt the program
to also list the answer for each flashcard.

#### Format

```
[Deck - `name`]
  > list [/ans]
```
> Note: `name` is a placeholder for the actual name of the deck that is being edited.

#### Examples

List without answers:
```
[Deck - market failure]
  > list
// ------------------------------------------------------------
// You are now viewing deck: [Deck - market failure]
// ------------------------------------------------------------
// 1. Question: Define market failure.

// 2. Question: What is the difference between free-loading and
//              free-riding?

// ------------------------------------------------------------
[Deck - market failure]
```

List with answers:
```
[Deck - market failure]
  > list /ans
// ------------------------------------------------------------
// You are now viewing deck: [Deck - market failure]
// ------------------------------------------------------------
// 1. Question: Define market failure.
//    Answer:   Economic situation defined by inefficient
//              distribution of goods and services in the free
//              market

// 2. Question: What is the difference between free-loading
//              and free-riding?
//    Answer:   Free-loading gives a benefit to the free-loader
//              but there is a cost to the people taken
//              advantage of. Free-riding is an advantage to
//              the free-rider without imposing a cost on 
//              others or society.

// ------------------------------------------------------------
[Deck - market failure]
```

### Delete a flashcard: `delete`

Deletes the specified flashcard from the deck.

#### Format

```
[Deck - `name`]
  > delete <index of flashcard>
// Do you want to delete `name of flashcard`? [y/n] <y/n>
// `name of flashcard` has been deleted.
```

> Note: `name` is a placeholder for the actual name of the deck that is being edited.
> Note: `name of flashcard` is a placeholder for the actual name of the flashcard corresonding to the index entered.
> The second line will only be displayed if the user entered y at the prompt for <y/n>.

#### Examples

Deciding not to delete: 
```
[Deck - market failure]
  > delete 1
// Do you want to delete Define market failure? [y/n] n
[Deck - market failure]
```

Confirming a delete:
```
[Deck - market failure]
  > delete 1
// Do you want to delete Define market failure? [y/n] y
// Define market failure has been deleted.
[Deck - market failure]
  >
```

Entering an invalid response:
```
[Deck - market failure]
  > delete 1
// Do you want to delete Define market failure? [y/n] not_y_or_n
// Response should be 'y' or 'n'!
// Do you want to delete Define market failure? [y/n] y
// Define market failure has been deleted.
[Deck - market failure]
```

### Update a flashcard: `update`

Updates the question and answer fields of a  specified flashcard
in the deck.
The `update` command expects no initial arguments.
The current question and answer are displayed.
Then, the user is prompted to specify the new details of the flashcard.

#### Format
```
[Deck - `name`]
  > update <index of flashcard>
// Question: `Current Question`
// New Question:
    > <new question>
// Answer:   `Current Answer`
// New Answer:
    > <new answer>
// The flashcard has been updated.
```
> Note: `name` is a placeholder for the actual name of the deck that is being edited.
> `Current Question` and `Current Answer` are placeholders for the original question
> and answer of the flashcard.

If a blank line is supplied as the new detail, then the detail is unchanged.

#### Examples

Updating both the question and answer:
```
[Deck - market failure]
  > update 1
// Question: Define market failure
// New Question:
  > What is the difference between free-loading and free-riding?
// Answer:   Economic situation defined by inefficient distribution of goods and services in the free market
// New Answer:
  > Free-loading gives a benefit to the free-loader but there is a cost to the people taken advantage of.
    Free-riding is an advantage to the free-rider without imposing a cost on others or society.
// Question and answer updated.
```

Updating question only:
```
[Deck - market failure]
  > update 1
// Question: Define market failure
// New Question:
  > Define Market Failure
// Answer:   Economic situation defined by inefficient distribution of goods and services in the free market
// New Answer:
  > 
// Question updated.
```

Updating answer only:
```
[Deck - market failure]
  > update 1
// Question: Define market failure
// New Question:
  > 
// Answer:   Economic situation defined by inefficient distribution of goods and services in the free market
// New Answer: Economic situation where distribution of goods and services in the free market is inefficient
  > Economic situation where distribution of goods and services in the free market is inefficient
// Answer updated.
```

No updates:
```
[Deck - market failure]
  > update 1
// Question: Define market failure
// New Question:
  > 
// Answer:   Economic situation defined by inefficient distribution of goods and services in the free market
// New Answer: Economic situation where distribution of goods and services in the free market is inefficient
  > 
// Original question and answer retained.
```

### Exit Deck Mode: `done`

Exits Deck Mode and returns to Normal Mode.

#### Format

`done`

#### Examples

```
[Deck - market failure]
  > done
------------------------------------------------------------
You are back in Normal Mode
------------------------------------------------------------
[Normal]
```

### Viewing help in Deck Mode: `help`

Displays the list of all commands in Deck Mode.

#### Examples

```
[Deck - market failure]
  > help
// ------------------------------------------------------------
// eCardnomics.
// Deck Mode.

// Usage:
//   add            Adds a new flash card to the current deck.
//   list [/ans]    Lists all flash cards in the current deck, optionally with answers.
//   delete <ix>    Deletes the flash card at list index <ix> from the current deck.
//   done           Exits from Deck Mode and returns to Normal Mode.
//   exit           Exits the program.
//   help           Show this output.

// Options:
//   --version      Show version.
// ------------------------------------------------------------
[Deck - market failure]
  > 
```

## Features - Anywhere

### Exit the program: `exit`

Exits the program.

#### Examples

In Normal Mode:
```
[Normal]
  > exit
------------------------------------------------------------
Bye. Hope to see you again soon!
------------------------------------------------------------
```

In Deck Mode:
```
[Deck - market failure]
  > exit
------------------------------------------------------------
Bye. Hope to see you again soon!
------------------------------------------------------------
```

## FAQ

**Q**: How do I transfer my data to another computer? 

**A**: {your answer here}

## Command Summary

### Normal Mode

|Action|Format|Example|
|------|------|-------|
|Create deck|`create `|`create market-failure`|
|Display decks|`decks`||
|Delete deck|`delete `|`delete 1`|
|Enter Deck Mode|`edit `|`edit 1`|
|Help|`help`||

### Deck Mode

|Action|Format|Example|
|------|------|-------|
|Add flash card|`add`||
|List flash cards|`list [/ans]`||
|Delete flash card|`delete `|`delete 1`|
|Exit Deck Mode|`done`||
|Help|`help`||

### Anywhere

|Action|Format|Example|
|------|------|-------|
|Exit program|`exit`||
