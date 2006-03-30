/*
 * Copyright 2000-2004 The Apache Software Foundation.
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
package org.apache.portals.graffito.jcr.testmodel.inheritance;



/**
 * CmsObject test
 * 
 * @author <a href="mailto:christophe.lombart@gmail.com">Christophe Lombart</a>
 * 
 * 
 */
public class CmsObject
{
    
    protected String path;        
    protected String name;
    protected Folder parentFolder;
    
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public Folder getParentFolder() {
		return parentFolder;
	}
	public void setParentFolder(Folder parentFolder) {
		this.parentFolder = parentFolder;
	}
	
	
        
        
}
