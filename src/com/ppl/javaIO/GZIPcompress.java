package com.ppl.javaIO;

import java.io.*;
import java.util.zip.*;

public class GZIPcompress {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			BufferedReader br = new BufferedReader(new FileReader("1.txt"));

			BufferedOutputStream bos = new BufferedOutputStream(new GZIPOutputStream(new FileOutputStream("x.gz")));
			System.out.println("start wirte gzip file.");
			int c;
			while ((c = br.read()) != -1)
				bos.write(c);
			br.close();
			bos.close();
			System.out.println("Reading file");
			BufferedReader in2 = new BufferedReader(  
					new InputStreamReader(new GZIPInputStream(new FileInputStream("x.gz"))));
			String s;
			while ((s = in2.readLine()) != null)
				System.out.println(s);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
