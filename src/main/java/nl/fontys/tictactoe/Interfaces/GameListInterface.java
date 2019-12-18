package nl.fontys.tictactoe.Interfaces;

import nl.fontys.tictactoe.Models.Button;
import nl.fontys.tictactoe.Models.Game;
import nl.fontys.tictactoe.Models.Move;
import nl.fontys.tictactoe.Models.Player;

import java.util.ArrayList;

public interface GameListInterface {
    public void addGamesToList(Game game);
    public void addPlayerToGame(Player player);
    public Boolean containsTwoPlayers();
    public Boolean makeMove(Move move);
    public ArrayList<Player> getPlayers();
    public void deleteGameFromList(String ownerId);
    public ArrayList<Game> getGames();
}
