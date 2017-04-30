public class delete
{
    public static void main(String[] args) {
       for(int n = 0; n < 20; n++)
       {
           int[] cache = new int[n];
           for(int i = 0; i < n; i++)
           {
               cache[i] = -1;
           }

           System.out.println(goodrec(n,cache));
       }
    }

    public static int goodrec(int n, int[] cache)
    {
        int val;
        if(n==0)
        {
            val =1;
        }
        else if(n==1)
        {
            val =2;
        }
        else{
            if(cache[n-1]==-1)
            {
                cache[n-1]=goodrec(n-1,cache);
            }
            if(cache[n-2]==-1)
            {
                cache[n-2]=goodrec(n-2,cache);
            }
            val = cache[n-1]+cache[n-2];
        }
        return val;
    }
}
