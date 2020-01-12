package nl.fontys.tictactoe.Models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class GameSessionTest {
    GameSession gameSession;
    HashSet<Player> players;
    Player player1;
    Player player2;
    @BeforeEach
    void setUp() {
        player1 = new Player("UdPrf1cFM2XdNtu12", "teundeclercq@gmail.com", true, Button.X, Button.X);
        player2 = new Player("UdPrf1cFM2XdNtu13", "schroenanne@gmail.com", false, Button.O, Button.X);
        players = new HashSet<>();
        players.add(player1);
        players.add(player2);
        gameSession = new GameSession(players, player1.getEmail(), LocalDateTime.now());
    }
    @Test
    void EmptyConstructor() {
        gameSession = new GameSession();
        assertNull(gameSession.getPlayerO());
        assertEquals(0, gameSession.getId());
    }
    @Test
    void SetPlayersConstructor() {
        player1 = new Player("UdPrf1cFM2XdNtu12", "teundeclercq@gmail.com", true, Button.X, Button.X);
        player2 = new Player("UdPrf1cFM2XdNtu13", "schroenanne@gmail.com", false, Button.O, Button.X);
        players = new HashSet<>();
        players.add(player1);
        players.add(player2);
        gameSession = new GameSession(players);

        assertEquals("teundeclercq@gmail.com", gameSession.getPlayerX());
        assertEquals("schroenanne@gmail.com", gameSession.getPlayerO());
    }
    @Test
    void getId() {
        gameSession.setId(1);
        assertEquals(1, gameSession.getId());
    }

    @Test
    void getPlayerO() {
        assertEquals(player2.getEmail(), gameSession.getPlayerO());
    }

    @Test
    void getPlayerX() {
        assertEquals(player1.getEmail(), gameSession.getPlayerX());
    }

    @Test
    void getPlayerWhoWon() {
        assertEquals(player1.getEmail(), gameSession.getPlayerWhoWon());
    }

    @Test
    void getTimePlayed() {
        LocalDateTime time = LocalDateTime.now();
        gameSession = new GameSession(players, player1.getEmail(), time);
        assertEquals(time, gameSession.getTimePlayed());
    }

    @Test
    void setId() {
        gameSession.setId(1);
        assertEquals(1, gameSession.getId());
    }

    @Test
    void setPlayerO() {
        gameSession.setPlayerO(player1.getEmail());
        assertEquals("teundeclercq@gmail.com",gameSession.getPlayerO());
    }

    @Test
    void setPlayerX() {
        gameSession.setPlayerX(player1.getEmail());
        assertEquals("teundeclercq@gmail.com",gameSession.getPlayerX());
    }

    @Test
    void setPlayerWhoWon() {
        gameSession.setPlayerWhoWon(player1.getEmail());
        assertEquals("teundeclercq@gmail.com",gameSession.getPlayerWhoWon());
    }

    @Test
    void setTimePlayed() {
        LocalDateTime time = LocalDateTime.now();
        gameSession.setTimePlayed(time);
        assertEquals(time, gameSession.getTimePlayed());
    }
}