package apragma.practica;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfig {

	@Bean
	public Docket apiDocket() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("apragma.practica.controller"))
				.paths(PathSelectors.any()).build().apiInfo(getApiInfo());
	}

	private ApiInfo getApiInfo() {
		return new ApiInfo("Documentaci�n del micro Persona CRUD", "A continuaci�n de talles de las opereciones, modelos y dem�s detalles del micro...", "1.0", "URLTerminosCondiciones",
				new Contact("Jorge M. Anaya Le�n", "URLContacto", "Email"), "Licencia", "URLLicencia",
				Collections.emptyList());
	}

}
