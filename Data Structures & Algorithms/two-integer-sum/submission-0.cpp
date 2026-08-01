class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        vector<int> prefix;
        vector<int> ans;
        unordered_map<int,int> m;

        int sum = 0;
        for(int i = 0; i < nums.size(); i++){
            sum += nums[i];
            prefix.push_back(sum);
            m[nums[i]] = i;
        }

        int required = 0;
        for(int i = 0; i < nums.size(); i++){
            required = target - nums[i];
            if(m.find(required) != m.end()){
                if(m[required] < i){
                    ans.push_back(m[required]);
                    ans.push_back(i);
                }else{
                    ans.push_back(i);
                    ans.push_back(m[required]);  
                }

                return ans;
            }
        }

        
    }
};
