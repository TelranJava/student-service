package telran.java52.configuration;

import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration.AccessLevel;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceConfiguration {

	@Bean // добавить в апл контекст
	ModelMapper getModelMapper() {
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration()
				.setFieldMatchingEnabled(true) // разрешить вставлять данные напрямую без сеттеров
				.setFieldAccessLevel(AccessLevel.PRIVATE) // в ом числе в приватные поля
				.setMatchingStrategy(MatchingStrategies.STRICT); // полное совпадение имени поля
		return modelMapper;
	}
}
