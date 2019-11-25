package com.example.quiz.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.example.quiz.Custom;
import com.example.quiz.Item;
import com.example.quiz.Product;

@Mapper
public interface ItemMapper {
	/**
	 * 添加会员				
	 */
	@Insert("insert into item(drink,size,suger,ice,dosing,price,time) "
			+ "values(#{drink},#{size},#{suger},#{ice},#{dosing},#{price},now())")
	void additem(Item item);

	/**
	 * 查询订单
	 * @return
	 */
	@Select("select * from item order by time desc")
	List<Item> list();
	
	@Select("select * from item where drink=#{name}")
	List<Item> listname(String name);
}
