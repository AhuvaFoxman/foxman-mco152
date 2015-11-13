package foxman.ups;

import java.util.HashSet;

import org.junit.Assert;
import org.junit.Test;

public class UPSDatabaseTest {

	@Test
	/** 
	 * Add a Package to a Location. 
	 * Verify that the Package is returned with getPackages().
	 * Verify that the Location is returned with getLocation().
	 */
	public void testAddPackageToLocation() {
		Package pkg = new Package("123456789");
		Location location = new Location(100,100);
		UPSDatabase data = new UPSDatabase();
		HashSet set = new HashSet();
		set.add(pkg);
		data.addPackageToLocation(location, pkg);
		Assert.assertEquals(location, data.getLocation(pkg));
		Assert.assertEquals(set,data.getPackages(location));
		
	}
	
	@Test 
	/** 
	 * Add a Package to a Location then update the Package Location to a different Location. 
	 * Verify that the Package is returned with getPackages().
	 * Verify that the Location is returned with getLocation().
	 * Verify that the Package is NOT returned when calling getPackage() with the first Location.
	 */
	public void testUpdatePackageLocation() {
		Package pkg = new Package("123456789");
		Location location = new Location(100,100);
		Location newLocation = new Location(200,200);
		UPSDatabase data = new UPSDatabase();
		HashSet set = new HashSet();
		set.add(pkg);
		data.addPackageToLocation(location, pkg);
		data.updatePackageLocation(pkg,newLocation);
		Assert.assertEquals(newLocation, data.getLocation(pkg) );
		Assert.assertEquals(set, data.getPackages(newLocation) );
		Assert.assertNotEquals(location, data.getLocation(pkg));
		
	}
	
	@Test
	/**
	 * Verify that calling getPackages() returns an empty Set when called with
	 * a Location without Packages.
	 */
	public void testGetPackagesReturnsAnEmptySet() {
	
		Location location = new Location(100,100);
		UPSDatabase data = new UPSDatabase();
		
		
		HashSet emptySet = new HashSet();
		
		Assert.assertEquals(emptySet, data.getPackages(location));
	}
	
	@Test
	/**
	 * Verify that calling getLocation() on an unknown Package returns null.
	 */
	public void testGetLocationReturnsNull() {
		Package pkg = new Package("123456789");
		UPSDatabase data = new UPSDatabase();
		Assert.assertEquals(null, data.getLocation(pkg));
	}
	
}
