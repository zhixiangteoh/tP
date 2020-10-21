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

### Parsing and Logic

### Commands

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
