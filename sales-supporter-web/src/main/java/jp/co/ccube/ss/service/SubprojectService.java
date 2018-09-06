package jp.co.ccube.ss.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.ccube.ss.dao.CaseDao;
import jp.co.ccube.ss.entity.CaseDetail;
import jp.co.ccube.ss.entity.CaseProject;
import jp.co.ccube.ss.entity.ChargeClientEmployee;
import jp.co.ccube.ss.form.SubprojectForm;

@Service
public class SubprojectService {
	@Autowired
	private CaseDao caseDao;

	// 案件検索
	public List<CaseProject> searchCase(SubprojectForm form) {
		CaseProject subproject = new CaseProject();
		// Project project = new Project();
		String projectName = form.getProjectName();
		String subprojectName = form.getCaseName();

		if (!projectName.isEmpty()) {
			subproject.setProjectName(projectName);
		}
		if (!subprojectName.isEmpty()) {
			subproject.setCaseName(subprojectName);
		}
		return caseDao.selectByCase(subproject);

	}

	// 案件詳細表示(案件名)
	public CaseDetail detailCase(SubprojectForm form) {
		CaseDetail sub = new CaseDetail();
		sub.setProjectId(form.getProjectId());
		sub.setCaseId(form.getCaseId());
		// カラムが足りないかもしれない
		return caseDao.selectByDetail(sub);
	}

	// 案件詳細表示(案件担当者)
	public List<ChargeClientEmployee> searchCharge(SubprojectForm formC) {
		ChargeClientEmployee chargeClientEmployee = new ChargeClientEmployee();
		chargeClientEmployee.setProjectId(formC.getProjectId());
		chargeClientEmployee.setCaseId(formC.getCaseId());
		System.out.println(chargeClientEmployee.getProjectId());
		System.out.println(chargeClientEmployee.getCaseId());
		return caseDao.selectByCharge(chargeClientEmployee);
	}

	// 案件更新画面編集対象
	public SubprojectForm editSubprojectSearch(SubprojectForm form) {
		CaseDetail sub = new CaseDetail();
		sub.setCaseId(form.getCaseId());
		sub.setProjectId(form.getProjectId());
		sub = caseDao.selectByEditSearch(sub);

		form.setProjectName(sub.getProjectName());
		form.setCaseName(sub.getCaseName());
		form.setCompanyName(sub.getCompanyName());
		form.setName(sub.getName());
		form.setAgreementType(sub.getAgreementType());
		form.setClassificationName(sub.getClassificationName());

		// カラムが足りないかもしれない
		return form;
	}

	// 案件削除確認画面
	public CaseDetail deleteSubprojectSearch(SubprojectForm form) {
		CaseDetail sub = new CaseDetail();

		sub.setCaseId(form.getCaseId());
		sub.setProjectId(form.getProjectId());

		return caseDao.selectByDetail(sub);
	}

	// 案件削除機能(削除フラグの更新)
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