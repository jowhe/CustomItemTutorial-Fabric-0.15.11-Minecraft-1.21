package org.jowhe.customitemtutorial;

import net.fabricmc.api.ModInitializer;
import org.jowhe.customitemtutorial.group.ModGroups;
import org.jowhe.customitemtutorial.item.ModItems;

public class CustomItemTutorial implements ModInitializer {

    public static String MOD_ID = "custom_item_tutorial";

    /**
     * This is the main entrypoint of your mod.
     * All of your main functionality will be contained in here.
     */
    @Override
    public void onInitialize() {
        // Call the initializeItems function to register the items in the game.
        ModItems.initializeItems();
        ModGroups.initializeGroups();
    }
}
