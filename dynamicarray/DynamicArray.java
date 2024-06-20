//big-omega notasyonu (Ω): 
//bir algoritmanın çalışma süresinin alt sınırını belirtir

//amortize analiz: 
//bir dizi işlemin ortalama maliyetini analiz eder

//geometrik artış:
//büyüme yapıldığında arrayin lengthinin length*2 yapılması
//amortize maliyet = O(1) 

//aritmetik artış;
//büyüme yapıldığında arrayin lengthinin length+10 yapılması
//amortize maliyet = O(n^2) 

//stringbuilder vs string concatenation:

//stringbuilder:
//sb.append("a").append("b").append("c")
//stringbuilder dynamic array kullanır
//stringbuilder daha hızlıdır

//string concatenation:
//"a" + "b" + "c"
//string concatenation her birleştirme işleminde yeni bir array oluşturur
//string concatenation daha yavaştır

public class DynamicArray{

    int size;
    int capacity = 5;
    Object[] array;

    public DynamicArray() {
        this.array = new Object[capacity];
    }

    public DynamicArray(int capacity) {
        this.capacity = capacity;
        this.array = new Object[capacity];
    }

    public void add(Object data){
        if(size >= capacity){
            grow();
        }
        array[size] = data;
        size++;
    }

    public void remove(Object data){
        int removedIndex = search(data)-1;
        if(removedIndex == -2){
            System.out.println("tekrar dene");
            return;
        }
        array[removedIndex] = null;
        for(int i = 0; i<size-1; i++){
            if(array[i] == null){
                array[i] = array[i+1];
                array[i+1] = null;
            }
        }
        shrink();
        size = size-1;
    }

    public void insert(int index, Object data){
        if(index < size){
            array[index] = data;
        }
        if(index == size){
            add(data);
        }
        if(index > size){
            System.out.println("tekrar dene");
            return;
        }
    }

    public int search(Object data){
        int index = -1;
        if(data != null){
            for(int i = 0; i<size; i++){
                if(array[i] == data){
                    index = i;
                }
            }
        }
        return index;
    }

    private void grow(){
        int newCapacity = capacity * 2;
        Object[] newArray = new Object[newCapacity];
        for(int i = 0; i<size; i++){
            newArray[i] = array[i];
        }
        capacity = newCapacity;
        array = newArray;
    }

    private void shrink(){
        int newCapacity = size-1;
        Object[] newArray = new Object[newCapacity];
        for(int i = 0; i<size-1; i++){
            newArray[i] = array[i];
        }
        capacity = newCapacity;
        array = newArray;
    }

    public boolean isEmpty(){
        boolean isEmpty;
        if(size == 0){
            isEmpty = true;
        }
        else{
            isEmpty = false;
        }
        return isEmpty;
    }

    public String toString(){
        String string = "";

        if(size == 0){
            string = "[]";
        }
        else{
            string += "[ ";

            for(int i = 0; i<size; i++){
                string += array[i] + " ";
            }

            string += "]";
        }

        return string;
    }

}