package GameHandling;

import Hero.Hero;

import java.util.Scanner;

public class SharedDataSingleton {

    private static SharedDataSingleton instance = null;
    public Hero player;

    private SharedDataSingleton() {

    }

    public static synchronized SharedDataSingleton getInstance() {
        if (instance == null) {
            instance = new SharedDataSingleton();
        }
        return instance;
    }

    public void initSharedDataSingleton(Hero player) {
        this.player = player;
    }

    public Hero getPlayer() {
        return this.player;
    }
}
