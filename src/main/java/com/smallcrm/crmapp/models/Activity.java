package com.smallcrm.crmapp.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "activities")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Activity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Builder.Default
    @Column(name = "\"lead\"") // 👈 escapes "lead" so Postgres treats it as a column
    private String lead = "YES";

    @Column(nullable = false)
    private String activity;

    @OneToMany(mappedBy = "activity", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CustomerActivity> customerActivities;
}