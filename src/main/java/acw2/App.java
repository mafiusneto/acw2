package acw2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@SpringBootApplication
@Controller
public class App {

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);

	}
	
	@RequestMapping({"","/","teste"})
	@ResponseBody
	String Teste(){
		//tcc_horafacil
		return "Teste ok!!";
	}

}
