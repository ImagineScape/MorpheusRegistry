package tk.imaginescape.morpheusregistry;

import net.minecraft.world.World;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.quetzi.morpheus.api.INewDayHandler;

public class GenericDimensionHandler implements INewDayHandler {

	private final int dimID;

	public GenericDimensionHandler(int dimID) {
		this.dimID = dimID;
	}

	@Override
	public void startNewDay() {

		World world = FMLCommonHandler.instance().getMinecraftServerInstance().worldServerForDimension(dimID);
		world.setWorldTime(world.getWorldTime() + getTimeToSunrise(world));
	}

	private long getTimeToSunrise(World world) {
		long dayLength = 24000;
		return dayLength - (world.getWorldTime() % dayLength);
	}
}
