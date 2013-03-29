package kr.pe.ihoney.type;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.junit.Test;

public class SimpleEnumTest {

	@Test
	public void enum의values확인() {
		assertThat(SimpleEnum.values().length, is(5));
	}

	@Test
	public void enum_switch_활용방법() {
		int result = switchEnum(SimpleEnum.FIRST);
		assertThat(result, is(1));
	}
	
	@Test
	public void printENUM() {
		System.out.println(SimpleEnum.FIRST);
	}
	
	@Test
	public void printEnumValues() {
		for(SimpleEnum simpleEnum : SimpleEnum.values())
			System.out.println(simpleEnum);
	}

	private int switchEnum(SimpleEnum inputEnum) {
		int result = 0;
		switch (inputEnum) {
		case FIRST:
			result = 1;
			break;
		case SECOND:
			result = 2;
			break;
		case THIRD:
			result = 3;
			break;
		case FOURTH:
			result = 4;
			break;
		case FIFTH:
			result = 5;
			break;
		default:
			break;
		}
		
		return result;
	}
}
