import static org.junit.Assert.*;

import java.util.Date;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.BlogPostDao;
import com.niit.dao.UsersDao;
import com.niit.model.BlogPost;
import com.niit.model.Users;

public class BlogDaoTestCase {

	static BlogPostDao blogPostDao;
	static UsersDao usersDAO;
	@BeforeClass
	public static void initialize()
	{
		AnnotationConfigApplicationContext annotationConfigApplicationContext= new AnnotationConfigApplicationContext();
		annotationConfigApplicationContext.scan("com.niit");
	
		annotationConfigApplicationContext.refresh();
		blogPostDao=(BlogPostDao)annotationConfigApplicationContext.getBean("BlogPostDao");
		usersDAO=(UsersDao)annotationConfigApplicationContext.getBean("UsersDao");
	}

	@Test
	public void createBlogTest()
	{
		Users u=new Users();
		u=usersDAO.getUserByUsername("punam");
		BlogPost bp=new BlogPost();
		bp.setApproved(false);
		bp.setCreatedBy(u);
		bp.setId(12);
		bp.setPostedOn(new Date());
		bp.setTitle("BloTest");
		bp.setDescription("My Test Blog");
		blogPostDao.saveBlogPost(bp);
		assertTrue("problem in creation of blog",blogPostDao.saveBlogPost(bp));
		
	}
}
