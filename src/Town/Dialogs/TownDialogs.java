package Town.Dialogs;

import GameHandling.UserInputHandler;

import java.util.ArrayList;
import java.util.Arrays;

public class TownDialogs {

    public static final ArrayList<Integer> PRIEST_DIALOG_GLOBAL = new ArrayList<>(Arrays.asList(1, 2));
    public static final ArrayList<Integer> MERCHANT_DIALOG_GLOBAL = new ArrayList<>(Arrays.asList(1, 2));
    public static final ArrayList<Integer> MERCHANT_DIALOG_WEAPONS = new ArrayList<>(Arrays.asList(1, 2, 3));

    /**
     * Display Priest global dialog
     * @return
     */
    public static int showPriestDialogGlobal() {
        System.out.println("There you are, my dear child.");
        System.out.println("I can fully restore your power if you desire, for the cheap price of ten gold.");
        System.out.println("Accept the offer ?");
        System.out.println("1. Yes");
        System.out.println("2. No");
        return UserInputHandler.getUserIntInput(PRIEST_DIALOG_GLOBAL);
    }

    /**
     * Display Merchant global dialog
     * @return
     */
    public static int showMerchantDialogGlobal() {
        System.out.println("Hello. I sell multiple weapons at a cheap price.");
        System.out.println("Wanna give it a try ?");
        System.out.println("1. Yes");
        System.out.println("2. No");
        return UserInputHandler.getUserIntInput(MERCHANT_DIALOG_GLOBAL);
    }

    /**
     * Display Merchant weapon dialog
     * @return
     */
    public static int showMerchantDialogWeapons() {
        System.out.println("1. Sword - 10 Golds");
        System.out.println("2. Staff - 10 Golds");
        System.out.println("3. Leave the store");
        return UserInputHandler.getUserIntInput(MERCHANT_DIALOG_WEAPONS);
    }

    /**
     * Player don't have enough gold
     */
    public static void tooPoor() {
        System.out.println("You don't have enough gold to buy that.");
    }
}
