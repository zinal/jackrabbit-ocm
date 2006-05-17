/* ========================================================================
 * Copyright 2004 The Apache Software Foundation
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * ========================================================================
 */
package org.apache.portals.graffito.jcr.persistence.impl;

import org.apache.portals.graffito.jcr.RepositoryLifecycleTestSetup;

import junit.framework.Test;
import junit.framework.TestSuite;


/**
 * Package level tests.
 * 
 * @author <a href='mailto:the_mindstorm[at]evolva[dot]ro'>Alexandru Popescu</a>
 */
public class AllTests {

    public static Test suite() {
        return new RepositoryLifecycleTestSetup(buildSuite());
    }

    public static Test buildSuite() {
        TestSuite suite= new TestSuite("Test for org.apache.portals.graffito.jcr.persistence.impl");
        //$JUnit-BEGIN$
        suite.addTestSuite(PersistenceManagerAtomicQueryTest.class);
        suite.addTestSuite(PersistenceManagerBasicVersionningTest.class);
        suite.addTestSuite(PersistenceManagerInheritanceConcreteClassTest.class);
        suite.addTestSuite(PersistenceManagerInheritanceHierarchyTest.class);
        suite.addTestSuite(PersistenceManagerInterfaceConcreteClassTest.class);
        suite.addTestSuite(PersistenceManagerQueryInheritanceConcreteClassTest.class);
        suite.addTestSuite(PersistenceManagerInterfaceHierarchyTest.class);        
        suite.addTestSuite(PersistenceManagerIteratorQueryTest.class);
        suite.addTestSuite(PersistenceManagerMultiValueQueryTest.class);       
        suite.addTestSuite(PersistenceManagerRemoveTest.class);
        suite.addTestSuite(PersistenceManagerSameNameSiblingTest.class);
        suite.addTestSuite(PersistenceManagerScopeQueryTest.class);
        suite.addTestSuite(PersistenceManagerSimpleQueryTest.class);      
        suite.addTestSuite(PersistenceManagerTest.class);
        
        //$JUnit-END$

        return suite;
    }
}
