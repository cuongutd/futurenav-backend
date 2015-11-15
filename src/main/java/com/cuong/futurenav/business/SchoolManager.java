package com.cuong.futurenav.business;

import com.cuong.futurenav.dao.SchoolJpaRepository;
import com.cuong.futurenav.dao.dto.SchoolEntity;
import com.cuong.futurenav.model.SchoolData;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by Cuong on 11/13/2015.
 */

@Service
public class SchoolManager {

	@Autowired
	private SchoolJpaRepository repo;

	public SchoolData findSchoolsByLocation(int id) {

		SchoolEntity dto = repo.findOne(id);

		SchoolData data = new SchoolData();
		BeanUtils.copyProperties(dto, data);
		return data;

	}

	public List<SchoolData> findSchoolByLocation(@RequestParam(value = "lat") String lat, @RequestParam(value = "lon") String lon){
		
		return null;
		
	}
	
}
