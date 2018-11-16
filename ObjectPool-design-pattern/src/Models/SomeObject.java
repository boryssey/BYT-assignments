package Models;

import java.util.concurrent.atomic.AtomicInteger;

public class SomeObject {

	private static AtomicInteger counter = new AtomicInteger(0);

	private final int id;

	public SomeObject() {

		id = counter.incrementAndGet();

	}
}
