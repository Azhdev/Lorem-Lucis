package nl.Azhdev.LL;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.IWorldGenerator;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import nl.Azhdev.LL.init.LLBlocks;
import nl.Azhdev.LL.handlers.generationHandler;
import nl.Azhdev.LL.init.LLItems;
import nl.Azhdev.LL.proxies.CommonProxy;
import nl.Azhdev.LL.reference.Reference;


@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.MOD_VERSION, dependencies = Reference.DEPENDENCIES)
public class LoremLucis {
	
	@Instance("LL")
	public static LoremLucis instance;
	
	@SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.SERVER_PROXY_CLASS)
	public static CommonProxy proxy;

	IWorldGenerator gen = new generationHandler();
	
	@EventHandler
	public void Preinit(FMLPreInitializationEvent event){
		LLBlocks.initBlocks();
		LLBlocks.intTileEntities();
		LLItems.init();
		proxy.initRendering();
		GameRegistry.registerWorldGenerator(gen, 1);
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event){
		GameRegistry.addRecipe(new ItemStack(LLItems.Upgrade), new Object[]{" I ", "INI", " I ", 'N', Items.nether_star, 'I', Items.iron_ingot});
	}
	
	@EventHandler
	public void Postinit(FMLPostInitializationEvent event){
        proxy.registerRenders();
	}
}

//TODO
//Make BlockSpinny texture load in inventory and when hold
//Make BlockSpinny spin again :3