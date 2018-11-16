package interfaces;
import java.util.HashSet;
import java.util.Set;

public abstract class ObjectPool<T> {

	private static int poolSize = 4;
	private Set<T> available = new HashSet<>();
	private Set<T> inUse = new HashSet<>();

	public abstract T create();
	
	public int getAvailableAmount() {
		return available.size();
	}
	public int getInUseAmount() {
		return inUse.size();
	}
	public synchronized boolean poolDoesntExceedSize() {
		return ((inUse.size() + 1) >= poolSize);
	}
	
	public void cleanPool() {
		available.clear();
		inUse.clear();
	}
	
	public synchronized T acquireReusable() {
		if(poolDoesntExceedSize()) {
			return null;
		}
		
		if (available.isEmpty()) {
			available.add(create());
		}
		T instance = available.iterator().next();
		available.remove(instance);
		inUse.add(instance);
		return instance;

	}

	public synchronized void releaseReusable(T instance) {
		inUse.remove(instance);
		available.add(instance);
	}
}