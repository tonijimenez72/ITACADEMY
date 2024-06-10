## User Manual - Package n2exercise1
You can run the package from the IDE or from Terminal. In case of Terminal is mandatory follow the Compilation guide. 

### Compilation (if necessary).
To compile this package, follow these steps:

1. Open a terminal.

2. Navigate to the directory where the source code of the package (n2exercise1) is located.

3. Run the following command to compile the package:

`javac *.java`

### Usage

#### Execution without arguments: 
The arguments are provided in the resources/configuration.properties file.

`java Main.java`

In case of fail reading the properties file, you will be asked to assign a path to continue with the test.

#### Results
The program will save a file, with the assigned name in the properties file, in the folder resources of the package, with a recursive list of the contents of the specified directory, 
including files and subdirectories, formatted for better readability.