# Custom Item Tutorial for Fabric-0.15.11 Minecraft-1.21
This tutorial is intended for those who have already setup their development environment, and need some support adding Items into their mod. Please let me know if there are any errors, or if things can be improved upon all feedback is good feedback :)

[<img src="https://img.shields.io/badge/1.21-green?style=flat&label=Minecraft%20Version&color=green">](<https://www.minecraft.net/download>) [<img src="https://img.shields.io/badge/0.15.11-blue?style=flat&label=Fabric%20Version&color=blue">](<https://fabricmc.net/use/installer/>)

# Contents
1. #### [Changing the Display Name and adding a Tooltip](#changing-the-display-name-and-adding-a-tooltip-1)
2. #### [Adding Custom Textures and Models](#adding-custom-textures-and-models-1)
3. #### [Adding an ItemGroup](#adding-an-itemgroup-1)


## Folder Structure
Folder structure is personal preference however you should always make sure that your directories are readable, for example `src/main/<package_name>/item` is a clean directory to store all of your Item code.
This can be applied for any instance such as blocks and entities.

<details><summary><h3>CustomItemTutorial.java</h3>
<p>This is the main class for the mod.</p></summary>

```java
    package org.sixixsix.customitemtutorial;

    import net.fabricmc.api.ModInitializer;
    import item.org.jowhe.customitemtutorial.ModItems;
    
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
        }
    }
```

</details>
<details><summary><h3>CustomItem.java</h3>
<p>This is the basic outline of the Custom Item Class. Here is where all the code that handles the item, is contained.</p></summary>

```java
    package org.sixixsix.customitemtutorial.item;

    import net.minecraft.item.Item;
    import net.minecraft.item.ItemStack;
    import net.minecraft.item.tooltip.TooltipType;
    import net.minecraft.text.Text;
    
    import java.util.List;
    
    public class CustomItem extends Item {
    
        /** Declaration of the ITEM
         * Note that we declare an Item to be registered as ITEM, but we pass,
         * the {@link CustomItem} class we have made.
         * This ensures that the Item is actually an Item but is an instance of our CustomItem.
         */
        public static final Item ITEM = new CustomItem(new Settings());
    
        /** Constructor for CustomItem
         * This constructor can be used for many things,
         * for the purpose of this tutorial it will be defaulted {@link Item.Settings()}.
         */
        public CustomItem(Settings settings) {
            super(settings);
        }
    }

```

</details>
<details><summary><h3>Registering an Item</h3></summary>

```java
    package org.sixixsix.customitemtutorial.item;

    import net.minecraft.item.Item;
    import net.minecraft.registry.Registries;
    import net.minecraft.registry.Registry;
    import net.minecraft.util.Identifier;
    import org.jowhe.customitemtutorial.CustomItemTutorial;
    
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
```

</details>

<details><summary><h3>Result</h3>
<p>The result of the code above will add a custom item into the game.</p></summary>
<img src="https://github.com/user-attachments/assets/b4e35cd6-0cc8-4597-a8e7-fd5541b4e7de">
</details>

# Changing the Display Name and adding a Tooltip.
This section shows you how you can add a name and tooltip to your item.

## Adding language translations
To add this file you must navigate to the `src/main/resources/` and create two new folders one called `assets` and the other with the same MOD_ID as you set in your main class.

It should look like `src/main/resources/assets/custom_mod_id/`
Once you have that you need to create a new folder called `lang` and then a new json file called `en_us.json`.

This is essentially an extension to the default language pack in minecraft and allows you to translate that `item.custom_item_tutorial.custom_item` into something more readable.
While you're in the en_us.json file, add another line underneath your item name, and call it something like `tooltip.custom_item_tutorial.custom_item`. This will setup the tooltip text for later.

<details><summary>en_us.json file</summary>
<img src="https://github.com/user-attachments/assets/596467a1-4c36-4e5c-8be2-f7d362fbfdf9">
</details>

## Adding the Tooltip Text
To add the tooltip text you must go back into your CustomItem class, where you declare the ITEM variable. Here you want to add the following code
```java
    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        // Here is where you enter the value of what you set in the en_us.json file, if you are using an IDE like IntelliJ IDEA,
        // this field will be present in auto-complete (I'm not sure about others).
        tooltip.add(Text.translatable("tooltip.custom_item_tutorial.custom_item"));
        super.appendTooltip(stack, context, tooltip, type);
    }
```

After adding those you should see your Item now has it's custom name and a custom tooltip.
<details><summary>Result</summary>
<img src="https://github.com/user-attachments/assets/6198977a-f144-43d9-8900-d6293c87f4a4">
</details>

# Adding Custom Textures and Models
In order to add custom textures/models we need to setup the correct directories in order for them to be accessible. A good source for understanding models would be the [Minecraft Wiki Page](https://minecraft.wiki/w/Tutorials/Models).

For Textures:
`src/main/resources/assets/textures/item/`

For Models:
`src/main/resources/assets/models/item/`

Simply create your textures and name them appropiatly, this will help you when applying the textures to the model.

## Adding your Model
To add your model you need to create a `<model_name>.json` e.g. `custom_item.json`, in this file you have to input your model data. 

```json

{
  "parent": "item/handheld",
  "textures": {
    "layer0": "custom_item_tutorial:item/custom_item"
  }
}

```
Breaking down what this file is doing is pretty straightforward, ensuring it is a type of item/handheld means that it will be scaled correctly.
The value inside of layer0 refers to the namespace of the mod which is what you set `MOD_ID` to, `item/custom_item` refers to `textures/item/custom_item.png`.

<details><summary>Result</summary>
<img src="https://github.com/user-attachments/assets/0322f87d-cd02-4c06-a01b-6372ecc09b42">
</details>

# Adding an ItemGroup
To add an item group we will first create a new package in `src/main/<mod_package>/` called `group`, this will encase the ModGroups class.
In this class we are going to create new RegistryKey<ItemGroup> this is creating a new key to identify our Item Group.
```java

/**
     * In order for your item group to be accessible you need to make a registry key
     * this acts as the identifier for your item group.
     */
    public static final RegistryKey<ItemGroup> CUSTOM_ITEM_GROUP_KEY =
            RegistryKey.of(Registries.ITEM_GROUP.getKey(),
                    Identifier.of(CustomItemTutorial.MOD_ID,
                            "custom_item_group"));

```
Underneath this we are going to create the actual ItemGroup, we do this by using `FabricItemGroup.builder().build()`, this function takes in extra parameters such as `.icon()`. The code below will show you how to create the ItemGroup with a respective icon.
```java

public static ItemGroup CUSTOM_ITEM_GROUP =
            FabricItemGroup.builder()
                    .icon(() -> new ItemStack(CustomItem.ITEM)).build();

```
After that you have to register your ItemGroup which can be done by creating a new public void called `initializeGroups()` and call it from your `onInitialize()` function in the mods main class.
<details><summary><h5>ModGroups.java</h5></summary>

```java

package org.sixixsix.customitemtutorial.group;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;
import org.sixixsix.customitemtutorial.CustomItemTutorial;
import org.sixixsix.customitemtutorial.item.CustomItem;

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

```

</details>

Finally you can edit the `en_us.json` file to include a name for your Item group and add your item to the group. That is done by calling `ItemGroupEvents.modifyEntriesEvent()` in the `ModItems` class. Once you have added that to your class, call `ModGroups.initializeGroups()` in your main mod class.

<details><summary><h5>ModItems.java initializeItems()</h5></summary>

```java

/**
     * Initialize Items
     * This function will be used to initialize custom items.
     */
    public static void initializeItems(){
        // "custom_item" will be the accessible name,
        // CustomItem.ITEM is our ITEM's declaration.
        registerItem("custom_item", CustomItem.ITEM);

        // Add the custom item to the custom item group.
        ItemGroupEvents.modifyEntriesEvent(ModGroups.CUSTOM_ITEM_GROUP_KEY).register(itemGroup -> {
            itemGroup.add(CustomItem.ITEM);
        });

    }

```

</details>

<details><summary><h5>CustomItemTutorial.java onInitialize()</h5></summary>

```java

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

```

</details>

<details><summary>Result</summary>
<img src="https://github.com/user-attachments/assets/986c50f8-da77-4990-9590-18491c90c758">
</details>
