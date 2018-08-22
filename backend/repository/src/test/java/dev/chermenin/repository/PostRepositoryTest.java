package dev.chermenin.repository;

import dev.chermenin.dao.Post;
import dev.chermenin.repository.util.SpecsBuilder;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = TestConfiguration.class)
public class PostRepositoryTest {
    @Autowired
    private PostRepository postRepository;


    @Test
    public void specificationsTest() {
        String search = "price<150,roomsCount:4";
        List<Post> results = postRepository.findAll((Specification<Post>) SpecsBuilder.createSpecification(search));
        for (Post post : results) {
            Assert.assertTrue(post.getPrice() <= 150);
            Assert.assertEquals(4, (int) post.getRoomsCount());
        }
    }

    @Test
    @Transactional
    public void findByUserIdAndId() {
        Post post = postRepository.findById(1L).get();
        Long postId = post.getId();
        Long userId = post.getClient().getId();
        Assert.assertTrue(postRepository.existsByIdAndClientId(postId, userId));
        Assert.assertFalse(postRepository.existsByIdAndClientId(postId, userId + 1));
    }

    @Test
    public void findAll() {
        postRepository.findAll(PageRequest.of(0, 10));
    }
}