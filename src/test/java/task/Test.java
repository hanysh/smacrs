package task;

import org.springframework.beans.factory.annotation.Autowired;

import com.smacrs.mse2015.common.dao.UserDao;
import com.smacrs.mse2015.common.dao.impl.UserDaoImpl;
import com.smacrs.mse2015.common.entity.User;

import junit.framework.TestCase;

public class Test extends TestCase {
	
	@Autowired
	UserDao dao;
	
	public void testcase(){
		
		User user=new User();
		user.setUserName("test");
		user.setPassword("test");
		dao.getUser(user);
	}

}
