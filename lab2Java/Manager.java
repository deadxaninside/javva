public class Manager extends Employee {
    private String teamName;

    // Конструктор по умолчанию
    public Manager() {
        super();
        this.teamName = "Unknown";
    }

    // Конструктор с параметрами
    public Manager(String name, int age, double salary, String teamName) {
        super(name, age, salary);
        this.teamName = teamName;
    }

    // Геттер
    public String getTeamName() {
        return teamName;
    }

    // Сеттер
    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    // Перегруженный метод doWork()
    public void doWork() {
        System.out.println("Менеджер " + getName() + " руководит командой " + teamName);
    }

    // Перегруженный метод doWork() с дополнительным параметром
    public void doWork(String task) {
        System.out.println("Менеджер " + getName() + " выполняет задачу " + task + " для команды " + teamName);
    }
}
