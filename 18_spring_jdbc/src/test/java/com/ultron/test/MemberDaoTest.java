package com.ultron.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.Connection;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.ultron.dao.MemberDao;
import com.ultron.dto.Member;

@TestMethodOrder(OrderAnnotation.class)
@SpringJUnitConfig(locations = "/beans.xml")
public class MemberDaoTest {

	@Autowired
	private MemberDao memberDao;

	@Autowired
	private JdbcOperations dbOperation;

	@Test
	@Order(1)
	@Sql(scripts = "/database.sql")
	void createTest() {

		Member m = new Member();
		m.setMemberId("1001");
		m.setName("root");
		m.setPassword("admin");

		memberDao.create(m);

	}

	@Test
	@Order(2)
	void testUsingConnection() {

		var data = dbOperation.execute((Connection con) -> {

			var stm = con.createStatement();
			var rs = stm.executeQuery("SELECT COUNT(*) FROM members");

			while (rs.next()) {
				return rs.getLong(1);
			}

			return 0;
		});

		assertEquals(1L, data);
	}

	@Test
	@Order(3)
	void testUsingStatement() {

		var data = dbOperation.execute((Statement stm) -> {
			final String INSERT = """
					INSERT INTO members (memberId,password,name)VALUES('1002','admin2','root2')
					""";
			return stm.executeUpdate(INSERT);
		});

		assertEquals(1, data);

	}

	@Test
	@Order(4)
	void testUsingResultSetExtractor() {

		var data = dbOperation.query("SELECT COUNT(*) FROM members", rs -> {

			while (rs.next()) {
				return rs.getInt(1);
			}

			return 0;
		});

		assertEquals(2, data);

		var list = dbOperation.query("SELECT * FROM members", rs -> {

			List<Member> member = new ArrayList<>();

			while (rs.next()) {
				Member m = new Member();
				m.setMemberId(rs.getString("memberId"));
				m.setPassword(rs.getString("password"));
				m.setName(rs.getString("name"));
				m.setPhone(rs.getString("phone"));
				m.setEmail(rs.getString("email"));
				member.add(m);
			}

			return member;

		});

		assertEquals(2, list.size());
	}

	@Test
	@Order(5)
	void testRowCallbackHandler() {
		List<Member> member = new ArrayList<Member>();

		dbOperation.query("SELECT * FROM members", rs -> {

			Member m = new Member();
			m.setMemberId(rs.getString("memberId"));
			m.setPassword(rs.getString("password"));
			m.setName(rs.getString("name"));
			m.setPhone(rs.getString("phone"));
			m.setEmail(rs.getString("email"));
			member.add(m);
		});

		assertEquals(2, member.size());
	}

	@Test
	@Order(6)
	void testRowMapper() {

		var list = dbOperation.query("SELECT * FROM members", (rs, count) -> {

			List<Member> member = new ArrayList<>();

			Member m = new Member();
			m.setMemberId(rs.getString("memberId"));
			m.setPassword(rs.getString("password"));
			m.setName(rs.getString("name"));
			m.setPhone(rs.getString("phone"));
			m.setEmail(rs.getString("email"));
			member.add(m);

			return member;
		});

		assertEquals(2, list.size());

	}

	@Test
	@Order(7)
	void testOneRowOneColumnResult() {

		var admin = dbOperation.queryForObject("SELECT password FROM members WHERE memberId = '1001'",
				String.class);
		
		   assertEquals("admin", admin);

	}

}
