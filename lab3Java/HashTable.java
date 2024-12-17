import java.util.LinkedList;

public class HashTable<K, V> { //объяыляем класс
    // вложенный класс для хранения пар ключ-значение
    private static class Entry<K, V> {
        private K key;
        private V value;

        public Entry(K key, V value) { //конструктор принимающий ключ-значение
            this.key = key;
            this.value = value;
        }
        //метод для полчения ключа и значения
        public K getKey() { //получение
            return key;
        }

        public V getValue() {
            return value;
        }
        //метод для обновления значения
        public void setValue(V value) { //обновление
            this.value = value;
        }
    }

    // поля хэш таблицы
    private LinkedList<Entry<K, V>>[] table;  // массив списков для хранения пар
    private int size;  // количество элементов в таблице
    private static final int DEFAULT_CAPACITY = 16;  // начальный размер массива

    // конструктор
    public HashTable() {
        table = new LinkedList[DEFAULT_CAPACITY]; //инициализируем массив связных списков с размером по умолчанию
        size = 0;
    }

    // метод для вычисления хэш-кода ключа
    private int hash(K key) {
        return Math.abs(key.hashCode() % table.length); //проверяем остаток от деления
    } //Math.abs гарантирует, что индекс будет положительным

    // метод для добавления пары ключ-значение
    public void put(K key, V value) {
        int index = hash(key);
        if (table[index] == null) {
            table[index] = new LinkedList<>();
        } //если связного списка в данном индексе еще не существут, создаем его

        for (Entry<K, V> entry : table[index]) {
            if (entry.getKey().equals(key)) {
                entry.setValue(value);  // обновляем значение, если ключ уже существует
                return;
            }
        }

        table[index].add(new Entry<>(key, value));  // добавляем новую пару, если ключ не найден
        size++;
    }

    // метод для получения значения по ключу
    public V get(K key) {
        int index = hash(key);
        if (table[index] != null) { // если связный список существует
            for (Entry<K, V> entry : table[index]) { //проходим по всем элементам списка
                if (entry.getKey().equals(key)) { //если найден нужный ключ
                    return entry.getValue(); //возвращаем значение
                }
            }
        }
        return null;  // возвращаем null, если ключ не найден
    }

    // метод для удаления пары по ключу
    public void remove(K key) {
        int index = hash(key);
        if (table[index] != null) { // если найден ключ
            for (Entry<K, V> entry : table[index]) {  //проходим по элементам списка
                if (entry.getKey().equals(key)) { // если найден ключ
                    table[index].remove(entry); //удаляем пару
                    size--; //уменьшаем таблицу на 1
                    return; //завершаем выполнение
                }
            }
        }
    }

    // метод для получения количества элементов в таблице
    public int size() {
        return size;
    }

    // метод для проверки, пуста ли таблица
    public boolean isEmpty() {
        return size == 0; //true если колво элементов 0
    }
        //метод для тестирования таблицы
    public static void main(String[] args) {
        HashTable<String, Integer> hashTable = new HashTable<>(); //создаем экземпляр хэш-таблицы с ключами string и значениями типа Integer

        // добавление элементов
        hashTable.put("apple", 5);
        hashTable.put("banana", 3);
        hashTable.put("orange", 7);
        hashTable.put("pear", 2);

        // получение элементов
        System.out.println("apple: " + hashTable.get("apple"));  // 5
        System.out.println("banana: " + hashTable.get("banana"));  // 3
        System.out.println("pear: " + hashTable.get("pear"));  // 2
        System.out.println("orange: " + hashTable.get("orange"));  // 7

        //удаление элемента
        hashTable.remove("banana");
        System.out.println("banana: " + hashTable.get("banana"));  // null

        // проверка размера и пустоты
        System.out.println("Size: " + hashTable.size());  // 3
        System.out.println("Is empty: " + hashTable.isEmpty());  // false
    }
}