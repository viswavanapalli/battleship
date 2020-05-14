import com.game.constants.Constants;
import com.game.controller.GameController;
import com.game.controller.PlayController;
import com.game.controller.UserController;
import com.game.entity.User;
import com.game.enums.Command;
import com.game.enums.Parameter;
import com.game.utils.BattleshipUtils;

import java.util.Map;

import static com.game.enums.Command.*;

public class BattleshipApplication {

    private static UserController userController;
    private static GameController gameController;
    private static PlayController playController;

    public  static void main(String[] args){
        User user0 = new User("Admin", 100);

        userController = new UserController();
        gameController = new GameController();
        playController = new PlayController();
    }

    public static void initialSetup(){
        for(int i = 0; i<Constants.bootstrapQueries.length; i++){
            System.out.println("For query : "+ Constants.bootstrapQueries[i]);
            String[] queryData = Constants.bootstrapQueries[i].split(",");
            String playerMetadata = queryData[0];
            String playerInput = queryData[1];
            executeCommand(playerMetadata, playerInput);
        }
    }

    public static void executeCommand(String playerMetadata, String playerInput) {
        Map<Parameter, String> requestParams = BattleshipUtils.getParameterValues(playerInput);
        Command command = valueOf(requestParams.get(Parameter.COMMAND));
        switch(command){
            case REGISTER_USER :
                userController.registerUser(playerMetadata, requestParams);
                break;
            case CREATE_GAME:
                gameController.createGame(playerMetadata, requestParams);
                break;
            case START_GAME:
                gameController.startGame(playerMetadata, requestParams);
                break;
            case END_GAME:
                gameController.endGame(playerMetadata, requestParams);
                break;
            case PAUSE_GAME:
                gameController.pauseGame(playerMetadata, requestParams);
                break;
            case TARGET:
                playController.target(playerMetadata, requestParams);
                break;
        }
    }
}


//REGISTER_USER,
//        CREATE_GAME,
//        CREATE_SHIP,
//        START_GAME,
//        END_GAME,
//        PAUSE_GAME,
//        TARGET