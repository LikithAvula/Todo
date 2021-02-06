package com.taskManager.Todo.Dao.Impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.taskManager.Todo.Dao.UserDao;
import com.taskManager.Todo.entitiy.User;

@Repository("userDao")
public class UserDaoImpl extends JdbcDaoSupportImpl implements UserDao {

	@Override
	public User getUserDetails(String userName) {
		List<User> list = getJdbcTemplate().query("select * from user where username = ?", new String[] { userName },
				rowMapper);
		return list.get(0);

	}

	@Override
	public void createAccount(User user) {
		getJdbcTemplate().update("insert into user values (?,?,?,?)", user.getUserName(), user.getPassword(),
				user.getDateOfBirth(), user.getRole());
	}

	@Override
	public void deleteAccount(User user) {
		// TODO Auto-generated method stub

	}

	RowMapper<User> rowMapper = new RowMapper<User>() {
		@Override
		public User mapRow(ResultSet rs, int rowNum) throws SQLException {
			User user = new User();
			user.setUserName(rs.getString("username"));
			user.setPassword(rs.getString("password"));
			user.setDateOfBirth(rs.getDate("dateOfBirth"));
			user.setRole(rs.getString("userRole"));
			return user;
		}

	};

	@Override
	public void editAccount(User user) {
		getJdbcTemplate().update("update user set  password=? where username = ?", user.getPassword(), user.getUserName());
		
	}
}
