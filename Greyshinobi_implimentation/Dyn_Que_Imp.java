
public class Dyn_Que_Imp {
  
    private int capacity = 2;
    int qArray[];
    int front= 0;
    int rear = -1;
    int f=front;
    int r=rear;
    int currentSize = 0;
     
    public Dyn_Que_Imp() {
        qArray = new int[this.capacity];
    }
 
    public boolean QueueFull(){
        boolean status = false;
        if (currentSize == qArray.length){
            status = true;
        }
        return status;
    }
    
    public boolean isQueueEmpty(){
        boolean status = false;
        if (currentSize == 0)status = true;
        return status;
    }
    public void qItems(int n){
       System.out.print("Queue List:");
       for(n=0;n<=qArray.length;n++){
            System.out.print(qArray[n]+" ");
            
         
       }
    }
    
    
  public void qdequeue() {
        if (isQueueEmpty()) {
            System.out.println("* Queue is empty! can not remove a value");
        } else {
            f++;
            if(f > qArray.length-1){
                System.out.println("* Removed From The Queue: "+qArray[f-1]+"           *");
                f = 0;
            } else {
                System.out.println("* Removed From The Queue: "+qArray[f-1]+"           *");
            }
            currentSize--;
        }
    }
 
    private void increaseCapacity(){
         
        
        int newCapacity = this.qArray.length*2;
        int[] newArr = new int[newCapacity];
        int tmpFront = f;
        int index = -1;
        while(true){
            newArr[++index] = this.qArray[tmpFront];
            tmpFront++;
            if(tmpFront == this.qArray.length){
                tmpFront = 0;
            }
            if(currentSize == index+1){
                break;
            }
        }
        
        this.qArray = newArr;
        System.out.println("* New array capacity: "+this.qArray.length+"                *");
        this.f = 0;
        this.r = index;
    }
       public void enqueue(int value) {
         
        if (QueueFull()) {
            System.out.println("* Queue is full, increase capacity...  *");
            increaseCapacity();
        }
        r++;
        if(r >= qArray.length && currentSize != qArray.length){
            r = 0;
        }
        qArray[r] = value;
        currentSize++;
        System.out.println("* Added To Queue: " + value+"                   *");
    }
    public static void main(String args[]){
         
        Dyn_Que_Imp  q = new Dyn_Que_Imp() ;
        System.out.println("****Dynamic_Queue_Implimentation********");
        q.enqueue(11);
        q.qdequeue();
        q.enqueue(12);
        q.enqueue(13);
        q.enqueue(23);
        q.qdequeue();
        q.enqueue(24);
        q.enqueue(28);
        q.qdequeue();
        q.qdequeue();
        q.qdequeue();
        q.enqueue(50);
        q.qdequeue();
        q.qdequeue();
        System.out.println("****************************************");
              
       
       
    }
}
