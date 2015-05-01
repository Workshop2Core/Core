package com.javatrainee.batch27.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the ORDER_HISTORY database table.
 * 
 */
@Entity
@Table(name="ORDER_HISTORY")
@NamedQuery(name="OrderHistory.findAll", query="SELECT o FROM OrderHistory o")
public class OrderHistory implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="ORDER_HISTORY_IDORDER_GENERATOR", sequenceName="ORDER_HISTORY_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ORDER_HISTORY_IDORDER_GENERATOR")
	private long idorder;

	@Temporal(TemporalType.DATE)
	private Date dateorder;

	private BigDecimal idcounterpart;

	private String jenistransaksi;

	private BigDecimal lot;

	private BigDecimal price;

	private String status;

	//bi-directional many-to-one association to Saham
	@ManyToOne
	@JoinColumn(name="IDSAHAM")
	private Saham saham;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="IDUSER")
	private User user;

	public OrderHistory() {
	}

	public long getIdorder() {
		return this.idorder;
	}

	public void setIdorder(long idorder) {
		this.idorder = idorder;
	}

	public Date getDateorder() {
		return this.dateorder;
	}

	public void setDateorder(Date dateorder) {
		this.dateorder = dateorder;
	}

	public BigDecimal getIdcounterpart() {
		return this.idcounterpart;
	}

	public void setIdcounterpart(BigDecimal idcounterpart) {
		this.idcounterpart = idcounterpart;
	}

	public String getJenistransaksi() {
		return this.jenistransaksi;
	}

	public void setJenistransaksi(String jenistransaksi) {
		this.jenistransaksi = jenistransaksi;
	}

	public BigDecimal getLot() {
		return this.lot;
	}

	public void setLot(BigDecimal lot) {
		this.lot = lot;
	}

	public BigDecimal getPrice() {
		return this.price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
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

	@Override
	public String toString() {
		return "OrderHistory [idorder=" + idorder + ", dateorder=" + dateorder
				+ ", idcounterpart=" + idcounterpart + ", jenistransaksi="
				+ jenistransaksi + ", lot=" + lot + ", price=" + price
				+ ", status=" + status + ", saham=" + saham + ", user=" + user
				+ "]";
	}
}