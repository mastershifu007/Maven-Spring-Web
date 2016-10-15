package com.tuturself.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 * Handles requests for the Uploading a file and saving it to disk.
 *  
 * @author Master Shifu
 *
 */

@Controller
public class FileUploadController {
	
	
	private static final Logger logger = LogManager.getLogger(FileUploadController.class);
	
	
	
	@RequestMapping(value = "/uploadFile", method = RequestMethod.GET)
	public String uploadFile(Locale locale, Model model) {
		
		return null;
	}
	
	@RequestMapping(value = "/upload", method = RequestMethod.GET)
	public String showUploadPage(Locale locale, Model model) {
		
		return "fileupload";
	}

}
