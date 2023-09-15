import CharacterCreateFolder.Spinner;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class BRSim {

    private int game;
    private ArrayList<Fighter> fighters = new ArrayList<Fighter>();
    ArrayList<Fighter> losers = new ArrayList<Fighter>();



    public ArrayList<Fighter> getFighters() {
        return fighters;
    }

    public void setFighters(ArrayList<Fighter> fighters) {
        this.fighters = fighters;
    }

    public int getGame() {
        return game;
    }

    public BRSim(int x) {
        this.game = x;
        pick();
        if (getGame() == 2) {
            Fighter lms = soloRoyale(fighters);
            System.out.println(lms.name + " is your victor!\n");
            kills();

        }
        else if (getGame() == 3) {
            //teamRoyale(this.fighters);
        }
    }


    public void pick() {
        System.out.println("What universe would you like?");
        System.out.println("[1] Star Wars\n"+
                "[2] Demon Slayer");
        Scanner scan = new Scanner(System.in);
        int inp = scan.nextInt();

        switch(inp) {
            case 1:
                sim(1);
                break;
            case 2:
                sim(2);
                break;
            default:
                System.out.println("Invalid Input, try again");
                pick();
        }
    }
    public ArrayList sim(int genre) {
        ArrayList<Fighter> fighters = new ArrayList<Fighter>();
        FighterDataBase fdb = new FighterDataBase();
        if (genre == 1) {
            fdb.fillSW(fighters);
            setFighters(fighters);

        }
        if (genre == 2) {

        }
        return fighters;
    }
    public void result(Fighter w, Fighter l) {
        ArrayList<String> lines = new ArrayList<String>();
        lines.add("bested");
        lines.add("demolished");
        lines.add("made quick work of");
        lines.add("barely survived");
        lines.add("triumphed over");

        int idx = (int) (Math.random() * lines.size());

        System.out.println(w.name + " " + lines.get(idx) + " " + l.name);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
    public void kills() {
        System.out.println("Killcounts:");
        for (Fighter f: losers) {
            String namespace = String.format("%-18s", f.name);
            String kills = "";
            for (Fighter l: f.killList) {
                kills += l.name + ", ";
            }
            if (f.killList.size() > 0) {
                kills = kills.substring(0, kills.length() - 2);
            }
            else {
                kills = "";
            }
            System.out.println(namespace + "|" + f.kills + " ---> " + kills); // + " " + f.killList.toString());
        }
        String wKills = "";
        for (Fighter l: fighters.get(0).killList) {
            wKills += l.name + ", ";
        }

        String finWKills = wKills.substring(0, wKills.length()-2);

        String winame = String.format("%-18s",fighters.get(0).name);
        System.out.println(winame + "|" + fighters.get(0).kills + " ---> " + finWKills);
    }

    public Fighter soloRoyale(ArrayList<Fighter> fighters) {
        while (fighters.size() > 1) {
            int index1 = (int) (Math.random() * fighters.size());
            int index2 = (int) (Math.random() * fighters.size());//get random fighters
            while (index1 != index2 && index1 != fighters.size() && index2 != fighters.size()) {
                Fighter f1 = fighters.get(index1);
                Fighter f2 = fighters.get(index2);
                Fighter b, w;

                if (f1.skill >= f2.skill) { //determine whos better
                    b = f1;
                    w = f2;
                } else {
                    b = f2;
                    w = f1;
                } //b is better skilled fighter, w worse


                double pb = ((double) b.skill) / (b.skill + w.skill);
                double pw = ((double) w.skill) / (b.skill + w.skill); //calculates probability of win based on skill


                double r = Math.random();
                Fighter winner, loser;
                double pdub;

                if (r > pw) {
                    winner = b;
                    loser = w;
                    pdub = pb;
                } else {
                    winner = w;
                    loser = b;
                    pdub = pw;
                } //obtains winner and loser

                result(winner, loser);
                //System.out.println(winner.skill + " " + pdub);

                winner.kills++;
                fighters.remove(loser);
                losers.add(loser);
                winner.killList.add(loser);
                //System.out.println(loser.name);
                //losers.add(loser);
                //fighters.removeAll(losers);
            }

        }

        return fighters.get(0);
    }

//    public ArrayList teamRoyale(ArrayList<Fighter> fighters) {
//
//    }




}
