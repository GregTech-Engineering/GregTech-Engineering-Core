package org.gte.gtecore.api.recipe;

import com.gtelib.GTECore;
import net.minecraft.gametest.framework.BeforeBatch;
import net.minecraft.server.level.ServerLevel;
import net.minecraftforge.gametest.GameTestHolder;
import net.minecraftforge.gametest.PrefixGameTestTemplate;

@PrefixGameTestTemplate(false)
@GameTestHolder(GTECore.Core_ID)
public class InputSeparationTest {

    @BeforeBatch(batch = "InputSeparation")
    public static void prepare(ServerLevel level) {

    }
}
