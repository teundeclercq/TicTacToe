package nl.fontys.tictactoe.Models;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MoveTest {
    Move move;
    Player player;
    @BeforeEach
    void setUp() {
        player = new Player("UdPrf1cFM2XdNtu12", "teundeclercq@gmail.com");
        move = new Move(2, player);
    }

    @Test
    void getId() {
        int moveId = 2;
        assertEquals(moveId, move.getId());
    }

    @Test
    void getPlayer() {
        assertEquals(player, move.getPlayer());
    }
}