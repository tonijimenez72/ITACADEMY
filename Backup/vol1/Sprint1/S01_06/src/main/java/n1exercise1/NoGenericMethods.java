package n1exercise1;

public class NoGenericMethods {
    private String ready;
    private String steady;
    private String go;

    public NoGenericMethods( String ready,  String steady, String go) {
        this.ready = ready;
        this.steady = steady;
        this.go = go;
    }

    public String getReady() {
        return ready;
    }

    public String getSteady() {
        return steady;
    }

    public String getGo() {
        return go;
    }
}