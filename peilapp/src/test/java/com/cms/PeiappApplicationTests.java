package com.cms;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.cms.bean.Params;
import com.cms.bean.User;
import com.cms.bean.exam.Users;
import com.cms.mapper.banner.IBannerMapper;
import com.cms.mapper.exam.IRegMapper;
import com.cms.mapper.supervise.IUserAdminMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PeiappApplicationTests {
    
	@Autowired
	private IBannerMapper bannermapper;
	@Autowired
	private IUserAdminMapper useradminmapper;
	@Autowired
	private IRegMapper regmapper;
	@Test
	public void banner() {
		
	}
	
	@Test
	public void user(){
		Params params=new Params();
		params.setKeyword("w");
		List<User> users=useradminmapper.getUsers(params);
		System.out.println(users);
	}
	
	
	@Test
	public void saveUser(){
		Users users=new Users();
		users.setAccount("wen");
		users.setHobby(2);
		users.setIntroduce("sdsdsd");
		users.setMale(0);
		users.setPassword("123456");
		users.setProvince("湖南");
		users.setUsername("yuan");
	   int a=regmapper.saveUser(users);
	   System.out.println(a);
	}
	
	
	

}
