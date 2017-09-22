import static org.junit.Assert.*;



import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;

import com.niit.configuration.WebConfig;
import com.niit.dao.UsersDao;
import com.niit.model.Users;


public class UserTestCase{

static UsersDao usersDAO;
	
	
	@BeforeClass
	public static void initialize()
	{
		AnnotationConfigApplicationContext annotationConfigApplicationContext= new AnnotationConfigApplicationContext();
		annotationConfigApplicationContext.scan("com.niit");
	
		annotationConfigApplicationContext.refresh();
		usersDAO=(UsersDao)annotationConfigApplicationContext.getBean("UsersDao");
		
	}
	
	
	@Test
	public void createUserTest()
	{
		Users users= new Users();
		
		users.setUsername("Punam21");
		users.setEmail("punam@yahoo.com");
		users.setFirstname("poonam");
		users.setLastname("kulkarni");
		users.setPassword("abcd");
		users.setRole("User");
		
		users.setOnline(false);
		users.setEnabled(true);
		boolean f=usersDAO.registration(users);
		assertTrue("Problem in user creation",f==true);
		
	}
	
	
	

	
	
	
	@Ignore
	@Test 
	public void getUserTestCase()
	{
		boolean res=false;
		if(usersDAO.getUserByUsername("pooja@gmail.com")!=null){
			res=true;
		}
		assertTrue("Problem in getting user by id",res);
		
	}
	
	@Ignore
	@Test 
	public void getUserListTestCase()
	{
		List<Users> listusers=usersDAO.getAllUsers();
		System.out.println(listusers.size());
		assertTrue("Problem in getting the list",listusers.size()>0);
		
	}
	
	
	


}
