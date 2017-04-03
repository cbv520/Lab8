public class DSAHeap
{
    private DSAHeapEntry[] m_heap;
    private int m_count;

    public DSAHeap(int maxSize)
    {
        m_heap = new DSAHeapEntry[maxSize];
	m_count = 0;
    }

    public void add(int priority, Object value)
    {
        int parentIdx = (m_count - 1)/2;
	
    }

    public Object remove()
    {

    }

    public void heapSort(Object[] list)
    {

    }

    private void trickleUp(int index)
    {

    }

    private void trickleDown(int index)
    {

    }
}
