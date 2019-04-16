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
@javax.persistence.Table(name = "skill")
public class Skill extends Table{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "area")
    private String area;

    @Column(name = "skill_level")
    private String skillsLevel;
}
