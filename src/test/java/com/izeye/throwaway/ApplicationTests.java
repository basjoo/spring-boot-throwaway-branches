package com.izeye.throwaway;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Tests for {@link Application}.
 *
 * @author Johnny Lim
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class ApplicationTests {

	@Autowired
	private DataSource dataSource;

	@Test
	public void testDataSource() {
		assertThat(this.dataSource).isInstanceOf(org.apache.tomcat.jdbc.pool.DataSource.class);
		org.apache.tomcat.jdbc.pool.DataSource tomcatJdbcPoolDataSource =
				(org.apache.tomcat.jdbc.pool.DataSource) this.dataSource;
		assertThat(tomcatJdbcPoolDataSource.isTestOnBorrow()).isFalse();
	}

}