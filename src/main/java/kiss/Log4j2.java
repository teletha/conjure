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

import java.net.URI;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.Marker;
import org.apache.logging.log4j.message.Message;
import org.apache.logging.log4j.message.MessageFactory;
import org.apache.logging.log4j.spi.AbstractLogger;
import org.apache.logging.log4j.spi.ExtendedLogger;
import org.apache.logging.log4j.spi.LoggerContext;
import org.apache.logging.log4j.spi.LoggerContextFactory;
import org.apache.logging.log4j.spi.Provider;

public class Log4j2 extends Provider {

    public Log4j2() {
        super(15, detectVersion(), Factory.class);
    }

    private static String detectVersion() {
        try {
            Class.forName("org.apache.logging.log4j.spi.LoggingSystem");
            return "3.0.0";
        } catch (ClassNotFoundException e) {
            return "2.6.0";
        }
    }

    /**
     * 
     */
    public static class Factory implements LoggerContextFactory, LoggerContext {

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
    }

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