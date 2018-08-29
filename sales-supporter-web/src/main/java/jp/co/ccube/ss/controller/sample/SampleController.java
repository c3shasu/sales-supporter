package jp.co.ccube.ss.controller.sample;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import jp.co.ccube.ss.controller.AbstractController;
import jp.co.ccube.ss.dao.UsersDao;
import jp.co.ccube.ss.entity.Users;

@Controller
public class SampleController extends AbstractController {

	@Autowired
	UsersDao usersDao;

	/**
	 * [サンプル] はろー画面初期表示
	 *
	 * @return テンプレートパス
	 */
	@RequestMapping("/hello")
	public String hello() {
		return "sample/hello";
	}

	/**
	 * [サンプル] input画面初期表示
	 *
	 * @return テンプレートパス
	 */
	@RequestMapping("/input")
	public String input() {
		return "sample/input";
	}

	/**
	 * [サンプル]sendボタン押下時処理
	 * <p>
	 * <ul>
	 * <li>画面からのパラメータ：param の値をキーに{@link usersDao#selectByPrimaryKey(String)
	 * ユーザ情報を検索する。}</li>
	 * <li>検索した結果を{@link Model#addAttribute(String, Object)
	 * 画面に受け渡すオブジェクトに設定する。}</li>
	 * </ul>
	 * </p>
	 *
	 * @param model Viewに渡すオブジェクト
	 * @param param 画面からのパラメータ：paramの値
	 * @return テンプレートパス
	 */
	@Transactional
	@RequestMapping(value = "/send", params = "send", method = RequestMethod.POST)
	public String send(Model model, @RequestParam("param") String param) {
		Users userInfo = usersDao.selectByPrimaryKey(param);
		if (userInfo != null) {
			model.addAttribute("result", userInfo.getName());
		} else {
			model.addAttribute("result", "");
		}
		return "sample/result";
	}

	@RequestMapping(value = "/createReportSample", method = RequestMethod.POST)
	public String createReport(HttpServletResponse response, @RequestParam("param2") String param) {

		// テンプレート取得
		final String templatePath = "excel_templates/TestTemplate.xlsx";
		Workbook workBook = getTemplate(templatePath);

		// シート取得
		Sheet sheet = workBook.getSheetAt(0);

		// 値の埋め込み
		sheet.getRow(2).getCell(1).setCellValue(param);

		// ExcelファイルのByte化
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		try{
			try {
				workBook.write(bos);
			} finally {
			    bos.close();
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		byte[] fileBytes = bos.toByteArray();

		// レスポンスの設定
		response.setContentType("application/octet-stream");
		response.setHeader("Content-Disposition", "attachment; filename=" + "report.xlsx");
		response.setContentLength(fileBytes.length);

		// レスポンス書き出し
		try (OutputStream os = response.getOutputStream()) {
			os.write(fileBytes);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	private Workbook getTemplate(String templatePath) {
		Workbook workbook = null;
		URL url = this.getClass().getClassLoader().getResource(templatePath);
		if (url != null) {
			try (InputStream is = new ByteArrayInputStream(Files.readAllBytes(Paths.get(url.toURI())));) {
				workbook = WorkbookFactory.create(is);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return workbook;
	}

	/**
	 * [サンプル]戻るボタン押下時処理
	 *
	 * @return テンプレートパス
	 */
	@RequestMapping(value = "/test", params = "back")
	public String back() {
		return "sample/input";
	}

}
