package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpaMain {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        //트랜잭션을 받아오지않으면 실제 DB에 저장되지않음
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        try {
            /*
            저장
            Member member = new Member();
            member.setId(2l);
            member.setName("HelloB");
            //em.persist(member);

            조회
            Member findMember = em.find(Member.class, 1l);
            System.out.println("findMember = " + findMember.getId());
            System.out.println("findMember = " + findMember.getName());

            삭제
            Member findMember = em.find(Member.class, 1l);
            em.remove(findMember);

            수정
            Member findMember = em.find(Member.class, 1l);
            findMember.setName("HelloJPA");

            List<Member> result = em.createQuery("select m from Member as m", Member.class)
                                    .setFirstResult(5)
                                    .setMaxResults(8)
                                    .getResultList();

            for (Member member : result) {
                System.out.println("member = " + member.getName());
            }
            */

            //비영속
            Member member = new Member();
            member.setId(100L);
            member.setName("HelloJPA");

            //영속
            System.out.println("===BEFORE===");
            em.persist(member);
            em.detach(member);
            System.out.println("===AFTER===");
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            //code
            em.close();
        }
        emf.close();
    }
}
