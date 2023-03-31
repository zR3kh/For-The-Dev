package GameHandling;

import Hero.Hero;

import java.util.Scanner;

public class SharedDataSingleton {

    private static SharedDataSingleton instance = null;
    public Hero player;
    public Scanner scanner;

    private SharedDataSingleton() {

    }

    public static synchronized SharedDataSingleton getInstance() {
        if (instance == null) {
            instance = new SharedDataSingleton();
        }
        return instance;
    }

    public void initSharedDataSingleton(Hero player, Scanner scanner) {
        this.player = player;
        this.scanner = scanner;
    }

    public Hero getPlayer() {
        return this.player;
    }

    public Scanner getScanner() {
        return this.scanner;
    }
}
