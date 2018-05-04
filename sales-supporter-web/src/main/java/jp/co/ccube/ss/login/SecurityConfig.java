package jp.co.ccube.ss.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configurers.GlobalAuthenticationConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import jp.co.ccube.ss.service.LoginService;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private AuthenticationSuccessHandler successHandler;

	@Autowired
	private AuthenticationFailureHandler failureHandler;

	@Autowired
	private LogoutHandler logoutHandler;

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/images/**", "/css/**", "/fonts/**", "/javascript/**");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// 認可の設定
		http.authorizeRequests().antMatchers("/", "/login").permitAll().anyRequest().authenticated();

		// ログイン設定
		http.formLogin().loginProcessingUrl("/login").loginPage("/login").successHandler(successHandler)
				.failureHandler(failureHandler).usernameParameter("loginId").passwordParameter("password").and();

		// ログアウト設定
		http.logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout**")).logoutSuccessUrl("/login")
				.addLogoutHandler(logoutHandler);
	}

	@Configuration
	protected static class AuthenticationConfiguration extends GlobalAuthenticationConfigurerAdapter {
		@Autowired
		LoginService loginService;

		@Override
		public void init(AuthenticationManagerBuilder auth) throws Exception {
			// 認証するユーザーを設定する
			auth.userDetailsService(loginService)
					// 入力値をbcryptでハッシュ化した値でパスワード認証を行う
					// .passwordEncoder(new BCryptPasswordEncoder());
					// 平文
					.passwordEncoder(NoOpPasswordEncoder.getInstance());

		}
	}
}
