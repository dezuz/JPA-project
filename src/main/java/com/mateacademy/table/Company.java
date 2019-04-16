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
@Table(name = "company")
public class Company extends TableX {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "developers_number")
    private Integer developersNumber;

    @Column(name = "budget")
    private Integer budget;
}
