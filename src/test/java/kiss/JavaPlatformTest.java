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

import java.lang.System.Logger;
import java.lang.System.Logger.Level;

import org.junit.jupiter.api.Test;

class JavaPlatformTest extends LoggerTestBase {

    @Test
    void message() {
        Logger logger = System.getLogger("test");
        logger.log(Level.INFO, "message from java platform logger api");

        assert Log.check(Level.INFO, "message from java platform logger api");
    }
}
