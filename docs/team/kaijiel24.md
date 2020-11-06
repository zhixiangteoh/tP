
# Liau Kai Jie - Project Portfolio Page

## Overview
eCardnomics is a complete Command Line Interface Flash Card manager program for fast-typing, Junior College Economics 
students to create flash cards. The manager can store multiple decks of flash cards, which consists of a question and an 
answer, and has 3 distinct modes of operation.

In Normal mode, it can manage decks of flash card performing operations such as `create`, `delete`, `tag`, `search` and 
`ppt` on a particular deck. 

There is also Deck mode which can accessed from Normal mode via the operation `edit` which allows the user to edit the 
flash cards within a deck by performing operations such as `add`, `delete` and `update`. 

The last mode is Game mode which is the main tool that the users will be using after they have created a deck to help them 
with their studying by practicing active recall. Questions will be presented one at a time, at random, and the user has to key in the 
answer as they remember it. The program will then calculate the percentage similarity with the correct answer and display 
the original answer at the same time. The program prompts the user on whether to have the question come up again in the current 
game. 

### Summary of Contributions
The following are the basic and additional features that I have worked on:
Basic features
* Run Normal mode and run Deck mode in Main
* Normal Parser 
* Deck Parser
* Edit command to enter Deck mode from Normal mode
* Exit command from both Normal and Deck mode
* Done Edit command to return to Normal mode form Deck mode
* Getting index from user input to be used in commands which require an index (such as `delete`, `edit`,`tag`)
* Handling Exceptions for user input index (such as number too big, index format error)

Additional features
* Powerpoint command 
    * This feature allows the user to print any deck to a PowerPoint Slide (.pptx file)
    * The target for this could be students who wish to use the flash cards they have created on other platforms such
        their mobile phones or test themselves outside of the CLI. 
    * This command can be called from both Normal mode (need to specify which deck to use) and Deck mode (do not 
        need to specify, automatically uses the current deck)
* 'Force Yes' option for commands that have prompt for confirmation (such as `delete` and `ppt`)
    * This feature allows fast-typist to directly enter a one-line command by adding the option `-y` after the commands
        to by pass the prompt, and to be more efficient in their use of the program.