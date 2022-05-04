package hellojpa;

import org.hibernate.Hibernate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.time.LocalDateTime;
import java.util.List;

public class JpaMain {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        //트랜잭션을 받아오지않으면 실제 DB에 저장되지않음
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        try {

            Member member = new Member();
            member.setUsername("member1");
            member.setHomeaddress(new Address("homeCity", "street", "100000"));

            member.getFavoriteFoods().add("치킨");
            member.getFavoriteFoods().add("족발");
            member.getFavoriteFoods().add("피자");

            member.getAddressHistory().add(new Address("old1", "street", "100000"));
            member.getAddressHistory().add(new Address("old2", "street", "100000"));
            em.persist(member);



            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback();
        } finally {
            //code
            em.close();
        }
        emf.close();
    }

    private static void logic(Member m, Member m1) {
        System.out.println("m == m2: " + (m1 instanceof Member));
        System.out.println("m == m2: " + (m instanceof Member));
    }
}
