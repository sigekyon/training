package unit.employ;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

import employ.OutLog;

public class TOutLog {

	/*
	 * UT004-001
	 * 入力された文字列がC:/test/log/log.txtに書き込まれること。
	 * 入力：""sample：サンプル""
	 * 出力：yyyy/mm/dd hh:mm:ss:sample：サンプル
	EOF#C:/test/log/log.txt
	 */
	@Test
	public final void tOutLogDmp001() throws IOException {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		OutLog.outLogDmp("sample：サンプル");
		assertEquals(sdf.format(date) + ":sample：サンプル", getLog());
		
	}
	/*
	 * UT004-002
	 * 入力された数値がC:/test/log/log.txtに書き込まれること。
	 * 入力：12345
	 * 出力：yyyy/mm/dd hh:mm:ss:12345
	EOF#C:/test/log/log.txt
	 */
	@Test
	public final void tOutLogDmp002() throws IOException {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		OutLog.outLogDmp(12345);
		assertEquals(sdf.format(date) + ":12345", getLog());
	}
	
	private String getLog() throws IOException{
		String strLog = null;
		File file = null;
		BufferedReader br = null;
		try{
			file = new File("C:/test/log/log.txt");
			br = new BufferedReader(new FileReader(file));
			strLog = br.readLine();
		}catch(Exception e){
			e.printStackTrace();
		} finally {
			br.close();
		}
		return strLog;
	}

}
