package com.member.domain;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@SequenceGenerator(
		name="JPAMEMBER_SEQ_GEN",
		sequenceName = "JPAMEMBER_SEQ",
		initialValue = 1,
		allocationSize = 1
		)

@Table(name="JPAMEMBER")
public class Member {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "JPAMEMBER_SEQ_GEN")
	@Column(name = "NO")
	private long no;
	@Column(name = "USERID")
	private String userId;
	@Column(name = "PASSWORD")
	private String password;
	@Column(name = "NAME")
	private String name;
	@Column(name = "GENDER")
	private String gender;
	@Column(name = "AGE")
	private int age;
	@Column(name = "REGDATE")
	private Date regDate;	
}
