package StreamTest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamCases {

    List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
    List<String> words = Arrays.asList("apple", "banana", "cherry", "date", "elderberry");
    List<Double> prices = Arrays.asList(2.99, 1.99, 4.99, 3.49, 0.99);
    List<Boolean> flags = Arrays.asList(true, false, true, false, true);

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    class Student {
        private String name;
        private int age;

        // 构造函数和 getter/setter 方法省略
    }

    List<Student> students = Arrays.asList(
            new Student("Alice", 18),
            new Student("Bob", 19),
            new Student("Charlie", 20),
            new Student("David", 21),
            new Student("Emily", 22)
    );


    @Test
    public void initData() {
        boolean b = numbers.stream().allMatch(n -> n % 3 == 0);
        System.out.println(b);

        List<Integer> stream = numbers.stream().filter(t -> t % 2 != 0)
                .toList();
        System.out.println(stream);

    }
}
