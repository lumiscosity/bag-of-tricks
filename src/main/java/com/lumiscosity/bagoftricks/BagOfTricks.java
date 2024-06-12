package com.lumiscosity.bagoftricks;

import com.lumiscosity.bagoftricks.blocks.RegisterBlocks;
import com.lumiscosity.bagoftricks.items.RegisterItems;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BagOfTricks implements ModInitializer {
    public static final Logger LOGGER = LoggerFactory.getLogger("bagoftricks");

	@Override
	public void onInitialize() {
		RegisterBlocks.initBlocks();
		RegisterItems.initItems();

		LOGGER.info("Bag of Tricks registered successfully!");
	}
}