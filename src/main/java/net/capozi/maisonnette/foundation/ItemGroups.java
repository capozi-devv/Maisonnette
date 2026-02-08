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
                        entries.add(BlockInit.CALCITE_STAIRS);
                        entries.add(BlockInit.CALCITE_SLAB);
                        entries.add(BlockInit.CALCITE_WALL);
                        entries.add(BlockInit.CALCITE_BUTTON);
                        entries.add(BlockInit.TUFF_STAIRS);
                        entries.add(BlockInit.TUFF_SLAB);
                        entries.add(BlockInit.TUFF_WALL);
                        entries.add(BlockInit.TUFF_BUTTON);
                        entries.add(Items.BOOK);
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
                        entries.add(BlockInit.RED_WILLOW_LEAVES);
                        entries.add(BlockInit.ORANGE_WILLOW_LEAVES);
                        entries.add(BlockInit.YELLOW_WILLOW_LEAVES);
                        entries.add(BlockInit.RED_WILLOW_SAPLING);
                        entries.add(BlockInit.ORANGE_WILLOW_SAPLING);
                        entries.add(BlockInit.YELLOW_WILLOW_SAPLING);
                        entries.add(BlockInit.WILLOW_LOG);
                        entries.add(BlockInit.WILLOW_WOOD);
                        entries.add(BlockInit.STRIPPED_WILLOW_LOG);
                        entries.add(BlockInit.STRIPPED_WILLOW_WOOD);
                        entries.add(BlockInit.WILLOW_PLANKS);
                        entries.add(BlockInit.WILLOW_STAIRS);
                        entries.add(BlockInit.WILLOW_SLAB);
                        entries.add(BlockInit.WILLOW_FENCE);
                        entries.add(BlockInit.WILLOW_FENCE_GATE);
                        entries.add(BlockInit.WILLOW_DOOR);
                        entries.add(BlockInit.WILLOW_TRAPDOOR);
                        entries.add(BlockInit.WILLOW_PRESSURE_PLATE);
                        entries.add(BlockInit.WILLOW_BUTTON);
                        entries.add(BlockInit.CHARRED_LOG);
                        entries.add(BlockInit.CHARRED_WOOD);
                        entries.add(BlockInit.STRIPPED_CHARRED_LOG);
                        entries.add(BlockInit.STRIPPED_CHARRED_WOOD);
                        entries.add(BlockInit.CHARRED_PLANKS);
                        entries.add(BlockInit.CHARRED_STAIRS);
                        entries.add(BlockInit.CHARRED_SLAB);
                        entries.add(BlockInit.CHARRED_FENCE);
                        entries.add(BlockInit.CHARRED_FENCE_GATE);
                        entries.add(BlockInit.CHARRED_DOOR);
                        entries.add(BlockInit.CHARRED_TRAPDOOR);
                        entries.add(BlockInit.CHARRED_PRESSURE_PLATE);
                        entries.add(BlockInit.CHARRED_BUTTON);
                        entries.add(BlockInit.WAXED_COPPER_TORCHBULB);
                        entries.add(BlockInit.WAXED_EXPOSED_COPPER_TORCHBULB);
                        entries.add(BlockInit.WAXED_WEATHERED_COPPER_TORCHBULB);
                        entries.add(BlockInit.WAXED_OXIDIZED_COPPER_TORCHBULB);
                    }).build());
    public static void init() {}
}
