package com.nix.zemnitskiy.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@NoArgsConstructor
@Data
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@Table("weather")
public class Weather {
    @PrimaryKey
    private int id;
    @Column
    private String base;
    @Column
    private String name;
    @Column
    private Temperature main;
    @Column
    private double visibility;
    @Column
    private double timezone;
}