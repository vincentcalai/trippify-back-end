package com.trippify.trippify.config.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.trippify.trippify.config.dao.IDestCodeDAO;
import com.trippify.trippify.config.model.DestCodeViewVO;
import com.trippify.trippify.config.view.DestCodeView;

@Transactional
@Service
public class DestCodeService {

	private static final String CD_DEST = "CD_DEST";

	@Autowired
	private IDestCodeDAO destCodeDAO;

	public Map<String, List<DestCodeViewVO>> retrieveCodes() {
		Map<String, List<DestCodeViewVO>> codeMap = new HashMap<>();
		List<DestCodeView> list = destCodeDAO.findAll();
		List<DestCodeViewVO> codeViewVOList = new ArrayList<>();
		list.forEach(rec -> {
			DestCodeViewVO codeViewVO = new DestCodeViewVO();
			codeViewVO.setId(rec.getId());
			codeViewVO.setCtry(rec.getCtry());
			codeViewVO.setCity(rec.getCity());
			codeViewVOList.add(codeViewVO);
		});
		codeMap.put(CD_DEST, codeViewVOList);
		return codeMap;
	}
}
