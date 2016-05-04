package net.hycrafthd.youtubetut.util;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.block.state.pattern.BlockMatcher;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenMinable;

public class GenerationUtil {

	public static void generateOre(IBlockState state, Random random, int x, int z, World world, int chance, int minY, int maxY, int minVienSize, int maxVienSize) {
		generateOre(state, Blocks.stone, random, x, z, world, chance, minY, maxY, minVienSize, maxVienSize);
	}

	public static void generateOre(IBlockState state, Block blockin, Random random, int x, int z, World world, int chance, int minY, int maxY, int minVienSize, int maxVienSize) {
		int vienSize = minVienSize + random.nextInt(maxVienSize - minVienSize);
		int hightRange = maxY - minY;

		for (int i = 0; i < chance; i++) {
			int posX = x + random.nextInt(16);
			int posY = random.nextInt(hightRange) + minY;
			int posZ = z + random.nextInt(16);
			new WorldGenMinable(state, vienSize, BlockMatcher.forBlock(blockin)).generate(world, random, new BlockPos(posX, posY, posZ));
		}
	}

}
