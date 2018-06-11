package LinkList;

public class LLNode<E> 
{
	LLNode<E> prev;
	LLNode<E> next;
	E data;

	// TODO: Add any other methods you think are useful here
	// E.g. you might want to add another constructor
	public LLNode() 
	{
		this.data = null;
		this.prev = null;
		this.next = null;
	}
	

	public LLNode(E e) 
	{
		this.data = e;
		this.prev = null;
		this.next = null;
	}
	
	public E getData()
	{
		return this.data;
	}

}