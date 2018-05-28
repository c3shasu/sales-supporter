package jp.co.ccube.ss.config;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public  class CheckBoxItemConfig {


	//権限の中身
	public static final Map<String, Integer> PREMISSION_ITEMS =
		    Collections.unmodifiableMap(new LinkedHashMap<String, Integer>() {
		    {
		      put("管理職", 8);
		      put("企画開発部", 4);
		      put("営業部", 2);
		      put("総務部", 1);
		    }
		  });

}
