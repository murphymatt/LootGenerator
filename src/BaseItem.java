/**
 * Created by mattmurphy on 4/17/16.
 */
public class BaseItem implements Drop {

    private String name;

    public BaseItem (String name) { this.name = name; }

    public BaseItem open() {
        return this;
    }
}
