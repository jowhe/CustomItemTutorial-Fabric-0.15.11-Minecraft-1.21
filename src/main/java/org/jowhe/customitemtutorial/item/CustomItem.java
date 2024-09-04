package org.jowhe.customitemtutorial.item;

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

    /**
     * This override allows you to manipulate the items' tooltip.
     * @param stack The current ItemStack that is in the hand of player.
     * @param context Tooltip context class handles the current tooltip.
     * @param tooltip The tooltip text, it is multi-line so calling tooltip.add will add another line.
     * @param type The type of tooltip that is being displayed.
     */
    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        tooltip.add(Text.translatable("tooltip.custom_item_tutorial.custom_item"));
        super.appendTooltip(stack, context, tooltip, type);
    }
}
