/*
 * Copyright (C) 2021 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package kiss;

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

    /**
     * Install logger delegation.
     */
    public static void install() {
        try {
            Class.forName("org.apache.logging.log4j.spi.LoggerContextFactory");

            System.setProperty("log4j2.loggerContextFactory", Log4j2.class.getName());
        } catch (ClassNotFoundException e) {
            I.warn("The log4j-api-xxx.jar is not found in classpath. Stop installing the conjure system for log4j2.");
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

    /**
     * 
     */
    @SuppressWarnings("serial")
    private static class Logger extends AbstractLogger {

        private Logger(String name) {
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public boolean isEnabled(Level level, Marker marker, Message message, Throwable t) {
            return true;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public boolean isEnabled(Level level, Marker marker, CharSequence message, Throwable t) {
            return true;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public boolean isEnabled(Level level, Marker marker, Object message, Throwable t) {
            return true;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public boolean isEnabled(Level level, Marker marker, String message, Throwable t) {
            return true;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public boolean isEnabled(Level level, Marker marker, String message) {
            return true;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public boolean isEnabled(Level level, Marker marker, String message, Object... params) {
            return true;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public boolean isEnabled(Level level, Marker marker, String message, Object p0) {
            return true;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public boolean isEnabled(Level level, Marker marker, String message, Object p0, Object p1) {
            return true;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public boolean isEnabled(Level level, Marker marker, String message, Object p0, Object p1, Object p2) {
            return true;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public boolean isEnabled(Level level, Marker marker, String message, Object p0, Object p1, Object p2, Object p3) {
            return true;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public boolean isEnabled(Level level, Marker marker, String message, Object p0, Object p1, Object p2, Object p3, Object p4) {
            return true;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public boolean isEnabled(Level level, Marker marker, String message, Object p0, Object p1, Object p2, Object p3, Object p4, Object p5) {
            return true;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public boolean isEnabled(Level level, Marker marker, String message, Object p0, Object p1, Object p2, Object p3, Object p4, Object p5, Object p6) {
            return true;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public boolean isEnabled(Level level, Marker marker, String message, Object p0, Object p1, Object p2, Object p3, Object p4, Object p5, Object p6, Object p7) {
            return true;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public boolean isEnabled(Level level, Marker marker, String message, Object p0, Object p1, Object p2, Object p3, Object p4, Object p5, Object p6, Object p7, Object p8) {
            return true;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public boolean isEnabled(Level level, Marker marker, String message, Object p0, Object p1, Object p2, Object p3, Object p4, Object p5, Object p6, Object p7, Object p8, Object p9) {
            return true;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public void logMessage(String fqcn, Level level, Marker marker, Message message, Throwable error) {
            int kind;
            switch (level.getStandardLevel()) {
            case OFF:
                return;

            case TRACE:
                kind = 1;
                break;

            case DEBUG:
                kind = 2;
                break;

            case INFO:
                kind = 3;
                break;

            case WARN:
                kind = 4;
                break;

            case ERROR:
            case FATAL:
                kind = 5;
                break;

            default:
                kind = 6;
                break;
            }

            I.log("system", message.getFormattedMessage(), kind, 9);
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
