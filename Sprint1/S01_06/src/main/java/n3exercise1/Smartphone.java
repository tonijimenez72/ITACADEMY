package n3exercise1;

public class Smartphone implements Phone{
    @Override
    public void call() {
        System.out.println("Calling from the Smartphone.");
    }

    public void takePhotos() {
        System.out.println("Taking photos with the Smartphone.");
    }

}
