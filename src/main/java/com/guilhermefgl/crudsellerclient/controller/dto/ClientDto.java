package com.guilhermefgl.crudsellerclient.controller.dto;

import java.util.ArrayList;
import java.util.List;

import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

import com.guilhermefgl.crudsellerclient.model.enums.GenderEnum;
import com.guilhermefgl.crudsellerclient.util.Constants;
import com.guilhermefgl.crudsellerclient.util.validor.CpfValidator;
import com.guilhermefgl.crudsellerclient.util.validor.NameValidator;

public class ClientDto {

	private Long id;
	private String name;
	private String cpf;
	private GenderEnum gender;
	private List<SellerDto> sellers = new ArrayList<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public GenderEnum getGender() {
		return gender;
	}

	public void setGender(GenderEnum gender) {
		this.gender = gender;
	}

	public List<SellerDto> getSellers() {
		return sellers;
	}

	public void setSellers(List<SellerDto> sellers) {
		this.sellers = sellers;
	}

	public void validate(BindingResult result) {
		if (!NameValidator.isValid(name)) {
			result.addError(new ObjectError(name, Constants.Messages.MSG_NAME_INVALID));
		}
		if (!CpfValidator.isValid(cpf)) {
			result.addError(new ObjectError(cpf, Constants.Messages.MSG_CPF_INVALID));
		}
	}

}
