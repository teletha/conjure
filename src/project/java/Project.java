
/*
 * Copyright (C) 2024 The CONJURE Development Team
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          https://opensource.org/licenses/MIT
 */

/*
 * Copyright (C) 2021 conjure Development Team
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          https://opensource.org/licenses/MIT
 */

import javax.lang.model.SourceVersion;

public class Project extends bee.api.Project {

    {
        product("com.github.teletha", "conjure", ref("version.txt"));
        describe("""
                Including this library in the classpath automatically delegates logs output from the various logging APIs to [Sinobu](https://github.com/teletha/sinobu)'s logging API.

                The currently supported APIs are as follows:
                * [Apache Commons Logging](https://commons.apache.org/proper/commons-logging/)
                * [Apache Log4j2](https://logging.apache.org/log4j/2.x/)
                * [SLF4J](https://www.slf4j.org/)
                * [JUL](https://docs.oracle.com/en/java/javase/19/docs/api/java.logging/java/util/logging/package-summary.html)
                """);

        require(SourceVersion.latest(), SourceVersion.RELEASE_21);

        require("com.github.teletha", "sinobu");
        require("org.slf4j", "slf4j-api").atProvided();
        require("org.apache.logging.log4j", "log4j-api").atProvided();
        require("commons-logging", "commons-logging").atProvided();
        require("com.github.teletha", "antibug").atTest();
    }
}