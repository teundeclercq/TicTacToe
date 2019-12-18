package nl.fontys.tictactoe.Models;

public class Move {
    private int id;
    private Player player;

    public Move(int id, Player player) {
        this.id = id;
        this.player = player;
    }

    /**
     * Getter for property 'id'.
     *
     * @return Value for property 'id'.
     */
    public int getId() {
        return id;
    }

    /**
     * Getter for property 'button'.
     *
     * @return Value for property 'button'.
     */
    public Player getPlayer() {
        return player;
    }
}
