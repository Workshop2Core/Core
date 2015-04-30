package com.javatrainee.batch27.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the TRANSAKSI_SAHAM database table.
 * 
 */
@Entity
@Table(name="TRANSAKSI_SAHAM")
@NamedQuery(name="TransaksiSaham.findAll", query="SELECT t FROM TransaksiSaham t")
public class TransaksiSaham implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="TRANSAKSI_SAHAM_IDTRANSAKSI_GENERATOR", sequenceName="TRANSAKSI_SAHAM_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TRANSAKSI_SAHAM_IDTRANSAKSI_GENERATOR")
	private long idtransaksi;

	private BigDecimal lot;

	//bi-directional many-to-one association to Saham
	@ManyToOne
	@JoinColumn(name="IDSAHAM")
	private Saham saham;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="IDUSER")
	private User user;

	public TransaksiSaham() {
	}

	public long getIdtransaksi() {
		return this.idtransaksi;
	}

	public void setIdtransaksi(long idtransaksi) {
		this.idtransaksi = idtransaksi;
	}

	public BigDecimal getLot() {
		return this.lot;
	}

	public void setLot(BigDecimal lot) {
		this.lot = lot;
	}

	public Saham getSaham() {
		return this.saham;
	}

	public void setSaham(Saham saham) {
		this.saham = saham;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}