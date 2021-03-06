package com.kito.webservice.domain.posts;

import org.aspectj.lang.annotation.After;
import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.time.LocalDateTime;
import java.util.List;

@SpringBootTest
class PostsRepositoryTest {

    @Autowired
    PostsRepository postsRepository;

    @After("")
    public void cleanup(){
        postsRepository.deleteAll();
    }

    @Test
    public void contextLoads() {

        //given 테스트 기반 환경을 구축
        postsRepository.save(Posts.builder()
                            .title("테스트 게시글")
                            .content("테스트 본문")
                            .author("daseul727").build());

        //when  테스트 하고자 하는 행위
        List<Posts> postsList = postsRepository.findAll();

        //then 테스트 결과 검증
        Posts posts = postsList.get(0);
        assertThat(posts.getTitle(),is("테스트 게시글"));
        assertThat(posts.getContent(), is("테스트 본문"));
    }

    @Test
    public void BaseTimeEntity_save(){

        //given
        LocalDateTime now = LocalDateTime.now();
        postsRepository.save(Posts.builder().title("테스트 게시글").content("테스트 본문").author("daseul727").build());

        //when
        List<Posts> postsList = postsRepository.findAll();

        //then
        Posts posts = postsList.get(0);
        assertTrue(posts.getCreatedDate().isAfter(now));
        assertTrue(posts.getModifyDateTime().isAfter(now));
    }

}
