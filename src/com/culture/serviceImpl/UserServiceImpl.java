package com.culture.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.culture.mapper.UserMapper;
import com.culture.model.User;
import com.culture.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserMapper uMapper;
     
	@Override
	public User findUserById(int id) throws Exception {

		return uMapper.findUserById(id);
	}

	@Override
	public User findUserByName(String username) throws Exception {

		return uMapper.findUserByUsername(username);
	}
//
//	@Override
//	public List<User> findUserList() throws Exception {
//
//		return uMapper.findUserList();
//	}

	@Override
	public User findUserByusername(String username) {
		// TODO 自动生成的方法存根
		return uMapper.findUserByusername(username);
	}



//	@Override
//	public int addUser(User user) throws Exception {
//
//		return uMapper.addUser(user);
//	}
//
//	@Override
//	public int deleteUser(User user) throws Exception {
//
//		return uMapper.deleteUser(user);
//	}
//
//	@Override
//	public int updateUser(User user) throws Exception {
//		return uMapper.deleteUser(user);
//	}
//
//	@Override
//	public String login(String username, String password) throws Exception {
//
//		return null;
//	}



}
