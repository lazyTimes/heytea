package com.example.quiz.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.quiz.Custom;
import com.example.quiz.Product;
import com.example.quiz.mapper.ProductMapper;

@RestController
@RequestMapping("/api/v1/Product")

public class ProductController {

	/**
	 * 自动装配（设置）
	 */
	@Autowired
	ProductMapper mapper;

	/**
	 * 往数据库中添加商品
	 * 
	 * @return
	 */
	@PostMapping()
	public Map<String, Object> createproduct(@RequestBody Product product) {
		System.out.println(product);
		mapper.addproduct(product);
		Map<String, Object> msg = new HashMap<>();
		msg.put("msg", "ok");
		return msg;
	}

	/*
	 * 获取数据库中数据
	 */
	@GetMapping
	public List<Product> page() {
		return mapper.list();
	}
	/**
	 * 删除数据库中的数据
	 */
	@PostMapping("/delproduct")
	public Map<String, Object> delproduct(@RequestBody Product product) {
		System.out.println(product);
		mapper.delproduct(product);
		Map<String, Object> msg = new HashMap<>();
		msg.put("msg", "ok");
		return msg;
	}
	
	@PostMapping("/updata")
	public Map<String, Object> updataproduct(@RequestBody HashMap<String, String> hash) {
		String s=hash.get("rdrink");
		String s1=hash.get("drink");
		String s2=hash.get("price");
		
		System.out.println(s+"---"+s1+"---"+s2);
		mapper.updata(s1,s2,s);
		Map<String, Object> msg = new HashMap<>();
		msg.put("msg", "ok");
		return msg;
	}
	
	
	
}
