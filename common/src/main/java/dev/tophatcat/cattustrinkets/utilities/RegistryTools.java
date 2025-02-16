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
package dev.tophatcat.cattustrinkets.utilities;

import com.google.common.base.Suppliers;
import dev.tophatcat.cattustrinkets.CattusTrinketsCommon;
import dev.tophatcat.cattustrinkets.common.blocks.base.CattusButtonBlock;
import dev.tophatcat.cattustrinkets.common.blocks.base.CattusCeilingHangingSignBlock;
import dev.tophatcat.cattustrinkets.common.blocks.base.CattusDoorBlock;
import dev.tophatcat.cattustrinkets.common.blocks.base.CattusFenceBlock;
import dev.tophatcat.cattustrinkets.common.blocks.base.CattusFenceGateBlock;
import dev.tophatcat.cattustrinkets.common.blocks.base.CattusLeavesBlock;
import dev.tophatcat.cattustrinkets.common.blocks.base.CattusLogBlock;
import dev.tophatcat.cattustrinkets.common.blocks.base.CattusPlanksBlock;
import dev.tophatcat.cattustrinkets.common.blocks.base.CattusPressurePlateBlock;
import dev.tophatcat.cattustrinkets.common.blocks.base.CattusSaplingBlock;
import dev.tophatcat.cattustrinkets.common.blocks.base.CattusSlabBlock;
import dev.tophatcat.cattustrinkets.common.blocks.base.CattusStairBlock;
import dev.tophatcat.cattustrinkets.common.blocks.base.CattusStandingSignBlock;
import dev.tophatcat.cattustrinkets.common.blocks.base.CattusTrapDoorBlock;
import dev.tophatcat.cattustrinkets.common.blocks.base.CattusWallHangingSignBlock;
import dev.tophatcat.cattustrinkets.common.blocks.base.CattusWallSignBlock;
import dev.tophatcat.cattustrinkets.common.items.base.CattusHangingSignItem;
import dev.tophatcat.cattustrinkets.common.items.base.CattusSignItem;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.HangingSignItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SignItem;
import net.minecraft.world.item.SpawnEggItem;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.ButtonBlock;
import net.minecraft.world.level.block.CeilingHangingSignBlock;
import net.minecraft.world.level.block.DoorBlock;
import net.minecraft.world.level.block.FenceBlock;
import net.minecraft.world.level.block.FenceGateBlock;
import net.minecraft.world.level.block.PressurePlateBlock;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.SaplingBlock;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.StandingSignBlock;
import net.minecraft.world.level.block.TrapDoorBlock;
import net.minecraft.world.level.block.WallHangingSignBlock;
import net.minecraft.world.level.block.WallSignBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.grower.TreeGrower;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;

import java.util.function.Supplier;

/**
 * A collection of methods or tools I use to help clean up code duplication and make things easier to set up.
 * The first set of "register" methods are used to help register things like biomes, items and blocks to the game.
 * The rest of "create" methods are to help set up things like items and blocks. More specifically blocks in my case.
 */
public class RegistryTools {

    /**
     * Helper method for registering block entities.
     *
     * @param id          The block entities registry name.
     * @param blockEntity the block entity to be registered.
     */
    public static <T extends BlockEntity> Supplier<BlockEntityType<T>> registerBlockEntity(
        String id, Supplier<BlockEntityType<T>> blockEntity) {
        return CattusTrinketsCommon.COMMON_PLATFORM.registerBlockEntity(id, blockEntity);
    }

    /**
     * Helper method for registering blocks.
     *
     * @param id    The blocks registry name.
     * @param block The block to be registered.
     */
    public static <T extends Block> Supplier<T> registerBlock(String id, Supplier<T> block) {
        return CattusTrinketsCommon.COMMON_PLATFORM.registerBlock(id, block);
    }

    /**
     * Helper method for registering entities.
     *
     * @param id     The entities registry name.
     * @param entity   The entity to be registered.
     * @param width    The width of the mobs hit box.
     * @param height   The height of the mobs hit box.
     * @param category The category the mob belongs to.
     */
    public static <T extends Mob> Supplier<EntityType<T>> registerEntity(
        String id, EntityType.EntityFactory<T> entity, float width, float height, MobCategory category) {
        return CattusTrinketsCommon.COMMON_PLATFORM.registerEntity(id, () -> EntityType.Builder.of(
            entity, category).sized(width, height).build(id));
    }

    /**
     * Helper method for registering armor materials.
     *
     * @param id            The armor materials registry name.
     * @param armorMaterial The material to be registered.
     */
    public static <T extends ArmorMaterial> Supplier<T> registerArmorMaterial(String id, Supplier<T> armorMaterial) {
        return CattusTrinketsCommon.COMMON_PLATFORM.registerArmorMaterial(id, armorMaterial);
    }

    /**
     * Helper method for registering items.
     *
     * @param id   The items registry name.
     * @param item The item to be registered.
     */
    public static <T extends Item> Supplier<T> registerItem(String id, Supplier<T> item) {
        return CattusTrinketsCommon.COMMON_PLATFORM.registerItem(id, item);
    }

    /**
     * Helper method for registering sounds.
     *
     * @param id    The sounds registry name.
     * @param sound The sound to be registered.
     */
    public static <T extends SoundEvent> Supplier<T> registerSound(String id, Supplier<T> sound) {
        return CattusTrinketsCommon.COMMON_PLATFORM.registerSound(id, sound);
    }

    /**
     * Helper method for registering creative tabs.
     *
     * @param id      The creative mode tabs name, I always use the mods ID.
     * @param builder The creative mode tabs builder that provides the settings and adds the items to the tab.
     */
    public static <T extends CreativeModeTab> Supplier<CreativeModeTab> registerCreativeTab(
        String id, CreativeModeTab.Builder builder) {
        return CattusTrinketsCommon.COMMON_PLATFORM.registerCreativeModeTab(id, builder::build);
    }

    /**
     * Helper method for registering spawn egg items.
     *
     * @param id             The name of the spawn egg.
     * @param entityType     The entity to register a spawn egg for.
     * @param primaryColor   The primary hex color of the egg.
     * @param secondaryColor The secondary hex color of the egg.
     * @param properties     The egg items properties.
     */
    public static <T extends Mob> Supplier<SpawnEggItem> registerSpawnEggItem(
        String id, Supplier<EntityType<T>> entityType, int primaryColor, int secondaryColor,
        SpawnEggItem.Properties properties) {
        return CattusTrinketsCommon.COMMON_PLATFORM.registerSpawnEgg(
            id, entityType, primaryColor, secondaryColor, properties);
    }

    /**
     * A helper method to create pillar like blocks, logs, stripped logs, columns and so on.
     *
     * @param id The name of the block being registered.
     */
    public static Supplier<RotatedPillarBlock> createPillarBlock(String id) {
        return registerBlock(id, Suppliers.memoize(() -> new CattusLogBlock(
            BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LOG))));
    }

    /**
     * A helper method to create wooden plank type blocks.
     *
     * @param id The name of the planks being registered.
     */
    public static Supplier<Block> createPlanksBlock(String id) {
        return registerBlock(id, Suppliers.memoize(()
            -> new CattusPlanksBlock(Block.Properties.ofFullCopy(Blocks.OAK_PLANKS))));
    }

    /**
     * A helper method to create stair blocks.
     *
     * @param id         The name of the stairs being registered.
     * @param blockState The default block state of the planks that these stairs are to be made of.
     */
    public static Supplier<StairBlock> createStairsBlock(String id, Supplier<BlockState> blockState) {
        return registerBlock(id, Suppliers.memoize(() -> new CattusStairBlock(blockState.get(),
            Block.Properties.ofFullCopy(Blocks.OAK_STAIRS))));
    }

    /**
     * A helper method to create leaf blocks.
     *
     * @param id The name of the leaves being registered.
     */
    public static Supplier<Block> createLeavesBlock(String id) {
        return registerBlock(id, Suppliers.memoize(() -> new CattusLeavesBlock(
            Block.Properties.ofFullCopy(Blocks.OAK_LEAVES))));
    }

    /**
     * A helper method to create slab blocks.
     *
     * @param id The name of the slabs being registered.
     */
    public static Supplier<SlabBlock> createSlabBlock(String id) {
        return registerBlock(id, Suppliers.memoize(() -> new CattusSlabBlock(
            Block.Properties.ofFullCopy(Blocks.OAK_SLAB))));
    }

    /**
     * A helper method to create fence blocks.
     *
     * @param id The name of the fence being registered.
     */
    public static Supplier<FenceBlock> createFenceBlock(String id) {
        return registerBlock(id, Suppliers.memoize(() -> new CattusFenceBlock(
            Block.Properties.ofFullCopy(Blocks.OAK_FENCE))));
    }

    /**
     * A helper method to create fence gates.
     *
     * @param id The name of the gate being registered.
     */
    public static Supplier<FenceGateBlock> createGateBlock(String id) {
        return registerBlock(id, Suppliers.memoize(() -> new CattusFenceGateBlock(
            WoodType.OAK, Block.Properties.ofFullCopy(Blocks.OAK_FENCE_GATE))));
    }

    /**
     * A helper method to create buttons.
     *
     * @param id The name of the button being registered.
     */
    public static Supplier<ButtonBlock> createButtonBlock(String id) {
        return registerBlock(id, Suppliers.memoize(() -> new CattusButtonBlock(
            BlockSetType.OAK, 30, Block.Properties.ofFullCopy(Blocks.OAK_BUTTON))));
    }

    /**
     * A helper method to create pressure plates.
     *
     * @param id The name of the pressure plates being registered.
     */
    public static Supplier<PressurePlateBlock> createPressurePlateBlock(String id) {
        return registerBlock(id, Suppliers.memoize(() -> new CattusPressurePlateBlock(
            BlockSetType.OAK, Block.Properties.ofFullCopy(Blocks.OAK_PRESSURE_PLATE))));
    }

    /**
     * A helper method to create trap doors.
     *
     * @param id The name of the trap door being registered.
     */
    public static Supplier<TrapDoorBlock> createTrapdoorBlock(String id) {
        return registerBlock(id, Suppliers.memoize(() -> new CattusTrapDoorBlock(
            BlockSetType.OAK, Block.Properties.ofFullCopy(Blocks.OAK_TRAPDOOR))));
    }

    /**
     * A helper method to create doors.
     *
     * @param id The name of the door being registered.
     */
    public static Supplier<DoorBlock> createDoorBlock(String id) {
        return registerBlock(id, Suppliers.memoize(() -> new CattusDoorBlock(BlockSetType.OAK,
            Block.Properties.ofFullCopy(Blocks.OAK_DOOR).strength(3.0F)
                .noOcclusion().ignitedByLava())));
    }

    /**
     * A helper method to create saplings.
     *
     * @param id   The name of the sapling being registered.
     * @param grower the {@link TreeGrower} to be used to grow trees.
     */
    public static Supplier<SaplingBlock> createSaplingBlock(String id, TreeGrower grower) {
        return registerBlock(id, Suppliers.memoize(() -> new CattusSaplingBlock(grower,
            Block.Properties.ofFullCopy(Blocks.OAK_SAPLING))));
    }

    /**
     * A helper method to create signs.
     *
     * @param id          The name of the sign being registered.
     * @param signBlock     The sign block to be placed when placing signs on floors.
     * @param wallSignBlock The sign block to be placed when placing signs on walls.
     */
    public static Supplier<SignItem> createSign(String id, Supplier<StandingSignBlock> signBlock,
                                                Supplier<WallSignBlock> wallSignBlock) {
        return registerItem(id, Suppliers.memoize(() -> new CattusSignItem(new Item.Properties()
            .stacksTo(16), signBlock.get(), wallSignBlock.get())));
    }

    /**
     * A helper method to create standing sign blocks.
     *
     * @param id     The name of the standing sign being registered.
     * @param woodType The wood type of the sign.
     */
    public static Supplier<StandingSignBlock> createStandingSignBlock(String id, WoodType woodType) {
        return registerBlock(id, Suppliers.memoize(() -> new CattusStandingSignBlock(
            woodType, Block.Properties.ofFullCopy(Blocks.OAK_SIGN))));
    }

    /**
     * A helper method to create wall sign blocks.
     *
     * @param id     The name of the wall sign being registered.
     * @param woodType The wood type of the sign.
     */
    public static Supplier<WallSignBlock> createWallSignBlock(String id, WoodType woodType) {
        return registerBlock(id, Suppliers.memoize(() -> new CattusWallSignBlock(
            woodType, Block.Properties.ofFullCopy(Blocks.OAK_WALL_SIGN))));
    }

    /**
     * A helper method to create hanging signs.
     *
     * @param id                 The name of the hanging sign being registered.
     * @param hangingSignBlock     The hanging sign block to be placed when placing hanging signs on a down facing surface.
     * @param wallHangingSignBlock The hanging sign block to be placed when hanging signs from a side facing surface.
     */
    public static Supplier<HangingSignItem> createHangingSign(
        String id, Supplier<CeilingHangingSignBlock> hangingSignBlock,
        Supplier<WallHangingSignBlock> wallHangingSignBlock) {
        return registerItem(id, Suppliers.memoize(() -> new CattusHangingSignItem(hangingSignBlock.get(),
            wallHangingSignBlock.get(), new Item.Properties().stacksTo(16))));
    }

    /**
     * A helper method to create hanging sign blocks.
     *
     * @param id     The name of the hanging sign block being registered.
     * @param woodType The wood type of the sign.
     */
    public static Supplier<CeilingHangingSignBlock> createHangingSignBlock(String id, WoodType woodType) {
        return registerBlock(id, Suppliers.memoize(() -> new CattusCeilingHangingSignBlock(
            woodType, Block.Properties.ofFullCopy(Blocks.OAK_HANGING_SIGN))));
    }

    /**
     * A helper method to create wall hanging sign blocks.
     *
     * @param id     The name of the wall hanging sign block being registered.
     * @param woodType The wood type of the sign.
     */
    public static Supplier<WallHangingSignBlock> createWallHangingSignBlock(String id, WoodType woodType) {
        return registerBlock(id, Suppliers.memoize(() -> new CattusWallHangingSignBlock(
            woodType, Block.Properties.ofFullCopy(Blocks.OAK_WALL_HANGING_SIGN))));
    }
}
