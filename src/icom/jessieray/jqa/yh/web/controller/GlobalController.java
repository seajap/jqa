package icom.jessieray.jqa.yh.web.controller;


import java.net.InetAddress;
import java.util.Set;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class GlobalController {

	@RequestMapping("/view/{jsp}")
	public String view(@PathVariable String jsp){
		return jsp;
	}

}
