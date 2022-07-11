package com.ocean.model.boat;

import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.QueryHints;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
@RequiredArgsConstructor
public class BoatRepository {

    @PersistenceContext
    EntityManager em;

    public Boat getByName(Boat boat){
        return em.createQuery("""
                SELECT  b
                FROM Boat b
                WHERE b.name = :name
                """,Boat.class)
                .setParameter("name", boat.getName())
                .getSingleResult();
    }

    public Boat getByName2Query(String name){
        Boat boat =  em.createQuery("""
                SELECT DISTINCT b
                FROM Boat b
                JOIN FETCH b.lifeRafts
                WHERE b.name = :name
                """,Boat.class)
                .setParameter("name", name)
                .setHint(QueryHints.PASS_DISTINCT_THROUGH, false)
                .getSingleResult();

        boat =  em.createQuery("""
                SELECT DISTINCT b
                FROM Boat b
                JOIN FETCH b.seamen
                WHERE b.name = :name
                """,Boat.class)
                .setParameter("name", name)
                .setHint(QueryHints.PASS_DISTINCT_THROUGH, false)
                .getSingleResult();
        return boat;
    }

    public int findAll(){
        return em.createQuery("""
                Select b From Boat b
                """,Boat.class)
                .getResultList().size();
    }

    @Transactional
    public void save(Boat boat){
        em.persist(boat);
    }



}
