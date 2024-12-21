import java.util.regex.*;

public class CapitalAfterLowercase {
    public static void main(String[] args) {
        // Исходный текст
        String text = "This is a tEst Example to Find Patterns.";

        // Регулярное выражение для нахождения строчная-заглавная
        Pattern pattern = Pattern.compile("([a-z])([A-Z])");

        Matcher matcher = pattern.matcher(text);

        // Создаем новый текст с выделенными парами
        StringBuffer result = new StringBuffer();

        while (matcher.find()) {
            // Добавляем знаки "!" вокруг найденного совпадения
            matcher.appendReplacement(result, matcher.group(1) + "!" + matcher.group(2) + "!");
        }
        matcher.appendTail(result);

        System.out.println("Измененный текст:");
        System.out.println(result.toString());
    }
}