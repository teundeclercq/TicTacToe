package nl.fontys.tictactoe.Repositories;

import nl.fontys.tictactoe.Models.GameSession;
import nl.fontys.tictactoe.Models.Player;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Objects;

@Repository
public interface PlayerRepository extends CrudRepository<Player, String> {
}
