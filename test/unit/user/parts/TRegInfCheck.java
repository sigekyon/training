package unit.user.parts;

import static org.junit.Assert.*;

import org.junit.Test;

import user.parts.RegInfCheck;

public class TRegInfCheck {
	/*
	 * UT001-001
	 * 半角10桁で空文字が出力されること。
	 * 入力："0123456789"
	 * 出力：""#RegInfCheck.getErrMsg
	 */
	@Test
	public final void tCheckName001() {
		RegInfCheck reginfcheck = new RegInfCheck();
		reginfcheck.checkName("0123456789");
		assertEquals("",reginfcheck.getErrMsg());
	}
	/*
	 * UT001-002
	 * 全角10桁で空文字が出力されること。
	 * 入力："あいうえおかきくけこ"
	 * 出力：""#RegInfCheck.getErrMsg
	 */
	@Test
	public final void tCheckName002() {
		RegInfCheck reginfcheck = new RegInfCheck();
		reginfcheck.checkName("あいうえおかきくけこ");
		assertEquals("",reginfcheck.getErrMsg());
	}
	/*
	 * UT001-003
	 * 半角11桁でエラーメッセージが出力されること。
	 * 入力："01234567890"
	 * 出力："名前は10桁以内で入力してください。<br />"#RegInfCheck.getErrMsg
	 */
	@Test
	public final void tCheckName003() {
		RegInfCheck reginfcheck = new RegInfCheck();
		reginfcheck.checkName("01234567890");
		assertEquals("名前は10桁以内で入力してください。<br />",reginfcheck.getErrMsg());
	}
	/*
	 * UT001-004
	 * 全角11桁でエラーメッセージが出力されること。
	 * 入力："あいうえおかきくけこさ"
	 * 出力："名前は10桁以内で入力してください。<br />"#RegInfCheck.getErrMsg
	 */
	@Test
	public final void tCheckName004() {
		RegInfCheck reginfcheck = new RegInfCheck();
		reginfcheck.checkName("あいうえおかきくけこさ");
		assertEquals("名前は10桁以内で入力してください。<br />",reginfcheck.getErrMsg());
	}
	/*
	 * UT001-005
	 * 半角数字16で空文字が出力されること。
	 * 入力："16"
	 * 出力：""#RegInfCheck.getErrMsg
	 */
	@Test
	public final void tCheckAge005() {
		RegInfCheck reginfcheck = new RegInfCheck();
		reginfcheck.checkAge("16");
		assertEquals("",reginfcheck.getErrMsg());
	}
	/*
	 * UT001-006
	 * 半角数字60で空文字が出力されること。
	 * 入力："60"
	 * 出力：""#RegInfCheck.getErrMsg
	 */
	@Test
	public final void tCheckAge006() {
		RegInfCheck reginfcheck = new RegInfCheck();
		reginfcheck.checkAge("60");
		assertEquals("",reginfcheck.getErrMsg());
	}
	/*
	 * UT001-007
	 * 半角数字15でエラーメッセージが出力されること。
	 * 入力："15"
	 * 出力："年齢は(16-60)の範囲で入力してください。<br />"#RegInfCheck.getErrMsg
	 */
	@Test
	public final void tCheckAge007() {
		RegInfCheck reginfcheck = new RegInfCheck();
		reginfcheck.checkAge("15");
		assertEquals("年齢は(16-60)の範囲で入力してください。<br />",reginfcheck.getErrMsg());
	}
	/*
	 * UT001-008
	 * 半角数字61でエラーメッセージが出力されること。
	 * 入力："61"
	 * 出力："年齢は(16-60)の範囲で入力してください。<br />"#RegInfCheck.getErrMsg
	 */
	@Test
	public final void tCheckAge008() {
		RegInfCheck reginfcheck = new RegInfCheck();
		reginfcheck.checkAge("61");
		assertEquals("年齢は(16-60)の範囲で入力してください。<br />",reginfcheck.getErrMsg());
	}
	/*
	 * UT001-009
	 * 全角数字16でエラーメッセージが出力されること。
	 * 入力："１６"
	 * 出力："年齢は数値(半角)で入力してください。<br />"#RegInfCheck.getErrMsg
	 */
	@Test
	public final void tCheckAge009() {
		RegInfCheck reginfcheck = new RegInfCheck();
		reginfcheck.checkAge("１６");
		assertEquals("年齢は数値(半角)で入力してください。<br />",reginfcheck.getErrMsg());
	}
	/*
	 * UT001-010
	 * 半角数字以外でエラーメッセージが出力されること。
	 * 入力："あいうえお"
	 * 出力："年齢は数値(半角)で入力してください。<br />
	年齢は(16-60)の範囲で入力してください。<br />"#RegInfCheck.getErrMsg
	 */
	@Test
	public final void tCheckAge010() {
		RegInfCheck reginfcheck = new RegInfCheck();
		reginfcheck.checkAge("あいうえお");
		assertEquals("年齢は数値(半角)で入力してください。<br />年齢は(16-60)の範囲で入力してください。<br />",reginfcheck.getErrMsg());
	}
	/*
	 * UT001-011
	 * 半角数字＋半角数字以外でエラーメッセージが出力されること。
	 * 入力："16あいうえお"
	 * 出力："年齢は数値(半角)で入力してください。<br />
	年齢は(16-60)の範囲で入力してください。<br />"#RegInfCheck.getErrMsg
	 */
	@Test
	public final void tCheckAge011() {
		RegInfCheck reginfcheck = new RegInfCheck();
		assertEquals("",reginfcheck.getErrMsg());
	}
	/*
	 * UT001-012
	 * 999で空文字が出力されること。
	 * 入力："999"
	 * 出力：""#RegInfCheck.getErrMsg>
	 */
	@Test
	public final void tCheckId012() {
		RegInfCheck reginfcheck = new RegInfCheck();
		reginfcheck.checkId("999");
		assertEquals("",reginfcheck.getErrMsg());
	}
	/*
	 * UT001-013
	 * 1000でエラーメッセージが出力されること。
	 * 入力："1000"
	 * 出力："登録可能なID（999）を超えています。管理者に問い合わせてください。<br />"#RegInfCheck.getErrMsg
	 */
	@Test
	public final void tCheckId013() {
		RegInfCheck reginfcheck = new RegInfCheck();
		reginfcheck.checkId("1000");
		assertEquals("登録可能なID（999）を超えています。管理者に問い合わせてください。<br />",reginfcheck.getErrMsg());
	}

}
