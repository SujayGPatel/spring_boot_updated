package com.demo.jpa.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Entity
@Data
@Table(name = "STUDENT", schema = "test")
public class Student implements Serializable {

    private static final long serialVersionUID = -1798070786993154676L;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "ID", unique = true, nullable = false)
    private Integer  id;

    @Basic
    @Column(name = "NAME", nullable = true, length = 100)
    private String name;

   /* @OneToMany(cascade=CascadeType.ALL)
    @JoinColumn(name="STUDENT_ID")
    private Set<Book> books;*/

   /* @OneToMany(cascade=CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "student")
    @JsonManagedReference
    private List < Book > books;*/


}
