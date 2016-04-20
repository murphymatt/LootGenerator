
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by mattmurphy on 4/17/16.
 */
public class Game {

    public static void main(String[] args) throws FileNotFoundException {

        Scanner in = new Scanner(System.in);
        String ans;

        do {
            // generate monster
            Monster monster = LootGenerator.pickMonster();

            System.out.println("Fighting " + monster.getMonsterClass() + "...");
            System.out.println("You have slain " + monster.getMonsterClass() + "!");
            System.out.println(monster.getMonsterClass() + " dropped:");
            System.out.print("\n\n");

            // generate item dropped
            TreasureClass treasureClass = LootGenerator.fetchTreasureClass(monster.getTreasureClassName());
            BaseItem baseItem = LootGenerator.generateBaseItem(treasureClass);
            int baseStat = LootGenerator.generateBaseStats(baseItem);

            // print prefix if appropriate
            Affix prefix;
            Random rand = new Random();
            int affixProb = rand.nextInt(2);
            if (affixProb == 0) {
                prefix = LootGenerator.generateAffix(true);
                System.out.print(prefix.getName() + " ");
            } else {
                prefix = null;
            }

            System.out.print(baseItem.getName() + " ");

            // print suffix if appropriate
            Affix suffix;
            affixProb = rand.nextInt(2);
            if (affixProb == 0) {
                suffix = LootGenerator.generateAffix(false);
                System.out.print(suffix.getName());
            } else {
                suffix = null;
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
            System.out.print("\n\n\n");
        } while (ans.equals("y"));
    }
}
