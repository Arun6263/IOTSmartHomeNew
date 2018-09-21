package com.akshar.iot.smarthome.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

@Configuration
@ComponentScan
@EnableSwagger2
@EnableWebMvc
public class SwaggerConfig extends WebMvcConfigurerAdapter  {

    /**
     * User API Swagger config
     *
     * @return
     */
    @Bean
    public Docket userApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("Admin-api")
                .forCodeGeneration(false)
                .apiInfo(apiInfo())
                .select()
                    .apis(RequestHandlerSelectors.basePackage("com.akshar.iot.smarthome.webservice.rest"))
                    .paths(PathSelectors.any())
                    .build(); //.globalOperationParameters(globalParameters())
    }

   

    /**
     * Add API Info
     *
     * @return
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("SMARTHome manager")
                .version("1.0.0")
                .build();
    }

    /**
     * Add global parameters
     *
     *  - x-auth-token (required) (type:header)
     *
     * @return
     */
    private List<Parameter> globalParameters() {
        List<Parameter> parameters = new ArrayList<>();

        parameters.add(new ParameterBuilder()
            .name("x-auth-token")
            .modelRef(new ModelRef("string"))
            .parameterType("header")
            .required(true)
            .build()
        );

        return parameters;
    }
    
    private static final String[] CLASSPATH_RESOURCE_LOCATIONS = {
            "classpath:/META-INF/resources/", "classpath:/resources/",
            "classpath:/static/", "classpath:/public/"
    };
    
    @Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**")
                .addResourceLocations(CLASSPATH_RESOURCE_LOCATIONS);
       
        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
        registry.addResourceHandler("swagger-ui.html")
        .addResourceLocations("classpath:/META-INF/resources/");
    }
}
