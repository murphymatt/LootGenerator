import java.util.Random;

/**
 * Created by mattmurphy on 4/17/16.
 */
public class Affix {

    // fields
    private String name, statBoost;
    private int minStat, maxStat;

    // constructor
    public Affix(String name, String statBoost, int minStat, int maxStat) {
        this.name = name;
        this.statBoost = statBoost;
        this.minStat = minStat;
        this.maxStat = maxStat;
    }

    // methods
    public String getName() {
        return name;
    }

    public String getStatBoost() {
        return statBoost;
    }

    /*
     * chooses a random stat between vals of minStat and maxStat
     *
     * @return  randomStat
     */
    public int chooseStat() {
        if (minStat == maxStat) {
            return minStat;
        }
        Random rand = new Random();
        return rand.nextInt(maxStat - minStat) + minStat;
    }
}
