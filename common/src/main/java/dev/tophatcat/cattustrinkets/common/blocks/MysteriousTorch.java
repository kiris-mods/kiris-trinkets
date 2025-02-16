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
package dev.tophatcat.cattustrinkets.common.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LeverBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;

public class MysteriousTorch extends LeverBlock {

    protected final ParticleOptions flameParticle;
    public static final BooleanProperty POWERED = BlockStateProperties.POWERED;
    protected static final VoxelShape AABB = Block.box(6.0, 0.0, 6.0, 10.0, 10.0, 10.0);

    public MysteriousTorch(Properties properties) {
        super(properties);
        flameParticle = ParticleTypes.FLAME;
        registerDefaultState(stateDefinition.any()
            .setValue(FACING, Direction.NORTH)
            .setValue(POWERED, false));
    }

    @NotNull
    @Override
    public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
        return AABB;
    }

    @NotNull
    @Override
    public BlockState updateShape(BlockState state, Direction direction, BlockState neighborState, LevelAccessor world, BlockPos pos, BlockPos neighborPos) {
        return direction == Direction.DOWN && !this.canSurvive(state, world, pos)
            ? Blocks.AIR.defaultBlockState()
            : super.updateShape(state, direction, neighborState, world, pos, neighborPos);
    }

    @Override
    public boolean canSurvive(BlockState state, LevelReader world, BlockPos pos) {
        return canSupportCenter(world, pos.below(), Direction.UP);
    }

    @Override
    public void animateTick(BlockState state, Level world, BlockPos pos, RandomSource random) {
        double d = (double) pos.getX() + 0.5;
        double e = (double) pos.getY() + 0.7;
        double f = (double) pos.getZ() + 0.5;
        world.addParticle(ParticleTypes.SMOKE, d, e, f, 0.0, 0.0, 0.0);
        world.addParticle(this.flameParticle, d, e, f, 0.0, 0.0, 0.0);
    }
}
