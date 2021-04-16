package com.kito.webservice.service;

import com.kito.webservice.domain.posts.PostsRepository;
import com.kito.webservice.dto.PostsSaveRequestDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@AllArgsConstructor
@Service
public class PostsService {

    private PostsRepository postsRepository;


    /*
    *  @Transactional
    *    - INSERT/UPDATE/DELETE 하는 service메소드는 해당 어노테이션을 붙인다.
    *    역할 : 메소드 내에서 exception이 발생하면 해당 메소드에서 이루어진 모든 DB작업을 초기화시킨다.
    * */

    @Transactional
    public Long save(PostsSaveRequestDto dto){

        //entity를 바로받지 않고 save용 dto로 받아서 저장한다.

        return postsRepository.save(dto.toEntity()).getId();
    }
}
