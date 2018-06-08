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

	// ～～顧客情報の追加～～
	public void addClient(ClientForm form) {
		// 顧客種別の取得
		int type = 0;
		for (int data : form.getClientType()) {
			type += data;
		}
		// DBアクセス
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
		// 顧客種別の取得
		int type = 0;
		for (int data : form.getClientType()) {
			type += data;
		}
		// DBアクセス
		Client client = new Client();
		String clientName = form.getClientName();
		String clientTel = form.getClientTel();
		if (!clientName.isEmpty()) {
			client.setCompanyName(clientName);
		}
		if (!clientTel.isEmpty()) {
			client.setTelephone(clientTel);
		}
		if (type != 0) {
			client.setType(type);
		}
		return clientDao.selectByClient(client);
	}

	// ～～顧客種別を判定する～～
	public void typeNameMapping(List<ResultClient> result) {
		result.forEach(RC -> {
			switch (RC.getType()) {
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

	// ～～顧客情報の削除～～
	public void deleteClient(ClientForm form) {
		for (Integer id : form.getCheck()) {
			clientDao.deleteClient(id);
		}
	}

	// ～～編集対象の検索～～
	public ClientForm editClientSearch(ClientForm form) {
		Integer id[] = form.getCheck();

		Client client = clientDao.selectByPrimaryKey(id[0]);
		int type = client.getType();
		Integer[] typeSet = new Integer[8];
		int n = 0;
		int cnt = 0;
		while (type >= 2) {
			if (type % 2 == 1) {
				typeSet[cnt] = (int) Math.pow(2, n);
				cnt++;
			}
			type = type / 2;
			n++;
		}
		typeSet[cnt] = (int) Math.pow(2, n);

		form.setClientId(id[0]);
		form.setClientName(client.getCompanyName());
		form.setClientAddress(client.getAddress());
		form.setClientTel(client.getTelephone());
		form.setClientEmailAddress(client.getMailAddress());
		form.setClientType(typeSet);
		form.setClietDescription(client.getDescription());

		return form;
	}

	// ～～顧客情報の編集～～
	public void editClient(ClientForm form) {
		// 顧客種別の取得
		int type = 0;
		for (int data : form.getClientType()) {
			type += data;
		}
		// DBアクセス
		Client client = new Client();
		client.setCompanyId(form.getClientId());
		client.setCompanyName(form.getClientName());
		client.setAddress(form.getClientAddress());
		client.setTelephone(form.getClientTel());
		client.setMailAddress(form.getClientEmailAddress());
		client.setType(type);
		client.setDescription(form.getClietDescription());
		clientDao.updateByPrimaryKeySelective(client);
	}

}
