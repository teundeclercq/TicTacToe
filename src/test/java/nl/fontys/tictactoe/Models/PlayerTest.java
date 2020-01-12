package nl.fontys.tictactoe.Models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class PlayerTest {
    Player player;
    @BeforeEach
    void setUp() {
        player = new Player("UdPrf1cFM2XdNtu12", "teundeclercq@gmail.com", true, Button.X, Button.X);
    }

    @Test
    void getId() {
        String id = "UdPrf1cFM2XdNtu12";
        assertEquals(id, player.getId());
    }
    @Test
    void emptyConstructor() {
        player = new Player();
        assertNull(player.getId());
        assertNull(player.getPlayerFiguur());
    }
    @Test
    void constructorWithIdEmailCanMove() {
        player = new Player("UdPrf1cFM2XdNtu12", "teundeclercq@gmail.com", true);
        assertNull(player.getPlayerTurn());
        assertNull(player.getPlayerFiguur());
    }
    @Test
    void getEmail() {
        String email = "teundeclercq@gmail.com";
        assertEquals(email, player.getEmail());
    }

    @Test
    void getCanMove() {
        assertEquals(true, player.getCanMove());
    }

    @Test
    void getPlayerFiguur() {
        assertEquals(Button.X, player.getPlayerFiguur());
    }

    @Test
    void getPlayerTurn() {
        assertEquals(Button.X, player.getPlayerFiguur());
    }

    @Test
    void setId() {
        player.setId("IUY");
        assertEquals("IUY", player.getId());
    }

    @Test
    void setEmail() {
        player.setEmail("anneschroen@gmail.com");
        assertEquals("anneschroen@gmail.com", player.getEmail());
    }

    @Test
    void setCanMove() {
        player.setCanMove(false);
        assertEquals(false, player.getCanMove());
    }

    @Test
    void setPlayerFiguur() {
        player.setPlayerFiguur(Button.O);
        assertEquals(Button.O, player.getPlayerFiguur());
    }

    @Test
    void setPlayerTurn() {
        player.setPlayerTurn(Button.O);
        assertEquals(Button.O, player.getPlayerTurn());
    }
}