package kr.co.sist.condition;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.sist.img.ImgDTO;

@Controller
public class ConditionController {

	@GetMapping("condition/condition_view")
	public String condition(Model model, @RequestParam(value="id", defaultValue="0") int id) {
		
		List<ImgDTO> imgList = new ArrayList<ImgDTO>();
		imgList.add(new ImgDTO("default_img.png", "야호"));
		imgList.add(new ImgDTO("default_img2.png", "오늘은"));
		imgList.add(new ImgDTO("dice_1.png", "목요일"));
		imgList.add(new ImgDTO("dice_2.png", "이다"));
		imgList.add(new ImgDTO("dice_3.png", "이제"));
		imgList.add(new ImgDTO("dice_4.png", "곧"));
		imgList.add(new ImgDTO("dice_5.png", "주말"));
		imgList.add(new ImgDTO("dice_6.png", "이다"));
		
		model.addAttribute("imgList", imgList);
		
		switch(id) {
		case 0:
			model.addAttribute("name","이장훈");
			model.addAttribute("score", 90);
			
			ConditionDTO cDTO = new ConditionDTO();
			cDTO.setAge(20);
			cDTO.setName("강태일");
			cDTO.setRole("user");
			
			model.addAttribute("cDTO",cDTO);
			
			List<String> list = new ArrayList<String>();
			list.add("이장훈");
			list.add("강태일");
			list.add("주현석");
			list.add("양준수");
			list.add("이호빈");
			list.add("심규민");
			
			model.addAttribute("list",list);
			break;
		case 1:
			model.addAttribute("name","야호");
			model.addAttribute("score", 13);
			
			ConditionDTO cDTO2 = new ConditionDTO();
			cDTO2.setAge(2330);
			cDTO2.setName("야호");
			cDTO2.setRole("guest");
			
			model.addAttribute("cDTO",cDTO2);
			List<String> list2 = new ArrayList<String>();
			list2.add("이장훈");
			list2.add("강태일");
			list2.add("주현석");
			list2.add("양준수");
			list2.add("이호빈");
			list2.add("심규민");
			
			model.addAttribute("list",list2);
			break;
		case 2:
			model.addAttribute("name","목요일");
			model.addAttribute("score", 667);
			
			ConditionDTO cDTO3 = new ConditionDTO();
			cDTO3.setAge(1234);
			cDTO3.setName("누구세요?");
			cDTO3.setRole("admin");
			
			model.addAttribute("cDTO",cDTO3);
			List<String> list3 = new ArrayList<String>();
			list3.add("이장훈");
			list3.add("강태일");
			list3.add("주현석");
			list3.add("양준수");
			list3.add("이호빈");
			list3.add("심규민");
			
			model.addAttribute("list",list3);
			break;
		}
		
		return "condition/condition_view";
	}
	
}
