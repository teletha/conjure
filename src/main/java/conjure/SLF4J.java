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

import org.slf4j.ILoggerFactory;
import org.slf4j.IMarkerFactory;
import org.slf4j.Logger;
import org.slf4j.Marker;
import org.slf4j.event.Level;
import org.slf4j.helpers.LegacyAbstractLogger;
import org.slf4j.spi.MDCAdapter;
import org.slf4j.spi.SLF4JServiceProvider;

import kiss.I;

public class SLF4J implements SLF4JServiceProvider, ILoggerFactory {

    /**
     * {@inheritDoc}
     */
    @Override
    public ILoggerFactory getLoggerFactory() {
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public IMarkerFactory getMarkerFactory() {
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MDCAdapter getMDCAdapter() {
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getRequestedApiVersion() {
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void initialize() {
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("serial")
    @Override
    public Logger getLogger(String name) {
        return new LegacyAbstractLogger() {

            @Override
            public boolean isWarnEnabled() {
                return true;
            }

            @Override
            public boolean isTraceEnabled() {
                return true;
            }

            @Override
            public boolean isInfoEnabled() {
                return true;
            }

            @Override
            public boolean isErrorEnabled() {
                return true;
            }

            @Override
            public boolean isDebugEnabled() {
                return true;
            }

            @Override
            protected void handleNormalizedLoggingCall(Level level, Marker marker, String msg, Object[] arguments, Throwable throwable) {
                switch (level) {
                case TRACE:
                    I.trace(name, String.format(msg, arguments));
                    if (throwable != null) I.trace(name, throwable);
                    break;

                case DEBUG:
                    I.debug(name, String.format(msg, arguments));
                    if (throwable != null) I.debug(name, throwable);
                    break;

                case INFO:
                    I.info(name, String.format(msg, arguments));
                    if (throwable != null) I.info(name, throwable);
                    break;

                case WARN:
                    I.warn(name, String.format(msg, arguments));
                    if (throwable != null) I.warn(name, throwable);
                    break;

                case ERROR:
                    I.error(name, String.format(msg, arguments));
                    if (throwable != null) I.error(name, throwable);
                    break;
                }
            }

            @Override
            protected String getFullyQualifiedCallerName() {
                return null;
            }
        };
    }
}
