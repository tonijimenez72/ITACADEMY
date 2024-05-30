package n3exercice1;

public class PopulateTest {
    public static void populate() {
        IOMenuMethods ioMenuMethods = new IOMenuMethods();

        ioMenuMethods.addJournalist("Lois Lane", "111111111L");
        ioMenuMethods.addJournalist("Clark Kent", "55555555S");

        ioMenuMethods.assignSoccerNews(1, "headline", "competition", "team", "player");
        ioMenuMethods.assignSoccerNews(1, "Metropolis lo peta", "Champions League", "Real Madrid", "Benzema");

        ioMenuMethods.assignSoccerNews(2, "Metropolis nunca pierde", "Champions League", "Real Madrid", "Benzema");
        ioMenuMethods.assignSoccerNews(2, "headline2", "competition", "team", "player");

        ioMenuMethods.assignBasketballNews(2, "Metropolis nunca pierde", "ACB", "Real Madrid");
        ioMenuMethods.assignBasketballNews(2, "Metropolis lo peta", "Euroleague", "FC Barcelona");
        ioMenuMethods.assignBasketballNews(2, "Metropolis pierde su primer partido contra el instituto de Beacontown ", "Euroleague", "Beacontown");

        ioMenuMethods.assignTennisNews(2, "Set y partido para Lex Luthor", "Nadal");
        ioMenuMethods.assignTennisNews(2, "Imparable", "Federer");
        ioMenuMethods.assignTennisNews(2, "Se muda a Metropolis", "Djokovic");

        ioMenuMethods.assignF1News(2, "Sono rimasto senza benzina!", "Ferrari");
        ioMenuMethods.assignF1News(2, "Accidente sin víctimas en el circuito de Metropolis", "Mercedes");
        ioMenuMethods.assignF1News(2, "Ganador sorprendente  en el Grand Prix de Metropolis", "Seat");

        ioMenuMethods.assignF1News(2, "Penúltima vuelta en Metropolis", "Honda");
        ioMenuMethods.assignF1News(2, "¡Triunfal llegada a meta!", "Yahama");
    }
}