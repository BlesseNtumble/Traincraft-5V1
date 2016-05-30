package train.common.blocks.tracks;

import railcraft.api.core.ITextureLoader;
import railcraft.api.tracks.ITrackItemIconProvider;
import railcraft.api.tracks.TrackSpec;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;
import train.common.library.TrackIDs;

import java.util.HashMap;
import java.util.Map;

public class TrackTextureLoader implements ITextureLoader, ITrackItemIconProvider {
	public static final TrackTextureLoader INSTANCE = new TrackTextureLoader();
	public final Map textures = new HashMap();
	//public final Map itemIcon = new HashMap();
	@Override
	public void registerIcons(IIconRegister iconRegister) {
		for (TrackIDs track : TrackIDs.values()) {
			IIcon[] icons = SheetTextureStitched.unstitchIcons(iconRegister, track.getTextureTag(), track.getNumIcons());
			this.textures.put(track.getTrackSpec(), icons);
			//this.itemIcon.put(track.getTrackSpec(), icons[track.getNumIcons()]);
		}
	}
	@Override
	public IIcon getTrackItemIcon(TrackSpec spec) {
		return getTrackIcons(spec)[0];
	}

	public IIcon[] getTrackIcons(TrackSpec spec) {
		return (IIcon[]) this.textures.get(spec);
	}

}
