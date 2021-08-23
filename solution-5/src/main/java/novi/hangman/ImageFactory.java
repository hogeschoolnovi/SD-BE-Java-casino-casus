package novi.hangman;

import java.util.List;

public class ImageFactory {
    public static List<List<String>> IMAGES = List.of(
            List.of(),
            List.of(
                    "",
                    "",
                    "",
                    "",
                    "",
                    "___|___"
            ),
            List.of(
                    "",
                    "   |",
                    "   |",
                    "   |",
                    "   |",
                    "___|___"
            ),
            List.of(
                    "   ---------",
                    "   |",
                    "   |",
                    "   |",
                    "   |",
                    "___|___"
            ),
            List.of(
                    "   ---------",
                    "   |       |",
                    "   |      ( )",
                    "   |",
                    "   |",
                    "___|___"
            ),
            List.of(
                    "   ---------",
                    "   |       |",
                    "   |      ( )",
                    "   |       |",
                    "   |",
                    "___|___"
            ),
            List.of(
                    "   ---------",
                    "   |       |",
                    "   |      ( )",
                    "   |       |",
                    "   |      / \\",
                    "___|___"
            ),
            List.of(
                    "   ---------",
                    "   |       |",
                    "   |      ( )",
                    "   |      -|-",
                    "   |      / \\",
                    "___|___"
            )
    );

    public static List<String> getImage(int index) {
        return IMAGES.get(index);
    }
}
