package dev.chermenin.repository;

import dev.chermenin.dao.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PostRepository extends JpaRepository<Post, Long>, JpaSpecificationExecutor<Post> {
    boolean existsByIdAndClientId(Long postId, Long userId);

    Page<Post> findAllByClientId(Long id, Pageable pageable);

    @Override
    Page<Post> findAll(Pageable pageable);

    @EntityGraph(value = "allJoinsForId", type = EntityGraph.EntityGraphType.LOAD)
    @Override
    Optional<Post> findById(Long id);
}
