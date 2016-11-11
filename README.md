# GameOfLife
I write all my test codes in CellTest.java and MainPanelTest.java, all the tests are based on the modification I made in the Cell.java and the MainPanel.java. I found methods to be enhanced and modified in those two functions. I pushed all the stuffs to the GitHub, the link is at the top of the next page. 

For this deliverable, the first thing to do is detect which method to modify in this project. I profiled this application through VisualVM, which is helpful to determine which part within this code can I improve the efficiency. I started by running the program with VisualVM running, and was able to shrink a few big-problem methods as target from the start. I ran it with a continuous run for a while, then also tried the write function. In this case, Cell.toString() and MainPanel.convertToInt() are the methods that took the most CPU time among all. 

For Cell.toString(), I went through the code to determine the end result of the function. I found out some methods are unnecessary and removed those, replaced those with more performable codes by myself. Besides, I wrote several pinning tests to make sure the results were the same as the original, to keep the functionality unchanged as expected. Following the requirements and my organization, then, I removed the loop from the function and simplified how the function returned the value without doing extra work. Running the pinning test code to verify the functionality.

Similarly, following the same process for MainPanel.convertToInt(). It seems that the entire function was redundant – the value that needed to be converted to an int was already an int. I also wrote pinning tests to ensure the functionality running correctly, then changed some code in the function to simply return the value that was expected. Because the convertToInt() function was private,  I wrote a  function that accepted an int, called convertToInt(). So as to apply the pinning tests. Making sure the functionality was not changed and the above two methods were more performable. After that, I reran the VisualVM and noticed two other functions to be modified – Cell’s constructor and MainPanel.runContinuous(). For Cell’s constructor, I found that MainPanel.backup() was creating entirely new objects every time it was called, and it was called every iteration. However, the only use for the backup file was to undo the last run and the undo functionality only needed to know whether the Cell was alive or not. So I refactored at this place which was discussed in the code comment. For the runContinuous function, I decided to make manual tests for this since there is no way to run unit test as there’s no input/output values in that method (void function). I checked functionality during continuous run and made sure there’s no change after I refactored by removing the unnecessary loop.

At last, the runContinous method still shows as taking the most CPU time in VisualVM, but it seems to be as a natural phenomenon due to this method is running continuously.   

Manual Tests in this project:
1.
Preconditions: There is a vertical line of three alive cells on the screen.
Execution: Press the Run button.
Postconditions: The top and the bottom cells of that vertical line should die and the cells immediately to the right and the left of the middle cell will become alive.
2.
Preconditions: There is a vertical line of three alive cells on the screen.
Execution: Press the Run Continuous button.
Postconditions: The vertical line of three alive cells should alternate between a horizontal line of alive cells, centered on the middle of the original line, and turn back to the original line of cells.
3.
Preconditions: There are arbitrary numbers of alive cells on the screen.
Execution: Press the Run Continuous button.
Postconditions: The messages “Calculating…” and “Displaying…” are shown repeatedly in the terminal, proving that the program is running continuously as expected.

Results Screenshot: Because I cannot add picture in readme file, please see more screenshot details in the README.pdf.
