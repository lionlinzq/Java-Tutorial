package StreamTest;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class JavaStreamApiExample {

    public static void main(String[] args) {
        // 创建示例数据
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        List<String> words = Arrays.asList("apple", "banana", "cherry", "date", "elderberry");
        List<Double> prices = Arrays.asList(2.99, 1.99, 4.99, 3.49, 0.99);
        List<Boolean> flags = Arrays.asList(true, false, true, false, true);

        class Student {
            private String name;
            private int age;

            public Student(String name, int age) {
                this.name = name;
                this.age = age;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public int getAge() {
                return age;
            }

            public void setAge(int age) {
                this.age = age;
            }
        }

        List<Student> students = Arrays.asList(
                new Student("Alice", 18),
                new Student("Bob", 21),
                new Student("Cathy", 19),
                new Student("David", 22)
        );

        // 创建流
        // 1. 将集合或数组转换为流
        Stream<Integer> stream1 = numbers.stream();
        // 2. 创建一个包含指定元素的流
        Stream<String> stream2 = Stream.of("apple", "banana", "cherry");
        // 3. 创建一个空的流
        Stream<Integer> stream3 = Stream.empty();
        // 4. 创建一个包含无限个随机数的流
        Stream<Double> stream4 = Stream.generate(Math::random);
        // 5. 创建一个包含指定个元素的流
        Stream<Integer> stream5 = Stream.iterate(1, n -> n + 1).limit(10);

        // 转换流
        // 1. 过滤符合条件的元素
        Stream<Integer> stream6 = numbers.stream().filter(n -> n % 2 == 0);
        // 2. 将元素映射为新的元素
        Stream<String> stream7 = words.stream().map(String::toUpperCase);
        // 3. 将元素映射为流，然后将多个流合并为一个流
        Stream<Character> stream8 = words.stream().flatMap(w -> w.chars().mapToObj(c -> (char) c));
        // 4. 对元素进行排序
        Stream<String> stream9 = words.stream().sorted();
        // 5. 去除重复元素
        Stream<String> stream10 = words.stream().distinct();
        // 6. 限制流的大小
        Stream<Integer> stream11 = numbers.stream().limit(3);
        // 7. 跳过指定个元素，返回剩余的元素流
        Stream<Integer> stream12 = numbers.stream().skip(2);
        // 8. 将元素按照指定条件分组
        Stream<List<Student>> stream13 = students.stream().collect(Collectors.groupingBy(Student::getAge)).values().stream();
        // 9. 将元素按照指定条件分区
        Stream<List<Student>> stream14 = students.stream().collect(Collectors.partitioningBy(s -> s.getAge() > 20)).values().stream();

        // 处理流
        // 1. 统计元素个数
        long count = numbers.stream().count();
        // 2. 返回流中的最大值
        Optional<Integer> max = numbers.stream().max(Integer::compareTo);
        // 3. 返回流中的最小值
        Optional<Integer> min = numbers.stream().min(Integer::compareTo);
        // 4. 返回流中的第一个元素
        Optional<Integer> first = numbers.stream().findFirst();
        // 5. 返回流中的任意一个元素
        Optional<Integer> any = numbers.stream().findAny();
        // 6. 判断流中是否包含指定元素
        boolean contains = words.stream().anyMatch("apple"::equals);
        // 7. 对流中的元素进行归约操作（求和、求积等）
        int sum = numbers.stream().reduce(0, Integer::sum);
        // 8. 对流中的元素进行归约操作（求平均值）
        OptionalDouble average = prices.stream().mapToDouble(Double::doubleValue).average();
        // 9. 对流中的元素进行归约操作（求最大值）
        OptionalDouble maxPrice = prices.stream().mapToDouble(Double::doubleValue).max();
        // 10. 对流中的元素进行归约操作（求最小值）
        OptionalDouble minPrice = prices.stream().mapToDouble(Double::doubleValue).min();
        // 11. 对流中的元素进行归约操作（连接字符串）
        String concat = words.stream().reduce("", (s1, s2) -> s1 + s2);
        // 12. 对流中的元素进行归约操作（连接字符串，添加分隔符）
        String join = words.stream().collect(Collectors.joining("; "));
        // 13. 将流中的元素转换为数组
        Integer[] array = numbers.stream().toArray(Integer[]::new);
        // 14. 将流中的元素转换为列表
        List<Integer> list = numbers.stream().collect(Collectors.toList());
        // 15. 将流中的元素转换为集合
//        List<Integer> set = numbers.stream().collect(Collectors.toSet());
        // 16. 将流中的元素转换为指定的集合类型
        List<Integer> linkedList = numbers.stream().collect(Collectors.toCollection(java.util.LinkedList::new));
        // 17. 将流中的元素转换为指定的映射类型
        String map = words.stream().collect(Collectors.joining(", ", "{", "}"));
        // 18. 将流中的元素进行计数
        long flagCount = flags.stream().filter(Boolean::booleanValue).count();
    }
}