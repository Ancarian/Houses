package dev.chermenin.service.dto;


import dev.chermenin.dao.BaseObject;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class Dto {

    private Long id;


    public Dto(BaseObject baseObject) {
        this.id = baseObject.getId();
    }
}
