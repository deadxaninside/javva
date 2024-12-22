import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

    // @DataProcessor Эта аннотация используется для пометки методов, которые обрабатывают данные.
    // Методы с этой аннотацией будут автоматически вызываться в DataManager.
@Retention(RetentionPolicy.RUNTIME) // Указывает, что аннотация доступна во время выполнения программы
@Target(ElementType.METHOD)         // Указывает, что аннотация может применяться только к методам
public @interface DataProcessor {
}
