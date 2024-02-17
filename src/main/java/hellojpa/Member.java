package hellojpa;

import javax.persistence.*;
import java.util.Date;

@Entity //JPA를 사용하는 애 구나 하고 인식을하게됨
//@Table(name = "MBR")    //이런식으로하면 table과 클래스가 매핑될때 MBR가 매핑된다.
public class Member {
    @Id //PK가 뭔지 알려줘야함
    private Long id;

    @Column(name = "name",nullable = false)
    //Member 클래스에는 username인데 데이터베이스에는 name이라는 필드명을 쓰고싶으면 다음과 같이 name을 변경해준다.
    private String username;
    private Integer age;    //다른타입을 쓸수도있음 DB에서도 숫자타입이 적용됨.

    @Enumerated(EnumType.STRING)
    //자바에는 enum타입이 있지만 db에는 enum타입이 없다. 그래서 다음과 같이 enumtype을 붙인다.
    private RoleType roleType;

    //타입 정보가 3개존재한다. 시간, 날짜, 날짜시간
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;

    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDate;

    @Lob
    private String description;

    public Member(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public RoleType getRoleType() {
        return roleType;
    }

    public void setRoleType(RoleType roleType) {
        this.roleType = roleType;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
