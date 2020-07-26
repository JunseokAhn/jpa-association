package OneToOne_Association;

import javax.persistence.*;

@Entity
public class Member4 {

    @Id @GeneratedValue
    @Column(name = "MEMBER_ID")
    private Long id;
    @OneToOne
    @JoinColumn(name = "LOCKER_ID")
    private Locker locker;
    private String userName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Locker getLocker() {
        return locker;
    }

    public void setLocker(Locker locker) {
        this.locker = locker;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
