package dev.chermenin.service.dto.create;

import dev.chermenin.service.dto.Dto;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Getter
@Setter
public class UserRegistrationDto extends Dto {
    @Pattern(regexp = "[a-zA-Z0-9_]{2,20}")
    private String name;
    @Pattern(regexp = "[a-zA-Z0-9_]{2,20}")
    private String lastname;
    @NotNull
    @Min(1)
    private Long cityId;
    @Pattern(regexp = "[a-zA-Z0-9_]{3,20}+@[a-z]+\\.[a-z]{2,6}")
    private String email;
    @Pattern(regexp = "[0-9]{2,20}")
    private String phone;
    @Pattern(regexp = "[a-zA-Z0-9_]{6,20}")
    private String password;
}
