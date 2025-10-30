package org.gte.gtecore.common.registry;

import com.gregtechceu.gtceu.api.registry.registrate.GTRegistrate;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import org.gte.gtecore.GTECore;

public class GTERegistration {

    public static final GTRegistrate REGISTRATE = GTRegistrate.create(GTECore.MOD_ID);

    static {
	    GTERegistration.REGISTRATE.defaultCreativeTab((ResourceKey<CreativeModeTab>) null);
    }
	
	private GTERegistration() {/**/}
}
