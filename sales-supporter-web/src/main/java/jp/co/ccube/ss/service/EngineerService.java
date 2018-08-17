package jp.co.ccube.ss.service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.ccube.ss.dao.EngineerDao;
import jp.co.ccube.ss.entity.Engineer;
import jp.co.ccube.ss.form.CaseDispatchEngineerForm;
import jp.co.ccube.ss.form.EngineerForm;

@Service
public class EngineerService {
	@Autowired
	private EngineerDao engineerDao;
	// 編集対象検索
	public   EngineerForm engineerSearch(EngineerForm form) throws ParseException {
		Engineer engineer = new Engineer();

		engineer.setProjectId(10);
		engineer.setCaseId(9);
		engineer.setBranchNo(6);

		engineer = engineerDao.deleteSelect(engineer);
		//開始予定日の設定
		SimpleDateFormat starty = new SimpleDateFormat("yyyy");
		String startyear = starty.format(engineer.getStartDate());

		SimpleDateFormat startm = new SimpleDateFormat("MM");
		String startmonth = startm.format(engineer.getStartDate());

		SimpleDateFormat startd = new SimpleDateFormat("dd");
		String startday = startd.format(engineer.getStartDate());

		String startYms = startyear+startmonth+startday;

	//終了予定日の設定
		SimpleDateFormat endy = new SimpleDateFormat("yyyy");
		String endyear = endy.format(engineer.getEndDate());

		SimpleDateFormat endm = new SimpleDateFormat("MM");
		String endmonth = endm.format(engineer.getEndDate());

		SimpleDateFormat endd = new SimpleDateFormat("dd");
		String endday = endd.format(engineer.getEndDate());

		String endYms = endyear+endmonth+endday;
System.out.println("1");
		form.setProjectId(engineer.getProjectId());
		form.setCaseId(engineer.getCaseId());
		form.setEmployeeNo(engineer.getEmployeeNo());
		form.setClientId(engineer.getClientId());
		form.setEngineerName(engineer.getEngineerName());
		form.setPrice(engineer.getPrice());
		form.setExcessPrice(engineer.getExcessPrice());
		form.setDeductionPrice(engineer.getDeductionPrice());
		form.setCost(engineer.getCost());
		form.setExcessCost(engineer.getExcessCost());
		form.setDeductionCost(engineer.getDeductionCost());
		form.setStartYms(startYms);
		form.setEndYms(endYms);
		form.setManHours(engineer.getManHours());
		return form;
	}
	// ～～エンジニア情報の登録～～
			public  void insertEngineer(CaseDispatchEngineerForm form) throws ParseException  {
							Engineer engineer = new Engineer();
						//開始日String→Date
							String startyear =form.getEngineerStartYear();
							String startmonth =form.getEngineerStartMonth();
							String startday =form.getEngineerStartDay();
							String startymd = startyear+startmonth+startday;
							DateFormat startFormat=new SimpleDateFormat("yyyyMMdd");
							Date startDate = startFormat.parse(startymd);

						//終了日String→Date
							String endyesr =form.getEngineerEndYear();
							String endmonth =form.getEngineerEndMonth();
							String endday =form.getEngineerEndDay();
							String endymd = endyesr+endmonth+endday;
							DateFormat endFormat=new SimpleDateFormat("yyyyMMdd");
							Date endDate = endFormat.parse(endymd);

						//エンティティに登録
							engineer.setProjectId(10);//
							engineer.setCaseId(9);
							//engineer.setEmployeeNo(form.getEmployeeNo());
							//engineer.setClientId(form.getClientId());
							engineer.setEmployeeNo(3);
							engineer.setClientId(3);
							engineer.setEngineerName(form.getEngineerName());
							engineer.setPrice(form.getPrice());
							engineer.setExcessPrice(form.getExcessPrice());
							engineer.setDeductionPrice(form.getDeductionPrice());
							engineer.setCost(form.getCost());
							engineer.setExcessCost(form.getExcessCost());
							engineer.setDeductionCost(form.getDeductionCost());
							engineer.setStartDate(startDate);
							engineer.setEndDate(endDate);
							engineer.setManHours(form.getManHours());
				// 情報をDBに保存
							engineerDao.insertSelective(engineer);
						}
			//～～エンジニア情報の削除～～
			public  void engineerDelete(EngineerForm form) throws ParseException  {
				Integer projectId[] = new Integer[1];
				projectId[0]=10;
				Integer subProjectId[] = new Integer[1];
				subProjectId[0]=9;
				Integer branchNo[] = new Integer[1];
				branchNo[0]=6;

				//engineerDao.deleteByPrimaryKey(projectId[0],subProjectId[0],branchNo[0]);
			}
	}