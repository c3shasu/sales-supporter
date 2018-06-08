package jp.co.ccube.ss.controller.client;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import jp.co.ccube.ss.config.CheckBoxItemConfig;
import jp.co.ccube.ss.controller.AbstractController;
import jp.co.ccube.ss.entity.ResultClient;
import jp.co.ccube.ss.form.ClientForm;
import jp.co.ccube.ss.service.ClientService;

@Controller
public class ClientListController extends AbstractController {

	@Autowired
	ClientService clientService;

	/**
	 * ユーザ一覧画面初期表示
	 *
	 * @return テンプレートパス
	 */
	@RequestMapping(value = "/clientList", method = RequestMethod.GET)
	public String clientList(@ModelAttribute("form") ClientForm form, Model model) {
		model.addAttribute("checkItems", CheckBoxItemConfig.CLIENTTYPE_ITEMS);
		return "client/clientList";
	}

	// 検索処理
	@RequestMapping(value = "/clientSearch", params = "search", method = RequestMethod.POST)
	public ModelAndView search(ModelAndView mav, @ModelAttribute("form") ClientForm form, Model model) {
		mav.setViewName("/client/clientList");
		List<ResultClient> result = clientService.searchClient(form);
		model.addAttribute("checkItems", CheckBoxItemConfig.CLIENTTYPE_ITEMS);
		clientService.typeNameMapping(result);
		mav.addObject("serachClientList", result);
		return mav;
	}

	// 削除処理
	@RequestMapping(value = "/clientSearch", params = "delete", method = RequestMethod.POST)
	public ModelAndView delete(ModelAndView mav, @ModelAttribute("form") ClientForm form, Model model) {
		// 削除対象確認
		if (form.getCheck().length != 0) {
			clientService.deleteClient(form);
		}
		mav.setViewName("/client/clientList");
		List<ResultClient> result = clientService.searchClient(form);
		model.addAttribute("checkItems", CheckBoxItemConfig.CLIENTTYPE_ITEMS);
		clientService.typeNameMapping(result);
		mav.addObject("serachClientList", result);
		return mav;
	}

	// 編集画面遷移処理
	@RequestMapping(value = "/clientSearch", params = "edit", method = RequestMethod.POST)
	public String userEdit(ModelAndView mav, @ModelAttribute("form") ClientForm form, Model model) {
		// チェックボックスに一個のチェックがある時だけ編集画面に遷移
		if (form.getCheck().length != 1) {
			model.addAttribute("checkItems", CheckBoxItemConfig.CLIENTTYPE_ITEMS);
			return "/client/clientList";
		}
		model.addAttribute("form", clientService.editClientSearch(form));
		model.addAttribute("checkItems", CheckBoxItemConfig.CLIENTTYPE_ITEMS);

		return "/client/clientEdit";
	}

}
