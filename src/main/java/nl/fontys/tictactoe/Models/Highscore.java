package nl.fontys.tictactoe.Models;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "highscore")
public class Highscore {
    @Id
    @Column(name = "highscore_id")
    private int id;
    @OneToMany(mappedBy = "highscore")
    private Set<GameSession> gamesessions;
    public Highscore() {
    }
}
