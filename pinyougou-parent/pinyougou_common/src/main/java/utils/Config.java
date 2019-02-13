
    /**  
    * @Title: Config.java
    * @Package utils
    * @Description: TODO(用一句话描述该文件做什么)
    * @author Administrator
    * @date 2019年1月3日
    * @version V1.0  
    */
    
package utils;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
    * @ClassName: Config
    * @Description: TODO(这里用一句话描述这个类的作用)
    * @author Administrator
    * @date 2019年1月3日
    *
    */

@Configuration
@EnableSwagger2
public class Config {
  @Bean
  public Docket createRestApi() {
      // 创建API页面展示信息
      ApiInfo apiInfo = new ApiInfoBuilder()
      // 页面标题 swagger-ui.html的标题
      .title("SpringBoot整合Swagger2")
      // 描述下的链接信息
      .contact(new Contact("Jason", "http://localhost:8080/toLogin", ""))
      // 版本号  页面标题上显示的版本号
      .version("1.0")
      // 页面API文档的描述信息
      .description("API ---------------------------------------------- 描述").build();

      return new Docket(DocumentationType.SWAGGER_2)
              .apiInfo(apiInfo)
              .select()
              .apis(
                      // 将包路径下所有方法扫描成API
                      RequestHandlerSelectors.basePackage("com.tensquare")
                    )
              .paths(PathSelectors.any())
              .build();
  }

}
