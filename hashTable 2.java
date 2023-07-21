
import java.lang.Math;

public class hashTable {

    public static int bsize;
    private hashNode head;
    private hashNode current;
    public int globalDepth;
    public hashNode maxLocDep;
    public boolean isFull = false;




    public hashTable(int size) {

        bsize = size;
        globalDepth = 1;

        head = new hashNode("0",bsize);
        head.next = new hashNode("1", bsize);
        head.next.previous = head;
        current = head;
        maxLocDep = head;

    }

    public boolean search(int key) {

        String hashkey = hash(key);

        hashkey = hashkey.substring(0, globalDepth);

        current = head;

        while (true) {

            if (current.hashValue.equals(hashkey)) {
                break;
            }
            current = current.next;
        }

        return current.kbacket.search(key);
    }

    public void lookup(int key){
        String hashkey = hash(key);

        hashkey = hashkey.substring(0, globalDepth);

        current = head;

        boolean f = false;

        while (true) {

            if (current.hashValue.equals(hashkey)) {
                f =  current.kbacket.search(key);
                break;
            }
            current = current.next;
        }
        if (f == true){
            System.out.println("\n The key is present in "+current.hashValue);
        }else {
            System.out.println("\n The key not found");
        }


    }



    public boolean insert(int key) {

        if ( search(key) )
            return false;

        //curre

//        hashValue = Integer.parseInt((hash(key)));
        if (current.kbacket.insert(key)) {
            return true;
        }

        if (current.kbacket.localDepth < globalDepth){

            reorginaze();
            insert(key);
        }

        else {
            if (extandHashTable()){
                // print();
                insert(key);
            }

            else {
                System.out.println("Table is full");
            }



        }


        return false;
    }

    public boolean delete(int key) {

        if (search(key)) {
            if (current.kbacket.delete(key)) {
                // If the bucket is empty check if it is safe to shrink the hash table
                if (current.kbacket.isEmpty() && current.kbacket.localDepth>1)
                    current.kbacket.coalescing();

                if(maxLocDep.kbacket.localDepth < globalDepth);
                decreasing();

                return true;
            }
        }
        return false;
    }

    public boolean extandHashTable() {

        if(globalDepth == 8)
            return false;

        current = head;
        hashNode temp = current;

        while(current != null) {

            temp = temp.next;


            current.next = new hashNode(current.hashValue + "1",current.kbacket);
            current.next.previous = current;

            current.hashValue = current.hashValue + "0";

            current.next.next = temp;

            if(temp != null)
                temp.previous = current.next;

            current = temp;
        }

        globalDepth++;

        return true;
    }

    public boolean reorginaze() {

        backet oldB = current.kbacket;
        current = oldB.init;
        int num = (int)( Math.pow(2,globalDepth)/Math.pow(2,current.kbacket.localDepth++));

        for(int i = 0 ; i<num-1; i++){

            current = current.next;
            current.kbacket = new backet(bsize, current,oldB.localDepth+1);
        }

        int i;
        oldB.current = oldB.head;
        for( i = 0 ; i < oldB.current.keys.length; i++){

            if(oldB.current.keys[i] == null)
                break;

            if( insert(oldB.current.keys[i])){

                for(int j = i; j<oldB.current.keys.length-1; j++){
                    oldB.current.keys[j] = oldB.current.keys[j+1];
                }

                oldB.current.keys[oldB.current.keys.length-1] = null;
                i--;
            }


        }

     /* if(maxLocDep.kbacket.localDepth < oldB.localDepth){

         maxLocDep.kbacket = oldB;
      }*/

        return true;
    }

    public void decreasing(){

        hashNode temp;
        current = head;
        temp = current;

        int num = (int)( Math.pow(2,globalDepth)/Math.pow(2,maxLocDep.kbacket.localDepth));

        while(current != null){

            for(int i = 0 ; i<num ;i++)
                temp = temp.next;

            current.hashValue = current.hashValue.substring(0,globalDepth-1);
            current.next = temp;

            if(temp !=  null)
                temp.previous = current;

            current = temp;

        }
        --globalDepth;
        maxLocDep.kbacket.localDepth = globalDepth;
    }

    public void print(){

        current = head;
        int count = 0;
        while(current != null){

            for(int i = 0; i<globalDepth; i++){

                System.out.print("-");
            }

            System.out.println("\n"+current.hashValue);

            for(int i = 0; i<globalDepth; i++){

                System.out.print("-");
            }

            if(count%2 != 0 && current.previous != null && current.kbacket == current.previous.kbacket){

                System.out.println("---> saame as previos" );

            }
            else
                current.kbacket.print();

            System.out.println(" ******************* ");

            current = current.next;
            count++;
        }

        System.out.println("///////////////////////////////////////////////////////");
    }

    // Input: A positive integer key such that 0 >= key <= 255
    // Output: A string contains an 8-bit hash value of the received key
    public static String hash(int key) {

        String value = Integer.toBinaryString(key);

        for (int i = value.length(); i < 8; i++) {
            value += "0";
        }

        return value;
    }


}


class hashNode {

    public String hashValue;
    public backet kbacket;
    public hashNode next;
    public hashNode previous;

    public hashNode(String value, backet b) {

        next = null;
        previous = null;
        hashValue = value;
        kbacket = b;
    }

    public hashNode(String value, int size) {

        next = null;
        previous = null;
        hashValue = value;
        kbacket = new backet( size,this);
    }





}
