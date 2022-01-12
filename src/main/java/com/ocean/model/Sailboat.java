package com.ocean.model;

import lombok.*;

import javax.persistence.Entity;

@Entity
//For Entity without collection Data is ok
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Sailboat extends BaseEntity{
    String name;

}
