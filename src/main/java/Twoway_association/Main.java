package Twoway_association;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        EntityManagerFactory EMF = Persistence.createEntityManagerFactory("hello");
        EntityManager EM = EMF.createEntityManager();
        EntityTransaction TS = EM.getTransaction();

        TS.begin();

        try {
            Team2 team = new Team2();
            team.setName("teamA");
            EM.persist(team);

            Member2 member = new Member2();
            member.setUserName("Junseok");
            member.setTeam(team);
            EM.persist(member);

            EM.flush();
            EM.clear();

            Member2 FindMember = EM.find(Member2.class, member.getId());
            List<Member2> members= FindMember.getTeam().getMembers();
//          플러쉬 클리어를 한다음에 파인드로 값을 찾아오면 members까지 다 찾아오지만,
//          플러쉬클리어를 안하면 캐쉬에서 값을 찾기때문에 members를 따로 등록해주지 않으면 값을 찾아오지못한다
//          즉 이런문제때문에 항상 team.getMembers().add(member)를 해줘야함
//          이게 귀찮기때문에, member.setTeam할때 setTeam을 조금 커스텀해서 한번에 되게해주자.
            System.out.println("=============");
            for(Member2 i : members )
                System.out.println(i.getUserName());
            System.out.println("=============");

            TS.commit();
//          toString이나 롬복 생성시, 양방향매핑관계는 무한루프가걸리므로 toString이나
//          롬복의 toString자동생성은 사용하지말것.
//          그리고 JSON생성 라이브러리도 같은 문제가 발생하는데, 이경우는 Entity를 생성하지말라고 한다.
        } catch (Exception e) {
            e.printStackTrace();
            TS.rollback();
        } finally {
            EM.close();
        }
        EMF.close();

    }
}
