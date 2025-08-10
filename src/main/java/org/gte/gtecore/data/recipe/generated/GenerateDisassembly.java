package org.gte.gtecore.data.recipe.generated;

import net.minecraft.resources.ResourceLocation;

import it.unimi.dsi.fastutil.objects.ObjectOpenHashSet;

import java.util.Set;

public interface GenerateDisassembly {

    Set<ResourceLocation> DISASSEMBLY_RECORD = new ObjectOpenHashSet<>();

    Set<ResourceLocation> DISASSEMBLY_BLACKLIST = new ObjectOpenHashSet<>();

    String[] outputItem = { "_frame", "_fence", "_electric_motor",
            "_electric_pump", "_conveyor_module", "_electric_piston", "_robot_arm", "_field_generator",
            "_emitter", "_sensor", "smd_", "_lamp", "ae2:blank_pattern", "gtceu:carbon_nanites" };
}
