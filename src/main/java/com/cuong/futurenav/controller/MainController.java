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
import com.cuong.futurenav.controller.model.FavSchoolResponse;
import com.cuong.futurenav.controller.model.SchoolResponse;
import com.cuong.futurenav.controller.model.StudentProfileRequest;
import com.cuong.futurenav.controller.model.StudentProfileResponse;
import com.cuong.futurenav.dao.dto.FavSchoolEntity;
import com.cuong.futurenav.model.FavSchoolData;
import com.cuong.futurenav.model.SchoolData;
import com.cuong.futurenav.model.StudentProfileData;
import com.cuong.futurenav.util.BeanCopy;

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
			s.setListOfSchoolDetail(null);
			response.add(s);
			
		}
		
		return response;
		
	}
	
	@RequestMapping(value = "/getSchoolDetail", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public SchoolResponse getSchoolDetail(@RequestParam(value = "schoolId") int schoolId){
		
		SchoolData d = schoolManager.getSchoolDetail(schoolId);
		SchoolResponse r = new SchoolResponse();
		BeanUtils.copyProperties(d, r);
		return r;
		
	}
	
	@RequestMapping(value = "/addSchoolToFav", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public StudentProfileResponse addSchoolToFav(@RequestParam(value = "studentId") int studentId
			, @RequestParam(value = "schoolId") int schoolId
			, @RequestParam(value = "note") String note){
		
		StudentProfileData d = studentMgr.addSchoolToFav(studentId, schoolId, note);
		StudentProfileResponse r = new StudentProfileResponse();
		
		BeanCopy.copyProperties(d, r);

		return r;
		
	}
	
	@RequestMapping(value = "/removeFromFav", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public StudentProfileResponse removeFromFav(@RequestParam(value = "studentId") int studentId
			, @RequestParam(value = "favId") int favId){
		
		StudentProfileData d = studentMgr.removeFromFav(studentId, favId);
		StudentProfileResponse r = new StudentProfileResponse();
		BeanCopy.copyProperties(d, r);
		return r;
		
	}
	
	@RequestMapping(value = "/getStudentProfile", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public StudentProfileResponse getStudentProfile(@RequestParam(value = "email") String email){
		
		StudentProfileData d = studentMgr.getStudentProfile(email);
		StudentProfileResponse r = new StudentProfileResponse();
		BeanCopy.copyProperties(d, r);
		return r;
	}
	
	@RequestMapping(value = "/tokenSignIn", method = RequestMethod.POST
			, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public StudentProfileResponse tokenSignIn(@RequestBody StudentProfileRequest userProfile){
		
		StudentProfileData d = studentMgr.tokenSignIn(userProfile);
		StudentProfileResponse r = new StudentProfileResponse();
		BeanCopy.copyProperties(d, r);
		return r;
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
	public StudentProfileResponse createStudentProfile(@RequestBody StudentProfileData studentInfo){
		
		StudentProfileData d = studentMgr.createStudentProfile(studentInfo);
		StudentProfileResponse r = new StudentProfileResponse();
		BeanCopy.copyProperties(d, r);
		return r;
	}
	
	
}
