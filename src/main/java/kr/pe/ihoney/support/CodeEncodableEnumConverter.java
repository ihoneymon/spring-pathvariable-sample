package kr.pe.ihoney.support;

import java.util.Set;

import kr.pe.ihoney.type.CodeDescriptionOrderEnum;
import kr.pe.ihoney.type.CodeEncodableEnum;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.core.convert.converter.GenericConverter;

import com.google.common.collect.ImmutableSet;

/**
 * CodeEncodableEnum 인터페이스를 상속한 Enum <-> String Converter
 * 
 * @author honeymon
 *
 */
public class CodeEncodableEnumConverter implements GenericConverter {

	private static final Logger logger = LoggerFactory.getLogger(CodeEncodableEnumConverter.class);
	
	private final Set<ConvertiblePair> convertiblePairs;
	
	public CodeEncodableEnumConverter() {
		this.convertiblePairs = ImmutableSet.<ConvertiblePair> builder()
				.add(new ConvertiblePair(String.class, CodeDescriptionOrderEnum.class))
				.build();
		
		for(ConvertiblePair convertiblePair : convertiblePairs)
			if(!CodeEncodableEnum.class.isAssignableFrom(convertiblePair.getTargetType()))
				throw new IllegalArgumentException(convertiblePair.getTargetType().getName() + " did not implement the CodeEncodableEnum interface.");
	}

	@Override
	public Set<ConvertiblePair> getConvertibleTypes() {
		return convertiblePairs;
	}

	@Override
	public Object convert(Object source, TypeDescriptor sourceType, TypeDescriptor targetType) {
		String code = (String) source;
		logger.debug("find code :{} in {}", new Object[]{code, targetType.getType().getName()} );
		
		@SuppressWarnings("unchecked")
		Class<? extends CodeEncodableEnum> targetClass = (Class<? extends CodeEncodableEnum>) targetType.getType();
		for(CodeEncodableEnum codeEncodableEnum : targetClass.getEnumConstants())
			if(codeEncodableEnum.getCode().equals(code))
				return codeEncodableEnum;
		
		throw new IllegalArgumentException("Unknown code '" + code + "' for enum type " + targetType.getType().getName());
	}

}
