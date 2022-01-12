package com.ocean.model;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
@RequiredArgsConstructor
public class SailboatRepository {

    @PersistenceContext
    EntityManager em;

    public Sailboat find(Long id){
        return em.find(Sailboat.class,id);
    }

    public Sailboat find(){
        return em.createQuery("Select s From Sailboat s", Sailboat.class)
                .getSingleResult();
    }

    @Transactional
    public void save (Sailboat sailboat){
        em.persist(sailboat);
    }
}
