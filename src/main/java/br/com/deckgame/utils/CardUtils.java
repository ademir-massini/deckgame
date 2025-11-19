package br.com.deckgame.utils;

public class CardUtils {
    public static int valueToInt(String value) {
        if (value == null) return 0;
        switch (value) {
            case "A": return 1;
            case "J": return 11;
            case "Q": return 12;
            case "K": return 13;
            default:
                try {
                    return Integer.parseInt(value);
                } catch (NumberFormatException e) {
                    return 0;
                }
        }
    }
}