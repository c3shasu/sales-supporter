package jp.co.ccube.ss.service;



import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.ccube.ss.dao.DispatchDao;
import jp.co.ccube.ss.entity.Dispatch;
import jp.co.ccube.ss.form.CaseDispatchEngineerForm;
import jp.co.ccube.ss.form.DispatchForm;

@Service
public class DispatchService {

	@Autowired
	private   DispatchDao dispatchDao;




		// 編集対象検索
		public   DispatchForm editDispatchSearch(DispatchForm form) throws ParseException {
			//Integer projectId = form.getProjectID();
	Integer projectId[] = new Integer[1];
	projectId[0]=5;
			Dispatch dispatch = new Dispatch();
			dispatch = dispatchDao.selectByPrimaryKey(projectId[0]);
		//開始予定日の設定
			SimpleDateFormat starty = new SimpleDateFormat("yyyy");
			String startyear = starty.format(dispatch.getStartDate());

			SimpleDateFormat startm = new SimpleDateFormat("MM");
			String startmonth = startm.format(dispatch.getStartDate());

			SimpleDateFormat startd = new SimpleDateFormat("dd");
			String startday = startd.format(dispatch.getStartDate());

		//終了予定日の設定
			SimpleDateFormat endy = new SimpleDateFormat("yyyy");
			String endyear = endy.format(dispatch.getEndDate());

			SimpleDateFormat endm = new SimpleDateFormat("MM");
			String endmonth = endm.format(dispatch.getEndDate());

			SimpleDateFormat endd = new SimpleDateFormat("dd");
			String endday = endd.format(dispatch.getEndDate());

		//下限時間設定
			Integer lowerTime1 = dispatch.getLowerTime();
			Integer lowerTimem = lowerTime1%100;
			Integer lowerTime2 = dispatch.getLowerTime();
			Integer lowerTime = lowerTime2/100;

		//上限時間設定
			Integer upperTIme1 = dispatch.getUpperTime();
			Integer upperTIme = upperTIme1%100;
			Integer upperTIme2 = dispatch.getUpperTime();
			Integer upperTImem = upperTIme2/100;

			form.setProjectID(dispatch.getProjectId());
			form.setCaseID(dispatch.getCaseId());
			form.setStartYear(startyear);
			form.setStartMonth(startmonth);
			form.setStartDay(startday);
			form.setEndYear(endyear);
			form.setEndMonth(endmonth);
			form.setEndDay(endday);
			form.setLowerTime(lowerTime);
			form.setLowerTimem(lowerTimem);
			form.setUpperTIme(upperTImem);
			form.setUpperTImem(upperTIme);
			form.setProduction(dispatch.getProduction());
			return form;
		}

		// ～～顧客情報の編集～～
		public  void editDispatch(DispatchForm form) throws ParseException  {
			Dispatch dispatch = new Dispatch();

		//開始予定日String→Date
			String startyear =form.getStartYear();
			String startmonth =form.getStartMonth();
			String startday =form.getStartDay();
			String startymd = startyear+startmonth+startday;
			DateFormat startFormat=new SimpleDateFormat("yyyyMMdd");
			Date startDate = startFormat.parse(startymd);

		//終了予定日String→Date
			String endyesr =form.getEndYear();
			String endmonth =form.getEndMonth();
			String endday =form.getEndDay();
			String endymd = endyesr+endmonth+endday;
			DateFormat endFormat=new SimpleDateFormat("yyyyMMdd");
			Date endDate = endFormat.parse(endymd);

		//下限時間
			String lh = String.valueOf(form.getLowerTime());
			String lm = String.valueOf(form.getLowerTimem());
			String lhm = lh+lm;
			Integer  LowerrTime = Integer.parseInt(lhm);

		//上限時間
			String eh = String.valueOf(form.getUpperTIme());
			String em = String.valueOf(form.getUpperTImem());
			String ehm = eh+em;
			Integer  UpperTime = Integer.parseInt(ehm);

		//エンティティに登録

			dispatch.setProjectId(3);//
			dispatch.setCaseId(form.getCaseID());
			dispatch.setStartDate(startDate);
			dispatch.setEndDate(endDate);
			dispatch.setLowerTime(LowerrTime);
			dispatch.setUpperTime(UpperTime);
			dispatch.setProduction(form.getProduction());

// 変更をDBに保存
			//dispatchDao.updateByPrimaryKeySelective(dispatch);
		}

		// ～～顧客情報の登録～～
		public  void insertDispatch(CaseDispatchEngineerForm disform) throws ParseException  {
						Dispatch dispatch = new Dispatch();
					//開始予定日String→Date
						String startyear =disform.getDispatchStartYear();
						String startmonth =disform.getDispatchStartMonth();
						String startday =disform.getDispatchStartDay();
						String startymd = startyear+startmonth+startday;
						DateFormat startFormat=new SimpleDateFormat("yyyyMMdd");
						Date startDate = startFormat.parse(startymd);

					//終了予定日String→Date
						String endyesr =disform.getDispatchEndYear();
						String endmonth =disform.getDispatchEndMonth();
						String endday =disform.getDispatchEndDay();
						String endymd = endyesr+endmonth+endday;
						DateFormat endFormat=new SimpleDateFormat("yyyyMMdd");
						Date endDate = endFormat.parse(endymd);

					//下限時間
						String lh = String.valueOf(disform.getLowerTime());
						String lm = String.valueOf(disform.getLowerTimem());
						String lhm = lh+lm;
						Integer  LowerrTime = Integer.parseInt(lhm);

					//上限時間
						String eh = String.valueOf(disform.getUpperTIme());
						String em = String.valueOf(disform.getUpperTImem());
						String ehm = eh+em;
						Integer  UpperTime = Integer.parseInt(ehm);

					//エンティティに登録
						dispatch.setProjectId(10);
						dispatch.setCaseId(10);
						dispatch.setStartDate(startDate);
						dispatch.setEndDate(endDate);
						dispatch.setLowerTime(LowerrTime);
						dispatch.setUpperTime(UpperTime);
						dispatch.setProduction(disform.getProduction());

			// 情報をDBに保存
						//dispatchDao.insertSelective(dispatch);
					}
}

