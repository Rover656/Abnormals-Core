package com.teamabnormals.abnormals_core.common.world.storage;

import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.ResourceLocation;

import java.util.HashMap;
import java.util.Map;

/**
 * Implemented on types that will store global NBT data for a Minecraft Save.
 * This interface should only be used on the server side.
 * This main purpose of this interface is for storing global data for a Minecraft Save.
 *
 * @see net.minecraft.world.storage.WorldSavedData
 * @author SmellyModder (Luke Tonon)
 */
public interface GlobalStorage {
	Map<ResourceLocation, GlobalStorage> STORAGES = new HashMap<>();

	/**
	 * Adds a {@link GlobalStorage} to the {@link #STORAGES} map and returns the {@link GlobalStorage}.
	 * Use this to have your {@link GlobalStorage} be saved and loaded.
	 * @param key - The id of the storage.
	 * @param storage - The {@link GlobalStorage} to add to the {@link #STORAGES} map.
	 * @param <S> - The type of {@link GlobalStorage}.
	 * @throws IllegalStateException if the storage is created after {@link GlobalStorageManager} has loaded its NBT.
	 * @return - The supplied {@link GlobalStorage}.
	 */
	static <S extends GlobalStorage> S createStorage(ResourceLocation key, S storage) {
		if (GlobalStorageManager.isLoaded()) {
			throw new IllegalStateException(String.format("Global Storage with id %s was created after Global Storage Manager loaded!", key));
		}
		STORAGES.put(key, storage);
		return storage;
	}

	/**
	 * Called when saving this {@link GlobalStorage} to NBT.
	 * @return - The serialized NBT data of this {@link GlobalStorage}.
	 */
	CompoundNBT toTag();

	/**
	 * Called when loading the saved NBT data for this {@link GlobalStorage}.
	 * @param tag - The deserialized NBT data of this {@link GlobalStorage}.
	 */
	void fromTag(CompoundNBT tag);
}
