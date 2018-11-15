
public class SomeObjectPool extends ObjectPool<SomeObject>{
	private static SomeObjectPool instance;
	private SomeObjectPool() {
		
	}
	public static SomeObjectPool getInstance() {
		if(instance == null ) {
			instance = new SomeObjectPool();
		}
		return instance;
	}
	@Override
	public SomeObject create() {
		return new SomeObject();
	}
	
}
