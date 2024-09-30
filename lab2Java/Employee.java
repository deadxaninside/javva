public abstract class Employee {
    private String name;
    private int age;
    private double salary;

    // Статическая переменная для подсчета количества сотрудников
    private static int employeeCount = 0;

    // Конструктор по умолчанию
    public Employee() {
        this.name = "Unknown";
        this.age = 0;
        this.salary = 0;
        employeeCount++;
    }

    // Конструктор с параметрами
    public Employee(String name, int age, double salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
        employeeCount++;
    }

    // Геттеры
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getSalary() {
        return salary;
    }

    // Сеттеры
    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    // Абстрактный метод для описания работы сотрудника
    public abstract void doWork();

    // Статический метод для получения количества сотрудников
    public static int getEmployeeCount() {
        return employeeCount;
    }
}