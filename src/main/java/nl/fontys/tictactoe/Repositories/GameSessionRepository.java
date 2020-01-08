package nl.fontys.tictactoe.Repositories;

import nl.fontys.tictactoe.Models.GameSession;
import org.springframework.data.repository.CrudRepository;

public interface GameSessionRepository extends CrudRepository<GameSession, Integer> {

}
