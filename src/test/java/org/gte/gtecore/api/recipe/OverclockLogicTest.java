package org.gte.gtecore.api.recipe;

import net.minecraft.gametest.framework.BeforeBatch;
import net.minecraft.server.level.ServerLevel;
import net.minecraftforge.gametest.GameTestHolder;
import net.minecraftforge.gametest.PrefixGameTestTemplate;

import com.gtelib.GTECore;

@PrefixGameTestTemplate(false)
@GameTestHolder(GTECore.Core_ID)
public class OverclockLogicTest {

    @BeforeBatch(batch = "OverclockLogic")
    public static void prepare(ServerLevel level) {}
}
