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

import dev.tophatcat.cattustrinkets.client.CattusRenderingNeo;
import net.minecraft.core.registries.Registries;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.loading.FMLEnvironment;
import net.neoforged.neoforge.registries.DeferredRegister;

@Mod(CattusTrinketsCommon.MOD_ID)
public class CattusTrinketsNeoForge {

    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES
        = DeferredRegister.create(Registries.BLOCK_ENTITY_TYPE, CattusTrinketsCommon.MOD_ID);
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(
        Registries.BLOCK, CattusTrinketsCommon.MOD_ID);
    public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(
        Registries.ENTITY_TYPE, CattusTrinketsCommon.MOD_ID);
    public static final DeferredRegister<ArmorMaterial> ARMOR_MATERIAL = DeferredRegister.create(
        Registries.ARMOR_MATERIAL, CattusTrinketsCommon.MOD_ID);
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(
        Registries.ITEM, CattusTrinketsCommon.MOD_ID);
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS = DeferredRegister.create(
        Registries.SOUND_EVENT, CattusTrinketsCommon.MOD_ID);
    public static final DeferredRegister<CreativeModeTab> CREATIVE_TABS = DeferredRegister.create(
        Registries.CREATIVE_MODE_TAB, CattusTrinketsCommon.MOD_ID);

    public CattusTrinketsNeoForge(IEventBus bus) {
        BLOCK_ENTITIES.register(bus);
        BLOCKS.register(bus);
        ENTITIES.register(bus);
        ITEMS.register(bus);
        SOUND_EVENTS.register(bus);
        CREATIVE_TABS.register(bus);
        CattusTrinketsCommon.init();

        if (FMLEnvironment.dist == Dist.CLIENT) {
            bus.addListener(CattusRenderingNeo::registerEntityModels);
            bus.addListener(CattusRenderingNeo::registerModelLayers);
        }
    }
}
