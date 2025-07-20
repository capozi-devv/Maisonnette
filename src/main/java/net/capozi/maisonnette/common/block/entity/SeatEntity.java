package net.capozi.maisonnette.common.block.entity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class SeatEntity extends Entity {
    public SeatEntity(EntityType<?> type, World world, BlockPos pos) {
        super(type, world);
    }
    @Override
    protected void initDataTracker() {}
    @Override
    protected void readCustomDataFromNbt(NbtCompound nbt) {}
    @Override
    protected void writeCustomDataToNbt(NbtCompound nbt) {}
    @Override
    public boolean isCollidable() { return true; }
    @Override
    public boolean hasPassenger(Entity passenger) { return super.hasPassenger(passenger); }
    @Override
    public boolean isInvisible() { return true; }
    @Override
    public boolean isInvulnerable() { return true; }
    @Override
    public boolean doesNotCollide(double offsetX, double offsetY, double offsetZ) { return true; }
}
