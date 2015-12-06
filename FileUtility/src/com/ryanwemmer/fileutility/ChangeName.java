package com.ryanwemmer.fileutility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * This class takes a list of files, found in a source directory, and
 * creates a copy with a new name saved in a new destination directory.  
 * 
 * @author Ryan Wemmer 
 * Copyright (c) July 20, 2013
 */
public class ChangeName{	
	/**
	 * This method takes takes the user inputs and makes copies of all files. This method is called by the GUI. 
	 * It should loop through all of the files and create copies of each one.
	 * 
	 * @param sourceDirectory Location of the source files. Parameter must include a trailing slash. (\ or /)
	 * @param destinationDirectory Directory to save new files. Parameter must include a trailing slash. (\ or /)
	 * @param inputFiles String array containing the names of the source files. Each element is the existing file name with extension. 
	 * @param outFiles: String array containing the names of the destination files. Each element is the new file name with extension. 
	 */
	public void makeAllFiles(String sourceDirectory, String destinationDirectory, 
			String[] inputFiles, String[] outputFiles){	
		//Loop through each file on the list
		for(int i = 0; i < inputFiles.length; i++){ 							
			String sourceFile = sourceDirectory + inputFiles[i]; 			//Create Full file path for source file
			String destinationFile = destinationDirectory + outputFiles[i];	//Create Full file path for output file				
			try{
				saveNewFile(sourceFile, destinationFile);					//Run method that creates the new file.
			}catch(Exception e){ 											//Debugging Only: Print errors to console
				System.out.println(e.toString()); 
				System.out.println("Error: " + inputFiles[i]);
			}
		}		
	}			
	/** 
	 * This should result in a copy of sourceFile located at destinationFile with the specified new name
	 * 
	 * @param sourceFile Source file. This should include the full path and file name.
	 * @param destinationFile The output file, this should include the full path and file name.
	 * @throws IOException Throws an IOException if an error occurs. 
	 */
	private void saveNewFile(String sourceFile, String destinationFile) 
			throws IOException{				
		//File handling
		File f = new File(sourceFile); 
		FileInputStream is = new FileInputStream(f);
		OutputStream os = new FileOutputStream(destinationFile); 		
		byte[] b = new byte[2048]; 								//Byte array for storing data
		int length; 											
		while ((length = is.read(b)) != -1) {					//Read the byte array, write to new file
			os.write(b, 0, length);								
		}
		//Close Streams
		is.close();
		os.close();
	} 
}