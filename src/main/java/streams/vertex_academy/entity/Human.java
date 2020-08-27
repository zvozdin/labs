package streams.vertex_academy.entity;

import lombok.*;

import java.util.List;

@NoArgsConstructor
@Setter
@Getter
@ToString(of = {"name", "surname", "friendsAmount"})
public class Human {

    private  String name;
    private  String surname;
    private  int friendsAmount;
    private  List<String> pets;

    public Human(String name, String surname, int friendsAmount) {
        this.name = name;
        this.surname = surname;
        this.friendsAmount = friendsAmount;
    }

    public Human(String name, List<String> pets) {
        this.name = name;
        this.pets = pets;
    }
}
