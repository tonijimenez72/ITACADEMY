## User Manual - Package n1exercise5
You can run the package from the IDE or from Terminal. In case of Terminal is mandatory follow the Compilation guide. 

### Compilation (if necessary).
To compile this package, follow these steps:

1. Open a terminal.

2. Navigate to the directory where the source code of the package (n1exercise5) is located.

3. Run the following command to compile the package: `javac *.java`

### Usage

#### Execution without arguments: 
If you run the program without providing arguments, it will prompt you to enter a valid path. 
This will happen if you execute from directly from IDE, or just execute from Terminal without a paramater: 

`java Main.java`

You will be asked to assign a path to continue with the test.

#### Execution with argument:

You can also provide the path as an argument when running the program.

`java main.java /path/to/directory`

Example: `java Main.java C:\Temp`

#### Results 
The program will save a n1exercise5.txt in the folder resources of the package, with a recursive list of the contents of the specified directory, 
including files and subdirectories, formatted for better readability, also the n1exercise3.txt will be printed on the screen.

The program creates a person.ser in the resources path with info (name, surname) of an object. Then the file will be deserialized printing the info in the .ser file.