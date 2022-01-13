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

import java.lang.System.Logger;
import java.lang.System.LoggerFinder;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.concurrent.ConcurrentHashMap;

public class Java extends LoggerFinder {

    private static final Map<String, Logger> systems = new ConcurrentHashMap();

    /**
     * {@inheritDoc}
     */
    @Override
    public Logger getLogger(String name, Module module) {
        return systems.computeIfAbsent(name, SystemLogger::new);
    }

    /**
     * 
     */
    private static class SystemLogger implements Logger {

        private final String name;

        /**
         * @param name
         */
        private SystemLogger(String name) {
            this.name = name;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public String getName() {
            return name;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public boolean isLoggable(Level level) {
            return true;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public void log(Level level, ResourceBundle bundle, String msg, Throwable thrown) {
            send(level, bundle, msg, null, thrown);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public void log(Level level, ResourceBundle bundle, String format, Object... params) {
            send(level, bundle, format, params, null);
        }

        /**
         * Send log to sinobu.
         * 
         * @param level
         * @param bundle
         * @param message
         * @param params
         * @param error
         */
        private void send(Level level, ResourceBundle bundle, String message, Object[] params, Throwable error) {
            if (I.NoOP != null) {
                if (message != null) {
                    if (bundle != null) {
                        message = bundle.getString(message);
                    }

                    if (params != null) {
                        message = String.format(message, params);
                    }
                }

                I.log("system", message, level.ordinal(), 3);
                if (error != null) I.log("system", error, level.ordinal(), 3);
            }
        }
    }
}
