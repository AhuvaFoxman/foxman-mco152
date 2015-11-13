package foxman.ups;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * REQUIREMENT: You may not use an ArrayList (or any "List") in this class.
 */
public class UPSDatabase {
	private HashMap<Package, Location> ups = new HashMap<Package, Location>();
	private HashMap<Location, HashSet<Package>> pkgs = new HashMap<Location, HashSet<Package>>();

	/**
	 * Add a package to the specified Location
	 */
	public void addPackageToLocation(Location location, Package pkg) {
		HashSet<Package> packages = new HashSet<Package>();
		if (pkgs.containsKey(location)) {
			packages = pkgs.get(location);
			packages.add(pkg);
			pkgs.put(location, packages);
		} else {
			packages.add(pkg);
			pkgs.put(location, packages);
		}
		if (ups.containsKey(location)) {
			ups.replace(pkg, location);
		} else {
			ups.put(pkg, location);
		}

	}

	/**
	 * Update a Package's Location.
	 */
	public void updatePackageLocation(Package pkg, Location location) {

		HashSet<Package> packages = new HashSet<Package>();

		if (ups.containsKey(pkg)) {

			ups.replace(pkg, location);
		} else {
			ups.put(pkg, location);
		}
		if (pkgs.containsKey(location)) {
			packages = pkgs.get(location);
			packages.add(pkg);
			pkgs.replace(location, packages);
		} else {
			packages.add(pkg);
			pkgs.put(location, packages);
		}
	}

	/**
	 * @return a Set of Packages at the specified Location or an empty Set if
	 *         the Location doesn't exist or there are no Packages at that
	 *         Location.
	 */
	public Set<Package> getPackages(Location location) {
		HashSet<Package> packages = new HashSet<Package>();
		if (pkgs.containsKey(location)) {
			packages = pkgs.get(location);
		}
		return packages;
	}

	/**
	 * @return the Location of a Package or null if the Package doesn't exist.
	 */
	public Location getLocation(Package pkg) {

		return ups.get(pkg);

	}

}
