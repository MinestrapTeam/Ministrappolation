package minestrapteam.minestrappolation.block;

import java.util.List;
import java.util.Random;

import minestrapteam.minestrappolation.Config;
import minestrapteam.minestrappolation.util.Chance;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumWorldBlockLayer;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockFan extends MBlock
{
	int	effectRate;
	
	public BlockFan(int rate, Material material, MapColor mapColor)
	{
		super(material, mapColor);
		this.effectRate = rate;
		//this.setTickRandomly(true);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public EnumWorldBlockLayer getBlockLayer()
	{
		return EnumWorldBlockLayer.CUTOUT;
	}
	/*
	@Override
	public void onBlockAdded(World world, BlockPos pos, IBlockState state)
	{
		this.updateTick(world, pos, state, world.rand);
	}
	
	@Override
	public void updateTick(World world, BlockPos pos, IBlockState state, Random rand)
	{
		if (!world.isRemote)
		{
			world.scheduleUpdate(pos, this, this.effectRate);
			AxisAlignedBB axisalignedbb = this.getCollisionBoundingBox(world, pos, state).expand(0, 10, 0).offset(0, 4, 0);
			List<Entity> list = world.getEntitiesWithinAABB(Entity.class, axisalignedbb);
			
			for (Entity living : list)
			{
				living.motionY += (1 / (2*(living.posY - pos.getY())));
			}
		}
	}
	*/
}
