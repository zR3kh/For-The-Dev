package GameHandling;

import Hero.Hero;
import Hero.Warrior.Warrior;
import Monster.Monster;
import MonsterFactory.MonsterFactory;
import Town.Town;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

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
    public Scanner scanner;

    /**
     * Constructor
     */
    public GameHandler() {
        this.player = new Warrior("Rekh");
        this.scanner = new Scanner(System.in);
        this.sharedDataSingleton = SharedDataSingleton.getInstance();
        this.sharedDataSingleton.initSharedDataSingleton(player, scanner);
        this.player = this.sharedDataSingleton.getPlayer();
        this.scanner = this.sharedDataSingleton.getScanner();
        this.iFightHandler = new FightHandler();
        this.gameIntroduction();
    }

    /**
     * Generate map and moves player until he dies
     */
    public void gameIntroduction() {
        System.out.println("Welcome to For the Dev.");
        this.generateMaps();
        while (this.player.getLife() > 0) {
            movePlayer();
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
     * Get all the possible directions before moving the hero
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

    public int handleUserInput() {
        ArrayList<Integer> directions = this.getPossibleDirections();
        int userChoice = -1;
        do {
            if (!this.scanner.hasNextInt()) {
                System.out.println("This is not a valid direction.");
                this.scanner.next();
            } else {
                if (!directions.contains(userChoice)) {
                    System.out.println("There is nothing to explore here.");
                    this.scanner.next();
                }
            }
            userChoice = this.scanner.nextInt();
        } while (!directions.contains(userChoice));
        return userChoice;
    }

    /**
     * Move the player on the map
     * Update his coordinates
     * Launch the associated event
     */
    public void movePlayer() {
        System.out.println("Where do you want to go ?");
        int userChoice = this.handleUserInput();
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
            this.iFightHandler.fightProcess(this.player, enemy, this.scanner);
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
        System.out.println("Looks like there is nothing more to fight here.");
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
            System.out.println("2. Leave the town");
            int userChoice = this.scanner.nextInt();
            switch (userChoice) {
                case 1:
                    Town.visitPriest(this.player, this.scanner);
                    break;
                case 2:
                    System.out.println("You leave the town.");
                    quit = true;
                    break;
            }
        }
    }
}
