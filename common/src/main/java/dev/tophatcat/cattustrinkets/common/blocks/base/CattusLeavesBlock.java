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
package dev.tophatcat.cattustrinkets.common.blocks.base;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;

public class CattusLeavesBlock extends LeavesBlock {

    private final boolean canEntityPassThrough;

    public CattusLeavesBlock(Properties properties) {
        this(properties, false);
    }

    public CattusLeavesBlock(Properties properties, boolean canEntityPassThrough) {
        super(properties);
        this.canEntityPassThrough = canEntityPassThrough;
        properties.speedFactor(0.8F);
    }

    @NotNull
    @Override
    protected VoxelShape getCollisionShape(@NotNull BlockState state, @NotNull BlockGetter level,
                                           @NotNull BlockPos pos, @NotNull CollisionContext context) {
        return canEntityPassThrough ? state.getShape(level, pos) : Shapes.empty();
    }
}
