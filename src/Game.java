
import java.io.FileNotFoundException;
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

            System.out.println("Fighting " + monster + "...");
            System.out.println("You have slain " + monster + "!");
            System.out.println(monster + " dropped:");
            System.out.print("\n\n\n");

            // generate item dropped
            TreasureClass treasureClass = LootGenerator.fetchTreasureClass(monster);
            Affix affix = LootGenerator.generateAffix();
            BaseItem baseItem = LootGenerator.generateBaseItem(treasureClass);
            BaseStats baseStats = LootGenerator.generateBaseStats();

            System.out.println(affix + " " + baseItem);
            System.out.println(baseStats);
            System.out.print("\n\n\n");

            // prompt to continue
            System.out.print("Fight again [y/n]?  ");
            ans = in.nextLine().toLowerCase();

        } while (ans.equals("y"));
    }
}
