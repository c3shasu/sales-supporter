package jp.co.ccube.ss.controller.client;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.ccube.ss.controller.AbstractController;

@Controller
public class ClientConfirmController extends AbstractController {

	@RequestMapping("/clientConfirm")
	public String clientConfirm() {
		return "client/clientConfirm";
	}

}
