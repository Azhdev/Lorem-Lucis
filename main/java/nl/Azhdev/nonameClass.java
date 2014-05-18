package nl.Azhdev;

import nl.Azhdev.blocks.AzhdevBlocks;
import nl.Azhdev.handlers.generationHandler;
import nl.Azhdev.proxies.commonProxy;
import cpw.mods.fml.common.IWorldGenerator;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;


@Mod(modid = "2636", name = "noname", version = "1.7.2-0.1")
public class nonameClass {
	
	@Instance("2636")
	public static nonameClass instance;
	
	@SidedProxy(clientSide = "nl.Azhdev.proxies.ClientProxy", serverSide = "nl.Azhdev.proxies.commonProxy")
	public static commonProxy proxy;
	
	IWorldGenerator gen = new generationHandler();
	
	@EventHandler
	public void Preinit(FMLPreInitializationEvent event){
		AzhdevBlocks.initBlocks();
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
