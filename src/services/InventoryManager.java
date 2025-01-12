package services;

import items.LibraryItem;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

public class InventoryManager<T extends LibraryItem> {

	private final Collection<T> inventory;
	private final Collection<T> currentInventory;
	private final Collection<T> outOfInventory;

	public InventoryManager(){
        this.inventory=new HashSet<>();
		this.currentInventory=new HashSet<>();
		this.outOfInventory = new HashSet<>();
	}

	// Adds item to current inventory if it existed before, otherwise, it is added as a new item
	public void addItem(T item){
		if(outOfInventory.contains(item)){
			this.currentInventory.add(item);
			this.outOfInventory.remove(item);
		}else{
			this.inventory.add(item);
			this.currentInventory.add(item);
		}
	}

	// Add items to current inventory if those existed before, otherwise, those are added as new items
	public void addItems(Collection<? extends T> items){
		if(outOfInventory.containsAll(items)){
			this.currentInventory.addAll(items);
			this.outOfInventory.removeAll(items);
		}else{
			this.inventory.addAll(items);
			this.currentInventory.addAll(items);
		}
		
	}

	// Removes an item from current inventory by title of item
	public T removeItem(String title){
		Iterator<T> iterator=currentInventory.iterator();
		T removedItem=null;

		while(iterator.hasNext()){
			T item=iterator.next();
			if(item.compareTo(title)==0) {
				removedItem=item;
				break;
			}
		}

		if (removedItem!=null) {
			currentInventory.remove(removedItem);
			outOfInventory.add(removedItem);
		}
		return removedItem;
	}

	// Removes an item from current inventory by item
	public T removeItem(T removeItem){
		return removeItem(removeItem.getTitle());
	}

	public void printInventory(){
		printInventory(inventory);
	}

	public void printCurrentInventory(){
		System.out.println(currentInventory);
	}

	public void printInventory(Collection<? extends T> items){
		System.out.println(items);
	}

	public T checkOutOfInventory(String title){
		for(T t : outOfInventory){
			if(t.compareTo(title)==0){
				outOfInventory.remove(t);
				return t;
			}
		}
		return null;
	}

	public LibraryItem findByTitle(String title){
		return findByTitle(inventory,title);
	}

	public LibraryItem findByTitle(Collection<? extends LibraryItem> items,String title){
		for(LibraryItem t : items){
			if(t.compareTo(title)==0){
				return t;
			}
		}
		return null;
	}

	public void transferItems(Collection<? extends T> source, Collection<? super T> destination){
		destination.addAll(source);
		source.clear();
	}

}