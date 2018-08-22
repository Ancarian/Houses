package dev.chermenin.dao.adress;


import dev.chermenin.dao.BaseObject;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "adress")
@Getter
@Setter
public class Adress extends BaseObject {
    @Column(nullable = false, length = 20)
    private String adress;
    @ManyToOne(optional = false)
    private City city;
}
