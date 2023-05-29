package StreamTest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.junit.Test;

import java.util.*;
import java.util.stream.*;

public class StreamAPITest {

    // 示例数据
    List<String> stringList = Arrays.asList("apple", "banana", "orange", "peach", "kiwi");
    List<Integer> intList = Arrays.asList(1, 2, 3, 4, 5);
    List<Double> doubleList = Arrays.asList(1.1, 2.2, 3.3, 4.4, 5.5);

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    class Person {
        private String name;
        private int age;
    }

    List<Person> personList = Arrays.asList(
            new Person("Tom", 25),
            new Person("Jerry", 30),
            new Person("Mike", 20),
            new Person("John", 35),
            new Person("Lucy", 28)
    );

    /**
     * forEach：对流中的每个元素执行指定的操作
     */
    @Test
    public void testForEach() {
        stringList.stream().forEach(System.out::println);
    }

    /**
     * map：对流中的每个元素执行指定的操作，返回包含操作结果的新流
     */
    @Test
    public void testMap() {
        Stream<String> stringStream = stringList.stream().map(String::toUpperCase);
        stringStream.forEach(System.out::println);
    }

    /**
     * flatMap：对流中的每个元素执行指定的操作，返回包含操作结果的新流，并将所有新流中的元素合并为一个新流
     */
    @Test
    public void testFlatMap() {
        Stream<String> stringStream = Stream.of("hello world", "welcome to Java");
        Stream<String> flatMapStream = stringStream.flatMap(str -> Stream.of(str.split(" ")));
        flatMapStream.forEach(System.out::println);
    }

    /**
     * filter：根据指定的条件过滤流中的元素，返回符合条件的元素组成的新流
     */
    @Test
    public void testFilter() {
        Stream<Integer> intStream = intList.stream().filter(i -> i % 2 == 0);
        intStream.forEach(System.out::println);
    }

    /**
     * distinct：去除流中的重复元素，返回去重后的新流
     */
    @Test
    public void testDistinct() {
        Stream<Integer> intStream = Stream.of(1, 2, 3, 2, 1, 4, 5);
        Stream<Integer> distinctStream = intStream.distinct();
        distinctStream.forEach(System.out::println);
    }

    /**
     * sorted：对流中的元素进行排序，返回排序后的新流
     */
    @Test
    public void testSorted() {
        Stream<Double> doubleStream = doubleList.stream().sorted(Comparator.reverseOrder());
        doubleStream.forEach(System.out::println);
    }

    /**
     * peek：对流中的每个元素执行指定的操作，返回原流
     */
    @Test
    public void testPeek() {
        Stream<Person> personStream = personList.stream().peek(p -> p.setAge(p.getAge() + 1));
        personStream.forEach(System.out::println);
    }

    /**
     * limit：截取流中的前n个元素，返回截取后的新流
     */
    @Test
    public void testLimit() {
        Stream<String> stringStream = stringList.stream().limit(3);
        stringStream.forEach(System.out::println);
    }

    /**
     * skip：跳过流中的前n个元素，返回剩余元素组成的新流
     */
    @Test
    public void testSkip() {
        Stream<String> stringStream = stringList.stream().skip(2);
        stringStream.forEach(System.out::println);
    }

    /**
     * reduce：求流中的元素的聚合结果
     */
    @Test
    public void testReduce() {
        List<Integer> list1 = Arrays.asList(3, 1, 4, 1, 5, 9, 2, 6, 5, 3, 5);
        Integer reduce = list1.stream().reduce(Integer::max).orElse(0);
        System.out.println(reduce);


        List<Integer> list = Arrays.asList(1, 3, 2, 8, 11, 4);
        // 求和方式1
        Optional<Integer> sum = list.stream().reduce((x, y) -> x + y);
        // 求和方式2
        Optional<Integer> sum2 = list.stream().reduce(Integer::sum);
        // 求和方式3
        Integer sum3 = list.stream().reduce(0, Integer::sum);

        // 求乘积
        Optional<Integer> product = list.stream().reduce((x, y) -> x * y);

        // 求最大值方式1
        Optional<Integer> max = list.stream().reduce((x, y) -> x > y ? x : y);
        // 求最大值写法2
        Integer max2 = list.stream().reduce(1, Integer::max);

        System.out.println("list求和：" + sum.get() + "," + sum2.get() + "," + sum3);
        System.out.println("list求积：" + product.get());
        System.out.println("list求和：" + max.get() + "," + max2);
    }

    /**
     * count：统计流中元素的个数
     */
    @Test
    public void testCount() {
        long count = stringList.stream().count();
        System.out.println(count);
    }

    /**
     * anyMatch：判断流中是否存在满足指定条件的元素
     */
    @Test
    public void testAnyMatch() {
        boolean anyMatch = personList.stream().anyMatch(p -> p.getAge() > 30);
        System.out.println(anyMatch);
    }

    /**
     * allMatch：判断流中所有元素是否都满足指定条件
     */
    @Test
    public void testAllMatch() {
        boolean allMatch = personList.stream().allMatch(p -> p.getName().length() > 2);
        System.out.println(allMatch);
    }

    /**
     * noneMatch：判断流中是否不存在满足指定条件的元素
     */
    @Test
    public void testNoneMatch() {
        boolean noneMatch = personList.stream().noneMatch(p -> p.getName().startsWith("Z"));
        System.out.println(noneMatch);
    }

    /**
     * findFirst：返回流中的第一个元素
     */
    @Test
    public void testFindFirst() {
        Optional<String> first = stringList.stream().findFirst();
        System.out.println(first.get());
    }

    /**
     * findAny：返回流中的任意一个元素
     */
    @Test
    public void testFindAny() {
        Optional<String> any = stringList.stream().findAny();
        System.out.println(any.get());
    }

    /**
     * max：返回流中的最大元素
     */
    @Test
    public void testMax() {
        Optional<Integer> max = intList.stream().max(Integer::compare);
        System.out.println(max.get());
    }

    /**
     * min：返回流中的最小元素
     */
    @Test
    public void testMin() {
        Optional<Integer> min = intList.stream().min(Integer::compare);
        System.out.println(min.get());
    }

    /**
     * forEachOrdered：对流中的每个元素执行指定的操作，并保证顺序
     */
    @Test
    public void testForEachOrdered() {
        intList.stream().parallel().forEachOrdered(System.out::println);
    }

    /**
     * toArray：将流中的元素转换为数组
     */
    @Test
    public void testToArray() {
        Object[] array = stringList.stream().toArray();
        System.out.println(Arrays.toString(array));
    }

    /**
     * collect：将流中的元素收集到指定的集合中
     */
    @Test
    public void testCollect() {
        List<String> list = stringList.stream().collect(Collectors.toList());
        System.out.println(list);
    }

    /**
     * partitioningBy：按照指定条件将流中元素分为两组
     */
    @Test
    public void testPartitioningBy() {
        Map<Boolean, List<Person>> map = personList.stream().collect(Collectors.partitioningBy(p -> p.getAge() > 25));
        System.out.println(map);
    }

    /**
     * groupingBy：按照指定条件将流中元素分组
     */
    @Test
    public void testGroupingBy() {
        Map<String, List<Person>> map = personList.stream().collect(Collectors.groupingBy(Person::getName));
        System.out.println(map);
    }

    /**
     * counting：统计流中元素的个数
     */
    @Test
    public void testCounting() {
        long count = stringList.stream().collect(Collectors.counting());
        System.out.println(count);
    }

    /**
     * averagingInt：求流中元素的平均值
     */
    @Test
    public void testAveragingInt() {
        double avg = personList.stream().collect(Collectors.averagingInt(Person::getAge));
        System.out.println(avg);
    }

    /**
     * summingInt：求流中元素的总和
     */
    @Test
    public void testSummingInt() {
        int sum = personList.stream().collect(Collectors.summingInt(Person::getAge));
        System.out.println(sum);
    }

    /**
     * summarizingInt：对流中元素进行统计
     */
    @Test
    public void testSummarizingInt() {
        IntSummaryStatistics summary = personList.stream().collect(Collectors.summarizingInt(Person::getAge));
        System.out.println(summary);
    }

    /**
     * joining：将流中的元素拼接成字符串
     */
    @Test
    public void testJoining() {
        String str = stringList.stream().collect(Collectors.joining(","));
        System.out.println(str);
    }

    /**
     * toMap：将流中的元素转换为Map
     */
    @Test
    public void testToMap() {
        Map<String, Integer> map = personList.stream().collect(Collectors.toMap(Person::getName, Person::getAge));
        System.out.println(map);
    }
}