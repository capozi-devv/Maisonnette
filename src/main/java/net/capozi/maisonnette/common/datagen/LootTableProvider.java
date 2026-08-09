package net.capozi.maisonnette.common.datagen;

import net.capozi.maisonnette.foundation.BlockInit;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.block.Block;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Items;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.condition.TableBonusLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.entry.LeafEntry;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;

public class LootTableProvider extends FabricBlockLootTableProvider {
    public LootTableProvider(FabricDataOutput dataOutput) { super(dataOutput); }
    public LootTable.Builder yellowWillowLeavesDrops(Block leaves, Block drop, float... chance) {
        return this.leavesDrops(leaves, drop, chance).pool(LootPool.builder().rolls(ConstantLootNumberProvider.create(1.0F)).conditionally(WITHOUT_SILK_TOUCH_NOR_SHEARS).with(((LeafEntry.Builder)this.addSurvivesExplosionCondition(leaves, ItemEntry.builder(Items.GOLDEN_APPLE))).conditionally(TableBonusLootCondition.builder(Enchantments.FORTUNE, new float[]{0.05F, 0.055555557F, 0.0625F, 0.08333334F, 0.025F}))));
    }
    @Override
    public void generate() {
        addDrop(BlockInit.CALCITE_STAIRS);
        addDrop(BlockInit.CALCITE_SLAB, slabDrops(BlockInit.CALCITE_SLAB));
        addDrop(BlockInit.CALCITE_BUTTON);
        addDrop(BlockInit.CALCITE_WALL);
        addDrop(BlockInit.TUFF_STAIRS);
        addDrop(BlockInit.TUFF_BUTTON);
        addDrop(BlockInit.TUFF_SLAB, slabDrops(BlockInit.TUFF_SLAB));
        addDrop(BlockInit.TUFF_WALL);
        addDrop(BlockInit.COPPER_TORCHBULB);
        addDrop(BlockInit.EXPOSED_COPPER_TORCHBULB);
        addDrop(BlockInit.WAXED_COPPER_TORCHBULB);
        addDrop(BlockInit.OXIDIZED_COPPER_TORCHBULB);
        addDrop(BlockInit.WAXED_EXPOSED_COPPER_TORCHBULB);
        addDrop(BlockInit.BLACK_SEAT);
        addDrop(BlockInit.BLUE_SEAT);
        addDrop(BlockInit.BROWN_SEAT);
        addDrop(BlockInit.CYAN_SEAT);
        addDrop(BlockInit.GRAY_SEAT);
        addDrop(BlockInit.GREEN_SEAT);
        addDrop(BlockInit.LIGHT_BLUE_SEAT);
        addDrop(BlockInit.LIGHT_GRAY_SEAT);
        addDrop(BlockInit.LIME_SEAT);
        addDrop(BlockInit.MAGENTA_SEAT);
        addDrop(BlockInit.PINK_SEAT);
        addDrop(BlockInit.ORANGE_SEAT);
        addDrop(BlockInit.RED_SEAT);
        addDrop(BlockInit.WHITE_SEAT);
        addDrop(BlockInit.YELLOW_SEAT);
        addDrop(BlockInit.WILLOW_WOOD);
        addDrop(BlockInit.WILLOW_LOG);
        addDrop(BlockInit.WILLOW_PLANKS);
        addDrop(BlockInit.STRIPPED_WILLOW_WOOD);
        addDrop(BlockInit.STRIPPED_WILLOW_LOG);
        addDrop(BlockInit.RED_WILLOW_LEAVES, oakLeavesDrops(BlockInit.RED_WILLOW_LEAVES, BlockInit.RED_WILLOW_SAPLING, 0.2f));
        addDrop(BlockInit.ORANGE_WILLOW_LEAVES, oakLeavesDrops(BlockInit.ORANGE_WILLOW_LEAVES, BlockInit.ORANGE_WILLOW_SAPLING, 0.2f));
        addDrop(BlockInit.YELLOW_WILLOW_LEAVES, yellowWillowLeavesDrops(BlockInit.YELLOW_WILLOW_LEAVES, BlockInit.YELLOW_WILLOW_LEAVES, 0.2f));
        addDrop(BlockInit.RED_WILLOW_SAPLING);
        addDrop(BlockInit.ORANGE_WILLOW_SAPLING);
        addDrop(BlockInit.YELLOW_WILLOW_SAPLING);
        addDrop(BlockInit.WILLOW_STAIRS);
        addDrop(BlockInit.WILLOW_SLAB, slabDrops(BlockInit.WILLOW_SLAB));
        addDrop(BlockInit.WILLOW_FENCE);
        addDrop(BlockInit.WILLOW_FENCE_GATE);
        addDrop(BlockInit.WILLOW_DOOR, doorDrops(BlockInit.WILLOW_DOOR));
        addDrop(BlockInit.WILLOW_TRAPDOOR);
        addDrop(BlockInit.WILLOW_PRESSURE_PLATE);
        addDrop(BlockInit.WILLOW_BUTTON);
        addDrop(BlockInit.CHARRED_STAIRS);
        addDrop(BlockInit.CHARRED_SLAB, slabDrops(BlockInit.CHARRED_SLAB));
        addDrop(BlockInit.CHARRED_FENCE);
        addDrop(BlockInit.CHARRED_FENCE_GATE);
        addDrop(BlockInit.CHARRED_DOOR, doorDrops(BlockInit.CHARRED_DOOR));
        addDrop(BlockInit.CHARRED_TRAPDOOR);
        addDrop(BlockInit.CHARRED_PRESSURE_PLATE);
        addDrop(BlockInit.CHARRED_BUTTON);
        addDrop(BlockInit.CHARRED_WOOD);
        addDrop(BlockInit.CHARRED_LOG);
        addDrop(BlockInit.CHARRED_PLANKS);
        addDrop(BlockInit.STRIPPED_CHARRED_WOOD);
        addDrop(BlockInit.STRIPPED_CHARRED_LOG);
        addDrop(BlockInit.CARNATION);
        addDrop(BlockInit.COLOSSAL_HIBISCUS);
        addDrop(BlockInit.COLOSSAL_HIBISCUS_BLOOMLING);
        addDrop(BlockInit.BLACK_STARLETTE);
        addDrop(BlockInit.ORANGE_STARLETTE);
        addDrop(BlockInit.YELLOW_STARLETTE);
        addDrop(BlockInit.DELPHINIUM_FLOWER);
        addDrop(BlockInit.BLACK_GLADIOLUS);
        addDrop(BlockInit.WHITE_GLADIOLUS);
        addDrop(BlockInit.POTTED_BLACK_STARLETTE, pottedPlantDrops(BlockInit.POTTED_BLACK_STARLETTE));
        addDrop(BlockInit.POTTED_ORANGE_STARLETTE, pottedPlantDrops(BlockInit.POTTED_ORANGE_STARLETTE));
        addDrop(BlockInit.POTTED_YELLOW_STARLETTE, pottedPlantDrops(BlockInit.POTTED_YELLOW_STARLETTE));
        addDrop(BlockInit.POTTED_CARNATION, pottedPlantDrops(BlockInit.POTTED_CARNATION));
        addDrop(BlockInit.POTTED_COLOSSAL_HIBISCUS_BLOOMLING, pottedPlantDrops(BlockInit.POTTED_COLOSSAL_HIBISCUS_BLOOMLING));
        addDrop(BlockInit.POTTED_RED_WILLOW_SAPLING, pottedPlantDrops(BlockInit.POTTED_RED_WILLOW_SAPLING));
        addDrop(BlockInit.POTTED_ORANGE_WILLOW_SAPLING, pottedPlantDrops(BlockInit.POTTED_ORANGE_WILLOW_SAPLING));
        addDrop(BlockInit.POTTED_YELLOW_WILLOW_SAPLING, pottedPlantDrops(BlockInit.POTTED_YELLOW_WILLOW_SAPLING));
        addDropWithSilkTouch(BlockInit.GREENHOUSE_GLASS);
        addDropWithSilkTouch(BlockInit.WIRED_GREENHOUSE_GLASS);
        addDrop(BlockInit.WROUGHT_IRON_GATE, doorDrops(BlockInit.WROUGHT_IRON_GATE));
        addDrop(BlockInit.WROUGHT_IRON_BARS, doorDrops(BlockInit.WROUGHT_IRON_BARS));
    }
}
