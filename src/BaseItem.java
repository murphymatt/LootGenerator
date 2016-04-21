import java.util.Random;

/**
 * Created by mattmurphy on 4/17/16.
 */
public class BaseItem {

    // fields
    private String name;
    private int minStat, maxStat;

    // constructor
    public BaseItem(String name, int minStat, int maxStat) {
        this.name = name;
        this.minStat = minStat;
        this.maxStat = maxStat;
    }

    // methods
    public String getName() {
        return name;
    }

    /*
     *  chooses a random stat value between minStat and maxStat
     *
     *  @return stat    randomly selected stat val
     */
    public int getStat() {
        Random rand = new Random();
        return rand.nextInt(maxStat - minStat) + minStat;
    }
}
