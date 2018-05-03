# Project_Gutenberg
Test strategies of an application, that allows to figure out which cities are mentioned in which English books from Project Gutenberg.
## Text To Csv Converter
To run convert all the txt files inside the "[booksfortesting](https://github.com/UsernameDiana/Project_Gutenberg/tree/master/booksfortesting)":
 - Change the location of the "booksfortesting" path in [App.java](https://github.com/UsernameDiana/Project_Gutenberg/blob/master/src/main/java/TestingExamForPlebs/TxtToCsv/App.java) for Reading.
 - Setting a new location to where to store the newly created ".csv" files in [App.java](https://github.com/UsernameDiana/Project_Gutenberg/blob/master/src/main/java/TestingExamForPlebs/TxtToCsv/App.java).
 - You need to run the [App.java](https://github.com/UsernameDiana/Project_Gutenberg/blob/master/src/main/java/TestingExamForPlebs/TxtToCsv/App.java) for Reading and Writing.

## Side notes for Converter
 
 - The code finds all the titles and removes any symbols that exist in the title that the ".csv" format would be correct.
 - The does not split the authors if there are more than one of them, it just puts it as a single author.
 - The cities are all the words that have first capital letter. As we don't really care about the non-city words we can just keep it as is for now. 
 - The form of the generated csv file is:
 ```
 bookid, title,
 0, title1, 
 0, title2,
 0, title3,
 0, title4,
```
