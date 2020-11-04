# Developer Guide

## Introduction

Flash Card manager for Economics students on Command Line.

See also: [User Guide](./UserGuide.md) | [Releases](https://github.com/AY2021S1-CS2113-T14-2/tp/releases) | [Team Project Portfolio Page](./AboutUs.md)

## Contents

- [Design](#design)
  * [Application Architecture](#application-architecture)
    + [How the components interact with one another](#how-the-components-interact-with-one-another)
  * [User Interface](#user-interface)
  * [Logic](#logic)
    + [Overall Logic](#overall-logic)
    + [Commands](#commands)
      - [Overview](#overview)
      - [Mode-specific commands](#mode-specific-commands)
      - [Command sequence](#command-sequence)
  * [Deck Model](#deck-model)
  * [Storage](#storage)
    + [Loading the deckList data](#loading-the-decklist-data)
    + [Writing the deckList data](#writing-the-decklist-data)
  * [Exceptions](#exceptions)
- [Implementation - Features](#implementation---features)
  * [Print to PowerPoint SlideShow](#print-to-powerpoint-slideshow)
  * [Pretty Printing (Wei Siew)](#pretty-printing--wei-siew-)
    + [Design Consideration:](#design-consideration-)
  * [Tags for grouping and searching decks](#tags-for-grouping-and-searching-decks)
  * [Game Mode](#game-mode)
    + [General Architecture](#general-architecture)
    + [Example Use Case](#example-use-case)
    + [Sequential Flow](#sequential-flow)
- [Product scope](#product-scope)
  * [Target user profile](#target-user-profile)
  * [Value proposition](#value-proposition)
- [User Stories](#user-stories)
- [Non-Functional Requirements](#non-functional-requirements)
- [Glossary](#glossary)
- [Instructions for manual testing](#instructions-for-manual-testing)

## Design

### Application Architecture
![Architecture](images-dg/Architecture.png)

The **Architecture Diagram** given above explains the high-level design of the Flash Card Manager Application.

`Main` is responsible for initializing the other components in the program and linking them up correctly.

* `Ui` Takes in instructions from user and displays the output to the user
* `Logic` Consists of the `Parsers` and the `Commands`. The `Parser` decipher the user input and executes the specific `Command` that affects the change the user wishes.
* `Model` Holds the data that is in memory as the program runs. It consists of the 3 components:
    * `Flash Card` : A single question and answer pair.
    * `Deck` : A list of `Flash Card`s under a common topic.
    * `Deck List` : A complete list of all the `Deck`s in memory.
* `Storage` Reads and writes data from and to a text file.

#### How the components interact with one another
The following **Sequence Diagram** shows how the components interact for a basic `create <deck name>` command where a new deck is created and added in to the `Deck List`.

![Sequence Diagram](images-dg/Sequence%20Diagram.png)
The sequence shown is as follows:
* The **`Main`** instance runs and calls the *`readUserInput()`*  of **`Ui`**. The function waits for the user to key in one line of input 
and then returns that input as a String to **`Main`**. **`Main`** calls *`parse`* of which creates a new **`CreateCommand`** and this is returned to **`Main`**. 
This section will be explained in details in the `Parser` section later on.
**`Main`** then calls for *`execute()`*  of the *`CreateCommand`* that calls *`addDeck()`* of **`DeckList`** and subsequently  *`printNewDeck()`* 
of **`Ui`** which prints the output to the user. 
Finally, **`Main`** calls *`write()`* of **`Storage`** to write the updated Deck List to the text file.


### User Interface

**API**: [seedu/ecardnomics/Ui.java](https://github.com/AY2021S1-CS2113-T14-2/tp/tree/master/src/main/java/seedu/ecardnomics/Ui.java)

The UI contains String constants that represent the outputs
that the application is defined to produce.

The `UI` component has two main purposes:
* Reading user input from the console.
* Printing program output to the console.

Reading of user input is done using the method *`readUserInput()`*
which reads one line of user input. The other methods within `UI` are
called when a specific output needs to be printed.

The `UI` component passes the user input to the **`NormalParser`** and
**`DeckParser`** components that will extract the relevant information.
The `UI` component provides its printing methods to **`NormalParser`**
and **`DeckParser`** for printing the appropriate output when required.

### Logic

#### Overall Logic
![DG-Overall Logic UML](./images-dg/Logic-DG.png?raw=true "Overall Logic Diagram")

1. The overall logic component consists of the **`Parser`** class and **`Command`** class.
2. The **`Parser`** parses the user input and creates the respective **`Command`** object.
3. This command will be executed by the **`Main`** class.
4. The command execution then can affect the Model (e.g. creating a new deck)

#### Commands

##### Overview

![DG-Design Commands UML](./images-dg/DG-Design-Commands-UML.png?raw=true "Commands UML Class Diagram")

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
   
![DG-Design Commands Breakdown](./images-dg/DG-Design-Commands-Breakdown.png?raw=true "Commands Components Breakdown")

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
  
![DG-Design CreateCommand Sequence UML](./images-dg/DG-Design-Sequence-Diagram.png?raw=true "CreateCommand UML
 Sequence Diagram")
 
Here, `parse()` first splits the user input `create microeconomics` into two strings, "create" and "microeconomics",
 the command word and command arguments respectively. Then within the `parseCommand()` call in `NormalParser`, a
 dedicated method to create a new deck based on the argument string "microeconomics", `prepareNewDeck()`, is called
 . A new `Deck` object is returned to the same `parseCommand()` call and used to create the new `CreateCommand
 ` object, which is then propagated back to `Main` (not shown here) that called `parse()`.
 
> Note that the `CreateCommand` object is not marked as deleted in the above diagram because its lifeline does not
> really end until its `execute()` method has been called from `Main`, using `Main`'s `executeCommand()`.

### Deck Model

![DG-Design Model UML](./images-dg/DG-Design-Model.png?raw=true "Model UML Class Diagram")

**API**: [seedu/ecardnomics/deck](https://github.com/AY2021S1-CS2113-T14-2/tp/tree/master/src/main/java/seedu/ecardnomics/deck)

The Deck Model component is made up of three parts:
* `DeckList`
* `Deck`
* `FlashCard`

The `FlashCard` component represents a flashcard, storing question
and answer data. The `Deck` represents a collection of flashcards
related by a common topic. The `DeckList` represents the collection
of all the `Deck` objects that the user has.

Only the `Command` components can modify the `DeckList`, `Deck` and
`FlashCard` components. However, `Ui`, `DeckParser` and `NormalParser`
are able to read data from the `DeckList`, `Deck` and `FlashCard`
components.

### Storage

#### Loading the deckList data

![Storage Sequence Diagram](./images-dg/Storage.png?raw=true "load Storage sequence diagram")

**API**: [seedu/ecardnomics/storage](https://github.com/AY2021S1-CS2113-T14-2/tp/blob/master/src/main/java/seedu/ecardnomics/storage)

Storage of this application uses basic `.txt` read and write functions.  
Upon start of the program, the application checks whether there is a `./data` folder and creates one is there isn't.  
Then, it reads from the storage file `deckList.txt` line by line to create:
* new **`Deck`**
* new **`FlashCard`**

and adds them to the current `deckList` passed into the *`load`* method call.

#### Writing the deckList data

Similarly, for writing the data into `.txt` file, the Storage will loop through all the current `Decks` and their
current `FlashCards` and write them in a specific format in the text file in the `./data` folder.

### Exceptions

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

## Implementation - Features

### Print to PowerPoint SlideShow

An additional feature targeted at students who wish to use add more style to their flash cards outside of the command 
line option to allow keep things interesting when they are revising.

The `PowerPointCommand` is parsed by `NormalParser` but the "Print to PowerPoint" command can be called from both Normal 
and Deck Mode. 

The following diagram shows how the `PowerPointCommand`'s `execute()` calls the `createNewPowerPoint()` method of `PowerPoint`.
*`execute()`* first checks if the whether `isPptxCreated` is `true` and only creates the PowerPoint if so. This is necessary as 
the user might have input the command `pptx` but when prompt for confirmation, they input `n` which means no, but the parser will 
still output a **`PowerPointCommand`** except with the element `isPptxCreated` as `false` and thus, when executed, nothing happens.
![PPTX Sequence Diagram](images-dg/PPTX-Sequence-Diagram.png)

The `newIntroSlide()`, `newSlide()` and `exportSlide()` method of `PowerPoint` uses a third party library - Apache POI 
to create new slides, populate them with the questions and answers from the deck and finally print them out to a new PowerPoint
 file in the `pptx` folder under the name `<deck name>.pptx`.
 
The following are the Classes/ Enum of the third part package `org.apache.poi.xslf.usermodel` which are used:
* `SlideLayout` - Enum representing the Slide Layouts available
* `XMLSlideShow` - Class representing an entire Slide Show
* `XSLFSlide` - Class representing a single Slide
* `XSLFSlideLayout` - Class representing the layout of a slide
* `XSLFSlideMaster` - Class representing the default slides layouts
* `XSLFTextShape` - Class representing a shape within a slide
* `XSLFTextParagraph` - Class representing a paragraph of text within a shape
* `XSLFTextRun` - Class representing the properties of the text within a paragraph

### Pretty Printing (Wei Siew)

The purpose of this feature is to improve the readability of the
question and answer fields of a flashcard for the user. Without this
feature, long question and answer fields will follow the default
wrapping style of the console. When words are truncated unnecessarily,
it is going to be distracting and annoying for students trying to
study. We illustrate the problem in the following example:
```
This is a long question (or maybe answer) field. Suppose tha
t our console is 60 characters wide, we see that the word "t
hat" was truncated in the first line and again in the second
line.
```
In this section, we define the following terms:
* `lineLength` is the maximum number of characters on a line,
set to be equal to Ui.DASH_LINES.length(). This is also the number of
characters between the start of line and end of line.
* `label` can be "Question: " or "Answer:   " and is used to indicate
whether a field is the question or answer of the flashcard.
* `usableLength` is the number of characters that can be used for
printing a field. This is also the number of characters between the end
of `label` and end of line.

The following sequence diagram illustrates the call to the
`toString(boolean isQuestion, int offset)` method of a `FlashCard`
object.

![DG-Implementation-Features-PP-Sequence](./images-dg/PP-Sequence.png?raw=true)

The `offset` parameter specifies the number of characters already
printed on the line before the flashcard field will be printed.
The `offset` is used by the `formatResponse()` method to determine
`usableLength`.

`formatResponse()` places as many words as possible on each line until
the next word does not fit within the `usableLength` of the current
line. This word is therefore placed on the next line and the process
repeats until all the words have been formatted into the response. If
the  length of a single word exceeds the `usableLength`, the word is
split across multiple lines to prevent the program from looping
infinitely as it would never be able to fit the word on any line.

Take note that infinite loops can still occur if
* formatResponse() is called with offset >= `lineLength` or
* toString(boolean, int) is called with offset >= `lineLength` - length
of `label`

#### Design Consideration:

In order to maximize `usableLength`,
`toString(boolean isQuestion, int offset)` is designed to take
parameter `offset` instead of hardcoding `offset` to be
`"2147483647. ".length()` which is the maximum possible index when
listing flashcards. As a result, flashcards with different number of
digits in the index will be misaligned when listing flashcards.

### Tags for grouping and searching decks
The purpose of this feature is to provide a mean to group the decks based on their subjects
and search for relevant decks related to one or more relevant subjects in a robust way. Each created deck will
tagged to their respective field.

![DG-Implementation-Features-TagArchitecture](./images-dg/TagFeature-UML.png?raw=true)

The user can also modify to tags of the decks by using tag or untag command, and uses search by tag to find
a group of decks he/she is interested in.

![DG-Implementation-Features-TagSequence](./images-dg/Tag.png?raw=true)

### Game Mode

eCardnomics' quintessential mode. Game Mode can be started from either Normal Mode or Deck Mode. The `start` command
 is parsed by `NormalParser` (see [Commands](#commands)).

#### General Architecture

Game Mode contains two main components: a storage component, `GameStorage`, and a logic component, `GameEngine`. The
 former handles all data structures used by Game Mode, and stores the original deck (`originalDeck`), question pool
  (`deque`), and retest question pool (`retestStore`). The latter executes the main game loop (`runGameLoop()`), and
   interacts with `GameStorage` on package-private basis; i.e., `GameEngine` and `GameStorage` have full mutual
    access as if they were a single class. This is one of the main intentional design decisions.
  
![DG-Implementation-Features-Game-Mode-Architecture](./images-dg/DG-Game-Mode-Architecture-Overview.png?raw=true "Game Mode
 Architecture Overview")

The schematic below describes the individual responsibilities of the `GameStorage` and `GameEngine` classes (or
 components) of Game Mode as introduced above, and also two key interactions between the two classes, namely via
  `GameEngine`'s `update(isResponseY:boolean, flashCard:FlashCard)` and `poseQuestion()` method calls. For
   context, `poseQuestion()` pops the top flash card off `GameStorage`'s question pool `deque` to display to the user
   , while `update()` is the `GameEngine` method that adds to the retest question pool `retestStore
   ` when the user chooses to do so (via `isResponseY == true`). This essentially describes one iteration of
    `runGameLoop()`; more explanation and a full-blown illustration and sequence are given further below.  

![DG-Implementation-Features-Game-Storage-Game-Engine](./images-dg/DG-Game-Storage-Game-Engine.png?raw=true "Game
 Mode Game Storage Game Engine")
 
**See also**: [Gameplay description](./UserGuide.md#gameplay)

The actual "game" aspect of eCardnomics is essentially summarised in the `runGameLoop()` high-level overview above
. For a textual gameplay description, check out the "See also" link. 

#### Example Use Case

For a more contextual use case, consider the following scenario of Econs Wiz attempting the Game Mode for the first
 deck, `Demand-Supply`, in his deck list.

> Note: Focus on the biggest box in the diagram!

![DG-Implementation-Features-Game-Use-Case](./images-dg/DG-Game-Use-Case.png?raw=true "Game Mode Use Case")

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

![DG-Implementation-Features-Game-Mode-Sequence](./images-dg/DG-Game-Mode-Sequence.png?raw=true "Game Mode UML Sequence
 Diagram")
 
 In the above diagram the key takeaway is the existence of an *intermediary* `game:Game` object that holds
  `GameEngine` and `GameStorage` together. In fact, this is the sole purpose of the `Game` class: to hold the
   current game instance, in a Single-Responsibility-Principle (SRP) and Object-Oriented Programming (OOP) manner. 
   This intermediary role of the `Game` class is also illustrated in the upper part of the earlier [use case
    diagram](#example-use-case). Note how it is from this `game` object that the main game loop, run and managed by
     `GameEngine`, is started.
 
![DG-Implementation-Features-Game-Mode-Sequence-run-game-loop-sd](./images-dg/DG-run-game-loop-sd.png?raw=true "Game
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

## Product scope

### Target user profile

Junior College Economics Students.

Anybody > Students > Students in courses with high amount of content > Economics students > **Junior College
 Economics students** (focus on theory than calculations)

### Value proposition

Flashcard application that allows students to quickly create new flashcards and access flashcards quickly on the
 command line to enhance their studying experience, and ultimately be an aid for [active recall](https://getatomi.com/blog/what-is-active-recall-and-how-effective-is-it).

## User Stories

|Version| As a(n) ... | I want to ... | So that I can ...|
|--------|----------|---------------|------------------|
|v1.0|poor student|have small computer programs|run it on my old computer|
|v1.0|fast typist|have an easily-navigable interface to type up notes and store them|create and manage notes quickly and efficiently|
|v1.0|smart student|be able to use the system effectively and efficiently|save time and maximise my productivity|
|v1.0|JC econs student|quickly create short notes of key concepts|keep up during lectures and tutorials|
|v1.0|tech-savvy student|have a software tool to store my notes|stop needing to worry about losing my hardcopy notes|
|v1.0|lazy student|create flashcards to keep my notes concise|learn at a comfortable, incrementing pace|
|v2.0|organised student|have my notes be stored in a systematic way|retrieve them quickly and easily|
|v2.0|student|have a system that can categorise material into different topics|quickly revise all the content for a topic when studying for an exam|
|v2.0|hardworking student|have a studying system that can help me memorise content in a non-traditional manner|remember all the facts during an exam through active recall|

## Non-Functional Requirements

{Give non-functional requirements}

## Glossary

* *glossary item* - Definition

## Instructions for manual testing

{Give instructions on how to do a manual product testing e.g., how to load sample data to be used for testing}
