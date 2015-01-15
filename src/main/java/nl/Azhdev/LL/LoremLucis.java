package nl.Azhdev.LL;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import nl.Azhdev.LL.blocks.AzhdevBlocks;
import nl.Azhdev.LL.handlers.generationHandler;
import nl.Azhdev.LL.items.LLItems;
import nl.Azhdev.LL.proxies.commonProxy;
import net.minecraftforge.fml.common.IWorldGenerator;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import nl.Azhdev.LL.reference.Reference;


@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.MOD_VERSION, dependencies = Reference.DEPENDENCIES)
public class LoremLucis {

	@Instance(Reference.MOD_ID)
	public static LoremLucis instance;
	
	@SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.SERVER_PROXY_CLASS)
	public static commonProxy proxy;
	
	IWorldGenerator gen = new generationHandler();
	
	@EventHandler
	public void Preinit(FMLPreInitializationEvent event){
		AzhdevBlocks.initBlocks();
		AzhdevBlocks.intTileEntities();
		LLItems.init();
		proxy.initRendering();
		GameRegistry.registerWorldGenerator(gen, 1);
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event){
		GameRegistry.addRecipe(new ItemStack(LLItems.upgrade), new Object[]{" I ", "INI", " I ", 'N', Items.nether_star, 'I', Items.iron_ingot});
	}
	
	@EventHandler
	public void Postinit(FMLPostInitializationEvent event){
		
	}
}