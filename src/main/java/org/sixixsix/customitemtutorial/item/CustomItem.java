package org.sixixsix.customitemtutorial.item;

import net.minecraft.item.Item;

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
