package org.sixixsix.customitemtutorial.item;

import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import org.sixixsix.customitemtutorial.CustomItemTutorial;

public class ModItems {

    /**
     * Registering an Item
     * This function will allow us to register new Items after we have created them.
     *
     * @param name The parameter name handles what the item is called in the registry.
     * @param item The parameter item handles what the item object points to.
     */
    public static void registerItem(String name, Item item){
        Registry.register(Registries.ITEM, Identifier.of(CustomItemTutorial.MOD_ID, name), item);
    }

    /**
     * Initialize Items
     * This function will be used to initialize custom items.
     */
    public static void initializeItems(){
        // "custom_item" will be the accessible name,
        // CustomItem.ITEM is our ITEM's declaration.
        registerItem("custom_item", CustomItem.ITEM);
    }

}
