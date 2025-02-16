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
package dev.tophatcat.cattustrinkets.registries;

import dev.tophatcat.cattustrinkets.CattusTrinketsCommon;
import dev.tophatcat.cattustrinkets.utilities.RegistryTools;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.PushReaction;

import java.util.function.Supplier;

public class CattusBlockRegistry {

    public static void init() {
        CattusTrinketsCommon.LOG.info("Registering blocks...");
    }

    public static final Supplier<Block> ENDER_ORE = RegistryTools.registerBlock(
        "ender_ore", () -> new Block(BlockBehaviour.Properties.of()));

    public static final Supplier<Block> MYSTERIOUS_TORCH = RegistryTools.registerBlock(
        "mysterious_torch", () -> new Block(BlockBehaviour.Properties.of()
            .noCollission().instabreak().lightLevel(state -> 14)
            .sound(SoundType.WOOD).pushReaction(PushReaction.DESTROY)));

    public static final Supplier<Block> MYSTERIOUS_WALL_TORCH = RegistryTools.registerBlock(
        "mysterious_wall_torch", () -> new Block(BlockBehaviour.Properties.of()
            .noCollission().instabreak().lightLevel(state -> 14)
            .sound(SoundType.WOOD).dropsLike(MYSTERIOUS_TORCH.get())
            .pushReaction(PushReaction.DESTROY)));
}
