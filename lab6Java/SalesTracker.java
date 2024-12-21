import java.util.*;

public class SalesTracker {
    // Вложенный класс для представления продажи
    private static class Sale {
        private String itemName; // Название товара
        private double itemPrice; // Цена товара

        public Sale(String itemName, double itemPrice) {
            this.itemName = itemName;
            this.itemPrice = itemPrice;
        }

        public String getItemName() {
            return itemName;
        }

        public double getItemPrice() {
            return itemPrice;
        }
    }
    private LinkedList<Sale> soldItems; // Список проданных товаров

    public SalesTracker() {
        this.soldItems = new LinkedList<>();
    }

    // Метод для добавления продажи
    public void addSale(String itemName, double itemPrice) {
        soldItems.add(new Sale(itemName, itemPrice)); // Добавляем продажу в список
    }

    // Метод для вывода всех продаж
    public void displaySales() {
        System.out.println("Список всех продаж:");
        for (Sale sale : soldItems) {
            System.out.println("Товар: " + sale.getItemName() + ", Цена: " + sale.getItemPrice());
        }
    }

    // Метод для подсчета общего количества продаж
    public int getTotalSales() {
        return soldItems.size();
    }

    // Метод для подсчета общей суммы продаж
    public double getTotalRevenue() {
        double total = 0.0;
        for (Sale sale : soldItems) {
            total += sale.getItemPrice(); // Суммируем цену каждого проданного товара
        }
        return total;
    }

    // Метод для определения самого популярного товара
    public String getMostPopularItem() {
        Map<String, Integer> frequencyMap = new HashMap<>();
        for (Sale sale : soldItems) {
            String itemName = sale.getItemName();
            frequencyMap.put(itemName, frequencyMap.getOrDefault(itemName, 0) + 1);
        }

        String mostPopular = null;
        int maxCount = 0;

        for (Map.Entry<String, Integer> entry : frequencyMap.entrySet()) {
            if (entry.getValue() > maxCount) {
                mostPopular = entry.getKey();
                maxCount = entry.getValue();
            }
        }

        return mostPopular;
    }
    public static void main(String[] args) {
        SalesTracker tracker = new SalesTracker();

        // Добавляем продажи
        tracker.addSale("Яблоко", 50.0);
        tracker.addSale("Апельсин", 30.0);
        tracker.addSale("Яблоко", 50.0);
        tracker.addSale("Банан", 25.0);
        tracker.addSale("Апельсин", 30.0);
        tracker.addSale("Яблоко", 50.0);

        // Выводим список всех продаж
        tracker.displaySales();

        // Общая информация о продажах
        System.out.println("\nОбщее количество продаж: " + tracker.getTotalSales());
        System.out.println("Общая сумма продаж: " + tracker.getTotalRevenue());
        System.out.println("Самый популярный товар: " + tracker.getMostPopularItem());
    }
}