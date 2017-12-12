package kr.co.sample.security;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.userdetails.jdbc.JdbcDaoImpl;

public class CustomUserDetailsService extends JdbcDaoImpl {
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		String message = null;
		List<UserDetails> users = loadUsersByUsername(username);
		if (users.size() == 0) {
			message = username + "에 해당하는 정보가 존재하지 않습니다.";
			logger.debug(message);
			throw new UsernameNotFoundException(message);
		}
		UserDetails user = users.get(0);
		Set<GrantedAuthority> dbAuthsSet = new HashSet<GrantedAuthority>();
		if (getEnableAuthorities()) {
			dbAuthsSet.addAll(loadUserAuthorities(user.getUsername()));
		}
		if (getEnableGroups()) {
			dbAuthsSet.addAll(loadGroupAuthorities(user.getUsername()));
		}
		List<GrantedAuthority> dbAuths = new ArrayList<GrantedAuthority>(dbAuthsSet);
		addCustomAuthorities(user.getUsername(), dbAuths);
		if (dbAuths.size() == 0) {
			message = username + "에 부여된 권한이 없습니다. ";
			logger.debug(message);
			throw new UsernameNotFoundException(message);
		}
		((CustomUserDetails) user).setAuthorities(dbAuths);
		return user;
	}

	/*
	 * userByUsername 쿼리를 사용해 데이터베이스내의 사용자 정보를 조회하는 메소드
	 */
	@Override
	protected List<UserDetails> loadUsersByUsername(String username) {
		JdbcTemplate template = getJdbcTemplate();
		return template.query(getUsersByUsernameQuery(), new String[] { username }, new RowMapper<UserDetails>() {
			@Override
			public UserDetails mapRow(ResultSet rs, int rowNum) throws SQLException {
				CustomUserDetails userDetails = new CustomUserDetails();
				userDetails.setUser_id(rs.getString("USER_ID"));
				userDetails.setUser_name(rs.getString("USER_NAME"));
				userDetails.setPassword(rs.getString("PASSWORD"));
				userDetails.setEnabled(rs.getBoolean("ENABLED"));
				userDetails.setEmail(rs.getString("EMAIL"));
				userDetails.setReg_date(rs.getString("REG_DATE"));
				userDetails.setAuthorities(AuthorityUtils.NO_AUTHORITIES);
				return userDetails;
			}
		});
	}

	/*
	 * authoritiesByUsername 쿼리를 통해 사용자의 권한 정보를 조회하는 메소드
	 */
	@Override
	protected List<GrantedAuthority> loadUserAuthorities(String username) {
		JdbcTemplate template = getJdbcTemplate();
		return template.query(getAuthoritiesByUsernameQuery(), new String[] { username },
				new RowMapper<GrantedAuthority>() {
					@Override
					public GrantedAuthority mapRow(ResultSet rs, int rowNum) throws SQLException {
						String role = rs.getString("AUTHORITY");
						return new SimpleGrantedAuthority(role);
					}
				});
	}
}
