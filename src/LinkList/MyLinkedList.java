package LinkList;
import java.util.AbstractList;

import App.WordNode;

public class MyLinkedList<E> extends AbstractList<E> {
	
	LLNode<E> head;
	LLNode<E> tail;
	int size;

	/** Create a new empty LinkedList */
	public MyLinkedList() {
		head=new LLNode<E>();
		tail=new LLNode<E>();
		head.next = tail;
		tail.prev = head;
		size=0;
	}

	/**
	 * Appends an element to the end of the list
	 * @param element The element to add
	 */
	public boolean add(E element) 
	{
		LLNode<E> nn = new LLNode<E>(element);
		nn.next = tail;
		nn.prev = tail.prev;
		tail.prev.next = nn;
		tail.prev = nn;
		size++;
		return true;
	}

	/** Get the element at position index 
	 * @throws IndexOutOfBoundsException if the index is out of bounds. */
	public E get(int index) 
	{
		if(index>=size)
			throw new IndexOutOfBoundsException("IndexOutOfBoundsException");
		
		LLNode<E> temp = head.next;
		int i=0;
		
		while(i!=index)
		{
			temp=temp.next;
			i++;
		}
		
		return temp.data;
	}
	
	
	/**Method to return the List Object at index*/
	public LLNode<E> getNodeObject(int index) 
	{
		if(index>=size)
			throw new IndexOutOfBoundsException("IndexOutOfBoundsException");
		
		LLNode<E> temp = head.next;
		int i=0;
		
		while(i!=index)
		{
			temp=temp.next;
			i++;
		}
		
		return temp;
	}
	
	public LLNode<WordNode> getNodeObject(String find) 
	{
		LLNode<WordNode> temp = (LLNode<WordNode>) head.next;
		
		while(temp!=null)
		{
			if(temp.getData().getWord().equals(find))
				return temp;
			
			temp=temp.next;
		}
		
		return null;
	}

	/**
	 * Add an element to the list at the specified index
	 * @param The index where the element should be added
	 * @param element The element to add
	 */
	public void add(int index, E element ) 
	{
		// TODO: Implement this method
	}


	/** Return the size of the list */
	public int size() 
	{
		return this.size;
	}

	/** Remove a node at the specified index and return its data element.
	 * @param index The index of the element to remove
	 * @return The data element removed
	 * @throws IndexOutOfBoundsException If index is outside the bounds of the list
	 * 
	 */
	public E remove(int index) 
	{
		// TODO: Implement this method
		return null;
	}

	/**
	 * Set an index position in the list to a new element
	 * @param index The index of the element to change
	 * @param element The new element
	 * @return The element that was replaced
	 * @throws IndexOutOfBoundsException if the index is out of bounds.
	 */
	public E set(int index, E element) 
	{
		// TODO: Implement this method
		return null;
	}   
	
	/*
	public static void main(String args[])
	{
		MyLinkedList<Integer> list = new MyLinkedList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		
		
		System.out.println(list.get(4));
		
		int size=list.size();
		
		for(int i=0;i<size;i++)
		{
			System.out.println(list.get(i));
		}
		
		System.out.println("-----------");
		LLNode<Integer> temp = list.head.next;
		
		while(temp.next!=null)
		{
			System.out.println(temp.data);
			temp=temp.next;
		}
		
	}*/

}


