package com.terramod;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class TerraMod implements ModInitializer {
    public static final String MOD_ID = "terramod";

    // --- BLOCOS DE MINÉRIO (ENCONTRADOS NA TERRA) ---
    public static final Block ALUMINIO_ORE = registrarBloco("aluminio_ore", new Block(FabricBlockSettings.copyOf(Blocks.IRON_ORE)));
    public static final Block ESTANHO_ORE  = registrarBloco("estanho_ore",  new Block(FabricBlockSettings.copyOf(Blocks.IRON_ORE)));
    public static final Block ZINCO_ORE    = registrarBloco("zinco_ore",    new Block(FabricBlockSettings.copyOf(Blocks.IRON_ORE)));
    public static final Block CHUMBO_ORE   = registrarBloco("chumbo_ore",   new Block(FabricBlockSettings.copyOf(Blocks.IRON_ORE).strength(3.5f)));
    public static final Block SILICIO_ORE  = registrarBloco("silicio_ore",  new Block(FabricBlockSettings.copyOf(Blocks.COAL_ORE)));
    public static final Block ENXOFRE_ORE  = registrarBloco("enxofre_ore",  new Block(FabricBlockSettings.copyOf(Blocks.COAL_ORE)));

    // --- BLOCOS COMPACTOS (REFINADOS) ---
    public static final Block ALUMINIO_BLOCK = registrarBloco("aluminio_block", new Block(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK)));
    public static final Block ESTANHO_BLOCK  = registrarBloco("estanho_block",  new Block(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK)));
    public static final Block ZINCO_BLOCK    = registrarBloco("zinco_block",    new Block(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK)));
    public static final Block CHUMBO_BLOCK   = registrarBloco("chumbo_block",   new Block(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK)));
    public static final Block SILICIO_BLOCK  = registrarBloco("silicio_block",  new Block(FabricBlockSettings.copyOf(Blocks.QUARTZ_BLOCK)));
    public static final Block ENXOFRE_BLOCK  = registrarBloco("enxofre_block",  new Block(FabricBlockSettings.copyOf(Blocks.SANDSTONE)));

    // --- ITENS BRUTOS (CAEM AO QUEBRAR O MINÉRIO) ---
    public static final Item RAW_ALUMINIO = registrarItem("raw_aluminio", new Item(new FabricItemSettings()));
    public static final Item RAW_ESTANHO  = registrarItem("raw_estanho",  new Item(new FabricItemSettings()));
    public static final Item RAW_ZINCO    = registrarItem("raw_zinco",    new Item(new FabricItemSettings()));
    public static final Item RAW_CHUMBO   = registrarItem("raw_chumbo",   new Item(new FabricItemSettings()));
    public static final Item RAW_SILICIO  = registrarItem("raw_silicio",  new Item(new FabricItemSettings()));
    public static final Item RAW_ENXOFRE  = registrarItem("raw_enxofre",  new Item(new FabricItemSettings()));

    // --- ITENS REFINADOS (BARRAS E PÓS) ---
    public static final Item ALUMINIO_INGOT = registrarItem("aluminio_ingot", new Item(new FabricItemSettings()));
    public static final Item ESTANHO_INGOT  = registrarItem("estanho_ingot",  new Item(new FabricItemSettings()));
    public static final Item ZINCO_INGOT    = registrarItem("zinco_ingot",    new Item(new FabricItemSettings()));
    public static final Item CHUMBO_INGOT   = registrarItem("chumbo_ingot",   new Item(new FabricItemSettings()));
    public static final Item SILICIO_DUST   = registrarItem("silicio_dust",   new Item(new FabricItemSettings()));
    public static final Item ENXOFRE_DUST   = registrarItem("enxofre_dust",   new Item(new FabricItemSettings()));

    // Aba Criativa Exclusiva do Mod
    public static final ItemGroup TERRA_GROUP = Registry.register(Registries.ITEM_GROUP,
        new Identifier(MOD_ID, "terra_group"),
        FabricItemGroup.builder()
            .displayName(Text.literal("TerraMod: Minérios"))
            .icon(() -> new ItemStack(ALUMINIO_INGOT))
            .entries((displayContext, entries) -> {
                entries.add(ALUMINIO_ORE); entries.add(RAW_ALUMINIO); entries.add(ALUMINIO_INGOT); entries.add(ALUMINIO_BLOCK);
                entries.add(ESTANHO_ORE);  entries.add(RAW_ESTANHO);  entries.add(ESTANHO_INGOT);  entries.add(ESTANHO_BLOCK);
                entries.add(ZINCO_ORE);    entries.add(RAW_ZINCO);    entries.add(ZINCO_INGOT);    entries.add(ZINCO_BLOCK);
                entries.add(CHUMBO_ORE);   entries.add(RAW_CHUMBO);   entries.add(CHUMBO_INGOT);   entries.add(CHUMBO_BLOCK);
                entries.add(SILICIO_ORE);  entries.add(RAW_SILICIO);  entries.add(SILICIO_DUST);   entries.add(SILICIO_BLOCK);
                entries.add(ENXOFRE_ORE);  entries.add(RAW_ENXOFRE);  entries.add(ENXOFRE_DUST);   entries.add(ENXOFRE_BLOCK);
            }).build());

    private static Block registrarBloco(String nome, Block bloco) {
        Registry.register(Registries.ITEM, new Identifier(MOD_ID, nome), new BlockItem(bloco, new FabricItemSettings()));
        return Registry.register(Registries.BLOCK, new Identifier(MOD_ID, nome), bloco);
    }

    private static Item registrarItem(String nome, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(MOD_ID, nome), item);
    }

    @Override
    public void onInitialize() {
        // Inicialização concluída
    }
                                                              }
