package net.capozi.maisonnette.common.entity.object;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class SeatEntity extends Entity {
    public SeatEntity(EntityType<?> type, World world) {
        super(type, world);
        this.noClip = true;
    }
    public SeatEntity(EntityType<?> type, World world, BlockPos pos) {
        this(type, world);
        this.setPosition(pos.getX() + 0.5, pos.getY(), pos.getZ() + 0.5);
    }
    @Override
    protected void initDataTracker() {}

    @Override
    protected void readCustomDataFromNbt(NbtCompound nbt) {}

    @Override
    protected void writeCustomDataToNbt(NbtCompound nbt) {}

    @Override
    public void tick() {
        super.tick();
        if (!hasPassengers() && !getWorld().isClient) {
            this.discard();
        }
    }

    @Override
    public ActionResult interact(PlayerEntity player, Hand hand) {
        if (!getWorld().isClient && !player.hasVehicle()) {
            player.startRiding(this);
        }
        return ActionResult.SUCCESS;
    }
    @Override public boolean isInvisible() { return true; }
    @Override public boolean isInvulnerable() { return true; }
    @Override public boolean canHit() { return false; }
    @Override
    public boolean doesNotCollide(double offsetX, double offsetY, double offsetZ) {
        return true;
    }
    @Override public boolean isPushable() { return false; }
    @Override
    public boolean isAttackable() {
        return false;
    }
    @Override
    public boolean hasNoGravity() {
        return true;
    }

}

