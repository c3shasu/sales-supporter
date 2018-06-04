package jp.co.ccube.ss.config;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public  class CheckBoxItemConfig {


	//ユーザ権限種別
	public static final Map<String, Integer> PREMISSION_ITEMS =
		    Collections.unmodifiableMap(new LinkedHashMap<String, Integer>() {
		    {
		      put("管理職", 8);
		      put("企画開発部", 4);
		      put("営業部", 2);
		      put("総務部", 1);
		    }
		  });
	//顧客種別
	public static final Map<String, Integer> CLIENTTYPE_ITEMS =
		    Collections.unmodifiableMap(new LinkedHashMap<String, Integer>() {
		    {
		      put("案件紹介", 1);
		      put("人材紹介", 2);
		    }
		  });

}
