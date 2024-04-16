package curdoperationjdbc.empdao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import curdoperationjdbc.empmodel.Empolyee;
@Repository
public class EmpDao implements EmpDaoInterface{
	
	private NamedParameterJdbcOperations namedParameterJdbcOperations;
	
	@Autowired
	public EmpDao(DataSource dataSource) {

		namedParameterJdbcOperations = new NamedParameterJdbcTemplate(dataSource);
	}
	
	@Override
	public List<Empolyee> addemp(Empolyee emp) {
		MapSqlParameterSource param=getEmpParamMap(emp);
	System.out.println("param"+param);
		KeyHolder keyHolder = new GeneratedKeyHolder();
		String []empidgenrated = null;
		// emp (empid,empolyeName,empolyeeSalary,empolyeeAddress) this must be present under DB
		String sql="insert into emp (empid,empolyeName,empolyeeSalary,empolyeeAddress)VALUES(:empid,:empolyeName,:empolyeeSalary,:empolyeeAddress)";
		int no=0;
		try {
		no=namedParameterJdbcOperations.update(sql, param);
	}catch(Exception e) {
		e.printStackTrace();
	}
		if(no>0) {
			System.out.println("row are added no="+no);
		}else {
			System.out.println("row are not effected");
		}
		return getall();
	}
public MapSqlParameterSource getEmpParamMap(Empolyee emp)
{
	MapSqlParameterSource paramSource = new MapSqlParameterSource();
	paramSource.addValue("empid",emp.getEmpid());
	paramSource.addValue("empolyeName",emp.getEmpolyeName());
	paramSource.addValue("empolyeeSalary",emp.getEmpolyeeSalary());
	paramSource.addValue("empolyeeAddress",emp.getEmpolyeeAddress());
	return paramSource;	
	
}


@Override
public List<Empolyee> update(Empolyee emp){
	String sql="update emp set empid=:empid,empolyeName=:empolyeName,empolyeeSalary=:empolyeeSalary,empolyeeAddress=:empolyeeAddress";
	
	MapSqlParameterSource param=getEmpParamMap(emp);
	int a=namedParameterJdbcOperations.update(sql,param);
if(a>0) {
	System.out.println("Updated record is ="+a);
}
	return getall();
}

public List<Empolyee> getall(){
	String sql="select * from emp";
	MapSqlParameterSource param=new MapSqlParameterSource();
	List<Empolyee> emplist=	namedParameterJdbcOperations.query(sql,param,new ResultSetExtractor<List<Empolyee>>() {

		@Override
		public List<Empolyee> extractData(ResultSet rs) throws SQLException, DataAccessException {
			List<Empolyee> list=new ArrayList<>();
			while(rs.next()) {
				Empolyee ob=new Empolyee();
				ob.setEmpid(rs.getInt("empid"));
				ob.setEmpolyeeAddress(rs.getString("empolyeeAddress"));
				ob.setEmpolyeeSalary(rs.getDouble("empolyeeSalary"));
				ob.setEmpolyeName(rs.getString("empolyeName"));
				list.add(ob);
			}
			
			
			return list;
		}
		
		
	});
	System.out.println("list ="+emplist);
	return emplist;
	
}
	
}
