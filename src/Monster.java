/**
 * Created by mattmurphy on 4/17/16.
 */
public class Monster {

    private String monsterClass, type;
    private int level;
    private TreasureClass treasureClass;

    public Monster(String monsterClass, String type, int level, TreasureClass treasureClass) {
        this.monsterClass = monsterClass;
        this.type = type;
        this.level = level;
        this.treasureClass = treasureClass;
    }

    public String getMonsterClass() {
        return monsterClass;
    }

    public String getType() {
        return type;
    }

    public int getLevel() {
        return level;
    }

    public TreasureClass getTreasureClass() {
        return treasureClass;
    }
}
