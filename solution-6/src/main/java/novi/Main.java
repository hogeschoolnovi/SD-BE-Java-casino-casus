package novi;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner inputScanner = new Scanner(System.in);
        Casino casino = new Casino(inputScanner);

        casino.start();
    }
}
