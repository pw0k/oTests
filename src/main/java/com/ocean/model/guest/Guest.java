package com.ocean.model.guest;

import com.ocean.model.BaseEntity;
import com.ocean.model.boat.Boat;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Guest extends BaseEntity {
    private String firstname;
    private String middlename;

    //@ManyToOne(fetch = FetchType.LAZY)
    @ManyToOne()
    private Boat boat;
}
