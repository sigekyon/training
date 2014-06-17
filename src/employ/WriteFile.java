package employ;

import java.io.*;

public class WriteFile {
	private File  file ;
	private PrintWriter pw;
	
	public WriteFile(String fileName) {
		// TODO Auto-generated constructor stub
		file = new File(fileName);
	}
	
	public void openFile() throws Exception{
		pw = new PrintWriter(new OutputStreamWriter(new FileOutputStream (file, true)));
	}
	public void openNewFile() throws Exception{
		pw = new PrintWriter(new OutputStreamWriter(new FileOutputStream (file, false)));
	}

	public void writeFile(String str) {
		pw.println(DateString.getDate14() + ":" + str);
	}
	public void writeln(String str) {
		pw.println(str);
	}
	public void closeFile() {
		pw.close();
	}

	public void deleteFile() {
		file.delete();
	}
	public boolean existFile() {
		return file.exists();
	}

}

