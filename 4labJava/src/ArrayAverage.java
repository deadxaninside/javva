public class ArrayAverage {
    public static void main(String[] args) {
        int[] arr ={1, 2, 4, 6, 8}; //массив целых чисел
        int sum = 0;

        try {
            // Вычисляем сумму элементов массива
            for (int i = 0; i < arr.length; i++) {
                sum += arr[i];
            }

            // Вычисляем и выводим среднее значение
            double average = (double) sum / arr.length;
            System.out.println("Среднее арифметическое: " + average);

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Ошибка: Выход за границы массива. " + e.getMessage());

        } finally {
            System.out.println("Операция завершена.");
        }
    }
}