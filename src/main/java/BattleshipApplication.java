import com.game.constants.Constants;
import com.game.controller.GameController;
import com.game.controller.PlayController;
import com.game.controller.UserController;
import com.game.entity.User;
import com.game.enums.Command;
import com.game.enums.Parameter;
import com.game.utils.BattleshipUtils;

import java.util.Map;
import java.util.Scanner;

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
            executeCommand(Constants.bootstrapQueries[i]);
        }
    }

    public static void executeCommand(String query) {
        Map<Parameter, String> requestParams = BattleshipUtils.getParameterValues(query);
        Command command = valueOf(requestParams.get(Parameter.COMMAND));
        switch(command){
            case REGISTER_USER :
                userController.registerUser(requestParams);
                break;
            case CREATE_GAME:
                gameController.createGame(requestParams);
                break;
            case START_GAME:
                gameController.startGame(requestParams);
                break;
            case END_GAME:
                gameController.endGame(requestParams);
                break;
            case PAUSE_GAME:
                gameController.pauseGame(requestParams);
                break;
            case CREATE_SHIP:
                playController.createShip(requestParams);
                break;
            case TARGET:
                playController.target(requestParams);
                break;
        }
    }

    public static void commandLineInputs(){
        Scanner scanner = new Scanner(System.in);
        String inputQuery;
        do{
            System.out.println("-------------------------Enter Input Query here-------------------------");
            inputQuery = scanner.nextLine();
            if(inputQuery!= null && inputQuery.equals("exit"))
                continue;
            try{
                if(inputQuery != null && inputQuery.trim()!=""){
                    System.out.println("For query : "+ inputQuery);
                        executeCommand(inputQuery);
                }
            } catch(Exception e){
                System.out.println("Error executing query " + inputQuery);
                e.printStackTrace();
            }
        } while(!inputQuery.equals("exit"));
    }
}

