package com.cuong.futurenav.dao;

import org.springframework.data.repository.PagingAndSortingRepository;
import com.cuong.futurenav.dao.dto.FavSchoolEntity;

/**
 * Repository : FavSchool.
 */
public interface FavSchoolJpaRepository extends PagingAndSortingRepository<FavSchoolEntity, Integer> {

}
