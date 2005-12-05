/*
 * Copyright 2000-2005 The Apache Software Foundation.
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
package org.apache.portals.graffito.jcr.mapper.model;

import java.util.HashMap;
import java.util.Map;

/**
 * This class match to the complete xml mapping files.
 * it contains mainly a collection of {@link ClassDescriptor}
 * 
 * @author <a href="mailto:christophe.lombart@sword-technologies.com">Lombart Christophe </a>
 * @version $Id: Exp $
 */
public class MappingDescriptor
{
    private HashMap classDescriptors = new HashMap();
    
    /**
     * Add a new ClassDescriptor
     * 
     * @param classDescriptor The class descriptor to add
     */
    public void addClassDescriptor(ClassDescriptor classDescriptor)
    {
        classDescriptors.put(classDescriptor.getClassName(), classDescriptor);
    }
    
    /**
     * Get the classdescriptor to used for the class 
     * @param className the class name 
     * @return the class descriptor found or null
     */
    public ClassDescriptor getClassDescriptor(String className)
    {
        return (ClassDescriptor) classDescriptors.get(className);
    }
    
    /**
     * Get all class descriptors 
     * @return all class descriptors found
     */
    public Map getClassDescriptors()
    {
    	return classDescriptors;
    }

}