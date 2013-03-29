package kr.pe.ihoney.type;

public enum CodeDescriptionEnum implements CodeEncodableEnum {
	FIRST("first", "첫번째"),
	SECOND("second", "두번째"),
	THIRD("third", "세번째"),
	FOURTH("fourth", "네번째"),
	FIFTH("fifth", "다섯번째");
	
	private String code;
	private String description;
	
	CodeDescriptionEnum(String code, String description) {
		this.code = code;
		this.description = description;
	}

	@Override
	public String getCode() {
		return this.code;
	}

	public String getDescription() {
		return description;
	}
}