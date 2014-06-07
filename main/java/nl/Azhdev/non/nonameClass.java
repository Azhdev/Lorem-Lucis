package nl.Azhdev.non;

import nl.Azhdev.non.blocks.AzhdevBlocks;
import nl.Azhdev.non.handlers.generationHandler;
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


@Mod(modid = "LL", name = "Lorem Lucis", version = "1.7.2-2.0")
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
		proxy.initRendering();
		GameRegistry.registerWorldGenerator(gen, 1);
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event){
		
	}
	
	@EventHandler
	public void Postinit(FMLPostInitializationEvent event){
		
	}
}
