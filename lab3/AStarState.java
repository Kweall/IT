package lab3;

import java.util.*;


/**
 * This class stores the basic state necessary for the A* algorithm to compute 
 * a path across a map.  This state includes a collection of "open waypoints" 
 * and another collection of "closed waypoints."  In addition, this class 
 * provides the basic operations that the A* pathfinding algorithm needs to 
 * perform its processing.
 **/
public class AStarState
{
    /** 
     * This is a reference to the map that the A* algorithm
     * is navigating.
     **/
    private Map2D map;

    /** Initialize a map of all open waypoints and their locations. **/
    private Map<Location, Waypoint> opened_waypoints = new HashMap<Location, Waypoint> ();
    
    /** Initialize a map of all closed waypoints and their locations. **/
    private Map<Location, Waypoint> closed_waypoints = new HashMap<Location, Waypoint> ();

    /**
     * Initialize a new state object for the A* pathfinding algorithm to use.
     **/
    public AStarState(Map2D map)
    {
        if (map == null)
            throw new NullPointerException("map cannot be null");

        this.map = map;
    }

    /** Returns the map that the A* pathfinder is navigating. **/
    public Map2D getMap()
    {
        return map;
    }

    /**
     * This method scans through all open waypoints, and returns the waypoint
     * with the minimum total cost.  If there are no open waypoints, this 
     * method returns <code>null</code>.
     **/
    public Waypoint getMinOpenWaypoint() {
        var minCost = Float.MAX_VALUE;
        Waypoint minWaypoint = null;

        for (var waypointEntrySet : opened_waypoints.entrySet()) {
            var cost = waypointEntrySet.getValue().getTotalCost();
            if (cost <= minCost) {
                minCost = cost;
                minWaypoint = waypointEntrySet.getValue();
            }
        }

        return minWaypoint;
    }

    /**
     * This method adds a waypoint to (or potentially updates a waypoint 
     * already in) the "open waypoints" collection.  If there is not already 
     * an open waypoint at the new waypoint's location then the new waypoint 
     * is simply added to the collection.  However, if there is already a 
     * waypoint at the new waypoint's location, the new waypoint replaces 
     * the old one <em>only if</em> the new waypoint's "previous cost" value 
     * is less than the current waypoint's "previous cost" value.
     **/
    public boolean addOpenWaypoint(Waypoint newWP)
    {
        // Finds the location of the new waypoint.
        Location location = newWP.getLocation();
        
        // Checks to see if there is already an open waypoint at the new
        // waypoint's location.
        if (opened_waypoints.containsKey(location))
        {
            // If there is already an open waypoint at the new waypoint's
            // location, checks to see if the new waypoint's "previous
            // cost" value is less than the current waypoint's "previous
            // cost" value.
            Waypoint current_waypoint = opened_waypoints.get(location);
            if (newWP.getPreviousCost() < current_waypoint.getPreviousCost())
            {
                // If the new waypoint's "previous cost" value is less than the
                // current waypoint's "previous cost" value, the new waypoint
                // replaces the old waypoint and returns true.
                opened_waypoints.put(location, newWP);
                return true;
            }
            // If the new waypoint's "previous cost" value is not less than
            // the current waypoint's "previous cost" value, return false.
            return false;
        }
        // If there is not already an open waypoint at the new waypoint's
        // location, add the new waypoint to the collection of open waypoints
        // and return true. 
        opened_waypoints.put(location, newWP);
        return true;
    }


    /** Returns the current number of open waypoints. **/
    public int numOpenWaypoints()
    {
        return opened_waypoints.size();
    }

    /**
     * This method moves the waypoint at the specified location from the
     * open list to the closed list.
     **/
    public void closeWaypoint(Location loc)
    {
        Waypoint waypoint = opened_waypoints.remove(loc);
        closed_waypoints.put(loc, waypoint);
    }

    /**
     * Returns true if the collection of closed waypoints contains a waypoint
     * for the specified location.
     **/
    public boolean isLocationClosed(Location loc)
    {
        return closed_waypoints.containsKey(loc);
    }
}