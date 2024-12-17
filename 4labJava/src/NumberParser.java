import java.io.FileWriter; //для записи текста в файл
import java.io.IOException;//исключение, связанное с ошибками ввода-вывода

class CustomNumberFormatException extends Exception {
    public CustomNumberFormatException(String message) {
        super(message);
    } //конструктор принимает сообщение об ошибке
}                                       //передача сообщения, чтобы оно стало доступно



public class NumberParser {
    public static void main(String[] args) {
        String input = "123abc";  // некорректная строка для преобразования в число

        try {
            // попытка преобразовать строку в число
            int number = parseStringToInt(input);
            System.out.println("Преобразованное число: " + number);

        } catch (CustomNumberFormatException e) {
            System.out.println("Ошибка: " + e.getMessage());
            logException(e);  // логируем информацию об исключении
        }
    }

    // Метод для преобразования строки в число с выбрасыванием CustomNumberFormatException
    public static int parseStringToInt(String input) throws CustomNumberFormatException {
        try {
            return Integer.parseInt(input);  //метод строки в число
        } catch (NumberFormatException e) {
            // Создаем и выбрасываем наше пользовательское исключение
            throw new CustomNumberFormatException("Неверный формат числа: '" + input + "'");
        }
    }

    // Метод для логирования исключений в файл
    public static void logException(Exception e) {
        String logFile = "exceptions.log";
        try (FileWriter writer = new FileWriter(logFile, true)) {
            writer.write("Исключение: " + e + "\n");
            writer.write("Сообщение: " + e.getMessage() + "\n\n");
            System.out.println("Информация об исключении записана в лог-файл.");
        } catch (IOException ioException) {
            System.out.println("Ошибка при записи в лог-файл: " + ioException.getMessage());
        }
    }
}