import java.util.Random;

/**
 * Created by mattmurphy on 4/17/16.
 */
public class TreasureClass {

    // fields
    private String name;
    private String drop1, drop2, drop3;

    // constructor
    public TreasureClass(String name, String drop1, String drop2, String drop3) {
        this.name = name;
        this.drop1 = drop1;
        this.drop2 = drop2;
        this.drop3 = drop3;
    }

    // methods

    /*
     *  chooses one drop name at random
     *
     *  @return drop    randomly selected drop
     */
    public String open() {
        Random random = new Random();
        int dropVal = random.nextInt(3);
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
