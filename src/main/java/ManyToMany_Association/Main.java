package ManyToMany_Association;

import Association_Mapping.Order;
import Association_Mapping.OrderItem;
import Oneway_association.Member;

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

            Member5 member = new Member5();
            member.setName("Junseok");

            Product product = new Product();
            product.setName("Phone");

            Member_Product memberProduct = new Member_Product();
            memberProduct.setMember(member);
            memberProduct.setProduct(product);

            EM.persist(member);
            EM.persist(product);
            EM.persist(memberProduct);

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
