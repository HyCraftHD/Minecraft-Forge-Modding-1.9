package net.hycrafthd.youtubetut.creativetab;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;

public class CreativeTabTut extends CreativeTabs {

	public CreativeTabTut() {
		super("tuttab");
		this.setBackgroundImageName("item_search.png");
	}

	@Override
	public Item getTabIconItem() {
		return Items.golden_apple;
	}
	
	@Override
	public boolean hasSearchBar() {
		return true;
	}

}
