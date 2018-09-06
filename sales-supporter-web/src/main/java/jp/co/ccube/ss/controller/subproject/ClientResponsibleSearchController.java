package jp.co.ccube.ss.controller.subproject;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import jp.co.ccube.ss.config.CheckBoxItemConfig;
import jp.co.ccube.ss.entity.ClientResponsible;
import jp.co.ccube.ss.form.ClientResponsibleForm;
import jp.co.ccube.ss.service.ClientResponsibleService;

@Controller
public class ClientResponsibleSearchController {
     @Autowired
     ClientResponsibleService clientResponsibleService;

     @RequestMapping(value = "/clientResponsible", params = "search", method=RequestMethod.POST)
     public ModelAndView search(ModelAndView mav, @ModelAttribute("form") ClientResponsibleForm form, Model model, HttpSession session){
    	 System.out.println(form.getName());
    	 mav.setViewName("/subproject/clientResponsible");
    	 System.out.println(form.getName());
    	 List<ClientResponsible> result = clientResponsibleService.searchClientResponsible(form);
    	 model.addAttribute("checkItems", CheckBoxItemConfig.CLIENTTYPE_ITEMS);
    	 System.out.println(form.getName());
    	 session.setAttribute("clientResponsible", result);
    	 System.out.println("EndSearch");
    	 mav.addObject("clientResponsible", result);

    	 return mav;

     }
}
