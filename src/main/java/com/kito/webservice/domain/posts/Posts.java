package com.kito.webservice.domain.posts;

import com.kito.webservice.domain.BaseTimeEntity;
import lombok.*;

import javax.persistence.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class Posts extends BaseTimeEntity {

    /*
    * 실제 DB와 매칭될 클래스 == Entity 클래스 라고도 한다.
    * jpa를 활용하여 DB 데이터를 작업할 경우 실제 쿼리를 날리기보단 Entity 클래스를 수정하여 작업한다.
    *
    * @NoArgsConstructor == 기본생성자 자동추가
    *         (access = AccessLevel.PROTECTED) : 기본생성자의 접근을 protected로 제한. 생성자로 protected Posts(){}와 같은 효과
    *                                               entity 클래스를 코드상에서 기본생성자로 생성하는것을 막고 jpa에서 entity 클래스를 생성하는것을 허용하기위함.
    *
    * @Getter == 클래스 내 모든 필드의 getter 메소드를 자동생성
    *
    * @Entity == 테이블과 링크될 클래스를 나타냄. 언더스코어네이밍으로 매칭 ( helloWorld class -> hello_world table )
    *
    * @Id == 해당 테이블의 PK 필드
    *
    * @GeneratedValue == PK의 생성규칙을 나타냄. 기본값은 auto 이며 mysql의 auto_increment와 같이 자동증가하는 정수.
    *                    spring 2.0에선 (strategy = GenerationType.IDENTITY) 안해주면 자동증가 안하므로 추가함.
    *
    * @Column == entity로 선언된 클래스 내 변수는 모두 컬럼취급을 받지만, 별도로 어노테이션 하는 이유는
    *            기본값 외에 추가변경 옵션이 있을경우 사용한다. (VARCHAR(500)으로 늘린다거나, 타입을 TEXT로 변경할때)
    *
    * @Builder == 해당 클래스의 빌더패턴 클래스를 생성. 생성자 상단에 선언 시, 생성자에 포함된 빌드만 빌더에 포함
    *             나중에 db insert할때 Posts.builder().컬럼명(값).컬럼명(값).bulid() 로 insert 한다.
    *
    */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 500, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT" , nullable = false)
    private String content;

    private String author;

    @Builder
    public Posts(String title, String content, String author){
        this.title = title;
        this.content = content;
        this.author = author;
    }
}
