package com.itwill.guest.dao.jdbctemplate;

import java.sql.Types;
import java.util.List;
import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class SpringBootJdbcTemplateMain {

	public static void main(String[] args) throws Exception {
		ApplicationContext applicationContext = SpringApplication.run(SpringBootJdbcTemplateMain.class, args);
		JdbcTemplate jdbcTemplate = (JdbcTemplate) applicationContext.getBean(JdbcTemplate.class);
		System.out.println("A.JdbcTemplate:" + jdbcTemplate);
		System.out.println("B.JdbcTemplate DataSource:" + jdbcTemplate.getDataSource());
		System.out.println("C.JdbcTemplate DataSource Connection:" + jdbcTemplate.getDataSource().getConnection());

		System.out.println("1. JdbcTemplate객체얻기");
		/**********************************************************
		 * select --> queryForObject 반환타입[String,Wrapper,DTO]
		 **********************************************************/
		/*
		 * queryForObject[반환타입 DTO]
		 */
		String selectDtoSql = "select * from guest where guest_no=?";
		Object[] paramArray1 = { 263 };
		Object[] paramArray2 = new Object[] { 263 };

		/*
		 * <BeanPropertyRowMapper 클래스> resultset객체로부터 데이타를 컬럼이름으로 get해서 guest객체생성후
		 * 테이블컬럼이름과 동일한 이름의 guest객체의 set property호출
		 */

		BeanPropertyRowMapper<Guest> guestBeanPropertyRowMapper = new BeanPropertyRowMapper<Guest>(Guest.class);

//		Guest guest = jdbcTemplate.queryForObject(selectDtoSql, 
//				new Object[] { 200 }, 
//				new int[] { Types.INTEGER },
//				guestBeanPropertyRowMapper);
//		System.out.println("queryForObject[Guest]:" + guest);

		/*
		 * select --> query 반환타입[String,Wrapper]
		 */
		String selectStringSql = "select guest_name from guest where guest_no=?";
		String guest_name = jdbcTemplate.queryForObject(selectStringSql, 
				new Object[] { 244 },
				new int[] { Types.INTEGER },
				String.class);
		System.out.println(guest_name);

		/*
		 * query 반환타입[List<Guest>]
		 */
		
//		String selectStringListSql = "select guest_name from guest";
//		List<String> guest_nameList = jdbcTemplate.queryForList(selectStringListSql,String.class);
//		System.out.println(guest_nameList);
//		
		
		/*
		 * select > queryforMap 반환타입 > list  Map<String,Object>
		 */
		String selectMapSql = "select guest_no from guest where guest_no =?";
		Map rowMap = jdbcTemplate.queryForMap(selectMapSql, new Object[] {210}, new int[] {Types.INTEGER});
		System.out.println("rowmap ===="+rowMap);
		
		
		

		String selectMapListSql = "select * from guest ";
		List rowMapList = jdbcTemplate.queryForList(selectMapListSql);
		System.out.println(rowMapList);

		/*
		 * DML(update,delete,insert) --> update 반환타입[ rowCount(int) ]
		 */

//		String insertSql = "insert into guest values(guest_no_seq.nextval,?,sysdate,?,?,?,?)";
//		int rowCount = jdbcTemplate.update(insertSql,"김수미2","email",".com","양념게장","만들기");
//		System.out.println(rowCount);
//		String updateSql = "update guest set  guest_name=?, guest_email=?, guest_homepage=?, guest_title=?, guest_content=? where guest_no =?";
//		int rowCount = jdbcTemplate.update(updateSql,"김우미2","email","com","title","content",315);
//		System.out.println(rowCount);
//		String deleteSql = "delete from guest where guest_no=?";
//		int rowCount = jdbcTemplate.update(deleteSql,155);

	}

}