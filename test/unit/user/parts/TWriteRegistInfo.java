package unit.user.parts;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.junit.Test;

import user.bean.RegistrantInfo;
import user.parts.WriteRegistInfo;

public class TWriteRegistInfo {
	/*
	 * UT003-001
	 * C:/temp/userInfo.txt�Ɍٗp�ҏ�񂪏������܂�邱�ƁB
	 * ���́F{"001","��ؑ��Y","35"}
	 * �o�́F001,��ؑ��Y,35
	 * �����s��
	 * EOF#C:/temp/userInfo.txt
	 */
	@Test
	public final void tRegRegInfo001() throws IOException {
		RegistrantInfo regInfo = new RegistrantInfo();
		regInfo.setrId("001");
		regInfo.setrName("��ؑ��Y");
		regInfo.setrAge("35");
		WriteRegistInfo.regRegInfo(regInfo);
		
		File file = null;
		BufferedReader br = null;
		String line1 = null,line2 = null;
		try{
			file = new File("c:/temp/userInfo.txt");
			br = new BufferedReader(new FileReader(file));
			line1 = br.readLine();
			line2 = br.readLine();
		}catch(Exception e){
			e.printStackTrace();
		} finally {
			br.close();
			assertEquals("001,��ؑ��Y,35", line1);
			assertEquals(null, line2);
		}
	}
	/*
	 * UT003-002
	 * �����ɊY������ٗp�ҏ���ID�ɕR�Â����O�E�N��AC:/temp/userInfo.txt�ŏ㏑������邱�ƁB
	 * ���́F{"002","Michael","29"}
	 * �o�́F001,��ؑ��Y,35
	 * 002,Michael,29
	 * 003,�R�c�Ԏq,30
	 * �����s��
	 * #C:/temp/userInfo.txt
	 */
	@Test
	public final void tModRegInfo002() throws IOException {
		RegistrantInfo regInfo = new RegistrantInfo();
		regInfo.setrId("002");
		regInfo.setrName("Michael");
		regInfo.setrAge("29");
		WriteRegistInfo.modRegInfo(regInfo);
		
		File file = null;
		BufferedReader br = null;
		String line1 = null,line2 = null,line3 = null,line4 = null;
		try{
			file = new File("c:/temp/userInfo.txt");
			br = new BufferedReader(new FileReader(file));
			line1 = br.readLine();
			line2 = br.readLine();
			line3 = br.readLine();
			line4 = br.readLine();
		}catch(Exception e){
			e.printStackTrace();
		} finally {
			br.close();
			assertEquals("001,��ؑ��Y,35", line1);
			assertEquals("002,Michael,29", line2);
			assertEquals("003,�R�c�Ԏq,30", line3);
			assertEquals(null, line4);
		}
	}
	/*
	 * UT003-003
	 * �����ɊY������ٗp�ҏ�񂪁AC:/temp/userInfo.txt����폜����邱�ƁB
	 * ���́F{"001","��ؑ��Y","35"}
	 * �o�́F002,Tommy,25
	 * 003,�R�c�Ԏq,30
	 * �����s��EOF
	 * #C:/temp/userInfo.txt
	 */
	@Test
	public final void tDelRegInfo003() throws IOException {
		RegistrantInfo regInfo = new RegistrantInfo();
		regInfo.setrId("001");
		regInfo.setrName("��ؑ��Y");
		regInfo.setrAge("35");
		WriteRegistInfo.delRegInfo(regInfo);
		
		File file = null;
		BufferedReader br = null;
		String line1 = null,line2 = null,line3 = null;
		try{
			file = new File("c:/temp/userInfo.txt");
			br = new BufferedReader(new FileReader(file));
			line1 = br.readLine();
			line2 = br.readLine();
			line3 = br.readLine();
		}catch(Exception e){
			e.printStackTrace();
		} finally {
			br.close();
			assertEquals("002,Tommy,25", line1);
			assertEquals("003,�R�c�Ԏq,30", line2);
			assertEquals(null, line3);
		}
	}
}
