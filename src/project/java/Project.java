/*
 * Copyright (C) 2021 conjure Development Team
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          https://opensource.org/licenses/MIT
 */
public class Project extends bee.api.Project {

    {
        product("com.github.teletha", "conjure", ref("version.txt"));

        require("com.github.teletha", "sinobu");
        require("org.slf4j", "slf4j-api").atProvided();
        require("org.apache.logging.log4j", "log4j-api").atProvided();
        require("commons-logging", "commons-logging").atProvided();
        require("com.github.teletha", "antibug").atTest();
    }
}