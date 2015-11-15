package com.cuong.futurenav.dao;

import org.springframework.data.repository.PagingAndSortingRepository;
import com.cuong.futurenav.dao.dto.StudentLoginEntity;

/**
 * Repository : StudentLogin.
 */
public interface StudentLoginJpaRepository extends PagingAndSortingRepository<StudentLoginEntity, Integer> {

}
