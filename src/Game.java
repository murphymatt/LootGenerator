
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by mattmurphy on 4/17/16.
 */
public class Game {

    public static void main(String[] args) throws FileNotFoundException {

        // variable declarations
        Scanner in = new Scanner(System.in);
        String ans = "y";
        int baseStat;
        TreasureClass treasureClass;
        BaseItem baseItem;
        Affix prefix, suffix;

        while (ans.equals("y")) {

            // generate and fight monster
            Monster monster = LootGenerator.pickMonster();
            System.out.println("Fighting " + monster.getMonsterClass() + "...");
            System.out.println("You have slain " + monster.getMonsterClass() + "!");
            System.out.println(monster.getMonsterClass() + " dropped:");
            System.out.print("\n\n");

            // generate item dropped
            treasureClass = LootGenerator.fetchTreasureClass(monster.getTreasureClassName());
            baseItem = LootGenerator.generateBaseItem(treasureClass);
            baseStat = LootGenerator.generateBaseStats(baseItem);

            // generate possible affixes and print full item name
            prefix = LootGenerator.setAffix(true);
            if (prefix != null) {
                System.out.print(prefix.getName() + " ");
            }
            System.out.print(baseItem.getName() + " ");
            suffix = LootGenerator.setAffix(false);
            if (suffix != null) {
                System.out.println(suffix.getName());
            }

            System.out.println();
            System.out.println("Defense: " + baseStat);

            // print affix stats if available
            if (prefix != null) {
                System.out.println(prefix.chooseStat() + " " + prefix.getStatBoost());
            }
            if (suffix != null) {
                System.out.println(suffix.chooseStat() + " " + suffix.getStatBoost());
            }

            System.out.print("\n\n");

            // prompt to continue
            System.out.print("Fight again [y/n]?  ");
            ans = in.nextLine().toLowerCase();
            while (!ans.equals("y") && !ans.equals("n")) {
                System.out.println("Sorry, you must respond with \"y\" or \"n\".");
                System.out.print("Fight again [y/n]?  ");
                ans = in.nextLine().toLowerCase();
            }
            if (ans.equals("n")) {
                break;
            }
            System.out.print("\n\n\n");
        }

        in.close();
    }
}
