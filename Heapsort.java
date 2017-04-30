public DSAHeapEntry[] heapsort(DSAHeapEntry[] array)
{
    m_heap = array;
    heapify();

    for(int i = m_heap.length - 1; i > 0; i--)
    {
        DSAHeapEntry temp = m_heap[0];
        m_heap[0] = m_heap[i];
        m_heap[i] = temp;
        trickDown(0, i); //need to overload trickDown()
    }
    
    return m_array;
}

private void heapify()
{
    for(int i = (m_heap.length/2)-1; i >= 0; i--)
    {
        trickleDown(i);
    }
}
