package com.dexin.phenixflowerblooming.config;

import cn.hutool.core.collection.ListUtil;
import com.google.common.collect.Lists;
import java.util.List;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.SecurityScheme;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@Configuration
@EnableSwagger2
public class SwaggerConfig {

  @Bean
  public Docket api() {
    return new Docket(DocumentationType.SWAGGER_2)
        .apiInfo(apiInfo())
        .select()
        .apis(RequestHandlerSelectors.basePackage("com.dexin.phenixflowerblooming.controller"))
        .paths(PathSelectors.any())
        .build()
        .securitySchemes(security());
  }


    /**
     * 统一授权参数
     * @return
     */
    private List<SecurityScheme> security() {
        return ListUtil.toList(new ApiKey("token", "token", "header"));
    }

  private ApiInfo apiInfo() {
    return new ApiInfoBuilder()
        .title("凤凰花开 网络平台 API文档")
        .description("")
        .version("1.0")
        .build();
  }

}
