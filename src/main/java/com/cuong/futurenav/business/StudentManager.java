package com.cuong.futurenav.business;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cuong.futurenav.dao.FavSchoolJpaRepository;
import com.cuong.futurenav.dao.SchoolJpaRepository;
import com.cuong.futurenav.dao.StudentJpaRepository;
import com.cuong.futurenav.dao.dto.FavSchoolEntity;
import com.cuong.futurenav.dao.dto.SchoolEntity;
import com.cuong.futurenav.dao.dto.StudentEntity;
import com.cuong.futurenav.model.StudentProfile;

@Service
public class StudentManager {
	
	@Autowired
	StudentJpaRepository studentRepo;
	
	@Autowired
	FavSchoolJpaRepository favRepo;
	
	@Autowired
	SchoolJpaRepository schoolRepo;
	
	public StudentProfile addSchoolToFav(int studentId, int schoolId, String note) {

		SchoolEntity e = schoolRepo.findOne(schoolId);
		StudentEntity s = studentRepo.findOne(studentId); 
		FavSchoolEntity f = new FavSchoolEntity();
		f.setSchool(e);
		f.setStudent(s);
		f.setNote(note);
		f.setAffiliateType("FAVORITE");
		favRepo.save(f);
		
		return getStudentProfile(studentId);

	}

	public StudentProfile removeFromFav(int studentId, int favId) {

		favRepo.delete(favId);
		
		return getStudentProfile(studentId);
	}

	public StudentProfile getStudentProfile(int studentId) {

		StudentEntity e = studentRepo.findOne(studentId);
		StudentProfile p = new StudentProfile();
		BeanUtils.copyProperties(e, p);
		
		return p;

	}

	public void takeNoteOnFav(int favId, String note) {

		FavSchoolEntity f = favRepo.findOne(favId);
		f.setNote(note);
		favRepo.save(f);

	}

}
