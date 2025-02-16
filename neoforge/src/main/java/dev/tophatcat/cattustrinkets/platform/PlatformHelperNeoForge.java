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
package dev.tophatcat.cattustrinkets.platform;

import dev.tophatcat.cattustrinkets.CattusTrinketsNeoForge;
import java.util.function.Supplier;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SpawnEggItem;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.fml.ModList;
import net.neoforged.fml.loading.FMLEnvironment;
import net.neoforged.neoforge.common.DeferredSpawnEggItem;

public class PlatformHelperNeoForge implements IPlatformHelper {

    @Override
    public String getPlatformName() {
        return "NeoForge";
    }

    @Override
    public boolean isModLoaded(String modId) {
        return ModList.get().isLoaded(modId);
    }

    @Override
    public boolean isDevelopmentEnvironment() {
        return !FMLEnvironment.production;
    }

    @Override
    public <T extends BlockEntity> Supplier<BlockEntityType<T>> registerBlockEntity(
        String id, Supplier<BlockEntityType<T>> blockEntityType) {
        return CattusTrinketsNeoForge.BLOCK_ENTITIES.register(id, blockEntityType);
    }

    @Override
    public <T extends Block> Supplier<T> registerBlock(String id, Supplier<T> block) {
        return CattusTrinketsNeoForge.BLOCKS.register(id, block);
    }

    @Override
    public <T extends Entity> Supplier<EntityType<T>> registerEntity(String id, Supplier<EntityType<T>> entity) {
        return CattusTrinketsNeoForge.ENTITIES.register(id, entity);
    }

    @Override
    public <T extends ArmorMaterial> Supplier<T> registerArmorMaterial(String id, Supplier<T> armorMaterial) {
        return CattusTrinketsNeoForge.ARMOR_MATERIAL.register(id, armorMaterial);
    }

    @Override
    public <T extends Item> Supplier<T> registerItem(String id, Supplier<T> item) {
        return CattusTrinketsNeoForge.ITEMS.register(id, item);
    }

    @Override
    public <T extends SoundEvent> Supplier<T> registerSound(String id, Supplier<T> sound) {
        return CattusTrinketsNeoForge.SOUND_EVENTS.register(id, sound);
    }

    @Override
    public <T extends CreativeModeTab> Supplier<T> registerCreativeModeTab(String id, Supplier<T> tab) {
        return CattusTrinketsNeoForge.CREATIVE_TABS.register(id, tab);
    }

    @Override
    public <E extends Mob> Supplier<SpawnEggItem> registerSpawnEgg(
        String id, Supplier<EntityType<E>> entityType, int primaryColor, int secondaryColor, Item.Properties itemProperties) {
        return registerItem(id, () -> new DeferredSpawnEggItem(entityType, primaryColor, secondaryColor, itemProperties));
    }

    @Override
    public CreativeModeTab.Builder newCreativeTabBuilder() {
        return CreativeModeTab.builder();
    }
}
