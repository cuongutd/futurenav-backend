package com.cuong.futurenav.dao;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.cuong.futurenav.dao.dto.SchoolEntity;

/**
 * Repository : School.
 */
@Repository
public interface SchoolJpaRepository extends PagingAndSortingRepository<SchoolEntity, Integer> {

	List<SchoolEntity> findByLatitudeLessThanAndLatitudeGreaterThanAndLongitudeLessThanAndLongitudeGreaterThan(double lowerLat, double upperLat, double lowerLong, double upperLong);
	
	
}
