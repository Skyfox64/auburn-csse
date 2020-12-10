
import java.util.LinkedList;
import java.util.Queue;

/********************************************************
 * PROGRAM NAME - hw6 (Homework 6)
 * PROGRAMMER - John Carroll
 * SYSTEM - Coded in IntelliJ and jGrasp, using JDK 7
 * DATE - Started 10/30/2014       Completed 11/02/2014
 * DESCRIPTION -  * This program coordinates multiple concurrent tasks
 *      (Java Threads), each one representing either a reader or writer. It
        *      uses Java threads and synchronized methods to implement a monitor
                *      which coordinates the readers and writers. There can be multiple
        *      readers, but if there is a writer everything else must wait.
        ********************************************************/
        public class hw6Driver {

            public static void main(String[] args) {

                //Create a hw6 object
                final hw6<String> theQueue = new hw6<String>();

                //Alphabet [0-25]. This will be the sample input.
                final String[] theAlphabet = {"A", "B", "C", "D", "E", "F", "G", "H",
                        "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T",
                        "U", "V", "W", "X", "Y", "Z"};

                //Threads - Readers and Writers
                //Writers use the alphabet as a sample writing input.
                Thread writer1 = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        theQueue.write(1, "Hello!");}});

                Thread writer2 = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        theQueue.write(2, 0, 5, theAlphabet);
                    }});

                Thread writer3 = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        theQueue.write(3, 6, 11, theAlphabet);
                    }});

                Thread writer4 = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        theQueue.write(4, 12, 17, theAlphabet);
                    }});

                Thread writer5 = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        theQueue.write(5, 18, 25, theAlphabet);
                    }});


                //Readers have various read lengths. Read until reached or till end of queue.
                Thread reader1 = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        theQueue.read(1, 26);
                    }});

                Thread reader2 = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        theQueue.read(2, 20);

                    }});

                Thread reader3 = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        theQueue.read(3, 15);

                    }});

                Thread reader4 = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        theQueue.read(4, 6);

                    }});

        Thread reader5 = new Thread(new Runnable() {
            @Override
            public void run() {
                theQueue.read(5, 1);

            }});


        //************************************************************************************
        //Run-time calls are below

        System.out.println("Objective: Show that there can be multiple readers, however; \n" +
                "           if there is a writer everything else must wait to resume.\n");
        System.out.println("_______________________________\n");
        System.out.println("       Homework 6 Output         ");
        System.out.println("_______________________________\n");

        //These threads do not begin sequentially, but in parallel -- near simultaneously.
        //The JVM scheduler decides what threads start first.
        writer1.start();      //Write

        reader1.start(); //Read

        writer2.start();      //Write

        reader2.start(); //Read

        writer3.start();      //Write

        reader3.start(); //Read

        writer4.start();      //Write

        reader4.start(); //Read

        writer5.start();      //Write

        reader5.start(); //Read

    }
}

/**
 * Class: hw6
 * Purpose: This class implements a generic type queue.
 *          It holds all of the functions used on that queue.
 *
 * @param <T> - generic type accepted
 */
class hw6<T> {
    private int write;// read;
    private Queue<T> theQueue;

    /**
     * This is the HW6 constructor for the class.
     */
    public hw6() {
        //Initializes theQueue as a generic typed-linked list
        theQueue = new LinkedList<T>();

        //Allow only 1 writer at a time, so set at a capacity of 1
        write = 1;
    }

    /**
     * Method: Read
     * Purpose: Used to read a specified number of times.
     *
     * @param readerNumberIn - the identification number for this specific reader
     * @param numReadsIn - the number of times to read from the queue
     */
    public synchronized void read(int readerNumberIn, int numReadsIn) {
        //Try to read from the queue
        try {
            //Waits for access due to writer exclusive access
            while (write == 0) {
                wait(); //Waits until this task can continue
            }

            //No need to acquire exclusive access like in "write"
            //Also, no need to use a reader access variable to prevent writers from interrupting
            // due to Queue-cloning immediately prior to reading.

            //checks to see if queue has anything in it
            if (!theQueue.isEmpty()) {

                //Let it be known what the task wants to do
                System.out.println("Reader[" + readerNumberIn + "] wants to read [" + numReadsIn + "] time(s).");

                //Get initial Q size and clone original Q prior to reading
                Queue tempQueue = new LinkedList<T>(theQueue);

                //Begin Reading
                int initialQSize = tempQueue.size(); //Get initial queue size
                int i = 0; //Initial loop counter
                while (i < numReadsIn && i <= initialQSize && !tempQueue.isEmpty()) {

                    //Let it be known what has been read from the queue
                    System.out.println("   >Reader[" + readerNumberIn + "]: " + tempQueue.remove());
                    i++; //Increment after loop
                }
            }

            //Release not needed like in "write"

            notifyAll();//Notify all threads
        }
        //Catch InterruptedException and handle with a print
        catch (InterruptedException iex) {System.out.println("Read Interrupted");}
    }

    /**
     * Method: Write
     * Purpose: Used to do a single write.
     *
     * @param writerNumberIn - the identification number for this specific writer
     * @param writeIn - this is what is written in
     */
    public synchronized void write(int writerNumberIn, T writeIn) {
        //Try to write to the queue
        try {
            //Waits for access due to writer exclusive access
            while (write == 0) {
                wait(); //Waits until this task can continue
            }
            write--;//Acquire

            //Let it be known what the task wants to do
            System.out.println("Writer[" + writerNumberIn + "] wants to write [1] time(s).");

            //Let it be known what has been written to the queue
            System.out.println("   >Writer[" + writerNumberIn + "]: " + writeIn);
            theQueue.add(writeIn);//Write to the queue

            write++;//Release

            notifyAll();//Notify all threads
        }
        // Catch InterruptedException and handle with a print
        catch (InterruptedException e) {System.out.println("Write Interrupted");}
    }

    /**
     * Method: Write
     * Purpose: Used to do multiple writes. (ex: From [spot 1] To [spot 8])
     *
     * @param writerNumberIn - the identification number for this specific writer
     * @param indexFrom - the lower bound index of the inputArray to start writing from
     * @param indexTo - the upper bound index of the inputArray to stop writing at
     * @param inputArray - this is the same input used to write into the queue
     */
    public synchronized void write( int writerNumberIn, int indexFrom, int indexTo, T[] inputArray) {
        // Try to write to the queue
        try {
            //Waits for access due to writer exclusive access
            while (write == 0) {
                wait(); //Waits until this task can continue
            }

            write--;//Acquire

            //Let it be known what the task wants to do
            int numWrites = (indexTo - indexFrom) + 1;
            System.out.println("Writer[" + writerNumberIn + "] wants to write [" + numWrites + "] time(s).");

            //Begin writing
            int currentIndex = indexFrom;
            while(currentIndex <= indexTo){

                //Let it be known what has been written to the queue
                T writeToQ = inputArray[currentIndex];
                System.out.println("   >Writer[" + writerNumberIn + "]: " + writeToQ);
                theQueue.add(writeToQ); //Write to the queue

                currentIndex++; //inc to go to next iteration/index
            }

            write++;//Release

            notifyAll();//Notify all threads
        }
        //Catch InterruptedException and handle with a print
        catch (InterruptedException e) {System.out.println("Write Interrupted");}
    }
}