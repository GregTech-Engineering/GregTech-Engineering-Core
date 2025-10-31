package com.gtecore;

import com.gtelib.GTECore;

import com.gtecore.client.ClientProxy;
import com.gtecore.common.CommonProxy;

import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;

@Mod(GTECore.Core_ID)
public class Core {

    public Core() {
        DistExecutor.unsafeRunForDist(() -> ClientProxy::new, () -> CommonProxy::new);
    }
}
