package net.capozi.maisonnette.common.loot;

import net.capozi.maisonnette.Maisonnette;
import net.capozi.maisonnette.foundation.BlockInit;
import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.util.Identifier;

public class SnifferDiggingLoot {
    private static final Identifier SNIFFER_DIGGING = new Identifier("minecraft", "gameplay/sniffer_digging");

    public static void register() {
        LootTableEvents.MODIFY.register((resourceManager, lootManager, id, tableBuilder, source) -> {
            if (source.isBuiltin() && SNIFFER_DIGGING.equals(id)) {
                tableBuilder.pool(LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1.0F))
                        .with(ItemEntry.builder(BlockInit.COLOSSAL_HIBISCUS_BLOOMLING)));
            }
        });
    }
}
