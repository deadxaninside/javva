import java.util.List;
import java.util.stream.Collectors;


 // FilterProcessor класс для фильтрации данных.

public class FilterProcessor {

     // Метод с аннотацией @DataProcessor, который выполняет фильтрацию данных.
     // @param data исходный список строк.
     // @return список строк, содержащих слово "filter".
    @DataProcessor
    public List<String> filterData(List<String> data) {
        return data.stream() // Преобразуем список в поток данных
                .filter(line -> line.contains("filter")) // Фильтруем строки, содержащие слово "filter"
                .collect(Collectors.toList()); // Сохраняем отфильтрованные строки в новый список
    }
}
