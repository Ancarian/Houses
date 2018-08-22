package dev.chermenin.dao;


import dev.chermenin.dao.adress.City;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "client")
@Getter
@Setter
@NamedEntityGraphs({
        @NamedEntityGraph(name = "userWithRoles", attributeNodes = {
                @NamedAttributeNode(value = "roles"),
        })
})
public class Client extends BaseObject {
    @Column(nullable = false, length = 20)
    private String name;

    @Column(nullable = false, length = 20)
    private String lastname;

    @OneToMany(mappedBy = "client", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Post> posts;

    @Column(nullable = false, unique = true)
    private String email;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private City city;

    @Column(nullable = false, unique = true, length = 20)
    private String phone;

    @Column(nullable = false)
    private String password;

    @ElementCollection(targetClass = RoleType.class, fetch = FetchType.LAZY)
    private Set<RoleType> roles;

    public enum RoleType {
        USER, MODERATOR, ADMIN
    }
}
