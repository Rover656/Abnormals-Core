package com.teamabnormals.abnormals_core.core.util.registry;

import net.minecraft.util.SoundEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

/**
 * A basic {@link AbstractSubRegistryHelper} for sounds. This contains some useful registering methods for sounds.
 * @see AbstractSubRegistryHelper
 * @author SmellyModder (Luke Tonon)
 */
public class SoundSubRegistryHelper extends AbstractSubRegistryHelper<SoundEvent> {

	public SoundSubRegistryHelper(RegistryHelper parent, DeferredRegister<SoundEvent> deferredRegister) {
		super(parent, deferredRegister);
	}

	public SoundSubRegistryHelper(RegistryHelper parent) {
		super(parent, DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, parent.getModId()));
	}

	/**
	 * Creates and registers a {@link SoundEvent}.
	 * @param name - The sound's name.
	 * @return A {@link RegistryObject} containing the created {@link SoundEvent}.
	 */
	public RegistryObject<SoundEvent> createSoundEvent(String name) {
		return this.deferredRegister.register(name, () -> new SoundEvent(this.parent.prefix(name)));
	}

}
