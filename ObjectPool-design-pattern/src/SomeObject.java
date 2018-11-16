import java.util.concurrent.atomic.AtomicInteger;

public class SomeObject {

	private static AtomicInteger counter = new AtomicInteger(0);

	private final int id;

	public SomeObject() {
		    id = counter.incrementAndGet();
		    try {
		      Thread.sleep(500);
		    } catch (InterruptedException e) {
		      e.printStackTrace();
		    }
		  }

	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return String.format("SomeObject id = " + id);
	}
}
