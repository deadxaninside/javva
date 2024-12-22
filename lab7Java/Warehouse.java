import java.util.concurrent.*; // Импортируем пакеты для работы с многопоточностью
import java.util.*; // Импортируем пакеты для работы с коллекциями

// Класс, реализующий интерфейс Runnable, представляет грузчика
class LoaderRealization implements Runnable {
    private final List<Integer> weights; // Список товаров с их весами
    private final int maxWeight; // Максимальный вес, который грузчики могут перенести за раз
    private static final Object lock = new Object(); // Объект для синхронизации доступа к общим ресурсам
    private static int loadCounter = 1; // Счётчик загрузок для нумерации партий

    // Конструктор класса, принимающий список весов и максимальный вес
    public LoaderRealization(List<Integer> weights, int maxWeight) {
        this.weights = weights; // Список товаров
        this.maxWeight = maxWeight; // Лимит по весу
    }

    @Override
    public void run() {
        List<Integer> currentLoad = new ArrayList<>(); // Текущая партия товаров
        int currentWeight = 0; // Общий вес текущей партии

        while (true) {
            synchronized (lock) { // Блокируем доступ к списку товаров, чтобы избежать конфликтов
                if (weights.isEmpty()) { // Если товаров больше нет, выходим из цикла
                    break;
                }

                // Берём первый товар из списка
                int weight = weights.get(0);
                if (currentWeight + weight <= maxWeight) {
                    // Если вес товара вписывается в лимит, добавляем его в текущую партию
                    currentLoad.add(weight);
                    currentWeight += weight;
                    weights.remove(0); // Удаляем товар из списка
                } else if (currentLoad.isEmpty()) {
                    // Если груз слишком тяжёлый для переноса и нет текущей партии
                    System.out.println("Товар весом " + weight + " кг слишком тяжёлый для переноса.");
                    weights.remove(0); // Удаляем этот товар из списка, так как его нельзя перенести
                } else {
                    // Если текущая партия уже сформирована, выходим из цикла
                    break;
                }
            }
        }

        // Если партия сформирована, выводим информацию и запускаем процесс разгрузки
        if (!currentLoad.isEmpty()) {
            synchronized (lock) { // Синхронизируем вывод информации о загрузке
                System.out.println("Загрузка #" + loadCounter++ + ": " + currentLoad + " кг (вес: " + currentWeight + " кг).");
            }
            unload(currentLoad); // Разгружаем текущую партию
        }
    }

    // Метод для имитации разгрузки товаров
    private void unload(List<Integer> load) {
        try {
            System.out.println("Перенос товаров: " + load); // Уведомление о переносе партии
            Thread.sleep(1000); // Имитация времени, необходимого для разгрузки
            System.out.println("Разгрузка завершена: " + load); // Уведомление о завершении разгрузки
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt(); // Восстанавливаем состояние прерывания
            System.out.println("Ошибка при разгрузке."); // Выводим сообщение об ошибке
        }
    }
}

// Основной класс, управляющий процессом переноса товаров
public class Warehouse {
    public static void main(String[] args) {
        // Создаём список товаров и их весов
        List<Integer> weights = new ArrayList<>(Arrays.asList(
                40, 50, 30, 20, 70, 60, 90, 80, 10, 40, 30, 25, 35, 45
        ));

        int maxWeight = 150; // Максимальный вес, который могут перенести грузчики за одну партию
        int numberOfLoaders = 3; // Количество грузчиков

        // Создаём пул потоков, ограниченный числом грузчиков
        ExecutorService executorService = Executors.newFixedThreadPool(numberOfLoaders);

        // Запускаем работу грузчиков
        for (int i = 0; i < numberOfLoaders; i++) {
            executorService.execute(new LoaderRealization(weights, maxWeight)); // Назначаем каждому грузчику задачу
        }
        // Завершаем работу пула потоков
        executorService.shutdown();
        try {
            // Ожидаем завершения всех потоков
            executorService.awaitTermination(1, TimeUnit.HOURS);
        } catch (InterruptedException e) {
            System.out.println("Ошибка при завершении работы пула потоков."); // Обработка исключения, если пул не завершился корректно
        }

        // Сообщение о завершении работы
        System.out.println("Все товары перенесены.");
    }
}