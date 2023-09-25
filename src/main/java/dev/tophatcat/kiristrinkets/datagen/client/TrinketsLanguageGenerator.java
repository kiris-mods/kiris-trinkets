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
package dev.tophatcat.kiristrinkets.datagen.client;

import dev.tophatcat.kiristrinkets.init.TrinketsRegistry;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;

public class TrinketsLanguageGenerator extends FabricLanguageProvider {

    public TrinketsLanguageGenerator(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generateTranslations(TranslationBuilder translationBuilder) {
        translationBuilder.add(TrinketsRegistry.MYSTERIOUS_TORCH.get(), "Mysterious Torch");
        translationBuilder.add(TrinketsRegistry.ENDER_ORE.get(), "Ender Ore");
        translationBuilder.add(TrinketsRegistry.ENDER_DUST.get(), "Ender Dust");
    }
}
