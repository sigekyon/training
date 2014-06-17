package employ;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReadFile {
	private File  file ;
	private BufferedReader pw;
	
	public ReadFile(String fileName) {
		// TODO Auto-generated constructor stub
		file = new File(fileName);
	}
	
	public void FileOpen() throws Exception ,FileNotFoundException{
			pw = new BufferedReader(new InputStreamReader(new FileInputStream (file)));
		
	}

	public String FileRead() throws IOException {
		return pw.readLine();
	}
	public void Fileclose() throws IOException {
		pw.close();
	}
	

}
