package prova;

import prova.entity.ChanceGame;
import prova.entity.Game;
import prova.entity.RolGame;
import prova.entity.StrategyGame;
import prova.service.GameService;

public class Main {
    public static void main(String[] args) {

        GameService gameService = new GameService();


        gameService.addGame(new RolGame("rol1", "Rol 1", 3, 20.00, 1));

        gameService.addGame(new RolGame("rol2", "Rol 2", 6, 20.00, 1));

        gameService.addGame(new ChanceGame("chance1", "Chance 1", 6, 10.00, 1));

        gameService.addGame(new StrategyGame("strategy1", "Strategy 1", 6, 10.00, 1));

        System.out.println("\nPrinting all games after add:" +
                "\n" + gameService.getAllGamesWithPrices());

        System.out.println("\nPrinting by name:" +
                "\n" + gameService.filterGamesByName("Rol 1"));

        System.out.println("\nPrinting by category:" +
                "\n" + gameService.filterGamesByCategory("Rol"));

        System.out.println("\nPrinting by difficulty:" +
                "\n" + gameService.filterGamesByDifficulty(6));

        gameService.removeGame("rol2");

        System.out.println("\nPrinting all games after remove:" +
                "\n" + gameService.getAllGamesWithPrices());


    }
}