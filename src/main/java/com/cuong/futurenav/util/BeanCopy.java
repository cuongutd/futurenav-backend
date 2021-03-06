package com.cuong.futurenav.util;

import java.util.ArrayList;

import org.springframework.beans.BeanUtils;

import com.cuong.futurenav.controller.model.FavSchoolResponse;
import com.cuong.futurenav.controller.model.SchoolResponse;
import com.cuong.futurenav.controller.model.StudentProfileResponse;
import com.cuong.futurenav.dao.dto.FavSchoolEntity;
import com.cuong.futurenav.dao.dto.SchoolDetailEntity;
import com.cuong.futurenav.dao.dto.SchoolEntity;
import com.cuong.futurenav.dao.dto.StudentEntity;
import com.cuong.futurenav.model.FavSchoolData;
import com.cuong.futurenav.model.SchoolData;
import com.cuong.futurenav.model.SchoolDetailData;
import com.cuong.futurenav.model.StudentProfileData;

public class BeanCopy {

	public static void copyProperties(StudentProfileData source, StudentProfileResponse target) {

		org.springframework.beans.BeanUtils.copyProperties(source, target);

		ArrayList<FavSchoolResponse> favSchoolResponse = new ArrayList<FavSchoolResponse>();
		for (FavSchoolData data : source.getListOfFavSchool()) {
			FavSchoolResponse res = new FavSchoolResponse();
			org.springframework.beans.BeanUtils.copyProperties(data, res);
			SchoolResponse schoolRes = new SchoolResponse();
			org.springframework.beans.BeanUtils.copyProperties(data.getSchool(), schoolRes);
			res.setSchool(schoolRes);
			favSchoolResponse.add(res);

		}

		target.setListOfFavSchool(favSchoolResponse);

	}

	public static void copyProperties(StudentEntity source, StudentProfileData target) {

		org.springframework.beans.BeanUtils.copyProperties(source, target);

		ArrayList<FavSchoolData> schoolData = new ArrayList<FavSchoolData>();
		for (FavSchoolEntity entity : source.getListOfFavSchool()) {

			// copy schoolEntity to data
			SchoolData data = new SchoolData();
			org.springframework.beans.BeanUtils.copyProperties(entity.getSchool(), data);

			// copy favSchoolEntity to data
			FavSchoolData favData = new FavSchoolData();
			org.springframework.beans.BeanUtils.copyProperties(entity, favData);

			favData.setSchool(data);
			schoolData.add(favData);

		}

		target.setListOfFavSchool(schoolData);

	}

	public static void copyProperties(SchoolEntity source, SchoolData target){
		
		org.springframework.beans.BeanUtils.copyProperties(source, target);
		ArrayList<SchoolDetailData> details = new ArrayList<SchoolDetailData>();
		for (SchoolDetailEntity entity : source.getListOfSchoolDetail()){
			SchoolDetailData data = new SchoolDetailData();
			org.springframework.beans.BeanUtils.copyProperties(entity, data);
			details.add(data);
		}
		target.setListOfSchoolDetail(details);
		
	}
	
	
}
