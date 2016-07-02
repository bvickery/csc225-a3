import java.util.ArrayList;

public class Heap{ 
   
    private ArrayList<Element> heap = new ArrayList<Element>();
    private class Element{
        int value;
		int a;
		int b;
		
        Element(int a, int b){
            this.value = a^3 + b^3;
			this.a = a;
			this.b = b;
        }
        Element(){}
    }
	
    public boolean isEmpty(){
		return heap.isEmpty();
    }
	
    public void insert(int a, int b){
        Element e = new Element(a,b);
        heap.add(e);
		int size = heap.size();
		Element temp_child = null;
		Element temp_parent = null;
		Element swap = null;
		int i = heap.size()-1;
		temp_child = heap.get(i);
		int child_key = 0;
		int parent_key = 0;
		do{
			temp_parent = heap.get((i-1)/2);
			child_key = temp_child.value;
			parent_key = temp_parent.value;
			if(child_key > parent_key){
				swap = temp_parent;
				heap.set(((i-1)/2),temp_child);
				heap.set(i,swap);
			}
			temp_child = temp_parent;
			i = (i-1)/2;
		}while(temp_child != heap.get(0));
    } 
	
    public void delete(){
		if(heap.isEmpty()){
			return;
		}
		int size = heap.size()-1;
        heap.set(0, heap.get(size));
        heap.remove(size);
        int i = 0;
		Element left_child = null;
		Element right_child = null;
		Element temp_parent = heap.get(i);
		Element swap = null;
		int left_value = 0;
		int right_value = 0;
		do{
			if(2*i+2 <= size){
				left_child =  heap.get(2*i+1);
				left_value = left_child.value;
				right_child = heap.get(2*i+2);
				right_value = right_child.value;
				if(left_value <= temp_parent.value){
					//swap left child with parent
					swap = left_child;
					heap.set(2*i+1, temp_parent);
					heap.set(i,swap);
				}else{
					//swap right child with parent
					swap = right_child;
					heap.set(2*i+2, temp_parent);
					heap.set(i,swap);
				}
			}else if(2*i+1 <= size){
				left_child =  heap.get(2*i+1);
				left_value = left_child.value;
				if(left_value <= temp_parent.value){
					//swap left child with parent
					swap = left_child;
					heap.set(2*i+1, temp_parent);
					heap.set(i,swap);
				}
			}else{
				break;
			}
		}while(2*i+1 <= size);
    }
	
    public int top(){
        if(heap.isEmpty()){
			return Integer.MAX_VALUE;
		}
		Element temp = heap.get(0);
		return temp.value;
    }
}