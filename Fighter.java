import java.util.ArrayList;

public class Fighter {
    String name;
    int skill;
    int kills;
    ArrayList<Fighter> killList;

    public Fighter(String name, int skill) {
        this.name = name;
        this.skill = skill;
        this.kills = 0;
        this.killList = new ArrayList<Fighter>();

    }
}
