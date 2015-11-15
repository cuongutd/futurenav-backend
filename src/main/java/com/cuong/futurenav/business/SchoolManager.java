package com.cuong.futurenav.business;

import com.cuong.futurenav.dao.SchoolJpaRepository;
import com.cuong.futurenav.dao.dto.SchoolEntity;
import com.cuong.futurenav.model.SchoolData;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

	public List<SchoolData> findSchoolByLocation(String lat, String lon) {

		double dLat = Double.valueOf(lat);
		double dLon = Double.valueOf(lon);

		List<SchoolEntity> entities = repo.findByLatitudeLessThanAndLatitudeGreaterThanAndLongitudeLessThanAndLongitudeGreaterThan(dLat - 0.1d, dLat + 0.1d, dLon - 0.1d, dLon + 0.1d);

		List<SchoolData> data = new ArrayList<SchoolData>();

		for (SchoolEntity e : entities) {

			SchoolData d = new SchoolData();
			BeanUtils.copyProperties(e, d);
			data.add(d);
		}

		return data;

	}

}
