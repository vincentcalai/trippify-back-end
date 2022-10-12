package com.trippify.trippify.config.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trippify.trippify.common.model.ConfigResponseBean;
import com.trippify.trippify.config.service.CodeService;

@CrossOrigin(origins = "http://localhost:4401", allowedHeaders = "*")
@RestController
@RequestMapping(path = "/code")
public class CodeController {

	private static final String CD_TYP = "cdTyp";
	private static final String CD_CITY = "CITY";

	@Autowired
	private CodeService codeService;

	@GetMapping("/retrieveCodeResult")
	public ConfigResponseBean retrieveCodeResult() {
		ConfigResponseBean response = new ConfigResponseBean();
		Map<String, Map<Long, String>> citiesMap = this.retrieveCityCode(CD_CITY);

		Map<String, Map<String, ?>> result = new HashMap<>();
		result.put(CD_TYP, citiesMap);

		response.setResult(result);
//		logger.trace(version);
//		Map<String, List<CodeLanguageVO>> cdTyp = null;
//		Map<String, Map<String, List<String>>> cdReln = null;
//		ConfigResponseBean response = this.updateCheck(version);
//		if (response.isUpdate()) {
//			Map<String, Map<String, ?>> result = new HashMap<>();
//			cdTyp = this.retrieveCode();
//			cdReln = this.retrieveCodeReln();
//			result.put(CD_TYP, cdTyp);
//			result.put(CD_RELN, cdReln);
//			response.setResult(result);
//		}
//
//		WSResult wsResult = new WSResult();
//		wsResult.setResultDtTime(DateUtil.dateToString(LocalDateTime.now(), DateUtil.DT_PATTERN));
//		response.setEdeWSResult(wsResult);
		return response;

	}

	private Map<String, Map<Long, String>> retrieveCityCode(String cd) {
		return this.codeService.retrieveCityCode(cd);
	}
}
