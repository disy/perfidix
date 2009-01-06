/*
 * Copyright 2009 Distributed Systems Group, University of Konstanz
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
 *
 * $Revision$
 * $Author$
 * $Date$
 *
 */
package org.perfidix.element;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.lang.reflect.Method;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.perfidix.annotation.Bench;

/**
 * Test case for BenchmarkElements.
 * 
 * @author Sebastian Graf, University of Konstanz
 */
public class BenchmarkElementTest {

    private BenchmarkElement benchClass1;
    private BenchmarkElement benchClass2;

    /**
     * Simple setUp
     * 
     * @throws Exception
     *             of any kind
     */
    @Before
    public void setUp() throws Exception {
        final Class<?> clazz = new BenchClass().getClass();
        final Method meth = clazz.getMethod("bench");
        final BenchmarkMethod benchMeth = new BenchmarkMethod(meth);

        benchClass1 = new BenchmarkElement(benchMeth);
        benchClass2 = new BenchmarkElement(benchMeth);
    }

    /**
     * Test method for {@link org.perfidix.element.BenchmarkElement#getId()} .
     */
    @Test
    public void testID() {
        assertFalse(benchClass1.getId() == benchClass2.getId());
    }

    /**
     * Test method for
     * {@link org.perfidix.element.BenchmarkElement#equals(Object)} .
     */
    @Test
    public void testEquals() {
        assertFalse(benchClass1.equals(benchClass2));
        assertTrue(benchClass1.getMeth().equals(benchClass2.getMeth()));
    }

    /**
     * Test method for {@link org.perfidix.element.BenchmarkElement#hashCode()}
     * .
     */
    @Test
    public void testHashCode() {
        assertFalse(benchClass1.hashCode() == benchClass2.hashCode());
        assertTrue(benchClass1.getMeth().hashCode() == benchClass2
                .getMeth().hashCode());
    }

    /**
     * Simple tearDown
     * 
     * @throws Exception
     *             of any kind
     */
    @After
    public void tearDown() throws Exception {
        benchClass1 = null;
        benchClass2 = null;
    }

    class BenchClass {
        @Bench
        public void bench() {

        }
    }
}
