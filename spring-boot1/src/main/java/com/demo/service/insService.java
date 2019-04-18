package com.demo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.DAO.DAO;
import com.demo.modal.insVO;
@Service
public class insService {

@Autowired DAO dao;
	
	
	@Transactional
	public void insun(insVO areaVO)
	{
		dao.insert(areaVO);
	}
	
	@Transactional
	public List searchuser(insVO insvo){
		List ls = dao.search(insvo);
		return ls;
		
	}
	
	@Transactional
	public void deleteuser(insVO customer) {
		// TODO Auto-generated method stub
		dao.deluser(customer);
	}

	/*public List search_edit(insVO regVO) {
		// TODO Auto-generated method stub
		List ls = dao.
	}*/

}
