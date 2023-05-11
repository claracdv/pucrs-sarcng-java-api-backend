package br.com.sarc.core.common.swagger;

import com.google.common.util.concurrent.ListenableFuture;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2).
                tags(
                        new Tag("Predios", "Efetua operações de CRUD para predios"),
                        new Tag("Recursos", "Efetua operações de CRUD para recursos")).
                genericModelSubstitutes(ListenableFuture.class).
                useDefaultResponseMessages(false).
                apiInfo(apiInfo()).
                select().
                apis(RequestHandlerSelectors.basePackage("br.com.sarc.application.controller")).
                paths(PathSelectors.any()).
                build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().
                title("Sarc API").
                description("API com prédio e recurso").
                build();
    }
}
