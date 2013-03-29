package kr.pe.ihoney.type;

public enum CodeEnum implements CodeEncodableEnum {
	FIRST("first"),
	SECOND("second"),
	THIRD("third"),
	FOURTH("fourth"),
	FIFTH("fifth");
	
	private String code;
	
	CodeEnum(String code) {
		this.code = code;
	}

	@Override
	public String getCode() {
		return this.code;
	}
}
