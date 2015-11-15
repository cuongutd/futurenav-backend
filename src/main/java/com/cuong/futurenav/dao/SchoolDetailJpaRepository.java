package com.cuong.futurenav.dao;

import org.springframework.data.repository.PagingAndSortingRepository;
import com.cuong.futurenav.dao.dto.SchoolDetailEntity;

/**
 * Repository : SchoolDetail.
 */
public interface SchoolDetailJpaRepository extends PagingAndSortingRepository<SchoolDetailEntity, Integer> {

}
