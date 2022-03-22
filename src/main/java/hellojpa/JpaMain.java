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
            /*
            //비영속
            Member member = new Member();
            member.setId(101L);
            member.setName("HelloJPA");

            //영속
            System.out.println("===BEFORE===");
            em.persist(member);
//            em.detach(member);
            System.out.println("===AFTER===");
             */
            /*
            Member findMember1 = em.find(Member.class, 101L);
            Member findMember2 = em.find(Member.class, 101L);

            System.out.println("result = " + (findMember1 == findMember2));
            System.out.println("findMember = " + findMember1.getId());
            System.out.println("findMember = " + findMember1.getName());
             */
/*
            Member member1 = new Member(150L, "A");
            Member member2 = new Member(160l, "B");
            em.persist(member1);
            em.persist(member2);

 */
            /*
            Member member = em.find(Member.class, 150L);
            member.setName("ZZZZZZ");
             */
            /*
            Member member = new Member(200L, "meber200");
            em.persist(member);
            em.flush();
             */
            /*
            Member member = em.find(Member.class, 150L);
            member.setName("AAAAA");
            
            
            //준영속상태로 전환
            em.detach(member);

            // 영속성 컨텍스트를 완전히 초기화
            // em.clear()
            // Member member2 = em.find(Member.class, 150L);

            // 영속성 컨텍스트를 종료
            // em.close()

            System.out.println("=============================");
            */
            Member member = new Member();
            member.setUsername("C");
            System.out.println("==================================");
            em.persist(member);
            System.out.println("member.getId() = " + member.getId());
            System.out.println("==================================");
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
