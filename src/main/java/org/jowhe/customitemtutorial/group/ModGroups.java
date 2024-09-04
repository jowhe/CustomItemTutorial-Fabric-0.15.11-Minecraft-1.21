package org.jowhe.customitemtutorial.group;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import org.jowhe.customitemtutorial.CustomItemTutorial;
import org.jowhe.customitemtutorial.item.CustomItem;

public class ModGroups {

    /**
     * In order for your item group to be accessible you need to make a registry key
     * this acts as the identifier for your item group.
     */
    public static final RegistryKey<ItemGroup> CUSTOM_ITEM_GROUP_KEY =
            RegistryKey.of(Registries.ITEM_GROUP.getKey(),
                    Identifier.of(CustomItemTutorial.MOD_ID,
                            "custom_item_group"));

    public static ItemGroup CUSTOM_ITEM_GROUP =
            FabricItemGroup.builder()
                    .icon(() -> new ItemStack(CustomItem.ITEM))
                    .displayName(Text.translatable("itemGroup.custom_items"))
                    .build();

    public static void initializeGroups(){
        Registry.register(Registries.ITEM_GROUP, CUSTOM_ITEM_GROUP_KEY, CUSTOM_ITEM_GROUP);
    }
}
