package streams.vertex_academy;

import org.apache.commons.lang3.StringUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import streams.vertex_academy.entity.Car;
import streams.vertex_academy.entity.Human;
import streams.vertex_academy.entity.User;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.*;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;

public class Practice {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private List<User> users;

    @Before
    public void setUp() {
        System.setOut(new PrintStream(outContent));

        users = asList(
                new User("John", 30),
                new User("Ames", 25),
                new User("Terry", 6),
                new User("Bruce", 60),
                new User("Taiisia", 45),
                new User("Damir", 70),
                new User("Sash", 10),
                new User("Olena", 3)
        );
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    public void sortWithCollectionsFramework() {
//        // by name
        Collections.sort(users, Comparator.comparing(User::getName));

        assertEquals("[" +
                "name = Ames, age = 25, " +
                "name = Bruce, age = 60, " +
                "name = Damir, age = 70, " +
                "name = John, age = 30, " +
                "name = Olena, age = 3, " +
                "name = Sash, age = 10, " +
                "name = Taiisia, age = 45, " +
                "name = Terry, age = 6]", Arrays.deepToString(users.toArray()));

        // by age
        Collections.sort(users, Comparator.comparingInt(User::getAge));

        assertEquals("[" +
                "name = Olena, age = 3, " +
                "name = Terry, age = 6, " +
                "name = Sash, age = 10, " +
                "name = Ames, age = 25, " +
                "name = John, age = 30, " +
                "name = Taiisia, age = 45, " +
                "name = Bruce, age = 60, " +
                "name = Damir, age = 70]", Arrays.deepToString(users.toArray()));

        // reverse
        Collections.sort(users, Comparator.comparingInt(User::getAge).reversed());

        assertEquals("[" +
                "name = Damir, age = 70, " +
                "name = Bruce, age = 60, " +
                "name = Taiisia, age = 45, " +
                "name = John, age = 30, " +
                "name = Ames, age = 25, " +
                "name = Sash, age = 10, " +
                "name = Terry, age = 6, " +
                "name = Olena, age = 3]", Arrays.deepToString(users.toArray()));
    }

    @Test
    public void withListSort() {
        users.sort(Comparator.comparing(User::getName));

        assertEquals("[" +
                "name = Ames, age = 25, " +
                "name = Bruce, age = 60, " +
                "name = Damir, age = 70, " +
                "name = John, age = 30, " +
                "name = Olena, age = 3, " +
                "name = Sash, age = 10, " +
                "name = Taiisia, age = 45, " +
                "name = Terry, age = 6]", Arrays.deepToString(users.toArray()));

        // reverse
        users.sort(Comparator.comparing(User::getName).reversed());

        assertEquals("[" +
                "name = Terry, age = 6, " +
                "name = Taiisia, age = 45, " +
                "name = Sash, age = 10, " +
                "name = Olena, age = 3, " +
                "name = John, age = 30, " +
                "name = Damir, age = 70, " +
                "name = Bruce, age = 60, " +
                "name = Ames, age = 25]", Arrays.deepToString(users.toArray()));
    }

    @Test
    public void forEachWithList() {
//        users.forEach(user -> System.out.println(user));
        users.forEach(System.out::println);

        assertEquals("" +
                "name = John, age = 30\r\n" +
                "name = Ames, age = 25\r\n" +
                "name = Terry, age = 6\r\n" +
                "name = Bruce, age = 60\r\n" +
                "name = Taiisia, age = 45\r\n" +
                "name = Damir, age = 70\r\n" +
                "name = Sash, age = 10\r\n" +
                "name = Olena, age = 3\r\n", outContent.toString());
    }

    @Test
    public void forEachWithSet() {
        // given
        Set<User> userHashSet = new LinkedHashSet<>(users);

        // when
        userHashSet.forEach(System.out::println);

        // then
        assertEquals("" +
                "name = John, age = 30\r\n" +
                "name = Ames, age = 25\r\n" +
                "name = Terry, age = 6\r\n" +
                "name = Bruce, age = 60\r\n" +
                "name = Taiisia, age = 45\r\n" +
                "name = Damir, age = 70\r\n" +
                "name = Sash, age = 10\r\n" +
                "name = Olena, age = 3\r\n", outContent.toString());
    }

    @Test
    public void forEachWithMap() {
        // given
        Map<Integer, User> userMap = new LinkedHashMap<>();
        for (int i = 0; i < users.size(); i++) {
            userMap.put(i, users.get(i));
        }

        // when
        userMap.forEach((k, v) -> System.out.println(userMap.get(k)));

        // then
        assertEquals("" +
                "name = John, age = 30\r\n" +
                "name = Ames, age = 25\r\n" +
                "name = Terry, age = 6\r\n" +
                "name = Bruce, age = 60\r\n" +
                "name = Taiisia, age = 45\r\n" +
                "name = Damir, age = 70\r\n" +
                "name = Sash, age = 10\r\n" +
                "name = Olena, age = 3\r\n", outContent.toString());
    }

    @Test
    public void function() {
        // given
        ToIntFunction<Integer> toInteger = string -> Integer.parseInt(String.valueOf(string));

        // when
        Integer integer = toInteger.applyAsInt(Integer.valueOf("5"));

        // then
        assertEquals(Integer.valueOf(5), integer);
    }

    @Test
    public void filterWithForEach() {
        // given
        Stream<User> stream = users.stream();

        // when
        Stream<User> userStreamAfterFilter = stream.filter(user -> user.getAge() > 30);
        userStreamAfterFilter.forEach(System.out::println);

        // then
        assertEquals("" +
                "name = Bruce, age = 60\r\n" +
                "name = Taiisia, age = 45\r\n" +
                "name = Damir, age = 70\r\n", outContent.toString());
    }

    @Test
    public void filterWithCount() {
        // given
        Stream<User> stream = users.stream();

        // when
        Stream<User> userStreamAfterFilter = stream.filter(user -> user.getAge() > 30);
        long count = userStreamAfterFilter.count();

        // then
        assertEquals(3, count);
    }

    @Test
    public void filterWithMultipleConditions() {
        // when
        users.stream()
                .filter(user -> user.getAge() > 30 ||
                        user.getName().startsWith("T"))
                .forEach(System.out::println);

        // then
        assertEquals("" +
                "name = Terry, age = 6\r\n" +
                "name = Bruce, age = 60\r\n" +
                "name = Taiisia, age = 45\r\n" +
                "name = Damir, age = 70\r\n", outContent.toString());
    }

    @Test
    public void multiplyIntegers() {
        // when
        users.stream()
                .map(user -> user.getAge())
                .forEach(System.out::println);

        // then
        assertEquals("" +
                "30\r\n" +
                "25\r\n" +
                "6\r\n" +
                "60\r\n" +
                "45\r\n" +
                "70\r\n" +
                "10\r\n" +
                "3\r\n", outContent.toString());
    }

    @Test
    public void capitalizeStringsWithStreamMap() {
        // when
        users.stream()
                .map(user -> user.getName())
                .map(StringUtils::reverse)
                .forEach(System.out::println);

        // then
        assertEquals("nhoJ\r\n" +
                "semA\r\n" +
                "yrreT\r\n" +
                "ecurB\r\n" +
                "aisiiaT\r\n" +
                "rimaD\r\n" +
                "hsaS\r\n" +
                "anelO\r\n", outContent.toString());
    }

    @Test
    public void filterWithStreamMap() {
        // given
        List<Car> cars = asList(
                new Car("AA1111BX", 2007),
                new Car("AK5555IT", 2010),
                new Car(null, 2012),
                new Car("", 2015),
                new Car("AI3838PP", 2017));

        // when
        cars.stream()
                .filter(car -> car.getYear() > 2010) // выбираем только машины, выпущенные после 2010 года
                .map(Car::getNumber) // преобразовываем Машины в номера, теперь у нас Stream номеров машин
                .filter(s -> s != null && !s.isEmpty()) // выбираем только не пустые номера
                .forEach(System.out::print); // выводим результат

        // then
        assertEquals("AI3838PP", outContent.toString());
    }

    @Test
    public void collectIntoList() {
        // given
        List<Integer> numbers = asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // when
        List<Integer> evenNumbers = numbers.stream()
                .filter(number -> (number & 1) == 0)
                .collect(Collectors.toList());

        // then
        assertEquals("[2, 4, 6, 8, 10]", evenNumbers.toString());
    }

    @Test
    public void collectIntoSet() {
        // when
        Set<String> set = users.stream()
                .map(user -> user.getName())
                .filter(name -> name.startsWith("T"))
                .map(String::toUpperCase)
                .collect(Collectors.toSet());

        // then
        assertEquals("[TAIISIA, TERRY]", set.toString());
    }

    @Test
    public void groupingByProperty() {
        // given
        List<Human> humans = asList(
                new Human("Ned", "Stark", 1),
                new Human("Robb", "Stark", 2),
                new Human("Arya", "Stark", 1),
                new Human("Aegon", "Targaryen", 6),
                new Human("Daenerys", "Targaryen", 4),
                new Human("Jaime", "Lannister", 1),
                new Human("Tyrion", "Lannister", 3));

        // when
        Map<String, List<Human>> collect = humans.stream()
                .collect(Collectors.groupingBy(Human::getSurname));

        // then
        assertEquals("{" +
                        "Lannister=[Human(" +
                        "name=Jaime, surname=Lannister, friendsAmount=1), Human(" +
                        "name=Tyrion, surname=Lannister, friendsAmount=3)], " +
                        "Targaryen=[Human(" +
                        "name=Aegon, surname=Targaryen, friendsAmount=6), Human(" +
                        "name=Daenerys, surname=Targaryen, friendsAmount=4)], " +
                        "Stark=[Human(" +
                        "name=Ned, surname=Stark, friendsAmount=1), Human(" +
                        "name=Robb, surname=Stark, friendsAmount=2), Human(" +
                        "name=Arya, surname=Stark, friendsAmount=1)]}",
                collect.toString());
    }

    @Test
    public void groupingByPropertyAndCount() {
        // given
        List<Human> humans = asList(
                new Human("Ned", "Stark", 1),
                new Human("Robb", "Stark", 2),
                new Human("Arya", "Stark", 1),
                new Human("Aegon", "Targaryen", 6),
                new Human("Daenerys", "Targaryen", 4),
                new Human("Jaime", "Lannister", 1),
                new Human("Tyrion", "Lannister", 3));

        // when
        Map<String, Long> collect = humans.stream()
                .collect(Collectors.groupingBy(Human::getSurname,
                        Collectors.counting()));

        // then
        assertEquals("{" +
                "Lannister=2, " +
                "Targaryen=2, " +
                "Stark=3}", collect.toString());
    }

    @Test
    public void groupingByPropertyAndSum() {
        // given
        List<Human> humans = asList(
                new Human("Ned", "Stark", 1),
                new Human("Robb", "Stark", 2),
                new Human("Arya", "Stark", 1),
                new Human("Aegon", "Targaryen", 6),
                new Human("Daenerys", "Targaryen", 4),
                new Human("Jaime", "Lannister", 1),
                new Human("Tyrion", "Lannister", 3));

        // when
        Map<String, Integer> collect = humans.stream()
                .collect(Collectors.groupingBy(Human::getSurname,
                        Collectors.summingInt(Human::getFriendsAmount)));

        // then
        assertEquals("{" +
                "Lannister=4, " +
                "Targaryen=10, " +
                "Stark=4}", collect.toString());
    }

    @Test
    public void groupingByPropertyAndMappingToCollection() {
        // given
        List<Human> humans = asList(
                new Human("Ned", "Stark", 1),
                new Human("Robb", "Stark", 2),
                new Human("Arya", "Stark", 1),
                new Human("Aegon", "Targaryen", 6),
                new Human("Daenerys", "Targaryen", 4),
                new Human("Jaime", "Lannister", 1),
                new Human("Tyrion", "Lannister", 3));

        // when
        Map<String, Set<String>> collect = humans.stream()
                .collect(Collectors.groupingBy(Human::getSurname,
                        Collectors.mapping(Human::getName, Collectors.toSet())));

        // then
        assertEquals("{" +
                "Lannister=[Jaime, Tyrion], " +
                "Targaryen=[Aegon, Daenerys], " +
                "Stark=[Arya, Robb, Ned]}", collect.toString());
    }

    @Test
    public void flatMap() {
        // given
        List<Human> humans = asList(
                new Human("Sam", asList("Buddy", "Lucy")),
                new Human("Bob", asList("Frankie", "Rosie")),
                new Human("Marta", asList("Simba", "Tilly")));

        // when
        humans.stream()
                                            //преобразовываем Stream<Human> в Stream<List<Pet>>
                .map(Human::getPets)
                                            //"разворачиваем" Stream<List<Pet>> в Stream<Pet>
                .flatMap(pets -> pets.stream())
                .forEach(System.out::println);

        // then
        assertEquals("" +
                "Buddy\r\n" +
                "Lucy\r\n" +
                "Frankie\r\n" +
                "Rosie\r\n" +
                "Simba\r\n" +
                "Tilly\r\n", outContent.toString());

    // SECOND WAY
        List<java.lang.String> collect = humans.stream()
                .flatMap(human -> human.getPets().stream())
                .collect(Collectors.toList());

        assertEquals("[Buddy, Lucy, Frankie, Rosie, Simba, Tilly]", collect.toString());
    }

    @Test
    public void flatMapWithPrimitives() {
        // given
        int[][] arr = {{1, 2}, {3, 4}, {5, 6}};

        // when
        int[] ints = Arrays.stream(arr)
                .flatMapToInt(Arrays::stream)
                .toArray();

        // then
        assertEquals("[1, 2, 3, 4, 5, 6]", Arrays.toString(ints));
    }



}