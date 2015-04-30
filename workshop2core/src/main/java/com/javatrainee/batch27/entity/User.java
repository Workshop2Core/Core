package com.javatrainee.batch27.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the USERS database table.
 * 
 */
@Entity
@Table(name="USERS")
@NamedQuery(name="User.findAll", query="SELECT u FROM User u")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private long iduser;

	private String password;

	private BigDecimal saldo;

	private String username;

	//bi-directional many-to-one association to LoginHistory
	@OneToMany(mappedBy="user")
	private List<LoginHistory> loginHistories;

	//bi-directional many-to-one association to OrderHistory
	@OneToMany(mappedBy="user")
	private List<OrderHistory> orderHistories;

	//bi-directional many-to-one association to PasswordHistory
	@OneToMany(mappedBy="user")
	private List<PasswordHistory> passwordHistories;

	//bi-directional many-to-one association to TransaksiSaham
	@OneToMany(mappedBy="user")
	private List<TransaksiSaham> transaksiSahams;

	public User() {
	}

	public long getIduser() {
		return this.iduser;
	}

	public void setIduser(long iduser) {
		this.iduser = iduser;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public BigDecimal getSaldo() {
		return this.saldo;
	}

	public void setSaldo(BigDecimal saldo) {
		this.saldo = saldo;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<LoginHistory> getLoginHistories() {
		return this.loginHistories;
	}

	public void setLoginHistories(List<LoginHistory> loginHistories) {
		this.loginHistories = loginHistories;
	}

	public LoginHistory addLoginHistory(LoginHistory loginHistory) {
		getLoginHistories().add(loginHistory);
		loginHistory.setUser(this);

		return loginHistory;
	}

	public LoginHistory removeLoginHistory(LoginHistory loginHistory) {
		getLoginHistories().remove(loginHistory);
		loginHistory.setUser(null);

		return loginHistory;
	}

	public List<OrderHistory> getOrderHistories() {
		return this.orderHistories;
	}

	public void setOrderHistories(List<OrderHistory> orderHistories) {
		this.orderHistories = orderHistories;
	}

	public OrderHistory addOrderHistory(OrderHistory orderHistory) {
		getOrderHistories().add(orderHistory);
		orderHistory.setUser(this);

		return orderHistory;
	}

	public OrderHistory removeOrderHistory(OrderHistory orderHistory) {
		getOrderHistories().remove(orderHistory);
		orderHistory.setUser(null);

		return orderHistory;
	}

	public List<PasswordHistory> getPasswordHistories() {
		return this.passwordHistories;
	}

	public void setPasswordHistories(List<PasswordHistory> passwordHistories) {
		this.passwordHistories = passwordHistories;
	}

	public PasswordHistory addPasswordHistory(PasswordHistory passwordHistory) {
		getPasswordHistories().add(passwordHistory);
		passwordHistory.setUser(this);

		return passwordHistory;
	}

	public PasswordHistory removePasswordHistory(PasswordHistory passwordHistory) {
		getPasswordHistories().remove(passwordHistory);
		passwordHistory.setUser(null);

		return passwordHistory;
	}

	public List<TransaksiSaham> getTransaksiSahams() {
		return this.transaksiSahams;
	}

	public void setTransaksiSahams(List<TransaksiSaham> transaksiSahams) {
		this.transaksiSahams = transaksiSahams;
	}

	public TransaksiSaham addTransaksiSaham(TransaksiSaham transaksiSaham) {
		getTransaksiSahams().add(transaksiSaham);
		transaksiSaham.setUser(this);

		return transaksiSaham;
	}

	public TransaksiSaham removeTransaksiSaham(TransaksiSaham transaksiSaham) {
		getTransaksiSahams().remove(transaksiSaham);
		transaksiSaham.setUser(null);

		return transaksiSaham;
	}

}