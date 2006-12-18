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
package org.apache.portals.graffito.jcr.persistence.beanconverter;

import java.util.ArrayList;
import java.util.List;

import javax.jcr.Node;
import javax.jcr.Session;

import org.apache.portals.graffito.jcr.exception.JcrMappingException;
import org.apache.portals.graffito.jcr.exception.PersistenceException;
import org.apache.portals.graffito.jcr.exception.RepositoryException;

import org.apache.portals.graffito.jcr.mapper.Mapper;
import org.apache.portals.graffito.jcr.mapper.model.BeanDescriptor;
import org.apache.portals.graffito.jcr.mapper.model.ClassDescriptor;
import org.apache.portals.graffito.jcr.persistence.atomictypeconverter.AtomicTypeConverterProvider;
import org.apache.portals.graffito.jcr.persistence.beanconverter.impl.AbstractBeanConverterImpl;
import org.apache.portals.graffito.jcr.persistence.objectconverter.ObjectConverter;
import org.apache.portals.graffito.jcr.testmodel.B;

public class FakeBeanConverter extends AbstractBeanConverterImpl implements BeanConverter {

    private static  List log = new ArrayList();
    
    public FakeBeanConverter(Mapper mapper, ObjectConverter objectConverter, AtomicTypeConverterProvider atomicTypeConverterProvider) {
		super(mapper, objectConverter, atomicTypeConverterProvider);
		 
		 
	}

	public static List getLog() {
        return log;
    }
        
    /**
     * @see org.apache.portals.graffito.jcr.persistence.beanconverter.BeanConverter#insert(javax.jcr.Session, javax.jcr.Node, org.apache.portals.graffito.jcr.mapper.Mapper, java.lang.String, java.lang.Object)
     */
	public void insert(Session session, Node parentNode, BeanDescriptor beanDescriptor, ClassDescriptor beanClassDescriptor, Object object, ClassDescriptor parentClassDescriptor, Object parent)
	throws PersistenceException, RepositoryException, 	JcrMappingException {
        try {
            log.add("insert at path " + parentNode.getPath());
            
        }
        catch(javax.jcr.RepositoryException re) {
            throw new PersistenceException(re);
        }
    } 

    /**
     * @see org.apache.portals.graffito.jcr.persistence.beanconverter.BeanConverter#update(javax.jcr.Session, javax.jcr.Node, org.apache.portals.graffito.jcr.mapper.Mapper, java.lang.String, java.lang.Object)
     */
	public void update(Session session, Node parentNode, BeanDescriptor beanDescriptor, ClassDescriptor beanClassDescriptor, Object object, ClassDescriptor parentClassDescriptor, Object parent)
	throws PersistenceException, RepositoryException,	JcrMappingException {
        try {
            log.add("update at path " + parentNode.getPath());
        }
        catch(javax.jcr.RepositoryException re) {
            throw new PersistenceException(re);
        }
    }

    /**
     * @see org.apache.portals.graffito.jcr.persistence.beanconverter.BeanConverter#getObject(javax.jcr.Session, javax.jcr.Node, org.apache.portals.graffito.jcr.mapper.Mapper, java.lang.String, java.lang.Class)
     */
    public Object getObject(Session session, Node parentNode, BeanDescriptor beanDescriptor, ClassDescriptor beanClassDescriptor, Class beanClass, Object parent)
	throws PersistenceException, RepositoryException,JcrMappingException {
        try {
            log.add("get from path " + parentNode.getPath());
        }
        catch(javax.jcr.RepositoryException re) {
            throw new PersistenceException(re);
        }
        // The B object is not important for the unit test. 
        // The unit test checks only the log generated by this converter
        return new B(); 
    }

    /**
     * @see org.apache.portals.graffito.jcr.persistence.beanconverter.BeanConverter#remove(javax.jcr.Session, javax.jcr.Node, org.apache.portals.graffito.jcr.mapper.Mapper, java.lang.String)
     */
	public void remove(Session session, Node parentNode, BeanDescriptor beanDescriptor, ClassDescriptor beanClassDescriptor, Object object, ClassDescriptor parentClassDescriptor, Object parent)
    throws PersistenceException,	RepositoryException, JcrMappingException {

        try {
            log.add("remove from path " + parentNode.getPath());
        }
        catch(javax.jcr.RepositoryException re) {
            throw new PersistenceException(re);
        }
    }
}
