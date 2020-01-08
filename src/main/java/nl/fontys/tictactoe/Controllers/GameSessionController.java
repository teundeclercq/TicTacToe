package nl.fontys.tictactoe.Controllers;

import nl.fontys.tictactoe.Models.GameSession;
import nl.fontys.tictactoe.Services.GameSessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/gamesessions")
public class GameSessionController {
    private static final Logger logger = Logger.getLogger(GameSessionController.class.getName());
    private static String exceptionMsg = "Exception";
    private static String status = "Status";
    @Autowired
    private GameSessionService gameSessionService;

    @GetMapping("/")
    public List<GameSession> getAllGameSessions() {
        return gameSessionService.getAllGameSessions();
    }
}
