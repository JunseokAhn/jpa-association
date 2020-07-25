package Twoway_association;

import javax.persistence.*;

@Entity @Table(name = "MEMBER2")
public class Member2 {

    @Id @GeneratedValue
    @Column(name = "MEMBER_ID")
    private Long id;

//  처음 매핑할떄는 단방향매핑으로만 매핑할것. 양방향은 실무에서 필요해지는경우가있는데
//  이경우 테이블에 영향을 주지않으므로 하다가 추가해도된다.
    @ManyToOne
    @JoinColumn(name = "TEAM_ID")
    private Team2 team;

    @Column(name = "USER_NAME")
    private String userName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Team2 getTeam() {
        return team;
    }

    public void setTeam(Team2 team) {
        this.team = team;
//      연관관계 편의 메소드
        team.getMembers().add(this);
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
