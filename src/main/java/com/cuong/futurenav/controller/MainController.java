package com.cuong.futurenav.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.http.MediaType;
import com.cuong.futurenav.business.SchoolManager;
import com.cuong.futurenav.business.StudentManager;
import com.cuong.futurenav.controller.model.SchoolResponse;
import com.cuong.futurenav.controller.model.UserProfileRequest;
import com.cuong.futurenav.model.SchoolData;
import com.cuong.futurenav.model.StudentProfile;

import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {
	
	@Autowired
	private SchoolManager schoolManager;
	
	@Autowired
	private StudentManager studentMgr;
		
	@RequestMapping(value = "/findSchoolByLocation", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<SchoolResponse> findSchoolByLocation(@RequestParam(value = "lat") String lat, @RequestParam(value = "lon") String lon){
		
		List<SchoolData> data = schoolManager.findSchoolByLocation(lat, lon);
		
		//SchoolResponse is light weight
		List<SchoolResponse> response = new ArrayList<SchoolResponse>();
		
		for (SchoolData d :  data){
			SchoolResponse s = new SchoolResponse();
			BeanUtils.copyProperties(d,  s);
			response.add(s);
			
		}
		
		return response;
		
	}
	
	@RequestMapping(value = "/getSchoolDetail", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public SchoolData getSchoolDetail(@RequestParam(value = "schoolId") int schoolId){
		
		return schoolManager.findSchoolsByLocation(schoolId);
		
	}
	
	@RequestMapping(value = "/addSchoolToFav", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public StudentProfile addSchoolToFav(@RequestParam(value = "studentId") int studentId
			, @RequestParam(value = "schoolId") int schoolId
			, @RequestParam(value = "note") String note){
		
		return studentMgr.addSchoolToFav(studentId, schoolId, note);
		
	}
	
	@RequestMapping(value = "/removeFromFav", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public StudentProfile removeFromFav(@RequestParam(value = "studentId") int studentId
			, @RequestParam(value = "favId") int favId){
		
		return studentMgr.removeFromFav(studentId, favId);
		
	}
	
	@RequestMapping(value = "/getStudentProfile", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public StudentProfile getStudentProfile(@RequestParam(value = "email") String email){
		
		return studentMgr.getStudentProfile(email);
		
	}
	
	@RequestMapping(value = "/tokenSignIn", method = RequestMethod.POST
			, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public StudentProfile tokenSignIn(@RequestBody UserProfileRequest userProfile){
		
		return studentMgr.tokenSignIn(userProfile);
		
	}
	
	@RequestMapping(value = "/takeNoteOnFav", method = RequestMethod.POST)
	public void takeNoteOnFav(@RequestParam(value = "studentId") int studentId
			, @RequestParam(value = "favId") int favId
			, @RequestParam(value = "note") String note){
		
		studentMgr.takeNoteOnFav(favId, note);
		
	}
	
	@RequestMapping(value = "/createStudentProfile", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE
			, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public StudentProfile createStudentProfile(@RequestBody StudentProfile studentInfo){
		
		return studentMgr.createStudentProfile(studentInfo);
		
	}
	
	
}
