package com.ultron.product.model.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

import com.ultron.product.model.dto.Category;
import com.ultron.product.model.dto.Product;

@Repository
public class ProductDao {

	private BeanPropertyRowMapper<ProductDto> rowMapper;

	public ProductDao() {
		rowMapper = new BeanPropertyRowMapper<ProductDto>(ProductDto.class);
	}

	@Autowired
	private NamedParameterJdbcOperations jdbc;

	@Value("${dao.insert.product}")
	private String insert;

	@Value("${dao.findById.product}")
	private String findById;
	
	@Value("${dao.findByCategory.product}")
	private String findByCategory;
	
	@Value("${dao.updateById.product}")
	private String updateById;
	
	@Value("${dao.deleteById.product}")
	private String deleteById;
	
	@Value("${dao.search.product}")
	private String search;

	public int createProduct(Product p) {

		var key = new GeneratedKeyHolder();

		var params = new MapSqlParameterSource();
		params.addValue("categoryId", p.getCategory().getId());
		params.addValue("name", p.getName());
		params.addValue("price", p.getPrice());

		jdbc.update(insert, params, key);

		return key.getKey().intValue();
	}

	public Product findById(int id) {

		 var params = new MapSqlParameterSource();
		 params.addValue("id", id);

		Product result = jdbc.queryForStream(findById, params, rowMapper).findFirst().orElseGet(() -> null);
		return result;
	}

	public List<Product> findByCategory(int categoryId) {
		
		var params = new MapSqlParameterSource();
		params.addValue("id", categoryId);
		
		return jdbc.queryForStream(findByCategory, params, rowMapper).map(ProductDto::toProduct).toList();
		
	}

	public List<Product> search(String keyword) {
		
		 var params = new MapSqlParameterSource();
		 params.addValue("keyword", keyword);
		 
		 var result = jdbc.queryForStream(search, params, rowMapper).map(ProductDto::toProduct).toList();
		return result;
	}

	public int update(Product product) {
		
		 var params = new MapSqlParameterSource();
		 params.addValue("name", product.getName());
		 params.addValue("price", product.getPrice());
		 params.addValue("id", product.getId());
		 
		  var count = jdbc.update(updateById, params);
		return count;
	}

	public int delete(int id) {
		var params = new MapSqlParameterSource();
		params.addValue("id", id);
		
		 var result = jdbc.update(deleteById, params);
		return result;
	}
	
	
	//ProductDto
	public static class ProductDto extends Product{
		
		public void setCategoryId(int id) {

			if (getCategory() == null) {
				 setCategory(new Category());
			}
			  getCategory().setId(id);

		}
		
		public void setCategoryName(String name) {
			if(getCategory() == null) {
				setCategory(new Category());
			}
			
			getCategory().setName(name);
		
		}
		
		public Product toProduct() {
			return this;
		}
	}

}
