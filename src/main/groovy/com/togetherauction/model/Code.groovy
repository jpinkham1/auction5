package com.togetherauction.model

class Code extends ModelObject {

	private static final long serialVersionUID = 1L

	private String code
	private String value

	Code(final Integer id, final String code, final String value) {
		super(id)
		setCode(code)
		setValue(value)
	}
	
	String getCode() {
		return code.toUpperCase()
	}


	void setCode(String code) {
		this.code = code
	}


	String getValue() {
		return value
	}


	void setValue(String value) {
		this.value = value
	}

	@Override
	String toString() {
		return getCode()+"="+getValue()
	}
}
