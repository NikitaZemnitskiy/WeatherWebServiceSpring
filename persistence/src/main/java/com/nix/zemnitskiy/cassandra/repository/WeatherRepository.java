package com.nix.zemnitskiy.cassandra.repository;

import com.nix.zemnitskiy.api.Weather;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WeatherRepository extends CassandraRepository<Weather, Integer> {

}
