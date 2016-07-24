package com.bluemoon.log.jpa.repositories;

import com.bluemoon.log.jpa.domain.City;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by LeonWong on 16/7/22.
 */
public interface CityRepository extends CrudRepository<City, Long> {

    Page<City> findAll(Pageable pageable);

    City findByNameAndStateAllIgnoringCase(String name, String country);

}
