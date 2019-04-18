package com.demo.DAO;

import java.util.List;

import com.demo.modal.insVO;

public interface DAO {

	public insVO insert(insVO AreaView);
	public List search(insVO insvo);
	public void deluser(insVO customer);
}
