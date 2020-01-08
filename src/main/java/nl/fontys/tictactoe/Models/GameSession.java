package nl.fontys.tictactoe.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "gamesession")
@Getter
@Setter
public class GameSession implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "gamesession_id")
    private int id;
    @JsonIgnore
    @ManyToMany
    @JoinTable(name = "Player_GameSession",
                joinColumns = @JoinColumn(name = "gamesession_id"),
                inverseJoinColumns = @JoinColumn(name = "player_id"))
    private Set<Player> players;
    @Column(name = "playerWhoWon")
    private String playerWhoWon;
    public GameSession(Set<Player> players, String playerWhoWon) {
        if (players.size() == 2) {
            this.players = players;
            this.playerWhoWon = playerWhoWon;
        }
    }
    public GameSession(Set<Player> players) {
        if (players.size() == 2) {
            this.players = players;
        }
    }
    public GameSession() {

    }
}
