package employ;


public class OutLog {
	static String fileName ="log.txt";
	static String filePath = "C:\\test\\log\\" + fileName ;
	
	public static void outLogDmp(String s){
		//���O�t�@�C���I�[�v��
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
		//���O�t�@�C���I�[�v��
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