package nl.fontys.tictactoe.Controllers;

import nl.fontys.tictactoe.Models.*;
import nl.fontys.tictactoe.Services.GameListService;
import nl.fontys.tictactoe.Services.GameSessionService;
import nl.fontys.tictactoe.Services.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;
import java.util.logging.Logger;

@Controller
public class GameListController {
    private final static Logger LOGGER = Logger.getLogger(GameListController.class.getName());
    @Autowired
    SimpMessagingTemplate temp;
    @Autowired
    private GameListService gameListService;
    @Autowired
    private GameSessionService gameSessionService;


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
                        //Send the player icon back to the respective player.
                        temp.convertAndSend("/topic/register/" + player.getId(), player);
                        temp.convertAndSend("/topic/register/" + item.getId(), item);

                        //Send the enemy player to the other players.
                        temp.convertAndSend("/topic/enemyPlayer/" + player.getId(), item);
                        temp.convertAndSend("/topic/enemyPlayer/" + item.getId(), player);

                    }
                });
            }
        }
    }
    @MessageMapping("/remove")
    public void removePlayerFromGame(Player player) {
        System.out.println(gameListService.getPlayers().size());
        if (player!=null) {
            if (gameListService.getPlayers().size() != 0) {
                gameListService.removePlayerFromGame(player.getId());
            }
        }
    }
    @MessageMapping("/makeMove/{userId}")
    public void makeMove(Move move, @DestinationVariable String userId) {
        if (gameListService.makeMove(move)) {
            move.getPlayer().setCanMove(true);
            temp.convertAndSend("/topic/receiveMove/" + userId, move);
            Button button = gameListService.calculateWinner();
            if (button != null) {
                gameListService.getPlayers().forEach((item) -> {
                    if (!item.getId().equals(userId)) {
                        temp.convertAndSend("/topic/receiveWinner/" + userId, button);
                        temp.convertAndSend("/topic/receiveWinner/" +item.getId(), button);
                    }
                });
                Set<Player> players = new HashSet<>(gameListService.getPlayers());
                Player player;
                for (Player item : gameListService.getPlayers()) {
                    if (item.getPlayerFiguur().equals(button)) {
                        player = item;
                        gameSessionService.addGameSession(new GameSession(players, player.getEmail(), LocalDateTime.now()));
                    }
                }

            }
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
