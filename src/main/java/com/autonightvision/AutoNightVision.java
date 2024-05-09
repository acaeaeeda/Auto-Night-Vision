package com.autonightvision;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;

import org.slf4j.Logger;
import com.mojang.logging.LogUtils;









@Mod(AutoNightVision.MODID)
public class AutoNightVision {
    public static final String MODID = "autonightvision";
    public static final Logger LOGGER = LogUtils.getLogger();

    public static final Integer EffectThreshold = 6;

    @Mod.EventBusSubscriber(bus = Bus.FORGE,modid = AutoNightVision.MODID)
    public static class PlayerAutoNightVision{
        @SubscribeEvent
        public static void PlayerTick(TickEvent.PlayerTickEvent event){
            var player = event.player;
            if (player == null){return;}
            if (player.isSpectator() == true){
                var LightLevel = player.getLevel().getLightEmission(player.blockPosition());
                
                if (LightLevel <= EffectThreshold){
                    event.player.addEffect(new MobEffectInstance(MobEffects.NIGHT_VISION, 12,1,true,true));
                }
                
                
                
            }
        }
    }
}
