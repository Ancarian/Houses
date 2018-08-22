package dev.chermenin.service.dto.create;

import dev.chermenin.dao.Post;
import dev.chermenin.service.dto.Dto;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Set;

@Getter
@Setter
public class PostRegistrationDto extends Dto {
    private Long userId;
    private Set<String> urlOfimages;
    @Pattern(regexp = "[a-zA-Z0-9_]{2,20}")
    private String title;
    @Pattern(regexp = "[\\s\\S]{2,255}")
    private String information;
    @NotNull
    @Min(1)
    private Integer price;
    @NotNull
    @Min(1)
    private Integer roomsCount;
    @NotNull
    private Post.PostType postType;
    @NotNull
    private Post.BuldingType buildingType;
    @Pattern(regexp = "[a-zA-Z0-9, ]{2,20}")
    private String adress;
    @NotNull
    @Min(1)
    private Long cityId;
}
