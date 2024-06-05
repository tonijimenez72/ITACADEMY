/*Buscar la ruta de un archivo:

Dependiendo si ejecutas desde el Run de la clase Main,
o llamas a "java .\Main.java",
el programa se puede  perder esta función lo soluciona:*/

private static final String[] FILE_PATHS = {"backup/src/main/java/n3exercise1/resources/people.csv", "resources/people.csv"};
private String filePath;
setFilePath();

private void setFilePath() {
    for (String path : FILE_PATHS) {
        File file = new File(path);
        if (file.exists()) {
            filePath = path;
            return;
        }
    }
    throw new RuntimeException("No valid file path found.");
}
