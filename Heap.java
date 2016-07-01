import java.util.ArrayList;
import java.util.Vector; //don't use vector it is obsolete

public class Heap {    
    private ArrayList<Element> heap = new ArrayList<Element>();
    private class Element{
        int key;
        Element(int key){
            this.key = key;
        }
        Element(){}
    }
    public boolean isEmpty(){
		return heap.isEmpty();
        //return true if heap is empty
    }
    public void insert(int val){
        Element e = new Element(val);
        heap.add(e);
		int size = heap.size();
		Element temp_child = null;
		Element temp_parent = null;
		int i = heap.size()-1;
		temp_child = heap.get(i);
		int child_key = 0;
		int parent_key = 0;
		Element swap = null;
		do{
			temp_parent = heap.get((i-1)/2);
			child_key = temp_child.key;
			parent_key = temp_parent.key;
			if(child_key > parent_key){
				swap = temp_parent;
				heap.set(((i-1)/2),temp_child);
				heap.set(i,swap);
			}
			temp_child = temp_parent;
			i = (i-1)/2;
		}while(temp_child != heap.get(0));
        //send the last element up as much as you can
    }   
    public void delete(){
        heap.set(0, heap.get(heap.size()-1));
        heap.remove(heap.size()-1);
        int i = 0;
		Element temp_child = null;
		Element temp_parent = null;
		while(2*i+1 < heap.size()){
			
		}
        //send the element at root down as much as you can
    }
    public int top(){
        if(heap.isEmpty()){
			return Integer.MAX_VALUE;
		}
		Element temp = heap.get(0); //if empty return Integer.MAX_VALUE
		return temp.key;
    }
}
