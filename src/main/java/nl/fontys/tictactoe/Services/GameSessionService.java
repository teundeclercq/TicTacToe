package nl.fontys.tictactoe.Services;

import nl.fontys.tictactoe.Models.GameSession;
import nl.fontys.tictactoe.Repositories.GameSessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameSessionService {
    @Autowired
    private GameSessionRepository gameSessionRepository;

    public GameSessionService(GameSessionRepository gameSessionRepository) {
        this.gameSessionRepository = gameSessionRepository;
    }
    public List<GameSession> getAllGameSessions() {
        return (List<GameSession>) gameSessionRepository.findAll();
    }
    public void addGameSession(GameSession gameSession) {
        gameSessionRepository.save(gameSession);
    }
    public void updateGameSession(GameSession gameSession) {
        gameSessionRepository.save(gameSession);
    }
    
}
