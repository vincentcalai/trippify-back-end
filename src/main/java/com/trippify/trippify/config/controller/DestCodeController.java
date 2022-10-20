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
import com.trippify.trippify.config.model.DestCodeViewVO;
import com.trippify.trippify.config.service.DestCodeService;

@CrossOrigin(origins = "http://localhost:4401", allowedHeaders = "*")
@RestController
@RequestMapping(path = "/code")
public class DestCodeController {

	private static final String CD_TYP = "cdTyp";

	@Autowired
	private DestCodeService codeService;

	@GetMapping("/retrieveCodeResult")
	public ConfigResponseBean retrieveCodeResult() {
		ConfigResponseBean response = new ConfigResponseBean();
		Map<String, List<DestCodeViewVO>> destCdMap = this.retrieveCodes();

		Map<String, Map<String, ?>> result = new HashMap<>();
		result.put(CD_TYP, destCdMap);

		response.setResult(result);
		return response;

	}

	private Map<String, List<DestCodeViewVO>> retrieveCodes() {
		return this.codeService.retrieveCodes();
	}
}
