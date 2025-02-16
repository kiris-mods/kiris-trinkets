/*
 * A trinkets mod of miscellaneous content Kiri and Curle think would be useful for Minecraft!
 * Copyright (C) KiriCattus 2013 - 2025
 * https://github.com/kiris-mods/cattus-trinkets/blob/dev/LICENSE.md
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301
 * USA
 */
package dev.tophatcat.cattustrinkets;

import java.util.ServiceLoader;

import dev.tophatcat.cattustrinkets.platform.IPlatformHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CattusTrinketsCommon {

    public static final String MOD_ID = "cattustrinkets";
    public static final String MOD_NAME = "Cattus Trinkets";
    public static final Logger LOG = LoggerFactory.getLogger(MOD_NAME);
    public static final IPlatformHelper COMMON_PLATFORM = ServiceLoader.load(IPlatformHelper.class).findFirst().orElseThrow();

    public static void init() {
        LOG.debug("We are currently loaded via the {} mod loader in a {} environment!",
            COMMON_PLATFORM.getPlatformName(),
            COMMON_PLATFORM.getEnvironmentName());
    }
}
