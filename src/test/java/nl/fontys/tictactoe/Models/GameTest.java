package nl.fontys.tictactoe.Models;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class GameTest {
    Game game;

    @BeforeEach
    void setUp() {
        game = new Game();
    }

    @Test
    void addPlayerToGame() {
        Player player1 = new Player("UdPrf1cFM2XdNtu12", "teundeclercq@gmail.com");
        game.addPlayerToGame(player1);
        assertEquals(game.getPlayers().size(), 1);
        assertTrue(game.getPlayers().contains(player1));
    }

    @Test
    void makeMove() {
        Move move = new Move(2, new Player("UdPrf1cFM2XdNtu12", "teundeclercq@gmail.com"));
        Move moveFalse = new Move(10, new Player("UdPrf1cFM2XdNtu12", "teundeclercq@gmail.com"));
        assertEquals(true, game.makeMove(move));
        assertThrows(ArrayIndexOutOfBoundsException.class, () ->game.makeMove(moveFalse));
    }

    @Test
    void calculateWinnerReturnsX() {
        Move move1 = new Move(0, new Player("UdPrf1cFM2XdNtu12", "teundeclercq@gmail.com", true, Button.X, Button.X));
        Move move2 = new Move(1, new Player("UdPrf1cFM2XdNtu12", "teundeclercq@gmail.com", true, Button.X, Button.X));
        Move move3 = new Move(2, new Player("UdPrf1cFM2XdNtu12", "teundeclercq@gmail.com", true, Button.X, Button.X));
        game.makeMove(move1);
        game.makeMove(move2);
        game.makeMove(move3);
        assertEquals(Button.X ,game.calculateWinner());
    }
    @Test
    void calculateWinnerRetursNull() {
        Move move1 = new Move(0, new Player("UdPrf1cFM2XdNtu12", "teundeclercq@gmail.com"));
        Move move2 = new Move(1, new Player("UdPrf1cFM2XdNtu12", "teundeclercq@gmail.com"));
        Move move3 = new Move(2, new Player("UdPrf1cFM2XdNtu12", "teundeclercq@gmail.com"));
        game.makeMove(move1);
        game.makeMove(move2);
        game.makeMove(move3);
        assertNull(game.calculateWinner());
    }
    @Test
    void removePlayer() {
        Player player1 = new Player("UdPrf1cFM2XdNtu12", "teundeclercq@gmail.com");
        Player player2 = new Player("UdPrf1cFM2Xd2", "teundeclercq@hotmail.com");
        game.addPlayerToGame(player1);
        game.addPlayerToGame(player2);
        assertEquals(2, game.getPlayers().size());
        game.removePlayer("UdPrf1cFM2Xd2");
        assertEquals(1, game.getPlayers().size());
        assertTrue(game.getPlayers().contains(player1));
    }

    @Test
    void getPlayers() {
        Player player1 = new Player("UdPrf1cFM2XdNtu12", "teundeclercq@gmail.com");
        Player player2 = new Player("UdPrf1cFM2Xd2", "teundeclercq@hotmail.com");
        game.addPlayerToGame(player1);
        game.addPlayerToGame(player2);
        assertEquals(2, game.getPlayers().size());
        assertTrue(game.getPlayers().contains(player1));
        assertTrue(game.getPlayers().contains(player2));
    }

    @Test
    void containsTwoPlayer() {
        Player player1 = new Player("UdPrf1cFM2XdNtu12", "teundeclercq@gmail.com");
        Player player2 = new Player("UdPrf1cFM2Xd2", "teundeclercq@hotmail.com");
        game.addPlayerToGame(player1);
        game.addPlayerToGame(player2);
        assertTrue(game.containsTwoPlayer());
    }
}