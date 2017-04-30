import java.util.*;

public class TestHarness
{
    public static void main(String[] args)
    {
        int max = 50;
        DSAHeap heap = new DSAHeap(max);

        Random r = new Random();

        for(int i = 0; i < max; i++)
        {
            int n = r.nextInt(100);
            heap.add(n, Integer.toString(n));
        }

        System.out.println("Attempting to add to a full heap");
        try
        {
            heap.add(101, "error entry");
            System.out.println("failed");
        }
        catch(Exception e)
        {
            System.out.println("passed");
        }

        heap.display();
    }
}
