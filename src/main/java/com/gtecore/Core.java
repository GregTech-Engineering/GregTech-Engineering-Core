package com.gtecore;

import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;

import com.gtecore.client.ClientProxy;
import com.gtecore.common.CommonProxy;
import com.gtelib.GTECore;

@Mod(GTECore.Core_ID)
public class Core {

    public Core() {
        DistExecutor.unsafeRunForDist(() -> ClientProxy::new, () -> CommonProxy::new);
    }
}
