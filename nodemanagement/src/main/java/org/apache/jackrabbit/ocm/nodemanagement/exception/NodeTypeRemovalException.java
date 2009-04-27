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
package org.apache.jackrabbit.ocm.nodemanagement.exception;

/** Exception that is thrown when a JCR node type could not be removed.
 *
 * @author <a href="mailto:okiessler@apache.org">Oliver Kiessler</a>
 */
public class NodeTypeRemovalException extends BaseNodeManagementException
{

    /** Creates a new instance of NodeTypeRemovalException. */
    public NodeTypeRemovalException()
    {
    }

    /** Creates a new instance of NodeTypeRemovalException.
     * @param wrappedException Root exception
     */
    public NodeTypeRemovalException(Exception wrappedException)
    {
        setWrappedException(wrappedException);
    }
}
