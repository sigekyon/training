package unit.user.parts;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

import user.bean.RegistrantInfo;
import user.parts.ReadRegistInfo;

public class TReadRegistInfo {

	/*
	 * UT002-001
	 * C:/temp/userInfo.txtから雇用者情報が出力されること。
	 * 入力：---
	 * 出力：{
	 * "001","鈴木太郎","35"
	 * "002","Tommy","25"
	 * "003","山田花子","30"
	 * }#戻り値(RegistrantInfo[])
	 */
	@Test
	public final void tGetReglist001() throws IOException {
		RegistrantInfo[] rinf = ReadRegistInfo.getReglist();
		assertEquals("001",rinf[0].getrId());
		assertEquals("鈴木太郎",rinf[0].getrName());
		assertEquals("35",rinf[0].getrAge());
		assertEquals("002",rinf[1].getrId());
		assertEquals("Tommy",rinf[1].getrName());
		assertEquals("25",rinf[1].getrAge());
		assertEquals("003",rinf[2].getrId());
		assertEquals("山田花子",rinf[2].getrName());
		assertEquals("30",rinf[2].getrAge());
	}
	/*
	 * UT002-002
	 * C:/temp/userInfo.txtに保存されているIDの最大値+1の値が出力されること。
	 * 入力：---
	 * 出力："004"#戻り値(String)
	 */
	@Test
	public final void tGetNewId002() throws IOException {
		assertEquals("004", ReadRegistInfo.getNewId());
	}
	/*
	 * UT002-003
	 * C:/temp/userInfo.txtに保存されているIDが存在しない場合、初期値として"001"が出力されること。
	 * 入力：---
	 * 出力："001"#戻り値(String)
	 */
	@Test
	public final void tGetNewId003() throws IOException {
		assertEquals("001", ReadRegistInfo.getNewId());
	}


}
