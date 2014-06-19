package employ;

/**
 * このクラスは、ログファイルへの書き込みを行います。
 * 
 * <br>最終更新日：2014/6/19
 * @version 1.0
 */
public class OutLog {
	static String fileName ="log.txt";
	static String filePath = "C:\\test\\log\\" + fileName ;
	
	public static void outLogDmp(String s){
		//ログファイルオープン
		WriteFile wf = new WriteFile(filePath);
		try {
			wf.openFile();
			wf.writeFile(s);
			wf.closeFile();
		} catch (Exception e) {
			// TODO Auto-generated catch block
		}
	}

	public static void outLogDmp(Integer s){
		//ログファイルオープン
		WriteFile wf = new WriteFile(filePath);
		try {
			wf.openFile();
			wf.writeFile(s.toString());
			wf.closeFile();
		} catch (Exception e) {
			// TODO Auto-generated catch block
		}
	}
}
