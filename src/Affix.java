import java.util.Random;

/**
 * Created by mattmurphy on 4/17/16.
 */
public class Affix {

    private String name, statBoost;
    private int minStat, maxStat;

    public Affix(String name, String statBoost, int minStat, int maxStat) {
        this.name = name;
        this.statBoost = statBoost;
        this.minStat = minStat;
        this.maxStat = maxStat;
    }

    public String getName() {
        return name;
    }

    public String getStatBoost() {
        return statBoost;
    }

    public int chooseStat() {
        if (minStat == maxStat) {
            return minStat;
        }
        Random rand = new Random();
        int randStat = rand.nextInt(maxStat - minStat) + minStat;
        return randStat;
    }
}
