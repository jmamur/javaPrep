public int firstUniqChar(String s) {
        int[] count = new int[26];
        for( char c : s.toCharArray() ) count[c-'a']++;
        
        for(int i = 0; i < s.length(); i++ ){
            if( count[s.charAt(i)-'a'] == 1 ) return i;
        }
        return -1;
    }

    public int firstUniqChar(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for(char c: s.toCharArray())
        {
            if(map.containsKey(c))
            {
                int value = map.get(c);
                map.put(c, ++value);
            }
            else
            {
                map.put(c, 1);
            }
        }
        for(int i=0;i<s.length();i++)
        {
            char c = s.charAt(i);
            if(map.get(c) == 1)
                return i;
        }
        return -1;
    }