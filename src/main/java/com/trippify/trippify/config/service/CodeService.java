package com.trippify.trippify.config.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.trippify.trippify.config.dao.ICodeDao.ICodeDAO;
import com.trippify.trippify.config.view.ICodeDao.CodeView;

@Transactional
@Service
public class CodeService {

	private static final String CD_CITY = "CD_CITY";

	@Autowired
	private ICodeDAO codeDAO;

	public Map<String, Map<Long, String>> retrieveCityCode(String cd) {
		Map<String, Map<Long, String>> codeViewMap = new HashMap<>();
		Map<Long, String> citiesMap = new HashMap<>();
		List<CodeView> list = codeDAO.findByCdTyp(cd);
		list.forEach(rec -> citiesMap.put(rec.getId(), rec.getCdDesc()));
		codeViewMap.put(CD_CITY, citiesMap);
		return codeViewMap;
	}
}
