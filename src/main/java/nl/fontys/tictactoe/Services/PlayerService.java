package nl.fontys.tictactoe.Services;

import nl.fontys.tictactoe.Repositories.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class PlayerService {
    @Autowired
    private PlayerRepository playerRepository;

    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }
}
