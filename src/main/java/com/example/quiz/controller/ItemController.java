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

import com.example.quiz.Item;
import com.example.quiz.Product;
import com.example.quiz.mapper.ItemMapper;

@RestController
@RequestMapping("/api/v1/Item")
public class ItemController {
	/**
	 * 自动装配（设置）
	 */
	@Autowired
	ItemMapper mapper;
	
	List list;
	
	@PostMapping()
	public Map<String, Object> create(@RequestBody Item item) {
		System.out.println(item);
		mapper.additem(item);
		Map<String, Object> msg = new HashMap<>();
		msg.put("msg", "ok");
		return msg;
	}
	
	@GetMapping
	public List<Item> page() {

		return mapper.list();

	}
	@PostMapping("/findname")
	public List  finname(@RequestBody HashMap<String, String> hash1) {
		String s=hash1.get("name");
		System.out.println(s);
		list=mapper.listname(s);
		System.out.println(list);
		return list;
		
	}
//	@GetMapping("/fname")
//	public List<Item> page1(){
//		return list;
//	}
}
