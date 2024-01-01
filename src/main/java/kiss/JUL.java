/*
 * Copyright (C) 2024 The CONJURE Development Team
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          https://opensource.org/licenses/MIT
 */
package kiss;

import java.text.MessageFormat;
import java.util.MissingResourceException;
import java.util.ResourceBundle;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

public class JUL extends Handler {

    private static final int TRACE_LEVEL_THRESHOLD = Level.FINEST.intValue();

    private static final int DEBUG_LEVEL_THRESHOLD = Level.FINE.intValue();

    private static final int INFO_LEVEL_THRESHOLD = Level.INFO.intValue();

    private static final int WARN_LEVEL_THRESHOLD = Level.WARNING.intValue();

    /**
     * Replace logging from JUL to Sinobu.
     */
    public static void replace() {
        Logger logger = LogManager.getLogManager().getLogger("");
        for (Handler handler : logger.getHandlers()) {
            logger.removeHandler(handler);
        }
        logger.addHandler(new JUL());
    }

    /**
     * Hide constructor.
     */
    private JUL() {
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void close() {
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void flush() {
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void publish(LogRecord log) {
        if (log == null) {
            return;
        }

        String name = log.getLoggerName();
        String message = getMessageI18N(log);

        int level = log.getLevel().intValue();
        if (level <= TRACE_LEVEL_THRESHOLD) {
            I.log(name, message, 1, 6);
        } else if (level <= DEBUG_LEVEL_THRESHOLD) {
            I.log(name, message, 2, 6);
        } else if (level <= INFO_LEVEL_THRESHOLD) {
            I.log(name, message, 3, 6);
        } else if (level <= WARN_LEVEL_THRESHOLD) {
            I.log(name, message, 4, 6);
        } else {
            I.log(name, message, 5, 6);
        }
    }

    /**
     * Resolve the log message.
     *
     * @param log
     * @return
     */
    private String getMessageI18N(LogRecord log) {
        String message = log.getMessage();
        if (message == null) {
            return null;
        }

        ResourceBundle bundle = log.getResourceBundle();
        if (bundle != null) {
            try {
                message = bundle.getString(message);
            } catch (MissingResourceException e) {
                // ignore
            }
        }

        Object[] params = log.getParameters();
        if (params != null && params.length != 0) {
            try {
                message = MessageFormat.format(message, params);
            } catch (IllegalArgumentException e) {
                // ignore
            }
        }
        return message;
    }
}