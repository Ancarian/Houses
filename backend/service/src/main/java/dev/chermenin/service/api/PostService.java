package dev.chermenin.service.api;

import dev.chermenin.dao.Post;
import dev.chermenin.service.dto.PostDto;
import dev.chermenin.service.dto.create.PostRegistrationDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

public interface PostService {
    PostDto findById(Long id);

    Page<PostDto> findAll(Pageable pageable);

    Page<PostDto> findAll(Pageable pageable, Specification<Post> specification);

    Page<PostDto> findAllByUserId(Long id, Pageable pageable);

    Page<PostDto> findAllByUserId(Long id, Pageable pageable, Specification<Post> specification);

    PostDto save(PostRegistrationDto postDto);

    void update(PostRegistrationDto postDto);

    void deleteById(Long id);

    boolean existsByIdAndUserId(Long postId, Long userId);
}
