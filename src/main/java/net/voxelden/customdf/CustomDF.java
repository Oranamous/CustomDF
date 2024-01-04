package net.voxelden.customdf;

import net.fabricmc.api.ModInitializer;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.voxelden.customdf.df.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class CustomDF implements ModInitializer {
    String MOD_ID = "customdf";
    Logger logger = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        logger.info("Loading custom DF :3");

        Registry.register(Registries.DENSITY_FUNCTION_TYPE, new Identifier(MOD_ID, "x"), XCoordDensityFunction.CODEC_HOLDER.codec());
        Registry.register(Registries.DENSITY_FUNCTION_TYPE, new Identifier(MOD_ID, "z"), ZCoordDensityFunction.CODEC_HOLDER.codec());
        Registry.register(Registries.DENSITY_FUNCTION_TYPE, new Identifier(MOD_ID, "dist"), DistanceFromCenterDensityFunction.CODEC_HOLDER.codec());
    }
}
