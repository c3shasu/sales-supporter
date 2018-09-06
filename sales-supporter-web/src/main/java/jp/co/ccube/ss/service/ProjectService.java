package jp.co.ccube.ss.service;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.ccube.ss.dao.CaseDao;
import jp.co.ccube.ss.dao.ClientDao;
import jp.co.ccube.ss.dao.ProjectDao;
import jp.co.ccube.ss.entity.Client;
import jp.co.ccube.ss.entity.Project;
import jp.co.ccube.ss.form.ProjectForm;

@Service
public class ProjectService {
	@Autowired
	private ProjectDao projectDao;
	@Autowired
	private CaseDao caseDao;
	@Autowired
	private ClientDao clientDao;

	// ～～プロジェクトの登録～～
	public void registProject(ProjectForm form) throws ParseException {

		Project project = new Project();

		// DBアクセス
		// project.setProjectId(3);
		project.setProjectName(form.getProjectName());
		project.setClientId(form.getClientId());
		projectDao.insertSelective(project);

	}

	// 検索
	public List<Project> search(ProjectForm form) {
		Project project = new Project();
		String projectName = form.getProjectName();
		if (!projectName.isEmpty()) {
			project.setProjectName(projectName);
		}
		return projectDao.selectByProject(project);
	}

	// 対象の検索
	public ProjectForm projectSearch(ProjectForm form) {
		Integer id[] = form.getCheck();
		Project project = projectDao.selectByPrimaryKey(id[0]);

		form.setProject_id(id[0]);
		form.setProjectName(project.getProjectName());
		form.setClientId(project.getClientId());

		return form;
	}

	// 詳細表示
		public ProjectForm projectDetail(ProjectForm form) {
			Integer id[] = form.getCheck();
			Project project = projectDao.selectByPrimaryKey(id[0]);

			// BPコードを会社名に
			Client client = new Client();
			client = clientDao.bpSelect(project.getClientId());
			String companyName = client.getCompanyName();
			//System.out.println(companyName);
			form.setCompanyName(companyName);

			form.setProject_id(id[0]);
			form.setProjectName(project.getProjectName());
			form.setClientId(project.getClientId());

			return form;
		}


	// ～～プロジェクトの編集～～
	public void editProject(ProjectForm form) {

		// DBアクセス
		Project project = new Project();
		project.setProjectId(form.getProject_id());
		project.setProjectName(form.getProjectName());
		projectDao.updateByPrimaryKeySelective(project);
	}

	// ～～プロジェクトの削除～～
	public void deleteProject(ProjectForm form) {

		Project project = new Project();
		project.setProjectId(form.getProject_id());
		projectDao.deletedAtUpdate(project);
		caseDao.projectDeletedAtUpdate(project);
	}

}
