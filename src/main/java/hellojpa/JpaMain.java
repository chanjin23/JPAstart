package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain {
    public static void main(String[] args) {
        //JPA는 작업하는 모든 공간을 트랜잭션 안에서 해야한다.
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        //JPA는 EntityManagerFactory 공간을 무조건 만ㄷ르어야한다.

        EntityManager em = emf.createEntityManager();
        //쿼리를 날릴때마다 EntityManger를 꼭날려야한다.

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try{
            //비영속 상태
            Member member = new Member();
            member.setId(101L);
            member.setName("HelloJPA");

            //영속 상태  DB에 저장이 되는것은 아님
            System.out.println("==BEFORE==");
            em.persist(member); //1차 캐시 저장
//            em.detach(member);  //영속성 컨텍스트 분리
            System.out.println("==AFTER==");

            Member findMember = em.find(Member.class, 101L);    //1차캐시에 있는 곳을 찾는다.
            System.out.println("findMember.getId() = " + findMember.getId());
            System.out.println("findMember.getName() = " + findMember.getName());

            tx.commit();
            //commit이 되면 DB로 넘어가게됨.

        }catch(Exception e){
            tx.rollback();
        }finally{
            em.close();

        }

        emf.close();


    }
}
