package jp.co.ccube.ss.service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.ccube.ss.dao.ClientDao;
import jp.co.ccube.ss.dao.EmployeeDao;
import jp.co.ccube.ss.dao.EngineerDao;
import jp.co.ccube.ss.entity.Client;
import jp.co.ccube.ss.entity.Employee;
import jp.co.ccube.ss.entity.Engineer;
import jp.co.ccube.ss.form.EngineerForm;

@Service
public class EngineerService {
	@Autowired
	private EngineerDao engineerDao;
	@Autowired
	private ClientDao clientDao;
	@Autowired
	private EmployeeDao employeeDao;
	// 編集対象検索
	public EngineerForm engineerSearch(EngineerForm form) throws ParseException {
		Engineer engineer = new Engineer();
		engineer.setProjectId(10);
		engineer.setCaseId(9);
		engineer.setBranchNo(29);
		engineer = engineerDao.select(engineer);

		 //社員番号を部署名に
		 if(engineer.getEmployeeNo()!=null){
			 Employee employee = new Employee();
			 employee = employeeDao.employeeSelect(engineer.getEmployeeNo());
				String employeeDepartment = employee.getDepartment();
				form.setDepartment(employeeDepartment);
		 }

		// BPコードを会社名に
		if (engineer.getClientId() != null) {
			System.out.println("1");
			Client client = new Client();
			client = clientDao.bpSelect(engineer.getClientId());
			String companyName = client.getCompanyName();
			form.setCompanyName(companyName);
		}

		// 開始予定日の設定
		SimpleDateFormat starty = new SimpleDateFormat("yyyy");
		String startyear = starty.format(engineer.getStartDate());

		SimpleDateFormat startm = new SimpleDateFormat("MM");
		String startmonth = startm.format(engineer.getStartDate());

		SimpleDateFormat startd = new SimpleDateFormat("dd");
		String startday = startd.format(engineer.getStartDate());

		String startYms = startyear + "年" + startmonth + "月" + startday + "日";

		// 終了予定日の設定
		SimpleDateFormat endy = new SimpleDateFormat("yyyy");
		String endyear = endy.format(engineer.getEndDate());

		SimpleDateFormat endm = new SimpleDateFormat("MM");
		String endmonth = endm.format(engineer.getEndDate());

		SimpleDateFormat endd = new SimpleDateFormat("dd");
		String endday = endd.format(engineer.getEndDate());

		String endYms = endyear + "年" + endmonth + "月" + endday + "日";

		// 原価と単価を小数点3桁
		double wprice = (double) engineer.getPrice();
		wprice = wprice / 1000;
		double wcost = (double) engineer.getCost();
		wcost = wcost / 1000;

		//BPコードと会社名を同時表示
		String bpCompanyName = String.valueOf(engineer.getClientId())+"("+form.getCompanyName()+")";
		//社員番号と部署名を同時表示
		String employeeDepartment = String.valueOf(engineer.getEmployeeNo())+"("+form.getDepartment()+")";
		form.setProjectId(engineer.getProjectId());
		form.setCaseId(engineer.getCaseId());
		form.setEmployeeNo(engineer.getEmployeeNo());
		form.setClientId(engineer.getClientId());
		form.setEngineerName(engineer.getEngineerName());
		form.setPrice(engineer.getPrice());
		form.setWprice(wprice);
		form.setExcessPrice(engineer.getExcessPrice());
		form.setDeductionPrice(engineer.getDeductionPrice());
		form.setCost(engineer.getCost());
		form.setWcost(wcost);
		form.setExcessCost(engineer.getExcessCost());
		form.setDeductionCost(engineer.getDeductionCost());
		form.setStartYms(startYms);
		form.setEndYms(endYms);
		form.setManHours(engineer.getManHours());
		form.setStartYear(startyear);
		form.setStartMonth(startmonth);
		form.setStartDay(startday);
		form.setEndYear(endyear);
		form.setEndMonth(endmonth);
		form.setEndDay(endday);
		form.setBpCompanyName(bpCompanyName);
		form.setEmployeeDepartment(employeeDepartment);

		return form;
	}

	// ～～エンジニア情報の登録～～
	public void insertEngineer(EngineerForm form) throws ParseException {
		Engineer engineer = new Engineer();
		// 開始日String→Date
		String startyear = form.getStartYear();
		String startmonth = form.getStartMonth();
		String startday = form.getStartDay();
		String startymd = startyear + startmonth + startday;
		DateFormat startFormat = new SimpleDateFormat("yyyyMMdd");
		Date startDate = startFormat.parse(startymd);

		// 終了日String→Date
		String endyesr = form.getEndYear();
		String endmonth = form.getEndMonth();
		String endday = form.getEndDay();
		String endymd = endyesr + endmonth + endday;
		DateFormat endFormat = new SimpleDateFormat("yyyyMMdd");
		Date endDate = endFormat.parse(endymd);

		// 単価と原価を千円単位→円単位
		form.setWprice(form.getWprice() * 1000);
		int price = (int) form.getWprice();


		// エンティティに登録
		engineer.setProjectId(10);//
		engineer.setCaseId(9);
if(form.getEmployeeNo()!=null){
		engineer.setEmployeeNo(form.getEmployeeNo());
}
if(form.getClientId()!=null){
		engineer.setClientId(form.getClientId());
}
if(form.getEngineerName()!=null){
		engineer.setEngineerName(form.getEngineerName());System.out.println("社員"+form.getEngineerName());
}
if(form.getBpEngineerName()!=""){
	engineer.setEngineerName(form.getBpEngineerName());System.out.println("bp"+form.getBpEngineerName());
}
		engineer.setPrice(price);System.out.println();
		engineer.setExcessPrice(form.getExcessPrice());
		engineer.setDeductionPrice(form.getDeductionPrice());

		if(form.getWcost()!=0.0){
		form.setWcost(form.getWcost() * 1000);// 単価と原価を千円単位→円単位
		int cost = (int) form.getWcost();
		engineer.setCost(cost);System.out.println("社員原価"+engineer.getCost());
		}

		if(form.getBpWcost()!=0.0){
		form.setBpWcost(form.getBpWcost() * 1000);// 単価と原価を千円単位→円単位
		int bpCost = (int) form.getBpWcost();
		engineer.setCost(bpCost);System.out.println("bp原価"+engineer.getCost());
		}
		engineer.setExcessCost(form.getExcessCost());
		engineer.setDeductionCost(form.getDeductionCost());
		engineer.setStartDate(startDate);
		engineer.setEndDate(endDate);
		engineer.setManHours(form.getManHours());
		// 情報をDBに保存
		engineerDao.insertSelective(engineer);
	}

	// ～～エンジニア情報更新～～
	public void engineerUpdate(EngineerForm form) throws ParseException {
		Engineer engineer = new Engineer();
		engineer.setProjectId(10);
		engineer.setCaseId(9);
		engineer.setBranchNo(29);

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

		// 単価と原価を千円単位→円単位
		form.setWprice(form.getWprice() * 1000);
		int price = (int) form.getWprice();
		form.setWcost(form.getWcost() * 1000);
		int cost = (int) form.getWcost();

		engineer.setClientId(form.getClientId());
		engineer.setEmployeeNo(form.getEmployeeNo());
		engineer.setEngineerName(form.getEngineerName());
		engineer.setPrice(price);
		engineer.setExcessPrice(form.getExcessPrice());System.out.println(engineer.getExcessPrice());
		engineer.setDeductionPrice(form.getDeductionPrice());
		engineer.setCost(cost);
		engineer.setExcessCost(form.getExcessCost());
		engineer.setDeductionCost(form.getDeductionCost());
		engineer.setStartDate(startDate);
		engineer.setEndDate(endDate);
		engineer.setManHours(form.getManHours());
		engineerDao.updateByPrimaryKeySelective(engineer);
	}

	// ～～エンジニア情報の削除～～
	public void engineerDelete(EngineerForm form) throws ParseException {
		Integer projectId[] = new Integer[1];
		projectId[0] = 10;
		Integer subProjectId[] = new Integer[1];
		subProjectId[0] = 9;
		Integer branchNo[] = new Integer[1];
		branchNo[0] = 29;

		engineerDao.deleteByPrimaryKey(projectId[0], subProjectId[0], branchNo[0]);
	}
}