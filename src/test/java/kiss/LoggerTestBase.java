/*
 * Copyright (C) 2022 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package kiss;

import java.lang.System.Logger.Level;
import java.nio.CharBuffer;
import java.util.ArrayDeque;
import java.util.Deque;

import org.junit.jupiter.api.BeforeEach;

public class LoggerTestBase {

    protected static final LogBuffer Log = new LogBuffer();

    static {
        I.env("system.file", Level.OFF);
        I.env("system.console", Level.OFF);
        I.env("system.extra", Level.ALL);
        I.Logger = Log;
    }

    @BeforeEach
    void clean() {
        Log.clean();
    }

    /**
     * 
     */
    protected static class LogBuffer implements WiseTriConsumer<String, Level, CharBuffer> {

        private Deque<Level> levels = new ArrayDeque();

        private Deque<String> messages = new ArrayDeque();

        /**
         * {@inheritDoc}
         */
        @Override
        public void ACCEPT(String param1, Level param2, CharBuffer param3) throws Throwable {
            String message = param3.toString();
            messages.add(message.substring(message.lastIndexOf('\t') + 1).trim());
            levels.add(param2);
        }

        /**
         * Check buffered log.
         * 
         * @param level
         * @param message
         * @return
         */
        public boolean check(Level level, String message) {
            assert levels.pollFirst() == level;
            assert messages.pollFirst().equals(message);

            return true;
        }

        /**
         * Clean up all resources.
         */
        public void clean() {
            levels.clear();
            messages.clear();
        }
    }
}
