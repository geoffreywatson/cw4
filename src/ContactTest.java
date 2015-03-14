import static org.junit.Assert.*;

import java.util.Date;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public class ContactTest {
	
	private Contact c1;
	private Contact c2;
	private Contact c3;
	private Contact c4;
	private ContactManagerImpl cm;
	private FutureMeeting fm1;
	private FutureMeeting fm2;
	
	
@Before	
public void setUp(){
	c1 = new ContactImpl("Dave","new sales guy");
	c2 = new ContactImpl("Darren","Some good product ideas");
	c3 = new ContactImpl("Sharon","Great network, must get to know better");
	c4 = new ContactImpl("Stuart","Knows about finance and company structures");
	cm = new ContactManagerImpl();
	
	
}

@After
public void cleanUp(){
	ContactImpl.resetNextId();
}

	
@Test
public void testGetContactID(){
	int output = c1.getId();
	int expected = 0;
	assertEquals(expected,output);
	output = c2.getId();
	expected = 1;
	assertEquals(expected,output);
}

@Test
public void testGetNotes(){
	c1.addNotes("additional note");
	String output = c1.getNotes();
	String expected = "new sales guy ; additional note";
	assertEquals(output,expected);
}

@Test
public void testGetName(){
	String output = c1.getName();
	String expected = "Dave";
	assertEquals(output,expected);
}

@Test
public void testaddFutureMeeting(){
	Set<Contact> contacts = new HashSet<Contact>();
	contacts.add(c1);
	contacts.add(c2);
	Calendar cal = Calendar.getInstance();
	cal.add(Calendar.MILLISECOND,1);
	int output = cm.addFutureMeeting(contacts, cal);
	int expected = 100;
	assertEquals(output,expected);
}

@Test
public void testGetMeetingId(){
	Set<Contact> contacts = new HashSet<Contact>();
	contacts.add(c1);
	contacts.add(c2);
	Calendar cal = Calendar.getInstance();
	cal.add(Calendar.MILLISECOND, 1);
	FutureMeeting fm = new FutureMeetingImpl(contacts,cal);
	int output = fm.getId();
	int expected = 100;
	assertEquals(output,expected);
	String notes = "test notes";
	PastMeeting pm = new PastMeetingImpl(contacts,cal,notes);
	output = pm.getId();
	expected = 200;
	assertEquals(output,expected);
	
}

@Test 
public void testaddNewPastMeeting(){
	Set<Contact> contacts = new HashSet<Contact>();
	contacts.add(c1);
	contacts.add(c2);
	Calendar cal = Calendar.getInstance();
	cal.add(Calendar.MILLISECOND,1);
	String notes = "test notes";
	cm.addNewPastMeeting(contacts, cal, notes );
	
}

@Test
public void testGetPastMeeting(){
	PastMeeting meeting = cm.getPastMeeting(200);
	Calendar cal = meeting.getDate();
	Date date = cal.getTime();
	System.out.println(date);	
}

@Test
public void testAddNotes(){
	
	
}


@Test
public void testGetFutureMeetingId(){
	
	
	
}
	
@Test
public void testGetMeeting(){
	Calendar cal = Calendar.getInstance();
	cal.add(Calendar.MILLISECOND,10);
	Set<Contact> contacts = new HashSet<Contact>();
	contacts.add(c1);
	contacts.add(c2);
	int expected = cm.addFutureMeeting(contacts, cal);
	int output = cm.getMeeting(100).getId();
	System.out.print("int output ="+  cm.getMeeting(100).getId());
	//int expected = 100;
	assertEquals(output,expected);
	
}
	
	
	
	
	
}
