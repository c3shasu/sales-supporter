package jp.co.ccube.ss.config;

import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.boot.autoconfigure.web.WebMvcAutoConfiguration.WebMvcAutoConfigurationAdapter;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.handler.MappedInterceptor;

import jp.co.ccube.ss.login.SessionCheckInterceptor;
import nz.net.ultraq.thymeleaf.LayoutDialect;

@Configuration
public class MvcConfig extends WebMvcAutoConfigurationAdapter {
	@Bean
	public LayoutDialect layoutDialect() {
		return new LayoutDialect();
	}

	@Override
	public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
		Jackson2ObjectMapperBuilder builder = new Jackson2ObjectMapperBuilder().timeZone("Asia/Tokyo")
				.dateFormat(new SimpleDateFormat("yyyy/MM/dd HH:mm:ss"));
		converters.add(new MappingJackson2HttpMessageConverter(builder.build()));
	}

	/**
	 * セッションチェックインターセプターをBean登録
	 */
	@Bean
	public SessionCheckInterceptor sessionCheckInterceptor() {
		return new SessionCheckInterceptor();
	}

	/**
	 * セッションチェックインターセプターの適用
	 *
	 * @return
	 */
	@Bean
	public MappedInterceptor interceptor() {
		return new MappedInterceptor(new String[] { "/**" }, sessionCheckInterceptor());
	}

	//
	// @Override
	// public void addViewControllers(ViewControllerRegistry registry) {
	// registry.setOrder(Ordered.LOWEST_PRECEDENCE);
	// registry.addViewController("/**").setViewName("forward:/login/login.html");


	 @Override
	    public Validator getValidator() {
	        return validator();
	    }

	    @Bean
	    public LocalValidatorFactoryBean validator() {
	        LocalValidatorFactoryBean validator = new LocalValidatorFactoryBean();
	        validator.setValidationMessageSource(messageSource());
	        return validator;
	    }

	    private MessageSource messageSource() {
	        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
	        //プロパティファイルの名前やディレクトリも変更可能
	        messageSource.setBasename("classpath:/ValidationMessages");
	        //UTF-8に設定
	        messageSource.setDefaultEncoding("UTF-8");
	        return messageSource;
	    }

	// }
}
