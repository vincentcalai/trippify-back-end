package com.trippify.trippify.config.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.trippify.trippify.config.view.DestCodeView;

@Repository
public interface IDestCodeDAO extends JpaRepository<DestCodeView, Long> {
}
