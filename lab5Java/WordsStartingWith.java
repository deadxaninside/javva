import java.util.regex.*;
import java.util.Scanner;

public class WordsStartingWith {
    public static void main(String[] args) {
        // Исходный текст
        String text = "Apple and apricot are amazing fruits. But bananas are better.";

        // Ввод буквы от пользователя
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите букву, с которой должны начинаться слова:");
        char letter = scanner.next().charAt(0);

        // Регулярное выражение для поиска слов, начинающихся с заданной буквы
        Pattern pattern = Pattern.compile("\\b" + letter + "\\w*", Pattern.CASE_INSENSITIVE);

        Matcher matcher = pattern.matcher(text);

        System.out.println("Слова, начинающиеся с буквы '" + letter + "':");
        // Ищем и выводим слова
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }
}
