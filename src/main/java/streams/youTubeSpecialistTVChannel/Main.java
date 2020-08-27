package streams.youTubeSpecialistTVChannel;

import java.util.ArrayList;
import java.util.List;

//  https://www.youtube.com/watch?v=DNC6Lknn2AE
public class Main {

    public static void main(String[] args) {
        List<Person> persons = new ArrayList();
        persons.add(new Person("Sasha", 30));
        persons.add(new Person("Misha", 20));
        persons.add(new Person("Olena", 25));
        persons.add(new Person("Damir", 1));
        persons.add(new Person("Taiisia", 5));
        persons.add(new Person("Olga", 50));

//        for (Person person : persons) {
//            System.out.println(person);
//        }

//        Stream<Person> stream = persons.stream();

//        persons.stream().forEach((Person person) -> System.out.println(person));

//        persons.stream().forEach(person -> System.out.println(person));

//        persons.stream().forEach(System.out::println);

//        persons.stream()
//                .filter(person -> person.getAge() >= 18)
//                .forEach(System.out::println);

//        persons.stream()
//                .sorted((person1, person2) -> person2.getName().compareTo(person1.getName()))
//                .forEach(System.out::println);

//        persons.stream()
//                .map(person -> person.getName())
//                .sorted((personName1, personName2) -> personName1.compareTo(personName2))
//                .forEach(System.out::println);

        // find average adults age
        double averageAge = persons.stream()
                .filter(person -> person.getAge() >= 18)
                .mapToInt(person -> person.getAge())
                .average().getAsDouble();

        System.out.println(averageAge);

    }
}
