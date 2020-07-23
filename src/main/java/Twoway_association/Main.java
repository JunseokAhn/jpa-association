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
            System.out.println("=============");
            for(Member2 i : members )
                System.out.println(i.getUserName());
            System.out.println("=============");

            TS.commit();
        } catch (Exception e) {
            e.printStackTrace();
            TS.rollback();
        } finally {
            EM.close();
        }
        EMF.close();

    }
}
