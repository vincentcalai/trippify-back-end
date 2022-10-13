package com.trippify.trippify.config.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.trippify.trippify.config.dao.ICodeDao.ICodeDAO;
import com.trippify.trippify.config.model.CodeViewVO;
import com.trippify.trippify.config.view.ICodeDao.CodeView;

@Transactional
@Service
public class CodeService {

	private static final String CD_CITY = "CD_CITY";

	@Autowired
	private ICodeDAO codeDAO;

	public Map<String, List<CodeViewVO>> retrieveCityCode(String cd) {
		Map<String, List<CodeViewVO>> citiesMap = new HashMap<>();
		List<CodeView> list = codeDAO.findByCdTyp(cd);
		List<CodeViewVO> codeViewVOList = new ArrayList<>();
		list.forEach(rec -> {
			CodeViewVO codeViewVO = new CodeViewVO();
			codeViewVO.setId(rec.getId());
			codeViewVO.setCdDesc(rec.getCdDesc());
			codeViewVOList.add(codeViewVO);
		});
		citiesMap.put(CD_CITY, codeViewVOList);
		return citiesMap;
	}
}
