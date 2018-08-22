package dev.chermenin.service.api.impl;

import dev.chermenin.dao.Client;
import dev.chermenin.dao.Post;
import dev.chermenin.dao.adress.Adress;
import dev.chermenin.dao.adress.City;
import dev.chermenin.repository.CityRepository;
import dev.chermenin.repository.PostRepository;
import dev.chermenin.repository.UserRepository;
import dev.chermenin.service.api.PostService;
import dev.chermenin.service.api.impl.exception.NotFoundException;
import dev.chermenin.service.dto.PostDto;
import dev.chermenin.service.dto.create.PostRegistrationDto;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.domain.Specifications;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;

@Service
@AllArgsConstructor
public class PostServiceImpl implements PostService {
    private final PostRepository postRepository;
    private final UserRepository userRepository;
    private final CityRepository cityRepository;

    @Override
    public PostDto findById(Long id) {
        return postRepository.findById(id).map(PostDto::new).orElseThrow(
                () -> new NotFoundException(String.format("post with %d id does not exists", id)));
    }

    @Override
    public Page<PostDto> findAll(Pageable pageable) {
        Page<Post> posts = postRepository.findAll(pageable);
        posts.forEach(o -> {
            o.setImages(null);
            o.setClient(null);
            o.setAdress(null);
        });
        return posts.map(PostDto::new);
    }

    @Override
    public Page<PostDto> findAllByUserId(Long id, Pageable pageable) {
        Page<Post> posts = postRepository.findAllByClientId(id, pageable);
        posts.forEach(o -> {
            o.setImages(null);
            o.setClient(null);
            o.setAdress(null);
        });
        return posts.map(PostDto::new);
    }

    @Override
    public Page<PostDto> findAllByUserId(Long id, Pageable pageable, Specification<Post> specification) {
        Page<Post> posts = postRepository.findAll(specification.and(Specifications.where(
                (root, query, builder) -> {
                    final Join<Post, Client> join = root.join("client", JoinType.LEFT);
                    return builder.or(
                            builder.equal(join.get("id"), id)
                    );
                }
        )), pageable);
        posts.forEach(o -> {
            o.setImages(null);
            o.setClient(null);
            o.setAdress(null);
        });
        return posts.map(PostDto::new);
    }

    @Override
    public Page<PostDto> findAll(Pageable pageable, Specification<Post> specification) {
        Page<Post> posts = postRepository.findAll(specification, pageable);
        posts.forEach(o -> {
            o.setImages(null);
            o.setClient(null);
            o.setAdress(null);
        });
        return posts.map(PostDto::new);
    }

    @Override
    public PostDto save(PostRegistrationDto postDto) {

        return new PostDto(postRepository.save(convert(postDto)));
    }

    @Override
    public void update(PostRegistrationDto postDto) {
        Post post = convert(postDto);
        post.setId(postDto.getId());
        postRepository.save(post);
    }

    @Override
    public void deleteById(Long id) {
        if (!postRepository.existsById(id)) {
            throw new NotFoundException(String.format("post with %d id does not exists", id));
        }
        postRepository.deleteById(id);
    }

    @Override
    public boolean existsByIdAndUserId(Long postId, Long userId) {
        return !postRepository.existsByIdAndClientId(postId, userId);
    }

    private Post convert(PostRegistrationDto postDto) {
        Post post = new Post();
        Adress adress = new Adress();
        adress.setAdress(postDto.getAdress());
        adress.setCity(new City());
        adress.setCity(cityRepository.findById(postDto.getCityId()).orElseThrow(
                () -> new NotFoundException(String.format("city with %d id does not exists", postDto.getCityId()))));

        post.setAdress(adress);
        post.setBuildingType(postDto.getBuildingType());

        post.setPostType(postDto.getPostType());

        post.setTitle(postDto.getTitle());
        post.setInformation(postDto.getInformation());
        post.setPrice(postDto.getPrice());
        post.setRoomsCount(postDto.getRoomsCount());

        post.setImages(postDto.getUrlOfimages());


        post.setClient(userRepository.findById(postDto.getUserId()).orElseThrow(
                () -> new NotFoundException(String.format("user with %d id does not exists", postDto.getUserId()))));

        return post;
    }
}
