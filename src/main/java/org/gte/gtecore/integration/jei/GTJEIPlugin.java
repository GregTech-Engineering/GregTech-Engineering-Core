package org.gte.gtecore.integration.jei;

import org.gte.gtecore.GTECore;

import com.gregtechceu.gtceu.GTCEu;

import net.minecraft.client.renderer.Rect2i;
import net.minecraft.resources.ResourceLocation;
import net.p3pp3rf1y.sophisticatedbackpacks.client.gui.BackpackScreen;
import net.p3pp3rf1y.sophisticatedbackpacks.client.gui.BackpackSettingsScreen;

import appeng.integration.modules.jei.JEIPlugin;
import dev.emi.emi.jemi.JemiPlugin;
import jeresources.jei.JEIConfig;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.gui.handlers.IGuiContainerHandler;
import mezz.jei.api.helpers.IStackHelper;
import mezz.jei.api.recipe.transfer.IRecipeTransferHandlerHelper;
import mezz.jei.api.registration.IGuiHandlerRegistration;
import mezz.jei.api.registration.IRecipeTransferRegistration;
import mezz.jei.library.plugins.jei.JeiInternalPlugin;
import mythicbotany.jei.MythicJei;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class GTJEIPlugin implements IModPlugin {

    public static void addJEIPlugin(List<IModPlugin> list) {
        list.add(new GTJEIPlugin());
        list.add(new mezz.jei.library.plugins.vanilla.VanillaPlugin());
        list.add(new JeiInternalPlugin());
        list.add(new JEIPlugin());
        list.add(new JemiPlugin());
        list.add(new JEIConfig());
        list.add(new MythicJei());
        list.add(new de.mari_023.ae2wtlib.reijei.JEIPlugin());
    }

    @Override
    public @NotNull ResourceLocation getPluginUid() {
        return GTECore.id("jei_plugin");
    }

    @Override
    public void registerGuiHandlers(@NotNull IGuiHandlerRegistration registration) {
        if (GTCEu.isDev()) return;
        registration.addGuiContainerHandler(BackpackScreen.class, new BackpackScreenIGuiContainerHandler());
        registration.addGuiContainerHandler(BackpackSettingsScreen.class, new BackpackSettingsScreenIGuiContainerHandler());
    }

    @Override
    public void registerRecipeTransferHandlers(@NotNull IRecipeTransferRegistration registration) {
        if (GTCEu.isDev()) return;
        IRecipeTransferHandlerHelper handlerHelper = registration.getTransferHelper();
        IStackHelper stackHelper = registration.getJeiHelpers().getStackHelper();
    }

    private static class BackpackScreenIGuiContainerHandler implements IGuiContainerHandler<BackpackScreen> {

        public @NotNull List<Rect2i> getGuiExtraAreas(BackpackScreen gui) {
            List<Rect2i> ret = new ArrayList<>();
            gui.getUpgradeSlotsRectangle().ifPresent(ret::add);
            ret.addAll(gui.getUpgradeSettingsControl().getTabRectangles());
            gui.getSortButtonsRectangle().ifPresent(ret::add);
            return ret;
        }
    }

    private static class BackpackSettingsScreenIGuiContainerHandler implements IGuiContainerHandler<BackpackSettingsScreen> {

        @Override
        public @NotNull List<Rect2i> getGuiExtraAreas(BackpackSettingsScreen gui) {
            return new ArrayList<>(gui.getSettingsTabControl().getTabRectangles());
        }
    }
}
