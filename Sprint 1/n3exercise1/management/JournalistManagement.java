package n3exercise1.management;

import n3exercise1.journalist.Journalist;

import java.util.ArrayList;

public class JournalistManagement {
    static ArrayList<Journalist> journalists = new ArrayList<>();

    public void createJournalist(){
        addJournalist(InputManagement.inputName(), InputManagement.inputIdCard());
    }

    public void addJournalist(String name, String idCard) {
        Journalist journalist = new Journalist(name, idCard);

        if (checkIdCard(idCard)) {
            System.out.println("DNI " + idCard + " already registered.");
        }else {
            journalists.add(journalist);
            System.out.println("Journalist added: " + journalist.toString());
        }
    }

    public void deleteJournalist() {
        if (hasJournalists()) {
            readJournalists();
            delJournalist(InputManagement.inputIdCard());
        }
    }

    public void readJournalists() {
        if (hasJournalists()) {
            getJournalists();
        }
    }

    public boolean checkIdCard(String idCard) {
        for (Journalist journalist : journalists) {
            if (journalist.getIdCard().equals(idCard)) {
                return true;
            }
        }
        return false;
    }

    public boolean hasJournalists() {
        if (journalists.isEmpty()) {
            System.out.println("There are no journalists registered yet.");
            return false;
        }
        return true;
    }

    private void delJournalist(String idCard) {
        if (checkIdCard(idCard)) {
            journalists.removeIf(journalist -> journalist.getIdCard().equals(idCard));
            System.out.println("Journalist with DNI " + idCard + " has been removed.");
        } else {
            System.out.println( "DNI " + idCard + " is not registered.");
        }
    }

    public void getJournalists() {
        for (Journalist journalist : journalists) {
            System.out.println(journalist);
        }
    }

    public ArrayList<Journalist> getAllJournalists() {
        return journalists;
    }

    public int getJournalistIndex(String idCard) {
        for (int i = 0; i < journalists.size(); i++) {
            if (journalists.get(i).getIdCard().equals(idCard)) {
                return i;
            }
        }
        return -1;
    }

    public Journalist getJournalistIfValid(int index) {
        if (hasJournalists() && index != -1) {
            return JournalistManagement.journalists.get(index);
        } else {
            System.out.println("Invalid journalist or no journalists available.");
            return null;
        }
    }


}