package jp.co.ccube.ss.plugin;

import java.util.List;

import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;

/**
 * Mybatis-Generator用のプラグインクラス
 */
public class MybatisGeneratorPlugin extends PluginAdapter {

	/**
	 * @see org.mybatis.generator.api.Plugin#validate(java.util.List)
	 */
	@Override
	public boolean validate(List<String> paramList) {
		return true;
	}

	/**
	 * MapperをDaoに変換。
	 * 
	 * @see org.mybatis.generator.api.PluginAdapter#initialized(org.mybatis.generator.api.IntrospectedTable)
	 */
	@Override
	public void initialized(IntrospectedTable introspectedTable) {
		super.initialized(introspectedTable);

		// Mapper -> Dao
		String name = introspectedTable.getMyBatis3JavaMapperType();
		introspectedTable.setMyBatis3JavaMapperType(name.replaceAll("Mapper$", "Dao"));
	}

}
