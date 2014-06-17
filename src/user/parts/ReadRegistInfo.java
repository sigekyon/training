package user.parts;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;

import user.bean.RegistrantInfo;

public class ReadRegistInfo {

	public int lineCount(File f) throws IOException {
		

		LineNumberReader lr = new LineNumberReader(new FileReader(f));

		String tmpLine;

		while (null != (tmpLine = lr.readLine())) {
			;
		}

		int lineNum = lr.getLineNumber();

		lr.close();
		
		return lineNum;
	}

	public RegistrantInfo[] getReglist(File file) throws IOException {

		BufferedReader br = new BufferedReader(new FileReader(file));

		int lineNum = lineCount(file);
		RegistrantInfo[] regInfo = new RegistrantInfo[lineNum];

		String rLine = null;

		for (int i = 0; i < lineNum; i++) {
			regInfo[i] = new RegistrantInfo();
			rLine = br.readLine();
			String[] rInfo = rLine.split(",");

			regInfo[i].setrId(rInfo[0]);
			regInfo[i].setrName(rInfo[1]);
			regInfo[i].setrAge(rInfo[2]);
		}

		br.close();
		return regInfo;
	}

	public String[] getRegId(File file) throws IOException {

		BufferedReader br = new BufferedReader(new FileReader(file));

		int lineNum = lineCount(file);
		String[] idList = new String[lineNum];
		String rLine = null;

		for (int i=0; i<lineNum; i++) {
			idList[i] = new String();
			rLine = br.readLine();
			String[] rInfo = rLine.split(",");

			idList[i] = rInfo[0];
		}

		br.close();
		return idList;
	}
	
}
