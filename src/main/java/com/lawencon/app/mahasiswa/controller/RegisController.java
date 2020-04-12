package com.lawencon.app.mahasiswa.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lawencon.app.mahasiswa.model.Registrasi;
import com.lawencon.app.mahasiswa.service.RegisService;

@RestController
@CrossOrigin("*")
@RequestMapping("/regis")
public class RegisController extends BaseController<Registrasi> {

	@Autowired
	private RegisService regisService;
	
	@GetMapping("/show/all")
	public ResponseEntity<?> getList(){
		List<?> listRegis = new ArrayList<>();
		try {
			listRegis = regisService.findAll();
		} catch (Exception e) {
			return new ResponseEntity<>(listRegis, HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(listRegis, HttpStatus.OK);
	}
	
	@GetMapping("/show/all/{status}")
	public ResponseEntity<?> getListApprove(@PathVariable("status") String status){
		List<?> listApprove = new ArrayList<>();
		try {
			listApprove = regisService.findAllStatus(status);
		} catch (Exception e) {
			return new ResponseEntity<>(listApprove, HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(listApprove, HttpStatus.OK);
	}
	
	@PostMapping("/insert")
	public ResponseEntity<?> getInsert(@RequestBody String content){
		try {
			Registrasi regis = readValue(content, Registrasi.class);
			regisService.insert(regis);
			regisService.sendMail(regis);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>("Failed to Insert", HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>("Success", HttpStatus.OK);
	}
	
	@PostMapping("/update/{id}/{status}")
	public ResponseEntity<?> getupdate(@PathVariable("id")int id, @PathVariable("status")String status){
		try {
			regisService.update(id, status);
		} catch (Exception e) {
			return new ResponseEntity<>("Failed to Update", HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>("Success", HttpStatus.OK);
	}
	
	@PostMapping("/delete/{id}")
	public ResponseEntity<?> getdelete(@PathVariable("id")int id){
		try {
			regisService.delete(id);
		} catch (Exception e) {
			return new ResponseEntity<>("Failed to Delete", HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>("Success", HttpStatus.OK);
	}
}
