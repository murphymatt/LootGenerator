import java.util.Random;

/**
 * Created by mattmurphy on 4/17/16.
 */
public class BaseItem {

    private String name;
    private int minStat, maxStat;

    public BaseItem(String name, int minStat, int maxStat) {
        this.name = name;
        this.minStat = minStat;
        this.maxStat = maxStat;
    }

    // returns name
    public String getName() {
        return name;
    }

    public int getStat() {
        Random rand = new Random();
        return rand.nextInt(maxStat - minStat) + minStat;
    }
}
