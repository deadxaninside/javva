public class Administrator extends Employee {
    private String department;

    // Конструктор по умолчанию
    public Administrator() {
        super();
        this.department = "Unknown";
    }

    // Конструктор с параметрами
    public Administrator(String name, int age, double salary, String department) {
        super(name, age, salary);
        this.department = department;
    }

    // Геттер
    public String getDepartment() {
        return department;
    }

    // Сеттер
    public void setDepartment(String department) {
        this.department = department;
    }

    // Переопределенный метод doWork()
    @Override
    public void doWork() {
        System.out.println("Администратор " + getName() + " управляет отделом " + department);
    }
}
