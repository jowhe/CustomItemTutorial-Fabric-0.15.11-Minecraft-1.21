# Custom Item Tutorial for FabricMC (1.21)
This tutorial is intended for those who have already setup their development environment, and need some support adding Items into their mod.

[<img src="https://img.shields.io/badge/1.21-green?style=flat&label=Minecraft%20Version&color=green">](<https://www.minecraft.net/download>) [<img src="https://img.shields.io/badge/0.15.11-blue?style=flat&label=Fabric%20Version&color=blue">](<https://fabricmc.net/use/installer/>)

## Folder Structure
Folder structure is personal preference however you should always make sure that your directories are readable, for example `src/main/<package_name>/item` is a clean directory to store all of your Item code.
This can be applied for any instance such as blocks and entities.

<details><summary><h3>CustomItemTutorial.java</h3>
<p>This is the main class for the mod.</p></summary>

    package org.sixixsix.customitemtutorial;  
      
    import net.fabricmc.api.ModInitializer;  
    import org.sixixsix.customitemtutorial.item.ModItems;  
      
    public class CustomItemTutorial implements ModInitializer {  
      
      public static String MOD_ID = "custom_item_tutorial";  
      
      /**  
     * This is the main entrypoint of your mod. * All of your main functionality will be contained in here. */  @Override  
      public void onInitialize() {  
      // Call the initializeItems function to register the items in the game.  
      ModItems.initializeItems();  
     }}
</details>
<details><summary><h3>CustomItem.java</h3>
<p>This is the basic outline of the Custom Item Class. Here is where all the code that handles the item, is contained.</p></summary>

    package org.sixixsix.customitemtutorial.item;  
      
    import net.minecraft.item.Item;  
      
    public class CustomItem extends Item {  
      
      /** Declaration of the ITEM  
     * Note that we declare an Item to be registered as ITEM, but we pass, * the {@link CustomItem} class we have made.  
     * This ensures that the Item is actually an Item but is an instance of our CustomItem. */  public static final Item ITEM = new CustomItem(new Settings());  
      
      /** Constructor for CustomItem  
     * This constructor can be used for many things, * for the purpose of this tutorial it will be defaulted {@link Item.Settings()}.  
     */  public CustomItem(Settings settings) {  
      super(settings);  
     }  
      
    }
</details>
<details><summary><h3>Registering an Item</h3></summary>

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
     *  @param name The parameter name handles what the item is called in the registry.  
     * @param item The parameter item handles what the item object points to.  
     */  
     public static void registerItem(String name, Item item){  
      Registry.register(Registries.ITEM, Identifier.of(CustomItemTutorial.MOD_ID, name), item);  
     }  
      /**  
     * Initialize Items * This function will be used to initialize custom items. */  public static void initializeItems(){  
      // "custom_item" will be the accessible name,  
     // CustomItem.ITEM is our ITEM's declaration.  registerItem("custom_item", CustomItem.ITEM);  
     }  
    }
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
<img src="">
</details>

<details><summary>Result</summary>
<img src="">
</details>
