package jp.co.brightstar.dvd.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.brightstar.dvd.mapper.DVDMapper;
import jp.co.brightstar.dvd.model.Condi;
import jp.co.brightstar.dvd.model.DVD;
import jp.co.brightstar.dvd.model.ValueAndText;
import jp.co.brightstar.dvd.model.lendInfo;

@Service
public class DVDService {
	@Autowired
	private DVDMapper mapper;

	public void insertDVD(String name) {
		mapper.insertDVD(name);
	}

	public List<DVD> selectDVD(Condi condi) {
		return mapper.selectDVD(condi);
	}
	public void lendDVD(String id) {
		mapper.lendDVD(id);
	}
	
	public String getIdByName(String name) {
		String id = mapper.getIdByName(name);
		return id;
	}
	public void info(String id) {
		mapper.info(id);
	}
	public List<ValueAndText> getList(String category){
		return mapper.getList(category);
	}
	public void deleteDVD(String id) {
		mapper.deleteDVD(id);		
	}
	public DVD detail(String id) {
		return mapper.detail(id);
		
	}
	public void updateDVDInfo(String id) {
		mapper.updateDVDInfo(id);
	}
	public void updateDVDLendInfo(String id) {
		mapper.updateDVDLendInfo(id);
	}
	public String dvdCost(String id) {
		return mapper.dvdCost(id);
	}
	public List<lendInfo> getLendInfoById(String id) {
		return mapper.getLendInfoById(id);
	}
}