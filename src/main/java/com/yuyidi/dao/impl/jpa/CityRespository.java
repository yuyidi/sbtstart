package com.yuyidi.dao.impl.jpa;

import com.yuyidi.dao.CityDao;
import com.yuyidi.entity.City;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.Repository;

/**
 * @author Created by yuyidi on 2017/6/23.
 * @desc
 */
//@RepositoryDefinition(domainClass = CityRespository.class,idClass = Long.class)
public interface CityRespository extends Repository<City, Long>{

//    @Query("select c from City c where c.id = ?1")
    City getCityById(Long id);

    Page<City> findAll(Pageable pageable);

    Page<City> findByNameContainingAndCountryContainingAllIgnoringCase(String name, String country, Pageable pageable);

    City findByNameAndCountryAllIgnoringCase(String name, String country);
}
