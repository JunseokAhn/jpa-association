package OneToOne_Association;

import Association_Mapping.Order;
import Association_Mapping.OrderItem;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory EMF = Persistence.createEntityManagerFactory("hello");
        EntityManager EM = EMF.createEntityManager();
        EntityTransaction TS = EM.getTransaction();

        try {
            TS.begin();
            Member4 member = new Member4();
            member.setUserName("Junseok");
            Locker locker = new Locker();
            locker.setName("Junseok");
            member.setLocker(locker);

            EM.persist(member);
            EM.persist(locker);
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
