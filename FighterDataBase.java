import java.util.ArrayList;

public class FighterDataBase {
    public static ArrayList<Fighter> fillSW(ArrayList<Fighter> fighters) {
        Fighter ls = new Fighter("Luke Skywalker", 88);
        Fighter yoda = new Fighter("Yoda", 98);
        Fighter owk = new Fighter("Obi Wan Kenobi", 90);
        Fighter mw = new Fighter("Mace Windu", 94);
        Fighter at = new Fighter("Ashoka Tano", 81);
        Fighter hs = new Fighter("Han Solo", 76);
        Fighter rey = new Fighter("Rey", 72);
        Fighter chewy = new Fighter("Chewbacca", 68);
        Fighter pd = new Fighter("Poe Dameron", 60);
        //finn
        Fighter mando = new Fighter("Din Djarin", 58);
        //kanaan
        Fighter dv = new Fighter("Darth Vader", 94);
        Fighter ep = new Fighter("Emperor Palpatine", 99);
        Fighter dm = new Fighter("Darth Maul", 82);
        Fighter cd = new Fighter("Count Dooku", 87);
        Fighter gg = new Fighter("General Grievous", 79);
        Fighter bf = new Fighter("Boba Fett", 75);
        Fighter kr = new Fighter("Kylo Ren", 72);
        Fighter jf = new Fighter("Jango Fett", 66);
        Fighter gi = new Fighter("Grand Inquisitor", 62);
        Fighter cp = new Fighter("Captain Phasma", 58);

        fighters.add(ls);
        fighters.add(yoda);
        fighters.add(owk);
        fighters.add(mw);
        fighters.add(at);
        fighters.add(hs);
        fighters.add(rey);
        fighters.add(chewy);
        fighters.add(dv);
        fighters.add(ep);
        fighters.add(dm);
        fighters.add(cd);
        fighters.add(gg);
        fighters.add(bf);
        fighters.add(kr);
        fighters.add(jf);
        fighters.add(pd);
        fighters.add(mando);
        fighters.add(cp);
        fighters.add(gi);

        return fighters;
    }

}
