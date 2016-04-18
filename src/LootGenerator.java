import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by mattmurphy on 4/17/16.
 */
public class LootGenerator {

    public static Monster pickMonster() throws FileNotFoundException {

        // create reader for file
        Scanner fileReader = new Scanner(new File("data/small/monstats.txt"));

        if (fileReader.hasNextLine()) {
            fileReader.nextLine();
        }
        // TODO: not yet implemented
        return null;
    }

    public static TreasureClass fetchTreasureClass(Monster monster) {
        return monster.getTreasureClass();
    }

    public static BaseItem generateBaseItem(TreasureClass treasureClass) {
        treasureClass.open();
        return null;
    }

    public static BaseStats generateBaseStats() {
        // TODO: not yet implemented
        return null;
    }

    public static Affix generateAffix() {
        // TODO: not yet implemented
        return null;
    }
}
