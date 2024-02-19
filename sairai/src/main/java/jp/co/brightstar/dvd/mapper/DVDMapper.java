package jp.co.brightstar.dvd.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import jp.co.brightstar.dvd.model.Condi;
import jp.co.brightstar.dvd.model.DVD;
import jp.co.brightstar.dvd.model.ValueAndText;

@Mapper
public interface DVDMapper {
	void insertDVD(String name);

	List<DVD> selectDVD(Condi condi);
	void lendDVD(String id);
	String getIdByName(String name);
	void info(String id);
	void deleteDVD(String id);
	List<ValueAndText>getList(String category);
}


