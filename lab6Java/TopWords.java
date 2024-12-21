import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class TopWords {
    public static void main(String[] args) {
        // Указываем путь к файлу
        String filePath = "text";

        // Создаем объект File
        File file = new File(filePath);

        // Создаем объект Scanner для чтения файла
        Scanner scanner = null;
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        // Создаем Map для хранения слов и их количества
        Map<String, Integer> wordCount = new HashMap<>();

        // Читаем файл построчно, затем разбиваем строки на слова
        while (scanner != null && scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] words = line.split("\\s+");

            for (String word : words) {
                // Убираем знаки пунктуации и приводим к нижнему регистру
                word = word.replaceAll("[^a-zA-Zа-яА-Я]", "").toLowerCase();
                if (!word.isEmpty()) {
                    // Увеличиваем счетчик для слова
                    wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
                }
            }
        }

        // Закрываем Scanner
        if (scanner != null) {
            scanner.close();
        }

        // Создаем список из Map для сортировки
        List<Map.Entry<String, Integer>> sortedWords = new ArrayList<>(wordCount.entrySet());

        // Сортируем по убыванию значений
        sortedWords.sort((o1, o2) -> o2.getValue().compareTo(o1.getValue()));

        // Выводим топ-10 самых частых слов
        System.out.println("Топ-10 самых частых слов:");
        for (int i = 0; i < Math.min(10, sortedWords.size()); i++) {
            Map.Entry<String, Integer> entry = sortedWords.get(i);
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
    }
}
