package com.trippify.trippify.config.view.ICodeDao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_cd")
public class CodeView {

	private long id;
	private String cdTyp;
	private String cdDesc;

	@Id
	@Column(name = "id", nullable = false, precision = 22, scale = 0)
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Column(name = "cd_typ", length = 20, nullable = false)
	public String getCdTyp() {
		return cdTyp;
	}

	public void setCdTyp(String cdTyp) {
		this.cdTyp = cdTyp;
	}

	@Column(name = "cd_desc", length = 50, nullable = false)
	public String getCdDesc() {
		return cdDesc;
	}

	public void setCdDesc(String cdDesc) {
		this.cdDesc = cdDesc;
	}

}
