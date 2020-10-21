# Developer Guide

## Design

### Application Architecture

### User Interface
**API** `Ui.java`

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
