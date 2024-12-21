public class Main {
    public static class Stack<T> {
        private T[] data; // массив для хранения элементов стека
        private int size; // текущий размер стека

        // Конструктор, инициализирующий стек с указанной емкостью
        public Stack(int capacity) {
            data = (T[]) new Object[capacity]; // создание массива обобщенного типа
            size = 0; // начальный размер стека
        }

        // Метод для добавления элемента в стек
        public void push(T element) {
            if (size == data.length) {
                throw new StackOverflowError("Стек переполнен"); // проверка на переполнение
            }
            data[size++] = element; // добавление элемента и увеличение размера
        }

        // Метод для удаления элемента из стека
        public T pop() {
            if (isEmpty()) {
                throw new IllegalStateException("Стек пуст"); // проверка на пустоту
            }
            T element = data[--size]; // получение верхнего элемента
            data[size] = null; // удаление ссылки для освобождения памяти
            return element; // возврат элемента
        }

        // Метод для получения верхнего элемента стека без его удаления
        public T peek() {
            if (isEmpty()) {
                throw new IllegalStateException("Стек пуст"); // проверка на пустоту
            }
            return data[size - 1]; // возврат верхнего элемента
        }

        // Метод для проверки, пуст ли стек
        public boolean isEmpty() {
            return size == 0; // если размер стека равен 0, значит стек пуст
        }

        // Метод для получения текущего размера стека
        public int size() {
            return size; // возврат текущего размера
        }
    }

    // Метод main для тестирования
    public static void main(String[] args) {
        // Создаем стек с емкостью 10
        Stack<Integer> stack = new Stack<>(10);

        // Добавляем элементы в стек
        stack.push(1);
        stack.push(2);
        stack.push(3);

        // Удаляем верхний элемент и выводим его
        System.out.println("Pop: " + stack.pop()); // 3

        // Получаем верхний элемент без удаления и выводим его
        System.out.println("Peek: " + stack.peek()); // 2

        // Добавляем новый элемент
        stack.push(4);

        // Удаляем верхний элемент и выводим его
        System.out.println("Pop: " + stack.pop()); // 4

        // Вывод текущего размера стека
        System.out.println("Current size: " + stack.size()); // 2
    }
}