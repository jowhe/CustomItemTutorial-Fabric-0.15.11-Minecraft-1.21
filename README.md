## Custom Item Tutorial for FabricMC (1.21)
This tutorial is intended for those who have already setup their development environment, and need some support adding Items into their mod.
[<img src="https://img.shields.io/badge/1.21-green?style=flat&label=Minecraft%20Version&color=green">](<https://www.minecraft.net/download>) [<img src="https://img.shields.io/badge/0.15.11-blue?style=flat&label=Fabric%20Version&color=blue">](<https://fabricmc.net/use/installer/>)

### Folder Structure
Folder structure is personal preference however you should always make sure that your directories are readable, for example `src/main/<package_name>/item` is a clean directory to store all of your Item code.
This can be applied for any instance such as blocks and entities.

### CustomItemTutorial.java

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
This is the main class for the mod.

### CustomItem.java

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
This is the basic outline of the Custom Item Class. Here is where all of the code that handles the item, is contained.

### Registering Items

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