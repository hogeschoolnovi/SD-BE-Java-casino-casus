package novi;

import com.diogonunes.jcolor.Attribute;

import static com.diogonunes.jcolor.Ansi.colorize;

public class Printer {
    public static void printTitle(String title, Object... args) {
        System.out.printf(colorize(title + "\n", Attribute.BRIGHT_RED_TEXT(), Attribute.BRIGHT_YELLOW_BACK()), args);
    }

    public static void printGreen(String text, Object... args) {
        System.out.printf(colorize(text + "\n", Attribute.BRIGHT_WHITE_TEXT(), Attribute.BRIGHT_GREEN_BACK()), args);
    }

    public static void printRed(String text, Object... args) {
        System.out.printf(colorize(text + "\n", Attribute.BRIGHT_WHITE_TEXT(), Attribute.BRIGHT_RED_BACK()), args);
    }
}
