package com.cuong.futurenav.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.http.MediaType;
import com.cuong.futurenav.business.SchoolManager;
import com.cuong.futurenav.model.SchoolData;
import com.cuong.futurenav.model.StudentProfile;

import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {
	
	@Autowired
	private SchoolManager schoolManager;
	
	@RequestMapping(value = "/findSchoolByLocation", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<SchoolData> findSchoolByLocation(@RequestParam(value = "lat") String lat, @RequestParam(value = "lon") String lon){
		
		return null;
		
	}
	
	@RequestMapping(value = "/getSchoolDetail", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public SchoolData getSchoolDetail(@RequestParam(value = "schoolId") int schoolId){
		
		return schoolManager.findSchoolsByLocation(schoolId);
		
	}
	
	@RequestMapping(value = "/addSchoolToFav", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public StudentProfile addSchoolToFav(@RequestParam(value = "studentId") int studentId, @RequestParam(value = "schoolId") int schoolId){
		
		return null;
		
	}
	
	@RequestMapping(value = "/removeFromFav", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public StudentProfile removeFromFav(@RequestParam(value = "studentId") int studentId, @RequestParam(value = "schoolId") int schoolId){
		
		return null;
		
	}
	
	@RequestMapping(value = "/getStudentProfile", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public StudentProfile getStudentProfile(@RequestParam(value = "studentId") int studentId){
		
		return null;
		
	}
	
	@RequestMapping(value = "/takeNoteOnFav", method = RequestMethod.POST)
	public void takeNoteOnFav(@RequestParam(value = "studentId") int studentId
			, @RequestParam(value = "schoolId") int schoolId
			, @RequestParam(value = "note") String note){
		
		return;
		
	}
	
	
}
