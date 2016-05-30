/**
 * A track that detects all instance of Freight
 * 
 * @author Spitfire4466
 */
package train.common.blocks.tracks;

import railcraft.api.tracks.ITrackEmitter;
import net.minecraft.entity.item.EntityMinecart;
import train.common.api.Freight;
import train.common.library.TrackIDs;

public class BlockDetectorFreightTrack extends BlockDetectorTrack implements ITrackEmitter {

	@Override
	public TrackIDs getTrackType() {
		return TrackIDs.DETECTOR_FREIGHT;
	}

	@Override
	public void onMinecartPass(EntityMinecart cart) {
		if (cart instanceof Freight) {
			setTrackPowering();
		}
	}

}
