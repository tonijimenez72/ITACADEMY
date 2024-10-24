package n3exercise1;

public class Generics {
    public <T extends Phone> void telefonMethod(T telefon) {
        telefon.call();
    }

    public void smartphoneMethod(Smartphone smartphone) {
        smartphone.takePhotos();
    }
}
