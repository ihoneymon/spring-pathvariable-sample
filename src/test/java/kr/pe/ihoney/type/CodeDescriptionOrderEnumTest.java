package kr.pe.ihoney.type;

import static org.junit.Assert.*;

import java.util.Iterator;
import java.util.Set;

import org.junit.Test;

public class CodeDescriptionOrderEnumTest {

	/**
	 * {@link Enum}에서 static method으로 제공하는 ordinal()은 Enum에 정의된 순서를 따른다.
	 * {@link CodeDescriptionOrderEnum} 을 보면 순서가 다른데, <code>CodeDescriptionOrderEnu</code>의 순서가 변경되면 의도치 않은 상황이 발생할 수 있게된다.
	 *  그 대표적인 예가 화면View에서 select 값을 지정해줘야하는 경우가 그러한데, Orderd를 구현하고, 이를 기준으로 정렬한 값을 반환하는 메소드를 제공한다.
	 */
	@Test
	public void test() {
		assertNotSame(1, CodeDescriptionOrderEnum.FIRST.ordinal());
	}

	@Test
	public void enumSorted() {
		Set<CodeDescriptionOrderEnum> sortedCodeEnums = CodeDescriptionOrderEnum.values(true);
		int sortedCodeEnumSize = sortedCodeEnums.size();
		Iterator<CodeDescriptionOrderEnum> iterator = sortedCodeEnums.iterator();
		for(int i = 0; i < sortedCodeEnumSize; i++) {
			System.out.println("정렬된 Enum : " + iterator.next());
		}
	}
	
	@Test
	public void enumUnsorted() {
		Set<CodeDescriptionOrderEnum> sortedCodeEnums = CodeDescriptionOrderEnum.values(false);
		int sortedCodeEnumSize = sortedCodeEnums.size();
		Iterator<CodeDescriptionOrderEnum> iterator = sortedCodeEnums.iterator();
		for(int i = 0; i < sortedCodeEnumSize; i++) {
			System.out.println("미정렬된 Enum : " + iterator.next());
		}
	}
}
