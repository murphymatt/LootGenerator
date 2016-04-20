/**
 * Created by mattmurphy on 4/17/16.
 */
public class Monster {

    private String monsterClass, type;
    private int level;
    private String treasureClassName;

    public Monster(String monsterClass, String type, int level, String treasureClassName) {
        this.monsterClass = monsterClass;
        this.type = type;
        this.level = level;
        this.treasureClassName = treasureClassName;
    }

    public String getMonsterClass() {
        return monsterClass;
    }

    public String getTreasureClassName() {
        return treasureClassName;
    }
}
