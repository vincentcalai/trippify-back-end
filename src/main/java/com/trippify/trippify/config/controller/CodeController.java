package com.trippify.trippify.config.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trippify.trippify.common.model.ConfigResponseBean;
import com.trippify.trippify.config.model.CodeViewVO;
import com.trippify.trippify.config.service.CodeService;

@CrossOrigin(origins = "http://localhost:4401", allowedHeaders = "*")
@RestController
@RequestMapping(path = "/code")
public class CodeController {

	private static final String CD_TYP = "cdTyp";
	// private static final String CD_CITY = "CITY";
	private static final String CD_CTRY = "CTRY";

	@Autowired
	private CodeService codeService;

	@GetMapping("/retrieveCodeResult")
	public ConfigResponseBean retrieveCodeResult() {
		ConfigResponseBean response = new ConfigResponseBean();
		// Map<String, List<CodeViewVO>> citiesMap = this.retrieveCityCode(CD_CITY);
		Map<String, List<CodeViewVO>> ctryMap = this.retrieveCodes(CD_CTRY);

		Map<String, Map<String, ?>> result = new HashMap<>();
		// result.put(CD_TYP, citiesMap);
		result.put(CD_TYP, ctryMap);

		response.setResult(result);
		return response;

	}

	private Map<String, List<CodeViewVO>> retrieveCodes(String cd) {
		return this.codeService.retrieveCodes(cd);
	}
}
