package com.javatrainee.batch27.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the LOGIN_HISTORY database table.
 * 
 */
@Entity
@Table(name="LOGIN_HISTORY")
@NamedQuery(name="LoginHistory.findAll", query="SELECT l FROM LoginHistory l")
public class LoginHistory implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="LOGIN_HISTORY_IDLOGIN_GENERATOR", sequenceName="LOGIN_HISTORY_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="LOGIN_HISTORY_IDLOGIN_GENERATOR")
	private long idlogin;

	private Timestamp logintime;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="IDUSER")
	private User user;

	public LoginHistory() {
	}

	public long getIdlogin() {
		return this.idlogin;
	}

	public void setIdlogin(long idlogin) {
		this.idlogin = idlogin;
	}

	public Timestamp getLogintime() {
		return this.logintime;
	}

	public void setLogintime(Timestamp logintime) {
		this.logintime = logintime;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}