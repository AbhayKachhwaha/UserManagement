package com.ashokit.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UnlockAccount {
	
	private String email;
	private String tempPassword;
	private String newPassword;
}
