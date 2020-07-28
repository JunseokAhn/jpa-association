package ManyToMany_Association;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Member5 {

    @Id @GeneratedValue
    @Column(name = "MEMBER_ID")
    private Long id;
    private String name;

//    @ManyToMany
//    @JoinTable(name = "MEMBER_PRODUCT")
//    private List<Product> producs = new ArrayList<>();
//    ManyToMany는 테이블을 생성해주긴하지만 그외에 여러가지 커스텀이 안되기때문에 실무에서 사용이불가
//    그래서 그대신 객체테이블을 하나더주고 ManyToOne으로 수동으로 엮어줘야한다.


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
