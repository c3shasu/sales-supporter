package jp.co.ccube.ss.service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.ccube.ss.dao.EntrustedDao;
import jp.co.ccube.ss.entity.Entrusted;
import jp.co.ccube.ss.form.EntrustedForm;

@Service
public class EntrustedService {
	@Autowired
	private EntrustedDao entrustedDao;

	// ～～受託情報登録～～
	public void registEntrusted(EntrustedForm form) throws ParseException {

		Entrusted entrusted = new Entrusted();

		// 開始予定日String→Date
		String startyear = form.getStartYear();
		String startmonth = form.getStartMonth();
		String startday = form.getStartDay();
		String startymd = startyear + startmonth + startday;
		DateFormat startFormat = new SimpleDateFormat("yyyyMMdd");
		Date startDate = startFormat.parse(startymd);

		// 終了予定日String→Date
		String endyesr = form.getEndYear();
		String endmonth = form.getEndMonth();
		String endday = form.getEndDay();
		String endymd = endyesr + endmonth + endday;
		DateFormat endFormat = new SimpleDateFormat("yyyyMMdd");
		Date endDate = endFormat.parse(endymd);

		// DBアクセス
		entrusted.setProjectId(10);
		entrusted.setCaseId(8);
//		entrusted.setProjectId(form.getProject_id());
//		entrusted.setCaseId(form.getCase_id());
		entrusted.setStartDate(startDate);
		entrusted.setEndDate(endDate);
		entrusted.setManHour(form.getManHour());
		entrusted.setPrice(form.getPrice());
		entrusted.setAdditional(form.getAdditional());
		entrusted.setSales(form.getSales());
		entrustedDao.insertSelective(entrusted);
	}

	// ～～受託情報の編集対象検索～～
	public EntrustedForm editEntrustedSearch(EntrustedForm form) {
		Integer projectId[] = new Integer[1];
		projectId[0] = 3;
		Entrusted entrusted = new Entrusted();
		System.out.println(projectId[0]);
		entrusted = entrustedDao.selectByPrimaryKey(projectId[0]);

		// 開始予定日の設定
		SimpleDateFormat starty = new SimpleDateFormat("yyyy");
		String startyear = starty.format(entrusted.getStartDate());
		SimpleDateFormat startm = new SimpleDateFormat("MM");
		String startmonth = startm.format(entrusted.getStartDate());
		SimpleDateFormat startd = new SimpleDateFormat("dd");
		String startday = startd.format(entrusted.getStartDate());

		// 終了予定日の設定
		SimpleDateFormat endy = new SimpleDateFormat("yyyy");
		String endyear = endy.format(entrusted.getEndDate());
		SimpleDateFormat endm = new SimpleDateFormat("MM");
		String endmonth = endm.format(entrusted.getEndDate());
		SimpleDateFormat endd = new SimpleDateFormat("dd");
		String endday = endd.format(entrusted.getEndDate());

		form.setStartYear(startyear);
		form.setStartMonth(startmonth);
		form.setStartDay(startday);
		form.setEndYear(endyear);
		form.setEndMonth(endmonth);
		form.setEndDay(endday);
		// form.setStartDate(entrusted.getStartDate());
		// form.setEndDate(entrusted.getEndDate());
		form.setManHour(entrusted.getManHour());
		form.setPrice(entrusted.getPrice());
		form.setAdditional(entrusted.getAdditional());
		form.setSales(entrusted.getSales());
		return form;
	}

	// ～～受託情報の編集～～
	public void editEntrusted(EntrustedForm form) throws ParseException {

		Integer projectId[] = new Integer[1];
		projectId[0] = 3;
		Entrusted entrusted = new Entrusted();
		entrusted = entrustedDao.selectByPrimaryKey(projectId[0]);

		// 開始予定日String→Date
		String startyear = form.getStartYear();
		String startmonth = form.getStartMonth();
		String startday = form.getStartDay();
		String startymd = startyear + startmonth + startday;
		DateFormat startFormat = new SimpleDateFormat("yyyyMMdd");
		Date startDate = startFormat.parse(startymd);

		// 終了予定日String→Date
		String endyesr = form.getEndYear();
		String endmonth = form.getEndMonth();
		String endday = form.getEndDay();
		String endymd = endyesr + endmonth + endday;
		DateFormat endFormat = new SimpleDateFormat("yyyyMMdd");
		Date endDate = endFormat.parse(endymd);

		// DBアクセス
		entrusted.setStartDate(startDate);
		entrusted.setEndDate(endDate);
		entrusted.setManHour(form.getManHour());
		entrusted.setPrice(form.getPrice());
		entrusted.setAdditional(form.getAdditional());
		entrusted.setSales(form.getSales());
		entrustedDao.updateByPrimaryKeySelective(entrusted);
	}
}
