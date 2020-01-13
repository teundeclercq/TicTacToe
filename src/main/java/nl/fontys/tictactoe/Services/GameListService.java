package nl.fontys.tictactoe.Services;

import nl.fontys.tictactoe.Interfaces.GameListInterface;
import nl.fontys.tictactoe.Models.Button;
import nl.fontys.tictactoe.Models.Game;
import nl.fontys.tictactoe.Models.Move;
import nl.fontys.tictactoe.Models.Player;
import nl.fontys.tictactoe.Repositories.GameListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
@Service
public class GameListService implements GameListInterface {
    @Autowired
    private GameListRepository gameListRepository;


    @Override
    public void addGamesToList(Game game) {
        gameListRepository.addGamesToList(game);
    }

    @Override
    public void addPlayerToGame(Player player) {
        gameListRepository.addPlayerToGame(player);
    }

    @Override
    public void removePlayerFromGame(String uid) { gameListRepository.removePlayerFromGame(uid); }

    @Override
    public Boolean containsTwoPlayers() {
        return gameListRepository.containsTwoPlayers();
    }

    @Override
    public Boolean makeMove(Move move) {
        return gameListRepository.makeMove(move);
    }

    @Override
    public ArrayList<Player> getPlayers() {
        return gameListRepository.getPlayers();
    }

    @Override
    public void deleteGameFromList(String ownerId) {
        gameListRepository.deleteGameFromList(ownerId);
    }

    @Override
    public ArrayList<Game> getGames() {
        return gameListRepository.getGames();
    }

    @Override
    public Button calculateWinner() {
        return gameListRepository.calculateWinner();
    }
}
