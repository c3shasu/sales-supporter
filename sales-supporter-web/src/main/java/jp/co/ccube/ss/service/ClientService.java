package jp.co.ccube.ss.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.ccube.ss.dao.ClientDao;
import jp.co.ccube.ss.entity.Client;
import jp.co.ccube.ss.form.ClientForm;

@Service
public class ClientService {
	@Autowired
	private ClientDao clientDao;

	public void addClient(ClientForm form){

		//顧客種別の取得
		int type = 0;
		for ( int data: form.getClientType()) {
			type += data;
		}
		//DBアクセス
		Client client = new Client();

//		client.setCompanyId(form.getCompanyId());
//		client.setCompanyId(i);
		client.setCompanyName(form.getClientName());
		client.setAddress(form.getClientAddress());
		client.setTelephone(form.getClientTel());
		client.setMailAddress(form.getClientEmailAddress());
		client.setType(type);
		client.setDescription(form.getClietDescription());
		clientDao.insertSelective(client);

	}
}
