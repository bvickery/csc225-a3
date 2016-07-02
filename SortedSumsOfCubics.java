import java.util.ArrayList;

public class SortedSumsOfCubics{
	
	public static void SortedSumsOfCubics(int n){
		Heap heap = new Heap();


		heap.insert(1,4);
		int temp = heap.top();
		//System.out.println(temp);
		heap.insert(2,0);
		temp = heap.top();
		//System.out.println(temp);
		heap.insert(3,0);
		temp = heap.top();
		//	System.out.println(temp);
		heap.insert(66,0);
		temp = heap.top();
		//	System.out.println(temp);
		heap.insert(87,0);
		temp = heap.top();
		//	System.out.println(temp);
		heap.insert(55,0);
		temp = heap.top();
		//	System.out.println(temp);
		heap.insert(5,4);
		temp = heap.top();
		//	System.out.println(temp);
		heap.insert(0,0);
		temp = heap.top();
		//System.out.println(temp);

		while(!(heap.isEmpty())){
			temp = heap.top();
			System.out.println(temp);
			heap.delete();
		}
	}
	
	public static void main(String[] args){
		//we will have to check for a file first and if none is given then go to command line input
		int n = 15;
		SortedSumsOfCubics(n);
	}
}

class Heap{ 
   
    private ArrayList<Element> heap = new ArrayList<Element>();
    private class Element{
		int a;
		int b;
		
        Element(int a, int b){
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
		//adding first element to an empty heap
		if(heap.isEmpty()){
			heap.add(e);
			return;
		}
        heap.add(e);
		int i = heap.size()-1;
		int parent_index = (i-1)/2;
		Element temp_child = heap.get(i);
		Element temp_parent = heap.get(parent_index);
		int child_key = get_value(temp_child);
		int parent_key = get_value(temp_parent);
		while(i > 0 && parent_key > child_key){
			swap(parent_index, i);
			i = parent_index;
			parent_index = (i-1)/2;
			temp_child = heap.get(i);
			temp_parent = heap.get(parent_index);
			child_key = get_value(temp_child);
			parent_key = get_value(temp_parent);
		}
    } 
	
	public void delete(){
		if(heap.isEmpty()){
			return;
		}
		int size = heap.size()-1;
        heap.set(0, heap.get(size));
        heap.remove(size);
		if(heap.isEmpty()){
			return;
		}
        int i = 0;
		Element temp_parent = heap.get(i);
		int parent_value = get_value(temp_parent);
		int min_child = get_min_child(i);
		Element temp_child = heap.get(min_child);
		int child_value = get_value(temp_child);
		while(2*i+1 < size && child_value < parent_value){
			swap(i,min_child);
			i = min_child;
			min_child = get_min_child(i);
			temp_child = heap.get(min_child);
			child_value = get_value(temp_child);
		}
	}

    public int top(){
        if(heap.isEmpty()){
			return Integer.MAX_VALUE;
		}
		Element temp = heap.get(0);
		int ret = get_value(temp);
		return ret;
    }
	
	//returns the index of which child is the smaller child, returns the same index if there are no children
	private int get_min_child(int i){
		Element temp_parent = heap.get(i);
		if(2*i+2 < heap.size()-1){
			Element left_child = heap.get(2*i+1);
			Element right_child = heap.get(2*i+2);
			if(get_value(left_child) < get_value(right_child)){
				return 2*i+1;
			}else{
				return 2*i+2;
			}
		}else if(2*i+1 < heap.size()-1){
			return 2*i+1;
		}else{
			return i;
		}
	}
	//takes an element e and gives back the sum of each of its two values cubed
	private int get_value(Element e){
		int a = e.a;
		int b = e.b;
		int cubed = a*a*a + b*b*b;
		return cubed;
	}
	
	//swap function takes parent index as first argument and childs index as second
	private void swap(int parent, int child){
		Element temp_child = heap.get(child);	
		Element swap = heap.get(parent);
		heap.set(parent,temp_child);
		heap.set(child,swap);
	}
}