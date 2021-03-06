package com.giovane.soccer.entity.team;

import lombok.*;
import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
@Table(name = "teams")
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name_team")
    private String name;

    @Column(name = "name_stadium")
    private String stadium;

    @Column(name = "name_country")
    private String country;
}
