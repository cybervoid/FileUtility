package com.ryanwemmer.fileutility;

import java.io.File;
/**
 * This Class reports which images exist in a particular directory.
 * 
 * Possible use: A supplier may provide a list of their products. The
 * supplier is also likely to provide images for those products, often 
 * times provided as a batch download. This function, along with the
 * "FindMissing" is useful by determining if the supplier has provided
 * images for all of their products.
 * 
 * @author Ryan Wemmer,  7/20/2013
 *  
 */

public class FindExisting {
	/**
	 * Returns the name of a file if it exists.
	 * Returns null if the file is missing.
	 * 
	 * @param filePath The file path. Should end with a \ or /
	 * @param fileName Name of the file (for example: image.jpg)
	 */
	public String findIfExisting(String filePath, String fileName){
		//Loop through each file in the array.				
		File f = new File(filePath + fileName); //Create path to file			
		if(f.exists()){
			//If the file exists, the file name is returned.
			return fileName;
		}else{
			//If file is missing, returns nothing.
			return null;          
		}							
	}
}
