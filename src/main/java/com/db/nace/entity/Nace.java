package com.db.nace.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Nace {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "nace_seq_generator")
    @SequenceGenerator(name="nace_seq_generator",sequenceName = "nace_seq",allocationSize = 500)
    private Long id;
    private Long orderNum;
    private Long level;
    private String code;
    private String parent;
    private String description;
    @Column(columnDefinition = "TEXT")
    private String itemIncludes;
    @Column(columnDefinition = "TEXT")
    private String itemAlsoIncludes;
    @Column(columnDefinition = "TEXT")
    private String itemExcludes;
    private String reference;
}
