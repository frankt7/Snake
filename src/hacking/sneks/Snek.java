package hacking.sneks;

/**
 * An ordered list of objects of different (or same) types.
 * The user can access the element by their integer index (position in the list).
 * Unlike {@link java.util.Set}s, duplicate elements are allowed. However, {@code null}
 * is never a valid element.
 */
public interface Snek {
	/**
	 * Adds an element to the front of this list.
	 * @param elem - the element to be added
	 */
	public <E> void add(E elem);
	
	/**
	 * Removes the first occurrence of element which is equal to the supplied argument from
	 * the list. If the an element is removed from this list, {@code true} is returned;
	 * otherwise {@code false} is returned. {@link Object#equals(Object)} must be
	 * overriden properly for this method to work.
	 * @param elem - the element to be removed
	 * @return {@code true} if an element is remove; {@code false} otherwise.
	 */
	public <E> boolean remove(E elem);
	
	
}
