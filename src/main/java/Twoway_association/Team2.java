package Twoway_association;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Team2 {

    @Id @GeneratedValue
    @Column(name="TEAM_ID")
    private Long id;
    private String name;

//    Member2의 team변수에 매핑되었기때문에, members는 조회(get)만가능하고 변경(set)은불가함 set해봤자 변화안됨
//    변경하려면 Member2의 team변수를 바꾸면 여기있는 members도 같이 바뀐다.
//    외래키(많은쪽)가있는 Member2를 연관관계의 주인으로 정하는것이 직관적이고 좋다. 반대편은 mappedby로 조회만.
    @OneToMany(mappedBy = "team")
    private List<Member2> members = new ArrayList<>();

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

    public List<Member2> getMembers() {
        return members;
    }

    public void setMembers(List<Member2> members) {
        this.members = members;
    }
}
