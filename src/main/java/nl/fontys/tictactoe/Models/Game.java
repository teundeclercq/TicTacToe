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
    ArrayList<Player> players = new ArrayList<>();
    Button[] buttons = new Button[9];
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
