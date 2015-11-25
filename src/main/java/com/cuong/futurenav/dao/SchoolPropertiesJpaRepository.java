package com.cuong.futurenav.dao;

import org.springframework.data.repository.PagingAndSortingRepository;
import com.cuong.futurenav.dao.dto.SchoolPropertiesEntity;

/**
 * Repository : SchoolProperties.
 */
public interface SchoolPropertiesJpaRepository extends PagingAndSortingRepository<SchoolPropertiesEntity, Integer> {

}
