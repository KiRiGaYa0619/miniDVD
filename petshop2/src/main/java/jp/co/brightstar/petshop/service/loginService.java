package jp.co.brightstar.petshop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.brightstar.petshop.mapper.userMapper;
import jp.co.brightstar.petshop.model.customer;
import jp.co.brightstar.petshop.model.pet;

@Service
public class loginService {
	@Autowired
	private userMapper mapper;

	public String pwdCheck(String userid) {
		
		return mapper.pwdCheck(userid);
		
	}
	 public customer findCustomerById(String userid) {
	        return mapper.findCustomerById(userid);
	    }
	 public pet findPetById(String userid) {
	        return mapper.findPetById(userid);
	    }
}
