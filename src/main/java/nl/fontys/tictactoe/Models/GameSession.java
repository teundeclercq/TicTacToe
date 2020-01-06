package nl.fontys.tictactoe.Models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Set;

@Entity
@Table(name = "gamesession")
public class GameSession {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "gamesession_id")
    private int id;
    @OneToMany(mappedBy = "gamesession")
    private Set<Player> players;
    @ManyToOne
    @JoinColumn(name = "highscore_id")
    private Highscore highscore;
    public GameSession(int id, Set<Player> players) {
        this.id = id;
        this.players = players;
    }
    public GameSession() {

    }
}
