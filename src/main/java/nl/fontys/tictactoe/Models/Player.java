package nl.fontys.tictactoe.Models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "player")
@Getter
@Setter
public class Player {
    @Id
    @Column(name = "player_id")
    private String id;
    @Column(name = "email")
    private String email;
    @Column(name = "canMove")
    private Boolean canMove;
    @Column(name = "playerFiguur")
    private Button playerFiguur;
    @Column(name = "playerTurn")
    private Button playerTurn;
    @ManyToMany(mappedBy = "players")
    private Set<GameSession> gameSessions;
    public Player() {}
    public Player(String id, String email) {
        this.id = id;
        this.email = email;
    }
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
}
