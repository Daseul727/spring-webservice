package com.kito.webservice.web;

import com.kito.webservice.domain.posts.PostsRepository;
import com.kito.webservice.dto.PostsSaveRequestDto;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController //RestController 는 responseBody + controller 로, @ResponseBody를 하지않더라도 알아서 json/text 등의 형태로 넘겨준다.
@AllArgsConstructor
public class WebRestController{

    private PostsRepository postsRepository;

    @GetMapping("/hello")
    public String hello(){
        return "webRestController hello ~";
    }

    @PostMapping("/posts")
    public void savePosts(@RequestBody PostsSaveRequestDto dto){
        postsRepository.save(dto.toEntity());
    }
}