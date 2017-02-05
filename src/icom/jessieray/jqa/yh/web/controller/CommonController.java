package icom.jessieray.jqa.yh.web.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/common")
public class CommonController {

	private String path = "/jqa/img/";
	private String IMGHTTP = "";
	
	@RequestMapping(value="/fileUpload",method=RequestMethod.POST)
	public @ResponseBody Map fileUpload(@RequestParam(value = "file") MultipartFile file) throws IOException {
		String fileName = new SimpleDateFormat("YYYYMMDDHHmmss").format(new Date())+file.getOriginalFilename();
		File targetFile = new File(path, fileName);
		if (!targetFile.exists()) {
			targetFile.mkdirs();
		}
		try {
			file.transferTo(targetFile);
		} catch (Exception e) {
			e.printStackTrace();
		}
		Map map = new HashMap();
		map.put("imgpath", IMGHTTP+fileName);
		System.out.println(map);
		return map;
	}
}
