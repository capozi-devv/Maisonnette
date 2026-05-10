package net.capozi.maisonnette.foundation;

import net.capozi.maisonnette.Maisonnette;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

public interface SoundInit {
    static void init() {}
    private static SoundEvent registerSoundEvent(String name) {
        Identifier id = new Identifier(Maisonnette.MOD_ID, name);
        return Registry.register(Registries.SOUND_EVENT, id, SoundEvent.of(id));
    }
    SoundEvent BOOK_ADD = registerSoundEvent("book_add");
    SoundEvent BOOK_STACK_BREAK = registerSoundEvent("book_stack_break");
    SoundEvent BOOK_STACK_STEP = registerSoundEvent("book_stack_step");
    SoundEvent BOOK_STACK_PLACE = registerSoundEvent("book_stack_place");
    SoundEvent BOOK_STACK_HIT = registerSoundEvent("book_stack_hit");
    SoundEvent BOOK_STACK_FALL = registerSoundEvent("book_stack_fall");
    BlockSoundGroup BOOK_STACK_SOUNDS = new BlockSoundGroup(1f, 1f, SoundInit.BOOK_STACK_BREAK, SoundInit.BOOK_STACK_STEP, SoundInit.BOOK_STACK_PLACE, SoundInit.BOOK_STACK_HIT, SoundInit.BOOK_STACK_FALL);
}
