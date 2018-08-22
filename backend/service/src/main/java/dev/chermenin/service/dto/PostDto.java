package dev.chermenin.service.dto;

import dev.chermenin.dao.Post;
import dev.chermenin.service.dto.adress.AdressDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Objects;
import java.util.Set;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class PostDto extends Dto {
    private PostUserInformationDto user;
    private Set<String> urlOfimages;
    private String title;
    private String information;
    private Integer price;
    private Integer roomsCount;
    private Post.PostType postType;
    private Post.BuldingType buildingType;
    private AdressDto adress;

    public PostDto(Post post) {
        super(post);
        if (Objects.nonNull(post.getClient())) {
            this.user = new PostUserInformationDto(post.getClient());
        }
        if (Objects.nonNull(post.getImages())) {
            this.urlOfimages = post.getImages();
        }
        if (Objects.nonNull(post.getAdress())) {
            this.adress = new AdressDto(post.getAdress());
        }
        this.title = post.getTitle();
        this.information = post.getInformation();
        this.price = post.getPrice();
        this.roomsCount = post.getRoomsCount();
        this.postType = post.getPostType();
        this.buildingType = post.getBuildingType();

    }
}
