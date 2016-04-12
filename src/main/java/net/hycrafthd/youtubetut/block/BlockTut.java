package net.hycrafthd.youtubetut.block;

import java.util.Random;

import net.hycrafthd.youtubetut.TutorialItems;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityAreaEffectCloud;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.MobEffects;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
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

	@Override
	public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, ItemStack heldItem, EnumFacing side, float hitX, float hitY, float hitZ) {
		if (!world.isRemote) {
			world.setBlockState(pos.add(0, 20, 0), Blocks.anvil.getDefaultState());
			EntityAreaEffectCloud effects = new EntityAreaEffectCloud(world, pos.getX(), pos.getY(), pos.getZ());
			effects.addEffect(new PotionEffect(MobEffects.levitation, 300, 10));
			effects.addEffect(new PotionEffect(MobEffects.resistance, 500, 4));
			effects.setColor(0xe67e22);
			effects.setRadius(5.0F);
			effects.setDuration(1000);
			effects.setWaitTime(40);
			world.spawnEntityInWorld(effects);
			world.setBlockToAir(pos);
			return true;
		}
		return super.onBlockActivated(world, pos, state, playerIn, hand, heldItem, side, hitX, hitY, hitZ);
	}

}
