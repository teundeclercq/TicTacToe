package nl.fontys.tictactoe.Services;

import nl.fontys.tictactoe.Repositories.HighscoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HigheScoreService {
    @Autowired
    private HighscoreRepository highscoreRepository;

    public HigheScoreService(HighscoreRepository highscoreRepository) {
        this.highscoreRepository = highscoreRepository;
    }
}
