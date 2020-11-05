package it.unibo.oop.lab.collections2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 
 * Instructions
 * 
 * This will be an implementation of
 * {@link it.unibo.oop.lab.collections2.SocialNetworkUser}:
 * 
 * 1) complete the definition of the methods by following the suggestions
 * included in the comments below.
 * 
 * @param <U>
 *            Specific user type
 */
public class SocialNetworkUserImpl<U extends User> extends UserImpl implements SocialNetworkUser<U> {

    /*
     * 
     * [FIELDS]
     * 
     * Define any necessary field
     * 
     * In order to save the people followed by a user organized in groups, adopt
     * a generic-type Map:
     * 
     * think of what type of keys and values would best suit the requirements
     */

	final private Map<String, Set<U>> group;
	//final private UserImpl me;
    /*
     * [CONSTRUCTORS]
     * 
     * 1) Complete the definition of the constructor below, for building a user
     * participating in a social network, with 4 parameters, initializing:
     * 
     * - firstName - lastName - username - age and every other necessary field
     * 
     * 2) Define a further constructor where age is defaulted to -1
     */
	
	public SocialNetworkUserImpl(String firstName, String lastName, String username, int age) {
		super(firstName, lastName, username, age);
		this.group = new HashMap<String, Set<U>>();
	}
	
	public SocialNetworkUserImpl(String firstName, String lastName, String username) {
		super(firstName, lastName, username);
		this.group = new HashMap<String, Set<U>>();
	}

    /**
     * Builds a new {@link SocialNetworkUserImpl}.
     * 
     * @param name
     *            the user firstname
     * @param surname
     *            the user lastname
     * @param userAge
     *            user's age
     * @param user
     *            alias of the user, i.e. the way a user is identified on an
     *            application
     */
	
    /*
     * [METHODS]
     * 
     * Implements the methods below
     */

    public boolean addFollowedUser(final String circle, final U user) {
    	if (this.group.get(circle) == null) {
    		this.group.put(circle, new HashSet<U>());
    	}
    	return this.group.get(circle).add(user);
    }

    @Override
    public Collection<U> getFollowedUsersInGroup(final String groupName) {
    	Set<U> returnSet = new HashSet<U>();
    	if (this.group.get(groupName) != null) {
    		for (U users: this.group.get(groupName)) {
    			returnSet.add(users);
    		}
    	}
    	return returnSet;
    }

    @Override
    public List<U> getFollowedUsers() {
    	List<U> list = new ArrayList<U>();
        for (Set<U> sets: this.group.values()) {
        	for (U users: sets) {
        		list.add(users);
        	}
        }
        return list;
    }

}
