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

	// ～～案件担当者の登録～～
	public void registClassification(ClassificationForm form) {

		int type = 0;
		type = form.getClassificationId();

		MClassification classification = new MClassification();
		// DBアクセス
		classification.setClassificationCode(form.getClassificationCode());
		classification.setClassificationId(type);
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
		String classificationCode = new String();
		classificationCode = "client";
		Integer classificationId[] = new Integer[1];
		classificationId[0] = 0000001;
		MClassification classification = new MClassification();
		classification = classificationDao.selectByPrimaryKey(classificationCode, classificationId[0]);

		form.setClassificationCode(classification.getClassificationCode());
		form.setClassificationId(classification.getClassificationId());
		form.setClassificationName(classification.getClassificationName());

		return form;
	}

	// ～～マスタ情報の編集～～
	public void editClassification(ClassificationForm form) throws ParseException {

		String classificationCode = new String();
		classificationCode = "client";
		Integer classificationId[] = new Integer[1];
		classificationId[0] = 0000001;
		MClassification classification = new MClassification();
		classification = classificationDao.selectByPrimaryKey(classificationCode, classificationId[0]);

		// DBアクセス
		classification.setClassificationCode(form.getClassificationCode());
		classification.setClassificationId(form.getClassificationId());
		classification.setClassificationName(form.getClassificationName());
		classificationDao.updateByPrimaryKeySelective(classification);
	}

	// ～～顧客情報の削除～～
	public void deleteClassification(ClassificationForm form) {
		String classificationCode = new String();
		classificationCode = "client";
		Integer classificationId[] = new Integer[1];
		classificationId[0] = 0000001;
		classificationDao.deleteByPrimaryKey(classificationCode, classificationId[0]);
	}
}
