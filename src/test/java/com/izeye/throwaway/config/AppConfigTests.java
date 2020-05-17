package com.izeye.throwaway.config;

import java.util.Objects;

import com.izeye.throwaway.service.DefaultPersonServiceConsumer;
import com.izeye.throwaway.service.PersonServiceConsumer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by izeye on 16. 4. 4..
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class AppConfigTests {
	
	@Autowired
	PersonServiceConsumer personServiceConsumer;

	@Autowired
	ApplicationContext context;
	
	@Test
	public void test() {
		assertThat(((DefaultPersonServiceConsumer) personServiceConsumer).getPersonService())
				.isNotNull();
	}

	@Test
	public void testNullBean() {
		Object nullBean = this.context.getBean("nullBean");

		assertThat(nullBean == null).isFalse();
		assertThat(nullBean.equals(null)).isTrue();
		assertThat(Objects.equals(nullBean, null)).isTrue();
		assertThat(Objects.deepEquals(nullBean, null)).isFalse();

		assertThat(nullBean).isNotNull();

		// AssertJ's isEqualTo() has been changed somewhere between 3.15.0 and 3.16.1.
		// 3.15.0 uses java.util.Objects.equals(), but 3.16.1 uses java.util.Objects.deepEquals().
		// I'm not sure if this is intentional, but it's diverged with Object.equals() anyway.
//		assertThat(nullBean).isEqualTo(null);
		assertThat(nullBean).isNotEqualTo(null);
	}
	
}
