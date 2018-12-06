// The Person class has multiple clients, but all of the clients are in 
// one file for convenience.  Imagine them as non-test methods in separate 
// client classes.

import java.io.IOException;
import java.io.StringWriter;

import org.junit.Assert;
import org.junit.Test;

public class PersonClientsTest {

	@Test
	public void testClients() throws IOException {
		Person bobSmith = new Person("Smith", "Bob", null);
		Person jennyJJones = new Person("Jones", "Jenny", "J");

		StringWriter out = new StringWriter();
		Client1.printPerson(out, bobSmith);
		Assert.assertEquals("Bob Smith", out.toString());

		out = new StringWriter();
		Client1.printPerson(out, jennyJJones);
		Assert.assertEquals("Jenny J Jones", out.toString());

		Assert.assertEquals("Smith, Bob", Client2.formatPerson(bobSmith));
		Assert.assertEquals("Jones, Jenny J", Client2.formatPerson(jennyJJones));

		out = new StringWriter();
		Client3.display(out, bobSmith);
		Assert.assertEquals("Smith, Bob", out.toString());

		out = new StringWriter();
		Client3.display(out, jennyJJones);
		Assert.assertEquals("Jones, Jenny J", out.toString());

		Assert.assertEquals("Smith, Bob", Client4.toString(bobSmith));
		Assert.assertEquals("Jones, Jenny J", Client4.toString(jennyJJones));
	}
}
