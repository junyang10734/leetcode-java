// Brute Force
// faster than 35.76%
class Solution1 {
    public int[] twoSum(int[] nums, int target) {
        for(int i=0; i<nums.length-1; i++){
            for(int j=i+1; j<nums.length; j++){
                if(nums[i] + nums[j] == target){
                    return new int[] {i,j};
                }
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}

// Two-pass Hash Table
// faster than 48.20%
class Solution2 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            map.put(nums[i],i);
        }
        for(int i=0; i<nums.length; i++){
            int a = target - nums[i];
            if(map.containsKey(a) && map.get(a) != i){
                return new int[]{i, map.get(a)};
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}

// One-pass Hash Table
// faster than 99.96%
class Solution3 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();

        for(int i=0; i<nums.length; i++){
            int a = target-nums[i];
            if(map.containsKey(a)){
                return new int[] {map.get(a), i};
            }
            map.put(nums[i],i);
        }

        throw new IllegalArgumentException("No two sum solution");
    }
}