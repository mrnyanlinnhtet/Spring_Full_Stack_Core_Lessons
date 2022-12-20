package com.ultron.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementCreatorFactory;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.ultron.dao.member_row_mapper.MemberMapper;
import com.ultron.dto.Member;

@SpringJUnitConfig(locations = "/beans.xml")
@TestMethodOrder(OrderAnnotation.class)
public class PrepareStatementTest {

	@Autowired
	private JdbcOperations dbOperation;
	

	@Autowired
	private MemberMapper mapper;

	@Autowired
	@Qualifier("memberRowMapper")
	private RowMapper<Member> rowMapper;

//	@Test
//	@DisplayName("1. Properties Sql")
//	@Order(1)
//	@Sql(scripts = "/database.sql")
//	 void test1(@Value("${member.insert}") String sql) {
//		
//		var count =  dbOperation.execute((Connection con)->{
//			  var stm = con.prepareStatement(sql);
//			  stm.setString(1, "1002");
//			  stm.setString(2, "admin2");
//			  stm.setString(3, "root2");
//			  stm.setString(4, "098877665");
//			  stm.setString(5, "user2@gmail.com");
//			  
//			  return stm;
//		 }, PreparedStatement::executeUpdate);
//		 
//		assertEquals(1,count);
//	 }

	@Test
	@DisplayName("1. Insert process with execute")
	@Order(1)
	@Sql(scripts = "/database.sql")
	void test1(@Qualifier("memberInsert") PreparedStatementCreatorFactory factory) {
		PreparedStatementCreator creator = factory
				.newPreparedStatementCreator(List.of("1003", "admin3", "root3", "098877345", "admin3@gmail.com"));

		var count = dbOperation.execute(creator, PreparedStatement::executeUpdate);

		assertEquals(1, count);
	}

	@Test
	@DisplayName("2. Update Process with update")
	@Order(2)
	void test2(@Qualifier("memberInsert") PreparedStatementCreatorFactory factory) {

		PreparedStatementCreator creator = factory
				.newPreparedStatementCreator(List.of("1001", "admin1", "root1", "0988223478", "admin1@gmail.com"));

		var count = dbOperation.update(creator);

		assertEquals(1, count);
	}

	@Test
	@DisplayName("3. Select Process with execute")
	@Order(3)
	void test3(@Qualifier("memberSelectByName") PreparedStatementCreatorFactory factory) {

		PreparedStatementCreator creator = factory.newPreparedStatementCreator(List.of("root1"));

		List<Member> list = new ArrayList<>();
		dbOperation.execute(creator, ((PreparedStatement stm) -> {

			var rs = stm.executeQuery();

			while (rs.next()) {
				Member m = new Member();

				m.setMemberId(rs.getString(1));
				m.setPassword(rs.getString(2));
				m.setName(rs.getString(3));
				m.setPhone(rs.getString(4));
				m.setEmail(rs.getString(5));

				list.add(m);
			}
			return list;
		}));

		assertEquals(1, list.size());
	}

	@Test
	@DisplayName("4. Select Process with query")
	@Order(4)
	void test4(@Qualifier("memberSelectByName") PreparedStatementCreatorFactory factory) {

		var creator = factory.newPreparedStatementCreator(List.of("root1"));

		List<Member> result = dbOperation.query(creator, mapper);

		assertEquals(1, result.size());
	}

	@Test
	@DisplayName("5. Select Process With ResultSet Extractor")
	@Order(5)
	void test5(@Qualifier("memberSelectByPk") PreparedStatementCreatorFactory factory) {

		var creator = factory.newPreparedStatementCreator(List.of("1001"));
		ResultSetExtractor<Member> ex = (rs -> {

			while (rs.next()) {
				return mapper.mapRow(rs, 1);
			}

			return null;
		});

		var memberObj = dbOperation.query(creator, ex);

		assertNotNull(memberObj);
		assertEquals("root1", memberObj.getName());
	}

	@Test
	@DisplayName("6. Execute With Sample Sql String")
	@Order(6)
	@Sql(scripts = "/database.sql")
	void test6(@Value("${member.insert}") String sql) {

		var count = dbOperation.execute(sql, (PreparedStatement stm) -> {

			stm.setString(1, "1001");
			stm.setString(2, "admin1");
			stm.setString(3, "root1");
			stm.setString(4, "0988776522");
			stm.setString(5, "root1@gmail.com");
			return stm.executeUpdate();

		});

		assertEquals(1, count);
	}

	@Test
	@DisplayName("7. Update Sql With Parameter And It is convince Method")
	@Order(7)
	@Sql(scripts = "/database.sql")
	void test7(@Value("${member.insert}") String sql) {

		int count = dbOperation.update(sql, "1002", "admin2", "root2", "09444859894", "root2@gmail.com");
		assertEquals(1, count);
	}

	@Test
	@DisplayName("8. Query With PreparedStatementSetter")
	@Order(8)
	void test8(@Value("${member.select.by.name}") String sql) {

		var list = dbOperation.query(sql, stm -> stm.setString(1, "root2"), mapper);
		assertEquals(1, list.size());
	}

	@Test
	@DisplayName("9. Query With Parameter")
	@Order(9)
	void test9(@Value("${member.select.by.name}") String sql) {

		var list = dbOperation.query(sql, rowMapper, "root2");
		assertEquals(1, list.size());

	}

	@Test
	@DisplayName("10. Query With ResultSet Extractor")
	@Order(10)
	void test10(@Value("${member.select.by.pk}") String sql) {

		var member = dbOperation.query(sql, stm -> stm.setString(1, "1002"), rs -> {
			while (rs.next()) {
				return rowMapper.mapRow(rs, 1);
			}

			return null;
		});

		assertNotNull(member);
		assertEquals("1002", member.getMemberId());
	}

	@Test
	@DisplayName("11. Query With Convince Method")
	@Order(11)
	void test11(@Value("${member.select.by.pk}") String sql) {

		ResultSetExtractor<Member> extractor = (rs) -> {

			while (rs.next()) {
				return rowMapper.mapRow(rs, 1);
			}
			return null;
		};

		var member = dbOperation.query(sql, extractor, "1002");

		assertNotNull(member);
		assertEquals("root2", member.getName());

	}

	@Test
	@DisplayName("12. Query With Convince Method")
	@Order(12)
	void test12(@Value("${member.select.by.pk}") String sql) {

		var member = dbOperation.queryForObject(sql, rowMapper, "1002");

		assertNotNull(member);
		assertEquals("root2", member.getName());
	}
	
	
	@Test
	@DisplayName("13. Query With Convince Method")
	@Order(13)
	void test13() {
      final String SQL = "SELECT COUNT(*)FROM members WHERE memberId=?";
      
		 var count = dbOperation.queryForObject(SQL, Long.class,"1002");
		 
		 assertEquals(1,count);
	
	}

}
