package com.Airpay.Utilities;
import java.io.*;
import java.io.FileReader;
import java.util.*;
import java.util.Comparator;
//Code for finding latest file in directory

	public class latestfirst {
		public static void main(String[] args) throws Exception {
		File f = new File("D:\\\\Automation\\\\AirpayAutomationProject_Updated\\\\Airpay_Automation_Framework\\\\AirPayTestData\\\\Result\\\\Graphical Reporting\\\\HTML");
		File[] files = f.listFiles();
		Arrays.sort(files, new Comparator() {
			public int compare(File f1, File f2) {
				return Long.valueOf(f1.lastModified()).compareTo(
						f2.lastModified());
			}

			@Override
			public int compare(Object o1, Object o2) {
				// TODO Auto-generated method stub
				return 0;
			}

			
		});
		System.out.println("Files of the directory: ");
		for (int i = 0; i < files.length; i++) {
			System.out.println(files[i].getName());
		}
		System.out.println();
		System.out.println("Latest File is: "
				+ files[files.length - 1].getName());
		System.out.println();
	/*
		File file = new File(files[files.length - 1].getPath());
		String filename = file.getPath();
		BufferedReader reader = new BufferedReader(new FileReader(filename));
		String line = null;
		System.out.println("File Data");
		while ((line = reader.readLine()) != null) {
			System.out.println(line);
		}
	*/	
	}}