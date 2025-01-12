package manage;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

public class InventoryManager<T extends Comparable<T>>{

	private final Collection<T> inventory;
	private final Collection<T> currentInventory;

	public InventoryManager(){
		this.inventory=new LinkedList<>();
		this.currentInventory=new LinkedList<>();
	}

	// Adds item to current inventory if it existed before, otherwise, it is added as a new item
	public void addItem(T item){
		if(inventory.contains(item)){
			this.currentInventory.add(item);
		}else{
			this.inventory.add(item);
			this.currentInventory.add(item);
		}
	}

	// Add items to current inventory if those existed before, otherwise, those are added as new items
	public void addItems(Collection<? extends T> items){
		if(inventory.containsAll(items)){
			this.currentInventory.addAll(items);
		}else{
			this.inventory.addAll(items);
			this.currentInventory.addAll(items);
		}
		
	}

	// Removes an item from current inventory
	public T removeItems(T removeItem){
		
		Iterator<T> iterator=currentInventory.iterator();
		T removedItem=null;

		while(iterator.hasNext()){
			T item=iterator.next();
			if(item.compareTo(removeItem)==0) {
				removedItem=item;
				break;
			}
		}

		if (removedItem!=null) currentInventory.remove(removedItem);

		return removedItem;
	}

	public void printInventory(){
		System.out.println(inventory);
	}

	public void printCurrentInventory(){
		System.out.println(currentInventory);
	}

	// No need to use this method --> Point number 03
	public void printInventory(Collection<? extends T> items){
		System.out.println(items);
	}

}