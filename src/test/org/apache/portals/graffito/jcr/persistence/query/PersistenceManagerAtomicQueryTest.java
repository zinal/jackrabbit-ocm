/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.portals.graffito.jcr.persistence.query;

import java.io.ByteArrayInputStream;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;

import junit.framework.Test;
import junit.framework.TestSuite;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.portals.graffito.jcr.RepositoryLifecycleTestSetup;
import org.apache.portals.graffito.jcr.TestBase;
import org.apache.portals.graffito.jcr.persistence.PersistenceManager;
import org.apache.portals.graffito.jcr.query.Filter;
import org.apache.portals.graffito.jcr.query.Query;
import org.apache.portals.graffito.jcr.query.QueryManager;
import org.apache.portals.graffito.jcr.testmodel.Atomic;

/**
 * Test Query on atomic fields
 *
 * @author <a href="mailto:christophe.lombart@sword-technologies.com">Christophe Lombart</a>
 */
public class PersistenceManagerAtomicQueryTest extends TestBase
{
	private final static Log log = LogFactory.getLog(PersistenceManagerAtomicQueryTest.class);
	private Date date = new Date();
	
	/**
	 * <p>Defines the test case name for junit.</p>
	 * @param testName The test case name.
	 */
	public PersistenceManagerAtomicQueryTest(String testName) throws Exception
	{
		super(testName);
		
	}

	public static Test suite()
	{
		// All methods starting with "test" will be executed in the test suite.
		return new RepositoryLifecycleTestSetup(new TestSuite(PersistenceManagerAtomicQueryTest.class));
	}
	
    
    public void tearDown() throws Exception
    {

		for (int i = 1; i <= 100; i++)
		{
			if (getPersistenceManager().objectExists("/test" + i))
			{
				getPersistenceManager().remove("/test" + i);
			}

		}
        getPersistenceManager().save();
        super.tearDown();
    }	
	

	public void testQueryAtomicFields()
	{

		try
		{
			
			this.importData(date);
			PersistenceManager persistenceManager = this.getPersistenceManager();
			
			// Test Boolean value 
			QueryManager queryManager = this.getQueryManager();
			Filter filter = queryManager.createFilter(Atomic.class);
			filter.addEqualTo("booleanObject", new Boolean(true));
			Query query = queryManager.createQuery(filter);
			
			long start = System.currentTimeMillis();
			Collection result = persistenceManager.getObjects(query);
			System.out.println("getObjects  : " + (System.currentTimeMillis() - start));
			
			assertTrue("Invalid number of objects - should be = 50", result.size() == 50);
			
			filter = queryManager.createFilter(Atomic.class);
			filter.addEqualTo("booleanPrimitive", new Boolean(false));
			query = queryManager.createQuery(filter);

			start = System.currentTimeMillis();
			result = persistenceManager.getObjects(query);
			System.out.println("getObjects 2 : " + (System.currentTimeMillis() - start));
			assertTrue("Invalid number of objects - should be = 0", result.size() == 0);
			
			
			// Test int value
			filter = queryManager.createFilter(Atomic.class);
			filter.addBetween("integerObject", new Integer(0), new Integer(500));
			query = queryManager.createQuery(filter);
			
			result = persistenceManager.getObjects(query);			
			assertTrue("Invalid number of objects - should be = 5", result.size() == 5);
			
			filter = queryManager.createFilter(Atomic.class);
			filter.addLessOrEqualThan("intPrimitive", new Integer(236));
			query = queryManager.createQuery(filter);
			
			result = persistenceManager.getObjects(query);			
			assertTrue("Invalid number of objects - should be = 36", result.size() == 36);

			
			//Test Date & Calendar
			filter = queryManager.createFilter(Atomic.class);
			Calendar calendar = Calendar.getInstance();
			calendar.set(2012, 12, 01);
			filter.addLessThan("calendar", calendar);
			query = queryManager.createQuery(filter);
			
			result = persistenceManager.getObjects(query);			
			assertTrue("Invalid number of objects - should be = 100 ", result.size() == 100);

			filter = queryManager.createFilter(Atomic.class);
			calendar = Calendar.getInstance();
			calendar.set(1975, 12, 01);
			filter.addLessThan("calendar", calendar);
			query = queryManager.createQuery(filter);
			
			result = persistenceManager.getObjects(query);			
			assertTrue("Invalid number of objects - should be = 0 ", result.size() == 0);
			
			filter = queryManager.createFilter(Atomic.class);			
			filter.addEqualTo("date", date);
			query = queryManager.createQuery(filter);
			
			result = persistenceManager.getObjects(query);			
			assertTrue("Invalid number of objects - should be = 100 ", result.size() == 100);

			filter = queryManager.createFilter(Atomic.class);			
			filter.addBetween("date", date, new Date());
			query = queryManager.createQuery(filter);
			
			result = persistenceManager.getObjects(query);			
			assertTrue("Invalid number of objects - should be = 100 ", result.size() == 100);
			
			// Test contains method
			filter = queryManager.createFilter(Atomic.class);			
			filter.addContains(".", "JCR");
			query = queryManager.createQuery(filter);
			
			result = persistenceManager.getObjects(query);			
			assertTrue("Invalid number of objects - should be = 50 ", result.size() == 50);
			
			filter = queryManager.createFilter(Atomic.class);			
			filter.addContains("byteArray", "Graffito");
			query = queryManager.createQuery(filter);
			
			result = persistenceManager.getObjects(query);			
			assertTrue("Invalid number of objects - should be = 50 ", result.size() == 50);
			
			filter = queryManager.createFilter(Atomic.class);			
			filter.addContains("byteArray", "String");
			query = queryManager.createQuery(filter);
			
			result = persistenceManager.getObjects(query);			
			assertTrue("Invalid number of objects - should be = 0 ", result.size() == 0);


			
		}
		catch (Exception e)
		{
			 e.printStackTrace();
             fail();
		}

	}

	private void importData(Date date)
	{
		try
		{

			PersistenceManager persistenceManager = getPersistenceManager();
			
			for (int i = 1; i <= 100; i++)
			{
				Atomic a = new Atomic();
				a.setPath("/test" + i);
				a.setBooleanObject(new Boolean(i%2==0));
				a.setBooleanPrimitive(true);
				a.setIntegerObject(new Integer(100 * i));
				a.setIntPrimitive(200 + i);
				a.setString("Test String " + i);
				a.setDate(date);
				Calendar calendar = Calendar.getInstance();
				calendar.set(1976, 4, 20, 15, 40);
				a.setCalendar(calendar);
				a.setDoubleObject(new Double(2.12 + i));
				a.setDoublePrimitive(1.23 + i);
				long now = System.currentTimeMillis();
				a.setTimestamp(new Timestamp(now));
				if ((i % 2) == 0)
				{
				     a.setByteArray("This is small object stored in a JCR repository".getBytes());
				     a.setInputStream(new ByteArrayInputStream("Test inputstream".getBytes()));
				}
				else
				{
					 a.setByteArray("This is small object stored in a Graffito repository".getBytes());
					 a.setInputStream(new ByteArrayInputStream("Another Stream".getBytes()));
				}
				persistenceManager.insert(a);
				
				
			}
			persistenceManager.save();

		}
		catch (Exception e)
		{
			e.printStackTrace();
			fail("Exception occurs during the unit test : " + e);
		}

	}
	
}