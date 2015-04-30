package com.javatrainee.batch27.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the PASSWORD_HISTORY database table.
 * 
 */
@Entity
@Table(name="PASSWORD_HISTORY")
@NamedQuery(name="PasswordHistory.findAll", query="SELECT p FROM PasswordHistory p")
public class PasswordHistory implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="PASSWORD_HISTORY_IDPASSWORD_GENERATOR", sequenceName="PASSWORD_HISTORY_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PASSWORD_HISTORY_IDPASSWORD_GENERATOR")
	private long idpassword;

	private String oldpwd;

	private Timestamp timechange;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="IDUSER")
	private User user;

	public PasswordHistory() {
	}

	public long getIdpassword() {
		return this.idpassword;
	}

	public void setIdpassword(long idpassword) {
		this.idpassword = idpassword;
	}

	public String getOldpwd() {
		return this.oldpwd;
	}

	public void setOldpwd(String oldpwd) {
		this.oldpwd = oldpwd;
	}

	public Timestamp getTimechange() {
		return this.timechange;
	}

	public void setTimechange(Timestamp timechange) {
		this.timechange = timechange;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}