package org.gte.gtecore.common.forge;

import org.gte.gtecore.api.entity.IEnhancedPlayer;
import org.gte.gtecore.common.network.ServerMessage;
import org.gte.gtecore.config.GTEConfig;
import org.gte.gtecore.utils.ServerUtils;

import net.minecraft.ChatFormatting;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.ClickEvent;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class ForgeCommonEvent {

    @SubscribeEvent
    public static void onPlayerLoggedInEvent(PlayerEvent.PlayerLoggedInEvent event) {
        if (event.getEntity() instanceof ServerPlayer player) {
            if (GTEConfig.getDifficulty() < 3 && !player.getPersistentData().getBoolean("initialization")) {
                player.getPersistentData().putBoolean("initialization", true);
                player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 72000, 2, false, false, true));
            }
            if (!GTEConfig.INSTANCE.dev) player.displayClientMessage(Component.translatable("gtecore.dev", Component.literal("GitHub").withStyle(Style.EMPTY.withColor(ChatFormatting.GREEN).withClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, "")))), false);
            if (player instanceof IEnhancedPlayer enhancedPlayer) {
                final var data = new CompoundTag();
                data.putUUID(ServerUtils.IDENTIFIER_KEY, ServerUtils.getServerIdentifier());
                ServerMessage.sendData(player.getServer(), player, "loggedIn", data);
                enhancedPlayer.gtecore$setDrift(enhancedPlayer.gTECore$isDisableDrift());
            }
        }
    }
}
