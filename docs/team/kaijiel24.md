
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
v1.0:
* Run Normal mode and run Deck mode in Main
* Normal Parser 
* Deck Parser
* Edit command to enter Deck mode from Normal mode
* Exit command from both Normal and Deck mode
* Done Edit command to return to Normal mode from Deck mode
* Getting index from user input to be used in commands which require an index (such as `delete`, `edit`,`tag`)
    * Handling Exceptions for user input index 
        * If the argument given is not a positive integer (-1, micro-economics, or random etc...), `IndexFormatException`
            will be thrown.
        * If the number given is too big such that it is greater than MAX_INT and cannot be stored in an integer variable,
            `NumberTooBigException` will be thrown.
        * If the number given is not within the range of number of decks/ flash cards (either 0 or greater than number
            of decks/ flash cards), `DeckRangeException`/ `FlashCardRangeException` will be thrown.

v2.0
* Powerpoint command 
    * This feature allows the user to print any deck to a PowerPoint Slide (.pptx file) within the pptx folder of the 
        current working directory.
    * The target for this could be students who wish to use the flash cards they have created on other platforms such
        their mobile phones or test themselves outside of the CLI. 
    * This command can be called from both Normal mode (need to specify which deck to use) and Deck mode (do not 
        need to specify, automatically uses the current deck).
  
* 'Force Yes' option for commands that have prompt for confirmation (such as `delete` and `pptx`)
    * This feature allows fast-typist to directly enter a one-line command by adding the option `-y` after the commands
        to by pass the prompt, and to be more efficient in their use of the program.
        
v2.1
* Powerpoint command choose text and background color
    ![Example of PowerPoint Slide](../images-ug/PPTX-Example.png)
    *Example of PowerPoint Slide with steelblue background and silver text created using the `-cs` option*
    
    * Added two options to `pptx` command that allows user to choose their preferred background and text color for the 
        PowerPoint slides that are created. 
        * Default *Color Schemes* `-cs` 
            * If the user does not know what specific colors to use, this option gives provides 
                the 10 default color combinations to choose from.
            * The 10 color combinations can be found in [User Guide](../UserGuide.md#default-color-schemes).
            * The color combinations selected complement each other so that the user can have an easy time reading the
                text while keeping things interesting (away from a simple black on white background).
            * The format for the option is `-cs  <index of color scheme>`
            * There are exceptions thrown if the index is either not within the range [1,10], `CsIndexRangeException` or 
                not in the correct format, `CsIndexFormatException`.
        * *Original Color* selection `-oc`
            * If the user has a specific color combination preference, this option allows provides the flexibility to 
                create a truly unique PowerPoint slide.
            * There are up to 148 different colours to choose from which can be found at this 
                [site](https://www.javadoc.io/doc/org.beryx/awt-color-factory/1.0.1/org.beryx.awt.color/org/beryx/awt/color/ColorFactory.html#ALICEBLUE)
            * The format for this option is `-oc bg color> <txt color>`
            * There is an exception thrown, `ColorsNotAvailException` when the at least one of the colors chosen is not 
                a valid color.
        
    * In each command, only either of the options can be used to select the colors so if both options are included 
        at the same time, there will be an exception thrown, `BothCsAndOcException`.
    * Any other options entered starting with `-` will trigger the exception, `InvalidOptionException`.
    
    