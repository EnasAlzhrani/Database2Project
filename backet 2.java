
public class backet {

    public bNode head;
    public bNode current;
    public hashNode init;
    public int localDepth;
    public int bsize;





    public backet(int size, hashNode i) {

        bsize = size;
        init = i;
        head = new bNode(bsize);
        localDepth = 1;
        current = head;

    }

    public backet(int size, hashNode i,int LD) {

        bsize = size;
        init = i;
        head = new bNode(bsize);
        localDepth = LD;
        current = head;

    }

    public boolean isEmpty() {

        if (current.keys[0] != null) {
            return false;
        }

        return true;
    }

    public boolean insert(int value) {// while current != null

        current = head;

        while (current != null){

            for (int i = 0; i < bsize; i++) {

                if (current.keys[i] == null) {

                    current.keys[i] = value;

                    return true;
                }
            }

            current = current.next;

        }

        return false;
    }


    public boolean search(int key) {

        current = head;

        while (current != null) {

            if(isEmpty())
                return false;

            for (int i = 0; i < bsize; i++) {

                if(current.keys[i] == null)
                    break;
                if ( current.keys[i] == key) {
                    return true;
                }
            }

            current = current.next;

        }

        return false;
    }


    public boolean delete(int key){

        current = head;

        while(current != null){

            for(int i = 0; i<bsize; i++)
                if(current.keys[i] == key){

                    for(int j = i; j<bsize-1; j++){
                        current.keys[j] = current.keys[j+1];
                    }

                    current.keys[bsize-1] = null;

                    return true;
                }

            current = current.next;

        }

        return false;
    }


    public Integer[] retrieve() {

        return current.keys;

    }

    public void coalescing(){

        if(init.hashValue.charAt(init.hashValue.length()-1) == '0'){

            init.kbacket = init.next.kbacket;
            init.kbacket.init = init;
        }

        else{

            init.kbacket = init.previous.kbacket;
        }

        init.kbacket.localDepth--;
    }

    public void print(){

        current = head;
        int count = 1;
        while(current != null){


            System.out.print("backet NO."+count+" ---> ");

            for(int i = 0; i<current.keys.length; i++){

                System.out.print(current.keys[i]+" - ");

            }

            System.out.println("");

            current = current.next;


        }
    }


}

class bNode {

    public bNode next;
    public Integer[] keys;

    public bNode(int size) {

        next = null;
        keys = new Integer[size];
    }

}
