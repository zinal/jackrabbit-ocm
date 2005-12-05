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
package org.apache.portals.graffito.jcr.exception;


/**
 * 
 * Base class of all runtime exceptions used in the JCR mapping.
 * 
 * @author <a href="mailto:christophe.lombart@sword-technologies.com">Christophe Lombart</a>
 */

public class JcrMappingException extends RuntimeException
{

    /**
     * Default Constructor without information.
     */
    public JcrMappingException() 
    {
        super();
    }
    
    /**
     * Constructor with message.
     * 
     * @param message the message associated to the exception
     */
    public JcrMappingException(String message) 
    {
        super(message);
    }
    
    /**
     * Constructor with throwable object.
     * 
     * @param nested the associated throwable object
     */    
    public JcrMappingException(Throwable nested)
    {
        super(nested);
    }
    
    /**
     * Constructor with message and throwable object.
     * 
     * @param message the message associated to the exception
     * @param nested the associated throwable object
     */    
    public JcrMappingException(String message, Throwable nested)
    {
        super(message, nested);
    }

}