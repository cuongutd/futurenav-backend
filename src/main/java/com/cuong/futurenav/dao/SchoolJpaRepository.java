package com.cuong.futurenav.dao;

import org.springframework.data.repository.PagingAndSortingRepository;
import com.cuong.futurenav.dao.dto.SchoolEntity;

import java.util.List;

/**
 * Repository : School.
 */
public interface SchoolJpaRepository extends PagingAndSortingRepository<SchoolEntity, Integer> {
	List<SchoolEntity> findByLatitudeGreaterThanAndLatitudeLessThanAndLongitudeGreaterThanAndLongitudeLessThan(double lowerLat, double upperLat, double lowerLong, double upperLong);
	List<SchoolEntity> findByLatitudeIsNullOrLongitudeIsNull();
}
