/*
 * Copyright (C) 2021 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package conjure;

import java.net.URI;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.Marker;
import org.apache.logging.log4j.message.Message;
import org.apache.logging.log4j.message.MessageFactory;
import org.apache.logging.log4j.spi.AbstractLogger;
import org.apache.logging.log4j.spi.ExtendedLogger;
import org.apache.logging.log4j.spi.LoggerContext;
import org.apache.logging.log4j.spi.LoggerContextFactory;

public class Log4j2 implements LoggerContextFactory, LoggerContext {

    public static void initialize() {
        try {
            Class.forName("org.apache.logging.log4j.spi.LoggerContextFactory");

            System.setProperty("log4j2.loggerContextFactory", Log4j2.class.getName());
        } catch (ClassNotFoundException e) {
            // ignore
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public LoggerContext getContext(String fqcn, ClassLoader loader, Object externalContext, boolean currentContext) {
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public LoggerContext getContext(String fqcn, ClassLoader loader, Object externalContext, boolean currentContext, URI configLocation, String name) {
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void removeContext(LoggerContext context) {
        // do nothing
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Object getExternalContext() {
        // If this exception will be thrown, it is bug of this program. So we must rethrow the
        // wrapped error in here.
        throw new Error();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ExtendedLogger getLogger(String name) {
        return new Logger(name);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ExtendedLogger getLogger(String name, MessageFactory messageFactory) {
        return new Logger(name);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean hasLogger(String name) {
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean hasLogger(String name, MessageFactory messageFactory) {
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean hasLogger(String name, Class<? extends MessageFactory> messageFactoryClass) {
        return true;
    }

    private static class Logger extends AbstractLogger {

        private final String name;

        private Logger(String name) {
            this.name = name;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public boolean isEnabled(Level level, Marker marker, Message message, Throwable t) {
            return false;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public boolean isEnabled(Level level, Marker marker, CharSequence message, Throwable t) {
            return false;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public boolean isEnabled(Level level, Marker marker, Object message, Throwable t) {
            return false;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public boolean isEnabled(Level level, Marker marker, String message, Throwable t) {
            return false;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public boolean isEnabled(Level level, Marker marker, String message) {
            return false;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public boolean isEnabled(Level level, Marker marker, String message, Object... params) {
            return false;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public boolean isEnabled(Level level, Marker marker, String message, Object p0) {
            return false;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public boolean isEnabled(Level level, Marker marker, String message, Object p0, Object p1) {
            return false;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public boolean isEnabled(Level level, Marker marker, String message, Object p0, Object p1, Object p2) {
            return false;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public boolean isEnabled(Level level, Marker marker, String message, Object p0, Object p1, Object p2, Object p3) {
            return false;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public boolean isEnabled(Level level, Marker marker, String message, Object p0, Object p1, Object p2, Object p3, Object p4) {
            return false;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public boolean isEnabled(Level level, Marker marker, String message, Object p0, Object p1, Object p2, Object p3, Object p4, Object p5) {
            return false;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public boolean isEnabled(Level level, Marker marker, String message, Object p0, Object p1, Object p2, Object p3, Object p4, Object p5, Object p6) {
            return false;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public boolean isEnabled(Level level, Marker marker, String message, Object p0, Object p1, Object p2, Object p3, Object p4, Object p5, Object p6, Object p7) {
            return false;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public boolean isEnabled(Level level, Marker marker, String message, Object p0, Object p1, Object p2, Object p3, Object p4, Object p5, Object p6, Object p7, Object p8) {
            return false;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public boolean isEnabled(Level level, Marker marker, String message, Object p0, Object p1, Object p2, Object p3, Object p4, Object p5, Object p6, Object p7, Object p8, Object p9) {
            return false;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public void logMessage(String fqcn, Level level, Marker marker, Message message, Throwable t) {
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public Level getLevel() {
            return null;
        }
    }
}
