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
 * If user cannot unlock path, for example if he/she have not correct lockTokens
 * 
 * @author Martin Koci
 * 
 */
public class CannotUnlockException extends LockingException
{

	private final String lockOwner;

	private final String path;

	/**
	 * 
	 * @return The JCR Lock Owner
	 */
	public String getLockOwner()
	{
		return lockOwner;
	}

	/**
	 * 
	 * @return the JCR path
	 */
	public String getPath()
	{
		return path;
	}

	public CannotUnlockException(String lockOwner, String path)
	{
		super();
		this.lockOwner = lockOwner;
		this.path = path;
	}

}
