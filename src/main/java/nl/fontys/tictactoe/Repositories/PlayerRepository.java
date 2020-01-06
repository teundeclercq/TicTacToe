package nl.fontys.tictactoe.Repositories;

import nl.fontys.tictactoe.Models.Player;
import org.springframework.data.repository.CrudRepository;

public interface PlayerRepository extends CrudRepository<Player, String> {
}
