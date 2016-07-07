package net.hycrafthd.youtubetut.block;

import net.hycrafthd.youtubetut.TutorialMod;
import net.hycrafthd.youtubetut.handler.TutorialGuiHandler;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlockTut2 extends Block {

	public BlockTut2() {
		super(Material.rock);
	}
	
	@Override
	public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, ItemStack heldItem, EnumFacing side, float hitX, float hitY, float hitZ) {
		player.openGui(TutorialMod.INSTANCE, TutorialGuiHandler.TUTGUIID, world, pos.getX(), pos.getY(), pos.getZ());
		return super.onBlockActivated(world, pos, state, player, hand, heldItem, side, hitX, hitY, hitZ);
	}
}
