package net.hycrafthd.youtubetut.world;

import java.util.Random;

import net.hycrafthd.youtubetut.TutorialBlocks;
import net.hycrafthd.youtubetut.util.GenerationUtil;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.chunk.*;
import net.minecraftforge.fml.common.IWorldGenerator;

public class TutorialWorldgeneration implements IWorldGenerator {

	private void nether(Random random, int x, int z, World world) {
		GenerationUtil.generateOre(TutorialBlocks.tutblock.getDefaultState(), Blocks.netherrack, random, x, z, world, 40, 0, 120, 1, 10);
	}

	private void overworld(Random random, int x, int z, World world) {
		GenerationUtil.generateOre(TutorialBlocks.tutblock.getDefaultState(), random, x, z, world, 20, 10, 64, 5, 10);
		GenerationUtil.generateOre(Blocks.glass.getDefaultState(), Blocks.air, random, x, z, world, 40, 100, 120, 1, 10);
	}

	private void end(Random random, int x, int z, World world) {

	}

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {
		int x = chunkX * 16;
		int z = chunkZ * 16;
		switch (world.provider.getDimension()) {
		case -1:
			nether(random, x, z, world);
			break;
		case 0:
			overworld(random, x, z, world);
			break;
		case 1:
			end(random, x, z, world);
			break;
		}
	}

}
