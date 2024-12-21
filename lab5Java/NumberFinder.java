import java.util.regex.*;
import java.util.Scanner;

public class NumberFinder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ввод текста для поиска чисел
        System.out.print("Введите текст: ");
        String text = scanner.nextLine().trim();

        // Проверка на пустой ввод текста
        if (text.isEmpty()) {
            System.out.println("Ошибка: текст не должен быть пустым.");
            return;
        }

        // Регулярное выражение для поиска чисел (целых и дробных)
        Pattern pattern = Pattern.compile("\\d+(\\.\\d+)?");
        Matcher matcher = pattern.matcher(text);

        boolean found = false;
        System.out.println("Найденные числа:");

        // Поиск чисел в тексте
        while (matcher.find()) {
            System.out.println(matcher.group());
            found = true;
        }

        // Если чисел не найдено, выводим сообщение
        if (!found) {
            System.out.println("Числа в тексте не найдены.");
        }
    }
}
