package jp.co.ccube.ss.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.ccube.ss.dao.CaseDao;
import jp.co.ccube.ss.entity.CaseDetail;
import jp.co.ccube.ss.entity.CaseProject;
import jp.co.ccube.ss.form.SubprojectForm;

@Service
public class SubprojectService {
	@Autowired
	private CaseDao caseDao;

	//案件検索
	public List<CaseProject> searchCase(SubprojectForm form){
		CaseProject subproject = new CaseProject();
		//Project project = new Project();
		System.out.println("searchCase Start " + form.getProjectName() + " :: " + form.getCaseName());
		String projectName = form.getProjectName();
		String subprojectName = form.getCaseName();
		System.out.println("searchCase A");

        System.out.println("aaa" + projectName + "bbb");

		System.out.println("searchCase B");
//		if(!projectName.isEmpty()){
        subproject.setProjectName(projectName);
//		}
		System.out.println("searchCase C");
//		if (!subprojectName.isEmpty()) {
			subproject.setCaseName(subprojectName);
//		}
		System.out.println("searchCase End");
		return caseDao.selectByCase(subproject);

	}
	//案件詳細表示
	public CaseDetail detailCase(SubprojectForm form){
		CaseDetail sub = new CaseDetail();
//		List<CaseDetail> list = new ArrayList<CaseDetail>();
//		list = (List<CaseDetail>) session.getAttribute("searchList");
//		System.out.println("searchCase Start " + list.get(0).getProjectId());
//		Integer subprojectId =form.getCaseId();
//		Integer projectId = form.getProjectId();
//		System.out.println("searchCase AA");

//		System.out.println("searchCase BB");
		sub.setProjectId(form.getProjectId());
        sub.setCaseId(form.getCaseId());
		System.out.println(form.getCaseId());
		sub.setProjectId(form.getProjectId());
		System.out.println(sub.getCaseId());
		System.out.println(sub.getProjectId());
		System.out.println("search Case EndA");
		//カラムが足りないかもしれない
		return caseDao.selectByDetail(sub);
	}

	//案件更新画面編集対象
	public SubprojectForm editSubprojectSearch(SubprojectForm form){
		CaseDetail sub = new CaseDetail();
		System.out.println("searchCase Start " + form.getProjectName() + " :: " + form.getCaseName());
		sub.setCaseId(form.getCaseId());
		sub.setProjectId(form.getProjectId());
		System.out.println("searchCase AA");
		sub = caseDao.selectByEditSearch(sub);

		System.out.println("searchCase BB");
		form.setProjectName(sub.getProjectName());
		form.setCaseName(sub.getCaseName());
		form.setCompanyName(sub.getCompanyName());
		form.setName(sub.getName());
		form.setAgreementType(sub.getAgreementType());
		form.setClassificationName(sub.getClassificationName());
		System.out.println("search Case EndA");
		//カラムが足りないかもしれない
		return form;
	}


	//案件削除確認画面
	public CaseDetail deleteSubprojectSearch(SubprojectForm form){
		CaseDetail sub = new CaseDetail();
		System.out.println("searchEX Case Start " + form.getProjectId() + " :: " + form.getCaseId());
		sub.setCaseId(form.getCaseId());
		sub.setProjectId(form.getProjectId());
		System.out.println("searchCase AA");
		return caseDao.selectByDetail(sub);
	}

	//案件削除機能(削除フラグの更新)
	public void deleteSubproject(SubprojectForm form) {
		CaseDetail sub = new CaseDetail();
		sub.setCaseId(form.getCaseId());
		sub.setProjectId(form.getProjectId());
		caseDao.deletedAtUpdate(sub);
	}

	public CaseDetail searchSubproject(SubprojectForm form) {

		CaseDetail sub = new CaseDetail();
		sub.setCaseId(form.getCaseId());
		sub.setProjectId(form.getProjectId());
		return caseDao.selectByDetail(sub);
	}



}
