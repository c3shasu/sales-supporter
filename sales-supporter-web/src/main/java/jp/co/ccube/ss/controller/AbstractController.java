package jp.co.ccube.ss.controller;

import javax.servlet.Filter;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.filter.CharacterEncodingFilter;

/**
 * 基底コントローラクラス
 */
@Controller
public abstract class AbstractController {

	/**
	 * 文字エンコードフィルタ
	 * <p>
	 * <ul>
	 * <li>{@link CharacterEncodingFilter#setEncoding(String)
	 * 文字コードフィルタにエンコード}に{@literal UTF-8}設定する。</li>
	 * <li>{@link CharacterEncodingFilter#setForceEncoding(boolean)
	 * 強制エンコードフラグ}に{@literal true}を設定する。</li>
	 * </ul>
	 * </p>
	 * 
	 * @return 文字エンコードフィルタ
	 */
	@Bean
	public Filter characterEncodingFilter() {
		CharacterEncodingFilter filter = new CharacterEncodingFilter();
		filter.setEncoding("UTF-8");
		filter.setForceEncoding(true);
		return filter;
	}

}
