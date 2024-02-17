package hellojpa;

import javax.persistence.*;
import java.util.Date;

@Entity //JPA를 사용하는 애 구나 하고 인식을하게됨
//@Table(name = "MBR")    //이런식으로하면 table과 클래스가 매핑될때 MBR가 매핑된다.
public class Member {
    @Id //PK가 뭔지 알려줘야함  이것만하면 직접할당됨.
    @GeneratedValue(strategy = GenerationType.IDENTITY) //다음 에너테이션을 붙이면 내가 값을 넣지 않아도 자동으로 순차적으로 db가 세팅된다.
    private Long id;

    @Column(name = "name")
    //Member 클래스에는 username인데 데이터베이스에는 name이라는 필드명을 쓰고싶으면 다음과 같이 name을 변경해준다.
    private String username;

    public Member() {

    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

}
