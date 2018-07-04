import db.DBConsole;
import db.DBGame;
import db.DBHelper;
import models.Console;
import models.Game;
import models.Genre;

import java.util.List;

public class Runner {

    public static void main(String[] args) {

        Console console1 = new Console("Sony", "Playstation4", "Europe");
        DBHelper.save(console1);
        Console console2 = new Console("Microsoft", "XBOX", "Asia");
        DBHelper.save(console2);

        Game game1 = new Game("Call of Duty 5", Genre.ACTION);
        DBHelper.save(game1);
        Game game2 = new Game("Final Fantasy 14", Genre.ADVENTURE);
        DBHelper.save(game2);

        console1.addGame(game1);
        game1.addConsole(console1);
        DBHelper.update(console1);

        game1.addConsole(console1);
        console1.addGame(game1);
        DBHelper.update(game1);

        List<Game> games  = DBConsole.getAvilableGames(console1);
        List<Console> consoles  = DBGame.getAvilableConsoles(game1);



    }
}
