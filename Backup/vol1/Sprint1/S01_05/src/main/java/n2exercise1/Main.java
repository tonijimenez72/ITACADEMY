package n2exercise1;

public class Main {
    public static void main(String[] args) {
        WriteLog.writeLog(ReadProperties.readProperties("readPath"));
    }
}