package com.mateacademy.table;

import com.mateacademy.listener.MyListener;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(MyListener.class)
@javax.persistence.Table(name = "project")
public class Project extends Table{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "developers_number")
    private Integer developersNumber;

    @Column(name = "customer")
    private String customer;

    @Column(name = "cost")
    private Integer cost;
}
