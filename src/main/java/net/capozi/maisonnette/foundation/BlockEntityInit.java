package net.capozi.maisonnette.foundation;

import net.capozi.maisonnette.Maisonnette;
import net.capozi.maisonnette.common.block.entity.HangingFlowerPotBlockEntity;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class BlockEntityInit {
    public static void init() {}

    public static final BlockEntityType<HangingFlowerPotBlockEntity> HANGING_FLOWER_POT = Registry.register(
            Registries.BLOCK_ENTITY_TYPE,
            new Identifier(Maisonnette.MOD_ID, "hanging_flower_pot"),
            FabricBlockEntityTypeBuilder.create(HangingFlowerPotBlockEntity::new, BlockInit.HANGING_FLOWER_POT).build()
    );
}
