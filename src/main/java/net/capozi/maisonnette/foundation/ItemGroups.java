package net.capozi.maisonnette.foundation;

import net.capozi.maisonnette.Maisonnette;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ItemGroups {
    public static final ItemGroup MAISONNETTE_GROUP = Registry.register(Registries.ITEM_GROUP,
            new Identifier(Maisonnette.MOD_ID, "maisonnette"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.maisonnette"))
                    .icon(() -> new ItemStack(Items.ENCHANTED_BOOK)).entries((displayContext, entries) -> {
                        entries.add(BlockInit.CALCITE_BRICKS);
                        entries.add(BlockInit.CHISELED_CALCITE);
                        entries.add(BlockInit.CALCITE_STAIRS);
                        entries.add(BlockInit.CALCITE_SLAB);
                        entries.add(BlockInit.CALCITE_WALL);
                        entries.add(BlockInit.CALCITE_BUTTON);
                        entries.add(BlockInit.TUFF_BRICKS);
                        entries.add(BlockInit.TUFF_STAIRS);
                        entries.add(BlockInit.TUFF_SLAB);
                        entries.add(BlockInit.TUFF_WALL);
                        entries.add(BlockInit.TUFF_BUTTON);
                        entries.add(Items.BOOK);
                        entries.add(ItemInit.SPIRIT_ORB);
                        entries.add(BlockInit.COPPER_TORCHBULB);
                        entries.add(BlockInit.EXPOSED_COPPER_TORCHBULB);
                        entries.add(BlockInit.WEATHERED_COPPER_TORCHBULB);
                        entries.add(BlockInit.OXIDIZED_COPPER_TORCHBULB);
                        entries.add(BlockInit.WHITE_SEAT);
                        entries.add(BlockInit.ORANGE_SEAT);
                        entries.add(BlockInit.MAGENTA_SEAT);
                        entries.add(BlockInit.LIGHT_BLUE_SEAT);
                        entries.add(BlockInit.YELLOW_SEAT);
                        entries.add(BlockInit.LIME_SEAT);
                        entries.add(BlockInit.PINK_SEAT);
                        entries.add(BlockInit.GRAY_SEAT);
                        entries.add(BlockInit.LIGHT_GRAY_SEAT);
                        entries.add(BlockInit.CYAN_SEAT);
                        entries.add(BlockInit.PURPLE_SEAT);
                        entries.add(BlockInit.BLUE_SEAT);
                        entries.add(BlockInit.BROWN_SEAT);
                        entries.add(BlockInit.GREEN_SEAT);
                        entries.add(BlockInit.RED_SEAT);
                        entries.add(BlockInit.BLACK_SEAT);
                        entries.add(BlockInit.MOSAIC);
                    }).build());
    public static void init() {

    }
}
