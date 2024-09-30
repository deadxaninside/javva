import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Создание сотрудников
        Employee admin = new Administrator("Иван", 30, 70000, "Отдел продаж");
        Employee programmer = new Programmer("Анна", 25, 300000, "Java");
        Employee manager = new Manager("Илья", 40, 100000, "Команда разработки");

        // Вывод информации о сотрудниках
        System.out.println("Информация о сотрудниках:");
        System.out.println("Имя: " + admin.getName() + ", Возраст: " + admin.getAge() + ", Зарплата: " + admin.getSalary());
        admin.doWork();

        System.out.println("Имя: " + programmer.getName() + ", Возраст: " + programmer.getAge() + ", Зарплата: " + programmer.getSalary());
        programmer.doWork();

        System.out.println("Имя: " + manager.getName() + ", Возраст: " + manager.getAge() + ", Зарплата: " + manager.getSalary());
        manager.doWork(); // Вызов метода без аргументов

        // Вывод количества сотрудников
        System.out.println("\nВсего сотрудников: " + Employee.getEmployeeCount());

        scanner.close();
    }
}

