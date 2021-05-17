/**
 * Copyright (c) 2012, University of Konstanz, Distributed Systems Group All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without modification, are permitted provided that the
 * following conditions are met: * Redistributions of source code must retain the above copyright notice, this list of
 * conditions and the following disclaimer. * Redistributions in binary form must reproduce the above copyright notice,
 * this list of conditions and the following disclaimer in the documentation and/or other materials provided with the
 * distribution. * Neither the name of the University of Konstanz nor the names of its contributors may be used to
 * endorse or promote products derived from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES,
 * INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL <COPYRIGHT HOLDER> BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY,
 * OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 * DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT,
 * STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE,
 * EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package org.perfidix.ouput.asciitable;

/**
 * This abstract class represents all drawable items in this {@link NiceTable}.
 *
 * @author Alexander Onea, neue Couch
 */
public abstract class AbstractTabularComponent {

    /**
     * Constant for the newline-symbol.
     */
    static final String NEWLINE = System.lineSeparator();

    /**
     * Border symbol, can be changed in the runtime.
     */
    static final char BORDER = '|';
    /**
     * Constant for the space between data and border.
     */
    static final String SPACE = " ";
    /**
     * Instance to draw to.
     */
    private transient final NiceTable table;

    /**
     * Constructor.
     *
     * @param paramTable to be drawn
     */
    AbstractTabularComponent(final NiceTable paramTable) {
        table = paramTable;
    }

    /**
     * Drawing this item.
     *
     * @return a string representation to draw this line.
     */
    protected abstract String draw();

    /**
     * Getter for member table.
     *
     * @return the table
     */
    final NiceTable getTable() {
        return table;
    }

    /**
     * Alignment in the cells.
     */
    public enum Alignment {
        /**
         * Left alignement.
         */
        Left,
        /**
         * Right alignement.
         */
        Right,
        /**
         * Center alignement.
         */
        Center
    }

}
