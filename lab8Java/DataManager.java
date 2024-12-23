import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;


 //DataManager класс отвечает за управление данными:
 // Загрузка данных из источника
 // Регистрация обработчиков данных.
 // Обработка данных с использованием многопоточности.
 // Сохранение обработанных данных в новый источник

public class DataManager {
    // Список зарегистрированных обработчиков данных
    private final List<Object> processors = new ArrayList<>();

    // Пул потоков для параллельной обработки данных
    private final ExecutorService executorService = Executors.newFixedThreadPool(4);

    // Исходные данные
    private List<String> rawData = new ArrayList<>();

    // Обработанные данные
    private List<String> processedData = new ArrayList<>();

     // Регистрация обработчика данных.
     // @param processor объект обработчика, содержащий методы с аннотацией @DataProcessor.
    public void registerDataProcessor(Object processor) {
        processors.add(processor);
    }

    // Загрузка данных из источника.
    //  путь к файлу, из которого загружаются данные.
    // если произошла ошибка при чтении файла.
    public void loadData(String source) throws IOException {
        rawData = Files.readAllLines(Path.of(source)); // Читаем строки из файла
        System.out.println("Данные загружены: " + rawData);
    }


     // Обработка данных.
     // Находит все методы с аннотацией @DataProcessor в зарегистрированных обработчиках
     // и запускает их параллельно с использованием потоков.
     //  если выполнение потоков прервано.
    public void processData() throws InterruptedException {
        for (Object processor : processors) {
            for (var method : processor.getClass().getDeclaredMethods()) {
                if (method.isAnnotationPresent(DataProcessor.class)) { // Проверяем наличие аннотации
                    executorService.submit(() -> { // Запускаем метод в отдельном потоке
                        try {
                            // Выполняем метод обработки данных
                            processedData = (List<String>) method.invoke(processor, rawData);
                            System.out.println("Обработано методом: " + method.getName());
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    });
                }
            }
        }
        // Ждем завершения всех потоков
        executorService.shutdown();
        executorService.awaitTermination(10, TimeUnit.SECONDS);
    }

    // Сохранение обработанных данных в файл.
    //  путь к файлу, куда будут сохранены обработанные данные.
    // если произошла ошибка при записи в файл.
    public void saveData(String destination) throws IOException {
        Files.write(Path.of(destination), processedData, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
        System.out.println("Обработанные данные сохранены в: " + destination);
    }
}
