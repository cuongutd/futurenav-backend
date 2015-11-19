package com.cuong.futurenav.business;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cuong.futurenav.controller.model.FavSchoolResponse;
import com.cuong.futurenav.controller.model.SchoolResponse;
import com.cuong.futurenav.controller.model.StudentProfileRequest;
import com.cuong.futurenav.dao.FavSchoolJpaRepository;
import com.cuong.futurenav.dao.SchoolJpaRepository;
import com.cuong.futurenav.dao.StudentJpaRepository;
import com.cuong.futurenav.dao.dto.FavSchoolEntity;
import com.cuong.futurenav.dao.dto.SchoolEntity;
import com.cuong.futurenav.dao.dto.StudentEntity;
import com.cuong.futurenav.model.FavSchoolData;
import com.cuong.futurenav.model.SchoolData;
import com.cuong.futurenav.model.StudentProfileData;
import com.cuong.futurenav.util.BeanCopy;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken.Payload;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdTokenVerifier;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;

@Service
public class StudentManager {

	public static final String CLIENT_ID = "654674175844-3b2ds1pblsb7k8cajp8vbtc3jkhncni2.apps.googleusercontent.com";
	public static final String GOOGLE_ISSUER = "https://accounts.google.com";
	public static final String GOOGLE_GROUP_NAME = "GOOGLE";

	@Autowired
	StudentJpaRepository studentRepo;

	@Autowired
	FavSchoolJpaRepository favRepo;

	@Autowired
	SchoolJpaRepository schoolRepo;

	public StudentProfileData addSchoolToFav(int studentId, int schoolId, String note) {

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

	public StudentProfileData removeFromFav(int studentId, int favId) {

		favRepo.delete(favId);

		return getStudentProfile(studentId);
	}

	public StudentProfileData getStudentProfile(int studentId) {

		StudentEntity e = studentRepo.findOne(studentId);
		StudentProfileData p = new StudentProfileData();
		BeanCopy.copyProperties(e, p);

		return p;

	}

	public StudentProfileData getStudentProfile(String email) {

		StudentEntity e = studentRepo.findByEmail(email);
		StudentProfileData p = new StudentProfileData();
		BeanCopy.copyProperties(e, p);

		return p;

	}

	public void takeNoteOnFav(int favId, String note) {

		FavSchoolEntity f = favRepo.findOne(favId);
		f.setNote(note);
		favRepo.save(f);

	}

	public StudentProfileData createStudentProfile(StudentProfileData studentInfo) {

		StudentEntity e = new StudentEntity();
		BeanUtils.copyProperties(studentInfo, e);
		studentRepo.save(e);
		return getStudentProfile(e.getId());

	}

	public StudentProfileData tokenSignIn(StudentProfileRequest userProfile) {

		// verify the token through google
		String userId = verifyGoogleToken(userProfile.getAuthToken());

		if (userId == null) // invalid google token
			return null;

		// check if account exists then return profile
		StudentEntity e = studentRepo.findByNetworkUserIdAndNetworkGroup(userId, userProfile.getNetworkGroup());
		// if not create new one
		if (e == null || e.getId() == null) {
			e = new StudentEntity();
			e.setNameFirst(userProfile.getDisplayName());
			e.setEmail(userProfile.getEmail());
			e.setNetworkGroup(userProfile.getNetworkGroup());
			e.setNetworkUserId(userId);
			e.setPhotoUrl(userProfile.getPhotoUrl());
			studentRepo.save(e);
		}
		return getStudentProfile(e.getId());
	}

	private String verifyGoogleToken(String token) {
		String userId = null;
		try {
			// Set up the HTTP transport and JSON factory
			HttpTransport httpTransport = GoogleNetHttpTransport.newTrustedTransport();
			JsonFactory jsonFactory = JacksonFactory.getDefaultInstance();

			GoogleIdTokenVerifier verifier = new GoogleIdTokenVerifier.Builder(httpTransport, jsonFactory)
					.setAudience(Arrays.asList(CLIENT_ID))
					// If you retrieved the token on Android using the Play
					// Services 8.3 API or newer, set
					// the issuer to "https://accounts.google.com". Otherwise,
					// set the issuer to
					// "accounts.google.com". If you need to verify tokens from
					// multiple sources, build
					// a GoogleIdTokenVerifier for each issuer and try them
					// both.
					.setIssuer(GOOGLE_ISSUER).build();

			// (Receive idTokenString by HTTPS POST)

			GoogleIdToken idToken = verifier.verify(token);
			if (idToken != null) {
				Payload payload = idToken.getPayload();

				userId = payload.getSubject();

				System.out.println("User ID: " + userId);
			} else {
				System.out.println("Invalid ID token.");
			}

		} catch (IOException e) {

			e.printStackTrace();

		} catch (GeneralSecurityException e) {

			e.printStackTrace();

		}
		return userId;
	}
}
