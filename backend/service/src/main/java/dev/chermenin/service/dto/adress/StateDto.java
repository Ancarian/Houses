package dev.chermenin.service.dto.adress;

import dev.chermenin.dao.adress.State;
import dev.chermenin.service.dto.Dto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StateDto extends Dto {
    private String name;

    public StateDto(State state) {
        super(state);
        this.name = state.getName();
    }
}
