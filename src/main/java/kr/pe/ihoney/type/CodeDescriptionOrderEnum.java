package kr.pe.ihoney.type;

import java.util.Set;
import java.util.TreeSet;

import org.apache.taglibs.standard.extra.spath.Step;
import org.apache.taglibs.standard.tag.common.core.SetSupport;
import org.springframework.core.OrderComparator;
import org.springframework.core.Ordered;

import com.google.common.collect.Sets;

public enum CodeDescriptionOrderEnum implements CodeEncodableEnum, Ordered {
	THIRD("third", "세번째", 3),
	SECOND("second", "두번째", 2),
	FIRST("first", "첫번째", 1),
	FOURTH("fourth", "네번째", 4),
	FIFTH("fifth", "다섯번째", 5);

	private String code;
	private String description;
	private int order;
	
	CodeDescriptionOrderEnum(String code, String description, int order) {
		this.code = code;
		this.description = description;
		this.order = order;
	}

	@Override
	public int getOrder() {
		return this.order;
	}

	@Override
	public String getCode() {
		return this.code;
	}

	public String getDescription() {
		return description;
	}

	public static final CodeDescriptionOrderEnum valueFromOrder(int order) {
		for(CodeDescriptionOrderEnum codeEnum : values()) {
			if(codeEnum.getOrder() == order)
				return codeEnum;
		}
		
		throw new IllegalArgumentException("Unknown order " + order + " for enum type " + CodeDescriptionOrderEnumTest.class.getSimpleName());
	}
	
	/**
	 * @param sort
	 * @return
	 * order를 기준으로 정렬된 enum목록이 필요한 경우(View단에서 select에 정렬된 값으로 보여주는 용도?)
	 */
	public static final Set<CodeDescriptionOrderEnum> values(boolean sort) {
		Set<CodeDescriptionOrderEnum> enums = null;
		if(sort) {
			enums = new TreeSet<CodeDescriptionOrderEnum>(new OrderComparator());
			for(CodeDescriptionOrderEnum step : values())
				enums.add(step);
		} else {
			enums = Sets.newHashSet(values());
		}
		
		return enums;
	}
}
