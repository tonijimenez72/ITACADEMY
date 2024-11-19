package n3exercise1.management;

import n3exercise1.journalist.Journalist;
import n3exercise1.news.News;

import java.util.ArrayList;

public class InfoManagement {
    static JournalistManagement journalistManagement = new JournalistManagement();

    private static ArrayList<News> allNewsArray() {
        ArrayList<News> allNewsArray = new ArrayList<>();

        for (Journalist journalist : journalistManagement.getAllJournalists()) {
            allNewsArray.addAll(journalist.getNewsByJournalist());
        }

        return allNewsArray;
    }

    public static void getAllNews() {
        ArrayList<News> allNews = allNewsArray();

        for (News news : allNews) {
            System.out.println(news + "\n");
        }
    }

    public static void getNewsPrice() {
        ArrayList<News> allNews = allNewsArray();

        for (News news : allNews) {
            System.out.println(news + "Price: " + news.calculatePrice() + "\n");
        }
    }

    public static void getNewsScore() {
        ArrayList<News> allNews = allNewsArray();

        for (News news : allNews) {
            System.out.println(news + "Score: " + news.calculateScore() + "\n");
        }
    }

    public static void getNewsByJournalist() {
        if (!journalistManagement.hasJournalists()) {
            System.out.println("No journalists available.");
            return;
        }

        String idCard = InputManagement.inputIdCard();
        int index = journalistManagement.getJournalistIndex(idCard);

        showNews(journalistManagement.getAllJournalists().get(index));
    }

    private static void showNews(Journalist journalist) {
        ArrayList<News> newsList = journalist.getNewsByJournalist();

        if (newsList.isEmpty()) {
            System.out.println("No news found for journalist " + journalist.getName() + ".");
            return;
        }

        System.out.println("News by journalist " + journalist.getName() + ":\n");
        newsList.forEach(System.out::println);
    }

}