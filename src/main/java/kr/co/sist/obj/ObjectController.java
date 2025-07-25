package kr.co.sist.obj;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ObjectController {

	@GetMapping("obj/object_value")
	public String objectValue(Model model, @RequestParam("name") String n, @RequestParam("age") int a) {

		ObjDTO obj = new ObjDTO();
		obj.setName("주현석");
		obj.setAge(30);
		
		model.addAttribute("data",obj);
		
		return "obj/obj_view";
	}
	
}
