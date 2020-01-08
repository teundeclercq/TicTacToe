package nl.fontys.tictactoe.Controllers;

import nl.fontys.tictactoe.Models.Player;
import nl.fontys.tictactoe.Services.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

@Controller
@RequestMapping("/player")
public class PlayerController {
    private static final Logger logger = Logger.getLogger(PlayerController.class.getName());
    private static String exceptionMsg = "Exception";
    private static String status = "Status";

    @Autowired
    private PlayerService playerService;

    @PostMapping("/")
    public Map<String, String> addPlayer(@RequestBody Player playerToDo) {
        HashMap<String, String> map = new HashMap<>();
        try {
            Player player = new Player(
                    playerToDo.getId(),
                    playerToDo.getEmail(),
                    playerToDo.getCanMove(),
                    playerToDo.getPlayerFiguur(),
                    playerToDo.getPlayerTurn()
            );
            this.playerService.addPlayer(player);
            map.put(status, "Ok");
            return map;
        } catch (Exception e) {
            logger.log(Level.INFO, exceptionMsg, e);
            map.put(status, "Error");
            return map;
        }
    }
//    @DeleteMapping("/{userId}")
//    public Map<String, String> deleteUser(@PathVariable String userId) {
//        HashMap<String, String> map = new HashMap<>();
//        try{
//            if(playerService.userExists(userId)){
//                this.playerService.deletePlayer(userId);
//                FirebaseAuth.getInstance().deleteUser(userId);
//                logger.log(Level.INFO, status , userId);
//                map.put(status, "Ok");
//            } else {
//                map.put(status, "USER not deleted");
//            }
//            return map;
//        } catch (Exception e) {
//            logger.log(Level.INFO, exceptionMsg, e);
//            map.put(status, "Error");
//            return map;
//        }
//    }
//    @PutMapping("/")
//    public Player updatePlayer(@RequestBody Player playerToDo) {
//        Player user = new Player(playerToDo.getId(),
//                playerToDo.getEmail(),
//                playerToDo.getCanMove(),
//                playerToDo.getPlayerFiguur(),
//                playerToDo.getPlayerTurn());
//        if(playerService.userExists(user.getId())) {
//            return playerService.updatePlayer(playerToDo);
//        } else {
//            return null;
//        }
//    }
}
