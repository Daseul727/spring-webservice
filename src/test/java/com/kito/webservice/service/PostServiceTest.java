package com.kito.webservice.service;

import com.kito.webservice.domain.posts.Posts;
import com.kito.webservice.domain.posts.PostsRepository;
import com.kito.webservice.dto.PostsSaveRequestDto;
import org.aspectj.lang.annotation.After;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class PostServiceTest {

    @Autowired
    private PostsService postsService;

    @Autowired
    private PostsRepository postsRepository;

    @After("")
    public void cleanup(){
        postsRepository.deleteAll();
    }

    @Test
    void saveDtoDataToPostsTable() {

        //given
        PostsSaveRequestDto dto = PostsSaveRequestDto.builder()
                                        .author("daseul727")
                                        .content("테스트")
                                        .title("테스트 타이틀")
                                        .build();
        //when
        postsService.save(dto);

        //then
        Posts posts = postsRepository.findAll().get(0);
        assertThat(posts.getAuthor()).isEqualTo(dto.getAuthor());
        assertThat(posts.getContent()).isEqualTo(dto.getContent());
        assertThat(posts.getTitle()).isEqualTo(dto.getTitle());
    }

}
