package nl.fontys.tictactoe.Controllers;

import nl.fontys.tictactoe.Models.Button;
import nl.fontys.tictactoe.Models.Game;
import nl.fontys.tictactoe.Models.Move;
import nl.fontys.tictactoe.Models.Player;
import nl.fontys.tictactoe.Services.GameListService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.annotation.SendToUser;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.logging.Logger;

@Controller
public class GameListController {
    private final static Logger LOGGER = Logger.getLogger(GameListController.class.getName());
    @Autowired
    SimpMessagingTemplate temp;
    @Autowired
    private GameListService gameListService;

    @MessageMapping("/getGames")
    @SendTo("/topic/games")
    public ArrayList<Game> getGames() {
        return gameListService.getGames();
    }

    @MessageMapping("/register")
    public void registerPlayerToGame(Player player) {
        if(player != null) {
            gameListService.addPlayerToGame(player);
            if (gameListService.containsTwoPlayers()) {
                gameListService.getPlayers().forEach((item) -> {
                    if (!item.equals(player)) {
                        item.setPlayerFiguur(Button.O);
                        player.setPlayerFiguur(Button.X);
                        player.setPlayerTurn(Button.X);
                        item.setPlayerTurn(Button.X);
                        player.setCanMove(true);
                        temp.convertAndSend("/topic/register/" + player.getId(), item);
                        temp.convertAndSend("/topic/register/" + item.getId(), player);
                    }
                });
            }
        }
    }
    @MessageMapping("/makeMove/{userId}")
    public void makeMove(Move move, @DestinationVariable String userId) {
        if (gameListService.makeMove(move)) {
            move.getPlayer().setCanMove(true);
            temp.convertAndSend("/topic/receiveMove/" + userId, move);
        }
    }
    @MessageMapping("/addGame")
    @SendTo("/topic/games")
    public ArrayList<Game> addGame(Game game) {
        Game _game = new Game(game.id, game.name, game.imagePath, game.description, game.owner);
        gameListService.addGamesToList(_game);
        return gameListService.getGames();
    }
    @MessageMapping("/deleteGame")
    public void deleteGame(String ownerId) {
        gameListService.deleteGameFromList(ownerId);
    }

}
