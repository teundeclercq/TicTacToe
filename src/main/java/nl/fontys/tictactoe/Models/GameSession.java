package nl.fontys.tictactoe.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
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
    @Column(name = "playerO")
    private String playerO;
    @Column(name = "playerX")
    private String playerX;
    @Column(name = "playerWhoWon")
    private String playerWhoWon;
    @Column(name = "TimePlayed")
    private LocalDateTime timePlayed;
    public GameSession(Set<Player> players, String playerWhoWon, LocalDateTime currentTime) {
        if (players.size() == 2) {
            players.forEach((item) -> {
                if (item.getPlayerFiguur() == Button.X) {
                    this.playerX = item.getEmail();
                }
                if (item.getPlayerFiguur() == Button.O) {
                    this.playerO = item.getEmail();
                }
            });
            this.timePlayed = currentTime;
            this.playerWhoWon = playerWhoWon;
        }
    }
    public GameSession(Set<Player> players) {
        if (players.size() == 2) {
            players.forEach((item) -> {
                if (item.getPlayerFiguur() == Button.X) {
                    this.playerX = item.getEmail();
                }
                if (item.getPlayerFiguur() == Button.O) {
                    this.playerO = item.getEmail();
                }
            });
        }
    }
    public GameSession() {

    }
}
