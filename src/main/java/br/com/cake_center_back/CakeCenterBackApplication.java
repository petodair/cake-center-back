package br.com.cake_center_back;

import br.com.cake_center_back.entity.Product;
import br.com.cake_center_back.repository.ProductRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import javax.naming.Context;
import java.math.BigDecimal;

@SpringBootApplication
public class CakeCenterBackApplication {

	public static void main(String[] args) {
		SpringApplication.run(CakeCenterBackApplication.class, args);
	}
}
