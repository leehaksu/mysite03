package com.jx372.mysite.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jx372.mysite.repository.UserDao;
import com.jx372.mysite.vo.UserVo;

@Service
public class UserService {
	
	@Autowired
	private UserDao userdao;
	
	public void join(UserVo uservo)
	{
		System.out.println("join in");
		userdao.insert(uservo);
		System.out.println("join in");
	}

	public UserVo getUser(UserVo uservo) {
		
		uservo= userdao.get(uservo.getEmail(), uservo.getPassword());
		return uservo;
		// TODO Auto-generated method stub
	}

	public UserVo modify(Long no) {
		// TODO Auto-generated method stub
		UserVo uservo;
		uservo=userdao.get(no);
		return uservo;
	}
	

}
