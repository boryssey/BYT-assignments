
public class Main {
	public static void main(String[] args) {
		SomeObjectPool pool = SomeObjectPool.getInstance();
		System.out.println(pool.toString());
		SomeObject SomeObject1 = pool.acquireReusable();
		System.out.println("Checked out " + SomeObject1);
		System.out.println(pool.toString());
		SomeObject SomeObject2 = pool.acquireReusable();
		System.out.println("Checked out " + SomeObject2);
		SomeObject SomeObject3 = pool.acquireReusable();
		System.out.println("Checked out " + SomeObject3);
		System.out.println(pool.toString());
		System.out.println("releaseReusableg in " + SomeObject1);
		pool.releaseReusable(SomeObject1);
		System.out.println("releaseReusableg in " + SomeObject2);
		pool.releaseReusable(SomeObject2);
		System.out.println(pool.toString());
		SomeObject SomeObject4 = pool.acquireReusable();
		System.out.println("Checked out " + SomeObject4);
		SomeObject SomeObject5 = pool.acquireReusable();
		System.out.println("Checked out " + SomeObject5);
		System.out.println(pool.toString());

	}
}
