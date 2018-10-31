package com.apap.tutorial7.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.apap.tutorial7.model.PilotModel;
import com.apap.tutorial7.rest.PilotDetail;
import com.apap.tutorial7.rest.Setting;
import com.apap.tutorial7.service.PilotService;

@RestController
@RequestMapping("/pilot")
public class PilotController {
	@Autowired
	private PilotService pilotService;

	@Autowired
	private RestTemplate restTemplate;

	@Bean
	public RestTemplate rest() {
		return new RestTemplate();
	}
	
	@GetMapping("/status/{licenseNumber}")
    public String getStatus(@PathVariable("licenseNumber") String licenseNumber) throws Exception {
        String path = Setting.pilotUrl + "/pilot?licenseNumber=" + licenseNumber;
        return restTemplate.getForEntity(path, String.class).getBody();
    }

    @GetMapping("/full/{licenseNumber}")
    public PilotDetail postStatus(@PathVariable("licenseNumber") String licenseNumber) throws Exception {
        String path = Setting.pilotUrl + "/pilot";
        PilotModel pilotModel = pilotService.getPilotDetailByLicenseNumber(licenseNumber);
        return restTemplate.postForObject(path, pilotModel, PilotDetail.class);
    }

	@PostMapping(value = "/add")
	public PilotModel addPilotSubmit(@RequestBody PilotModel pilot) {
		return pilotService.addPilot(pilot);
	}

	@GetMapping(value = "/view/{licenseNumber}")
	public PilotModel pilotView(@PathVariable("licenseNumber") String licenseNumber) {
		PilotModel pilot = pilotService.getPilotDetailByLicenseNumber(licenseNumber);
		return pilot;
	}

	@DeleteMapping(value = "/delete")
	public String deletePilot(@RequestParam("pilotId") long id) {
		PilotModel pilot = pilotService.getPilotDetailById(id);
		pilotService.deletePilot(pilot);
		return "remove";
	}

	@PutMapping(value = "/update/{pilotId}")
	public String updatePilotSubmit(@PathVariable("pilotId") long pilotId, @RequestParam("name") String name,
			@RequestParam("flyHour") int flyHour) {
		PilotModel pilot = pilotService.getPilotDetailById(pilotId);
		if (pilot.equals(null)) {
			return "Couldn't find your pilot";
		}
		pilot.setName(name);
		pilot.setFlyHour(flyHour);
		pilotService.updatePilot(pilotId, pilot);
		return "updateSuccess";
	}

}
