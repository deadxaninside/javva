import java.util.concurrent.*; // Импортируем библиотеку для работы с многопоточностью

public class ArraySum {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        // Создаем массив
        int[] array = new int[100];
        for (int i = 0; i < array.length; i++) {
            array[i] = i + 1; // Заполняем массив числами от 1 до 100
        }

        // Указываем количество потоков, которые будут использоваться для вычислений
        int numberOfThreads = 4;

        // Создаем пул потоков с фиксированным количеством потоков
        ExecutorService executorService = Executors.newFixedThreadPool(numberOfThreads);
        // Пул потоков позволяет ограничить количество одновременно работающих потоков 
        // и эффективно управлять их созданием и завершением.

        // Вычисляем размер части массива, которая будет обрабатываться каждым потоком
        int chunkSize = (int) Math.ceil((double) array.length / numberOfThreads);
        // Используем Math.ceil для округления вверх, чтобы разделение было равномерным.

        // Массив для хранения задач (Future) каждого потока
        Future<Integer>[] tasks = new Future[numberOfThreads];

        // Разделяем массив на части и отправляем задачи в пул потоков
        for (int i = 0; i < numberOfThreads; i++) {
            final int start = i * chunkSize; // Начальный индекс для текущего потока
            final int end = Math.min(start + chunkSize, array.length); // Конечный индекс (не больше длины массива)

            // Отправляем задачу в пул потоков
            tasks[i] = executorService.submit(() -> {
                int sum = 0; // Локальная переменная для хранения суммы
                for (int j = start; j < end; j++) {
                    sum += array[j]; // Вычисляем сумму чисел в заданном диапазоне
                }
                return sum; // Возвращаем результат (сумму) для данного диапазона
            });
        }

        // Собираем результаты из всех задач
        int totalSum = 0;
        for (Future<Integer> task : tasks) { // Проходим по всем объектам Future
            totalSum += task.get(); // Получаем результат выполнения задачи и добавляем его к общей сумме
            // Метод get() блокирует текущий поток до завершения задачи
        }

        // Завершаем работу пула потоков
        executorService.shutdown();
        // После вызова shutdown новые задачи больше не принимаются, но текущие задачи продолжают выполняться.

        // Выводим общую сумму элементов массива
        System.out.println("Сумма элементов массива: " + totalSum);
    }
}