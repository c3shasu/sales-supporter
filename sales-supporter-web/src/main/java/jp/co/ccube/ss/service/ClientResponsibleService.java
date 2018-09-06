package jp.co.ccube.ss.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.ccube.ss.dao.ClientResponsibleDao;
import jp.co.ccube.ss.entity.ClientResponsible;
import jp.co.ccube.ss.form.ClientResponsibleForm;

@Service
public class ClientResponsibleService {
	@Autowired
	private ClientResponsibleDao clientResponsibleDao;

	public List<ClientResponsible> searchClientResponsible(ClientResponsibleForm form){
		System.out.println(form.getName());
		ClientResponsible clientR = new ClientResponsible();
		System.out.println(form.getName());
		String clientResponsibleName = form.getName();
		System.out.println(form.getName());
		//String clientResponsibleKana = form.getKana();
		System.out.println(form.getName());
		clientR.setName(clientResponsibleName);
		//clientR.setKana(clientResponsibleKana);
		System.out.println("EndB"+form.getName());
		return clientResponsibleDao.selectByClientR(clientR);
	}

}
