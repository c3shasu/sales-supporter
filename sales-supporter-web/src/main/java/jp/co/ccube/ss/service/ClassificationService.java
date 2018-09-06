package jp.co.ccube.ss.service;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.ccube.ss.dao.MClassificationDao;
import jp.co.ccube.ss.entity.MClassification;
import jp.co.ccube.ss.form.ClassificationForm;

@Service
public class ClassificationService {
	@Autowired
	private MClassificationDao classificationDao;

	// ～～マスタの登録～～
	public void registClassification(ClassificationForm form) {

		MClassification classification = new MClassification();
		// DBアクセス
		classification.setClassificationCode(form.getClassificationCode());
		classification.setClassificationId(form.getClassificationId());
		classification.setClassificationName(form.getClassificationName());
		classificationDao.insertSelective(classification);
	}

	// 検索
	public List<MClassification> search(ClassificationForm form) {
		MClassification classification = new MClassification();
		String classificationCode = form.getClassificationCode();
		if (!classificationCode.isEmpty()) {
			classification.setClassificationCode(classificationCode);
		}
		return classificationDao.selectByMClassification(classification);
	}

	// 対象の検索
	public ClassificationForm classificationSearch(ClassificationForm form) {

		String code = form.getClassificationCode();
		Integer id = form.getClassificationId();
		MClassification classification = classificationDao.selectByPrimaryKey(code, id);

		form.setClassificationCode(classification.getClassificationCode());
		form.setClassificationId(classification.getClassificationId());
		form.setClassificationName(classification.getClassificationName());

		return form;
	}

	// ～～マスタ情報の編集～～
	public void editClassification(ClassificationForm form) throws ParseException {

		String code = form.getClassificationCode();
		Integer id = form.getClassificationId();
		MClassification classification = classificationDao.selectByPrimaryKey(code, id);

		// DBアクセス
		classification.setClassificationCode(form.getClassificationCode());
		classification.setClassificationId(form.getClassificationId());
		classification.setClassificationName(form.getClassificationName());
		classificationDao.updateByPrimaryKeySelective(classification);
	}

	// ～～マスタの削除～～
	public void deleteClassification(ClassificationForm form) {
		String code = form.getClassificationCode();
		String s = String.valueOf(form.getClassificationId());
		Integer id = Integer.parseInt(s, 2);
		classificationDao.deleteByPrimaryKey(code, id);
	}
}
