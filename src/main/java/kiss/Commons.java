/*
 * Copyright (C) 2025 The CONJURE Development Team
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          https://opensource.org/licenses/MIT
 */
package kiss;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogConfigurationException;
import org.apache.commons.logging.LogFactory;

public class Commons extends LogFactory {

    private static final Logger Delegator = new Logger();

    /**
     * {@inheritDoc}
     */
    @Override
    public Object getAttribute(String name) {
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String[] getAttributeNames() {
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Log getInstance(Class clazz) throws LogConfigurationException {
        return Delegator;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Log getInstance(String name) throws LogConfigurationException {
        return Delegator;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void release() {
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void removeAttribute(String name) {
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setAttribute(String name, Object value) {
    }

    /**
     * 
     */
    private static class Logger implements Log {

        /**
         * {@inheritDoc}
         */
        @Override
        public void debug(Object message) {
            I.log("system", message, 2, 2);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public void debug(Object message, Throwable t) {
            I.log("system", message, 2, 2);
            if (t != null) I.log("system", message, 2, 2);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public void error(Object message) {
            I.log("system", message, 5, 2);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public void error(Object message, Throwable t) {
            I.log("system", message, 5, 2);
            if (t != null) I.log("system", message, 5, 2);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public void fatal(Object message) {
            I.log("system", message, 5, 2);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public void fatal(Object message, Throwable t) {
            I.log("system", message, 5, 2);
            if (t != null) I.log("system", message, 5, 2);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public void info(Object message) {
            I.log("system", message, 3, 2);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public void info(Object message, Throwable t) {
            I.log("system", message, 3, 2);
            if (t != null) I.log("system", message, 3, 2);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public boolean isDebugEnabled() {
            return true;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public boolean isErrorEnabled() {
            return true;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public boolean isFatalEnabled() {
            return true;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public boolean isInfoEnabled() {
            return true;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public boolean isTraceEnabled() {
            return true;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public boolean isWarnEnabled() {
            return true;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public void trace(Object message) {
            I.log("system", message, 1, 2);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public void trace(Object message, Throwable t) {
            I.log("system", message, 1, 2);
            if (t != null) I.log("system", message, 1, 2);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public void warn(Object message) {
            I.log("system", message, 3, 2);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public void warn(Object message, Throwable t) {
            I.log("system", message, 3, 2);
            if (t != null) I.log("system", message, 3, 2);
        }
    }
}