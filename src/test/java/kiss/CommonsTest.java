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

import java.lang.System.Logger.Level;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.jupiter.api.Test;

class CommonsTest extends LoggerTestBase {

    @Test
    void message() {
        Log logger = LogFactory.getLog(CommonsTest.class);
        logger.info("message from commons-logging api");

        assert Log.check(Level.INFO, "message from commons-logging api");
    }
}
