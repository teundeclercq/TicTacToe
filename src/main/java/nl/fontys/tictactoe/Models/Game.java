package nl.fontys.tictactoe.Models;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Game {
    public int id;
    public String name;
    public String description;
    public String imagePath;
    public Player owner;
    private ArrayList<Player> players = new ArrayList<>();
    private Button[] buttons = new Button[9];
    private int buttonX = 0;
    private int buttonO = 0;
    public Game(int id, String name,String imagePath, String description, Player owner) {
        this.id = id;
        this.name = name;
        this.imagePath = imagePath;
        this.description = description;
        this.owner = owner;
    }
    public Game() {
    }
    public void addPlayerToGame(Player player) {
        players.add(player);
    }
    public Boolean makeMove(Move move) {
        if (buttons[move.getId()] == null) {
            buttons[move.getId()] = move.getPlayer().getPlayerFiguur();
            return true;
        } else {
            return false;
        }
    }
    public Button calculateWinner() {
        int [][] lines = {
                {0,1,2},
                {3,4,5},
                {6,7,8},
                {0,3,6},
                {1,4,7},
                {2,5,8},
                {0,4,8},
                {2,4,6}
        };
        for (int i = 0; i < lines.length; i++) {
            for (int j= 0; j < lines[i].length; j++) {
                if (buttons[lines[i][j]] == Button.X) {
                    buttonX++;
                }
                if (buttons[lines[i][j]] == Button.O) {
                    buttonO++;
                }
            }
            if (buttonX == 3) {
                return Button.X;
            }
            if (buttonO == 3) {
                return Button.O;
            }
            buttonO = 0;
            buttonX = 0;
        }
        return null;
    }
    public void removePlayer(String uid) {
        players.forEach((item) -> {
            if (!item.getId().equals(uid)) {
                players.remove(item);
            }
        });
    }
    public ArrayList<Player> getPlayers() { return players; }
    public Boolean containsTwoPlayer() {
        return players.size() == 2;
    }
}
