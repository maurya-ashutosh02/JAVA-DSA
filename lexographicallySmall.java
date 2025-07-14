class Solution {
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
       int n= nums.lenght;;
       int temp[]=new int [n];
       for(int i=0;i<ni++){
        temp[i]=nums[i];
       }
       Arrays.sort(temp);
       ArrayList<Queue<Integer>> list=new ArrayList<>();
       HashMap<Integer,Integer>group=new HashMap<>();
       int groupIndex=0;
       list.add(new LinkedList<>());
       list.get(groupIndex).offer(temp[0]);
       group.put(temp[0],groupIndex);
       for(int i=1;i<n;i++){
          if(temp[i]-list.get(groupIndex).peek()>limit){
            groupIndex++;
            list.add(new LinkedList<>());
           }
          group.put(temp[i],groupIndex);
          list.get(groupIndex).offer(temp[i]);
       }

       for(int i=0;i<n;i++){
        int gi=group.get(nums[i]);
        nums[i]=list.get(gi).poll();
       }

            
    

    return nums;
  }
}