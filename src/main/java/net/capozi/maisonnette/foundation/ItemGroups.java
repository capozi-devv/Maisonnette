package net.capozi.maisonnette.foundation;

import net.capozi.maisonnette.Maisonnette;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.block.Blocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ItemGroups {
//    public static final ItemGroup MAISONNETTE_GROUP = Registry.register(Registries.ITEM_GROUP,
//            new Identifier(Maisonnette.MOD_ID, "maisonnette"),
//            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.maisonnette"))
//                    .icon(() -> new ItemStack(BlockInit.COPPER_TORCHBULB)).entries((displayContext, entries) -> {
//                        entries.add(BlockInit.CALCITE_STAIRS);
//                        entries.add(BlockInit.CALCITE_SLAB);
//                        entries.add(BlockInit.CALCITE_WALL);
//                        entries.add(BlockInit.CALCITE_BUTTON);
//                        entries.add(BlockInit.TUFF_STAIRS);
//                        entries.add(BlockInit.TUFF_SLAB);
//                        entries.add(BlockInit.TUFF_WALL);
//                        entries.add(BlockInit.TUFF_BUTTON);
//                        entries.add(Items.BOOK);
//                        entries.add(BlockInit.CARNATION);
//                        entries.add(BlockInit.COLOSSAL_HIBISCUS);
//                        entries.add(BlockInit.COLOSSAL_HIBISCUS_BLOOMLING);
//                        entries.add(BlockInit.BLACK_STARLETTE);
//                        entries.add(BlockInit.ORANGE_STARLETTE);
//                        entries.add(BlockInit.YELLOW_STARLETTE);
//                        entries.add(BlockInit.DELPHINIUM_FLOWER);
//                        entries.add(BlockInit.WHITE_GLADIOLUS);
//                        entries.add(BlockInit.BLACK_GLADIOLUS);
//                        entries.add(BlockInit.HANGING_FLOWER_POT);
//                        entries.add(BlockInit.COPPER_TORCHBULB);
//                        entries.add(BlockInit.EXPOSED_COPPER_TORCHBULB);
//                        entries.add(BlockInit.WEATHERED_COPPER_TORCHBULB);
//                        entries.add(BlockInit.OXIDIZED_COPPER_TORCHBULB);
//                        entries.add(BlockInit.WHITE_SEAT);
//                        entries.add(BlockInit.ORANGE_SEAT);
//                        entries.add(BlockInit.MAGENTA_SEAT);
//                        entries.add(BlockInit.LIGHT_BLUE_SEAT);
//                        entries.add(BlockInit.YELLOW_SEAT);
//                        entries.add(BlockInit.LIME_SEAT);
//                        entries.add(BlockInit.PINK_SEAT);
//                        entries.add(BlockInit.GRAY_SEAT);
//                        entries.add(BlockInit.LIGHT_GRAY_SEAT);
//                        entries.add(BlockInit.CYAN_SEAT);
//                        entries.add(BlockInit.PURPLE_SEAT);
//                        entries.add(BlockInit.BLUE_SEAT);
//                        entries.add(BlockInit.BROWN_SEAT);
//                        entries.add(BlockInit.GREEN_SEAT);
//                        entries.add(BlockInit.RED_SEAT);
//                        entries.add(BlockInit.BLACK_SEAT);
//                        entries.add(BlockInit.GREENHOUSE_GLASS);
//                        entries.add(BlockInit.ORANGE_STAINED_GREENHOUSE_GLASS);
//                        entries.add(BlockInit.MAGENTA_STAINED_GREENHOUSE_GLASS);
//                        entries.add(BlockInit.LIGHT_BLUE_STAINED_GREENHOUSE_GLASS);
//                        entries.add(BlockInit.YELLOW_STAINED_GREENHOUSE_GLASS);
//                        entries.add(BlockInit.LIME_STAINED_GREENHOUSE_GLASS);
//                        entries.add(BlockInit.PINK_STAINED_GREENHOUSE_GLASS);
//                        entries.add(BlockInit.GRAY_STAINED_GREENHOUSE_GLASS);
//                        entries.add(BlockInit.LIGHT_GRAY_STAINED_GREENHOUSE_GLASS);
//                        entries.add(BlockInit.CYAN_STAINED_GREENHOUSE_GLASS);
//                        entries.add(BlockInit.PURPLE_STAINED_GREENHOUSE_GLASS);
//                        entries.add(BlockInit.BLUE_STAINED_GREENHOUSE_GLASS);
//                        entries.add(BlockInit.BROWN_STAINED_GREENHOUSE_GLASS);
//                        entries.add(BlockInit.GREEN_STAINED_GREENHOUSE_GLASS);
//                        entries.add(BlockInit.RED_STAINED_GREENHOUSE_GLASS);
//                        entries.add(BlockInit.BLACK_STAINED_GREENHOUSE_GLASS);
//                        entries.add(BlockInit.RED_WILLOW_LEAVES);
//                        entries.add(BlockInit.ORANGE_WILLOW_LEAVES);
//                        entries.add(BlockInit.YELLOW_WILLOW_LEAVES);
//                        entries.add(BlockInit.RED_WILLOW_SAPLING);
//                        entries.add(BlockInit.ORANGE_WILLOW_SAPLING);
//                        entries.add(BlockInit.YELLOW_WILLOW_SAPLING);
//                        entries.add(BlockInit.WILLOW_LOG);
//                        entries.add(BlockInit.WILLOW_WOOD);
//                        entries.add(BlockInit.STRIPPED_WILLOW_LOG);
//                        entries.add(BlockInit.STRIPPED_WILLOW_WOOD);
//                        entries.add(BlockInit.WILLOW_PLANKS);
//                        entries.add(BlockInit.WILLOW_STAIRS);
//                        entries.add(BlockInit.WILLOW_SLAB);
//                        entries.add(BlockInit.WILLOW_FENCE);
//                        entries.add(BlockInit.WILLOW_FENCE_GATE);
//                        entries.add(BlockInit.WILLOW_DOOR);
//                        entries.add(BlockInit.WILLOW_TRAPDOOR);
//                        entries.add(BlockInit.WILLOW_PRESSURE_PLATE);
//                        entries.add(BlockInit.WILLOW_BUTTON);
//                        entries.add(BlockInit.WISTERIA_LEAVES);
//                        entries.add(BlockInit.WISTERIA_SAPLING);
//                        entries.add(BlockInit.WISTERIA_LOG);
//                        entries.add(BlockInit.WISTERIA_WOOD);
//                        entries.add(BlockInit.STRIPPED_WISTERIA_LOG);
//                        entries.add(BlockInit.STRIPPED_WISTERIA_WOOD);
//                        entries.add(BlockInit.WISTERIA_PLANKS);
//                        entries.add(BlockInit.WISTERIA_STAIRS);
//                        entries.add(BlockInit.WISTERIA_SLAB);
//                        entries.add(BlockInit.WISTERIA_FENCE);
//                        entries.add(BlockInit.WISTERIA_FENCE_GATE);
//                        entries.add(BlockInit.WISTERIA_DOOR);
//                        entries.add(BlockInit.WISTERIA_TRAPDOOR);
//                        entries.add(BlockInit.WISTERIA_PRESSURE_PLATE);
//                        entries.add(BlockInit.WISTERIA_BUTTON);
//                        entries.add(BlockInit.CHARRED_LOG);
//                        entries.add(BlockInit.CHARRED_WOOD);
//                        entries.add(BlockInit.STRIPPED_CHARRED_LOG);
//                        entries.add(BlockInit.STRIPPED_CHARRED_WOOD);
//                        entries.add(BlockInit.CHARRED_PLANKS);
//                        entries.add(BlockInit.CHARRED_STAIRS);
//                        entries.add(BlockInit.CHARRED_SLAB);
//                        entries.add(BlockInit.CHARRED_FENCE);
//                        entries.add(BlockInit.CHARRED_FENCE_GATE);
//                        entries.add(BlockInit.CHARRED_DOOR);
//                        entries.add(BlockInit.CHARRED_TRAPDOOR);
//                        entries.add(BlockInit.CHARRED_PRESSURE_PLATE);
//                        entries.add(BlockInit.CHARRED_BUTTON);
//                        entries.add(BlockInit.WROUGHT_IRON_BARS);
//                        entries.add(BlockInit.WROUGHT_IRON_GATE);
//                        entries.add(BlockInit.WAXED_COPPER_TORCHBULB);
//                        entries.add(BlockInit.WAXED_EXPOSED_COPPER_TORCHBULB);
//                        entries.add(BlockInit.WAXED_WEATHERED_COPPER_TORCHBULB);
//                        entries.add(BlockInit.WAXED_OXIDIZED_COPPER_TORCHBULB);
//                    }).build());
    private static Identifier CATEGORY = Maisonnette.identifier("textures/gui/sprites/category.png");
    private static Identifier SLOT = Maisonnette.identifier("textures/gui/sprites/slot.png");
    public static final ItemGroup MAISONNETTE = Maisonnette.MOD.tabBuilder(Maisonnette.MOD_ID)
            .icon(BlockInit.COPPER_TORCHBULB)
            .searchBar()
            .category("maisonnette", Text.translatable("itemgroup.maisonnette"), (category) -> {
                category.alignCenter();
                category.backgroundTexture(CATEGORY);
                category.textColor("#b3a3a3");
                category.noBorder();
                category.add(
                        BlockInit.CALCITE_STAIRS,
                        BlockInit.CALCITE_SLAB,
                        BlockInit.CALCITE_WALL,
                        BlockInit.CALCITE_BUTTON,
                        BlockInit.TUFF_STAIRS,
                        BlockInit.TUFF_SLAB,
                        BlockInit.TUFF_WALL,
                        BlockInit.TUFF_BUTTON,
                        Items.BOOK,
                        BlockInit.COPPER_TORCHBULB,
                        BlockInit.EXPOSED_COPPER_TORCHBULB,
                        BlockInit.WEATHERED_COPPER_TORCHBULB,
                        BlockInit.OXIDIZED_COPPER_TORCHBULB,
                        BlockInit.WHITE_SEAT,
                        BlockInit.ORANGE_SEAT,
                        BlockInit.MAGENTA_SEAT,
                        BlockInit.LIGHT_BLUE_SEAT,
                        BlockInit.YELLOW_SEAT,
                        BlockInit.LIME_SEAT,
                        BlockInit.PINK_SEAT,
                        BlockInit.GRAY_SEAT,
                        BlockInit.LIGHT_GRAY_SEAT,
                        BlockInit.CYAN_SEAT,
                        BlockInit.PURPLE_SEAT,
                        BlockInit.BLUE_SEAT,
                        BlockInit.BROWN_SEAT,
                        BlockInit.GREEN_SEAT,
                        BlockInit.RED_SEAT,
                        BlockInit.BLACK_SEAT,
                        BlockInit.WAXED_COPPER_TORCHBULB,
                        BlockInit.WAXED_EXPOSED_COPPER_TORCHBULB,
                        BlockInit.WAXED_WEATHERED_COPPER_TORCHBULB,
                        BlockInit.WAXED_OXIDIZED_COPPER_TORCHBULB
                ).emptyRow();
            })
            .category("wonderous_wards", Text.translatable("itemgroup.maisonnette.wonderous_wards"), (category) -> {
                category.alignCenter();
                category.backgroundTexture(CATEGORY);
                category.textColor("#b3a3a3");
                category.noBorder();
                category.add(
                        BlockInit.RED_WILLOW_LEAVES,
                        BlockInit.ORANGE_WILLOW_LEAVES,
                        BlockInit.YELLOW_WILLOW_LEAVES,
                        BlockInit.RED_WILLOW_SAPLING,
                        BlockInit.ORANGE_WILLOW_SAPLING,
                        BlockInit.YELLOW_WILLOW_SAPLING,
                        BlockInit.WILLOW_LOG,
                        BlockInit.WILLOW_WOOD,
                        BlockInit.STRIPPED_WILLOW_LOG,
                        BlockInit.STRIPPED_WILLOW_WOOD,
                        BlockInit.WILLOW_PLANKS,
                        BlockInit.WILLOW_STAIRS,
                        BlockInit.WILLOW_SLAB,
                        BlockInit.WILLOW_FENCE,
                        BlockInit.WILLOW_FENCE_GATE,
                        BlockInit.WILLOW_DOOR,
                        BlockInit.WILLOW_TRAPDOOR,
                        BlockInit.WILLOW_PRESSURE_PLATE,
                        BlockInit.WILLOW_BUTTON,
                        BlockInit.CHARRED_LOG,
                        BlockInit.CHARRED_WOOD,
                        BlockInit.STRIPPED_CHARRED_LOG,
                        BlockInit.STRIPPED_CHARRED_WOOD,
                        BlockInit.CHARRED_PLANKS,
                        BlockInit.CHARRED_STAIRS,
                        BlockInit.CHARRED_SLAB,
                        BlockInit.CHARRED_FENCE,
                        BlockInit.CHARRED_FENCE_GATE,
                        BlockInit.CHARRED_DOOR,
                        BlockInit.CHARRED_TRAPDOOR,
                        BlockInit.CHARRED_PRESSURE_PLATE,
                        BlockInit.CHARRED_BUTTON
                ).emptyRow();
            })
            .category("botanical_bounties", Text.translatable("itemgroup.maisonnette.botanical_bounties"), (category) -> {
                category.alignCenter();
                category.backgroundTexture(CATEGORY);
                category.textColor("#b3a3a3");
                category.noBorder();
                category.add(
                        BlockInit.CARNATION,
                        BlockInit.COLOSSAL_HIBISCUS,
                        BlockInit.COLOSSAL_HIBISCUS_BLOOMLING,
                        BlockInit.BLACK_STARLETTE,
                        BlockInit.ORANGE_STARLETTE,
                        BlockInit.YELLOW_STARLETTE,
                        BlockInit.DELPHINIUM_FLOWER,
                        BlockInit.WHITE_GLADIOLUS,
                        BlockInit.BLACK_GLADIOLUS,
                        BlockInit.HANGING_FLOWER_POT,
                        BlockInit.GREENHOUSE_GLASS,
                        BlockInit.ORANGE_STAINED_GREENHOUSE_GLASS,
                        BlockInit.MAGENTA_STAINED_GREENHOUSE_GLASS,
                        BlockInit.LIGHT_BLUE_STAINED_GREENHOUSE_GLASS,
                        BlockInit.YELLOW_STAINED_GREENHOUSE_GLASS,
                        BlockInit.LIME_STAINED_GREENHOUSE_GLASS,
                        BlockInit.PINK_STAINED_GREENHOUSE_GLASS,
                        BlockInit.GRAY_STAINED_GREENHOUSE_GLASS,
                        BlockInit.LIGHT_GRAY_STAINED_GREENHOUSE_GLASS,
                        BlockInit.CYAN_STAINED_GREENHOUSE_GLASS,
                        BlockInit.PURPLE_STAINED_GREENHOUSE_GLASS,
                        BlockInit.BLUE_STAINED_GREENHOUSE_GLASS,
                        BlockInit.BROWN_STAINED_GREENHOUSE_GLASS,
                        BlockInit.GREEN_STAINED_GREENHOUSE_GLASS,
                        BlockInit.RED_STAINED_GREENHOUSE_GLASS,
                        BlockInit.BLACK_STAINED_GREENHOUSE_GLASS,
                        BlockInit.WISTERIA_LEAVES,
                        BlockInit.WISTERIA_SAPLING,
                        BlockInit.WISTERIA_LOG,
                        BlockInit.WISTERIA_WOOD,
                        BlockInit.STRIPPED_WISTERIA_LOG,
                        BlockInit.STRIPPED_WISTERIA_WOOD,
                        BlockInit.WISTERIA_PLANKS,
                        BlockInit.WISTERIA_STAIRS,
                        BlockInit.WISTERIA_SLAB,
                        BlockInit.WISTERIA_FENCE,
                        BlockInit.WISTERIA_FENCE_GATE,
                        BlockInit.WISTERIA_DOOR,
                        BlockInit.WISTERIA_TRAPDOOR,
                        BlockInit.WISTERIA_PRESSURE_PLATE,
                        BlockInit.WISTERIA_BUTTON,
                        BlockInit.WROUGHT_IRON_BARS,
                        BlockInit.WROUGHT_IRON_GATE
                );
            }).build();
    public static void init() {}
}
