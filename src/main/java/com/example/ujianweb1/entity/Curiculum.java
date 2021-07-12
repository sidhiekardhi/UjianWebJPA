package com.example.ujianweb1.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name="curiculum")

public class Curiculum {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String fullName;
	private String email_address;
	private String favorite_platform;
	private String file_cv;	
}
