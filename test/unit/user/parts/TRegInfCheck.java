package unit.user.parts;

import static org.junit.Assert.*;

import org.junit.Test;

import user.parts.RegInfCheck;

public class TRegInfCheck {
	/*
	 * UT001-001
	 * ���p10���ŋ󕶎����o�͂���邱�ƁB
	 * ���́F"0123456789"
	 * �o�́F""#RegInfCheck.getErrMsg
	 */
	@Test
	public final void tCheckName001() {
		RegInfCheck reginfcheck = new RegInfCheck();
		reginfcheck.checkName("0123456789");
		assertEquals("",reginfcheck.getErrMsg());
	}
	/*
	 * UT001-002
	 * �S�p10���ŋ󕶎����o�͂���邱�ƁB
	 * ���́F"��������������������"
	 * �o�́F""#RegInfCheck.getErrMsg
	 */
	@Test
	public final void tCheckName002() {
		RegInfCheck reginfcheck = new RegInfCheck();
		reginfcheck.checkName("��������������������");
		assertEquals("",reginfcheck.getErrMsg());
	}
	/*
	 * UT001-003
	 * ���p11���ŃG���[���b�Z�[�W���o�͂���邱�ƁB
	 * ���́F"01234567890"
	 * �o�́F"���O��10���ȓ��œ��͂��Ă��������B<br />"#RegInfCheck.getErrMsg
	 */
	@Test
	public final void tCheckName003() {
		RegInfCheck reginfcheck = new RegInfCheck();
		reginfcheck.checkName("01234567890");
		assertEquals("���O��10���ȓ��œ��͂��Ă��������B<br />",reginfcheck.getErrMsg());
	}
	/*
	 * UT001-004
	 * �S�p11���ŃG���[���b�Z�[�W���o�͂���邱�ƁB
	 * ���́F"����������������������"
	 * �o�́F"���O��10���ȓ��œ��͂��Ă��������B<br />"#RegInfCheck.getErrMsg
	 */
	@Test
	public final void tCheckName004() {
		RegInfCheck reginfcheck = new RegInfCheck();
		reginfcheck.checkName("����������������������");
		assertEquals("���O��10���ȓ��œ��͂��Ă��������B<br />",reginfcheck.getErrMsg());
	}
	/*
	 * UT001-005
	 * ���p����16�ŋ󕶎����o�͂���邱�ƁB
	 * ���́F"16"
	 * �o�́F""#RegInfCheck.getErrMsg
	 */
	@Test
	public final void tCheckAge005() {
		RegInfCheck reginfcheck = new RegInfCheck();
		reginfcheck.checkAge("16");
		assertEquals("",reginfcheck.getErrMsg());
	}
	/*
	 * UT001-006
	 * ���p����60�ŋ󕶎����o�͂���邱�ƁB
	 * ���́F"60"
	 * �o�́F""#RegInfCheck.getErrMsg
	 */
	@Test
	public final void tCheckAge006() {
		RegInfCheck reginfcheck = new RegInfCheck();
		reginfcheck.checkAge("60");
		assertEquals("",reginfcheck.getErrMsg());
	}
	/*
	 * UT001-007
	 * ���p����15�ŃG���[���b�Z�[�W���o�͂���邱�ƁB
	 * ���́F"15"
	 * �o�́F"�N���(16-60)�͈̔͂œ��͂��Ă��������B<br />"#RegInfCheck.getErrMsg
	 */
	@Test
	public final void tCheckAge007() {
		RegInfCheck reginfcheck = new RegInfCheck();
		reginfcheck.checkAge("15");
		assertEquals("�N���(16-60)�͈̔͂œ��͂��Ă��������B<br />",reginfcheck.getErrMsg());
	}
	/*
	 * UT001-008
	 * ���p����61�ŃG���[���b�Z�[�W���o�͂���邱�ƁB
	 * ���́F"61"
	 * �o�́F"�N���(16-60)�͈̔͂œ��͂��Ă��������B<br />"#RegInfCheck.getErrMsg
	 */
	@Test
	public final void tCheckAge008() {
		RegInfCheck reginfcheck = new RegInfCheck();
		reginfcheck.checkAge("61");
		assertEquals("�N���(16-60)�͈̔͂œ��͂��Ă��������B<br />",reginfcheck.getErrMsg());
	}
	/*
	 * UT001-009
	 * �S�p����16�ŃG���[���b�Z�[�W���o�͂���邱�ƁB
	 * ���́F"�P�U"
	 * �o�́F"�N��͐��l(���p)�œ��͂��Ă��������B<br />"#RegInfCheck.getErrMsg
	 */
	@Test
	public final void tCheckAge009() {
		RegInfCheck reginfcheck = new RegInfCheck();
		reginfcheck.checkAge("�P�U");
		assertEquals("�N��͐��l(���p)�œ��͂��Ă��������B<br />",reginfcheck.getErrMsg());
	}
	/*
	 * UT001-010
	 * ���p�����ȊO�ŃG���[���b�Z�[�W���o�͂���邱�ƁB
	 * ���́F"����������"
	 * �o�́F"�N��͐��l(���p)�œ��͂��Ă��������B<br />
	�N���(16-60)�͈̔͂œ��͂��Ă��������B<br />"#RegInfCheck.getErrMsg
	 */
	@Test
	public final void tCheckAge010() {
		RegInfCheck reginfcheck = new RegInfCheck();
		reginfcheck.checkAge("����������");
		assertEquals("�N��͐��l(���p)�œ��͂��Ă��������B<br />�N���(16-60)�͈̔͂œ��͂��Ă��������B<br />",reginfcheck.getErrMsg());
	}
	/*
	 * UT001-011
	 * ���p�����{���p�����ȊO�ŃG���[���b�Z�[�W���o�͂���邱�ƁB
	 * ���́F"16����������"
	 * �o�́F"�N��͐��l(���p)�œ��͂��Ă��������B<br />
	�N���(16-60)�͈̔͂œ��͂��Ă��������B<br />"#RegInfCheck.getErrMsg
	 */
	@Test
	public final void tCheckAge011() {
		RegInfCheck reginfcheck = new RegInfCheck();
		assertEquals("",reginfcheck.getErrMsg());
	}
	/*
	 * UT001-012
	 * 999�ŋ󕶎����o�͂���邱�ƁB
	 * ���́F"999"
	 * �o�́F""#RegInfCheck.getErrMsg>
	 */
	@Test
	public final void tCheckId012() {
		RegInfCheck reginfcheck = new RegInfCheck();
		reginfcheck.checkId("999");
		assertEquals("",reginfcheck.getErrMsg());
	}
	/*
	 * UT001-013
	 * 1000�ŃG���[���b�Z�[�W���o�͂���邱�ƁB
	 * ���́F"1000"
	 * �o�́F"�o�^�\��ID�i999�j�𒴂��Ă��܂��B�Ǘ��҂ɖ₢���킹�Ă��������B<br />"#RegInfCheck.getErrMsg
	 */
	@Test
	public final void tCheckId013() {
		RegInfCheck reginfcheck = new RegInfCheck();
		reginfcheck.checkId("1000");
		assertEquals("�o�^�\��ID�i999�j�𒴂��Ă��܂��B�Ǘ��҂ɖ₢���킹�Ă��������B<br />",reginfcheck.getErrMsg());
	}

}
