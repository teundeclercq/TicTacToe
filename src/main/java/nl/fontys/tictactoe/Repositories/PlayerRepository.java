package nl.fontys.tictactoe.Repositories;

import nl.fontys.tictactoe.Models.Player;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface PlayerRepository extends CrudRepository<Player, String> {
}
