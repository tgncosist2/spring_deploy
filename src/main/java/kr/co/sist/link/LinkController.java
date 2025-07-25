package kr.co.sist.link;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LinkController {

	@GetMapping("link/link_view")
	public String link(Model model) {
		
		List<LinkDTO> list = new ArrayList<LinkDTO>();
				
		LinkDTO lDTO = new LinkDTO();
		lDTO.setUrl("www.daum.net");
		lDTO.setNameKor("다음");
		lDTO.setNameEng("Daum");
		
		LinkDTO lDTO2 = new LinkDTO();
		lDTO2.setUrl("/obj/object_value");
		lDTO2.setNameKor("구글");
		lDTO2.setNameEng("Google");
		lDTO2.setName("강태일");
		lDTO2.setAge(22);
		
		list.add(lDTO2);
		list.add(lDTO);
		
		model.addAttribute("list",list);
		
		return "link/link_view";
	}
	
}
