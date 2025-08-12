package org.gte.gtecore.api.recipe;

import net.minecraft.gametest.framework.BeforeBatch;
import net.minecraft.server.level.ServerLevel;
import net.minecraftforge.gametest.GameTestHolder;
import net.minecraftforge.gametest.PrefixGameTestTemplate;
import org.gte.gtecore.GTECore;

@PrefixGameTestTemplate(false)
@GameTestHolder(GTECore.MOD_ID)
public class OverclockLogicTest {

    @BeforeBatch(batch = "OverclockLogic")
    public static void prepare(ServerLevel level) {

    }
}
