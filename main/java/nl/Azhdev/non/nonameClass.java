package nl.Azhdev.non;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import nl.Azhdev.non.blocks.AzhdevBlocks;
import nl.Azhdev.non.handlers.generationHandler;
import nl.Azhdev.non.items.nonItems;
import nl.Azhdev.non.proxies.commonProxy;
import cpw.mods.fml.common.IWorldGenerator;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;


@Mod(modid = "LL", name = "Lorem Lucis", version = "1.7.10-2.2")
public class nonameClass {
	
	@Instance("LL")
	public static nonameClass instance;
	
	@SidedProxy(clientSide = "nl.Azhdev.non.proxies.ClientProxy", serverSide = "nl.Azhdev.non.proxies.commonProxy")
	public static commonProxy proxy;
	
	IWorldGenerator gen = new generationHandler();
	
	@EventHandler
	public void Preinit(FMLPreInitializationEvent event){
		AzhdevBlocks.initBlocks();
		AzhdevBlocks.intTileEntities();
		nonItems.init();
		proxy.initRendering();
		GameRegistry.registerWorldGenerator(gen, 1);
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event){
		GameRegistry.addRecipe(new ItemStack(nonItems.upgrade), new Object[]{" I ", "INI", " I ", 'N', Items.nether_star, 'I', Items.iron_ingot});
	}
	
	@EventHandler
	public void Postinit(FMLPostInitializationEvent event){
		
	}
}
