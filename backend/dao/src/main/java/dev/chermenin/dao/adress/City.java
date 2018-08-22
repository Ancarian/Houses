package dev.chermenin.dao.adress;


import dev.chermenin.dao.BaseObject;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "city")
@Getter
@Setter
public class City extends BaseObject {
    @Column(nullable = false, length = 10)
    private String name;
    @ManyToOne(optional = false)
    private State state;
    @OneToMany(mappedBy = "city", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Adress> adresses;
}
