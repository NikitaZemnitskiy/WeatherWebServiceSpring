package com.nix.zemnitskiy.api;

import com.datastax.driver.core.DataType;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.cassandra.core.mapping.CassandraType;
import org.springframework.data.cassandra.core.mapping.UserDefinedType;

@NoArgsConstructor
@Data
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@UserDefinedType("temperature")
public class Temperature {
    @CassandraType(type = DataType.Name.DOUBLE)
    private double temp;
    @CassandraType(type = DataType.Name.DOUBLE)
    private double feels_like;
    @CassandraType(type = DataType.Name.DOUBLE)
    private double temp_min;
    @CassandraType(type = DataType.Name.DOUBLE)
    private double temp_max;
    @CassandraType(type = DataType.Name.DOUBLE)
    private double pressure;
    @CassandraType(type = DataType.Name.DOUBLE)
    private double humidity;

}
