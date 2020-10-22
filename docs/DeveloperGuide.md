# Developer Guide

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

#### How to **components** interact with one another
![Sequence Diagram](images-dg/Sequence%20Diagram.png)
The **Sequence Diagram** above shows how the components interact for a basic `create <deck name>` command where a new deck is created and added in to the `Deck List`.

### User Interface

**API**: [seedu/ecardnomics/Ui.java](https://github.com/AY2021S1-CS2113-T14-2/tp/tree/master/src/main/java/seedu/ecardnomics/Ui.java)

The UI contains String constants that represent the outputs
that the application is defined to produce.

The `UI` component has two main purposes:
* Reading user input from the console.
* Printing program output to the console.

Reading of user input is done using the method `readUserInput()`
which reads one line of user input. The other methods within `UI` are
called when a specific output needs to be printed.

The `UI` component passes the user input to the `NormalParser` and
`DeckParser` components that will extract the relevant information.
The `UI` component provides its printing methods to `NormalParser`
and `DeckParser` for printing the appropriate output when required.

### Logic
#### Overall Logic
![DG-Overall Logic UML](./images-dg/Logic-DG.png?raw=true "Overall Logic Diagram")

1. The overall logic component consists of the Parser class and Command class.
2. The Parser parses the user input and creates the respective Command object.
3. This command will be executed by the Main class.
4. The command execution then can affect the Model (e.g. creating a new deck)

#### Parsers
#### Commands

![DG-Design Commands UML](./images-dg/DG-Design-Commands.png?raw=true "Commands UML Class Diagram")

API: [seedu.ecardnomics/command](https://github.com/AY2021S1-CS2113-T14-2/tp/tree/master/src/main/java/seedu/ecardnomics/command)

Commands are primarily classified into two categories, `NormalCommand` and `DeckCommand`, corresponding to the
 application's Normal and Deck Modes, respectively. `NormalCommand` and `DeckCommand` are both abstract children derived
  from the overarching abstract class `Command`. The basis `Command` class is defined as such:
   
```java
public abstract class Command {
    public abstract void execute();
}
```

It only requires that all derived children implement the `execute()` method. The only two classes not belonging to
 either Normal or Deck Mode are `ExitCommand` and `VoidCommand`. The former is so that users can call the command
  `exit` from anywhere in the application, while the latter is a catch-all "command" for all erroneous commands a
   user enters. 
   
`NormalParser` and `DeckParser` play important roles in execution of specific commands, e.g. `CreateCommand`, because
 they define methods that check and ensure the conformity of user input to the commands' expected input. Below is a
  sequence diagram showcasing this interaction, for execution of a `CreateCommand`, e.g. `create
   microeconomics`:
  
![DG-Design CreateCommand Sequence UML](./images-dg/DG-Design-Sequence-Diagram.png?raw=true "CreateCommand UML
 Sequence Diagram")

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

## Implementation - Basic

## Implementation - Features

### Save to PPT (Kai Jie)

### Pretty Printing (Wei Siew)

### Tags and Filtering (Trang)

### Saving to text file (Wayne)

### Game Mode (Zhixiang)

## Product scope
### Target user profile

{Describe the target user profile}

### Value proposition

{Describe the value proposition: what problem does it solve?}

## User Stories

|Version| As a ... | I want to ... | So that I can ...|
|--------|----------|---------------|------------------|
|v1.0|new user|see usage instructions|refer to them when I forget how to use the application|
|v2.0|user|find a to-do item by name|locate a to-do without having to go through the entire list|

## Non-Functional Requirements

{Give non-functional requirements}

## Glossary

* *glossary item* - Definition

## Instructions for manual testing

{Give instructions on how to do a manual product testing e.g., how to load sample data to be used for testing}
