package com.ocean.model.seaman;

import com.ocean.model.BaseEntity;
import lombok.*;

import javax.persistence.Entity;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Seaman extends BaseEntity {
    String name;
}
