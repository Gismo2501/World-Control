package worldcontrolteam.worldcontrol.crossmod.industrialcraft2;

import ic2.api.reactor.IReactor;
import ic2.core.block.reactor.tileentity.TileEntityReactorChamberElectric;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import worldcontrolteam.worldcontrol.api.thermometer.IHeatSeeker;

public class IC2ReactorHeat implements IHeatSeeker {

	@Override
	public int getHeat(World world, BlockPos pos, TileEntity entity) {
		IReactor reactor = null;
		if(entity instanceof IReactor){
			reactor = (IReactor) entity;
		}
		if(reactor == null){
			reactor = ((TileEntityReactorChamberElectric) entity).getReactorInstance();
		}
		return reactor.getHeat();
	}

	@Override
	public boolean canUse(World world, BlockPos pos, TileEntity tile) {
		return (tile instanceof IReactor || tile instanceof TileEntityReactorChamberElectric);
	}

	@Override
	public String getUnloalizedName() {
		return "IC2";
	}
}
