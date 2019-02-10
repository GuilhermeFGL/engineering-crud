package com.guilhermefgl.crudsellerclient.controller.dto;

import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

import com.guilhermefgl.crudsellerclient.model.enums.GenderEnum;
import com.guilhermefgl.crudsellerclient.util.Constants;
import com.guilhermefgl.crudsellerclient.util.validor.CpfValidator;
import com.guilhermefgl.crudsellerclient.util.validor.NameValidator;

public class ClientDto {

	private static final String PARAM_NAME = "name";
	private static final String PARAM_CPF = "cpf";

	private Long id;
	private String name;
	private String cpf;
	private GenderEnum gender;
	private SellerDto seller;

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

	public SellerDto getSeller() {
		return seller;
	}

	public void setSeller(SellerDto seller) {
		this.seller = seller;
	}

	public void validate(BindingResult result) {
		if (!NameValidator.isValid(name)) {
			result.addError(new ObjectError(PARAM_NAME, Constants.Messages.MSG_NAME_INVALID));
		}
		if (!CpfValidator.isValid(cpf)) {
			result.addError(new ObjectError(PARAM_CPF, Constants.Messages.MSG_CPF_INVALID));
		}
	}

}
