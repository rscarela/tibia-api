package org.rscarela.tibia.api.worlds;

import java.util.List;

/**
 * @author Renan Scarela
 */
public class WorldProperties {

	private final boolean locked;
	private final boolean blocked;
	private final boolean lessStrict;
	private final boolean premium;
	private final boolean preview;

	public WorldProperties(boolean locked, boolean blocked, boolean lessStrict, boolean premium, boolean preview) {
		this.locked = locked;
		this.blocked = blocked;
		this.lessStrict = lessStrict;
		this.premium = premium;
		this.preview = preview;
	}

	public WorldProperties(List<String> attributes) {
		this.locked = attributes.contains("locked");
		this.blocked = attributes.contains("blocked");
		this.lessStrict = attributes.contains("less strict character transfer conditions");
		this.premium = attributes.contains("premium");
		this.preview = attributes.contains("preview game world");
	}

	public boolean isLocked() {
		return locked;
	}

	public boolean isBlocked() {
		return blocked;
	}

	public boolean isLessStrict() {
		return lessStrict;
	}

	public boolean isPremium() {
		return premium;
	}

	public boolean isPreview() {
		return preview;
	}

}
