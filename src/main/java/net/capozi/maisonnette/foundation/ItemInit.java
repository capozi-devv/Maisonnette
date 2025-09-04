package net.capozi.maisonnette.foundation;

import net.capozi.maisonnette.Maisonnette;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ItemInit {
    public static void init() {}
    private static Item registerItems(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(Maisonnette.MOD_ID, name), item);
    }
}
