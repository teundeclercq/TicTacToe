package nl.fontys.tictactoe.Repositories;

import nl.fontys.tictactoe.Models.Highscore;
import org.springframework.data.repository.CrudRepository;

public interface HighscoreRepository extends CrudRepository<Highscore, Integer> {
}
