import java.util.List;
import java.util.stream.Collectors;

 // AggregateProcessor класс для объединения строк.
public class AggregateProcessor {

    //Метод с аннотацией @DataProcessor, который выполняет объединение данных.
     // @param data исходный список строк.
     //@return список с одной строкой, представляющей объединение всех строк.

    @DataProcessor
    public List<String> aggregateData(List<String> data) {
        // Объединяем строки в одну, разделяя их символом "; "
        String aggregated = data.stream().collect(Collectors.joining("; "));
        return List.of(aggregated); // Возвращаем список с одной строкой
    }
}
