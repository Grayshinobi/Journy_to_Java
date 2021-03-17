
public class DynamicStackImpl {
    
    private int maxSize;
    
    private int[] stackArray;
    
    private int top;

    
     public DynamicStackImpl(int size) {
         maxSize = size;
         stackArray = new int[maxSize];
         top = -1;
    }

        public void push(int value) {
        if (!isFull()) { 
            top++;
            stackArray[top] = value;
        } else {
            resize(maxSize * 2);
            push(value);
        }
    }

     public int pop() {
         if (!isEmpty()) { 
              return stackArray[top--];
         }

        if (top < maxSize / 4) {
             resize(maxSize / 2);
             return pop();
        } else {
             System.out.println("The stack is already empty");
             return -1;
        }
    }

    public int peek() {
        if (!isEmpty()) { 
             return stackArray[top]; 
        } else {
            System.out.println("The stack is empty, cant peek");
            return -1;
        }
    }

    private void resize(int newSize) {
         int[] transferArray = new int[newSize];

         for (int i = 0; i < stackArray.length; i++) {
             transferArray[i] = stackArray[i];
             stackArray = transferArray;
         }
         maxSize = newSize;
    }

    
     public boolean isEmpty() {return (top == -1);}

    
     public boolean isFull() {return (top + 1 == maxSize);}

   
     public void makeEmpty(){top = -1;}
         
     
     public static void main(String args[]) {
         DynamicStackImpl s = new DynamicStackImpl(2); 
         // Populate the stack
         s.push(8);
         s.push(2);
         s.push(12);
         s.push(10);
         
         System.out.println("*****Dynamic Stack Implementation****");
         System.out.println("* Pushed Elements:-8,2,12.10        *");
         System.out.println("* Is The stack Empty:-"+s.isEmpty()+"         *"); 
         System.out.println("* Is The stac Full:-"+s.isFull()+"            *"); 
         System.out.println("* Peeked value:-"+s.peek()+"                  *"); 
         System.out.println("* Poped Value:-"+s.pop()+"                   *");  
         System.out.println("* Peeked Value:-"+s.peek()+"                  *"); 
         System.out.println("*************************************");
    }
}
