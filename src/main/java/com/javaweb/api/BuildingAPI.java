package com.javaweb.api;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.javaweb.model.BuildingDTO;
import com.javaweb.service.BuildingService;

import customException.FieldRequiredException;

@RestController
public class BuildingAPI {
	@Autowired
	private BuildingService buildingService;

	@GetMapping(value = "/api/building")
	public List<BuildingDTO> getBuilding(@RequestParam(value = "name", required = false) String name) {
		List<BuildingDTO> result = buildingService.findAll(name);
		return result;
	}

	public void valiDate(BuildingDTO buildingDTO) {
		if (buildingDTO.getName() == null || buildingDTO.getName().equals("")
				|| buildingDTO.getNumberOfBasement() == null)
			throw new FieldRequiredException("name or number not null");
	}


	@GetMapping(value = "/test") 
	public Map<String,String> test() {
		Map<String,String> result = new HashMap<>();

		result.put("code","200");
		result.put("msg", "OK");
		return result;
	}
	

	@GetMapping(value = "/building/{userId}")
	public Integer getPath(@PathVariable Integer userId) {
		return userId;
	}
}
