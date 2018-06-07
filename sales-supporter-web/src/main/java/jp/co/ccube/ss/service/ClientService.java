package jp.co.ccube.ss.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.ccube.ss.dao.ClientDao;
import jp.co.ccube.ss.entity.Client;
import jp.co.ccube.ss.entity.ResultClient;
import jp.co.ccube.ss.form.ClientForm;

@Service
public class ClientService {
	@Autowired
	private ClientDao clientDao;

//～～顧客情報の追加～～
	public void addClient(ClientForm form){
		//顧客種別の取得
		int type = 0;
		for ( int data: form.getClientType()) {
			type += data;
		}
		//DBアクセス
		Client client = new Client();
		client.setCompanyName(form.getClientName());
		client.setAddress(form.getClientAddress());
		client.setTelephone(form.getClientTel());
		client.setMailAddress(form.getClientEmailAddress());
		client.setType(type);
		client.setDescription(form.getClietDescription());
		clientDao.insertSelective(client);
	}

// ～～顧客情報の検索～～
	public List<ResultClient> searchClient(ClientForm form) {
		//顧客種別の取得
		int type = 0;
		for ( int data: form.getClientType()) {
			type += data;
		}
		//DBアクセス
		Client client = new Client ();
		String clientName = form.getClientName();
		String clientTel= form.getClientTel();
		if (!clientName.isEmpty()) {
			client.setCompanyName(clientName);
		}
		if (!clientTel.isEmpty()) {
			client.setTelephone(clientTel);
		}
		if (type != 0  ) {
			client.setType(type);
		}
		return clientDao.selectByClient(client);
	}

//～～顧客種別を判定する～～
	public void typeNameMapping(List<ResultClient> result){
		result.forEach(RC -> {
			switch (RC.getType()){
				case 1:
					RC.setTypeName("案件紹介");
					break;
				case 2:
					RC.setTypeName("人材紹介");
					break;
				case 3:
					RC.setTypeName("案件/人材");
					break;
			}
		});
	}

////～～顧客情報の削除～～
//	public void deleteClient(ClienttForm form) {
//		for ( String id : form.getDeleteCheck()) {
//			usersDao.deletedAtUpdate(id);
//		}
//	}

}


