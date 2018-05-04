package jp.co.ccube.ss.config;

import javax.servlet.http.HttpSessionListener;
import javax.sql.DataSource;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import jp.co.ccube.ss.listner.SessionListener;

/**
 * アプリケーション設定。
 */
@Configuration
@EnableTransactionManagement
@ComponentScan
public class AppConfig {

	/**
	 * JDBCのトランザクション管理を返却する。
	 *
	 * @param dataSource データソース
	 * @return トランザクション管理
	 */
	@Bean
	@Autowired
	protected PlatformTransactionManager createTransactionManager(DataSource dataSource) {
		return new DataSourceTransactionManager(dataSource);
	}

	/**
	 * SQLセッションを作成する。※不要かも。
	 *
	 * @param dataSource データソース
	 * @return SQLセッションファクトリー
	 */
	@Bean
	public SqlSessionFactoryBean sqlSessionFactory(DataSource dataSource) {
		SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
		sessionFactory.setDataSource(dataSource);
		return sessionFactory;
	}

	/**
	 * セッションリスナーの設定
	 * @return セッションリスナー
	 */
	@Bean
	public ServletListenerRegistrationBean<HttpSessionListener> sessionListener() {
		return new ServletListenerRegistrationBean<HttpSessionListener>(new SessionListener());
	}

}
