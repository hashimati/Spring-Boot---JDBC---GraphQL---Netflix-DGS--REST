package io.hashimati.baseApp;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.apache.commons.text.CaseUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Locale;

@SpringBootApplication
public class BaseAppApplication {

	public static void main(String[] args) {


		System.out.println(camelToSnake("AhelloWddf").toUpperCase(Locale.ROOT));
		SpringApplication.run(BaseAppApplication.class, args);
	}

	public static String camelToSnake(final String camelStr)
	{
		String ret = camelStr.replaceAll("([A-Z]+)([A-Z][a-z])", "$1_$2").replaceAll("([a-z])([A-Z])", "$1_$2");
		return ret.toLowerCase();
	}




}
