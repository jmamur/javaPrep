class Solution {
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> map = new HashMap<>();
        int width = s.length();
        for(int i=0;i<width;i++)
        {
            char chs = s.charAt(i);
            char cht = t.charAt(i);
            if(map.get(chs) != null)
            {
                if(map.get(chs) != cht)
                    return false;
            }
            else
            {
                map.put(chs, cht);
            }
        }
        return map.values().size()== new HashSet<>(map.values()).size();
    }
}

