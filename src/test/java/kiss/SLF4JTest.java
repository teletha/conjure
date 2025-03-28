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

import java.lang.System.Logger.Level;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class SLF4JTest extends LoggerTestBase {

    @Test
    void message() {
        Logger logger = LoggerFactory.getLogger(SLF4JTest.class);
        logger.info("message from slf4j api");

        assert Log.check(Level.INFO, "message from slf4j api");
    }
}