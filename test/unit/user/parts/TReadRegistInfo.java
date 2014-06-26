package unit.user.parts;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

import user.bean.RegistrantInfo;
import user.parts.ReadRegistInfo;

public class TReadRegistInfo {

	/*
	 * UT002-001
	 * C:/temp/userInfo.txt����ٗp�ҏ�񂪏o�͂���邱�ƁB
	 * ���́F---
	 * �o�́F{
	 * "001","��ؑ��Y","35"
	 * "002","Tommy","25"
	 * "003","�R�c�Ԏq","30"
	 * }#�߂�l(RegistrantInfo[])
	 */
	@Test
	public final void tGetReglist001() throws IOException {
		RegistrantInfo[] rinf = ReadRegistInfo.getReglist();
		assertEquals("001",rinf[0].getrId());
		assertEquals("��ؑ��Y",rinf[0].getrName());
		assertEquals("35",rinf[0].getrAge());
		assertEquals("002",rinf[1].getrId());
		assertEquals("Tommy",rinf[1].getrName());
		assertEquals("25",rinf[1].getrAge());
		assertEquals("003",rinf[2].getrId());
		assertEquals("�R�c�Ԏq",rinf[2].getrName());
		assertEquals("30",rinf[2].getrAge());
	}
	/*
	 * UT002-002
	 * C:/temp/userInfo.txt�ɕۑ�����Ă���ID�̍ő�l+1�̒l���o�͂���邱�ƁB
	 * ���́F---
	 * �o�́F"004"#�߂�l(String)
	 */
	@Test
	public final void tGetNewId002() throws IOException {
		assertEquals("004", ReadRegistInfo.getNewId());
	}
	/*
	 * UT002-003
	 * C:/temp/userInfo.txt�ɕۑ�����Ă���ID�����݂��Ȃ��ꍇ�A�����l�Ƃ���"001"���o�͂���邱�ƁB
	 * ���́F---
	 * �o�́F"001"#�߂�l(String)
	 */
	@Test
	public final void tGetNewId003() throws IOException {
		assertEquals("001", ReadRegistInfo.getNewId());
	}


}
