package com.ultron.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.ultron.dto.Member;

@Repository
public class MemberDao {

	@Autowired
	private JdbcTemplate template;

	public MemberDao(JdbcTemplate template) {
		super();
		this.template = template;
	}

	public void create(Member member) {
		final String INSERT = "INSERT INTO members VALUES (?,?,?,?,?)";

		template.update(INSERT, member.getMemberId(), member.getPassword(), member.getName(), member.getPhone(),
				member.getEmail());
	}

}
