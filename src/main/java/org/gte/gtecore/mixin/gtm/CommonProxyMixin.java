package org.gte.gtecore.mixin.gtm;

import org.gte.gtecore.data.Data;
import org.gte.gtecore.data.loot.DungeonLoot;
import org.gte.gtecore.data.recipe.GTERecipes;

import com.gregtechceu.gtceu.GTCEu;
import com.gregtechceu.gtceu.common.CommonProxy;
import com.gregtechceu.gtceu.data.loot.DungeonLootLoader;
import com.gregtechceu.gtceu.data.pack.GTDynamicDataPack;
import com.gregtechceu.gtceu.data.pack.GTPackSource;

import net.minecraft.server.packs.repository.Pack;
import net.minecraftforge.event.AddPackFindersEvent;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(CommonProxy.class)
public class CommonProxyMixin {

    @Inject(method = "registerPackFinders", at = @At(value = "INVOKE", target = "Lcom/gregtechceu/gtceu/data/pack/GTDynamicDataPack;clearServer()V"), remap = false, cancellable = true)
    private void registerPackFinders(AddPackFindersEvent event, CallbackInfo ci) {
        if (!GTERecipes.cache) {
            if (!GTCEu.isClientSide()) {
                Data.init();
            }
            DungeonLootLoader.init();
            DungeonLoot.init();
        }
        event.addRepositorySource(new GTPackSource("gtceu:dynamic_data", event.getPackType(), Pack.Position.BOTTOM, GTDynamicDataPack::new));
        ci.cancel();
    }
}
