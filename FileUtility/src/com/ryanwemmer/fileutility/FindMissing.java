package com.ryanwemmer.fileutility;

import java.io.File;
/**
 * The purpose of this class is take a list of images
 * and check if an image file exists. This will save 
 * time in identifying missing or discontinued products.
 * 
 * @author Ryan Wemmer,  7/19/2013
 */

public class FindMissing {
	/**
	 * Returns the name of a file if it is missing.
	 * Returns null if the file exists.
	 * 
	 * @param filePath The file path. Should end with a \ or /
	 * @param fileName Name of the file (for example: image.jpg)
	 */
	public String findIfMissing(String filePath, String fileName){
		//Loop through each file in the array.				
		File f = new File(filePath + fileName); //Load file into file objects
	    if(f.exists()){ //Check if the file exists
	    	return null; //If file exists, do not return anything
	    }else{
	    	//If file is missing, return the missing file name.
	    	return fileName;	          
	    }							
	}	
}
