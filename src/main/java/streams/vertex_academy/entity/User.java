package streams.vertex_academy.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
//@ToString(of = {"name", "age"})
public class User {

    private String name;
    private int age;

    @Override
    public String toString() {
        return "name = " + name + ", age = " + age;
    }
}