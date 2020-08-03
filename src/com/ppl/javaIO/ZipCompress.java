package com.ppl.javaIO;

import java.io.*;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.zip.*;


public class ZipCompress {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			FileOutputStream f = new FileOutputStream("test.zip");
			CheckedOutputStream csum = new CheckedOutputStream(f, new Adler32());
			ZipOutputStream out = new ZipOutputStream(new BufferedOutputStream(csum));
			out.setComment("A test of Java Zipping");
			// Can't read the above comment, though
			for (int i = 0; i < args.length; i++) {
				System.out.println("Writing file " + args[i]);
				FileInputStream ips = new FileInputStream(args[i]);
				BufferedReader in = new BufferedReader(new InputStreamReader(ips, "utf-8"));

				// BufferedReader in = new BufferedReader(new
				// FileReader(args[i]));
				ZipEntry zipfile = new ZipEntry(args[i]);
				// zipfile.setMethod(0);
				zipfile.setMethod(8);
				out.putNextEntry(zipfile);
				int c;
				byte[] temp = new byte[1024];

				/*
				 * while (in.re >0) { out.w
				 * 
				 * }
				 */
				byte[] bt;
				while ((c = in.read()) != -1) {
					bt = toByteArray(c);
					for (byte b : bt) {
						out.write(b);
					}
					System.out.println(String.format("c char : %c , c int : %x , bt to char %s", (char) c, c,
							Arrays.toString(bt)));
				}

				in.close();
			}
			out.close();
			// Checksum valid only after the file
			// has been closed!
			System.out.println("Checksum: " + csum.getChecksum().getValue());
			// Now extract the files:
			System.out.println("Reading file");
			FileInputStream fi = new FileInputStream("test.zip");
			CheckedInputStream csumi = new CheckedInputStream(fi, new Adler32());
			ZipInputStream in2 = new ZipInputStream(new BufferedInputStream(csumi));
			ZipEntry ze;
			System.out.println("Checksum: " + csumi.getChecksum().getValue());
			while ((ze = in2.getNextEntry()) != null) {
				System.out.println("Reading file " + ze);
				int x;
				while ((x = in2.read()) != -1)
					System.out.write(x);
			}
			in2.close();
			// Alternative way to open and read
			// zip files:
			ZipFile zf = new ZipFile("test.zip");
			Enumeration e = zf.entries();
			while (e.hasMoreElements()) {
				ZipEntry ze2 = (ZipEntry) e.nextElement();
				System.out.println("\t\nFile: " + ze2);
				// ... and extract the data as before
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static byte[] toByteArray(int iSource) {
		byte[] targets = new byte[2];

		targets[1] = (byte) (iSource & 0xff);// ���ֽ�
		targets[0] = (byte) ((iSource >> 8) & 0xff);// ���ֽ�

		System.out.println(String.format("ԭʼ��%x ,  ���ֽ�: %x , ���ֽ� : %x", iSource, iSource & 0xff, (iSource >> 8) & 0xff));
		return targets;
	}
}
