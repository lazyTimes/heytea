package com.example.quiz.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.quiz.Product;


@Mapper
public interface ProductMapper {
/**
 * 添加一个商品
 */
	@Insert("insert into product(name,price) values(#{name},#{price})")
	void addproduct(Product product);
	
	/**
	 * 查找商品
	 */
	@Select("select * from product")
	List<Product> list();
	
	
	
	
	@Delete("delete from product where name=#{name}")
	void delproduct(Product product);

	@Update("update product set name=#{drink},price=#{price} where name=#{rdrink}")
	void updata(String drink,String price,String  rdrink);
	
	
	

}
