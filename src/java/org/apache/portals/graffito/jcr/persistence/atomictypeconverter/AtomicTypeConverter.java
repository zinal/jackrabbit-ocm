/*
 * Copyright 2004-2005 The Apache Software Foundation or its licensors,
 *                     as applicable.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.portals.graffito.jcr.persistence.atomictypeconverter;

import javax.jcr.Value;

/**
 * 
 * AtomicTypeConverter interface.
 * 
 * The Object converter used atomic type converters to map atomic fields to JCR Value objects.
 * Amotic fields are primitive java types and their wrapper classes.
 * 
 * 
 * @author <a href="mailto:christophe.lombart@sword-technologies.com">Christophe Lombart</a>
 *
 */
public interface AtomicTypeConverter
{

	/**
	 * Convert an object into a JCR value.
	 * 
	 * @param object The object to convert
	 * @return the corresponding JCR value
	 *  
	 */
	public Value getValue(Object object);

	/**
	 * Convert a jcr property value into an object
	 * 
	 * @param value The JCR property value
	 * @return the corresponding object	
	 */
	public Object getObject(Value value);
	
	/**
	 * Get the string converted value
	 * @param object The object value
	 * @return The string converted value	 
	 */
	public String getStringValue(Object object);

}