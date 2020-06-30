package learningtest.org.springframework.core;

import org.springframework.core.ResolvableType;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Tests for {@link ResolvableType}.
 *
 * @author Johnny Lim
 */
class ResolvableTypeTests {

	@Test
	void test() {
		assertThat(new StringClass().getType()).isEqualTo(String.class);
	}

	private static abstract class GenericClass<T> {

		private final Class<T> type;

		@SuppressWarnings("unchecked")
		GenericClass() {
			this.type = (Class<T>) ResolvableType
					.forClass(GenericClass.class, getClass()).resolveGeneric();
		}

		public Class<T> getType() {
			return this.type;
		}

	}

	private static class StringClass extends GenericClass<String> {
	}

}
