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
package dev.tophatcat.kiristrinkets.init;

import dev.tophatcat.kirislib.RegHelpers;
import dev.tophatcat.kiristrinkets.KirisTrinkets;
import dev.tophatcat.kiristrinkets.common.blocks.MysteriousTorch;
import dev.tophatcat.kiristrinkets.common.blocks.MysteriousWallTorch;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.PushReaction;

import java.util.function.Supplier;

public class TrinketsRegistry {

    private TrinketsRegistry() {
        throw new UnsupportedOperationException("Trinkets Registry only contains static definitions...");
    }

    public static void init() {
        KirisTrinkets.BLOCKS.forEach((id, block) -> Registry.register(BuiltInRegistries.BLOCK, id, block.get()));
        KirisTrinkets.ITEMS.forEach((id, item) -> Registry.register(BuiltInRegistries.ITEM, id, item.get()));
    }

    public static final Supplier<Block> ENDER_ORE = RegHelpers.createBlockWithItem(KirisTrinkets.identifier(
            "ender_ore"), () -> new Block(Block.Properties.of()),
        KirisTrinkets.BLOCKS, KirisTrinkets.ITEMS);
    public static final Supplier<Item> ENDER_DUST = RegHelpers.createBasicItem(KirisTrinkets.identifier(
        "ender_dust"), () -> new Item(new Item.Properties()), KirisTrinkets.ITEMS);
    public static final Supplier<Block> MYSTERIOUS_TORCH = RegHelpers.createBlockWithItem(KirisTrinkets.identifier(
            "mysterious_torch"), () -> new MysteriousTorch(Block.Properties.of()
            .noCollission().instabreak().lightLevel(state -> 14)
            .sound(SoundType.WOOD).pushReaction(PushReaction.DESTROY)),
        KirisTrinkets.BLOCKS, KirisTrinkets.ITEMS);
    public static final Supplier<Block> MYSTERIOUS_WALL_TORCH = RegHelpers.createBlock(KirisTrinkets.identifier(
        "mysterious_wall_torch"), () -> new MysteriousWallTorch(BlockBehaviour.Properties.of()
        .noCollission().instabreak().lightLevel(state -> 14).sound(SoundType.WOOD).dropsLike(MYSTERIOUS_TORCH.get())
        .pushReaction(PushReaction.DESTROY)), KirisTrinkets.BLOCKS);
}
