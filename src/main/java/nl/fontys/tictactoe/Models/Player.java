package nl.fontys.tictactoe.Models;

import javax.persistence.*;

@Entity
@Table(name = "player")
public class Player {
    @Id
    private String id;
    private String email;
    private Boolean canMove;
    private Button playerFiguur;
    private Button playerTurn;
    @ManyToOne
    @JoinColumn(name = "gamesession_id")
    private GameSession gamesession;
    public Player() {}
    public Player(String id, String email, Boolean canMove) {
        this.id = id;
        this.email = email;
        this.canMove = canMove;
    }
    public Player(String id, String email, Boolean canMove, Button playerFiguur, Button playerTurn) {
        this.id = id;
        this.email = email;
        this.canMove = canMove;
        this.playerFiguur = playerFiguur;
        this.playerTurn = playerTurn;
    }

    /**
     * Getter for property 'id'.
     *
     * @return Value for property 'id'.
     */
    public String getId() {
        return id;
    }

    /**
     * Setter for property 'id'.
     *
     * @param id Value to set for property 'id'.
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Getter for property 'email'.
     *
     * @return Value for property 'email'.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Setter for property 'email'.
     *
     * @param email Value to set for property 'email'.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Getter for property 'canMove'.
     *
     * @return Value for property 'canMove'.
     */
    public Boolean getCanMove() {
        return canMove;
    }

    /**
     * Setter for property 'canMove'.
     *
     * @param canMove Value to set for property 'canMove'.
     */
    public void setCanMove(Boolean canMove) {
        this.canMove = canMove;
    }

    /**
     * Getter for property 'playerFiguur'.
     *
     * @return Value for property 'playerFiguur'.
     */
    public Button getPlayerFiguur() {
        return playerFiguur;
    }

    /**
     * Setter for property 'playerFiguur'.
     *
     * @param playerFiguur Value to set for property 'playerFiguur'.
     */
    public void setPlayerFiguur(Button playerFiguur) {
        this.playerFiguur = playerFiguur;
    }

    /**
     * Getter for property 'playerTurn'.
     *
     * @return Value for property 'playerTurn'.
     */
    public Button getPlayerTurn() {
        return playerTurn;
    }

    /**
     * Setter for property 'playerTurn'.
     *
     * @param playerTurn Value to set for property 'playerTurn'.
     */
    public void setPlayerTurn(Button playerTurn) {
        this.playerTurn = playerTurn;
    }
}
