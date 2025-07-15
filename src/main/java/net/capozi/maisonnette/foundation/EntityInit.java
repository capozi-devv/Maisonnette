package net.capozi.maisonnette.foundation;

import net.capozi.maisonnette.Maisonnette;
import net.capozi.maisonnette.common.entity.custom.SpecterEntity;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class EntityInit {

	public static final EntityType<SpecterEntity> SPECTER = Registry.register(Registries.ENTITY_TYPE,
			new Identifier(Maisonnette.MOD_ID, "specter"),
			FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, SpecterEntity::new)
					.dimensions(EntityDimensions.fixed(0.25f, 0.25f)).build());

	public static void init() {
	}
}
