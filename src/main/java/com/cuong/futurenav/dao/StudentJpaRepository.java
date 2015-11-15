package com.cuong.futurenav.dao;

import org.springframework.data.repository.PagingAndSortingRepository;
import com.cuong.futurenav.dao.dto.StudentEntity;

/**
 * Repository : Student.
 */
public interface StudentJpaRepository extends PagingAndSortingRepository<StudentEntity, Integer> {

}
