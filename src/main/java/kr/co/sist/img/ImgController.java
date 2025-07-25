package kr.co.sist.img;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ImgController {

	@GetMapping("/img/img_view")
	public String img(Model model) {
		
		ImgDTO iDTO = new ImgDTO();
		
		iDTO.setImg("default_img.png");
		iDTO.setTitle("기본이미지");
		
		ImgDTO iDTO2 = new ImgDTO();
		
		iDTO2.setImg("default_img2.png");
		iDTO2.setTitle("기본이미지2");
		
		model.addAttribute("imgData1",iDTO);
		model.addAttribute("imgData2",iDTO2);
		
		return "img/img_view";
	}
	
}
