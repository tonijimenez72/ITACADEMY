package n3exercise1.management;

import n3exercise1.journalist.Journalist;
import n3exercise1.news.News;
import n3exercise1.sports.*;

import java.util.ArrayList;

public class NewsManagement {


    JournalistManagement journalistManagement = new JournalistManagement();

    public void assignBasketNews() {
        addBasketNews(
                InputManagement.inputIdCard(),
                InputManagement.inputHeadline(),
                InputManagement.inputBody(),
                InputManagement.inputCompetition(),
                InputManagement.inputTeam()
        );
    }

    public void assignF1News() {
        addF1News(
                InputManagement.inputIdCard(),
                InputManagement.inputHeadline(),
                InputManagement.inputBody(),
                InputManagement.inputTeam()
        );
    }

    public void assignMotoNews() {
        addF1News(
                InputManagement.inputIdCard(),
                InputManagement.inputHeadline(),
                InputManagement.inputBody(),
                InputManagement.inputTeam()
        );
    }

    public void assignSoccerNews() {
        addSoccerNews(
                InputManagement.inputIdCard(),
                InputManagement.inputHeadline(),
                InputManagement.inputBody(),
                InputManagement.inputCompetition(),
                InputManagement.inputTeam(),
                InputManagement.inputPlayer()
        );
    }

    public void assignTennisNews() {
        addTennisNews(
                InputManagement.inputIdCard(),
                InputManagement.inputHeadline(),
                InputManagement.inputBody(),
                InputManagement.inputCompetition(),
                InputManagement.inputPlayer()
        );
    }

    public void addBasketNews(String idCard, String headline, String body, String competition, String team) {
        int index = journalistManagement.getJournalistIndex(idCard);

        Journalist journalist = journalistManagement.getJournalistIfValid(index);

        if (journalist != null) {
            Basket basket = new Basket(journalist, headline, body, competition, team);
            journalist.getNewsByJournalist().add(basket);

            System.out.println(headline + " assigned to " + journalist.getName() + "'s News.\n");
        }
    }

    public void addF1News(String idCard, String headline, String body, String team) {
        int index = journalistManagement.getJournalistIndex(idCard);

        Journalist journalist = journalistManagement.getJournalistIfValid(index);

        if (journalist != null) {
            F1 f1 = new F1(journalist, headline, body, team);
            journalist.getNewsByJournalist().add(f1);

            System.out.println(headline + " assigned to " + journalist.getName() + "'s News.\n");
        }
    }

    public void addMotoNews(String idCard, String headline, String body, String team) {
        int index = journalistManagement.getJournalistIndex(idCard);

        Journalist journalist = journalistManagement.getJournalistIfValid(index);

        if (journalist != null) {
            Moto moto = new Moto(journalist, headline, body, team);
            journalist.getNewsByJournalist().add(moto);

            System.out.println(headline + " assigned to " + journalist.getName() + "'s News.\n");
        }
    }

    public void addSoccerNews(String idCard, String headline, String body, String competition, String team, String player) {
        int index = journalistManagement.getJournalistIndex(idCard);

        Journalist journalist = journalistManagement.getJournalistIfValid(index);

        if (journalist != null) {
            Soccer soccer = new Soccer(journalist, headline, body, competition, team, player);
            journalist.getNewsByJournalist().add(soccer);

            System.out.println(headline + " assigned to " + journalist.getName() + "'s News.\n");
        }
    }

    public void addTennisNews(String idCard, String headline, String body, String competition, String player) {
        int index = journalistManagement.getJournalistIndex(idCard);

        Journalist journalist = journalistManagement.getJournalistIfValid(index);

        if (journalist != null) {

            Tennis tennis = new Tennis(journalist, headline, body, competition, player);
            journalist.getNewsByJournalist().add(tennis);

            System.out.println(headline + " assigned to " + journalist.getName() + "'s News.\n");
        }
    }

    public static void deleteNewsByJournalist() {
        JournalistManagement journalistManagement = new JournalistManagement();
        String idCard = InputManagement.inputIdCard();

        int index = journalistManagement.getJournalistIndex(idCard);

        Journalist journalist = journalistManagement.getJournalistIfValid(index);

        if (journalist == null) {
            return;
        }

        String headline = InputManagement.inputHeadline();
        ArrayList<News> newsList = journalist.getNewsByJournalist();

        newsListIsEmpty(newsList, journalist);

        News newsToDelete = findNewsByHeadline(newsList, headline);

        if (newsToDelete == null) {
            System.out.println("No news found with headline: " + headline + ".");
            return;
        }

        deleteNews(newsList, newsToDelete, journalist);
    }


    private static News findNewsByHeadline(ArrayList<News> newsList, String headline) {
        for (News news : newsList) {
            if (news.getHeadline().equals(headline)) {
                return news;
            }
        }
        return null;
    }

    private static void deleteNews(ArrayList<News> newsList, News newsToDelete, Journalist journalist) {
        if (newsToDelete == null) {
            System.out.println("No news found with the given headline.");
        } else {
            newsList.remove(newsToDelete);

            System.out.println(newsToDelete.getHeadline() + " has been deleted. Written by " + journalist.getName());
        }
    }

    public static void newsListIsEmpty(ArrayList<News> newsList, Journalist journalist) {
        if (newsList.isEmpty()) {
            System.out.println("No news found for journalist " + journalist.getName() + ".");
        }
    }

}