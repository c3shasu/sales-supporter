package jp.co.ccube.ss.controller.sample.usermanagement;

import org.springframework.stereotype.Controller;

/**
 * ユーザ情報管理コントローラ
 */
@Controller
public class UserManagementController {
	//
	// /** ユーザ情報Dao */
	// @Autowired
	// UsersDao usersDao;
	//
	// /**
	// * [サンプル]ユーザ情報一覧画面初期表示処理
	// * <p>
	// * <ul>
	// * <li>{@link #findAllUsers() ユーザ情報を検索する。}</li>
	// * <li>画面に受け渡す値に{@link Model#addAttribute(String, Object)
	// 検索した結果を設定する。}</li>
	// * </ul>
	// * </p>
	// *
	// * @param model Viewに渡すオブジェクト
	// * @return テンプレートパス
	// */
	// @RequestMapping("/userlist")
	// public String init(Model model) {
	// return "sample/usermanagement/list";
	// }
	//
	// /**
	// * [サンプル]オートセーブ時処理
	// * <p>
	// * <ul>
	// * <li>変更対象のユーザ情報をもとに、{@link usersDao#updateByPrimaryKeyWithBLOBs(Users)
	// * ユーザ情報の更新}を行う。</li>
	// * <li>{@link usersDao#findAll() ユーザ情報の全件検索を行う。}</li>
	// * </ul>
	// * </p>
	// *
	// * @param model Viewに渡すオブジェクト
	// * @data 変更対象のユーザ情報
	// * @return ユーザ情報リスト
	// */
	// @RequestMapping(value = "/userlist/update", consumes =
	// MediaType.APPLICATION_JSON_VALUE)
	// @ResponseBody
	// @Transactional
	// public List<Users> update(Model model, @RequestBody Users[] data) {
	// return usersDao.selectByPrimaryKey(1);
	// }
	//
	// /**
	// * saveボタン押下時処理
	// * <p>
	// * <ul>
	// * <li>全ユーザ情報をもとに、{@link usersDao#updateByPrimaryKeyWithBLOBs(Users)
	// ユーザ情報の更新}を行う。</li>
	// * <li>{@link usersDao#findAll() ユーザ情報の全件検索を行う。}</li>
	// * </ul>
	// * </p>
	// * @param model Viewに渡すオブジェクト
	// * @data 全ユーザ情報
	// * @return ユーザ情報リスト
	// */
	// @RequestMapping(value = "/userlist/save", consumes =
	// MediaType.APPLICATION_JSON_VALUE)
	// @ResponseBody
	// @Transactional
	// public List<Users> save(Model model, @RequestBody Users[] data) {
	// // TODO 削除差分でユーザ消し込み
	//
	// List<String> nowUsersList = usersDao.findUserId();
	//
	// // 更新
	// usersDao.updateUsers(Arrays.asList(data));
	//
	// //追加
	// for(int i = 0; i < data.length; i++){
	// Users Users = data[i];
	// if(nowUsersList.indexOf(Users.getUserId()) == -1){
	// Users.setDeleteFlag("0");
	// usersDao.insert(Users);
	// }
	// }
	//
	// // 削除
	// for (int i = 0; i < data.length; i++) {
	// nowUsersList.remove(data[i].getUserId());
	// }
	// usersDao.updateDeleteFlg(nowUsersList);
	//
	// return usersDao.findAll();
	// }
	//
	// /**
	// * loadボタン押下時処理
	// * <p>
	// * <ul>
	// * <li>{@link usersDao#findAll() ユーザ情報の全件検索を行う。}</li>
	// * </ul>
	// * </p>
	// *
	// * @param model Viewに渡すオブジェクト
	// * @return ユーザ情報リスト
	// */
	// @RequestMapping(value = "/userlist/load", consumes =
	// MediaType.APPLICATION_JSON_VALUE)
	// @ResponseBody
	// public List<Users> load(Model model) {
	// return usersDao.findAll();
	// }

}
