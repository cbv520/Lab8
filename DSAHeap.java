import java.lang.Math;
public class DSAHeap
{
    private DSAHeapEntry[] m_heap;
    private int m_count;

    public DSAHeap()
    {
        m_heap = new DSAHeapEntry[100];
        m_count = 0;
    }

    public DSAHeap(int maxSize)
    {
        m_heap = new DSAHeapEntry[maxSize];
	    m_count = 0;
    }

    public void add(int priority, Object value)
    {
        //System.out.println("====adding=====");
	    if(m_count == m_heap.length)
        {
            throw new ArrayIndexOutOfBoundsException("heap is full");
        }
        else
        {
            m_heap[m_count] = new DSAHeapEntry(priority, value);
            trickleUp(m_count);
            m_count++;
        }
    }

    public Object remove()
    {
        Object value = null;

        m_count--;
        if(m_count < 0)
        {
            throw new ArrayIndexOutOfBoundsException("heap is empty");
        }
        else
        {
            value = m_heap[0].getValue();
            m_heap[0] = m_heap[m_count];
            m_heap[m_count] = null;
            trickleDown(0);
        }
        return value;
    }

    public void heapSort(Object[] list)
    {
        
    }

    private void trickleUp(int index)
    {
        //System.out.println("--");
        //System.out.println("index: " + index);
        int parentIdx = (index - 1)/2;
        //System.out.println("parent index: " + parentIdx);
        //System.out.println("parent priority: " + m_heap[parentIdx].getPriority());
        //System.out.println("current priority: " + m_heap[index].getPriority());
        if(index > 0 && m_heap[parentIdx].getPriority() < m_heap[index].getPriority())
        {
            //System.out.println("swapping");
            DSAHeapEntry temp = new DSAHeapEntry(m_heap[parentIdx]);
            m_heap[parentIdx] = m_heap[index];
            m_heap[index] = temp;
            //System.out.println("parent priority: " + m_heap[parentIdx].getPriority());
            //System.out.println("current priority: " + m_heap[index].getPriority());
            trickleUp(parentIdx);
        }
    }

    private void trickleDown(int index)
    {
        int lcIdx = index * 2 + 1;
        int rcIdx = lcIdx + 1;

        if(lcIdx < m_count)
        {
            int largeIdx = lcIdx;
            if(rcIdx < m_count)
            {
                if(m_heap[lcIdx].getPriority() < m_heap[rcIdx].getPriority())
                {
                    largeIdx = rcIdx;
                }
            }
            if(m_heap[largeIdx].getPriority() > m_heap[index].getPriority())
            {
                DSAHeapEntry temp = new DSAHeapEntry(m_heap[largeIdx]);
                m_heap[largeIdx] = m_heap[index];
                m_heap[index] = temp;
                trickleDown(largeIdx);
            }
        }
    }

    public void display()
    {
        int line = 1;
        String level = "";

        for(int i = 0; i < m_count; i++)
        {
            level += m_heap[i].getPriority() + " ";
            if(i == Math.pow(2,line) - 2)
            {
                if(level.length() <= 80)
                {
                    System.out.println(level);
                }
                else
                {
                    System.out.println(level.substring(0,60) + "... (level " + line + ")");
                }
                level = "";
                line++;
            }
        }
        if(level.length() <= 80)
        {
            System.out.println(level);
        }
        else
        {
            System.out.println(level.substring(0,60) + "... (level " + line + ")");
        }
    }

    private class DSAHeapEntry
    {
        private int priority;
        private Object value;

        DSAHeapEntry(int inPriority, Object inValue)
        {
            priority = inPriority;
            value = inValue;
        }

        DSAHeapEntry(DSAHeapEntry entry)
        {
            priority = entry.getPriority();
            value = entry.getValue();
        }

        public int getPriority()
        {
            return priority;
        }

        public Object getValue()
        {
            return value;
        }
    }

}
