package com.hostmdy.car.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "Users")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "fullName Required")
	private String fullname;
	
	@Email(message="@ Required")
	@NotBlank(message = "email Required")
	@Column(unique = true)
	private String email;
	
	@NotBlank(message = "password Required")
	private String password;
	
	private String ph;
	private Long role;
	private String status;
}
