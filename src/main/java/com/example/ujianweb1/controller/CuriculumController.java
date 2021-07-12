package com.example.ujianweb1.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.ujianweb1.entity.Curiculum;
import com.example.ujianweb1.repository.CuriculumRepository;
import com.example.ujianweb1.service.CuriculumService;
import com.example.ujianweb1.utility.FileUtility;



@Controller
public class CuriculumController {

	@Autowired
	CuriculumRepository curiculumRepository;
	
	@Autowired
	CuriculumService curiculumService;
	
	@GetMapping("/curiculum/view")
	public String viewIndexTraveller(Model model) {
		model.addAttribute("listCuriculum", curiculumRepository.findAll());	
		return "view_curiculumvitae";
	}
	
	@GetMapping("/curiculum/add")
	public String viewAddTraveller(Model model) {
		// buat penampung data mahasiswa di halaman htmlnya
		model.addAttribute("curiculum",new Curiculum());
		return "add_curiculum";
	}
	
	
	@PostMapping("/curiculum/view")
	  public String addCuriculum(@RequestParam(value = "file") MultipartFile file, @ModelAttribute Curiculum curiculum, Model model) throws IOException {
		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        String uploadDir = "user-photos/" ;
    	
        FileUtility.saveFile(uploadDir, fileName, file);
        
        curiculum.setFile_cv("/"+uploadDir + fileName);
        
		// buat penampung data curiculum di halaman htmlnya
		curiculumService.saveCuriculum(curiculum);
		model.addAttribute("listCuriculum",curiculumRepository.findAll());
		return "view_curiculumvitae";
	}
	
	
}
