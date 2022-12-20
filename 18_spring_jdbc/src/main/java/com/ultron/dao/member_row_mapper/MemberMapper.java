package com.ultron.dao.member_row_mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ultron.dao.meta.RowMappers;
import com.ultron.dto.Member;

@RowMappers
public class MemberMapper implements RowMapper<Member> {

	@Override
	public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
		Member m = new Member();
		m.setMemberId(rs.getString(1));
		m.setPassword(rs.getString(2));
		m.setName(rs.getString(3));
		m.setPhone(rs.getString(4));
		m.setEmail(rs.getString(5));
		return m;
	}

}
