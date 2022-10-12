package com.trippify.trippify.config.dao.ICodeDao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.trippify.trippify.config.view.ICodeDao.CodeView;

@Repository
public interface ICodeDAO extends JpaRepository<CodeView, Long> {

	List<CodeView> findByCdTyp(String cd);

}
