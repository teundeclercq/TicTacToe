package nl.fontys.tictactoe.Repositories;

import nl.fontys.tictactoe.Interfaces.GameListInterface;
import nl.fontys.tictactoe.Models.Game;
import nl.fontys.tictactoe.Models.Move;
import nl.fontys.tictactoe.Models.Player;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public class GameListRepository implements GameListInterface {
    ArrayList<Game> games = new ArrayList<>();
    Game game = new Game();
    @Override
    public void addGamesToList(Game game) {
        games.add(game);
    }

    @Override
    public void addPlayerToGame(Player player) {
        game.addPlayerToGame(player);
    }

    @Override
    public Boolean containsTwoPlayers() {
        return game.containsTwoPlayer();
    }

    @Override
    public Boolean makeMove(Move move) {
        return game.makeMove(move);
    }

    @Override
    public ArrayList<Player> getPlayers() {
        return game.getPlayers();
    }

    @Override
    public void deleteGameFromList(String ownerId) {
        games.removeIf(game -> game.owner.getId().equals(ownerId));
    }

    @Override
    public ArrayList<Game> getGames() {
        return games;
    }
}
