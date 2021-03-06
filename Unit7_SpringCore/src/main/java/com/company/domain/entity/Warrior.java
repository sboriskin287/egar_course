package com.company.domain.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "warrior")
@Data
@EqualsAndHashCode
public class Warrior {

    @Id
    /*@GenericGenerator(
            name = "warrior_seq",
            strategy = "sequence",
            parameters = @Parameter(
                    name = "sequence_name",
                    value = "warrior_id_seq")
    )*/
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @OneToOne(fetch = FetchType.LAZY,
            cascade = { CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "hero_id")
    private Hero hero;
}
