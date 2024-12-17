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
        try {
            firstFile = new FileReader(firstFilePath);
            secondFile = new FileWriter(secondFilePath);

            int data;  //код каждого считываемого символа

            while ((data = firstFile.read()) != -1) {  //считываем символы до конца файла
                secondFile.write(data);
            }

            System.out.println("Файл успешно скопирован.");
        } catch (FileNotFoundException e) {
            System.err.println("Файл не найден");
        } catch (IOException e) {
            System.err.println("Ошибка ввода/вывода при обработке файлов");
        } finally {
            try {
                if (firstFile != null) {
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
