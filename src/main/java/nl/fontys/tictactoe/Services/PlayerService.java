package nl.fontys.tictactoe.Services;

import nl.fontys.tictactoe.Models.Player;
import nl.fontys.tictactoe.Repositories.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PlayerService {
    @Autowired
    private PlayerRepository playerRepository;

    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    public List<Player> getAllPlayers() {
        return (List<Player>) playerRepository.findAll();
    }

    public Player addPlayer(Player player) {
       return playerRepository.save(player);
    }
    public Player getPlayer(String id) {
        return playerRepository.findById(id).orElse(null);
    }
    public Player updatePlayer(Player player) {
        return playerRepository.save(player);
    }
    public void deletePlayer(String id) {
        playerRepository.deleteById(id);
    }
}
