package com.opeyemi.banking.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

@Entity
@Table(name = "users_transaction")
public class Transactions {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long Id;

	// @Column(name = "trans_date")
	// private String transDate;

	@Column(name = "amount")
	private String amount;

	@Column(name = "trans_type")
	private String transType;

	@Column(name = "description", unique = true)
	private String descrition;

	@ManyToOne(optional = false)
	@JoinColumn(name = "user_id", referencedColumnName = "id")
	private User user;
}
