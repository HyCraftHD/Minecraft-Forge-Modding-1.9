package net.hycrafthd.youtubetut.item;

import net.hycrafthd.youtubetut.entity.EntityTutGrenade;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.world.World;

public class ItemTutGrenade extends Item {

	public ItemTutGrenade() {
		super();
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn, EnumHand hand) {
		if (!playerIn.capabilities.isCreativeMode) {
			itemStackIn.stackSize--;
		}

		worldIn.playSound(playerIn, playerIn.getPosition(), SoundEvents.block_note_snare, SoundCategory.PLAYERS, 1.0F, 0.1F);

		if (!worldIn.isRemote) {
			EntityTutGrenade grenade = new EntityTutGrenade(worldIn, playerIn);
			grenade.func_184538_a(playerIn, playerIn.rotationPitch, playerIn.rotationYaw, 0.0F, 0.5F + (float) Math.random() * 2, 1.0F);
			worldIn.spawnEntityInWorld(grenade);
		}

		return super.onItemRightClick(itemStackIn, worldIn, playerIn, hand);
	}

}
