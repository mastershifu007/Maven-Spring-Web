package com.tuturself.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Locale;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;


/**
 * Handles requests for the Uploading a file and saving it to disk.
 *  
 * @author Master Shifu
 *
 */

@Controller
public class CustomFileUploadController {
	
	
	private static final Logger logger = LogManager.getLogger(CustomFileUploadController.class);
	
	
	
	@RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
	public String uploadFile(@RequestParam("file") MultipartFile file,Model model) {
		if (!file.isEmpty()) {
			String name = file.getOriginalFilename();
			try {
				byte[] bytes = file.getBytes();
				
				// Creating the directory to store file
				// We can add Custom path to write on disk
				String rootPath = System.getProperty("catalina.home");  
				File dir = new File(rootPath + File.separator + "tmpFiles");
				if (!dir.exists())
					dir.mkdirs();

				// Create the file on server
				File serverFile = new File(dir.getAbsolutePath()+ File.separator + name);
				BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
				stream.write(bytes);
				stream.close();

				logger.info("File Location="+ serverFile.getAbsolutePath());
				model.addAttribute("message", "You successfully uploaded file=" + name );
				model.addAttribute("fileName",name);
			} catch (Exception e) {
				model.addAttribute("message", "Filed to upload " + name + " => " + e.getMessage());
			}
		} else {
			model.addAttribute("message", "Failed to upload file is empty" );
		}
		return "fileupload";
	}
	
	@RequestMapping(value = "/upload", method = RequestMethod.GET)
	public String showUploadPage(Locale locale, Model model) {
		
		return "fileupload";
	}
	
	/*@RequestMapping(value = "/getImage", method = RequestMethod.GET)
	public void getImageAsByteArray(@RequestParam("filename") String fileName , HttpServletResponse response) throws IOException {
		
		String rootPath = System.getProperty("catalina.home");  
		File dir = new File(rootPath + File.separator + "tmpFiles");
		File serverFile = new File(dir.getAbsolutePath()+ File.separator + fileName);
		
	    InputStream in = 
	    response.setContentType(MediaType.IMAGE_JPEG_VALUE);
	    IOUtils.copy(in, response.getOutputStream());
	}*/

}
