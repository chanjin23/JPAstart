package hellojpa;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity //JPA를 사용하는 애 구나 하고 인식을하게됨
public class Member {
    @Id //PK가 뭔지 알려줘야함
    private Long id;
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
