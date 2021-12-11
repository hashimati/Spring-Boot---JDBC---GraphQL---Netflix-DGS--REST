package io.hashimati.baseApp.domains;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;



@Table("FRUITS")
public class Fruit {
    public long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    private long id;
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Fruit{" +
                "name='" + name + '\'' +
                '}';
    }

    private String name;
}
