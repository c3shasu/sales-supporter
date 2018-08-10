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
	public   EngineerForm editEngineerSearch(EngineerForm form) throws ParseException {

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
							engineer.setCaseId(10);
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
							//engineerDao.insertSelective(engineer);
						}
	}