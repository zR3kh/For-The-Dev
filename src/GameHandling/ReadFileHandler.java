package GameHandling;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadFileHandler {

    public static String file = "src/Introduction.txt";

    /**
     * Game dialogue introduction
     */
    public static void dialogueIntro() {
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String currentLine;
            while ((currentLine = br.readLine()) != null) {
                if (currentLine.contains("##INTROSTART")) {
                    break;
                }
            }
            while ((currentLine = br.readLine()) != null) {
                if (currentLine.contains("##INTROEND")) {
                    break;
                } else {
                    System.out.println(currentLine);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Ask user for his class choice
     */
    public static void characterChoice() {
        try(BufferedReader br = new BufferedReader(new FileReader(file))) {
            String currentLine;
            while ((currentLine = br.readLine()) != null) {
                if (currentLine.contains("##CLASSSTART")) {
                    break;
                }
            }
            while ((currentLine = br.readLine()) != null) {
                if (currentLine.contains("##CLASSEND")) {
                    break;
                } else {
                    System.out.println(currentLine);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Ask user for his name choice
     */
    public static void nameChoice() {
        try(BufferedReader br = new BufferedReader(new FileReader(file))) {
            String currentLine;
            while ((currentLine = br.readLine()) != null) {
                if (currentLine.contains("##NAMESTART")) {
                    break;
                }
            }
            while ((currentLine = br.readLine()) != null) {
                if (currentLine.contains("##NAMEEND")) {
                    break;
                } else {
                    System.out.println(currentLine);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
