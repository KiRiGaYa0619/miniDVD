package jp.co.brightstar.dvd.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.brightstar.dvd.mapper.UserDao.LogMapper;
import jp.co.brightstar.dvd.mapper.UserDao.LoginMapper;
import jp.co.brightstar.dvd.model.User;

@Service
public class loginService {

	@Autowired
	private LoginMapper mapper;
	@Autowired
	private LogMapper mapper2;

	public String loginCheck(User user) {

		String md5Password = MD5Util.toMD5(user.getPassword());
		//根据用户输入ID取得数据库对应对象
		User userByDb = mapper.getUserByUserid(user.getUsername());
		String msg = null;
		// DBのユーザ認証テーブルと連携する
		User userFromDB = mapper.getUserByUserid(user.getUsername());

		// 1レコード取得できる場合
		if (userFromDB != null) {
			// PSW認証を行う
			// DB.パスワード
			String passwordFromDB = userFromDB.getPassword();
			// DB.パスワード＜＞画面.パスワード(MD5で暗号化した内容)
			if (!passwordFromDB.equals(md5Password)) {
				// PSW認証エラー
				msg = "パスワードが間違っています。";
			} else {
				msg = "success";
			}
		}
		// 0レコードの場合
		else {
			// ユーザID認証エラー
			msg = "該当ユーザーが存在しません。";
		}
		return msg;
	}

	public void sendUserIdToDB(User user) {
		//DBの登録履歴に情報を記入
		mapper2.sendLog(user.getUsername());
	}
}
