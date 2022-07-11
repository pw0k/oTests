package com.ocean.model.boat;

import com.ocean.model.BaseEntity;
import com.ocean.model.guest.Guest;
import com.ocean.model.seaman.Seaman;
import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Boat extends BaseEntity {
    @NotNull
    private String name;

    @NotNull
    @Enumerated(EnumType.STRING)
    private TypeBoat type;

    @ElementCollection
    private List<LifeRaft> lifeRafts = new ArrayList<>();

    //todo: not reccomenduse CascadeType.REMOVE for xToMany assocations
    //https://thorben-janssen.com/avoid-cascadetype-delete-many-assocations/
    @OneToMany(cascade = CascadeType.PERSIST, orphanRemoval=true)
    private List<Seaman> seamen = new ArrayList<>();

    @Override
    public String toString() {
        return "Boat{" +
                "name='" + name + '\'' +
                ", type=" + type +
                '}';
    }

    //todo: add method
    //public void addGuest(String string){
    //}
}
