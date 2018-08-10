package jp.co.ccube.ss.controller.engineer;

import java.text.ParseException;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.co.ccube.ss.entity.Dispatch;
import jp.co.ccube.ss.form.CaseDispatchEngineerForm;
import jp.co.ccube.ss.service.DispatchService;
import jp.co.ccube.ss.service.EngineerService;

@Controller
public class EngineerRegistController {

	@Autowired
	DispatchService dispatchService;
	@Autowired
	EngineerService engineerService;
	@RequestMapping(value = "/engineerRegist", method = RequestMethod.POST)
	public String userList(@ModelAttribute("form") CaseDispatchEngineerForm form, HttpSession session) throws ParseException {
		// 正常系
		session.setAttribute("dispatchDetail", form);//formの情報をsessionに保存
		return "engineer/engineerDetailSearch";
	}
	@RequestMapping(value = "/registConfirm", method = RequestMethod.POST)
	public String userList(@ModelAttribute("form")Dispatch dispatch, CaseDispatchEngineerForm form,BindingResult result, HttpSession session) throws ParseException {
		CaseDispatchEngineerForm disform = new CaseDispatchEngineerForm();
		disform = (CaseDispatchEngineerForm) session.getAttribute("dispatchDetail");//前画面のformをsessionから取り出す
		//データベース登録はコメントアウト中
		dispatchService.insertDispatch(disform);
		engineerService.insertEngineer(form);
		return "engineer/engineerRegistConfirm";
	}
}
