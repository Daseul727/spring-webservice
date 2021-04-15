package com.kito.webservice.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PostsRepository extends JpaRepository<Posts,Long> {
    //ibatis, mybatis 등에서 Dao 라고 불리는 DB Layer 접근자.
    //JPA 에서는 Repository라고 부르며 인터페이스로 생성.
    //인터페이스 생성 후 JpaRepository<Entity클래스, pk타입>을 상속하면 기본적인 CRUD 메소드가 자동생성된다.
}
