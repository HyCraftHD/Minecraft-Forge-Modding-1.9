package net.hycrafthd.youtubetut.item;

import java.util.Set;

import com.google.common.collect.Sets;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.item.*;
import net.minecraftforge.fml.common.ObfuscationReflectionHelper;

public class ItemAdvancedAxe extends ItemTool {

	private static final Set<Block> EFFECTIVE_ON = Sets.newHashSet(new Block[] { Blocks.planks, Blocks.bookshelf, Blocks.log, Blocks.log2, Blocks.chest, Blocks.pumpkin, Blocks.lit_pumpkin, Blocks.melon_block, Blocks.ladder, Blocks.wooden_button, Blocks.wooden_pressure_plate });

	public ItemAdvancedAxe(ToolMaterial material, float attackSpeed) {
		super(material, EFFECTIVE_ON);
		this.damageVsEntity = material.getDamageVsEntity() + 5.0F;
		this.attackSpeed = attackSpeed;
		ObfuscationReflectionHelper.setPrivateValue(ItemTool.class, this, "axe", "toolClass");
	}

	public float getStrVsBlock(ItemStack stack, IBlockState state) {
		Material material = state.getMaterial();
		return material != Material.wood && material != Material.plants && material != Material.vine ? super.getStrVsBlock(stack, state) : this.efficiencyOnProperMaterial;
	}
}