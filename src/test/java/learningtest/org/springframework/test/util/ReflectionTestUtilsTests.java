package learningtest.org.springframework.test.util;

import org.junit.Test;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.concurrent.atomic.AtomicBoolean;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Created by izeye on 15. 10. 2..
 */
public class ReflectionTestUtilsTests {
	
	@Test
	public void testGetField() {
		AtomicBoolean created = (AtomicBoolean) ReflectionTestUtils.getField(
				ApplicationPidFileWriter.class, "created");
		assertThat(created.get(), is(ApplicationPidFileWriter.isCreated()));
		
		created.set(true);
		assertThat(created.get(), is(ApplicationPidFileWriter.isCreated()));
	}
	
	static class ApplicationPidFileWriter {

		private static final AtomicBoolean created = new AtomicBoolean(false);
		
		public static boolean isCreated() {
			return created.get();
		}
		
	}
	
}
