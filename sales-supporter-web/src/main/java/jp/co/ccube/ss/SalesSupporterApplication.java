package jp.co.ccube.ss;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.context.embedded.ErrorPage;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;

/**
 * アプリケーション実行クラス
 */
@MapperScan("jp.co.ccube.ss.dao")
@SpringBootApplication
public class SalesSupporterApplication {

	/**
	 * メインメソッド
	 * 
	 * @param args パラメータ
	 */
	public static void main(String[] args) {
		SpringApplication.run(SalesSupporterApplication.class, args);
	}

	/**
	 * @return {@link ServletContainerCustomizer}
	 */
	@Bean
	public EmbeddedServletContainerCustomizer containerCustomizer() {
		return new ServletContainerCustomizer();
	}

	/**
	 * HTTPエラーを捕捉する。
	 */
	private static class ServletContainerCustomizer implements EmbeddedServletContainerCustomizer {
		@Override
		public void customize(ConfigurableEmbeddedServletContainer factory) {
			factory.addErrorPages(new ErrorPage(HttpStatus.FORBIDDEN, "/403"));
			factory.addErrorPages(new ErrorPage(HttpStatus.NOT_FOUND, "/404"));
			factory.addErrorPages(new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR, "/500"));
		}
	}
}
