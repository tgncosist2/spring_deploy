package kr.co.sist.controller;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.net.URLEncoder;
import java.util.Random;


@Controller
public class MainController {

	@RequestMapping(value="/", method= {GET,POST})
	public String index(Model model) {

		if (new Random().nextBoolean()) {
			model.addAttribute("message","야호수요ㅕ일이다아아");
			model.addAttribute("message2","<strong>asdasdasd</strong>");
			model.addAttribute("name","이장훈");
			model.addAttribute("name2","강태일");
			model.addAttribute("color","color:red;");
			
			model.addAttribute("id","ju");
		}
		
		return "index";
	}
	
	@GetMapping("/yaho")
	public String yaho() {
		return "yaho";
	}
	
    @GetMapping("/search")
    @ResponseBody
    public ResponseEntity<?> search(
        @RequestParam String query,
        @RequestParam(defaultValue = "1") int display,
        @RequestParam(defaultValue = "1") int start,
        @RequestParam(defaultValue = "sim") String sort
    ) {
        try {
            RestTemplate restTemplate = new RestTemplate();
            
            // 헤더 설정
            HttpHeaders headers = new HttpHeaders();
            headers.set("X-Naver-Client-Id", "vQhtW2kM75FaIm_vc50t");
            headers.set("X-Naver-Client-Secret", "pwkQ0qSRBl");
            HttpEntity<?> entity = new HttpEntity<>(headers);
            
            // URL 생성
            String url = String.format(
                "https://openapi.naver.com/v1/search/image?query=%s&display=%d&start=%d&sort=%s",
                URLEncoder.encode(query, "UTF-8"), display, start, sort
            );
            
            // API 호출
            ResponseEntity<String> response = restTemplate.exchange(
                url, 
                HttpMethod.GET, 
                entity, 
                String.class
            );
            
            return ResponseEntity.ok(response.getBody());
            
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("검색 중 오류가 발생했습니다: " + e.getMessage());
        }
    }
}
	
