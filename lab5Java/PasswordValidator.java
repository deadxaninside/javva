import java.util.regex.*;
import java.util.Scanner;

public class PasswordValidator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ввод пароля для проверки
        System.out.print("Введите пароль: ");
        String password = scanner.nextLine().trim();

        // Проверка на пустой ввод пароля
        if (password.isEmpty()) {
            System.out.println("Ошибка: пароль не должен быть пустым.");
            return;
        }

        // Регулярное выражение для проверки пароля
        // Пароль должен быть от 8 до 16 символов, содержать хотя бы одну заглавную букву, одну цифру и только латинские буквы и цифры
        Pattern pattern = Pattern.compile("^(?=.*[A-Z])(?=.*\\d)[A-Za-z\\d]{8,16}$");
        Matcher matcher = pattern.matcher(password);

        // Проверка на соответствие пароля требованиям
        if (matcher.matches()) {
            System.out.println("Пароль корректен.");
        } else {
            System.out.println("Ошибка: пароль должен быть длиной от 8 до 16 символов, содержать хотя бы одну заглавную букву и одну цифру, и состоять только из латинских букв и цифр.");
        }
    }
}
