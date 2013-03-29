package kr.pe.ihoney.type;

import static org.junit.Assert.*;

import org.junit.Test;

public class CodeDescriptionEnumTest {

	@Test
	public void test() {
		
		/**
		 * Enum 에 선언된 description은 해당하는 Enum에 대한 설명을 위한 용도로 사용됨.
		 * 비교의 대상이 되는 것은 code으로 처리
		 */
		
		assertEquals("첫번째", CodeDescriptionEnum.FIRST.getDescription());
		assertEquals("두번째", CodeDescriptionEnum.SECOND.getDescription());
		assertEquals("세번째", CodeDescriptionEnum.THIRD.getDescription());
		assertEquals("네번째", CodeDescriptionEnum.FOURTH.getDescription());
		assertEquals("다섯번째", CodeDescriptionEnum.FIFTH.getDescription());
	}
}
