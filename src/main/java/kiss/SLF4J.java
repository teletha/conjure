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

import org.slf4j.ILoggerFactory;
import org.slf4j.IMarkerFactory;
import org.slf4j.Logger;
import org.slf4j.Marker;
import org.slf4j.event.Level;
import org.slf4j.helpers.BasicMarkerFactory;
import org.slf4j.helpers.LegacyAbstractLogger;
import org.slf4j.helpers.MessageFormatter;
import org.slf4j.helpers.NOPMDCAdapter;
import org.slf4j.spi.MDCAdapter;
import org.slf4j.spi.SLF4JServiceProvider;

public class SLF4J implements SLF4JServiceProvider, ILoggerFactory {

    static {
        System.setProperty("slf4j.internal.verbosity", "error");
    }

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
        return new BasicMarkerFactory();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MDCAdapter getMDCAdapter() {
        return new NOPMDCAdapter();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getRequestedApiVersion() {
        return "2.0.99";
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
                return true; //
            }

            @Override
            protected void handleNormalizedLoggingCall(Level level, Marker marker, String msg, Object[] arguments, Throwable throwable) {
                int kind;
                switch (level) {
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

                default:
                    kind = 5;
                    break;
                }

                I.log("system", MessageFormatter.arrayFormat(msg, arguments).getMessage(), kind, 5);
                if (throwable != null) I.log("system", throwable, kind, 5);
            }

            @Override
            protected String getFullyQualifiedCallerName() {
                return null;
            }
        };
    }
}