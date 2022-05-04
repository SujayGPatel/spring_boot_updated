package com.demo.jpa.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@Table(name = "BOOK", schema = "test")
public class Book implements Serializable {

    private static final long serialVersionUID = -1798070786993154676L;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "ID", unique = true, nullable = false)
    private Integer  id;

    @Basic
    @Column(name = "NAME", nullable = true, length = 100)
    private String name;

    /*
    @ManyToOne
    private Student student;
    */

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH}, fetch = FetchType.LAZY)
    @JoinColumn(name = "STUDENT_ID", nullable = false)
    @JsonBackReference
    private Student student;
}


