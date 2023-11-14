package com.opeyemi.banking.entity;

import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.format.annotation.DateTimeFormat;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
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

	@CreationTimestamp
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "trans_date")
	private Date transDate;

	@Column(name = "amount")
	private String amount;

	@Column(name = "trans_type")
	private String transType;

	@Column(name = "description")
	private String description;



	@ManyToOne(optional = false)
	@JoinColumn(name = "user_id", referencedColumnName = "id")
	private User users;
}
