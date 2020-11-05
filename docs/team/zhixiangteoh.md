# Zhixiang Teoh - Project Portfolio Page

## Overview

eCardnomics is a **desktop flashcard application to quickly create, manage, and access new flashcards via a Command
 Line Interface (CLI)**. eCardnomics is targeted at economics students in Junior College in Singapore, and aims to
 enhance students’ study experience as an efficient and handy aid for active recall. 
  
The main goals of this application are to help students store and segment their economics subject syllabus into
 different decks, consolidate bite-sized information within each topic by way of flash cards, and offer a fun
  way for students to study and revise.

## Summary of Contributions

### Code contributed

Summary: [tP Code Dashboard](https://nus-cs2113-ay2021s1.github.io/tp-dashboard/#breakdown=true&search=zhixiangteoh&sort=groupTitle&sortWithin=title&since=2020-09-27&timeframe=commit&mergegroup=&groupSelect=groupByRepos&checkedFileTypes=docs~functional-code~test-code~other)

In short, I did the following:

**v1.0**
* [Set up UG, write Introduction, Preliminaries](https://github.com/AY2021S1-CS2113-T14-2/tp/commit/a4eb7de173daddef27e3c76c7a58b62939063e0b), [Command Summary](https://github.com/AY2021S1-CS2113-T14-2/tp/commit/c9d16d286de7d1338ae8ec4dcaf224f45f8f0b78) 
* UG for [Normal Mode, half of Deck Mode](https://github.com/AY2021S1-CS2113-T14-2/tp/commit/afd37e97d5f1fe4d585538d3b8973cf45dd75b51)
* [Half of Deck Mode commands, for v1.0](https://github.com/AY2021S1-CS2113-T14-2/tp/commit/4f52a8d8aa29b3dbe61442f4eaf3117bf3f1c9ac)
* [JUnit Tests for DeckParser, NormalParser](https://github.com/AY2021S1-CS2113-T14-2/tp/commit/768192db9fdb8e2064ca44348375dd7664faf855), Ui

**v2.0**
* UG for [Game Mode](https://github.com/AY2021S1-CS2113-T14-2/tp/commit/207103b41966691a768502f899e1b6d4c23a3950), [Help commands](https://github.com/AY2021S1-CS2113-T14-2/tp/commit/15b51255ecde6085d941e0825180668e5d1a149d), [Command Summary](https://github.com/AY2021S1-CS2113-T14-2/tp/commit/4129639e2d6e3c6fc421e1e0ebec79148b967d96), FAQ
* DG for [Commands](https://github.com/AY2021S1-CS2113-T14-2/tp/commit/072d00d0e703b9d90d486f0c8ab35bc9f6bf7261) and [Game Mode](https://github.com/AY2021S1-CS2113-T14-2/tp/commit/ba39ebbb46ce52e55001857c0c8a65e57af053a3) sections, [Product Scope, User Stories](https://github.com/AY2021S1-CS2113-T14-2/tp/commit/b22e88ee875479db0b77ee021487ae6253afd3b0)
* Implementation of [Game Mode](https://github.com/AY2021S1-CS2113-T14-2/tp/commit/f3975adca5c43c6172d4cc7d7d5a6452493368d5)
* Refine Help commands
* JUnit Tests for Game Mode

### Enhancements implemented

In v1.0, I split the work with Wayne in implementing the Deck Mode commands. Specifically, I implemented:

* [DeleteCommand](https://github.com/AY2021S1-CS2113-T14-2/tp/commit/4f52a8d8aa29b3dbe61442f4eaf3117bf3f1c9ac)
* [HelpCommand](https://github.com/AY2021S1-CS2113-T14-2/tp/commit/622e584ff2847c15877375fd05a3c7db60bc9858)

`DeleteCommand` required me to implement a `y/n` prompt method for the `Ui` class, to be used by `DeckParser`, which
 was later used by all commands in the application that utilise `y/n` prompts. Below is an example of the user-interface appearance of the `y/n` prompt:
  
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

In v2.0, I implemented the [Game Mode feature](https://github.com/AY2021S1-CS2113-T14-2/tp/pull/94). For this, our team originally thought it would be just another command
 implemented as part of Normal Mode or Deck Mode, but I felt it deserved its own mode, and would better fit into the
  design and architecture of the application, as well as the semantics of the Game Mode. Thus I created a separate
   package, [`game`](), and parser class `GameParser` for Game Mode, with the `game` package abstracting away the
    entire Game Mode implementation from the rest of the application.
    
So the resulting `game` package is structured as such:

```
game 
  | Game
  | GameEngine
     | runGameLoop(), update()
  | GameStorage
     | originalDeck, deque, retestStore
```

Here, I tried as much as possible to incorporate the Single Responsibility Principle, both within the `game` classes
 and the SRP-ness of the existing classes.

### Contributions to the UG

Mainly [Introduction](https://ay2021s1-cs2113-t14-2.github.io/tp/UserGuide.html#introduction), v1.0 Normal Mode
 commands, [Features - Game Mode](https://ay2021s1-cs2113-t14-2.github.io/tp/UserGuide.html#features---game-mode), [Command Summary](https://ay2021s1-cs2113-t14-2.github.io/tp/UserGuide.html#command-summary).

* Introduction
* Contents
* [v1.0 Normal Mode commands](https://github.com/AY2021S1-CS2113-T14-2/tp/pull/57)
* some v1.0 Deck Mode commands
* [`help` commands](https://github.com/AY2021S1-CS2113-T14-2/tp/pull/156)
* `start` commands
* [Game Mode commands and gameplay description](https://github.com/AY2021S1-CS2113-T14-2/tp/pull/100)
* Anywhere Mode
* FAQ
* Command Summary

### Contributions to the DG

Mainly [Commands section](https://ay2021s1-cs2113-t14-2.github.io/tp/DeveloperGuide.html#commands) and 
[Exceptions section](https://ay2021s1-cs2113-t14-2.github.io/tp/DeveloperGuide.html#exceptions) under Design, 
and [Game Mode section](https://ay2021s1-cs2113-t14-2.github.io/tp/DeveloperGuide.html#game-mode) under Features. 

Relevant Pull Requests for DG:

* Commands [v2.0](https://github.com/AY2021S1-CS2113-T14-2/tp/pull/89), [v2.1](https://github.com/AY2021S1-CS2113-T14-2/tp/pull/166)
* [Exceptions](https://github.com/AY2021S1-CS2113-T14-2/tp/pull/166)
* Game Mode [v2.0](https://github.com/AY2021S1-CS2113-T14-2/tp/pull/104), [v2.1](https://github.com/AY2021S1-CS2113-T14-2/tp/pull/166)
* [Trivial](https://github.com/AY2021S1-CS2113-T14-2/tp/pull/105)

### Contributions to team-based tasks

Some examples:

* Re-organised packages a few times
* [Released JAR v1.0 and v1.1](https://github.com/AY2021S1-CS2113-T14-2/tp/releases)
* Maintained issue tracker - authored over 37 issues, closed and opened relevant issues, wrapped up Milestones
* [Created and started several Test classes](https://github.com/AY2021S1-CS2113-T14-2/tp/pull/55), e.g. `UiTest`, `NormalParserTest`, `DeckParserTest`
* [Started and set up User Guide](https://github.com/AY2021S1-CS2113-T14-2/tp/pull/57)
* Wrote some trivial aspects of User Guide (e.g. Introduction, Preliminaries, Command Summary) and Developer Guide
 (e.g. Product Scope, User Stories)
* Formatted and arranged [team Google Docs](https://docs.google.com/document/d/1e6HD8JaxAlITihBmqEDQnyKyVa52FLcAWi3Im_7wS6g/edit)

### Review/mentoring contributions

Some examples:

* Reviewed and merged about 5-10 Pull Requests by other teammates
* [Authored](https://github.com/AY2021S1-CS2113-T14-2/tp/pulls?q=is%3Apr+is%3Aclosed+author%3Azhixiangteoh+) over 24 Pull Requests

### Contributions beyond the project team

Notable posts/responses posted in forum:

* [Generating markdown table of contents](https://github.com/nus-cs2113-AY2021S1/forum/issues/108)
* [Comments on others' forum posts](https://github.com/nus-cs2113-AY2021S1/forum/issues?q=is%3Aissue+is%3Aclosed+zhixiangteoh)
* [Peer Evaluation-Dry Run on `Scheduler--;`](https://github.com/zhixiangteoh/ped/issues)

### UG Extracts

#### Guide format

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

#### v1.0 Normal Mode commands example - `create`

##### Create a new deck: `create`

Creates a new deck of flashcards. The `create` command expects one argument specifying the name of the deck to be
 created.

##### Format

Create deck without tags:
```java
create <name of deck>
```
Create deck with tag(s):
```java
create <name of deck> [/tag <tag1> [<tag2>]]
```

##### Examples

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

#### v1.0 Deck Mode commands example - `add`

##### Add a flashcard: `add`
Adds a flashcard to the end of the current deck. The `add` command expects no initial arguments. Instructions and 
format of card entry is displayed. Then, the user is prompted to specify the details of the flashcard to be added.

##### Format
```java
  > add
// Enter question: <question description>
// Enter answer: <question answer or explanation>
```

##### Examples

```java
[Deck - market failure]
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

#### v2.0 Deck Mode commands - `start`

##### Game Mode: `start`

Starts Game Mode for the current deck. 
 
> The `start` command can also be entered from within Normal Mode.
 
##### Format

```java
[Deck - market-failure]
  > start
```

##### Examples

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

#### Features - Game Mode

##### Gameplay

Questions are displayed in a randomised order. At each question, the user will:

1. Try to attempt an answer at the question, by typing at the prompt; then
2. Press `<enter>` (optionally with an empty attempt).

Then, the correct answer is displayed, and our 'advanced' algorithm scores the user's attempt against the correct
 answer. Finally, the user is given the option to re-attempt the question later. See below for example gamplay.
 
##### Examples

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

### DG Extracts

#### Design - Commands section

##### Overview

![DG-Design Commands UML](../images-dg/DG-Design-Commands-UML.png?raw=true "Commands UML Class Diagram")

**API**: [seedu.ecardnomics/command](https://github.com/AY2021S1-CS2113-T14-2/tp/tree/master/src/main/java/seedu/ecardnomics/command)

Commands are primarily classified into three categories, **`NormalCommand`**, **`DeckCommand`**, and **`GameCommand`**,
 corresponding to the application's Normal, Deck, and Game Modes, respectively. All three are abstract children
  derived from the overarching abstract class **`Command`**. The basis **`Command`** class is defined as such:
   
```java
public abstract class Command {
    public abstract void execute();
}
```

It only requires that all derived children implement the *`execute()`* method. The only two classes not belonging to
 individual modes are **`ExitCommand`** and **`VoidCommand`**. The former is so that users can call the command `exit`
  from anywhere in the application, while the latter is a catch-all "command" for all erroneous commands a user
  enters.

##### Mode-specific commands

The specific commands defined within the different Modes are shown below; one can simply substitute the `Normal Mode
 Commands`, `Game Mode Commands` and `Deck Mode Commands` components in the above UML class diagram with the
  corresponding `Command` classes, with all of the classes inheriting from the corresponding abstract classes, and
   being associated (with arrows pointing towards) with the corresponding `Parser` classes.
   
![DG-Design Commands Breakdown](../images-dg/DG-Design-Commands-Breakdown.png?raw=true "Commands Components Breakdown")

Notice that the same `StartCommand` class above is indicated as being in both Normal Mode and Deck Mode. While the
 diagram does not explain this phenomenon fully, the idea is there: that `start` is a command that can be run from
  within Deck Mode, but that its implementation is passed to `NormalParser` to be handled as a Normal Mode command
  . More specifically, within the specification of `DeckParser`'s `parseCommand()` method, the case of command word
   being parsed as `start` will in turn call `NormalParser`'s `parseCommand()` method, supplementing it with
    `DeckParser`'s Deck class field object as the `arguments` String. 

##### Command sequence

The **`Parser`** classes play important roles in execution of specific commands, e.g. **`CreateCommand`**, because
 they define methods that check and ensure the conformity of user input to the commands' expected input. Below is a
  sequence diagram showcasing this interaction, for execution of a **`CreateCommand`**, e.g. `create
   microeconomics`:
  
![DG-Design CreateCommand Sequence UML](../images-dg/DG-Design-Sequence-Diagram.png?raw=true "CreateCommand UML
 Sequence Diagram")
 
Here, `parse()` first splits the user input `create microeconomics` into two strings, "create" and "microeconomics",
 the command word and command arguments respectively. Then within the `parseCommand()` call in `NormalParser`, a
 dedicated method to create a new deck based on the argument string "microeconomics", `prepareNewDeck()`, is called
 . A new `Deck` object is returned to the same `parseCommand()` call and used to create the new `CreateCommand
 ` object, which is then propagated back to `Main` (not shown here) that called `parse()`.
 
> Note that the `CreateCommand` object is not marked as deleted in the above diagram because its lifeline does not
> really end until its `execute()` method has been called from `Main`, using `Main`'s `executeCommand()`.

#### Design - Exceptions section

![DG-Design Exceptions Architecture](./images-dg/DG-Exceptions-Architecture.png?raw=true "Exceptions Architecture
 Overview")

**API**: [seedu/ecardnomics/exceptions](https://github.com/AY2021S1-CS2113-T14-2/tp/blob/master/src/main/java/seedu/ecardnomics/exceptions)

How to read the diagram above:
- The font colour of the methods correspond to the fill colour of the Exception classes that they throw; e.g
., `NormalParser`'s `prepareNewDeck()` method throws `EmptyInputException`
- Additionally, methods that throw more than one exception will have their colours corresponding to one of the
 exception classes' fill colours, with the other associations denoted by explicit textual annotation on the
  association arrows; e.g., `NormalParser`'s `getIndex()` and `prepareDeck()` methods additionally throw
   `DeckRangeException`, on top of throwing `IndexFormatException`
- Each Exception class only has one String field unique to the class that holds the Exception message which is
 printed to the user on encountering the associated erroneous feedback

#### Feature Implementation - Game Mode

eCardnomics' quintessential mode. Game Mode can be started from either Normal Mode or Deck Mode. The `start` command
 is parsed by `NormalParser` (see [Commands](#commands)).

#### General Architecture

Game Mode contains two main components: a storage component, `GameStorage`, and a logic component, `GameEngine`. The
 former handles all data structures used by Game Mode, and stores the original deck (`originalDeck`), question pool
  (`deque`), and retest question pool (`retestStore`). The latter executes the main game loop (`runGameLoop()`), and
   interacts with `GameStorage` on package-private basis; i.e., `GameEngine` and `GameStorage` have full mutual
    access as if they were a single class. This is one of the main intentional design decisions.
  
![DG-Implementation-Features-Game-Mode-Architecture](../images-dg/DG-Game-Mode-Architecture-Overview.png?raw=true
 "Game Mode
 Architecture Overview")

The schematic below describes the individual responsibilities of the `GameStorage` and `GameEngine` classes (or
 components) of Game Mode as introduced above, and also two key interactions between the two classes, namely via
  `GameEngine`'s `update(isResponseY:boolean, flashCard:FlashCard)` and `poseQuestion()` method calls. For
   context, `poseQuestion()` pops the top flash card off `GameStorage`'s question pool `deque` to display to the user
   , while `update()` is the `GameEngine` method that adds to the retest question pool `retestStore
   ` when the user chooses to do so (via `isResponseY == true`). This essentially describes one iteration of
    `runGameLoop()`; more explanation and a full-blown illustration and sequence are given further below.  

![DG-Implementation-Features-Game-Storage-Game-Engine](../images-dg/DG-Game-Storage-Game-Engine.png?raw=true "Game
 Mode Game Storage Game Engine")
 
**See also**: [Gameplay description](../UserGuide.md#gameplay)

The actual "game" aspect of eCardnomics is essentially summarised in the `runGameLoop()` high-level overview above
. For a textual gameplay description, check out the "See also" link. 

#### Example Use Case

For a more contextual use case, consider the following scenario of Econs Wiz attempting the Game Mode for the first
 deck, `Demand-Supply`, in his deck list.

> Note: Focus on the biggest box in the diagram!

![DG-Implementation-Features-Game-Use-Case](../images-dg/DG-Game-Use-Case.png?raw=true "Game Mode Use Case")

**API**: [seedu/ecardnomics/game](https://github.com/AY2021S1-CS2113-T14-2/tp/tree/master/src/main/java/seedu/ecardnomics/game)

Since there are quite a few things going on in this diagram, here are the key takeaways (the last of which arguably
 the most important):
- the retest question pool (`retestStore`) is updated upon the user's attempt at each question and response to the
 prompt to include or exclude the flash card to be displayed again—if `y` then the flash card is added to the
  `retestStore`
- whenever the current question pool (`deque`) is emptied, i.e. all flash cards have been popped off and displayed to
 the user, the retest question pool (`retestStore`) is consulted from which to create a new question pool (`deque`)
- after a specific question is displayed, it does not appear again (even if the user has chosen to re-encounter the
 question) until after all other questions in the current question pool (`deque`) have been exhausted 

#### Sequential Flow

For a more formal sequential flow of the inner workings of Game Mode, the following elaborates the execution
 sequence of Game Mode, from after a `start` command has been parsed in Normal Mode:

![DG-Implementation-Features-Game-Mode-Sequence](../images-dg/DG-Game-Mode-Sequence.png?raw=true "Game Mode UML Sequence
 Diagram")
 
 In the above diagram the key takeaway is the existence of an *intermediary* `game:Game` object that holds
  `GameEngine` and `GameStorage` together. In fact, this is the sole purpose of the `Game` class: to hold the
   current game instance, in a Single-Responsibility-Principle (SRP) and Object-Oriented Programming (OOP) manner. 
   This intermediary role of the `Game` class is also illustrated in the upper part of the earlier [use case
    diagram](#example-use-case). Note how it is from this `game` object that the main game loop, run and managed by
     `GameEngine`, is started.
 
![DG-Implementation-Features-Game-Mode-Sequence-run-game-loop-sd](../images-dg/DG-run-game-loop-sd.png?raw=true "Game
 Mode UML Sequence Diagram run game loop sd")
 
The main game loop. As with all simple games, this flash card game mode is fundamentally built on the concept of a
 possibly never-ending game loop with specific end conditions. In this case, the main end condition is explicitly
  that the `command` object that is parsed and returned upon the `getAttempt()` call (that prompts the user for an
   answer attempt) is either a `DoneGameCommand` or `ExitCommand`. 

> This is not the *only* end condition, though, because the other important but implicit end scenario is when the
> question pool is exhausted (i.e., `storage.deque` is empty) **and** the retest question pool (`storage.retestStore
>`) is empty.

Naturally, the other sequence of special note here is the whole `update()` sequence, and even more specifically the
 `updateDeque()` call within the `update()` sequence. Notice how `updateDeque()` calls `createRandomisedStack(storage
 .retestStore)` with the `retestStore` as argument. This essentially creates a new randomised question pool from the
  retest question pool. 
  
Notice how this `updateDeque()` sequence is only called exactly when the `storage.deque` is empty (i.e., when all
 questions have been popped off the question pool). This is important because it ensures that the user encounters all
  available questions in the `deque` at least once before the retest questions are later displayed. Cross-check this
   with the detailed descriptions of the inner workings of the game loop implementation shown in the earlier
    [architecture](#general-architecture) and [use case](#example-use-case) diagrams.
  
Lastly, notice how `refreshRetestStore()` is called at the end of `updateDeque()` to, as its name suggests, clear the
 retest question pool to get ready to store the next wave of retest questions. This is also covered in the bottom few
  lines of the `GameEngine` portion of the use case diagram.
