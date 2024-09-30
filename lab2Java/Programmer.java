public class Programmer extends Employee {
    private String programmingLanguage;

    // Конструктор по умолчанию
    public Programmer() {
        super();
        this.programmingLanguage = "Unknown";
    }

    // Конструктор с параметрами
    public Programmer(String name, int age, double salary, String programmingLanguage) {
        super(name, age, salary);
        this.programmingLanguage = programmingLanguage;
    }

    // Геттер
    public String getProgrammingLanguage() {
        return programmingLanguage;
    }

    // Сеттер
    public void setProgrammingLanguage(String programmingLanguage) {
        this.programmingLanguage = programmingLanguage;
    }

    // Переопределенный метод doWork()
    @Override
    public void doWork() {
        System.out.println("Программист " + getName() + " пишет код на языке " + programmingLanguage);
    }
}
