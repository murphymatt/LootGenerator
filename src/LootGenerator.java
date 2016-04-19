import com.sun.xml.internal.rngom.parse.host.Base;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by mattmurphy on 4/17/16.
 */
public class LootGenerator {

    public static Monster pickMonster() throws FileNotFoundException {

        // create reader for file
        Scanner fileReader = new Scanner(new File("data/small/monstats.txt"));

        // create monsterData structure and fill with file info
        List<String> monsterData = new ArrayList<>();
        while (fileReader.hasNextLine()) {
            monsterData.add(fileReader.nextLine());
        }
        fileReader.close();

        // randomly choose a monster
        Random rand = new Random();
        int randomVal = rand.nextInt() % monsterData.size();
        String chosenData = monsterData.get(randomVal);

        // parse out info from chosen monster data
        String[] splitData = chosenData.split("\t");

        // create and return Monster
        String monsterClass = splitData[0];
        String type = splitData[1];
        int level = Integer.parseInt(splitData[2]);
        TreasureClass treasureClass = fetchTreasureClass(splitData[3]);
        return new Monster(monsterClass, type, level, treasureClass);
    }

    public static TreasureClass fetchTreasureClass(String treasureClassName) throws FileNotFoundException {

        // create reader for file
        Scanner fileReader = new Scanner(new File("data/small/TreasureClassEx.txt"));

        // search for treasureClass using treasureClassName

        return null;
    }

    public static BaseItem generateBaseItem(TreasureClass treasureClass) throws FileNotFoundException {

        // crate reader for file
        Scanner fileReader = new Scanner(new File("data/small/armor.txt"));

        while (fileReader.hasNext()) {
            if (fileReader.next().equals(treasureClass.getName())) {

            }
        }
        return (BaseItem) treasureClass.open();
    }

    public static BaseStats generateBaseStats() {
        return null;
    }

    public static Affix generateAffix() {
        // TODO: not yet implemented
        return null;
    }
}
