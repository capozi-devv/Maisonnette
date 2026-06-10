package net.capozi.maisonnette.common.block.entity;

import net.capozi.maisonnette.foundation.BlockEntityInit;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.FlowerPotBlock;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.s2c.play.BlockEntityUpdateS2CPacket;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.item.ItemStack;
import org.jetbrains.annotations.Nullable;

public class HangingFlowerPotBlockEntity extends BlockEntity {
    private Block pottedBlock = Blocks.AIR;

    public HangingFlowerPotBlockEntity(BlockPos pos, BlockState state) {
        super(BlockEntityInit.HANGING_FLOWER_POT, pos, state);
    }

    public boolean isEmpty() {
        return pottedBlock == Blocks.AIR;
    }

    public Block getPottedBlock() {
        return pottedBlock;
    }

    public void setPottedBlock(Block block) {
        pottedBlock = block;
        update();
    }

    public ItemStack getContentStack() {
        if (pottedBlock instanceof FlowerPotBlock flowerPotBlock) {
            return flowerPotBlock.getContent().asItem().getDefaultStack();
        }
        return ItemStack.EMPTY;
    }

    public void clear() {
        pottedBlock = Blocks.AIR;
        update();
    }

    private void update() {
        markDirty();
        if (world != null) {
            world.updateListeners(pos, getCachedState(), getCachedState(), Block.NOTIFY_ALL);
        }
    }

    @Override
    protected void writeNbt(NbtCompound nbt) {
        super.writeNbt(nbt);
        nbt.putString("PottedBlock", Registries.BLOCK.getId(pottedBlock).toString());
    }

    @Override
    public void readNbt(NbtCompound nbt) {
        super.readNbt(nbt);
        Identifier id = Identifier.tryParse(nbt.getString("PottedBlock"));
        pottedBlock = id == null ? Blocks.AIR : Registries.BLOCK.getOrEmpty(id).orElse(Blocks.AIR);
    }

    @Nullable
    @Override
    public Packet<ClientPlayPacketListener> toUpdatePacket() {
        return BlockEntityUpdateS2CPacket.create(this);
    }

    @Override
    public NbtCompound toInitialChunkDataNbt() {
        return createNbt();
    }
}
