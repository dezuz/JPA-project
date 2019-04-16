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
@javax.persistence.Table(name = "customer")
public class Customer extends TableX {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "company")
    private String company;

    @Column(name = "budget")
    private Integer budget;
}
