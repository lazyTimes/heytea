package com.example.quiz.controller;

import com.example.quiz.Custom;
import com.example.quiz.mapper.CustomMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
public class HomeController {

    @Autowired
    CustomMapper mapper;

	@RequestMapping("/index")
	public String diandan(HttpSession session) {
		if(session.getAttribute("uname") == null || session.getAttribute("idcard") == null){
			return "redirect:login";
		}
		return "heytea.html";
	}


	@RequestMapping(value={"/login","/"})
	public String login() {
		return "login.html";
	}

	@PostMapping("/register")
	@ResponseBody
	public Map<String, Object> loginDo(@RequestBody Custom cus){
		Map<String,Object> result = new HashMap<>();
		Custom login = mapper.login(cus);
		if(login==null){
			mapper.addcustom(cus);
			result.put("code",200);
			result.put("msg", "注册成功");
		}else{
			result.put("code",400);
			result.put("msg", "用户名或者卡号已经被绑定");
		}

		return result;
	}


	@PostMapping("/loing")
	@ResponseBody
	public Map<String, Object> loginDo(@RequestBody Custom cus, HttpSession session){

		Map<String,Object> result = new HashMap<>();
        Custom login = mapper.login(cus);
        if(login!=null){
			session.setAttribute("uname",login.getName() );
			session.setAttribute("idcard",login.getIdcard() );
        	result.put("code",200);
        	result.put("msg", "登陆成功");
		}else{
			result.put("code",400);
			result.put("msg", "登陆失败，请检查用户名和密码");
		}


        return result;
    }
}
