package jp.co.ccube.ss.service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.ccube.ss.dao.ChargeDao;
import jp.co.ccube.ss.entity.Charge;
import jp.co.ccube.ss.form.ChargeForm;

@Service
public class ChargeService {
	@Autowired
	private ChargeDao chargeDao;

	// ～～案件担当者の登録～～
	public void registCharge(ChargeForm form) throws ParseException {

		Charge charge = new Charge();

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
		charge.setProjectId(3);
		charge.setCaseId(3);
		// charge.setProjectId(form.getProject_id());
		// charge.setCaseId(form.getCase_id());
		// charge.setBranchNo(5);
		charge.setEmployeeNo(form.getEmployeeNo());
		charge.setClientId(form.getClientId());
		charge.setEngineerName(form.getEngineerName());
		charge.setPrice(form.getPrice());
		charge.setExcessAmount(form.getExcessAmount());
		charge.setStartDate(startDate);
		charge.setEndDate(endDate);
		charge.setManHours(form.getManHours());
		chargeDao.insertSelective(charge);
	}

	// ～～案件担当者情報の編集対象検索～～
	public ChargeForm editChargeSearch(ChargeForm form) {
		Integer projectId[] = new Integer[1];
		projectId[0] = 3;
		Charge charge = new Charge();
		System.out.println(projectId[0]);
		charge = chargeDao.selectByPrimaryKey(projectId[0]);

		// 開始予定日の設定
		SimpleDateFormat starty = new SimpleDateFormat("yyyy");
		String startyear = starty.format(charge.getStartDate());
		SimpleDateFormat startm = new SimpleDateFormat("MM");
		String startmonth = startm.format(charge.getStartDate());
		SimpleDateFormat startd = new SimpleDateFormat("dd");
		String startday = startd.format(charge.getStartDate());

		// 終了予定日の設定
		SimpleDateFormat endy = new SimpleDateFormat("yyyy");
		String endyear = endy.format(charge.getEndDate());
		SimpleDateFormat endm = new SimpleDateFormat("MM");
		String endmonth = endm.format(charge.getEndDate());
		SimpleDateFormat endd = new SimpleDateFormat("dd");
		String endday = endd.format(charge.getEndDate());

		form.setEmployeeNo(charge.getEmployeeNo());
		form.setClientId(charge.getClientId());
		form.setEngineerName(charge.getEngineerName());
		form.setPrice(charge.getPrice());
		form.setExcessAmount(charge.getExcessAmount());
		form.setStartYear(startyear);
		form.setStartMonth(startmonth);
		form.setStartDay(startday);
		form.setEndYear(endyear);
		form.setEndMonth(endmonth);
		form.setEndDay(endday);
		form.setManHours(charge.getManHours());

		return form;
	}

	// ～～案件担当者情報の編集～～
	public void editCharge(ChargeForm form) throws ParseException {

		Integer projectId[] = new Integer[1];
		projectId[0] = 3;
		Charge charge = new Charge();
		charge = chargeDao.selectByPrimaryKey(projectId[0]);

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
		charge.setEmployeeNo(form.getEmployeeNo());
		charge.setClientId(form.getClientId());
		charge.setEngineerName(form.getEngineerName());
		charge.setPrice(form.getPrice());
		charge.setExcessAmount(form.getExcessAmount());
		charge.setStartDate(startDate);
		charge.setEndDate(endDate);
		charge.setManHours(form.getManHours());
		chargeDao.updateByPrimaryKeySelective(charge);
	}

	// ～～エンジニア情報の削除～～
	public void chargeDelete(ChargeForm form) {
		Integer projectId[] = new Integer[1];
		projectId[0] = 3;
		Integer subProjectId[] = new Integer[1];
		subProjectId[0] = 3;
		Integer branchNo[] = new Integer[1];
		branchNo[0] = 3;

		// engineerDao.deleteByPrimaryKey(projectId[0],subProjectId[0],branchNo[0]);
		chargeDao.deletedAtUpdate(projectId[0], subProjectId[0], branchNo[0]);
	}

}
