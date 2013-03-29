package kr.pe.ihoney.type;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.core.convert.converter.GenericConverter;
import org.springframework.format.support.FormattingConversionServiceFactoryBean;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

public class CodeEnumTest {

	/**
	 * {@link SimpleEnum}과 쓰임새가 크게 다르지 않다.
	 * CodeEncodableEnum 을 구현한 enum은 리턴받은 enum이 어떤 것인지 확인하는 용도로 getCode() 를 사용할 수 있도록 정의한다. 
	 * 
	 * Enum을 String으로 변환하는 Coverter를 Spring의 conversionService에 등록해두면 controller 에서 {@link PathVariable}에 적용할 수 있다.
	 */
	
	@Test
	public void test() {
		CodeEnum firstCodeEnum = findCodeEnum("first");
		assertEquals(CodeEnum.FIRST, firstCodeEnum);
		
		CodeEnum secondCodeEnum = findCodeEnum("second");
		assertEquals(CodeEnum.SECOND, secondCodeEnum);
	}

	private CodeEnum findCodeEnum(String inputCode) {
		if(inputCode.equals(CodeEnum.FIRST.getCode()))
			return CodeEnum.FIRST;
		if(inputCode.equals(CodeEnum.SECOND.getCode()))
			return CodeEnum.SECOND;
		if(inputCode.equals(CodeEnum.THIRD.getCode()))
			return CodeEnum.THIRD;
		if(inputCode.equals(CodeEnum.FOURTH.getCode()))
			return CodeEnum.FOURTH;
		if(inputCode.equals(CodeEnum.FIFTH.getCode()))
			return CodeEnum.FIFTH;
		else
			return null;
	}
	
	@RequestMapping(value="/test/{ordinal}")
	public void sample(@PathVariable("ordinal") CodeEnum codeEnum) {
		// "/test/first"
		// "/test/second"
		// "/test/third"
		// "/test/fourth"
		// "/test/fifth"
		// 에 대한 처리를 하나의 메소드에서 할 수 있음
	}
}
