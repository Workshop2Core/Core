package com.javatrainee.batch27.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the SAHAM database table.
 * 
 */
@Entity
@NamedQuery(name="Saham.findAll", query="SELECT s FROM Saham s")
public class Saham implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private long idsaham;

	private String deskripsi;

	private BigDecimal lastprice;

	private String nama;

	//bi-directional many-to-one association to OrderHistory
	@OneToMany(mappedBy="saham")
	private List<OrderHistory> orderHistories;

	//bi-directional many-to-one association to TransaksiSaham
	@OneToMany(mappedBy="saham")
	private List<TransaksiSaham> transaksiSahams;

	public Saham() {
	}

	public long getIdsaham() {
		return this.idsaham;
	}

	public void setIdsaham(long idsaham) {
		this.idsaham = idsaham;
	}

	public String getDeskripsi() {
		return this.deskripsi;
	}

	public void setDeskripsi(String deskripsi) {
		this.deskripsi = deskripsi;
	}

	public BigDecimal getLastprice() {
		return this.lastprice;
	}

	public void setLastprice(BigDecimal lastprice) {
		this.lastprice = lastprice;
	}

	public String getNama() {
		return this.nama;
	}

	public void setNama(String nama) {
		this.nama = nama;
	}

	public List<OrderHistory> getOrderHistories() {
		return this.orderHistories;
	}

	public void setOrderHistories(List<OrderHistory> orderHistories) {
		this.orderHistories = orderHistories;
	}

	public OrderHistory addOrderHistory(OrderHistory orderHistory) {
		getOrderHistories().add(orderHistory);
		orderHistory.setSaham(this);

		return orderHistory;
	}

	public OrderHistory removeOrderHistory(OrderHistory orderHistory) {
		getOrderHistories().remove(orderHistory);
		orderHistory.setSaham(null);

		return orderHistory;
	}

	public List<TransaksiSaham> getTransaksiSahams() {
		return this.transaksiSahams;
	}

	public void setTransaksiSahams(List<TransaksiSaham> transaksiSahams) {
		this.transaksiSahams = transaksiSahams;
	}

	public TransaksiSaham addTransaksiSaham(TransaksiSaham transaksiSaham) {
		getTransaksiSahams().add(transaksiSaham);
		transaksiSaham.setSaham(this);

		return transaksiSaham;
	}

	public TransaksiSaham removeTransaksiSaham(TransaksiSaham transaksiSaham) {
		getTransaksiSahams().remove(transaksiSaham);
		transaksiSaham.setSaham(null);

		return transaksiSaham;
	}

}