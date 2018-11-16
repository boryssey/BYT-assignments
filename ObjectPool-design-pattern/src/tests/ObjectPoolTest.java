
package tests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import Models.SomeObject;
import Models.SomeObjectPool;


public class ObjectPoolTest {
	SomeObjectPool pool;
	SomeObject someObject1;
	SomeObject someObject2;
	SomeObject someObject3;
	SomeObject someObject4;
	
	@Before
	public void before() {
		pool = SomeObjectPool.getInstance();
	}
	@After
	public void after() {
		pool.cleanPool(); 
	}
	
	@Test
	public void testAcquringOneReusable() {
		someObject1 = pool.acquireReusable();
		Assert.assertEquals(0, pool.getAvailableAmount());
		Assert.assertEquals(1, pool.getInUseAmount());
	}
	@Test
	public void testAcquirungTwoItems() {
		someObject2 = pool.acquireReusable();
		someObject3 = pool.acquireReusable();
		Assert.assertEquals(2, pool.getInUseAmount());
	}
	@Test
	public void testReleaseReusable() {
		someObject2 = pool.acquireReusable();
		Assert.assertEquals(0, pool.getAvailableAmount());
		Assert.assertEquals(1, pool.getInUseAmount());
		pool.releaseReusable(someObject2);
		Assert.assertEquals(1, pool.getAvailableAmount());
		Assert.assertEquals(0, pool.getInUseAmount());
	}

	@Test
	public void testExceedingPoolSize() {
		someObject1 = pool.acquireReusable();
		someObject2 = pool.acquireReusable();
		someObject3 = pool.acquireReusable();
		someObject4 = pool.acquireReusable();
		Assert.assertNull(someObject4);
	}
	
	@Test
	public void testReAcquireReusable() {
		someObject1 = pool.acquireReusable();
		pool.releaseReusable(someObject1);
		Assert.assertEquals(1, pool.getAvailableAmount());
		someObject2 = pool.acquireReusable();
		Assert.assertEquals(0, pool.getAvailableAmount());
		Assert.assertEquals(1, pool.getInUseAmount());
	}
}
