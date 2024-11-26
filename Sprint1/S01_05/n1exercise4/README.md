## User Manual - Package n1exercise4
You can run the package from the IDE or from Terminal. In case of Terminal is mandatory follow the Compilation guide. 

### Compilation (if necessary).
To compile this package, follow these steps:

1. Open a terminal.

2. Navigate to the directory where the source code of the package (n1exercise3) is located.

3. Run the following command to compile the package:

`javac *.java`

### Usage

#### Execution without arguments: 
If you run the program without providing arguments, it will prompt you to enter a valid parameter and a valid path. 
This will happen if you execute from directly from IDE, or just execute from Terminal without a paramater:

`java Main.java`

You will be asked to assign an argument, -ls or -rf, and path to continue with the test.
* -ls, save directory listing to a file.
* -rf, read file content.

#### Execution with argument:

You can also provide the parameter and the path as an argument when running the program.

`java main.java - parameter /path/to/directory`

Example: `java Main.java -ls C:\Test`
Example: `java Main.java -rd C:\Test\One.txt`

#### Results
The program brings two options:

With the parameter -ls will save the ls.txt file in the folder Logs, located in the Documents folder of the user. with a recursive list of the contents of the specified directory, 
including files and subdirectories, formatted for better readability.

With the parameter -rf will show the content of the selected file.