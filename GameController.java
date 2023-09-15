import CharacterCreateFolder.CharacterCreator;
import CharacterCreateFolder.SWCreator;

import java.util.Scanner;

public class GameController {
    public static void main(String[] args) {
        System.out.println("What Game would you like to Play?");
        System.out.println("[1] Character Creator\n" +
                "[2] Solo Battle Royale\n" + "[3] Team Battle Royale");


        pickGame();

    }
    private static void pickGame() {
        Scanner scan = new Scanner(System.in);
        int inp = scan.nextInt();

        switch(inp) {
            case 1:
                CharacterCreator cc = new CharacterCreator();
                cc.ccGame();
                break;
            case 2:
                BRSim sim = new BRSim(inp);
                break;
            default:
                System.out.println("Invalid Input, try again");
                pickGame();
        }
    }
}
