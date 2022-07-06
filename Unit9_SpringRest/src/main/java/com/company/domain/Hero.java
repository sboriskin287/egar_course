package com.company.domain;

import com.company.audit.Audit;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "hero")
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Hero {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "hero_seq")
    @SequenceGenerator(
            name = "hero_seq",
            sequenceName = "hero_id_seq",
            allocationSize = 1)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "health")
    private Float health;

    @Column(name = "damage")
    private Float damage;

    @Embedded
    private Audit audit = new Audit();
}