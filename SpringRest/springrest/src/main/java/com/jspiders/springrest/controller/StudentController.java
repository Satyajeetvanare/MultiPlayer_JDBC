package com.jspiders.springrest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jspiders.springrest.pojo.StudentPOJO;
import com.jspiders.springrest.response.StudentResponse;
import com.jspiders.springrest.service.StudentService;

@RestController
public class StudentController {
	@Autowired
	private StudentService service;
	StudentResponse response = new StudentResponse();

	@PostMapping(path = "/add", consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = {
			MediaType.APPLICATION_JSON_VALUE })

	private ResponseEntity<StudentResponse> add(@RequestBody StudentPOJO student) {
		StudentPOJO pojo = service.add(student);
		if (pojo != null) {
			// successful response
			return new ResponseEntity<StudentResponse>(new StudentResponse("ok", "Successfully added", pojo, null),
					HttpStatus.ACCEPTED);
		}
		// failed response
		return new ResponseEntity<StudentResponse>(new StudentResponse("Fail", "student not added", pojo, null),
				HttpStatus.BAD_REQUEST);
	}

	@GetMapping(path = "/search{id}", consumes = (MediaType.APPLICATION_JSON_VALUE), produces = {
			MediaType.APPLICATION_JSON_VALUE })

	private ResponseEntity<StudentResponse> search(@PathVariable int id) {
		StudentPOJO pojo = service.search(id);
		if (pojo != null) {
			// success response
			return new ResponseEntity<StudentResponse>(new StudentResponse("Ok", "Find Successsfully..!!", pojo, null),
					HttpStatus.FOUND);

		}
		// failed response
		return new ResponseEntity<StudentResponse>(new StudentResponse("fail", "Not Found", null, null),
				HttpStatus.NOT_FOUND);

	}

	@GetMapping(path = "/diplay", consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = {
			MediaType.APPLICATION_JSON_VALUE })

	private ResponseEntity<StudentResponse> displayAll() {
		List<StudentPOJO> stude = service.displayAll();

		if (stude != null) {
			// success response
			return new ResponseEntity<StudentResponse>(new StudentResponse("ok", "All records are found", null, stude),
					HttpStatus.ACCEPTED);
		}
		// failure response
		return new ResponseEntity<StudentResponse>(new StudentResponse("fail", "Records not found", null, null),
				HttpStatus.BAD_REQUEST);

	}

	@PostMapping(path = "/delete{id}", consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = {
			MediaType.APPLICATION_JSON_VALUE })

	private ResponseEntity<StudentResponse> delete(@PathVariable int id) {
		StudentPOJO pojo = service.delete(id);
		if (pojo != null) {
			return new ResponseEntity<StudentResponse>(
					new StudentResponse("ok", "record deleted successfully..!!", pojo, null), HttpStatus.ACCEPTED);
		}
		// failure response
		return new ResponseEntity<StudentResponse>(new StudentResponse("fail", "record not deleted ..!!", pojo, null),
				HttpStatus.ACCEPTED);

	}

	@PostMapping(path = "/update", consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = {
			MediaType.APPLICATION_JSON_VALUE })

	private ResponseEntity<StudentResponse> update(@RequestBody StudentPOJO student) {
		StudentPOJO pojo = service.update(student);
		if (pojo != null) {
			return new ResponseEntity<StudentResponse>(new StudentResponse("ok", "Updated", pojo, null),
					HttpStatus.ACCEPTED);
		}
		return new ResponseEntity<StudentResponse>(new StudentResponse("fail", " Not Updated", null, null),
				HttpStatus.BAD_REQUEST);

	}

}
