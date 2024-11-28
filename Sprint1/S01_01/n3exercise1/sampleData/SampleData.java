package n3exercise1.sampleData;

import n3exercise1.management.JournalistManagement;
import n3exercise1.management.NewsManagement;

public class SampleData {
    JournalistManagement journalistManagement = new JournalistManagement();
    NewsManagement newsManagement = new NewsManagement();

    public void run() {
        journalistManagement.addJournalist("Lois Lane", "11111111L");
        journalistManagement.addJournalist("Clark Kent", "55555555S");


        newsManagement.addBasketNews("11111111L", "headline 1", "body 1", "EuroBasket", "FC Barcelona");
        newsManagement.addBasketNews("11111111L", "headline 2", "body 2", "", "");
        newsManagement.addSoccerNews("55555555S", "headline 3", "body 3", "Champions League", "FC Barcelona", "Benzema");
    }
}