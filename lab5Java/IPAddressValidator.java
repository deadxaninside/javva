import java.util.regex.*;
import java.util.Scanner;

public class IPAddressValidator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ввод IP-адреса
        System.out.print("Введите IP-адрес: ");
        String ipAddress = scanner.nextLine().trim();

        // Проверка на пустой ввод
        if (ipAddress.isEmpty()) {
            System.out.println("Ошибка: IP-адрес не должен быть пустым.");
            return;
        }

        // Регулярное выражение для проверки корректности IP-адреса
        Pattern pattern = Pattern.compile("^((25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$");
        Matcher matcher = pattern.matcher(ipAddress);

        // Проверка на соответствие формату IP-адреса
        if (matcher.matches()) {
            System.out.println("IP-адрес корректен.");
        } else {
            System.out.println("Ошибка: введен некорректный IP-адрес.");
        }
    }
}