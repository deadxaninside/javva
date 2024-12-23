import java.util.concurrent.*; // Импортируем пакет для работы с многопоточностью

// Основной класс программы
public class MatrixMax {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        // Определяем матрицу, в которой нужно найти максимальный элемент
        int[][] matrix = {
                {1, 5, 9},
                {2, 8, 3},
                {4, 6, 7}
        };

        int numThreads = 3; // Указываем количество потоков 
        ExecutorService executor = Executors.newFixedThreadPool(numThreads); // Создаём пул потоков
        Future<Integer>[] results = new Future[numThreads]; // Массив для хранения результатов выполнения потоков

        // Запускаем задачу поиска максимума для каждой строки
        for (int i = 0; i < matrix.length; i++) {
            results[i] = executor.submit(new MaxTask(matrix[i])); // Передаём строку в задачу MaxTask
        }

        int globalMax = Integer.MIN_VALUE; // Инициализируем глобальный максимум минимально возможным значением
        for (Future<Integer> result : results) {
            globalMax = Math.max(globalMax, result.get()); // Получаем результат из потока и обновляем глобальный максимум
        }

        executor.shutdown(); // Завершаем работу пула потоков
        System.out.println("Maximum Element: " + globalMax); // Выводим максимальный элемент матрицы
    }
}

// Класс, реализующий интерфейс Callable, выполняет задачу поиска максимума в строке матрицы
class MaxTask implements Callable<Integer> {
    private int[] row; // Строка матрицы, в которой ищем максимум

    // Конструктор принимает строку матрицы
    public MaxTask(int[] row) {
        this.row = row;
    }

    @Override
    public Integer call() {
        int max = Integer.MIN_VALUE; // Инициализируем локальный максимум минимально возможным значением
        for (int num : row) {
            max = Math.max(max, num); // Ищем максимальный элемент в строке
        }
        return max; // Возвращаем найденный максимум
    }
}
