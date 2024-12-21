import java.util.regex.*;
import java.util.Scanner;

public class WordsStartingWith {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ввод текста для поиска
        System.out.print("Введите текст: ");
        String text = scanner.nextLine().trim();

        // Проверка на пустой ввод текста
        if (text.isEmpty()) {
            System.out.println("Ошибка: текст не должен быть пустым.");
            return;
        }

        // Ввод буквы, с которой должно начинаться слово
        System.out.print("Введите букву, с которой должны начинаться слова: ");
        String letter = scanner.nextLine().trim();

        // Проверка на пустой ввод буквы
        if (letter.isEmpty()) {
            System.out.println("Ошибка: буква не должна быть пустой.");
            return;
        }

        // Проверка на корректность ввода буквы
        if (letter.length() != 1 || !Character.isLetter(letter.charAt(0))) {
            System.out.println("Ошибка: необходимо ввести одну букву.");
            return;
        }

        // Регулярное выражение для поиска слов, начинающихся с заданной буквы
        Pattern pattern = Pattern.compile("\\b" + letter + "\\w*", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(text);

        // Проверка на наличие найденных слов
        boolean found = false;
        System.out.println("Слова, начинающиеся с буквы '" + letter + "':");
        while (matcher.find()) {
            System.out.println(matcher.group());
            found = true;
        }

        if (!found) {
            System.out.println("Слова, начинающиеся с указанной буквы, не найдены.");
        }
    }
}
