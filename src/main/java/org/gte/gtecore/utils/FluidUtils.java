package org.gte.gtecore.utils;

import org.gte.gtecore.api.fluid.IFluid;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.Fluids;
import net.minecraftforge.registries.ForgeRegistries;

public class FluidUtils {

    private FluidUtils() {}

    public static String getId(Fluid fluid) {
        return getIdLocation(fluid).toString();
    }

    public static ResourceLocation getIdLocation(Fluid fluid) {
        return ((IFluid) fluid).gtecore$getIdLocation();
    }

    public static Fluid getFluid(String fluidName) {
        Fluid fluid = ForgeRegistries.FLUIDS.getValue(new ResourceLocation(fluidName));
        return fluid == null ? Fluids.EMPTY : fluid;
    }
}
