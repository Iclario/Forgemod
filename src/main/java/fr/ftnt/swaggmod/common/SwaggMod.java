package fr.ftnt.swaggmod.common;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import fr.ftnt.swaggmod.common.blocks.BlockSwaggiumCompressed;
import fr.ftnt.swaggmod.common.blocks.BlockSwaggiumDoor;
import fr.ftnt.swaggmod.common.blocks.BlockSwaggiumFence;
import fr.ftnt.swaggmod.common.blocks.BlockSwaggiumOre;
import fr.ftnt.swaggmod.common.blocks.BlockTutoMetadata;
import fr.ftnt.swaggmod.common.items.ItemSwaggiumArmor;
import fr.ftnt.swaggmod.common.items.ItemSwaggiumAxe;
import fr.ftnt.swaggmod.common.items.ItemSwaggiumDoor;
import fr.ftnt.swaggmod.common.items.ItemSwaggiumHoe;
import fr.ftnt.swaggmod.common.items.ItemSwaggiumPickaxe;
import fr.ftnt.swaggmod.common.items.ItemSwaggiumShovel;
import fr.ftnt.swaggmod.common.items.ItemSwaggiumSword;
import fr.ftnt.swaggmod.common.items.itemBlocks.ItemBlockSwaggiumMetadata;
import fr.ftnt.swaggmod.proxy.CommonProxy;
import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.util.EnumHelper;

@Mod(modid = SwaggMod.MODID, name = SwaggMod.NAME, version = SwaggMod.VERSION)
public class SwaggMod
{

    public static final String MODID = "swaggmod";
    public static final String NAME = "Swagg Mod";
    public static final String VERSION = "1.0.0";

    @Instance(MODID)
    public static SwaggMod instance;

    @SidedProxy(clientSide = "fr.ftnt.swaggmod.proxy.ClientProxy", serverSide = "fr.ftnt.swaggmod.proxy.CommonProxy")
    public static CommonProxy proxy;

    // Items declaration
    public static Item itemSwaggiumIngot; // Ingot
    public static Item itemSwaggiumHelmet, itemSwaggiumChestplate, itemSwaggiumLeggings, itemSwaggiumBoots; // Armor
    public static Item itemSwaggiumDoor /* , itemArmorHorseSwaggium */; // Miscellaneous
    public static Item ItemSwaggiumAxe, ItemSwaggiumSword, ItemSwaggiumPickaxe, ItemSwaggiumShovel, ItemSwaggiumHoe; // Tools

    // Blocks declaration
    public static Block blockSwaggiumOre, blockSwaggiumCompressed, BlockSwaggiumDoor, blockSwaggiumFence; // Basic Blocks
    public static Block blockTutoMetadata; // Tuto Blocks

    // Materials Declaration
    public static ArmorMaterial armorSwaggium = EnumHelper.addArmorMaterial("armorSwaggium", 15, new int[] {2, 6, 5, 2}, 30);
    public static ToolMaterial toolSwaggium = EnumHelper.addToolMaterial("toolSwaggium", 2, 854, 10.0F, 4.0F, 30);

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        // -- Items --
        // Basic Items
        itemSwaggiumIngot = new itemSwaggiumIngot();
        // Armor
        itemSwaggiumHelmet = new ItemSwaggiumArmor(0);
        itemSwaggiumChestplate = new ItemSwaggiumArmor(1);
        itemSwaggiumLeggings = new ItemSwaggiumArmor(2);
        itemSwaggiumBoots = new ItemSwaggiumArmor(3);
        // Tools
        ItemSwaggiumAxe = new ItemSwaggiumAxe();
        ItemSwaggiumSword = new ItemSwaggiumSword();
        ItemSwaggiumPickaxe = new ItemSwaggiumPickaxe();
        ItemSwaggiumShovel = new ItemSwaggiumShovel();
        ItemSwaggiumHoe = new ItemSwaggiumHoe();
        // Miscellaneous
        itemSwaggiumDoor = new ItemSwaggiumDoor();
     // itemArmorHorseSwaggium = new Item().setUnlocalizedName("HorseArmorSwaggium").setMaxStackSize(1).setCreativeTab(CreativeTabs.tabMisc).setTextureName(MODID + ":swaggium_horse_armor");

        // Registering
        GameRegistry.registerItem(itemSwaggiumIngot, "item_swaggium_ingot");
        GameRegistry.registerItem(itemSwaggiumHelmet, "item_swaggium_helmet");
        GameRegistry.registerItem(itemSwaggiumChestplate, "item_swaggium_chestplate");
        GameRegistry.registerItem(itemSwaggiumLeggings, "item_swaggium_leggings");
        GameRegistry.registerItem(itemSwaggiumBoots, "item_swaggium_boots");
        GameRegistry.registerItem(ItemSwaggiumAxe, "item_swaggium_axe");
        GameRegistry.registerItem(ItemSwaggiumSword, "item_swaggium_sword");
        GameRegistry.registerItem(ItemSwaggiumPickaxe, "item_swaggium_pickaxe");
        GameRegistry.registerItem(ItemSwaggiumShovel, "item_swaggium_shovel");
        GameRegistry.registerItem(ItemSwaggiumHoe, "item_swaggium_hoe");
        GameRegistry.registerItem(itemSwaggiumDoor, "item_door_swaggium");
     // GameRegistry.registerItem(itemArmorHorseSwaggium, "item_swaggium_horse_armor");

        // -- Blocks --
        // Basic blocks
        blockSwaggiumOre = new BlockSwaggiumOre();
        blockSwaggiumCompressed = new BlockSwaggiumCompressed(MapColor.lapisColor);
        BlockSwaggiumDoor = new BlockSwaggiumDoor(Material.iron);
        blockSwaggiumFence = new BlockSwaggiumFence();
        // Tuto Blocks
        blockTutoMetadata = new BlockTutoMetadata();
        // Registering
        GameRegistry.registerBlock(blockSwaggiumOre, "block_swaggium");
        GameRegistry.registerBlock(blockSwaggiumCompressed, "block_antiswagger");
        GameRegistry.registerBlock(BlockSwaggiumDoor, "block_swaggium_door");
        GameRegistry.registerBlock(blockSwaggiumFence, "block_swaggium_fence");
        GameRegistry.registerBlock(blockTutoMetadata, ItemBlockSwaggiumMetadata.class, "block_tuto_metadata");
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        addEntity(EntitySwagged.class, "swagged", 420, 0xd4192b, 0x522dbc);

        MinecraftForge.EVENT_BUS.register(new LivingEventHandler());
        proxy.registerRender();
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {

        proxy.registerRender();

    }

    public void addEntity(Class<? extends Entity> entityClass, String name, int id, int backgroungEggColor, int foregroundEggColor)
    {

        EntityRegistry.registerGlobalEntityID(entityClass, name, EntityRegistry.findGlobalUniqueEntityId(), backgroungEggColor, foregroundEggColor);
        EntityRegistry.registerModEntity(entityClass, name, id, this, 40, 1, true);
    }
}
