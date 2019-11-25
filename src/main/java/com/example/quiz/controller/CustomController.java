package com.example.quiz.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.quiz.Custom;
import com.example.quiz.Product;
import com.example.quiz.mapper.CustomMapper;

@RestController
@RequestMapping("/api/v1/Custom")
public class CustomController {

	/**
	 * 自动装配（设置）
	 */
	@Autowired
	CustomMapper mapper;

	Custom cus;
	 int m=0;

	/**
	 * 往数据库中添加会员
	 * 
	 * @return
	 */
	@PostMapping()
	public Map<String, Object> create(@RequestBody Custom custom) {
		System.out.println(custom);
		mapper.addcustom(custom);
		Map<String, Object> msg = new HashMap<>();
		msg.put("msg", "ok");
		return msg;
	}

	@PostMapping("/jifen")
	public Map<String, Object> jifen(@RequestBody HashMap<String, String> hash1) {
		String s = hash1.get("idcard");

		int s1 = Integer.parseInt(hash1.get("price"));
		System.out.println(s + "---" + s1);
		if (s != null) {
			cus = mapper.cus(s);
		}
		if (cus != null) {
			int jifen = cus.getIntegral();
			int changejifen = jifen + s1;
			mapper.updataintegral(s, changejifen);
		}
		System.out.println(cus);
		Map<String, Object> msg = new HashMap<>();
		msg.put("msg", "ok");
		return msg;
	}
	/**
	 * 从数据库获取数据
	 */
	@GetMapping
	public List<Custom> page() {
		return mapper.list();
	}
	
	@PostMapping("/findcus")
	public int findcus(@RequestBody HashMap<String, String> hash1) {
		String s = hash1.get("idcard");
		System.out.println(s);
		if(s=="") {
			m=0;
			return m;
		}
		if(s!="") {
			cus = mapper.cus(s);
			if(cus==null) {
				m=1;
				return m;
			}
			else {
				m=0;
				return m;
			}
		}
		return m;
	}
	
	

}
