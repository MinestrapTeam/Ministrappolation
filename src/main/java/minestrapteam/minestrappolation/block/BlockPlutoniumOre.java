package minestrapteam.minestrappolation.block;

import java.util.Random;

import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.BlockPos;
import net.minecraft.world.Explosion;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockPlutoniumOre extends BlockRadiation
{
	public BlockPlutoniumOre(Material material, int range, int rate)
	{
		super(material, range, rate);
	}	
	
	@Override
	public int quantityDropped(Random random)
	{
		return 1 + random.nextInt(2);
	}
	
	@Override
	public void addPotionEffect(EntityLivingBase living)
	{
		if (living instanceof EntitySkeleton)
		{
			living.addPotionEffect(new PotionEffect(Potion.resistance.getId(), 20 * 6, 1, false, false));
			living.addPotionEffect(new PotionEffect(Potion.regeneration.getId(), 20 * 6, 0, false, false));
			
		}
		else
		{
			living.addPotionEffect(new PotionEffect(Potion.wither.getId(), 40, 0, false, false));
		}
	}
	
	@Override
	public int getExpDrop(IBlockAccess world, BlockPos pos, int fortune)
	{
		return 5 + fortune;
	}
	
	@Override
	public void onBlockDestroyedByExplosion(World world, BlockPos pos, Explosion explosion)
	{
		world.createExplosion(null, 2.0, 2.0, 2.0, 4F, true);
	}

}