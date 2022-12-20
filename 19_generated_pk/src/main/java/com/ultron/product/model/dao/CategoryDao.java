package com.ultron.product.model.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import com.ultron.product.model.dto.Category;

@Repository
public class CategoryDao {

	@Autowired
	private JdbcTemplate template;

	@Value("${dao.insert.category}")
	private String insert;
	@Value("${dao.update.category}")
	private String update;
	@Value("${dao.findById.category}")
	private String findById;
	@Value("${dao.findByName.category}")
	private String findByName;
	@Value("${dao.countByName.category}")
	private String findCountByName;
	@Value("${dao.delete.category}")
	private String deleteById;

	private RowMapper<Category> mapper;

	public CategoryDao() {
		mapper = new BeanPropertyRowMapper<Category>(Category.class);
	}

	public int createCategory(Category c) {

//		PreparedStatementCreatorFactory factory = new PreparedStatementCreatorFactory(sql, Types.VARCHAR);
//		factory.setReturnGeneratedKeys(true);
//		PreparedStatementCreator creator = factory.newPreparedStatementCreator(List.of(c.getName()));
//
//		PreparedStatementCallback<Integer> callBack = stm -> {
//			stm.executeUpdate();
//			var rs = stm.getGeneratedKeys();
//
//			while (rs.next()) {
//				return rs.getInt(1);
//			}
//			return 0;
//		};

//		 var keyHolder = new GeneratedKeyHolder();
//		 
//		  operation.update(creator, keyHolder);
//
//		return keyHolder.getKey().intValue();

		SimpleJdbcInsert insert = new SimpleJdbcInsert(template);
		insert.setTableName("categories");
		insert.setGeneratedKeyName("id");
		Map<String, Object> map = new HashMap<>();
		map.put("name", c.getName());

		return insert.executeAndReturnKey(map).intValue();
	}

	public int update(Category c) {
		var result = template.update(update, c.getName(),c.getId());
		return result;
	}

	public Category findByid(int id) {
		var result = template.queryForObject(findById, mapper, id);
		return result;
	}

	public Category findByName(String name) {
		var result = template.queryForObject(findByName, mapper, name);
		return result;
	}

	public List<Category> findByNameCount(String name) {
		List<Category> list = template.query(findCountByName, mapper, name);
		return list;
	}

	public int deleteById(int id) {
		var count = template.update(deleteById, id);
		return count;
	}

}
