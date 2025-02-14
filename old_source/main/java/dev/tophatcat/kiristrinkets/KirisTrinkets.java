/*
 * Kiri's Trinkets - https://github.com/tophatcats-mods/kiris-trinkets
 * Copyright (C) 2013-2023 <KiriCattus>
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation;
 * Specifically version 2.1 of the License.
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
 * https://www.gnu.org/licenses/old-licenses/lgpl-2.1.html
 */
package dev.tophatcat.kiristrinkets;


import dev.tophatcat.kiristrinkets.init.TrinketsRegistry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import org.quiltmc.loader.api.ModContainer;
import org.quiltmc.qsl.base.api.entrypoint.ModInitializer;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Supplier;

public class KirisTrinkets implements ModInitializer {

    public static final String MOD_ID = "kiristrinkets";
    public static final Map<ResourceLocation, Supplier<Block>> BLOCKS = new LinkedHashMap<>();
    public static final Map<ResourceLocation, Supplier<Item>> ITEMS = new LinkedHashMap<>();

    @Override
    public void onInitialize(ModContainer container) {
        TrinketsRegistry.init();
    }

    public static ResourceLocation identifier(String name) {
        return new ResourceLocation(MOD_ID, name);
    }
}
