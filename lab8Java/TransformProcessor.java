import java.util.List;
import java.util.stream.Collectors;

// TransformProcessor класс для трансформации данных.
public class TransformProcessor {

     // Метод с аннотацией @DataProcessor, который выполняет трансформацию данных.
     // @param data исходный список строк.
     // @return список строк в верхнем регистре.
    @DataProcessor
    public List<String> transformData(List<String> data) {
        return data.stream() // Преобразуем список в поток данных
                .map(String::toUpperCase) // Преобразуем каждую строку в верхний регистр
                .collect(Collectors.toList()); // Сохраняем преобразованные строки в новый список
    }
}
