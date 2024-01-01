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

import java.lang.System.Logger.Level;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;

class Log4j2Test extends LoggerTestBase {

    @Test
    void message() {
        Logger logger = LogManager.getLogger();
        logger.info("message from log4j2 api");

        assert Log.check(Level.INFO, "message from log4j2 api");
    }
}