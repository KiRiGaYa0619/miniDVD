package jp.co.brightstar.dvd.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import jp.co.brightstar.dvd.model.User;

public class UserDao {	
	@Mapper
	public interface LoginMapper {
	    @Select("SELECT USER_ID, PASSWORD FROM USER_AUTH WHERE USER_ID = #{userid}")
	    User getUserByUserid(String userid);
	}
	@Mapper
	public interface LogMapper {
	    @Insert("INSERT INTO USER_ACCESS_LOG (USER_ID) VALUES (#{userid})")
	    void sendLog(String userid);
	}

	

}