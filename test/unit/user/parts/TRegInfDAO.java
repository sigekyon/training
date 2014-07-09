package unit.user.parts;

import static org.junit.Assert.*;

import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import user.bean.RegistrantInfo;
import user.parts.RegInfDAO;

public class TRegInfDAO {
	RegInfDAO regDAO
	;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		try {
			System.setProperty(Context.INITIAL_CONTEXT_FACTORY,
					"org.apache.naming.java.javaURLContextFactory");
			System.setProperty(Context.URL_PKG_PREFIXES,
					"org.apache.naming");
			InitialContext ic = new InitialContext();

			ic.createSubcontext("java:");
			ic.createSubcontext("java:comp");
			ic.createSubcontext("java:comp/env");
			ic.createSubcontext("java:comp/env/jdbc");

			MysqlDataSource ds = new MysqlDataSource();
			ds.setUser("root");
			ds.setPassword("root");
			ds.setURL("jdbc:mysql://localhost/Task");
		
			ic.bind("java:comp/env/jdbc/Task", ds);
			
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	@Before
	public void setUp() throws Exception {
		String cmd = "cmd.exe /c start C:/Users/tchiba/Desktop/set_testData.bat";
		Runtime.getRuntime().exec(cmd);
		regDAO = new RegInfDAO();
		Thread.sleep(300);
	}
	
	@After
	public void tearDown(){
		regDAO.close();
	}
	
	@Test
	public void tGetReglist001() {
		ArrayList<RegistrantInfo> regList = regDAO.getReglist();

		assertEquals(regList.get(0).getrId(),"001");
		assertEquals(regList.get(0).getrName(),"鈴木太郎");
		assertEquals(regList.get(0).getrAge(),"35");
		assertEquals(regList.get(1).getrId(),"002");
		assertEquals(regList.get(1).getrName(),"Tommy");
		assertEquals(regList.get(1).getrAge(),"25");
		assertEquals(regList.get(2).getrId(),"003");
		assertEquals(regList.get(2).getrName(),"山田花子");
		assertEquals(regList.get(2).getrAge(),"30");
	}

	@Test
	public void tGetNextId002() {
		assertEquals("004", regDAO.getNextId());
	}

	@Test
	public void tGetNextId003() throws Exception {
		String cmd = "cmd.exe /c start C:/Users/tchiba/Desktop/set_testData2.bat";
		Runtime.getRuntime().exec(cmd);
		Thread.sleep(300);
		assertEquals("001", regDAO.getNextId());
	}
	
	@Test
	public void tInsert004() {
		regDAO.insert("004", "佐藤路未央", "28");
		ArrayList<RegistrantInfo> regList = regDAO.getReglist();
		
		assertEquals(regList.get(0).getrId(),"001");
		assertEquals(regList.get(0).getrName(),"鈴木太郎");
		assertEquals(regList.get(0).getrAge(),"35");
		assertEquals(regList.get(1).getrId(),"002");
		assertEquals(regList.get(1).getrName(),"Tommy");
		assertEquals(regList.get(1).getrAge(),"25");
		assertEquals(regList.get(2).getrId(),"003");
		assertEquals(regList.get(2).getrName(),"山田花子");
		assertEquals(regList.get(2).getrAge(),"30");
		assertEquals(regList.get(3).getrId(),"004");
		assertEquals(regList.get(3).getrName(),"佐藤路未央");
		assertEquals(regList.get(3).getrAge(),"28");
	}

	@Test
	public void tUpdate005() {
		regDAO.update("002", "Michael", "29");
		ArrayList<RegistrantInfo> regList = regDAO.getReglist();
		
		assertEquals(regList.get(0).getrId(),"001");
		assertEquals(regList.get(0).getrName(),"鈴木太郎");
		assertEquals(regList.get(0).getrAge(),"35");
		assertEquals(regList.get(1).getrId(),"002");
		assertEquals(regList.get(1).getrName(),"Michael");
		assertEquals(regList.get(1).getrAge(),"29");
		assertEquals(regList.get(2).getrId(),"003");
		assertEquals(regList.get(2).getrName(),"山田花子");
		assertEquals(regList.get(2).getrAge(),"30");
	}

	@Test
	public void tDelete006() {
		regDAO.delete("001");
		ArrayList<RegistrantInfo> regList = regDAO.getReglist();
		
		assertEquals(regList.get(0).getrId(),"002");
		assertEquals(regList.get(0).getrName(),"Tommy");
		assertEquals(regList.get(0).getrAge(),"25");
		assertEquals(regList.get(1).getrId(),"003");
		assertEquals(regList.get(1).getrName(),"山田花子");
		assertEquals(regList.get(1).getrAge(),"30");
	}
}
