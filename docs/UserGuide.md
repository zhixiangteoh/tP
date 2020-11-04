# User Guide

## Introduction

eCardnomics is a **desktop flashcard application to quickly create, manage, and access new flashcards via a Command
 Line Interface (CLI)**. eCardnomics is targeted at economics students in Junior College in Singapore, and aims to
 enhance students’ study experience as an efficient and handy aid for active recall. Through the ability to create
 multiple decks of flashcards and tag them independently, students can segment the subject syllabus into topics when
 managing flashcards, yet consolidate flashcards by topic when accessing them to study.

## Contents

- [Preliminaries](#preliminaries)
  * [Installation](#installation)
  * [Running the program](#running-the-program)
  * [Guide format](#guide-format)
- [Features - Normal Mode](#features---normal-mode)
  * [Create a new deck: `create`](#create-a-new-deck---create-)
    + [Format](#format)
    + [Examples](#examples)
  * [Tag an existing deck: `tag`](#tag-an-existing-deck---tag-)
    + [Format](#format-1)
    + [Examples](#examples-1)
  * [Untag an existing tag: `untag`](#untag-an-existing-tag---untag-)
    + [Format](#format-2)
    + [Examples](#examples-2)
  * [Search decks by tag: `search`](#search-decks-by-tag---search-)
    + [Format](#format-3)
    + [Examples:](#examples-)
  * [Display all decks: `decks`](#display-all-decks---decks-)
    + [Format](#format-4)
    + [Examples](#examples-3)
  * [Delete an existing deck: `delete`](#delete-an-existing-deck---delete-)
    + [Format](#format-5)
    + [Examples](#examples-4)
  * [Deck Mode: `edit`](#deck-mode---edit-)
    + [Format](#format-6)
    + [Examples](#examples-5)
  * [Game Mode: `start`](#game-mode---start-)
    + [Format](#format-7)
    + [Examples](#examples-6)
  * [Print an Existing Deck to a PowerPoint File: `pptx`](#print-an-existing-deck-to-a-powerpoint-file---pptx-)
    + [Format](#format-8)
    + [Examples](#examples-7)
  * [Viewing help in Normal Mode: `help`](#viewing-help-in-normal-mode---help-)
    + [Examples](#examples-8)
- [Features - Deck Mode](#features---deck-mode)
  * [Add a flashcard: `add`](#add-a-flashcard---add-)
    + [Format](#format-9)
    + [Examples](#examples-9)
  * [List all the flashcards in the deck: `list`](#list-all-the-flashcards-in-the-deck---list-)
    + [Format](#format-10)
    + [Examples](#examples-10)
  * [Delete an existing Flash Card: `delete`](#delete-an-existing-flash-card---delete-)
    + [Format](#format-11)
    + [Examples](#examples-11)
  * [Update an existing Flash Card: `update`](#update-an-existing-flash-card---update-)
    + [Format](#format-12)
    + [Examples](#examples-12)
  * [Game Mode: `start`](#game-mode---start--1)
    + [Format](#format-13)
    + [Examples](#examples-13)
  * [Print Current Deck to a PowerPoint File: `pptx`](#print-current-deck-to-a-powerpoint-file---pptx-)
    + [Format](#format-14)
    + [Examples](#examples-14)
  * [Exits Deck Mode: `done`](#exits-deck-mode---done-)
    + [Examples](#examples-15)
  * [Viewing help in Deck Mode: `help`](#viewing-help-in-deck-mode---help-)
    + [Examples](#examples-16)
- [Features - Game Mode](#features---game-mode)
  * [Gameplay](#gameplay)
    + [Examples](#examples-17)
  * [Exits Game Mode: `done`](#exits-game-mode---done-)
    + [Examples](#examples-18)
  * [Viewing help in Game Mode: `help`](#viewing-help-in-game-mode---help-)
    + [Examples](#examples-19)
- [Features - Print to PowerPoint](#features---print-to-powerpoint)
  * [Create new PowerPoint based on the selected deck: `pptx`](#create-new-powerpoint-based-on-the-selected-deck---pptx-)
- [Features - Anywhere](#features---anywhere)
  * [Exits the program: `exit`](#exits-the-program---exit-)
    + [Examples](#examples-20)
  * [Shows release version: `--version`](#shows-release-version-----version-)
    + [Examples](#examples-21)
- [Features - (Proposed) Encryption and Decryption](#features----proposed--encryption-and-decryption)
- [FAQ](#faq)
  * [Game Mode](#game-mode)
- [Command Summary](#command-summary)
  * [Normal Mode](#normal-mode)
  * [Deck Mode](#deck-mode)
  * [Game Mode](#game-mode-1)
  * [Anywhere](#anywhere)

## Preliminaries

### Installation

1. Ensure that you have Java 11 or above installed.
2. Download the latest _jar_ release of `eCardnomics` from [here](https://github.com/AY2021S1-CS2113-T14
-2/tp/releases).

> Java 11 and above is highly recommended, although eCardnomics might run on a lower version.

### Running the program

Open your command line or terminal and navigate to the folder (e.g., `~/downloads`) where you downloaded the jar file
. Then simply run the command `java -jar ecardnomics.jar`:

```batch
$ cd ~/downloads
$ ls 
ecardnomics.jar
$ java -jar ecardnomics.jar
```

> Note: You can also run eCardnomics by double clicking the `ecardnomics.jar` file directly.

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

Create deck without tags:
```java
create <name of deck>
```
Create deck with tag(s):
```java
create <name of deck> [/tag <tag1> [<tag2>]]
```

#### Examples

```
[Normal]
  > create market-failure
// New deck created: market-failure
```
```
[Normal]
  > create market-failure /tag beginner
// New deck created: market-failure | Tag(s): beginner 
```

### Tag an existing deck: `tag`

Adds a tag to an existing deck of flashcards. The `tag` command expects one argument specifying the name of the deck
 to tag. At least one additional argument after /tag specifies tags to be added to the deck.

#### Format

```java
tag <index of deck> /tag <tag1> [<tag2>]
```
> Note: Do `decks` command first to obtain up-to-date index. 
> Tags' name should not include spaces, spaces are used to separate different tags

#### Examples

```java
[Normal]
  > tag 1 /tag beginner
// The deck market-failure has been tagged as: beginner
```

### Untag an existing tag: `untag`

Removes an existing tag from an existing deck of flashcards. The `untag` command expects one argument specifying the 
name of the deck to remove a deck from. At least one additional argument after /tag specifies tags to be removed from the deck.

#### Format

```java
untag <index of deck> /tag <tag1> [<tag2>]
// Do you want to remove the tag <tag1> from <name of deck>? [y/n] y/n
```
> Note: Do `decks` command first to obtain up-to-date index.
> Tags' name should not include spaces, spaces are used to separate different tags.
> 

#### Examples

```java
[Normal]
  > untag 1 /tag beginner
// Do you want to remove the tag beginner from market-failure? [y/n] y/n
// The tag beginner has been removed from the deck market-failure.
```

### Search decks by tag: `search`

Searches all the decks containing the specified tag. The `search` command expects at least one argument specifying one 
or more tags related to the deck. 

#### Format

```java
search <tag1> [<tag2>]
```
#### Examples:

```java
[Normal]
  > search beginner
// The decks having tags you are searching for:
// 2. Micro-economics
// 4. Macro-economics
```

> Notice how the original deck index is displayed.

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
// 1. market-failure
// 2. perfect competition
// 3. externalities
```

### Delete an existing deck: `delete`

Deletes an existing deck of flashcards. The `delete` command expects one argument specifying the index of the deck to
 be deleted. User is then further prompted for an input of only either `y` or `n`.
 
#### Format

```
[Normal]
  > delete <index of deck>
// Do you want to delete `name of deck`? [y/n] <y/n>
// `name of deck` has been deleted.
```

> Note: `name of deck` is a placeholder for the actual name of the deck corresponding to the index entered. The second
> line will only be displayed if the user entered y at the prompt for <y/n>.

One-line format:
```
  > delete <index of deck> -y
```
This command forces the delete of the deck at index `<index of deck>`.

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
// Do you want to delete market-failure? [y/n] no way
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

### Game Mode: `start`

Starts Game Mode for an existing deck. The `start` command expects one argument specifying the deck index for which to
 enter Deck Mode.
 
> The `start` command can also be entered from within Deck Mode, without the need for a deck index.
 
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

### Print an Existing Deck to a PowerPoint File: `pptx`

Prints an existing deck to a new PowerPoint file named `<deck name>.pptx` in `pptx/` folder.
The `pptx` command expects one argument specifying the deck index for which to enter Deck Mode.
You can add the option `-y` to create the PowerPoint without any further prompt.

 > The `pptx` command can also be entered from within Deck Mode, without the need for deck index.

#### Format

```java
// ------------------------------------------------------------
[Deck - `name of deck`]
  > pptx <index of deck>
// Do you want to print `name of deck` deck to PowerPoint? [y/n] yes
// Response should be 'y' or 'n'!
//   > y
// ------------------------------------------------------------
// `name of deck` has been created as PowerPoint.
// ------------------------------------------------------------
```

```java
// ------------------------------------------------------------
[Deck - `name of deck`]
  > pptx <index of deck> -y
// ------------------------------------------------------------
// `name of deck` has been created as PowerPoint.
// ------------------------------------------------------------
```

#### Examples

```java
------------------------------------------------------------
[Deck - Micro-Economics]
  > pptx 1
// Do you want to print Micro-Economics deck to PowerPoint? [y/n]
//   > yes
// Response should be 'y' or 'n'
//   > y
// ------------------------------------------------------------
// Micro-Economics has been created as PowerPoint.
// ------------------------------------------------------------
```

```java
// ------------------------------------------------------------
[Deck - Micro-Economics]
  > pptx 1 -y
// ------------------------------------------------------------
// Micro-Economics has been created as PowerPoint.
// ------------------------------------------------------------
```


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
//   create <nm>   [/tag <tag1> [<tag2> ...]]    Creates a new deck of flash cards, named <nm>.
//   decks                                       Lists all available decks.
//   edit   <ix>                                 Enter Deck Mode for editing the deck at list index <ix>.
//   start  <ix>                                 Enter Game Mode for deck at list index <ix>! Do your best!
//   delete <ix>   [-y]                          Deletes the deck at list index <ix> from list of decks.
//   pptx   <ix>   [-y]                          Creates a PowerPoint slides based on the deck at list index <ix>.
//   tag    <ix>   /tag <tag1> [<tag2> ...]      Tags the deck at list index <ix>, with 1 or more tags.
//   untag  <ix>   /tag <tag1> [<tag2> ...]      Untags specified <tag>s of the deck at list index <ix>.
//   search <tag1> [<tag2> ...]                  Search deck list for decks tagged with specified <tag>s.
//   exit                                        Exits the program.
//   help                                        Show this output.
//
// Options:
//   --version      Show version.
// ------------------------------------------------------------
```

## Features - Deck Mode

### Add a flashcard: `add`
Adds a flashcard to the end of the current deck. The `add` command expects no initial arguments. Instructions and 
format of card entry is displayed. Then, the user is prompted to specify the details of the flashcard to be added.

#### Format
```java
  > add
// Enter question: <question description>
// Enter answer: <question answer or explanation>
```
 
Equivalent One-line format:
```
  > add <question description> /ans <question answer or explanation>
```
>If `/ans` is not supplied, `<question description>` is stored and the user is prompted for the answer.
>
>If `<question description>` is empty, the input is invalid and the error message 
>```
>"Input shouldn't be empty! Returning..."
>```
>is shown.

#### Examples

```java
[Deck - market failure]
     > add 
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
List without answers:
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

List with answers:
```java
[Deck - market-failure]
  > list /ans
// ------------------------------------------------------------
// You are now viewing deck: market-failure
// ------------------------------------------------------------
// 1. Question: define market failure
//    Answer:   Market failure is the economic situation
//              defined by an inefficient distribution of goods
//              and services in the free market
// 
// 2. Question: What is a public good?
//    Answer:   A good which are non-rival and non-excludable
// 
// 3. Question: What is a merit good?
//    Answer:   A good that people underestimates the benefits
//              of
// ------------------------------------------------------------
```

### Delete an existing Flash Card: `delete`

Deletes an existing flashcard from deck. The `delete` command expects one argument specifying the index of the flash card to
 be deleted. User is then further prompted for an input of only either `y` or `n`.
 
#### Format

```java
[Deck - `name of deck`]
  > delete 1
// Do you want to delete the following flash card? [y/n] ?
//   '<question 1>' n
// ------------------------------------------------------------
```

```java
[Deck - `name of deck`]
  > delete 2
// Do you want to delete the following flash card? [y/n] ?
//   '<question 2>' y
// ------------------------------------------------------------
// The following flash card has been deleted:
//   '<question 2>'
// ------------------------------------------------------------
```

> Note: `name of deck` is a placeholder for the name of the current deck. The second
> line will only be displayed if the user entered y at the prompt for <y/n>.

One-line format:
```
  > delete <index of FlashCard> -y
```
This command forces the delete of the Flashcard at index `<index of FlashCard>`.

#### Examples

Deciding not to delete:
```java
[Deck - market-failure]
  > delete 1
// Do you want to delete the following flash card? [y/n]
//   `define market failure?` n
// ------------------------------------------------------------
[Deck - market-failure]
  > 
```

Confirming a delete:
```java
[Deck - market-failure]
  > delete 2
// Do you want to delete the following flash card? [y/n] ?
//   'What is a public good?' y
// ------------------------------------------------------------
// The following flash card has been deleted:
//   'What is a public good?'
// ------------------------------------------------------------
[Deck - market-failure]
  > 
```

Entering an invalid response:
```java
[Deck - market failure]
  > delete 2
// Do you want to delete the following flash card? [y/n] ?
//   'What is a public good?' definitely
// Response should be 'y' or 'n'!
//   > y
// ------------------------------------------------------------
// The following flash card has been deleted:
//   'What is a public good?'
// ------------------------------------------------------------
```

### Update an existing Flash Card: `update`

Updates the question and answer fields of a  specified flashcard in the deck. The `update` command expects no initial
 arguments. The current question and answer are displayed. Then, the user is prompted to specify the new details of
  the flashcard.

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
// ------------------------------------------------------------
// Question and answer updated.
// ------------------------------------------------------------
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
// ------------------------------------------------------------
// Question updated.
// ------------------------------------------------------------
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
// ------------------------------------------------------------
// Answer updated.
// ------------------------------------------------------------
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
// ------------------------------------------------------------
// Original question and answer retained.
// ------------------------------------------------------------
```

### Game Mode: `start`

Starts Game Mode for the current deck. 
 
> The `start` command can also be entered from within Normal Mode.
 
#### Format

```java
[Deck - market-failure]
  > start
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
  > start
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

### Print Current Deck to a PowerPoint File: `pptx`

Prints the current deck to a new PowerPoint file named `<deck name>.pptx` in `pptx/` folder.
You can add the option `-y` to create the PowerPoint without any further prompt.

> The `pptx` command can also be entered from within Normal Mode.
 
#### Format

```java
[Deck - `name of deck`]
  > pptx
// Do you want to print `name of deck` deck to PowerPoint? [y/n] <y/n>
// ------------------------------------------------------------
// `name of deck` has been created as PowerPoint.
// ------------------------------------------------------------
```

> Above displays the result for the case when user enters `y`.

```java
[Deck - `name of deck`]
  > pptx -y
// ------------------------------------------------------------
// `name of deck` has been created as PowerPoint.
// ------------------------------------------------------------
```

#### Examples

```java
[Deck - Micro-Economics]
  > pptx
// Do you want to print Micro-Economics deck to PowerPoint? [y/n] yes
// Response should be 'y' or 'n'
//   > y
// ------------------------------------------------------------
// Micro-Economics has been created as PowerPoint.
// ------------------------------------------------------------
```

```java
[Deck - Micro-Economics]
  > pptx -y
// ------------------------------------------------------------
// Micro-Economics has been created as PowerPoint.
// ------------------------------------------------------------
```

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
//   add         [<qn> /ans <ans>]    Adds a new flash card to the current deck.
//   list        [/ans]               Lists all flash cards in the current deck, optionally with answers.
//   delete <ix> [-y]                 Deletes the flash card at list index <ix> from the current deck.
//   pptx        [-y]                 Creates a PowerPoint slides based on the current deck.
//   start                            Enter Game Mode for this deck! Do your best!
//   done                             Exits from Deck Mode and returns to Normal Mode.
//   exit                             Exits the program.
//   help                             Show this output.
//
// Options:
//   --version      Show version.
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
  > start
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

## Features - Print to PowerPoint
### Create new PowerPoint based on the selected deck: `pptx`

Can be done from both Normal Mode and Deck Mode. In Normal Mode, a deck index is required, 
but in Deck Mode, there is no need to specify the deck index.
Has the option to skip confirmation prompt using `-y` suffix.

For details, check out:

* [Normal Mode PowerPoint](#print-an-existing-deck-to-a-powerpoint-file-pptx)
* [Deck Mode PowerPoint](#print-current-deck-to-a-powerpoint-file-pptx)


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

## Features - (Proposed) Encryption and Decryption

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

**A**: Escape the command using punctuations, e.g. `\done` or `"done"`.

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
|Tag deck|`tag <ix> /tag <tag1> [<tag2> ...]`|`tag 1 /tag important final-exam`|
|Untag deck|`untag <ix> /tag <tag1> [<tag2> ...]`|`untag 1 /tag important`|
|Search by tag(s)|`search <tag1> [<tag2> ...]`|`search final-exam important`|
|Display decks|`decks`||
|Delete deck|`delete <ix>`|`delete 1`|
|Enter Deck Mode|`edit <ix>`|`edit 1`|
|Enter Game Mode|`start <ix>`|`start 1`|
|Create PowerPoint|`pptx <ix> [-y]`|`pptx 1`|
|Help|`help`||

### Deck Mode

|Action|Format|Example|
|------|------|-------|
|Add flash card|`add`||
|List flash cards|`list [/ans]`||
|Delete flash card|`delete <ix>`|`delete 1`|
|Update flash card|`update <ix>`|`update 1`|
|Enter Game Mode|`start`||
|Create PowerPoint|`pptx [-y]`||
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
