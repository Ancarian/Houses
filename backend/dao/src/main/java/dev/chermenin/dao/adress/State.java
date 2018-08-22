package dev.chermenin.dao.adress;


import dev.chermenin.dao.BaseObject;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "state")
@Getter
@Setter
public class State extends BaseObject {
    @Column(nullable = false, length = 20)
    private String name;
    @ManyToOne(optional = false)
    private Country country;
    @OneToMany(mappedBy = "state", fetch = FetchType.LAZY)
    private List<City> cities;
}
