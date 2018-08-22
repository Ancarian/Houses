package dev.chermenin.dao;


import dev.chermenin.dao.adress.Adress;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "post")
@Getter
@Setter
@NamedEntityGraphs({
        @NamedEntityGraph(name = "allJoins", attributeNodes = {
                @NamedAttributeNode(value = "adress"),
        }),
        @NamedEntityGraph(name = "allJoinsForId", attributeNodes = {
                @NamedAttributeNode("client"),
                @NamedAttributeNode(value = "adress"),
                @NamedAttributeNode(value = "images")
        }
        )
})
public class Post extends BaseObject {
    @ManyToOne(fetch = FetchType.LAZY)
    private Client client;
    @ElementCollection
    private Set<String> images;
    @Column(nullable = false, length = 20)
    private String title;
    @Column(nullable = false)
    private String information;
    @Column(nullable = false)
    private Integer price;
    @Column(nullable = false)
    private Integer roomsCount;
    @Enumerated(EnumType.STRING)
    @Column
    private PostType postType;
    @Enumerated(EnumType.STRING)
    private BuldingType buildingType;
    @OneToOne(cascade = {CascadeType.ALL}, orphanRemoval = true, fetch = FetchType.LAZY, optional = false)
    private Adress adress;

    public enum BuldingType {
        APARTMENT, HOUSE
    }

    public enum PostType {
        PURCHASE, SALE, RENTING
    }
}
