class Solution {
public:
    bool isAnagram(string s, string t) {
        unordered_map<char,int>m1;
        unordered_map<char,int>m2;

        if(s.size() != t.size()){
            return false;
        }

        for(int i = 0; i < s.size(); i++){
            m1[s[i]]++;
        }
        for(int i = 0; i < t.size(); i++){
            m2[t[i]]++;
        }

        for(auto it : m1){
            if(m2.find(it.first) != m2.end()){
                if(m2[it.first] != it.second){
                    return false;
                }
            }else{
                return false;
            }
        }

        return true;
    }
};
