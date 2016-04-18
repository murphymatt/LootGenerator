import java.util.Random;

/**
 * Created by mattmurphy on 4/17/16.
 */
public class TreasureClass implements Drop {

    private String name;
    private Drop drop1, drop2, drop3;

    public TreasureClass(String name, Drop drop1, Drop drop2, Drop drop3) {
        this.name = name;
        this.drop1 = drop1;
        this.drop2 = drop2;
        this.drop3 = drop3;
    }

    public Drop open() {
        Random random = new Random();
        int dropVal = random.nextInt() % 3;
        switch (dropVal) {
            case 0:
                return drop1;
            case 1:
                return drop2;
            case 2:
                return drop3;
            default:
                return null;
        }
    }

}
