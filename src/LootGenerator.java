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

    /*
      * Picks a random monster from monstats.txt
      * set to "large" folder by default
      *
      * @return Monster: a randomly chosen monster from the monstats.txt
     */
    public static Monster pickMonster() throws FileNotFoundException {

        // create reader for file
        Scanner fileReader = new Scanner(new File("data/large/monstats.txt"));

        // create monsterData structure and fill with file info
        List<String> monsterData = new ArrayList<>();
        while (fileReader.hasNextLine()) {
            monsterData.add(fileReader.nextLine());
        }
        fileReader.close();

        // randomly choose a monster
        Random rand = new Random();
        int randomVal = rand.nextInt(monsterData.size());
        String chosenData = monsterData.get(randomVal);

        // parse out info from chosen monster data
        String[] splitData = chosenData.split("\t");

        // create and return Monster
        String monsterClass = splitData[0];
        String type = splitData[1];
        int level = Integer.parseInt(splitData[2]);
        String treasureClassName = splitData[3];
        return new Monster(monsterClass, type, level, treasureClassName);
    }

    /*
     * builds a TreasureClass object given the name of said treasureClass
     * parses associated TreasureClass fields from TreasureClassEx.txt
     * Set to "large" folder by default
     *
     * @params treasureClassName   string to search for in TreasureClassEx.txt
     * @return TreasureClass	   New TreasureClassObject with parsed information
     * 			null if class name not found
     */
    public static TreasureClass fetchTreasureClass(String treasureClassName) throws FileNotFoundException {

        // create reader for file
        @SuppressWarnings("resource")
        Scanner fileReader = new Scanner(new File("data/large/TreasureClassEx.txt"));
        String[] line = searchFile(fileReader, treasureClassName);
        fileReader.close();

        if (line != null) {
            return new TreasureClass(line[0], line[1], line[2], line[3]);
        } else {
            return null;
        }
    }

    /*
     * builds a BaseItem object given a TreasureClassObject
     * Selects random BaseItem to searchFor from TreasureClassObject
     * parses associated BaseItem fields from armor.txt
     * Set to "large" folder by default
     * If baseItem not found, baseItemName must be a TreasureClass
     * 	Searches for associated TreasureClass with name
     *
     * @params treasureClass   string to search for in TreasureClassEx.txt
     * @return BaseItem	   		New BaseItem with parsed information
     */
    public static BaseItem generateBaseItem(TreasureClass treasureClass) throws FileNotFoundException {

        // choose a baseItemName to search for
        String baseItemName = treasureClass.open();

        // search for baseItemName in armor.txt
        Scanner armorReader = new Scanner(new File("data/large/armor.txt"));
        String[] line = searchFile(armorReader, baseItemName);
        armorReader.close();

        // if line is not found in armor.txt, it must be another treasureClass
        if (line == null) {
            TreasureClass newTreasureClass = fetchTreasureClass(baseItemName);
            return generateBaseItem(newTreasureClass);
        }

        return new BaseItem(line[0], Integer.parseInt(line[1]), Integer.parseInt(line[2]));
    }

    /*
     * @params item		a BaseItem object
     * @return stat		randomly selected stat within item's stat range
     */
    public static int generateBaseStats(BaseItem item) {
        return item.getStat();
    }

    /*
     * Creates an suffix or prefix
     * Searches through MagicSuffix.txt or MagicPrefix.txt and chooses a random Affix
     * Set to "large" folder by default
     *
     * @params whichAffix		boolean to choose prefix or suffix
     * 							true -> prefix, false -> suffix
     * @return Affix			new Affix object parsed from associated file
     */
    public static Affix generateAffix(boolean whichAffix) throws FileNotFoundException {

        Scanner affixReader;

        if (whichAffix) {
            // create reader for prefix file
            affixReader = new Scanner(new File("data/large/MagicPrefix.txt"));
        } else {
            // create reader for suffix file
            affixReader = new Scanner(new File("data/large/MagicSuffix.txt"));
        }

        // get data using affixReader
        String[] parsedAffix = getRandomData(affixReader);
        affixReader.close();

        return new Affix(parsedAffix[0], parsedAffix[1],
                Integer.parseInt(parsedAffix[2]), Integer.parseInt(parsedAffix[3]));
    }

    /*
     * HelperMethod for generateAffix
     * chooses whether or not to create an affix
     * affix has 50% chance of creation
     *
     * @params whichAffix		boolean to choose prefix or suffix
     * 							true -> prefix, false -> suffix
     * @return Affix			new Affix object parsed from associated file
     */
    public static Affix setAffix(boolean whichAffix) throws FileNotFoundException {
        Affix affix;
        Random rand = new Random();
        int affixProb = rand.nextInt(2);
        if (affixProb == 0) {
            affix = generateAffix(whichAffix);
        } else {
            affix = null;
        }
        return affix;
    }

    /*
     * helper method
     * reads entire file and chooses a random line to parse
     *
     * @params fileReader			Scanner object for associated file
     * @return dataToParse.split()	Parsed information, split around tab chars
     */
    private static String[] getRandomData(Scanner fileReader) {
        List<String> fileLines = new ArrayList<>();

        // populate list with lines in the file
        while (fileReader.hasNextLine()) {
            fileLines.add(fileReader.nextLine());
        }

        // choose a random line to parse
        Random rand = new Random();
        int randLine = rand.nextInt(fileLines.size());
        String dataToParse = fileLines.get(randLine);

        return dataToParse.split("\t");
    }

    /*
     * helper method
     * Searches file line by line, if first "word" in line matches searchTerm,
     * then that line is returned
     *
     * @params	fileReader		Scanner object for associated file
     * 			searchFor		Search term
     * @return	splitData		returns string data split around tab chars
     * 							null if searchFor not found
     */
    private static String[] searchFile(Scanner fileReader, String searchFor) {
        String[] line;

        // search text file for treasureClassName
        while (fileReader.hasNextLine()) {
            line = fileReader.nextLine().split("\t");
            if (line[0].equals(searchFor)) {
                return line;
            }
        }

        return null;
    }

}
