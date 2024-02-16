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
        //쿼리를 날릴때마다 EntityManger를 꼭날려야한다.ㅇㅇ

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try{
            Member findMember = em.find(Member.class, 1L);
            findMember.setName("helloJpa");

            tx.commit();
        }catch(Exception e){
            tx.rollback();
        }finally{
            em.close();

        }

        emf.close();


    }
}
