package nl.fontys.tictactoe.Repositories;

import nl.fontys.tictactoe.Models.Player;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PlayerRepository extends CrudRepository<Player, String> {
}
