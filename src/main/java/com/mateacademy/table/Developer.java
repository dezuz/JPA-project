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
@javax.persistence.Table(name = "developer")
public class Developer extends TableX {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private Integer age;

    @Column(name = "sex")
    private String sex;

    @Column(name = "salary")
    private Integer salary;
}
