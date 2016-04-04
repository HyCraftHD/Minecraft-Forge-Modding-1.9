package net.hycrafthd.youtubetut.block;

import java.util.Random;

import net.hycrafthd.youtubetut.TutorialItems;
import net.minecraft.block.Block;
import net.minecraft.block.BlockOre;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockTut extends Block {

	public BlockTut() {
		super(Material.sand);
		this.setHardness(3.2F);
		this.setResistance(33.333333F);
		this.setStepSound(SoundType.SAND);
		this.setHarvestLevel("shovel", 2);
	}

	@Override
	public int getExpDrop(IBlockState state, IBlockAccess world, BlockPos pos, int fortune) {
		Random rand = world instanceof World ? ((World) world).rand : new Random();
		return MathHelper.getRandomIntegerInRange(rand, 5, 15) + fortune;
	}

	@Override
	public int quantityDropped(IBlockState state, int fortune, Random random) {
		return MathHelper.getRandomIntegerInRange(random, 1, 3 + fortune);
	}

	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune) {
		return TutorialItems.tutitem;
	}

}
