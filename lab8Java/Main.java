 // Основной класс программы
 // загружает данные из файла, обрабатывает их с использованием нескольких обработчиков и сохраняет результат в новый файл.
public class Main {
    public static void main(String[] args) {
        try {
            // Создаем экземпляр DataManager
            DataManager dataManager = new DataManager();

            // Регистрируем обработчики данных
            dataManager.registerDataProcessor(new FilterProcessor());
            dataManager.registerDataProcessor(new TransformProcessor());
            dataManager.registerDataProcessor(new AggregateProcessor());

            // Загрузка данных из входного файла
            dataManager.loadData("input.txt");

            // Обработка данных с использованием зарегистрированных обработчиков
            dataManager.processData();

            // Сохранение обработанных данных в выходной файл
            dataManager.saveData("output.txt");

        } catch (Exception e) {
            e.printStackTrace(); // Обрабатываем возможные исключения
        }
    }
}