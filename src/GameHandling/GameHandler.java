package GameHandling;

import Hero.Hero;
import Hero.Mage.Mage;
import Hero.Rogue.Rogue;
import Hero.Warrior.Warrior;
import Monster.Monster;
import MonsterFactory.MonsterFactory;
import Town.Town;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class GameHandler {

    public int[][] worldMap;
    public int playerCoordX;
    public int playerCoordY;
    public final int goNorth = 1;
    public final int goSouth = 2;
    public final int goWest = 3;
    public final int goEast = 4;
    public IFightHandler iFightHandler;
    public SharedDataSingleton sharedDataSingleton;
    public Hero player;

    public GameHandler() {
        this.sharedDataSingleton = SharedDataSingleton.getInstance();
        this.iFightHandler = new FightHandler();
        this.gameIntroduction();
    }

    /**
     * Beginning ! Read introduction, choose class & name
     */
    public void gameIntroduction() {
        ReadFileHandler.dialogueIntro();
        ReadFileHandler.characterChoice();
        int classChoice = UserInputHandler.getUserIntInput(new ArrayList(Arrays.asList(1, 2, 3)));
        ReadFileHandler.nameChoice();
        String playerName = UserInputHandler.getUserStringInput();
        this.runGame(classChoice, playerName);
    }

    /**
     * Initiate the player and start the game
     */
    public void runGame(int classChoice, String playerName) {
        switch (classChoice) {
            case 1:
                this.player = new Warrior(playerName);
                break;
            case 2:
                this.player = new Mage(playerName);
                break;
            case 3:
                this.player = new Rogue(playerName);
                break;
            default:
                break;
        }
        this.sharedDataSingleton.initSharedDataSingleton(this.player);
        this.player = this.sharedDataSingleton.getPlayer();
        this.generateMaps();
        while (this.player.getLife() > 0) {
            this.playerActionTurn();
        }
    }

    /**
     * Generate the world map where numbers refers as events
     * Set the starting coordinates of the player
     */
    public void generateMaps() {
        this.worldMap = new int[][]{{1, 1, 1, 1}, {1, 1, 1, 1}, {1, 1, 2, 1}, {1, 1, 1, 1}};
        this.playerCoordX = 3;
        this.playerCoordY = 2;
    }

    /**
     * Each time player must choose a move
     */
    public void playerActionTurn() {
        System.out.println("Please select an option.");
        System.out.println("1. Move");
        System.out.println("2. Menu");
        int playerChoice = UserInputHandler.getUserIntInput(new ArrayList<>(Arrays.asList(1, 2)));
        switch (playerChoice) {
            case 1:
                this.movePlayer();
                break;
            case 2:
                this.gameMenu();
                break;
        }
    }

    public void gameMenu() {
        System.out.println("1. Show Map");
        int playerChoice = UserInputHandler.getUserIntInput(new ArrayList<>(Arrays.asList(1)));
        switch (playerChoice) {
            case 1:
                this.showMapToPlayer();
                break;
        }
    }

    /**
     * Get all the possible directions before moving the hero
     *
     * @return
     */
    public ArrayList<Integer> getPossibleDirections() {
        ArrayList<Integer> directions = new ArrayList<>();
        if (this.playerCoordX > 0) {
            System.out.println("1. North");
            directions.add(this.goNorth);
        }
        if (this.playerCoordX < this.worldMap.length - 1) {
            System.out.println("2. South");
            directions.add(this.goSouth);
        }
        if (this.playerCoordY > 0) {
            System.out.println("3. West");
            directions.add(this.goWest);
        }
        if (this.playerCoordY < this.worldMap[this.playerCoordX].length - 1) {
            System.out.println("4. East");
            directions.add(this.goEast);
        }
        return directions;
    }

    /**
     * Move the player on the map
     * Update his coordinates
     * Launch the associated event
     */
    public void movePlayer() {
        System.out.println("Where do you want to go ?");
        int userChoice = UserInputHandler.getUserIntInput(this.getPossibleDirections());
        switch (userChoice) {
            case 1:
                this.playerCoordX--;
                break;
            case 2:
                this.playerCoordX++;
                break;
            case 3:
                this.playerCoordY--;
                break;
            case 4:
                this.playerCoordY++;
                break;
        }
        this.setupEventOnPlayerMove();
    }

    /**
     * Show map to player
     */
    public void showMapToPlayer() {
        System.out.println("You're actually here :\n");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.worldMap.length; i++) {
            for (int j = 0; j < this.worldMap[i].length; j++) {
                if (i == this.playerCoordX && j == this.playerCoordY) {
                    sb.append(" O ");
                } else {
                    sb.append(" X ");
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    /**
     * Call events based on the player position after moving
     */
    public void setupEventOnPlayerMove() {
        int evtNumber = this.worldMap[this.playerCoordX][this.playerCoordY];
        switch (evtNumber) {
            case 1:
                n1Event();
                break;
            case -1:
                nMinus1Event();
                break;
            case 2:
                n2Event();
                break;
        }
    }

    /**
     * Number 1 Event
     * Fight against a monster or nothing happened
     */
    public void n1Event() {
        int rdnNumber = new Random().nextInt(10);
        if (rdnNumber > 5) {
            Monster enemy = MonsterFactory.generateMonster();
            this.iFightHandler.fightProcess(this.player, enemy);
            this.worldMap[this.playerCoordX][this.playerCoordY] = -1;
        } else {
            System.out.println("Everything seems peaceful here...");
        }
    }

    /**
     * Number -1 Event
     * Map cleared, nothing to be afraid of
     */
    public void nMinus1Event() {
        System.out.println("Looks like this place is cleared of all dangers.");
    }

    /**
     * Number 2 Event
     * Welcome to the town !
     */
    public void n2Event() {
        System.out.println("You just arrived in a town. You could use some help from people here...");
        boolean quit = false;
        while (!quit) {
            System.out.println("What do you want to do ?");
            System.out.println("1. Visit the Priest");
            System.out.println("2. Visit the Merchant");
            System.out.println("3. Leave the town");
            int userChoice = UserInputHandler.getUserIntInput(new ArrayList(Arrays.asList(1, 2, 3)));
            switch (userChoice) {
                case 1:
                    Town.visitPriest(this.player);
                    break;
                case 2:
                    Town.visitMerchant(this.player);
                    break;
                case 3:
                    System.out.println("You leave the town.");
                    quit = true;
                    break;
            }
        }
    }
}
