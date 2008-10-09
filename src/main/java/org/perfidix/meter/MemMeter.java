/*
 * Copyright 2008 Distributed Systems Group, University of Konstanz
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
package org.perfidix.meter;

import org.perfidix.Perfidix;

public class MemMeter extends AbstractMeter {

    public String getUnit() {
        return Perfidix.MEM_UNIT;
    }

    public String getUnitDescription() {
        return Perfidix.MEM_DESCRIPTION;
    }

    public long getValue() {
        final Runtime rt = Runtime.getRuntime();
        final long mem = rt.totalMemory() - rt.freeMemory();
        rt.gc();
        return mem;
    }

    public void tick() {
    }

    public String getName() {
        return Perfidix.MEM_DESCRIPTION;
    }

}
