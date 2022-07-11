package com.ocean.model.guest;

import com.ocean.model.boat.Boat;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class GuestRepository {
    @PersistenceContext
    EntityManager em;

    @Transactional
    public void save (Guest guest){
        em.persist(guest);
    }

    public List<Guest> getGuestsWithN1(){
        return em.createQuery("""
                Select g
                From Guest g
                """,Guest.class)
                .getResultList();
    }

    public List<Guest> getGuestsWithJoin(){
        return em.createQuery("""
                Select g
                From Guest g
                join fetch g.boat
                """,Guest.class)
                .getResultList();
    }
}
