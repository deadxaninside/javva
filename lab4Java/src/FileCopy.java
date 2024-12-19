import java.io.*; //для чтения и записи
public class FileCopy {
    public static void main(String[] args) {
        String firstFilePath = "source.txt";
        String secondFilePath = "destination.txt";

        copyFile(firstFilePath, secondFilePath); //основная логика копирования файла

    }

    static void copyFile(String firstFilePath, String secondFilePath) {
        FileReader firstFile = null;  //файл еще не открыт
        FileWriter secondFile = null;
        try { //блок в котором будем выполнять операции которые могут вызывать исключения
            firstFile = new FileReader(firstFilePath); //открываем исходный файл
            secondFile = new FileWriter(secondFilePath); //и конечный

            int data;  //переменная хранит код каждого считываемого символа

            while ((data = firstFile.read()) != -1) {  //считываем символы до конца файла
                secondFile.write(data); //запись в конечный файл
            }

            System.out.println("Файл успешно скопирован.");
        } catch (FileNotFoundException e) {
            System.err.println("Файл не найден");
        } catch (IOException e) {
            System.err.println("Ошибка ввода/вывода при обработке файлов");
        } finally {
            try {
                if (firstFile != null) { //проверяем были ли открыты файлы если да закрываем их освобождая ресурсы
                    firstFile.close();
                }
                if (secondFile != null) {
                    secondFile.close();
                }
            } catch (IOException e) {
                System.out.println("Ошибка при закрытии файла: " + e.getMessage());

            }
        }
    }

}
