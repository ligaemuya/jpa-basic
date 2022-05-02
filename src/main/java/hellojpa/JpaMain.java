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

            Address address = new Address("city", "street", "1000");

            Member member = new Member();
            member.setUsername("hello");
            member.setHomeaddress(address);
            em.persist(member);

            Address copyAddress = new Address(address.getCity(), address.getStreet(), address.getZipCode());

            Member member1 = new Member();
            member1.setUsername("hello1");
            member1.setHomeaddress(copyAddress);
            em.persist(member1);

            //
            member.getHomeaddress().setCity("newCity");

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
