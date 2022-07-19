package hotel.management.input;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ScannerInput {

    private static Scanner scanner = new Scanner(System.in);

    //Used To Get Integer inputs from User
    public static int getInt(){
        int newInt = 0;
        try{
            newInt = scanner.nextInt();
        }catch (InputMismatchException e){
            scanner.nextLine();
        }
        return newInt;
    }

    //Used to get String inputs from User
    public static String getString(){
        return scanner.nextLine();
    }

    //Used to get character input from user
    public static char getCharacter(){
        String word = getString();
        if(word.isBlank() || word.length() > 1) return '?';
        return word.toUpperCase().charAt(0);
    }
}
