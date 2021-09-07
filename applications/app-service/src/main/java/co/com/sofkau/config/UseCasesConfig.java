package co.com.sofkau.config;

import co.com.sofkau.model.products.gateways.ProductsRepository;
import co.com.sofkau.usecase.createproducts.CreateProductsUseCase;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(basePackages = "co.com.sofkau.usecase",
        includeFilters = {
                @ComponentScan.Filter(type = FilterType.REGEX, pattern = "^.+UseCase$")
        },
        useDefaultFilters = false)
public class UseCasesConfig {

      CreateProductsUseCase createProductsUseCase(ProductsRepository productsRepository){
              return new CreateProductsUseCase(productsRepository);
      }
}
