package net.capozi.maisonnette.foundation;

import net.capozi.maisonnette.Maisonnette;
import net.capozi.maisonnette.common.item.SpiritOrbItem;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ItemInit {
    public static void init() {}
    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(Maisonnette.MOD_ID, name), item);
    }
    public static final Item SPIRIT_ORB = registerItem("spirit_orb", new SpiritOrbItem(new FabricItemSettings().maxCount(1)));
}
