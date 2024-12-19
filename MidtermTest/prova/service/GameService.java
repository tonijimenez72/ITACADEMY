package prova.service;

import prova.entity.*;

import java.util.*;
        import java.util.stream.Collectors;

public class GameService {
    private final Map<String, Game> inventory = new HashMap<>();
    private static final double IVA_RATE = 0.10;

    public void addGame(Game game) {
        if (inventory.containsKey(game.getId())) {
            throw new IllegalArgumentException("Game with this ID already exists in the inventory.");
        }
        inventory.put(game.getId(), game);
    }

    public void updateQuantity(String gameId, int quantity) {
        Game game = inventory.get(gameId);
        if (game == null) {
            throw new NoSuchElementException("Game not found in the inventory.");
        }
        game.updateInventory(quantity);
    }

    public List<String> getAllGames() {
        return inventory.values().stream()
                .map(game -> game.getName())
                .collect(Collectors.toList());
    }

    public List<String> getAllGamesWithPrices() {
        return inventory.values().stream()
                .map(game -> String.format("%s - Price with IVA: %.2f",
                        game.getName(), game.getPriceWithTax()))
                .collect(Collectors.toList());
    }

    public List<Game> filterGamesByName(String name) {
        return inventory.values().stream()
                .filter(game -> game.getName().equalsIgnoreCase(name))
                .collect(Collectors.toList());
    }

    public List<Game> filterGamesByCategory(String category) {
        return inventory.values().stream()
                .filter(game -> game.getCategory().equalsIgnoreCase(category))
                .collect(Collectors.toList());
    }

    public List<Game> filterGamesByDifficulty(int difficulty) {
        return inventory.values().stream()
                .filter(game -> game.getDifficulty() == difficulty)
                .collect(Collectors.toList());
    }

    public void removeGame(String name) {
        inventory.remove(name);
    }
}

