package com.ryanwemmer.fileutility;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;


public class DownloadFile {
	
	//Directory is where the files are saved.
	public void downloadFile(String directory, String[] fileLinks, String[] fileFiles, Boolean cbAppendUrl) throws Exception{		
		//If the url needs the File added to the end, create the url here:
		
		if(fileLinks.length == fileFiles.length){
			if(cbAppendUrl == true){
				for(int i = 0; i < fileLinks.length; i++ ){
					try{
						String destinationFile = directory + fileFiles[i];
						String fileUrl = fileLinks[i] + fileLinks[i];
						saveFile(fileUrl, destinationFile);
					}catch(Exception e){
						System.out.println(e.toString());
						System.out.println("Error: " + fileFiles[i]);
					}
				}			
			}else{
				for(int i = 0; i < fileLinks.length; i++ ){				
					try{
						String destinationFile = directory + fileFiles[i];
						String fileUrl = fileLinks[i];
						saveFile(fileUrl, destinationFile);
					}catch(Exception e){
						System.out.println(e.toString());
						System.out.println("Error: " + fileFiles[i]);
					}
				}
			}
		}else{
			System.out.println("Error. Lists are different lengths!");
		}
	}
	
	//Create the file input/output handler.
	public static void saveFile(String fileUrl, String destinationFile) throws IOException {
		URL url = new URL(fileUrl);
		InputStream is = url.openStream();
		OutputStream os = new FileOutputStream(destinationFile);
		byte[] b = new byte[2048];
		int length;
		while ((length = is.read(b)) != -1) {
			os.write(b, 0, length);
		}
			is.close();
			os.close();
	}
}